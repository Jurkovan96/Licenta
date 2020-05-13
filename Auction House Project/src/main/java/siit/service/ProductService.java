package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.ProductDao;
import siit.model.Product;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    public List<Product> getProductsByYear(int year){
        return productDao.getProductsByYears(year);
    }

    public Product getProductById(int id){
        Product product = productDao.getProductById(id);
       return product;}


    public Product getProductByBidId(int bid_id){
        return productDao.getProductForBid(bid_id);
    }

    public List<Product> getProductsByArtists(String artist) {
        return productDao.getProductsByArtists(artist);
    }

    public List<Product> getProductsByTehniq(String tehniq) {
        return productDao.getProductsByTehnique(tehniq);
    }
}
