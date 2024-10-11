package depoYonetimi;

import urunYonetimi.Urun;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DepoIslemleri {

    private Depo depo;

    public DepoIslemleri() {
        this.depo = new Depo();
    }

    Scanner scanner = new Scanner(System.in);

    public void depoMenu() {
        while (true) {
            System.out.println("Depo Menu");
            System.out.println("1-Depo girisi");
            System.out.println("2-Depo cikisi");
            System.out.println("3-Depo hareketlerini listeleme");
            System.out.println("4- Geri don");
            System.out.println("Seciminiz :");
           try {
               int secim = scanner.nextInt();
               scanner.nextLine();

               switch (secim) {
                   case 1:
                       //urun girisi menu methodu cagrilcak
                       urunGirisiMenu();
                       break;
                   case 2:
                       //urun cikisi menu methodu cagrilacak
                       urunCikisiMenu();
                       break;
                   case 3:
                       //urun hareket liste menusu methodu cagiracaz
                       urunHareketleriniGoruntule();
                       break;
                   case 4:
                       //geri don
                       return;
                   default:
                       System.out.println("Gecersiz secim, lutfen tekrar deneyiniz");
               }
           }catch (InputMismatchException e){
               System.out.println("Gecersiz karakter girdiniz. Lutfen sadece rakam giriniz(1-2-3-4) " +e.getMessage());
               scanner.next();
           }
        }
    }
    //methodlar-depo menu end

    private void urunGirisiMenu() {

        System.out.println("Depo Girisi");
        Urun urun = urunBilgileriAl();
        System.out.println("Miktari giriniz : ");
        try {
            double miktar = scanner.nextDouble();
            scanner.nextLine();
            depo.urunGirisi(urun,miktar);

        }catch (InputMismatchException e){
            System.out.println("Gecersiz miktar girdiniz. Lutfen bir sayi giriniz "+e.getMessage());
            scanner.next();
        }catch (Exception e){
            System.out.println("Depo giris islemi sirasinda bir hata olustu "+ e.getMessage());
        }
    }
    private void urunCikisiMenu() {

        System.out.println("Depo Cikisi");
        Urun urun = urunBilgileriAl();
        System.out.println("Miktari giriniz :");
        try {
            double miktar = scanner.nextDouble();
            scanner.nextLine();
            depo.urunCikisi(urun,miktar);
        }catch (InputMismatchException e){
            System.out.println("Gecersiz miktar girdiniz. Lutfen bir sayi giriniz "+e.getMessage());
            scanner.next();
        }catch (Exception e){
            System.out.println("Depo cikis islemi sirasinda bir hata olustu " +e.getMessage());
        }
    }

    private Urun urunBilgileriAl(){
        System.out.println("Depo hareket id : ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Urun adi : ");
            String urunIsmi = scanner.nextLine();

            System.out.println("Uretici : ");
            String uretici = scanner.nextLine();

            System.out.println("Birimi : ");
            String birim = scanner.nextLine();

            System.out.println("Kategori giriniz: ");
            String kategori = scanner.nextLine();
            return new Urun(id, urunIsmi,uretici,0,birim,kategori) {
                @Override
                public void rafOlustur() {
                }
                @Override
                public void idOlustur() {
                }
            };
        }catch (InputMismatchException e){
            System.out.println("Gecersiz karakter girdiniz. Lutfen sayi giriniz "+ e.getMessage());
            scanner.next();

        }catch (Exception e){
            System.out.println("Urun bilgileri alinirken hata olustu");
        }
        return null;
    }

    private void urunHareketleriniGoruntule(){
        depo.urunHareketleriniListele();

    }



}
