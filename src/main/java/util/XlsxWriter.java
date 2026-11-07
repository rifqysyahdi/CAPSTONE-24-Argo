package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Penulis berkas Excel (.xlsx) satu sheet tanpa library tambahan (xlsx = ZIP berisi XML).
 * Mendukung teks, angka, gaya sederhana (judul, header, tebal, angka 2 desimal), dan lebar kolom.
 */
public final class XlsxWriter {
    public static final int NORMAL = 0, HEADER = 1, JUDUL = 2, ANGKA = 3, TEBAL = 4;

    /** Sel dengan gaya tertentu. */
    public static final class Sel {
        final int gaya; final Object nilai;
        Sel(int gaya, Object nilai) { this.gaya = gaya; this.nilai = nilai; }
    }

    public static Sel sel(int gaya, Object nilai) { return new Sel(gaya, nilai); }

    private final String namaSheet;
    private final double[] lebar;
    private final List<Object[]> baris = new ArrayList<>();

    public XlsxWriter(String namaSheet, double... lebarKolom) {
        this.namaSheet = namaSheet.replaceAll("[\\\\/?*\\[\\]:]", " ");
        this.lebar = lebarKolom;
    }

    /** Menambah satu baris. Tiap elemen: String, Number, null (kosong), atau Sel. */
    public void baris(Object... sel) { baris.add(sel); }

