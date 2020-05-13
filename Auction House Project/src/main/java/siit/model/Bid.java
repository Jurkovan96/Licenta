package siit.model;
import java.util.Date;

 public class Bid {

    private int bid_id;
    private Product product;
    private String state;
    private Date start_date;
    private Date end_date;
    private int bid_value;

    public int getBid_id() {
        return bid_id;
    }

    public void setBid_id(int bid_id) {
        this.bid_id = bid_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getBid_value() {
        return bid_value;
    }

    public void setBid_value(int bid_value) {
        this.bid_value = bid_value;
    }

     @Override
     public String toString() {
         return "Bid{" +
                 "bid_id=" + bid_id +
                 ", product=" + product +
                 ", state='" + state + '\'' +
                 ", start_date=" + start_date +
                 ", end_date=" + end_date +
                 ", bid_value=" + bid_value +
                 '}';
     }
 }
