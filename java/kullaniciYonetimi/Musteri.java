package kullaniciYonetimi;

public class Musteri extends Kullanici {

    public Musteri(String kullaniciAdi, String sifre) {
        super(kullaniciAdi, sifre, "Musteri");
    }

    @Override
    public void rolYetkileri() {

    }
}
