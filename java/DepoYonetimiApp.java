
import kullaniciYonetimi.Kullanici;

import kullaniciYonetimi.*;
import urunYonetimi.*;
import satisYonetimi.*;
import raporlarVeAnaliz.*;
import depoYonetimi.*;

import java.util.Scanner;

public class DepoYonetimiApp {
    private static KullaniciIslemleri kullaniciIslemleri = new KullaniciIslemleri();
    private static UrunIslemleri urunİslemleri = new UrunIslemleri();
    private static SatisIslemleri satisIslemleri = new SatisIslemleri();
    private static RaporlarVeAnaliz raporIslemleri= new RaporlarVeAnaliz();
    private static DepoIslemleri depoIslemleri = new DepoIslemleri();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        kullaniciIslemleri.kullaniciEkle(new Admin("admin", "123"));
        kullaniciIslemleri.kullaniciEkle(new Kasiyer("kasiyer", "123"));
        kullaniciIslemleri.kullaniciEkle(new Musteri("musteri", "123"));

        depoYonetimMenu();

    }

    private static void musteriMenu() {
        System.out.println(" -----Musteri Menu-----");
        System.out.println("1-Yeni Urun Satin Al");
        System.out.println("2-Satis Iptal");
        System.out.println("3-Cikis");
        System.out.println("4-Hesap Değiştir");
        System.out.print("Seciminiz : ");
        int secim = scanner.nextInt();
        scanner.nextLine();
        switch (secim){
            case 1:
                //yeni urun satin alma
                satisIslemleri.yeniSatisOlusturma();
                işlemSonrasıSecim();
                break;
            case 2:
                //Satis iptal
                satisIslemleri.satisIptalMenu();
                işlemSonrasıSecim();
                break;
            case 3:
                System.out.println("Cikis yapiliyor...");
                System.exit(3);
            case 4:
                System.out.println("Giriş Ekranına Dönülüyor...");
                System.out.println(" ");
                depoYonetimMenu();
            default:
                System.out.println("Gecersiz secim, tekrar deneyiniz...");
                System.out.println(" ");
                musteriMenu();
                break;
        }
    }

    private static void kasiyerMenu() {
        System.out.println("-----Kasiyer Menu-----");
        System.out.println("1-Urun Yonetimi ");
        System.out.println("2-Satis Yonetimi ");
        System.out.println("3-Raporlar ve Analiz ");
        System.out.println("4-Cikis ");
        System.out.println("5-Hesap Değiştir ");
        System.out.println("Seciminiz : ");
        int secim = scanner.nextInt();
        scanner.nextLine();
        switch (secim){
            case 1:
                urunİslemleri.urunYonetimiMenu();
                break;
            case 2 :
                satisIslemleri.satisYonetimiMenu();
                break;
            case 3:
                raporIslemleri.raporlarVeAnalizMenu();
                break;
            case 4:
                System.out.println("Cikis yapiliyor...");
                 System.exit(4);
            case 5:
                System.out.println("Giriş Ekranına Dönülüyor...");
                System.out.println(" ");
                depoYonetimMenu();
                break;
            default:
                System.out.println("Gecersiz secim, tekrar deneyiniz");
                System.out.println(" ");
                kasiyerMenu();
                break;
        }

    }

    private static void adminMenu() {
        while (true){
            System.out.println("-----Admin Menu-----");
            System.out.println("1-Urun Yonetimi ");
            System.out.println("2-Kullanici Yonetimi");
            System.out.println("3-Satis Yonetimi ");
            System.out.println("4-Depo Yonetimi");
            System.out.println("5-Raporlar ve Analiz ");
            System.out.println("6-Cikis ");
            System.out.println("7-Hesap Değiştir");
            System.out.println("Seciminiz : ");
            int secim = scanner.nextInt();
            scanner.nextLine();
            switch (secim){
                case 1:
                    urunİslemleri.urunYonetimiMenu();
                    break;
                case 2 :
                    kullaniciIslemleri.kullaniciYonetimiMenu();
                    break;
                case 3:
                    satisIslemleri.satisYonetimiMenu();
                    break;
                case 4:
                    depoIslemleri.depoMenu();
                    break;
                case 5:
                    raporIslemleri.raporlarVeAnalizMenu();
                    break;
                case 6:
                    System.out.println("Cikis yapiliyor...");
                    System.exit(6);
                case 7:
                    System.out.println("Giriş Ekranına Dönülüyor...");
                    System.out.println(" ");
                    depoYonetimMenu();
                    break;
                default:
                    System.out.println("Gecersiz secim, tekrar deneyiniz");
                    System.out.println(" ");
                    adminMenu();
                    break;
            }
        }
    }


    public static void depoYonetimMenu(){

        System.out.println("Depo Yonetim Uygulamasina Hos Geldiniz");
        System.out.println("Kullanici adinizi giriniz. ");
        String kullaniciAdi =scanner.nextLine();
        System.out.println("Sifrenizi giriniz. ");
        String sifre = scanner.nextLine();
        Kullanici girisYapanKullanici = null;
        for (Kullanici k: kullaniciIslemleri.kullaniciListele()){
            if (k.getKullaniciAdi().equals(kullaniciAdi)&& k.getSifre().equals(sifre)){
                girisYapanKullanici = k;
            }
        }
        if (girisYapanKullanici !=null){
            System.out.println("Giris basarili, hos geldiniz. Sayin, "
                    + girisYapanKullanici.getKullaniciAdi());
            girisYapanKullanici.rolYetkileri();
            switch (girisYapanKullanici.getRol()){
                case "Admin":
                    //Admine gosterilecek menu
                    adminMenu();
                    break;
                case "Kasiyer":
                    //kasiyere gosterilecek menu
                    kasiyerMenu();
                    break;
                case "Musteri":
                    musteriMenu();
                    break;
            }
        }else{
            System.out.println("Kullanici adi ya da sifre yanlis, tekrar deneyiniz...");
            System.out.println(" ");
            depoYonetimMenu();
        }

    }

    public static void işlemSonrasıSecim(){
        System.out.println("Yeni Bir İşlem Yapmak İçin --> 1");
        System.out.println("ÇIKIŞ için                 --> 0");
        int secim= scanner.nextInt();
        switch (secim){
            case 1:
                System.out.println("Menüye Yönlendiriliyor ...");
                musteriMenu();
            case 0:
                System.out.println("Çıkış Yapılıyor ...");
               System.exit(0);
            default:
                System.out.println("Hatalı Seçim Yaptınız, Tekrar deneyiniz");
                işlemSonrasıSecim();
        }
    }




}
