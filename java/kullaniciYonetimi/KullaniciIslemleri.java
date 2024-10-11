package kullaniciYonetimi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KullaniciIslemleri {

    List<Kullanici> kullanicilar;

    Scanner scanner = new Scanner(System.in);

    public KullaniciIslemleri() {
        this.kullanicilar = new ArrayList<>();
    }

    public void kullaniciEkle(Kullanici yeniKullanici) {

        try {
            for (Kullanici mevcutKullanici : kullanicilar) {
                if (mevcutKullanici.getKullaniciAdi().equalsIgnoreCase(yeniKullanici.getKullaniciAdi())) {
                    System.out.println("Bu kullanıcı adı zaten mevcut: " + mevcutKullanici.getKullaniciAdi());
                    return;
                }
            }
            kullanicilar.add(yeniKullanici);
            System.out.println("Kullanıcı eklendi: " + yeniKullanici.getKullaniciAdi());

        }catch (Exception e){
            System.out.println("Kullanici Eklerken bir hata olustu " +e.getMessage());
        }
    }

    public void kullaniciSil(Kullanici kullanici) {
        try {
            if (!kullanicilar.remove(kullanici)){
                //method calistiktan sonra true ya da false deger donecegi icin method
                // burada 1 defa calisir varsa siler, true doner.
                //true dondukten sonra ! ile deger false doner
                throw new Exception("Kullanici bulunamadi "+ kullanici.getKullaniciAdi());
            }
            System.out.println("Kullanici silindi " +kullanici.getKullaniciAdi());
        }catch (Exception e){
            System.out.println("Kullanici silerken bir hata olustu " + e.getMessage());
        }
    }
    public void kullaniciGuncelle(Kullanici kullanici, String yeniSifre) {
        try {
            if (kullanici == null){
                throw new Exception("Guncellenecek kullanici bulunamadi ");
            }
            kullanici.setSifre(yeniSifre);
            System.out.println("Kullanici guncellendi : "+ kullanici.getKullaniciAdi());
        }catch (Exception e){
            System.out.println("Kullanici guncellenirken bir hata olustu : "+ e.getMessage());
        }

    }

    public void kullaniciYonetimiMenu() {
        while (true) {

            System.out.println("Kullanıcı Yönetim Menüsü");
            System.out.println(" 1)- Yeni Kullanıcı Ekleme");
            System.out.println(" 2)- Kullanıcı Listeleme");
            System.out.println(" 3)- Kullanıcı Bilgileri Güncelleme");
            System.out.println(" 4)- Kullanıcı Silme");
            System.out.println(" 5)- Geri Dön");
            System.out.print("  Seçiminiz :");

            try {
                int secim = scanner.nextInt();
                scanner.nextLine();

                switch (secim) {
                    case 1:
                        yeniKullaniciEkleme();
                        break;
                    case 2:
                        kullaniciListeleme();
                        break;
                    case 3:
                        kullaniciGuncelleme();
                        break;
                    case 4:
                        kullaniciSilme();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Geçersiz seçim, tekrar deneyin!!!");
                        return;
                }
            }catch (Exception e){
                System.out.println("Gecersiz giris yaptiniz (1-2-3-4-5) " +e.getMessage());
                scanner.next();
            }
        }
    }

    private void yeniKullaniciEkleme() {
        System.out.println("Yeni Kullanıcı Ekleme Menüsü");
        try {
            System.out.print("Kullanıcı Adı : ");
            String kullaniciAdi = scanner.nextLine();
            System.out.print("Şifre : ");
            String kullaniciSifre = scanner.nextLine().trim();
            if (kullaniciSifre.length() > 5 &&
                    !kullaniciSifre.replaceAll("[^A-Z]", "").isEmpty() &&
                    !kullaniciSifre.replaceAll("[^a-z]", "").isEmpty() &&
                    !kullaniciSifre.replaceAll("[^0-9]", "").isEmpty()) {
            } else {
                System.out.println("Geçersiz şifre girdiniz. Şifre en az 6 karakter olmalı, " +
                        "\nen az bir tane büyük harf, en az bir tane küçük harf ve rakam içermelidir");
                return;
            }
            System.out.println("Rol Seçiniz :");
            System.out.println("  1- Admin");
            System.out.println("  2- Kasiyer");
            System.out.println("  3- Müşteri");
            int rolSecim = scanner.nextInt();
            scanner.nextLine();

            Kullanici yeniKullanici;
            switch (rolSecim) {
                case 1:
                    yeniKullanici = new Admin(kullaniciAdi, kullaniciSifre);
                    break;
                case 2:
                    yeniKullanici = new Kasiyer(kullaniciAdi, kullaniciSifre);
                    break;
                case 3:
                    yeniKullanici = new Musteri(kullaniciAdi, kullaniciSifre);
                    break;
                default:
                    throw new IllegalArgumentException("Gecersiz rol secimi. Lutfen sayi girin. ");
            }
            kullaniciEkle(yeniKullanici);
        }catch (Exception e){
            System.out.println("Yeni kullanici eklerken bir hata olustu " +e.getMessage());

        }
    }

    private void kullaniciSilme() {

        System.out.println("Kullanıcı Silme Menüsü");
        System.out.println("Kullanıcı adı:");
        try {
            String kullaniciAdi = scanner.nextLine();

            Kullanici kullanici = null;

            for (Kullanici k : kullanicilar) {
                if (k.getKullaniciAdi().equals(kullaniciAdi)) {
                    kullanici = k;
                }
            }
            if (kullanici != null) {
                kullaniciSil(kullanici);
                System.out.println("Kulanıcı Silindi");
            } else {
                throw new Exception("Kullanici bulunamadi "+kullaniciAdi);
            }
        }catch (Exception e) {
            System.out.println("Kullanici silerken bir hata olustu " + e.getMessage());
        }
    }

    private void kullaniciGuncelleme() {
        System.out.println("Kullanıcı Güncelleme Menüsü");
        System.out.println("Güncellenecek Kullanıcı Adı :");
        try {
            String kullaniciAdi = scanner.nextLine();
            Kullanici kullanici = null;

            for (Kullanici k : kullanicilar) {
                if (k.getKullaniciAdi().equals(kullaniciAdi)) {
                    kullanici = k;
                    break;
                }
            }

            if (kullanici != null) {
                System.out.println("Yeni Şifre :");
                String yeniSifre = scanner.nextLine();
                if (yeniSifre.equals(kullanici.getSifre())){
                    System.out.println("Sifre onceki sifreyle ayni olamaz");
                }else {
                    kullanici.setSifre(yeniSifre);
                    System.out.println("Şifre Başarıyla Güncellendi");
                }
            } else {
                throw new Exception("Kullanıcı Bulunamadı");
            }
        }catch (Exception e){
            System.out.println("Kullanici guncellerken bir hata olustu " + e.getMessage());
        }

    }

    private void kullaniciListeleme() {
        System.out.println("Kullanıcılar Listeleniyor...");

        try {
            for (Kullanici kullanici : kullanicilar) {
                System.out.println("Kullanıcı Adı : " + kullanici.getKullaniciAdi() + " Rol : " + kullanici.getRol());
            }
        }catch (Exception e){
            System.out.println("Kullanicilar listelenirken bir hata olustu "+e.getMessage());
        }

    }

    public List<Kullanici> kullaniciListele() {
        return kullanicilar;
    }
}
