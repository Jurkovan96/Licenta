package siit.model;

public class Product {

    private int id;
    private String name;
    private int lenght;
    private int width;
    private String year;
    private String tehn;
    private String artist;
    private String url;
    private int value;
    private Auction auction;




    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTehn() {
        return tehn;
    }

    public void setTehn(String tehn) {
        this.tehn = tehn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lenght=" + lenght +
                ", width=" + width +
                ", year='" + year + '\'' +
                ", tehn='" + tehn + '\'' +
                ", artist='" + artist + '\'' +
                ", url='" + url + '\'' +
                ", value=" + value +
                '}';
    }
}