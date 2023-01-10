package model;


public class Sekolah {
 
   int idSekolah;
   String namaSekolah;
   String alamatSekolah;
   String akreditasi;
   
   public Sekolah(){
       
   }

   public Sekolah(int idSekolah, String namaSekolah, String alamatSekolah, String akreditasi) {
        this.idSekolah = idSekolah;
        this.namaSekolah = namaSekolah;
        this.alamatSekolah = alamatSekolah;
        this.akreditasi = akreditasi;
   }
   
   public Sekolah(int id, String nama){
       this.idSekolah = id;
       this.namaSekolah = nama;
   }
   

    public int getIdSekolah() {
        return idSekolah;
    }

    public void setIdSekolah(int idSekolah) {
        this.idSekolah = idSekolah;
    }

    public String getNamaSekolah() {
        return namaSekolah;
    }

    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    public String getAlamatSekolah() {
        return alamatSekolah;
    }

    public void setAlamatSekolah(String alamatSekolah) {
        this.alamatSekolah = alamatSekolah;
    }

    public String getAkreditasi() {
        return akreditasi;
    }

    public void setAkreditasi(String akreditasi) {
        this.akreditasi = akreditasi;
    }
   
   
}
