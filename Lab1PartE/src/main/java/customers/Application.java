package customers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new
				AnnotationConfigApplicationContext(AppConfig.class);
		ICustomerService customerService = context.getBean("customerService",
				ICustomerService.class);
		IProductService productService = context.getBean("productService",
				IProductService.class);

		customerService.addCustomer("Frank Brown", "fbrown@acme.com",
				"mainstreet 5", "Chicago", "60613");

		System.out.println("\n------------------------------------------------------------------------\n");

		productService.addProduct("SD1001", "Coffee", 5.98);

	}
}

