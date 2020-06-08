package siit.model;

import java.time.LocalDate;
import java.util.Date;

public class Auction {

    private int auction_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private int max_val;
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getAuction_id() {
        return auction_id;
    }

    public void setAuction_id(int auction_id) {
        this.auction_id = auction_id;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public int getMax_val() {
        return max_val;
    }

    public void setMax_val(int max_val) {
        this.max_val = max_val;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auction_id=" + auction_id +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", max_val=" + max_val +
                '}';
    }
}
