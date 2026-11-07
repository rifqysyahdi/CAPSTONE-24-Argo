ARGOPORT - LOGIN DAN REGISTRASI AKUN APLIKASI

1. Aktifkan MySQL pada XAMPP/Laragon.
2. Pastikan database argoport_db dan seluruh tabel proyek sudah diimpor.
3. Jalankan database_migration_akun_aplikasi.sql, lalu database_migration_wilayah.sql, sekali melalui phpMyAdmin.
4. Buka project di NetBeans dan jalankan main.MainApp.
5. Registrasi mandiri sudah DIHAPUS. Semua akun dibuat lewat migrasi (lihat bagian WILAYAH di bawah).
6. Akun pusat awal: username admin, password Admin123! (tidak terikat wilayah, bisa melihat semua wilayah).

KONFIGURASI KONEKSI:
Default XAMPP: host localhost, port 3306, database argoport_db, user root, password kosong.
Jika berbeda, atur environment variable:
ARGOPORT_DB_URL, ARGOPORT_DB_USER, ARGOPORT_DB_PASSWORD.

Catatan: autentikasi akun aplikasi menggunakan PBKDF2-HMAC-SHA256 dengan salt acak.
Akun operator yang baru didaftarkan memerlukan hak akses database sesuai peran. Karena operasi aplikasi memakai satu koneksi layanan, atur kredensial database layanan yang hanya memiliki grant yang diperlukan. Untuk tugas lokal XAMPP default, root dapat digunakan saat pengembangan.


FITUR PROFIL DAN KELOLA AKUN (v9)
=================================
PROFIL
- Klik nama pengguna di pojok kanan atas (semua halaman Admin dan Operator) untuk membuka Profil.
- Isi Profil: ganti/hapus foto (JPG/PNG maks 5 MB, otomatis dipotong persegi 256x256 dan disimpan di
  kolom akun_aplikasi.foto_profil), ubah nama lengkap, lihat info akun, dan ganti password
  (wajib mengisi password saat ini). Username dan peran tidak bisa diubah dari Profil.

KELOLA AKUN OPERATOR (menu Admin)
- Tabel sekarang membaca akun_aplikasi (akun yang benar-benar dipakai login), peran Operator saja.
- Reset password: sistem membuat password sementara acak, ditampilkan sekali ke admin. Operator
  wajib menggantinya saat login berikutnya (kolom wajib_ganti_sandi).
- Nonaktifkan / Aktifkan kembali: akun nonaktif tidak bisa login, datanya tetap ada.
- Hapus permanen: tetap tersedia, dengan konfirmasi yang menyarankan Nonaktifkan.
- Akun Admin tidak bisa diubah dari menu ini.

DATABASE
- Kolom baru (foto_profil, wajib_ganti_sandi, wilayah) juga dibuat otomatis saat login pertama, tetapi data awal
  (dermaga dan akun) hanya masuk lewat database_migration_wilayah.sql.


WILAYAH (v10)
=============
5 wilayah, 24 dermaga: Bontang 5, Balikpapan 5, Samarinda 5, Berau 4, Tanah Grogot 5.
Tiap wilayah punya 1 admin + operator (1 operator per dermaga = 24 operator). Total 29 akun baru.
- Login: admin_<wilayah> (mis. admin_bontang), operator op_<wilayah>_<no> (mis. op_bontang_1).
  Password awal semua akun: 123. Tiap akun wajib ganti password saat login pertama (baru minimal 8 karakter);
  paksaan itu bisa dimatikan lewat UPDATE yang ada di komentar database_migration_wilayah.sql.
- Admin dan operator hanya melihat dan mengubah data wilayahnya: dermaga, slot gudang, kapal, kargo,
  billing, laporan, dan akun operator. Kapal yang didaftarkan operator otomatis masuk wilayah operator itu.
- Akun "admin" lama bertipe pusat (wilayah kosong): bisa melihat semua wilayah tapi tidak bisa menambah
  dermaga/slot/kapal. Nonaktifkan lewat SQL bila tidak dipakai lagi.
- Data lama (dermaga/slot/kapal sebelum wilayah) berwilayah kosong sehingga tidak tampil di akun wilayah;
  atur wilayahnya lewat UPDATE (contoh ada di akhir database_migration_wilayah.sql).
- Nama 24 dermaga di migrasi masih "Dermaga <Wilayah> <no>", ganti lewat menu Kelola Dermaga.
- Tarif retribusi per wilayah: tiap admin wilayah mengatur tarifnya sendiri; tagihan kapal memakai tarif wilayah
  kapal itu. Akun pusat hanya melihat tarif bawaan.
- Laporan diekspor ke Excel (.xlsx), berisi wilayah, periode, ringkasan, dan rincian pembayaran.
