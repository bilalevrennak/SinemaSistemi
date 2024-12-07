public abstract class BaseEntity {
    private int id;
    private String ad;

    public BaseEntity(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public abstract void bilgiGoster();
}
