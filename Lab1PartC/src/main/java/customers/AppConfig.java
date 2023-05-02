package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerService customerService() {
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDAO(customerDAO());
        customerService.setEmailSender(emailSender());
        return customerService;
    }

    @Bean
    public EmailSender emailSender() {
        EmailSender emailSender = new EmailSender();
        emailSender.setLogger(logging());
        return emailSender;
    }

    @Bean
    public CustomerDAO customerDAO() {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.setLogger(logging());
        return customerDAO;
    }

    @Bean
    public ILogger logging() {
        return new Logger();
    }

}
