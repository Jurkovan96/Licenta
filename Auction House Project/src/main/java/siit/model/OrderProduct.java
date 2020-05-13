package siit.model;

public class OrderProduct {

    private int price;
    private Product product;
    private int order_id;
    private String pay_meth;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPay_meth() {
        return pay_meth;
    }

    public void setPay_meth(String pay_meth) {
        this.pay_meth = pay_meth;
    }
}
