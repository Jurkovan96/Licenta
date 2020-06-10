package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.AuctionDao;
import siit.db.DescriptionDao;
import siit.db.ProductDao;
import siit.model.Product;
import siit.model.ProductDescription;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private AuctionDao auctionDao;

    @Autowired
    private DescriptionDao descriptionDao;

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public List<Product> getProductsByYear(int year) {
        return productDao.getProductsByYears(year);
    }

    public Product getProductById(int id) {
        Product product = productDao.getProductById(id);
        return product;
    }


    public Product getProductByBidId(int bid_id) {
        return productDao.getProductForBid(bid_id);
    }

    public List<Product> getProductsByArtists(String artist) {
        return productDao.getProductsByArtists(artist);
    }

    public List<Product> getProductsByTehniq(String tehniq) {
        return productDao.getProductsByTehnique(tehniq);
    }

    public List<Product> getProductsWithTime() {
        List<Product> products = getProducts();
        for (Product p : products) {
            p.setAuction(auctionDao.getAuctionForProduct(p.getId()));
            calculateTime(p);
        }
        return products;
    }

    public void calculateTime(Product product) {
        long timeB = ChronoUnit.DAYS.between(LocalDate.now(), product.getAuction().getEnd_date());
        product.getAuction().setTime(timeB);
    }

    public Product getProductWithDescriptionById(int prod_id){
        Product product = productDao.getProductById(prod_id);
        ProductDescription description = descriptionDao.getProductTextByProductId(prod_id);
        product.setDescription(description);
        return product;
    }
}
