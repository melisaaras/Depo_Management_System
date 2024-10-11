package urunYonetimi;

public class Gida extends Urun {
    public Gida(int id, String urunIsim, String uretici, double miktar, String birim) {
        super(id, urunIsim, uretici, miktar, birim, "Gida");
    }

    @Override
    public void rafOlustur() {
        System.out.println("Gıda rafı olusturulacak");
    }

    @Override
    public void idOlustur() {
        System.out.println("Gıda için id olusturulacak");
    }
}
