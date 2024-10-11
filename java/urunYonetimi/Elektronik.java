package urunYonetimi;

public class Elektronik extends Urun {
    public Elektronik(int id, String urunIsim, String uretici, double miktar, String birim) {
        super(id, urunIsim, uretici, miktar, birim, "Elektronik");
    }

    @Override
    public void rafOlustur() {
        System.out.println("Elektronik rafı olusturulacak");
    }

    @Override
    public void idOlustur() {
        System.out.println("Elektronik için id olusturulacak");
    }
}
