package customer.services.service;

import java.util.List;

import customer.services.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer createCustomer(Customer customer);
	
	public Customer updatedCustomer(long id,Customer customer);
	
	public String deleteCustomer(long id);
	
	public Customer getOneCustomer(long id);

}
