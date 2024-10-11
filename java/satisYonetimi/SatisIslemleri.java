package satisYonetimi;

import urunYonetimi.Urun;
import urunYonetimi.UrunIslemleri;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SatisIslemleri {
    private List<Satis> satislar;

    Scanner scanner = new Scanner(System.in);

    public SatisIslemleri() {
        this.satislar = new ArrayList<>();
    }

    public void yeniSatis(int urunId, int miktar, String kasiyerAdi) {
        try {
            int satisId = satislar.size() + 1;//satis idlerini tutmak icin
            LocalDateTime satisTarihi = LocalDateTime.now();//tarih ve saat eklendi
            DateTimeFormatter formatSt = DateTimeFormatter.ofPattern("HH:mm");
            String formattedTime = formatSt.format(satisTarihi);
            Satis satis = new Satis(satisId, urunId, miktar, kasiyerAdi, formattedTime);
            satislar.add(satis);
        }catch (IllegalArgumentException e){
            System.out.println("Gecersiz karakter girdiniz. Lutfen bir rakam giriniz " +e.getMessage());
            scanner.next();
        }catch (Exception e){
            System.out.println("Yeni satis olustururken hata meydana geldi " + e.getMessage());
            scanner.next();
        }
    }

    public void satisIptalMenu() {
        System.out.println("Satis Iptali Menusu");
        System.out.println("Iptal edilecek satis ID si giriniz");
        try {
            int satisId = scanner.nextInt();
            scanner.nextLine();
            satisIptal(satisId);
        }catch (IllegalArgumentException e){
            System.out.println("Gecersiz karakter girdiniz. Lutfen bir rakam giriniz "+e.getMessage());
        }catch (Exception e){
            System.out.println("Satis iptal edilirken hata olustu "+ e.getMessage());
            scanner.next();
        }

    }
    public void satisIptal(int satisId) {
        Satis satis = satislar.
                stream().//akisi baslat
                        filter(t -> t.getSatisId() == satisId).//bu stream icerisindeki her bir satis nesnesini kontrol et ve
                //getSatis methodu satisId ye esit olanlari filtreler
                        findFirst().//filtrelenmis olan akistaki ilk elemani bulur ve bu elemani dondurur
                        orElse(null);//filtrelenmis olan bir eeman bulamazsa null degeri doner

        if (satis != null) {
            satislar.remove(satis);
            System.out.println("Satis basariyla iptal edildi");
        }else {
            System.out.println("Gecersiz ID girdiniz");
        }
    }

    public List<Satis> satisListele() {
        return satislar;
    }

    public void satisDetaylariniGoruntuleMenu() {//musterinin girecegi satis id
        System.out.println("Satis Detaylarini Goruntuleme");
        System.out.println("Satis yapilacak urun ID giriniz");
        int satisId = scanner.nextInt();
        scanner.nextLine();
        Satis satis = satisDetaylariniGoruntule(satisId);
        if (satis != null) {
            System.out.println("Satis Id : " + satis.getSatisId() +
                    " Urun Id : " + satis.getUrunId() +
                    " Miktar : " + satis.getMiktar() +
                    " Kasiyer Adi : " + satis.getKasiyerAdi() +
                    " Tarih : " + satis.getSatisTarihi());
        } else {
            System.out.println("Bu Id ile yapilmis satis yoktur");
        }
    }

    public Satis satisDetaylariniGoruntule(int satisId) {
        return satislar.stream().
                filter(t -> t.getSatisId() == satisId).
                findFirst().//filtrelenen elemani buldu ve dondurdu
                        orElse(null);//eleman yoksa null dondurur
    }

    public void satisYonetimiMenu() {
        while (true) {
            System.out.println("Satis Yonetimi Menu");
            System.out.println("1-Yeni Satis Olusturma");
            System.out.println("2-Satislari Listeleme");
            System.out.println("3-Satis Detaylarini Goruntuleme");
            System.out.println("4-Satis Iptali");
            System.out.println("5-Geri Don");
            System.out.print("Seciminiz : ");
            int secim = scanner.nextInt();
            scanner.nextLine();//buffer

            switch (secim) {
                case 1:
                    //Yeni satis olusturma methodu
                    yeniSatisOlusturma();//yeniSatis-yeniSatisOlusturma
                    break;
                case 2:
                    //Satislari listeleme methodu
                    satisListeleme();//satisListeleme
                    break;
                case 3:
                    //Satis detaylarini goruntuleme
                    satisDetaylariniGoruntuleMenu();
                    break;
                case 4:
                    //Satis iptali
                    satisIptalMenu();
                    break;
                case 5:
                    return;//case'i kirar

                default:
                    System.out.println("Gecersiz secim. Tekrar deneyiniz.");
            }
        }
    }

    public void satisListeleme() {
        System.out.println("Satislar listeleniyor...");
        for (Satis satis : satislar) {
            System.out.println("Satis Id : " + satis.getSatisId() +
                    " Urun Id : " + satis.getUrunId() +
                    " Miktar : " + satis.getMiktar() +
                    " Kasiyer Adi : " + satis.getKasiyerAdi() +
                    " Tarih : " + satis.getSatisTarihi());
        }
    }

    public void yeniSatisOlusturma() {
        System.out.println("Yeni Satis Olusturma");
        System.out.println("Satis yapilacak urun Id giriniz ");
        int urunId = scanner.nextInt();//eklenmis olan urunlerden bir id grmesi gerekir
        scanner.nextLine();
        System.out.println("Satis miktarini giriniz ");
        int urunMiktar = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Kasiyer adini giriniz ");
        String kasiyerAdi = scanner.nextLine();

        Urun urun = urunbul(urunId);//yeni urunler buradan girecek
        if (urun != null) {

            yeniSatis(urunId, urunMiktar, kasiyerAdi);
            System.out.println("Satis basariyla olusturuldu");


            urun.setMiktar(urun.getMiktar()-urunMiktar);
            System.out.println("Urun miktari basariyla guncellendi");

        } else {
            System.out.println("Urun bulunamadi");
        }




        //gecersiz urun Ä±d yaz.

    }
    private Urun urunbul(int id) {
        UrunIslemleri listGetir=new UrunIslemleri();
        for (Urun urun :listGetir.getUrunler() ) {
            if (urun.getId() == id) {
                return urun;
            }
        }
        return null;
    }

}