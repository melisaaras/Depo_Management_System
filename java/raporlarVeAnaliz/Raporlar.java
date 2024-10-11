package raporlarVeAnaliz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Raporlar {
    private String tarih ;
    private String raporTipi;
    private String icerik;

    public Raporlar(String tarih, String raporTipi, String icerik) {
        this.tarih = tarih;
        this.raporTipi = raporTipi;
        this.icerik = icerik;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getRaporTipi() {
        return raporTipi;
    }

    public void setRaporTipi(String raporTipi) {
        this.raporTipi = raporTipi;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }
}
