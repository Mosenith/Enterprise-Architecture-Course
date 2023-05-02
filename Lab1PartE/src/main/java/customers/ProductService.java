package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private IProductDAO productDAO;
    private IEmailSender emailSender;

    @Autowired
    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setEmailSender(IEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void addProduct(String productId, String productName, Double price) {
        Product product = new Product(productId, productName, price);
        productDAO.saveProduct(product);
        emailSender.sendEmail("admin@gmail.com", "Product with ID = " +
                productId + " is added!");
    }
}
