package kullaniciYonetimi;

public abstract class Kullanici {

    // Şifre İşlemlerinde Koşullar Olsun(6 karkter , En az 1 harf , En az 1 rakam)
    // Kullanıcı adı unique olmalı.
    // Liste boş ise "Kullanıcı Yok " uyarısı versin


    private String kullaniciAdi;
    private String sifre;
    private String rol;

    public Kullanici(String kullaniciAdi, String sifre, String rol) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.rol = rol;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public abstract void rolYetkileri();

}