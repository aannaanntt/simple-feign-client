package customer.bill.services.service;

import java.util.List;

import customer.bill.services.entity.Customer;

public interface CustomerBillService {
	
	public List<Customer> getCustomers();
	public Customer addCustomerBill(Customer customer);
	
	public Customer updateCustomer(long id,Customer cust);
	
	public String deleteCustomer(long id);

}
