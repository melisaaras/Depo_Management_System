package urunYonetimi;

public class Manav extends Urun {
    public Manav(int id, String urunIsim, String uretici, double miktar, String birim) {
        super(id, urunIsim, uretici, miktar, birim, "Manav");
    }

    @Override
    public void rafOlustur() {
        System.out.println("Manav rafı olusturulacak");
    }

    @Override
    public void idOlustur() {
        System.out.println("Manav için id olusturulacak");
    }
}
