import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;


// membuat class Main untuk menjalankan program
class Main {
    // deklarasi method main
    public static void main(String[] args) {
        // membuat objek scanner untuk menerima input dari pengguna
        Scanner sc = new Scanner(System.in);
        // membuat objek database untuk menghubungkan dengan database
        dbtiket db = new dbtiket();
        // membuat array list untuk menyimpan data tiket
        ArrayList<TiketKereta> listTiket = new ArrayList<>();
        // membuat objek formatter untuk memformat tanggal
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // membuat variabel pilihan untuk menyimpan pilihan menu
        int pilihan = 0;
        // menggunakan perulangan do-while untuk menampilkan menu
        do {
            // menampilkan menu
            System.out.println("=== Program Pemesanan Tiket Kereta Api ===");
            System.out.println("1. Pesan Tiket");
            System.out.println("2. Lihat Tiket");
            System.out.println("3. Ubah Tiket");
            System.out.println("4. Hapus Tiket");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            // menerima input pilihan dari pengguna
            pilihan = sc.nextInt();
            // menggunakan percabangan switch untuk menentukan aksi berdasarkan pilihan
            switch (pilihan) {
                case 1:
                    // membuat objek tiket baru
                    TiketKereta t = new TiketKereta(null, null, null, null, null, pilihan, pilihan, pilihan);
                    System.out.print("Masukkan Id Tiket: ");
                    t.setTiketId(sc.nextInt());
                    System.out.print("Masukkan nama Kereta: ");
                    t.setNama(sc.next());
                    System.out.print("Masukkan nama Penumpang: ");
                    t.setPenumpang(sc.next());
                    System.out.print("Masukkan stasiun asal: ");
                    t.setAsal(sc.next());
                    System.out.print("Masukkan stasiun tujuan: ");
                    t.setTujuan(sc.next());
                    System.out.print("Masukkan tanggal keberangkatan (yyyy-MM-dd): ");
                     try {
                        // mengubah input tanggal menjadi objek date
                        t.setTanggal(formatter.parse(sc.next()));
                    } catch (Exception e) {
                        // menampilkan pesan error jika terjadi exception
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.print("Masukkan jumlah tiket: ");
                    t.setJumlah(sc.nextInt());
                    System.out.print("Masukkan kelas tiket (1. Ekonomi, 2. Bisnis, 3. Eksekutif): ");
                    t.setKelas(sc.nextInt());
                    
                    // Calculate the total price based on the selected ticket class and quantity
                    double hargaTiket = t.hitungHarga(t.getJumlah(), t.getKelas());
                    t.setTotalHarga(hargaTiket);
                    System.out.println("Total Harga: Rp"  +hargaTiket);
                    

                    // menambahkan data tiket ke database
                    db.create(t);
                    // menambahkan objek tiket ke array list
                    listTiket.add(t);
                    break;
                case 2:
                    // menampilkan data tiket dari database
                    listTiket = db.read();
                    // menggunakan perulangan for-each untuk menampilkan data tiket dari array list
                    for (TiketKereta tiket : listTiket) {
                        // menampilkan data penumpang
                        tiket.tampilKeretaApi();
                        // menampilkan data pemesanan
                        tiket.cetakDetail();
                        System.out.println();
                    }
                    break;
                 case 3:
                    // menerima input kode tiket yang ingin diubah
                    System.out.print("Masukkan kode tiket yang ingin diubah: ");
                    int tiketId = sc.nextInt();
                    // mencari objek tiket yang sesuai dengan kode tiket
                    TiketKereta tiket = null;
                    for (TiketKereta t1 : listTiket) {
                        if (Integer.toString(t1.getTiketId()).equals(Integer.toString(tiketId))) {
            tiket = t1;
            break;
                        }
                    }
                    // jika objek tiket ditemukan
                    if (tiket != null) {
                        // menerima input data tiket baru dari pengguna
                        System.out.print("Masukkan nama baru: ");
                        tiket.setNama(sc.next());
                        System.out.print("Masukkan stasiun asal baru: ");
                        tiket.setAsal(sc.next());
                        System.out.print("Masukkan stasiun tujuan baru: ");
                        tiket.setTujuan(sc.next());
                        System.out.print("Masukkan tanggal keberangkatan baru (yyyy-MM-dd): ");
                        try {
                            // mengubah input tanggal menjadi objek date
                            tiket.setTanggal(formatter.parse(sc.next()));
                        } catch (Exception e) {
                            // menampilkan pesan error jika terjadi exception
                            System.out.println("Error: " + e.getMessage());
                            }
                        System.out.print("Masukkan jumlah tiket baru: ");
                        tiket.setJumlah(sc.nextInt());
                        System.out.print("Masukkan kelas tiket baru (1. Ekonomi, 2. Bisnis, 3. Eksekutif): ");
                        tiket.setKelas(sc.nextInt());
                        // mengubah data tiket di database
                        db.update(tiket);
                    } else {
                        // menampilkan pesan jika objek tiket tidak ditemukan
                        System.out.println("Kode tiket tidak valid");
                    }
                        break;
                case 4:
                   // menerima input kode tiket yang ingin dihapus
                   System.out.print("Masukkan kode tiket yang ingin dihapus: ");
                   int tiketIdToDelete = sc.nextInt();
                   String tiketIdString = Integer.toString(tiketIdToDelete);
                   // menghapus data tiket dari database
                   db.delete(tiketIdString);
                   break;
                case 5:
                   // menampilkan pesan keluar
                   System.out.println("Terima kasih telah menggunakan program ini");
                   break;
                   default:
                   // menampilkan pesan jika pilihan tidak valid
                   System.out.println("Pilihan tidak valid");
                   break;
              }
            // menampilkan pesan selamat tinggal
            System.out.println("Sampai jumpa");
            } while (pilihan != 5); // mengulangi menu selama pilihan bukan 
    }
}

                
                        
                         