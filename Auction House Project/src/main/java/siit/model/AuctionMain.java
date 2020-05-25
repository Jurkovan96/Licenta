package siit.model;

import java.sql.Timestamp;

public class AuctionMain {

    private int main_id;
    private String auction_state;
    private String acution_name;
    private Timestamp start_date;
    private Timestamp end_date;
    private User user;
    private Product product;

    public int getMain_id() {
        return main_id;
    }

    public void setMain_id(int main_id) {
        this.main_id = main_id;
    }

    public String getAuction_state() {
        return auction_state;
    }

    public void setAuction_state(String auction_state) {
        this.auction_state = auction_state;
    }

    public String getAcution_name() {
        return acution_name;
    }

    public void setAcution_name(String acution_name) {
        this.acution_name = acution_name;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