    public void simpan(File f) throws Exception {
        try (OutputStream os = new FileOutputStream(f); ZipOutputStream z = new ZipOutputStream(os, StandardCharsets.UTF_8)) {
            tulis(z, "[Content_Types].xml",
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<Types xmlns=\"http://schemas.openxmlformats.org/package/2006/content-types\">"
                + "<Default Extension=\"rels\" ContentType=\"application/vnd.openxmlformats-package.relationships+xml\"/>"
                + "<Default Extension=\"xml\" ContentType=\"application/xml\"/>"
                + "<Override PartName=\"/xl/workbook.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml\"/>"
                + "<Override PartName=\"/xl/worksheets/sheet1.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml\"/>"
                + "<Override PartName=\"/xl/styles.xml\" ContentType=\"application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml\"/>"
                + "</Types>");
            tulis(z, "_rels/.rels",
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">"
                + "<Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument\" Target=\"xl/workbook.xml\"/>"
                + "</Relationships>");
            tulis(z, "xl/workbook.xml",
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<workbook xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\">"
                + "<sheets><sheet name=\"" + esc(namaSheet) + "\" sheetId=\"1\" r:id=\"rId1\"/></sheets></workbook>");
            tulis(z, "xl/_rels/workbook.xml.rels",
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<Relationships xmlns=\"http://schemas.openxmlformats.org/package/2006/relationships\">"
                + "<Relationship Id=\"rId1\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet\" Target=\"worksheets/sheet1.xml\"/>"
                + "<Relationship Id=\"rId2\" Type=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles\" Target=\"styles.xml\"/>"
                + "</Relationships>");
            tulis(z, "xl/styles.xml",
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<styleSheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">"
                + "<numFmts count=\"1\"><numFmt numFmtId=\"164\" formatCode=\"#,##0.00\"/></numFmts>"
                + "<fonts count=\"4\">"
                + "<font><sz val=\"11\"/><name val=\"Calibri\"/></font>"
                + "<font><b/><sz val=\"11\"/><color rgb=\"FFFFFFFF\"/><name val=\"Calibri\"/></font>"
                + "<font><b/><sz val=\"16\"/><color rgb=\"FF112743\"/><name val=\"Calibri\"/></font>"
                + "<font><b/><sz val=\"11\"/><name val=\"Calibri\"/></font>"
                + "</fonts>"
                + "<fills count=\"3\"><fill><patternFill patternType=\"none\"/></fill><fill><patternFill patternType=\"gray125\"/></fill>"
                + "<fill><patternFill patternType=\"solid\"><fgColor rgb=\"FF112743\"/><bgColor indexed=\"64\"/></patternFill></fill></fills>"
                + "<borders count=\"1\"><border><left/><right/><top/><bottom/><diagonal/></border></borders>"
                + "<cellStyleXfs count=\"1\"><xf numFmtId=\"0\" fontId=\"0\" fillId=\"0\" borderId=\"0\"/></cellStyleXfs>"
                + "<cellXfs count=\"5\">"
                + "<xf numFmtId=\"0\" fontId=\"0\" fillId=\"0\" borderId=\"0\" xfId=\"0\"/>"
                + "<xf numFmtId=\"0\" fontId=\"1\" fillId=\"2\" borderId=\"0\" xfId=\"0\" applyFont=\"1\" applyFill=\"1\"/>"
                + "<xf numFmtId=\"0\" fontId=\"2\" fillId=\"0\" borderId=\"0\" xfId=\"0\" applyFont=\"1\"/>"
                + "<xf numFmtId=\"164\" fontId=\"0\" fillId=\"0\" borderId=\"0\" xfId=\"0\" applyNumberFormat=\"1\"/>"
                + "<xf numFmtId=\"0\" fontId=\"3\" fillId=\"0\" borderId=\"0\" xfId=\"0\" applyFont=\"1\"/>"
                + "</cellXfs>"
                + "<cellStyles count=\"1\"><cellStyle name=\"Normal\" xfId=\"0\" builtinId=\"0\"/></cellStyles>"
                + "</styleSheet>");

            StringBuilder sb = new StringBuilder();
            sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
              .append("<worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\">");
            if (lebar.length > 0) {
                sb.append("<cols>");
                for (int i = 0; i < lebar.length; i++)
                    sb.append("<col min=\"").append(i + 1).append("\" max=\"").append(i + 1).append("\" width=\"").append(lebar[i]).append("\" customWidth=\"1\"/>");
                sb.append("</cols>");
            }
            sb.append("<sheetData>");
            for (int r = 0; r < baris.size(); r++) {
                sb.append("<row r=\"").append(r + 1).append("\">");
                Object[] row = baris.get(r);
                for (int c = 0; c < row.length; c++) {
                    Object v = row[c]; int gaya = NORMAL;
                    if (v instanceof Sel) { gaya = ((Sel) v).gaya; v = ((Sel) v).nilai; }
                    if (v == null) continue;
                    String ref = kolom(c) + (r + 1);
                    if (v instanceof Number) {
                        sb.append("<c r=\"").append(ref).append("\" s=\"").append(gaya).append("\"><v>").append(angka((Number) v)).append("</v></c>");
                    } else {
                        sb.append("<c r=\"").append(ref).append("\" s=\"").append(gaya).append("\" t=\"inlineStr\"><is><t xml:space=\"preserve\">")
                          .append(esc(String.valueOf(v))).append("</t></is></c>");
                    }
                }
                sb.append("</row>");
            }
            sb.append("</sheetData></worksheet>");
            tulis(z, "xl/worksheets/sheet1.xml", sb.toString());
        }
    }

    private static String angka(Number n) {
        if (n instanceof Double || n instanceof Float) {
            double d = n.doubleValue();
            if (Double.isNaN(d) || Double.isInfinite(d)) return "0";
            return java.math.BigDecimal.valueOf(d).toPlainString();
        }
        return String.valueOf(n);
    }

    private static String kolom(int i) {
        StringBuilder s = new StringBuilder();
        for (i++; i > 0; i = (i - 1) / 26) s.insert(0, (char) ('A' + (i - 1) % 26));
        return s.toString();
    }

    /** Escape XML dan buang karakter kontrol yang tidak valid di XML 1.0. */
    private static String esc(String s) {
        StringBuilder b = new StringBuilder(s.length() + 8);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '&': b.append("&amp;"); break;
                case '<': b.append("&lt;"); break;
                case '>': b.append("&gt;"); break;
                case '"': b.append("&quot;"); break;
                default:
                    if (ch == '\t' || ch == '\n' || ch == '\r' || ch >= 0x20) b.append(ch);
            }
        }
        return b.toString();
    }

    private static void tulis(ZipOutputStream z, String nama, String isi) throws Exception {
        z.putNextEntry(new ZipEntry(nama));
        z.write(isi.getBytes(StandardCharsets.UTF_8));
        z.closeEntry();
    }
}
