import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class dbtiket {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pemesanantiket";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection conn;
    private static Statement stmt;
    private static ResultSet rs;

    public static void connection() {
        try {
            // Memuat driver jdbc
            Class.forName(JDBC_DRIVER);

            // Membuat koneksi dengan database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Membuat statement untuk menjalankan query
            stmt = conn.createStatement();
        } catch (Exception e) {
            // Menampilkan pesan error jika terjadi exception
            e.printStackTrace();
        }
    }

    
    // deklarasi method untuk menambahkan data tiket ke database
    public void create(TiketKereta t) {

        // menggunakan blok try-catch untuk menangani kemungkinan exception
        try {
            dbtiket.connection();
            // membuat query insert data tiket
            String query = "INSERT INTO tiket_kereta VALUES ('" + t.getTiketId() + "', '" + t.getNama() + "', '" + t.getPenumpang() + "', '" + t.getAsal() + "', '" + t.getTujuan() + "', '" + t.getTanggal() + "', " + t.getKelas() + ", " + t.getJumlah() + ")";
            stmt = conn.createStatement();
            // menjalankan query
            stmt.executeUpdate(query);
            // menampilkan pesan sukses
            System.out.println("Data tiket berhasil ditambahkan");
            conn.close();
        } catch (Exception e) {
            // menampilkan pesan error jika terjadi exception
            System.out.println("Error: " + e.getMessage());
        }
    }
    // deklarasi method untuk membaca data tiket dari database
    public ArrayList<TiketKereta> read() {
        // membuat array list untuk menyimpan data tiket
        ArrayList<TiketKereta> listTiketKereta = new ArrayList<>();
        // menggunakan blok try-catch untuk menangani kemungkinan exception
        try {
            // membuat query select data tiket
            String query = "SELECT * FROM tiket_kereta";
            // menjalankan query dan menyimpan hasilnya di resultset
            rs = stmt.executeQuery(query);
            // menggunakan perulangan while untuk mengambil data dari resultset
            while (rs.next()) {
                // membuat objek tiket dengan data dari resultset
                TiketKereta t = new TiketKereta(rs.getString("nama_kereta"), rs.getString("nama_penumpang"), rs.getString("asal"), rs.getString("tujuan"), rs.getDate("tanggal"), rs.getInt("kelas"), rs.getInt("jumlah"), rs.getInt("id"));
                // menambahkan objek tiket ke array list
                listTiketKereta.add(t);
            }
            conn.close();
        } catch (Exception e) {
            // menampilkan pesan error jika terjadi exception
            System.out.println("Error: " + e.getMessage());
        }
        // mengembalikan array list
        return listTiketKereta;
    }

    // deklarasi method untuk mengubah data tiket di database
    public void update(TiketKereta t) {
        // menggunakan blok try-catch untuk menangani kemungkinan exception
        try {
            dbtiket.connection();
            // membuat query update data tiket
            String query = "UPDATE tiket_kereta SET nama_kereta = '" + t.getNama() + "', nama_penumpang = '" + t.getPenumpang() +"', Asal = '" + t.getAsal() + "', Tujuan = '" + t.getTujuan() + "', tanggal = '" + t.getTanggal() + "', jumlah = " + t.getJumlah() + ", kelas = " + t.getKelas() + " WHERE id = '" + t.getTiketId() + "'";
            stmt = conn.createStatement();
            // menjalankan query
            stmt.executeUpdate(query);
            // menampilkan pesan sukses
            System.out.println("Data tiket_kereta berhasil diubah");
            conn.close();
        } catch (Exception e) {
            // menampilkan pesan error jika terjadi exception
            System.out.println("Error: " + e.getMessage());
        }
    }
    // deklarasi method untuk menghapus data tiket dari database
    public void delete(String tiketId) {
        // menggunakan blok try-catch untuk menangani kemungkinan exception
        try {
            dbtiket.connection();
            // membuat query delete data tiket
            String query = "DELETE FROM tiket_kereta WHERE id = '" + tiketId + "'";
            stmt = conn.createStatement();
            // menjalankan query
            stmt.executeUpdate(query);
            // menampilkan pesan sukses
            System.out.println("Data tiketkereta berhasil dihapus");
            conn.close();
        } catch (Exception e) {
            // menampilkan pesan error jika terjadi exception
            System.out.println("Error: " + e.getMessage());
        }
    }

}