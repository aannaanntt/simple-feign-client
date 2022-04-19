package customer.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import customer.services.entity.Customer;
import customer.services.service.CustomerService;

@RestController
@RequestMapping("/cust")
public class CustomerController {
	
	@Autowired
	private CustomerService customService;
	
	
	@GetMapping(value="/cust/{id}")
	public ResponseEntity<?> getOneCustomer(@PathVariable long id) {
		return new ResponseEntity<>(customService.getOneCustomer(id),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/customers")
	public List<Customer> getAllCustomer(){
		return customService.getCustomers();
	}
	
	@PostMapping(value="/cust/create")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customService.createCustomer(customer),HttpStatus.OK);
		
	}
	
	@PutMapping(value="/cust/update/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable long id,@RequestBody Customer cust) {
		return new ResponseEntity<>(customService.updatedCustomer(id, cust),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/cust/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id) {
		return  new   ResponseEntity<String>(customService.deleteCustomer(id),HttpStatus.OK);
	}
}
