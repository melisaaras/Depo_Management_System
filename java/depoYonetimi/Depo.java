package depoYonetimi;

import urunYonetimi.Urun;

import java.util.ArrayList;
import java.util.List;

public class Depo {
    private List<UrunHareketi> urunHareketleri;

    public Depo() {
        this.urunHareketleri = new ArrayList<>();
    }
    public void urunGirisi(Urun urun, double miktar){

        try {
            UrunHareketi hareket = new UrunHareketi(urun, "Urun girisi ", miktar);
            urunHareketleri.add(hareket);
            System.out.println("Urun girisi yapildi");
        }catch (Exception e){
            System.out.println("Urun girisi yaparken hata olustu "+ e.getMessage());
        }
    }
    public void urunCikisi(Urun urun, double miktar){

        try {
            UrunHareketi hareket = new UrunHareketi(urun, "Urun cikisi : ", miktar);
            urunHareketleri.add(hareket);
            System.out.println("Urun cikisi yapildi");
        }catch (Exception e){
            System.out.println("Urun cikisi yaparken hata olustu " + e.getMessage());

        }
    }
    public List<UrunHareketi> getUrunHareketleri(){

        return urunHareketleri;
    }

    public void urunHareketleriniListele() {

        try{
            for (UrunHareketi hareket : urunHareketleri) {
                System.out.println("Urun Adi : " + hareket.getUrun().getUrunIsim() +
                        " Miktar : " + hareket.getMiktar() +
                        " Islem Tipi : " + hareket.getIslemTuru());
            }
        }catch (Exception e){
            System.out.println("Urun hareketlerini listelerken hata olustu " +e.getMessage());
        }


    }

}
