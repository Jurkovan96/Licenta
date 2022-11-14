package siit.model;

import siit.db.repository.dao.ModelObject;

public class Address extends ModelObject {

    private final String streetName;
    private final Integer number;
    private final String city;
    private final String country;

    private Address(Builder builder) {
        super(builder.id);
        this.streetName = builder.streetName;
        this.number = builder.number;
        this.city = builder.city;
        this.country = builder.country;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private String streetName;
        private Integer number;
        private String city;
        private String country;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withStreetName(String street) {
            this.streetName = street;
            return this;
        }

        public Builder withNumber(Integer number) {
            this.number = number;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withCountry(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
