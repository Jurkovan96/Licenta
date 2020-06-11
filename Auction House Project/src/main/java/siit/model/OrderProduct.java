package siit.model;

public class OrderProduct {

    private int order_id;
    private int order_prod_id;
    private Owen_products product;
    private int produc_sale_value;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrder_prod_id() {
        return order_prod_id;
    }

    public void setOrder_prod_id(int order_prod_id) {
        this.order_prod_id = order_prod_id;
    }

    public Owen_products getProduct() {
        return product;
    }

    public void setProduct(Owen_products product) {
        this.product = product;
    }

    public int getProduc_sale_value() {
        return produc_sale_value;
    }

    public void setProduc_sale_value(int produc_sale_value) {
        this.produc_sale_value = produc_sale_value;
    }
}
