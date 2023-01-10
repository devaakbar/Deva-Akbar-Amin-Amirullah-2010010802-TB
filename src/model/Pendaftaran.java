package model;

public class Pendaftaran {
    
    int idDaftar;
    int idSiswa;
    String namaSiswa;
    int idSekolah;
    String namaSekolah;
    String Status;
    Peserta peserta;
    Sekolah sekolah;
    
    public Pendaftaran(){
        
    }

    public Pendaftaran(int idDaftar, int idSiswa, String namaSiswa, int idSekolah, String namaSekolah, String Status) {

        this.idDaftar = idDaftar;
        this.idSiswa = idSiswa;
        this.namaSiswa = namaSiswa;
        this.idSekolah = idSekolah;
        this.namaSekolah = namaSekolah;
        this.Status = Status;
        this.peserta = new Peserta(idSiswa, namaSiswa);
        this.sekolah = new Sekolah(idSekolah, namaSekolah);
    }

    public int getIdDaftar() {
        return idDaftar;
    }

    public void setIdDaftar(int idDaftar) {
        this.idDaftar = idDaftar;
    }

    public int getIdSiswa() {
        return idSiswa;
    }

    public int getIdSekolah() {
        return idSekolah;
    }

    public void setIdSekolah(int idSekolah) {
        this.idSekolah = idSekolah;
    }
    
    

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Peserta getPeserta() {
        return peserta;
    }

    public void setPeserta(Peserta peserta) {
        this.peserta = peserta;
    }

    public Sekolah getSekolah() {
        return sekolah;
    }

    public void setSekolah(Sekolah sekolah) {
        this.sekolah = sekolah;
    }
    
    
    
}
