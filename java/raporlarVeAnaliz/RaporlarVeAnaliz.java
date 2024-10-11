package raporlarVeAnaliz;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class RaporlarVeAnaliz {

    private List<Raporlar> raporlar;

    Scanner scanner = new Scanner(System.in);

    public RaporlarVeAnaliz() {
        this.raporlar = new ArrayList<>();
    }

    public void raporlarVeAnalizMenu() {
        while (true) {
            System.out.println("Raporlar ve Analiz Menu");
            System.out.println("1-Gunluk rapor olusturma");
            System.out.println("2-Aylik rapor olusturma");
            System.out.println("3-Guncel raporlari goruntuleme");
            System.out.println("4-Geri don");
            System.out.print("Seciminiz : ");

            try {
                int secim = scanner.nextInt();
                scanner.nextLine();

                switch (secim) {
                    case 1://Gunluk rapor olusturma
                        gunlukRaporOlusturmaMenu();
                        break;
                    case 2:
                        //Aylik rapor olusturma
                        aylikRaporOlusturmaMenu();
                        break;
                    case 3:
                        //Guncel rapor goruntuleme
                        guncelRaporlariGoruntuleme();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Gecersiz secim, tekrar deneyiniz");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Raporlar olusturulurken bir hata meydana geldi "+e.getMessage());
                scanner.next();
            }catch (Exception e){
                System.out.println("Islem sirasinda bir hata olustu");
            }
        }
    }

    private void guncelRaporlariGoruntuleme() {
        System.out.println("Guncel raporlar goruntuleniyor");
        try {
            for (Raporlar rapor : raporlar) {
                System.out.println("Rapor Tarihi : " + rapor.getTarih() +
                        " Rapor Tipi : " + rapor.getRaporTipi() +
                        " Icerik : " + rapor.getIcerik());
            }
        }catch (Exception e){
            System.out.println("Guncel rapor goruntulenirken bir hata olustu "+ e.getMessage());
            scanner.next();
        }
    }


    private void gunlukRaporOlusturmaMenu() {
        System.out.println("Gunluk Rapor Olusturma");
        System.out.println("İcerik : ");
        try {
            String icerik = scanner.nextLine();
            gunlukRaporOlusturma(icerik);
            System.out.println("Gunluk Rapor basariyla olusturuldu.");
        }catch (Exception e){
            System.out.println("Gunluk rapor olusturulurken hata meydana geldi "+ e.getMessage());
            scanner.next();
        }
    }

    LocalDateTime raporTarihi = LocalDateTime.now();//tarih ve saat eklendi
    DateTimeFormatter formatSt = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
    String formattedTime = formatSt.format(raporTarihi);
    public void gunlukRaporOlusturma(String icerik) {
        try {
            Raporlar rapor = new Raporlar(formattedTime, "gunluk", icerik);
            raporlar.add(rapor);
        }catch (Exception e){
            System.out.println("Gunluk rapor olusturulurken hata meydana geldi" +e.getMessage());
        }

        //BU RAPOR OLUSURKEN BUGUN EKLENEN URUNLERI, BUGUN SILINEN URUNLERI VE
        // BUGUN SATIS YAPILAN URUNLERE AIT BILGILERI ICERMELI
    }

    private void aylikRaporOlusturmaMenu() {
        System.out.println("Aylik Rapor Olusturma");
        System.out.println("İcerik : ");
        try {
            String icerik = scanner.nextLine();
            aylikRaporOlusturma(icerik);
            System.out.println("Aylik Rapor olusturuldu.");
        }catch (Exception e){
            System.out.println("Aylik rapor olusturulurken hata meydana geldi "+ e.getMessage());
            scanner.next();
        }
    }

    public void aylikRaporOlusturma(String icerik) {
        try {
            Raporlar rapor = new Raporlar(formattedTime, "aylik", "icerik");
            raporlar.add(rapor);
        }catch (Exception e){
            System.out.println("Aylik rapor olusturulurken hata meydana geldi " + e.getMessage());
        }

        //BU RAPOR OLUSURKEN AYLIK EKLENEN URUNLERI, AYLIK SILINEN URUNLERI VE
        // AYLIK SATIS YAPILAN URUNLERE AIT BILGILERI ICERMELI

    }

}
