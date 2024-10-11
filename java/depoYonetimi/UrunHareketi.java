package depoYonetimi;

import urunYonetimi.Urun;

public class UrunHareketi {

    private Urun urun;
    private double miktar;
    private String islemTuru;


    public UrunHareketi(Urun urun, String islemTuru, double miktar) {
        this.urun = urun;
        this.islemTuru = islemTuru;
        this.miktar = miktar;
    }


    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public String getIslemTuru() {
        return islemTuru;
    }

    public void setIslemTuru(String islemTuru) {
        this.islemTuru = islemTuru;
    }
}
