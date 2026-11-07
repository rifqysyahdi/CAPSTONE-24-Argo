# ArgoPort - Database & Akun DCL

## Urutan setup
1. Impor `argoport_db_.sql` (database `argoport_db`, MySQL 8 / MariaDB).
2. Buat akun DCL sesuai SQL praktikum (`admin_argo` dan `operator_argo`, host `localhost`).
3. Jalankan `database_migration_argoport.sql` sebagai root. Aman dijalankan ulang.
4. Jalankan aplikasi (`main.MainApp`) dan login memakai akun MySQL tersebut.

## Yang ditambahkan migration (mengikuti flowchart)
| Perubahan | Alasan (flowchart) |
|---|---|
| `dermaga.kapasitas_maksimal` (ton) | Kelola Dermaga |
| `slot_gudang.kapasitas_volume_m3`, `sisa_volume_m3` | Kelola Blok Gudang, Bongkar Muat |
| `kargo.volume_m3` | Validasi kapasitas slot (m3) saat Bongkar Muat |
| Tabel `tarif_pelabuhan` | Kelola Tarif Retribusi, Billing |
| `jadwal_sandar.waktu_lepas` boleh NULL | Kapal yang masih sandar |
| `retribusi.tanggal_bayar` boleh NULL | Status Belum Lunas |
| Status dermaga `Sibuk` menjadi `Terisi` | Flowchart Penambatan Kapal |
| GRANT untuk `admin_argo` dan `operator_argo` | Pembatasan hak akses per peran |

`operator_argo` tidak punya akses ke tabel `retribusi` dan `tarif_pelabuhan`.

## Pemetaan menu
**Admin:** Kelola Dermaga, Kelola Slot Gudang, Kelola Tarif Retribusi, Billing & Pembayaran, Kelola Akun Operator, Laporan (ekspor CSV).
**Operator:** Pendaftaran Kapal Baru, Lihat Daftar Kapal, Penambatan Kapal, Bongkar Muat Kargo, Kelola Data Kargo.

## Akun aplikasi (v9)
Login memakai tabel `akun_aplikasi` (jalankan `database_migration_akun_aplikasi.sql`), bukan akun MySQL DCL.
Profil dan Reset Password Operator tersedia; registrasi mandiri dihapus. Pembagian 5 wilayah dan akun awal
ada di `database_migration_wilayah.sql`. Lihat `README-AKUN-APLIKASI.txt`.
