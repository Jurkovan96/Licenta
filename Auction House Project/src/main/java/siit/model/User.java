package siit.model;

import java.util.List;

public class User {

    private int id;
    private String name;
    private String password;
    private String email;
    private String phone_number;
    private List<Bid> bidsList;
    private Adress adress;

    public List<Bid> getBidsList() {
        return bidsList;
    }

    public void setBidsList(List<Bid> bidsList) {
        this.bidsList = bidsList;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Bid> getBids() {
        return bidsList;
    }

    public void setBids(List<Bid> bids) {
        this.bidsList = bids;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
