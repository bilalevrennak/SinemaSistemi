public class Musteri extends BaseEntity {
    public Musteri(int id, String ad) {
        super(id, ad);
    }

    @Override
    public void bilgiGoster() {
        System.out.println("Müşteri ID: " + getId() + ", Ad: " + getAd());
    }
}
