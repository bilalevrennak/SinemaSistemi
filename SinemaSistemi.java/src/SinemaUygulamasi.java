import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SinemaUygulamasi implements IBiletSistemi {
    private List<Musteri> musteriler = new ArrayList<>();
    private List<Film> filmler = new ArrayList<>();
    private List<Salon> salonlar = new ArrayList<>();

    public static void main(String[] args) {
        SinemaUygulamasi uygulama = new SinemaUygulamasi();
        uygulama.calistir();
    }

    public void calistir() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sinema Müşteri Kayıt Sistemi ===");
            System.out.println("1. Yeni Film Ekle");
            System.out.println("2. Yeni Salon Ekle");
            System.out.println("3. Filmi Salona Ata");
            System.out.println("4. Müşteri Ekle");
            System.out.println("5. Filmleri Listele");
            System.out.println("6. Salon Bilgilerini Göster");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // Boş satır tüketimi

            switch (secim) {
                case 1 -> yeniFilmEkle(scanner);
                case 2 -> yeniSalonEkle(scanner);
                case 3 -> filmiSalonaAta(scanner);
                case 4 -> yeniMusteriEkle(scanner);
                case 5 -> filmleriListele();
                case 6 -> salonBilgileriniGoster(scanner);
                case 0 -> {
                    System.out.println("Çıkış yapılıyor...");
                    return;
                }
                default -> System.out.println("Geçersiz seçim!");
            }
        }
    }

    private void yeniFilmEkle(Scanner scanner) {
        System.out.print("Film adı: ");
        String ad = scanner.nextLine();
        System.out.print("Film süresi (dakika): ");
        int sure = scanner.nextInt();
        scanner.nextLine(); // Boş satır tüketimi
        System.out.print("Film türü: ");
        String tur = scanner.nextLine();

        Film film = new Film(ad, sure, tur);
        filmler.add(film);
        System.out.println("Film eklendi: " + ad);
    }

    private void yeniSalonEkle(Scanner scanner) {
        System.out.print("Salon adı: ");
        String ad = scanner.nextLine();

        Salon salon = new Salon(salonlar.size() + 1, ad);
        salonlar.add(salon);
        System.out.println("Salon eklendi: " + ad);
    }

    private void filmiSalonaAta(Scanner scanner) {
        if (filmler.isEmpty() || salonlar.isEmpty()) {
            System.out.println("Önce film ve salon eklemelisiniz.");
            return;
        }

        System.out.println("Filmler:");
        for (int i = 0; i < filmler.size(); i++) {
            System.out.println((i + 1) + ". " + filmler.get(i).getAd());
        }
        System.out.print("Film seçin: ");
        int filmSecim = scanner.nextInt() - 1;

        System.out.println("Salonlar:");
        for (int i = 0; i < salonlar.size(); i++) {
            System.out.println((i + 1) + ". " + salonlar.get(i).getAd());
        }
        System.out.print("Salon seçin: ");
        int salonSecim = scanner.nextInt() - 1;

        Film film = filmler.get(filmSecim);
        Salon salon = salonlar.get(salonSecim);
        salon.setFilm(film);

        System.out.println(film.getAd() + " filmi " + salon.getAd() + " salonuna atandı.");
    }

    private void yeniMusteriEkle(Scanner scanner) {
        System.out.print("Müşteri adı: ");
        String ad = scanner.nextLine();

        Musteri musteri = new Musteri(musteriler.size() + 1, ad);
        musteriler.add(musteri);

        System.out.println("Müşteri eklendi: " + ad);
    }

    private void filmleriListele() {
        if (filmler.isEmpty()) {
            System.out.println("Kayıtlı film yok.");
            return;
        }

        System.out.println("Kayıtlı Filmler:");
        for (Film film : filmler) {
            film.bilgiGoster();
        }
    }

    private void salonBilgileriniGoster(Scanner scanner) {
        if (salonlar.isEmpty()) {
            System.out.println("Kayıtlı salon yok.");
            return;
        }

        System.out.println("Salonlar:");
        for (int i = 0; i < salonlar.size(); i++) {
            System.out.println((i + 1) + ". " + salonlar.get(i).getAd());
        }
        System.out.print("Salon seçin: ");
        int secim = scanner.nextInt() - 1;

        if (secim < 0 || secim >= salonlar.size()) {
            System.out.println("Geçersiz seçim.");
            return;
        }

        Salon salon = salonlar.get(secim);
        salon.bilgiGoster();
    }

    @Override
    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    @Override
    public void filmEkle(Film film) {
        filmler.add(film);
    }

    @Override
    public void salonEkle(Salon salon) {
        salonlar.add(salon);
    }
}
