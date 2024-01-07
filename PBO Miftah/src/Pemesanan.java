// Membuat interface untuk pemesanan tiket
interface Pemesanan {
    // Mendeklarasikan konstanta harga tiket per kelas
    final int EKONOMI = 50000;
    final int BISNIS = 100000;
    final int EKSEKUTIF = 150000;

    // Mendeklarasikan metode abstrak untuk menghitung total harga
    public int hitungHarga(int jumlah, int kelas);

    // Mendeklarasikan metode abstrak untuk mencetak detail pemesanan
    public void cetakDetail();
}
