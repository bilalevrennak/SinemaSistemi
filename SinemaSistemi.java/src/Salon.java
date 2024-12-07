import java.util.ArrayList;
import java.util.List;

public class Salon extends BaseEntity {
    private Film film;
    private List<Musteri> musteriler;

    public Salon(int id, String ad) {
        super(id, ad);
        this.musteriler = new ArrayList<>();
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void musteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    public Film getFilm() {
        return film;
    }

    public List<Musteri> getMusteriler() {
        return musteriler;
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Salon ID: " + getId() + ", Ad: " + getAd());
        if (film != null) {
            System.out.println("Gösterimdeki Film: " + film.getAd());
        }
        System.out.println("Kayıtlı Müşteriler:");
        for (Musteri musteri : musteriler) {
            System.out.println(" - " + musteri.getAd());
        }
    }
}
