package urunYonetimi;

public abstract class Urun {
    private int id;
    private String urunIsim;
    private String uretici;
    private double miktar;
    private String birim;
    private String kategori;
    private int raf;
    private int sira;

    // Kategori ID başlangıç değerleri
    private static int gidaIdBaslangic = 1;
    private static int manavIdBaslangic = 101;
    private static int elektronikIdBaslangic = 201;

    public Urun(int id, String urunIsim, String uretici, double miktar, String birim, String kategori) {
        this.id = atananId(kategori);
        this.urunIsim = urunIsim;
        this.uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.kategori = kategori;
    }

    public Urun() {

    }

    private int atananId(String kategori) {
        switch (kategori) {
            case "Gida":
                return gidaIdBaslangic++;
            case "Manav":
                return manavIdBaslangic++;
            case "Elektronik":
                return elektronikIdBaslangic++;
            default:
                throw new IllegalArgumentException("Geçersiz kategori: " + kategori);
        }
    }

    public abstract void rafOlustur();
    public abstract void idOlustur();

    // Getters ve setters
    public int getId() {
        return id;
    }

    public String getUrunIsim() {
        return urunIsim;
    }

    public String getUretici() {
        return uretici;
    }

    public double getMiktar() {
        return miktar;
    }

    public String getBirim() {
        return birim;
    }

    public int getRaf() {
        return raf;
    }

    public void setRaf(int raf) {
        this.raf = raf;
    }

    public int getSira() {
        return sira;
    }

    public void setSira(int sira) {
        this.sira = sira;
    }

    public void setUrunIsim(String urunIsim) {
        this.urunIsim = urunIsim;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }
}
