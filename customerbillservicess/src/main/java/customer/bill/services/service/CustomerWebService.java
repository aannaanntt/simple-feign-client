package customer.bill.services.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import customer.bill.services.entity.Customer;



@FeignClient(value ="custservice" ,url="http://localhost:1238/cust")
public interface CustomerWebService {
	
	
	@GetMapping("/cust/{id}")
	public Customer getOneCustomer(@PathVariable long id);
	
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomer();
	
	
	@PostMapping("/cust/create")
	public Customer createCustomer(@RequestBody Customer customer);

	
	@PutMapping("/cust/update/{id}")
	public Customer updateCustomer(@PathVariable long id,@RequestBody Customer cust);
	
	
	@DeleteMapping("/cust/{id}")
	public String deleteCustomer(@PathVariable long id);
	

}
