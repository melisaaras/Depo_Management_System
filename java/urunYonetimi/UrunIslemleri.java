package urunYonetimi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class UrunIslemleri {


    private List<Urun> urunler;//private bir urun degiskeni olusturduk--yapici contsr. icindeki butun data typelerina ulasabilirz ve urunler fields'ina methot uyguayabilecegiz

    private int[] rafSiraGida = {1, 1};// gida kategorisi icin raf ve sira olusturuldu. urun eklendikce sayacla artacak
    private int[] rafSiraManav = {1, 1};//manav kategorisi icin raf ve sira olusturuldu. urun eklendikçe sayaclar artacak
    private int[] rafSiraElektronik = {1, 1};//elektronik kategorisi icin raf ve sira olusturuldu. urun eklendikçe sayaclar artacak

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public UrunIslemleri() {//constructor olusturacaz
        this.urunler = new ArrayList<>();
    }

    public void urunEkle(Urun urun) {//urun constructor icindeki degiskenlere buradan rahatlikla ulasabiliriz

        urunler.add(urun);
    }

    public void urunSil(Urun urun) {

        urunler.remove(urun);
    }

    private void urunListele() {
        if (urunler != null) {
            for (Urun urun : urunler) {
                System.out.println("urunId: " + urun.getId() + "\nadi: "
                        + urun.getUrunIsim() + "\nuretici: " + urun.getUretici() +
                        "\nurun miktari : "
                        + urun.getMiktar() + " \nraf : " + urun.getRaf() +
                        "\nsira : " + urun.getSira());

            }
        } else {//BURAYA BAKKKKK
            System.out.println("Listelenecek urun yok");
        }

    }

    //urunleri guncelleme
   /* public void urunGuncelle(Urun urun, double yenimiktar) {//setmiktar uzerinden calisacak
        urun.setMiktar(yenimiktar);
    }*/

    //yeni urun tanimlama

    private void yeniUrunTanimlama() {
        System.out.println("Yeni Ürün Tanımlama");
        System.out.print("Ürün Adı: ");
        String isim = scanner.nextLine();
        System.out.print("Üretici: ");
        String uretici = scanner.nextLine();
        System.out.print("Miktar: ");
        double miktar = scanner.nextDouble();
        scanner.nextLine();  // Buffer temizleme
        System.out.print("Birim: ");
        String birim = scanner.nextLine();
        System.out.println("Kategori Seçin: 1. Gıda, 2. Manav, 3. Elektronik");
        int kategoriSecim = scanner.nextInt();
        scanner.nextLine(); // Buffer temizleme

        Urun yeniurun;
        int id = urunler.size() + 1;

        switch (kategoriSecim) {
            case 1:
                yeniurun = new Gida(id, isim, uretici, miktar, birim);//scannerdan aldik ve ilgili kategoriye gonderdik
                setRafVeSira(yeniurun, rafSiraGida);
                break;
            case 2:
                yeniurun = new Manav(id, isim, uretici, miktar, birim);
                setRafVeSira(yeniurun, rafSiraManav);
                break;
            case 3:
                yeniurun = new Elektronik(id, isim, uretici, miktar, birim);
                setRafVeSira(yeniurun, rafSiraElektronik);
                break;
            default:
                System.out.println("Gecersiz kategori secimi");
                return;
        }
        urunEkle(yeniurun);
        System.out.println("Urun basariyla eklendi");
    }

    private void urunGuncelleme() {
        System.out.println("Urun guncellenme ekrani");
        System.out.println("Guncellenecek urun id girin");
        int id = scanner.nextInt();
        scanner.nextLine();//buffer temizleme

        Urun urun = urunbul(id);//yeni urunler buradan girecek
        if (urun != null) {
            System.out.println("Miktari giriniz : ");
            double yeniMiktar = scanner.nextDouble();
            scanner.nextLine();
            urun.setMiktar(yeniMiktar);
            System.out.println("Urun miktari basariyla guncellendi");

        } else {
            System.out.println("Urun bulunamadi");
        }
    }

    private Urun urunbul(int id) {
        for (Urun urun : urunler) {
            if (urun.getId() == id) {
                return urun;
            }
        }
        return null;
    }

    private void urunSilme() {
        System.out.println("Urun silme ekrani");
        System.out.println("Silinecek urun id girin");
        int id = scanner.nextInt();
        scanner.nextLine();//buffer temizleme

        Urun urun = urunbul(id);//yeni urunler buradan girecek
        if (urun != null) {
            urunSil(urun);
            System.out.println("Urun basariyla silindi");

        } else {
            System.out.println("Urun bulunamadi");
        }
    }

    private void urunDetaylariniGoruntuleme() {
        System.out.println("Urun detaylarini goruntuleme : ");
        System.out.println("Urun id'si giriniz : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Urun urun = urunbul(id);

        if (urun != null) {
            System.out.println("Urun adi : " + urun.getUrunIsim() +
                    " Uretici : " + urun.getUretici() +
                    " Urun miktari : " + urun.getMiktar() +
                    " Birim : " + urun.getBirim() +
                    " Raf : " + urun.getRaf() +
                    " Sira : " + urun.getRaf());
            //Urun ekleyen giris tarihi,cikis tarihi
        } else {
            System.out.println("Urun bulunamadi.");
        }
    }

    public void urunYonetimiMenu() {
        while (true) {
            System.out.println("Urun yonetim menusu");
            System.out.println("1-Yeni Urun Tanimla");
            System.out.println("2-Urun Listeleme");
            System.out.println("3-Urun Detaylarini Goruntuleme");
            System.out.println("4-Urun Guncelleme");
            System.out.println("5-Urun Silme");
            System.out.println("6-Geri don");
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    yeniUrunTanimlama();
                    break;
                case 2:
                    urunListele();
                    break;
                case 3:
                    urunDetaylariniGoruntuleme();
                    break;
                case 4:
                    urunGuncelleme();
                    break;
                case 5:
                    urunSilme();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Hatali giris yaptiniz, tekrar deneyiniz");

            }
        }

    }

    private void setRafVeSira(Urun urun, int[] rafSira) {
        //urun raf ve sira bilgilerini ayarlama
        // bu iki satir urunun raf ve sira bilgilerini "rafSira" dizisindeki degere gore ayarlar

        //urunun raf sirasini rafSira[0] degerine ayarlar
        urun.setRaf(rafSira[0]);//int dizi-raf numarasini tutar
        urun.setSira(rafSira[1]);//o raftaki sirayi temsil eder
        //urunun sira numarasini sira[1] degerine ayarlar

        rafSira[1]++;//bu satir mevcut raftaki sirayi 1 artirir.
        // yani bir sonraki urun icin sira numarasini artirir

        if (rafSira[1] > 2) {//sira kontrolu ve raf guncellemesi
            //bu kontrol siranin 2 den buyuk olup olmadigini kontrol eder
            //eger rafSira[1]>2 ise bu mevcut raftaki siranin doldugunu gosterir ve
            // yeni bir rafa gecilmesi anlamina gelir

            rafSira[0]++;//raf numarasini 1 artirir. Yani yeni rafa gecer
            rafSira[1] = 1;//sira numarasini tekrar 1 yapar. cunku acilan raf sira numarasi da 1'den baslayacak

            //ornek senaryo: baslangicta rafSira = {1,1} -->1. raf, 1. sira
            //ilk urun icin, urunun raf ve sira bilgileri 1 ve 1 olur.
            //urun eklendiginde sira 1 artirilir ve rafSira artik {1,2} olur.


        }

    }

    public List<Urun> getUrunler() {
        return urunler;
    }
}
