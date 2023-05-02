package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO implements IProductDAO {
    private ILogger logger;

    @Autowired
    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void saveProduct(Product product) {
        // simple sleep
        try {
            Thread.sleep(550);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ProductDAO: saving product with ID = '" + product.getProductId() +
                "' and Product Name = '" + product.getProductName() + "'");
        logger.log("Product is saved in the DB: " + product.getProductId() + " : " +
                product.getProductName());
    }
}
