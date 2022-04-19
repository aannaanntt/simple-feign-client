package customer.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.services.entity.Customer;
import customer.services.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customrepo;

	@Override
	public List<Customer> getCustomers() {
		return customrepo.findAll();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		
		System.out.println(customer.getCustName());
		
		return customrepo.save(customer);
	}

	@Override
	public Customer updatedCustomer(long id, Customer customer) {
		Customer cust = customrepo.findById(id).get();

		
		cust.setCustName(customer.getCustName());
		cust.setSalary(customer.getSalary());
		return customrepo.save(cust);
	}

	@Override
	public String deleteCustomer(long id) {
		
		customrepo.deleteById(id);
		return "Customer deleted";
	}

	@Override
	public Customer getOneCustomer(long id) {
		return customrepo.findById(id).get();
	}

}
