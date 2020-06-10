package siit.model;

public class ProductDescription {

    private int id_desc;
    private String desc;

    public int getId_desc() {
        return id_desc;
    }

    public void setId_desc(int id_desc) {
        this.id_desc = id_desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ProductDescription{" +
                "id_desc=" + id_desc +
                ", desc='" + desc + '\'' +
                '}';
    }
}
