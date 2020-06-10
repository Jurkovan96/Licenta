package siit.model;

public class OrderProduct {

   private int order_id;
   private int bid_ord_id;
   private Owen_products owen_products;
   private int price;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getBid_ord_id() {
        return bid_ord_id;
    }

    public void setBid_ord_id(int bid_ord_id) {
        this.bid_ord_id = bid_ord_id;
    }

    public Owen_products getOwen_products() {
        return owen_products;
    }

    public void setOwen_products(Owen_products owen_products) {
        this.owen_products = owen_products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
