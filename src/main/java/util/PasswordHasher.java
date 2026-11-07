package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * PBKDF2-HMAC-SHA256 untuk password akun aplikasi. Parameter sama persis dengan yang dipakai
 * AuthController sebelumnya (120.000 iterasi, 256 bit), jadi hash lama di akun_aplikasi tetap valid.
 */
public final class PasswordHasher {
    private static final int ITERATIONS = 120000;
    private static final SecureRandom RNG = new SecureRandom();
    /** Tanpa karakter yang mudah tertukar (0/O, 1/l/I) supaya password sementara gampang diketik. */
    private static final String HURUF_BESAR = "ABCDEFGHJKLMNPQRSTUVWXYZ";
    private static final String HURUF_KECIL = "abcdefghijkmnpqrstuvwxyz";
    private static final String ANGKA = "23456789";

    private PasswordHasher() {}

    public static String saltBaru() {
        byte[] salt = new byte[16];
        RNG.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hash(String password, String salt64) throws Exception {
        byte[] salt = Base64.getDecoder().decode(salt64);
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, 256);
        try {
            byte[] out = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(out);
        } finally {
            spec.clearPassword();
        }
    }

    public static boolean verify(String password, String salt64, String expectedHash) throws Exception {
        return MessageDigest.isEqual(hash(password, salt64).getBytes(StandardCharsets.UTF_8),
                expectedHash.getBytes(StandardCharsets.UTF_8));
    }

    /** Password sementara acak (10 karakter, minimal 1 huruf besar, 1 huruf kecil, 1 angka). */
    public static String passwordSementara() {
        String semua = HURUF_BESAR + HURUF_KECIL + ANGKA;
        char[] p = new char[10];
        p[0] = HURUF_BESAR.charAt(RNG.nextInt(HURUF_BESAR.length()));
        p[1] = HURUF_KECIL.charAt(RNG.nextInt(HURUF_KECIL.length()));
        p[2] = ANGKA.charAt(RNG.nextInt(ANGKA.length()));
        for (int i = 3; i < p.length; i++) p[i] = semua.charAt(RNG.nextInt(semua.length()));
        for (int i = p.length - 1; i > 0; i--) { // acak urutan (Fisher-Yates)
            int j = RNG.nextInt(i + 1);
            char t = p[i]; p[i] = p[j]; p[j] = t;
        }
        return new String(p);
    }
}
