// Membuat superclass untuk kereta api
public class KeretaApi {
        // Mendeklarasikan atribut nama, asal, dan tujuan
        private String nama;
        private String asal;
        private String tujuan;
        private String penumpang;
    
        // Membuat construktor dengan parameter nama, asal, dan tujuan
        public KeretaApi(String nama, String penumpang, String asal, String tujuan) {
            this.nama = nama;
            this.penumpang = penumpang;
            this.asal = asal;
            this.tujuan = tujuan;
        }
    
        // Membuat metode untuk mengembalikan nama
        public String getNama() {
            return nama;
        }
        public void setNama(String nama) {
            this.nama = nama;
        }
    

        // Membuat metode untuk mengembalikan nama
        public String getPenumpang() {
            return penumpang;
        }
        public void setPenumpang(String penumpang) {
            this.penumpang = penumpang;
        }
    
    
        // Membuat metode untuk mengembalikan asal
        public String getAsal() {
            return asal;
        }
        public void setAsal(String asal) {
            this.asal = asal;
        }
    
    
        // Membuat metode untuk mengembalikan tujuan
        public String getTujuan() {
            return tujuan;
        }
        public void setTujuan(String tujuan) {
            this.tujuan = tujuan;
        }
    
        
        // deklarasi method untuk menampilkan data penumpang
        public void tampilKeretaApi() {
        System.out.println("Nama Kereta: " + nama);
        System.out.println("Nama Penumpang: " + penumpang);
        System.out.println("Asal: " + asal);
        System.out.println("Tujuan: " + tujuan);
    }
}
