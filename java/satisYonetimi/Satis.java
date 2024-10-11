package satisYonetimi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Satis {

    private int satisId;//0
    private int urunId;//0
    private int miktar;//0
    private String kasiyerAdi;//null
    private String satisTarihi;//class ismi ile yazdik

    public Satis(int satisId, int urunId, int miktar, String kasiyerAdi, String satisTarihi) {
        this.satisId = satisId;
        this.urunId = urunId;
        this.miktar = miktar;
        this.kasiyerAdi = kasiyerAdi;
        this.satisTarihi = satisTarihi;
    }

    public int getSatisId() {
        return satisId;
    }

    public void setSatisId(int satisId) {
        this.satisId = satisId;
    }

    public int getUrunId() {
        return urunId;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getKasiyerAdi() {
        return kasiyerAdi;
    }

    public void setKasiyerAdi(String kasiyerAdi) {
        this.kasiyerAdi = kasiyerAdi;
    }

    public String getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(String satisTarihi) {
        this.satisTarihi = satisTarihi;
    }


}
