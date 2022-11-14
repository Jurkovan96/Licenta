package siit.model;

import siit.db.repository.dao.ModelObject;

import java.time.LocalDate;

public class Bid extends ModelObject {

    private final LocalDate postDate;
    private final BidStatus status;
    private final Integer userId;
    private final Integer productId;
    private final Double bidderSum;

    private Bid(Builder builder) {
        super(builder.id);
        this.postDate = builder.postDate;
        this.status = builder.status;
        this.userId = builder.userId;
        this.productId = builder.productId;
        this.bidderSum = builder.bidderSum;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public BidStatus getStatus() {
        return status;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public Double getBidderSum() {
        return bidderSum;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private java.lang.Integer id;
        private LocalDate postDate;
        private BidStatus status;
        private Integer userId;
        private Integer productId;
        private Double bidderSum;

        public Builder withPostDate(LocalDate postDate) {
            this.postDate = postDate;
            return this;
        }

        public Builder withStatus(BidStatus status) {
            this.status = status;
            return this;
        }

        public Builder withUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder withProductId(Integer productId) {
            this.productId = productId;
            return this;
        }

        public Builder withBidderSum(Double bidderSum) {
            this.bidderSum = bidderSum;
            return this;
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Bid build() {
            return new Bid(this);
        }
    }
}
