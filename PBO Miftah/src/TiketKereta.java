// Membuat subclass untuk tiket kereta api yang mengimplementasikan interface Pemesanan

import java.text.SimpleDateFormat;
import java.util.Date;

class TiketKereta extends KeretaApi implements Pemesanan {
    // Mendeklarasikan atribut tambahan untuk tanggal, kelas, jumlah dan id tiket
    private Date tanggal;
    private int kelas;
    private int jumlah;
    private int tiketId;
    private double totalHarga;


    // Membuat construktor dengan parameter nama, Penumpang, asal, tujuan, tanggal, kelas, dan jumlah
    public TiketKereta(String nama,String Penumpang, String asal, String tujuan, Date tanggal, int kelas, int jumlah, int tiketId) {
        // Memanggil construktor superclass
        super(nama, Penumpang, asal, tujuan);
        this.tanggal = tanggal;
        this.kelas = kelas;
        this.jumlah = jumlah;
        this.tiketId = tiketId;
    }


    // deklarasi getter dan setter untuk atribut kodeTiket, stasiunAsal, stasiunTujuan, tanggal, jumlah, kelas, dan total
    public int getTiketId() {
        return tiketId;
    }

    public void setTiketId(int tiketId) {
        this.tiketId = tiketId;
    }
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
    public int getKelas() {
        return kelas;
    }

    public void setKelas(int kelas) {
        this.kelas = kelas;
    }
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    // Mengimplementasikan metode untuk menghitung total harga
    public int hitungHarga(int jumlah, int kelas) {
        // Membuat variabel lokal untuk menyimpan harga
        int harga = 0;
        // Menggunakan percabangan switch untuk menentukan harga berdasarkan kelas
        switch (kelas) {
            case 1:
                harga = EKONOMI;
                break;
            case 2:
                harga = BISNIS;
                break;
            case 3:
                harga = EKSEKUTIF;
                break;
            default:
                System.out.println("Kelas tidak valid");
                break;
        }
        // Mengembalikan hasil perkalian harga dengan jumlah
        return harga * jumlah;
    }
    // Mengimplementasikan metode untuk mencetak detail pemesanan
    public void cetakDetail() {
        // Membuat objek SimpleDateFormat untuk memformat tanggal
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        // Mencetak detail pemesanan
        System.out.println("Detail Pemesanan Tiket Kereta Api");
        System.out.println("Id Tiket: " + tiketId);
        System.out.println("Nama Kereta: " + getNama());
        System.out.println("Nama Penumpang: " + getPenumpang());
        System.out.println("Asal: " + getAsal());
        System.out.println("Tujuan: " + getTujuan());
        System.out.println("Tanggal: " + sdf.format(tanggal));
        System.out.println("Kelas: " + kelas);
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Total Harga: Rp. " + getTotalHarga());
    }
}

