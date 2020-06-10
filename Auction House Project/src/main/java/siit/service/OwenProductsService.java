package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.OwenProductsDao;
import siit.exceptions.ValidationException;
import siit.model.Owen_products;
import siit.model.Product;

import java.util.List;

@Service
public class OwenProductsService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OwenProductsDao owenProductsDao;

    public void addProductToUser(int user_id, int prod_id, int maxVal) {
        int index = 0;
        Product product = productService.getProductById(prod_id);
        for (Owen_products op : owenProductsDao.getOwenProductsForUser(user_id)) {
            if (op.getProduct_id() == prod_id) {
                index++;
            }
        }
        if (index == 0) {
            owenProductsDao.addProductToUser(user_id, product, maxVal);
        } else throw new ValidationException("op.duplicate");

    }

    public List<Owen_products> getUserProductsByUserId(int user_id) {
        List<Owen_products> owen_products = owenProductsDao.getOwenProductsForUser(user_id);
        return owen_products;
    }

    public List<Owen_products> getOwnedProductsById(int op_id) {
        List<Owen_products> owen_products = owenProductsDao.getOwenProductsForOrderProduct(op_id);
        return owen_products;
    }

    public Owen_products getOwnedProductById(int op_id) {
        Owen_products owen_products = owenProductsDao.getOwenProductForOrderProduct(op_id);
        return owen_products;
    }


}
