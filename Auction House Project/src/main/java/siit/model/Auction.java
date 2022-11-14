package siit.model;

import siit.db.repository.dao.ModelObject;

import java.time.LocalDate;
import java.util.Set;

public class Auction extends ModelObject {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Integer maximumBet;
    private final Set<Bid> bids;

    private Auction(Builder builder) {
        super(builder.id);
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.maximumBet = builder.maximumBet;
        this.bids = builder.bids;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Integer getMaximumBet() {
        return maximumBet;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private LocalDate startDate;
        private LocalDate endDate;
        private Integer maximumBet;
        private Set<Bid> bids;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder withMaximumBet(Integer maximumBet) {
            this.maximumBet = maximumBet;
            return this;
        }

        public Builder withUserList(Set<Bid> bids) {
            this.bids = bids;
            return this;
        }

        public Auction build() {
            return new Auction(this);
        }
    }
}
