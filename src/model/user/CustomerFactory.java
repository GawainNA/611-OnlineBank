package model.user;

/**
 * Factory to create customer. CustomerFactory is a singleton
 */
public class CustomerFactory {
    private static CustomerFactory customerFactory;

    private CustomerFactory() {

    }
    
    public static CustomerFactory getInstance() {
        if(customerFactory == null) {
            customerFactory = new CustomerFactory();
        }
        return customerFactory;
    }

    public Customer createCustomer(String username, 
        UserGender gender, 
        String email,
        String passwd, 
        String address, 
        String phoneNum) {
        // TODO: create a new customer, also need to persistence in file
        Customer newCustomer = new Customer(username, gender, passwd, address, phoneNum);
        // TODO: add to warehouse

        return newCustomer;
    }
}