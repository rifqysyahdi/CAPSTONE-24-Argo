  <div align="center">

# 🛳️ **Selamat Datang di Panduan**

### ⚓ **ARGOPORT SYSTEM**

**SISTEM INFORMASI PENGELOLAAN DERMAGA DAN KARGO**

*Meningkatkan Efisiensi dan Integrasi Pengelolaan Dermaga serta Distribusi Kargo*

</div>

---

## 📚 **Daftar Isi**

- [📌 Deskripsi Project](#-deskripsi-project)
- [🎯 Tujuan Pengembangan](#-tujuan-pengembangan)
- [⚙️ Fitur Program](#️-fitur-program)
- [🧱 Penerapan OOP](#-penerapan-oop-object-oriented-programming)
- [📊 Flowchart](#-flowchart)
- [🗂️ ERD](#️-erd)
- [🧩 Use Case Diagram](#-use-case-diagram)
- [📁 Struktur Project](#-struktur-project)
- [💻 Cara Penggunaan Program](#-cara-penggunaan-program)
- [📅 Informasi Tambahan](#-informasi-tambahan)
- [👥 Profil Anggota](#-profil-anggota)

---
## 📌 **Deskripsi Project**

Program **ArgoPort Systems** merupakan aplikasi berbasis **Java Swing** yang dirancang untuk membantu pengelolaan kegiatan **operasional pelabuhan** secara terstruktur dan terintegrasi. Aplikasi ini memiliki dua jenis pengguna utama, yaitu admin dan operator, yang masing-masing memiliki hak akses dan fungsi berbeda.

**Admin** memiliki peran dalam mengelola data operasional pelabuhan, seperti data pengguna, kapal, dermaga, jadwal sandar, kargo, slot gudang, serta retribusi. Admin juga dapat memantau aktivitas kapal dan mengelola pencatatan biaya layanan pelabuhan.

Sementara itu, **operator** berperan dalam menjalankan kegiatan operasional, seperti mengelola data kapal, melihat jadwal sandar, mencatat data kargo, serta mengatur penyimpanan barang sesuai dengan hak akses yang diberikan.

Seluruh data pada program ini tersimpan dalam basis data relasional yang saling terhubung antarentitas, seperti pengguna, admin, operator, dermaga, kapal, jadwal_sandar, kargo, slot_gudang, dan retribusi, sehingga mendukung pengelolaan informasi operasional pelabuhan secara terintegrasi dan terstruktur.


Sistem ini dilengkapi dengan:

- Fitur pendaftaran dan pengelolaan data kapal.
- Fitur penjadwalan dan proses penambatan kapal sesuai ketersediaan dermaga.
- Fitur pencatatan dan pengelolaan data kargo serta penyimpanan barang di gudang.
- Fitur perhitungan dan pemantauan retribusi kapal.
- Fitur pemantauan laporan serta ekspor laporan ke format PDF dan Excel.
- Fitur admin dan operator dengan pembagian hak akses sesuai tugas masing-masing.

---

## 🎯 **Tujuan Pengembangan**

a. Meningkatkan efektivitas dan efisiensi pengelolaan aktivitas dermaga, mulai dari proses pendataan kapal, pengelolaan jadwal sandar, hingga kegiatan bongkar muat kargo.

b. Meningkatkan transparansi dan akurasi pengelolaan data kapal serta distribusi kargo melalui sistem informasi berbasis basis data terintegrasi.

c. Mempermudah proses pemantauan dan pengawasan aktivitas operasional dermaga guna mendukung kelancaran proses pengiriman dan penerimaan kargo melalui jalur laut.

d. Mengoptimalkan pengelolaan informasi dan administrasi dermaga agar lebih terstruktur, sistematis, dan meminimalkan kesalahan pencatatan data.

e. Mendukung peningkatan kualitas pelayanan operasional pelabuhan melalui pemanfaatan teknologi informasi yang efektif dan terintegrasi.

---

## ⚙️ FITUR UTAMA PROGRAM

ARGOPORT SYSTEM memiliki beberapa fitur utama untuk mendukung pengelolaan operasional pelabuhan, mulai dari pengelolaan data kapal, penambatan kapal, penyimpanan kargo, hingga administrasi dan pelaporan aktivitas pelabuhan.

### 🧑‍💼 Fitur Untuk Admin

**- Login**
  
  Admin dapat masuk ke dalam sistem menggunakan akun yang telah terdaftar untuk mengakses fitur pengelolaan sistem sesuai hak aksesnya.

**- Manajemen Akun Operator**
  
  Admin dapat melihat dan menghapus akun operator yang telah terdaftar dalam sistem.

**- Lihat Billing dan Pembayaran**
  
  Admin dapat melihat informasi tagihan serta riwayat pembayaran retribusi kapal yang menggunakan layanan tambat di pelabuhan.

**- Manajemen, Pemantauan, dan Ekspor Laporan**
 
  Admin dapat melihat, mengelola, dan memantau laporan aktivitas operasional pelabuhan, termasuk perkembangan dan status penanganannya. Admin juga dapat mengekspor laporan ke dalam format Excel.

**- Manajemen Data Dermaga (CRUD)**
  
  Admin dapat menambahkan, melihat, mengubah, dan menghapus data dermaga yang meliputi kode dermaga, nama dermaga, kapasitas, serta status ketersediaan dermaga.

**- Manajemen Data Slot Gudang (CRUD)**
  
  Admin dapat mengelola data slot gudang, meliputi penambahan, pengubahan, penghapusan, dan pemantauan informasi kode blok, kapasitas, serta operator yang bertanggung jawab.

**- Manajemen Tarif**
 
  Admin dapat melihat, memantau, dan menyimpan informasi tarif operasional pelabuhan, meliputi tarif tambat kapal per hari dan tarif muatan barang per ton.

### 👷 Fitur Untuk Operator

**- Login**
 
  Operator dapat masuk ke dalam sistem menggunakan akun yang telah didaftarkan oleh admin untuk mengakses fitur operasional pelabuhan sesuai hak aksesnya.

**- Pemantauan Data Kapal**
 
  Operator dapat melihat dan memantau data kapal yang terdaftar serta menghapus data kapal sesuai kebutuhan operasional pelabuhan.

**- Pendaftaran Kapal Baru**

  Operator dapat mendaftarkan kapal baru dengan mengisi informasi berupa nama kapal, jenis kapal, draf kapal (m), gross tonnage (GT), dan waktu kedatangan. Operator juga dapat melihat dan memantau data kapal yang telah didaftarkan.

**- Proses Penambatan Kapal**
 
  Operator dapat mengelola proses penambatan kapal dengan menghubungkan kapal yang berstatus antre ke dermaga yang masih tersedia. Hal ini bertujuan untuk menentukan penempatan kapal berdasarkan ketersediaan dermaga.

**- Pengelolaan Kargo dan Penyimpanan Barang**
 
  Operator dapat mengelola proses bongkar muat kargo dengan menghubungkan kapal yang sedang bersandar dengan slot gudang sebagai tempat penyimpanan barang. Operator juga dapat memasukkan data kargo berupa nama barang, berat (ton), dan volume (m³).

**- Manajemen dan Pemantauan Data Kargo**
  
  Operator dapat melihat, mengubah, dan menghapus data kargo yang telah terdaftar. Operator juga dapat memperbarui informasi kargo, seperti nama barang dan berat barang (ton), sesuai dengan kondisi terbaru.

---
## 🗂️ **Tech Stack**

### Bahasa

Java : Bahasa pemrograman yang digunakan untuk mengembangkan aplikasi ArgoPort Systems.

SQL : Bahasa yang digunakan untuk mengelola dan memanipulasi data pada database MySQL.

---
### Data

MySQL : Sistem manajemen basis data yang digunakan untuk menyimpan dan mengelola data operasional pelabuhan.

MySQL Connector/J : Library yang menghubungkan aplikasi Java dengan database MySQL melalui JDBC

---
### Framework

Java Swing : Digunakan untuk membangun antarmuka grafis (GUI) aplikasi desktop.

Apache NetBeans : IDE yang digunakan untuk membuat, mengembangkan, dan menjalankan program Java.

Laragon : Digunakan untuk menjalankan database MySQL secara lokal.

Data Modeler : Digunakan untuk merancang model dan struktur database.

Draw.io : Digunakan untuk membuat diagram sistem, seperti ERD dan Use Case Diagram.

GitHub : Digunakan untuk menyimpan dan mengelola kode program.

Canva : Digunakan untuk membuat desain presentasi proyek.

---
### Library

Program ini menerapkan **library**:



<img width="305" height="92" alt="image" src="https://github.com/user-attachments/assets/708499ac-35dc-4d74-9094-41a0afccf35e" />



1. AbsoluteLayout-RELEASE260.jar

   Digunakan untuk mengatur tata letak (layout) komponen antarmuka grafis pada aplikasi Java. Dengan Absolute Layout, posisi dan ukuran setiap komponen dapat diatur secara bebas menggunakan koordinat absolut (x, y, lebar, dan tinggi).

2. mysql-connector-j-8.4.0.jar

   Digunakan sebagai penghubung antara aplikasi Java dan database MySQL. Library ini memungkinkan program melakukan operasi seperti menyimpan, mengambil, mengubah, dan menghapus data melalui koneksi JDBC (Java Database Connectivity).

3. protobuf-java-3.25.1.jar

   Merupakan pustaka Protocol Buffers untuk Java yang digunakan untuk melakukan serialisasi dan deserialisasi data terstruktur secara efisien. Library ini menjadi dependensi pendukung yang digunakan oleh library atau layanan tertentu.


---
## 💻 **Perancangan Sistem**

### 📊 **Flowchart**

### 1. Halaman Utama
<img width="2408" height="3768" alt="image" src="https://github.com/user-attachments/assets/bcf2782a-4d9c-4413-996e-1e45419ef0d2" />

### 2. Login Sistem
<img width="6988" height="3888" alt="image" src="https://github.com/user-attachments/assets/a51fac13-e3f7-4599-ab5a-6b87c1f8cd7b" />


### 3. Dashboard Operator
<img width="14528" height="10088" alt="image" src="https://github.com/user-attachments/assets/e3cb3eeb-8c75-47ed-888c-9b2f9aa063b5" />


### 4. Menu 1 Pendaftaran Kapal Baru
<img width="11800" height="2128" alt="image" src="https://github.com/user-attachments/assets/7c5496df-23e6-47d8-80c1-1b71a994a727" />


### 5. Menu 2 Lihat Daftar Kapal
<img width="768" height="181" alt="image" src="https://github.com/user-attachments/assets/d5849749-13bf-4865-be40-22e83623db69" />


### 6. Menu 3 Penambatan Kapal (Docking)
<img width="13608" height="2184" alt="image" src="https://github.com/user-attachments/assets/9ff7f7b1-3805-40e2-b0eb-c66e4bfa5e5a" />


### 7. Menu 4 Bongkar Muat Kargo
<img width="11328" height="1568" alt="image" src="https://github.com/user-attachments/assets/ba7c58b4-1fad-42c0-851d-d0f7e9ed1f5e" />

### 8. Menu 5 Kelola Data Kargo
<img width="10488" height="2168" alt="image" src="https://github.com/user-attachments/assets/edf8be65-749d-4c97-8ae1-f174ed72fec3" />

### 9. Menu 6 Cek Profil Operator 
<img width="735" height="220" alt="image" src="https://github.com/user-attachments/assets/141b5e2d-f42b-46ba-9574-a4fed856ea01" />

### 10. Logout
<img width="765" height="192" alt="image" src="https://github.com/user-attachments/assets/7b42a8f3-de62-4610-82e8-08f634fc6ebe" />

### 11. Dashboard Admin
<img width="10488" height="2168" alt="image" src="https://github.com/user-attachments/assets/528aae2d-bd25-42ab-a9cf-dd2691e22518" />

### 12. Menu 1 Kelola Dermaga
<img width="13168" height="6176" alt="image" src="https://github.com/user-attachments/assets/d43c6a96-0299-4df5-8e3e-546d624b63ad" />

### 13. Menu 2 Kelola Slot Gudang
<img width="12368" height="6688" alt="image" src="https://github.com/user-attachments/assets/0b8d58d2-2dff-43b7-b128-fd108cf4749c" />

### 14. Menu 3 Kelola Tarif Retribusi
<img width="9128" height="2072" alt="image" src="https://github.com/user-attachments/assets/551db6e4-a304-4dc4-afac-9678b70d2595" />

### 15. Menu 4 Billing & Pembayaran 
<img width="10808" height="1768" alt="image" src="https://github.com/user-attachments/assets/d57a2709-9819-44df-a957-567e2ceafcfd" />

### 16. Menu 5 Kelola Akun Operator
<img width="16384" height="3057" alt="image" src="https://github.com/user-attachments/assets/1d206f7d-5884-46ba-80cc-7dae390525bc" />

### 17. Menu 6 Laporan
<img width="9608" height="1808" alt="image" src="https://github.com/user-attachments/assets/b0f2b63c-369b-4ed3-9f23-a1bbbe704d91" />

### 18. Menu 7 Cek Profil Admin 
<img width="768" height="220" alt="image" src="https://github.com/user-attachments/assets/b1fd12ef-23ef-4400-8427-659a47d10239" />

### 19. Logout
<img width="722" height="197" alt="image" src="https://github.com/user-attachments/assets/c4c78d8c-cab5-47e3-8da7-ba67357eb63f" />

📎 [Klik di sini untuk melihat Flowchart Lengkap](https://app.diagrams.net/?src=about#G1l_0vRv375RYu1bvGWVfsu-FzTx-2HyA5#%7B%22pageId%22%3A%22YSO67Ypj2ylAbOuhdHeY%22%7D)

---
### 🗂️ **ERD**

**Entitas utama sistem:**
- Pengguna
- Admin
- Operator
- Kapal
- Dermaga
- Kargo
- Slot Gudang
- Retribusi
- Laporan

**Relasi utama:**
- `Pengguna` ↔ `Admin` (1:1)
- `Pengguna` ↔ `Operator` (1:1)
- `Admin` ↔ `Laporan` (1:N)
- `Operator` ↔ `Slot_Gudang` (1:N)
- `Pengguna` ↔ `Retribusi` (1:N)
- `Slot_Gudang` ↔ `Kargo` (1:N)
- `Kargo` ↔ `Kapal` (N:M)
- `Kapal` ↔ `Jadwal_Sandar` (1:N)
- `Dermaga` ↔ `Jadwal_Sandar` (1:N)
- `Kapal` ↔ `Retribusi` (1:1)

📌 **ERD LOGICAL**

<img width="971" height="746" alt="image" src="https://github.com/user-attachments/assets/04de516b-e0cb-419c-b345-35e94ef1eee6" />


📌 **ERD RELATIONAL**

<img width="1190" height="827" alt="image" src="https://github.com/user-attachments/assets/27a42f96-2cda-4588-9dc9-0fc2658962c0" />

---
### 🧩 **Use Case Diagram**
>"Berikut merupakan ilustrasi hubungan antara aktor (Admin dan Operator) dengan fungsionalitas utama dalam sistem informasi manajemen operasional pelabuhan ArgoPort."

<img width="5572" height="11004" alt="image" src="https://github.com/user-attachments/assets/5cf4f856-a355-47c8-a407-ded992668b39" />

---
## 📁 **Struktur Project**

---
## 🧱 PENERAPAN OOP (Object-Oriented Programming)

Program ARGO PORT SYSTEM menerapkan** 4 pilar utama** Object-Oriented Programming (OOP) untuk membangun struktur kode yang terorganisir, mempermudah pengelolaan data, serta meningkatkan fleksibilitas dan pemeliharaan program.

1. **Encapsulation**
   
   Setiap entitas seperti Pengguna, Admin, Operator, Kapal, Dermaga, Kargo, SlotGudang, dan Retribusi menggunakan atribut private serta method getter dan setter.
   
2. **Inheritance**

   Class Admin dan Operator mewarisi atribut serta method dari class Pengguna menggunakan keyword extends.
   
3. **Abstraction**

   Menyederhanakan proses pengelolaan data melalui method tertentu tanpa menampilkan detail implementasinya.   

4. **Polymorphism**

   Method mouseEntered() dan mouseExited() pada MouseAdapter digunakan untuk mengatur perubahan tampilan tombol saat kursor masuk dan keluar.

---

## 💻 **Cara Penggunaan Program**

---

### 👤 **Admin (Pengguna Aplikasi)**

### 🏠︎ Home

#### 🔐 Login  

<p align="center">
  <img width="798" height="565" alt="Login Page" src="https://github.com/user-attachments/assets/3f6383ba-36dd-4aa0-b8f2-f989676b41da" />
</p>

Selanjutnya sebelum mengakses sistem adalah **login ke aplikasi Argoport System**.  
Pengguna wajib mengisi **Username** dan **Password** yang telah terdaftar, kemudian menekan tombol **Login**.

Pengguna juga dapat melihat password, apabila ingin melihat password yang telah diinput.

Setelah berhasil masuk, akan muncul notifikasi konfirmasi login seperti berikut:

<p align="center">
  <img width="802" height="559" alt="Screenshot 2025-11-04 221446 1" src="https://github.com/user-attachments/assets/b103e36f-1136-4941-9128-95db7b74ad79" />
</p>

Tampilan ini menunjukkan bahwa pengguna telah berhasil melakukan autentikasi dan siap menggunakan seluruh fitur di dalam sistem.



Setelah login, pengguna akan diarahkan ke dashboard aplikasi **Argoport System**, di mana mereka dapat:

Tampilan sederhana dan responsif memudahkan pengguna dalam mengakses fitur utama dengan cepat dan efisien.  

---
#### 🚢 **Pendaftaran Kapal Baru**  



Halaman Pendaftaran Kapal Baru berfungsi untuk menambahkan data kapal yang akan menggunakan layanan pelabuhan Argo. Operator dapat mengisi informasi kapal sebelum kapal masuk ke dalam proses operasional pelabuhan.

Halaman ini menyediakan beberapa kolom input, yaitu:

- Nama kapal
- Jenis kapal
- Draf kapal (m)
- Gross tonnage
- Waktu kedatangan

Setelah data diisi dan disimpan, informasi kapal akan masuk ke dalam database dan dapat dilihat kembali pada halaman data kapal.

---
#### 📊 **Lihat Daftar Kapal**  


Halaman Daftar Kapal berfungsi untuk menampilkan dan memantau data kapal yang telah terdaftar dalam sistem ArgoPort Systems. Melalui halaman ini, operator dapat melihat informasi kapal serta menghapus data kapal sesuai kebutuhan operasional pelabuhan.

Setiap data kapal ditampilkan dalam tabel yang berisi:

- ID kapal
- Nama kapal
- Jenis kapal
- Draf kapal (m)
- Gross tonnage
- Status kapal
- Kedatangan
- Waktu Sandar
- Dermaga

---
### ⚓ **Penambatan Kapal**


Halaman Penambatan Kapal berfungsi untuk mengatur dan memantau proses penempatan kapal pada dermaga yang tersedia. Operator dapat memilih kapal yang berstatus antre, kemudian menghubungkannya dengan dermaga yang masih kosong agar proses penambatan sesuai dengan ketersediaan dermaga.

Pada halaman ini, operator dapat melihat informasi berupa:
- ID kapal
- Nama kapal
- Jenis kapal
- Gross tonnage
- kedatangan
- ID Dermaga
- Nama Dermaga
- Kapasitas (Ton)

Setelah proses penambatan dilakukan, data penempatan kapal akan tersimpan dalam database dan status kapal serta dermaga akan diperbarui sesuai kondisi operasional.

---
### 🔨 **Bongkar Muat Kargo**



Halaman Pengelolaan Bongkar Muat Kargo digunakan untuk mencatat data barang yang dibongkar dari kapal serta menentukan lokasi penyimpanannya di gudang. Operator dapat memilih kapal yang sedang bersandar, kemudian mengisi informasi barang dan memilih slot gudang yang tersedia.

Pada halaman ini, operator dapat mengisi beberapa informasi, yaitu:
- Nama barang
- Berat barang (ton)
- Volume barang (m³)
- Kapal yang digunakan
- Slot gudang penyimpanan

Setelah data disimpan, informasi kargo akan tersimpan dalam database dan terhubung dengan data kapal serta slot gudang yang dipilih.

---
### 🗂️ **Kelola Data Kargo**



Halaman Kelola Data Kargo digunakan oleh operator untuk melihat, memperbarui, dan menghapus data kargo yang telah terdaftar dalam sistem. Melalui halaman ini, operator dapat memantau informasi barang serta menyesuaikan data apabila terdapat perubahan.

Setiap data kargo ditampilkan dalam tabel yang berisi:
- ID kargo
- Nama barang
- Berat barang (ton)
- Volume
- Status kargo
- ID kapal
- ID slot gudang

Operator juga dapat mengubah informasi seperti nama barang dan berat barang sesuai kondisi terbaru.

---

<details>
  <summary>📊 <b>1 Dashboard Admin</b></summary>

  <p align="center">
    <img width="1322" height="768" alt="image" src="https://github.com/user-attachments/assets/84eb8e12-8e92-4cf2-9c25-701c9eb10376" />
  </p>

  Halaman **Dashboard Admin Argoport System** 

</details>

---

<details>
  <summary>👥 <b>2️ Manajemen Data Dermaga</b></summary>

  <p align="center">
    <img width="1600" height="1029" alt="image" src="https://github.com/user-attachments/assets/989bb682-b5fd-4ac7-a324-2c621e165128" />
  </p>

  Halaman Manajemen **Data Dermaga** digunakan oleh admin untuk menambahkan, melihat, mengubah, dan menghapus data dermaga yang digunakan dalam kegiatan operasional pelabuhan.

Data dermaga ditampilkan dalam tabel yang berisi:
- ID dermaga
- Nama dermaga
- Kapasitas Maksimal(TON)
- Status dermaga  
 
---

<details>
  <summary>🧾 <b>3️ Manajemen Data Slot Gudang</b></summary>

  <p align="center">
    <img width="1600" height="1029" alt="image" src="https://github.com/user-attachments/assets/25d99f7d-3b18-4299-9a82-06e0bbe1fff2" />
  </p>

  Halaman **Manajemen Data Slot Gudang** digunakan oleh admin untuk mengelola data slot penyimpanan barang di gudang. Admin dapat menambahkan, melihat, mengubah, dan menghapus data slot gudang serta menentukan operator yang bertanggung jawab.

Data yang dikelola meliputi:
- ID slot
- Kode blok
- Kapasitas
- Sisa (M3)
- ID operator penanggung jawab
- Status slot
</details>

---

<details>
  <summary>🧾 <b>4 Tarif Retribusi</b></summary>

  <p align="center">
    <img width="1600" height="1029" alt="image" src="https://github.com/user-attachments/assets/c36d1963-cba8-460b-bf67-63599869f650" />

  </p>

  Halaman **Manajemen Tarif** digunakan oleh admin untuk melihat, memantau, dan menyimpan informasi tarif yang digunakan dalam perhitungan biaya pelabuhan.

Informasi tarif yang dikelola meliputi:
- Tarif tambat kapal per hari
- Tarif muatan barang per ton
</details>


<details>
  <summary>🧾 <b>5 Billing dan Pendaftaran</b></summary>

  <p align="center">
    <img width="1322" height="768" alt="image" src="https://github.com/user-attachments/assets/b44511ff-33fe-47bc-8785-67d36162cee6" />
  </p>

  Halaman Billing dan Pembayaran digunakan oleh admin untuk melihat informasi tagihan dan riwayat pembayaran retribusi dari kapal yang menggunakan layanan tambat di pelabuhan.

Informasi yang ditampilkan meliputi:
- ID Kapal
- Nama kapal
- Status Kapal
- Total Tagihan (Rp)
- Status pembayaran
</details>


---
## 📅 **Informasi Tambahan**
🧩 **Kebutuhan Sistem & Tech Stack**

Sebelum menjalankan program **Sistem Informasi Manajemen Operasional Pelabuhan ArgoPort**, kami menggunakan beberapa perangkat dan perangkat lunak pendukung berikut:

- **🧱 Java & Apache NetBeans**  
  Menggunakan bahasa pemrograman Java yang dikembangkan di lingkungan Apache NetBeans untuk membangun aplikasi berbasis desktop yang interaktif dan terstruktur.

- **💾 MySQL & Laragon / SQL**  
  Menggunakan database MySQL (yang dikelola melalui lingkungan lokal Laragon) sebagai Sistem Manajemen Basis Data Relasional (RDBMS) untuk menyimpan dan mengelola data operasional pelabuhan secara aman.

- **🔗 JDBC (Java Database Connectivity)**  
  Pustaka penghubung yang memungkinkan aplikasi berbasis Java dapat berkomunikasi dan melakukan pertukaran data secara langsung dengan database `argoport_db`.

- **📐 Data Modeler & Draw.io**  
  Digunakan untuk perancangan struktur basis data, pemodelan entitas (*ERD*), serta pembuatan diagram alur kerja sistem ArgoPort.

- **🐙 GitHub**  
  Digunakan sebagai layanan *version control* untuk mengelola kode program, kolaborasi tim, dan dokumentasi repositori proyek.

- **🎨 Canva**  
  Digunakan untuk perancangan desain antarmuka, presentasi, serta aset visual pendukung laporan proyek.

---
## 👥 **Profil Anggota**

**Kelompok 24 ARGO**

| **Nama** | **NIM** | **Kelas** | **GitHub Username** |
|-----------|----------|------------|----------------------|
| Mohammed Rifqy Syahdi | 2509116037 | Sistem Informasi A '25 | [![GitHub](https://img.shields.io/badge/-rifqysyahdi-black?logo=github&style=flat-square)](https://github.com/rifqysyahdi) |
| Kardila Varani Barutu | 2509116009 | Sistem Informasi A '25 | [![GitHub](https://img.shields.io/badge/-kardilabarutu29-black?logo=github&style=flat-square)](https://github.com/kardilabarutu29-lang) |
| Zahra Masyita | 2509116015 | Sistem Informasi A '25 | [![GitHub](https://img.shields.io/badge/-zahramaysita-black?logo=github&style=flat-square)](https://github.com/zahramaysita) |
| Nabila Fitriani | 2509116063 | Sistem Informasi B '25 | [![GitHub](https://img.shields.io/badge/-nbilaftrnii-black?logo=github&style=flat-square)](https://github.com/nbilaftrnii) |


---

[⬆️ Kembali ke Awal](#-selamat-datang-di-panduan)
