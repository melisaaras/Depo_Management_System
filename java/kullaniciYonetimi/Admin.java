package kullaniciYonetimi;

public class Admin extends Kullanici {


    public Admin(String kullaniciAdi, String sifre) {
        super(kullaniciAdi, sifre,"Admin");


    }

    @Override
    public void rolYetkileri() {

    }
}