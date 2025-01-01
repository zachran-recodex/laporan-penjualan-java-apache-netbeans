# Aplikasi Laporan Penjualan

Aplikasi Laporan Penjualan adalah sistem berbasis web yang dikembangkan menggunakan Java dan Apache NetBeans. Aplikasi ini dirancang untuk membantu pengelolaan dan pemantauan data penjualan dengan menyediakan berbagai jenis laporan yang komprehensif.

## Fitur Utama

Aplikasi ini menyediakan beberapa fitur pelaporan penting:

- Laporan Penjualan Harian
- Laporan Penjualan Mingguan
- Laporan Penjualan Bulanan
- Analisis Barang Terlaris

## Teknologi yang Digunakan

Aplikasi ini dibangun menggunakan teknologi berikut:

- Java Development Kit (JDK) 17
- Jakarta EE 11
- Apache NetBeans IDE
- Apache Tomcat 10.1.34
- MySQL Database (via MAMP)
- Maven untuk manajemen dependensi
- Bootstrap 5 untuk antarmuka pengguna

## Persyaratan Sistem

Untuk menjalankan aplikasi ini, Anda memerlukan:

- JDK 17 atau versi lebih baru
- Apache Tomcat 10.1.x
- MAMP atau server MySQL
- Maven 3.8 atau lebih baru
- Web browser modern

## Instalasi dan Pengaturan

1. **Persiapan Database:**
   - Instalasi MAMP
   - Buat database baru dengan nama 'sales_db'
   - Import struktur database dari file SQL yang tersedia

2. **Konfigurasi Aplikasi:**
   - Clone repositori ini
   - Sesuaikan konfigurasi database di src/main/java/config/DatabaseConfig.java
   - Sesuaikan port server di konfigurasi Tomcat

3. **Menjalankan Aplikasi:**
   - Build proyek menggunakan Maven: mvn clean install
   - Deploy file WAR ke server Tomcat
   - Akses aplikasi melalui http://localhost:8080

## Struktur Proyek

Proyek ini mengikuti struktur standar aplikasi web Java:

```
src/
├── main/
│   ├── java/
│   │   ├── config/
│   │   ├── model/
│   │   ├── servlet/
│   │   └── interfaces/
│   ├── resources/
│   └── webapp/
│       ├── WEB-INF/
│       │   └── views/
│       └── index.jsp
├── test/
└── pom.xml
```

## Dokumentasi API

Aplikasi ini menggunakan pola MVC (Model-View-Controller) dengan implementasi servlet untuk menangani permintaan HTTP:

- GET /laporan/harian : Menampilkan laporan penjualan harian
- GET /laporan/mingguan : Menampilkan laporan penjualan mingguan
- GET /laporan/bulanan : Menampilkan laporan penjualan bulanan
- GET /laporan/terlaris : Menampilkan daftar barang terlaris

## Pemeliharaan

Untuk memelihara dan memperbarui aplikasi:

1. Lakukan backup database secara berkala
2. Periksa log aplikasi untuk potensial masalah
3. Perbarui dependensi secara teratur
4. Pantau kinerja server dan database

## Kontak

Untuk pertanyaan dan dukungan, silakan hubungi:
- Website: [recodex.id](https://recodex.id)
- Email: zachranraze@recodex.id
