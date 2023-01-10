package model;


public class Peserta {
    int id;
    String namaPeserta;
    String jenisKelamin;
    String alamat;
    String agama;
    String asalSekolah;
    
    public Peserta(){
    
    }

    public Peserta(int id, String namaPeserta, String jenisKelamin, String alamat, String agama, String asalSekolah) {
        this.id = id;
        this.namaPeserta = namaPeserta;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.agama = agama;
        this.asalSekolah = asalSekolah;
    }
    
    public Peserta(int id, String namaPeserta){
        this.id = id;
        this.namaPeserta = namaPeserta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }
    
    
}
