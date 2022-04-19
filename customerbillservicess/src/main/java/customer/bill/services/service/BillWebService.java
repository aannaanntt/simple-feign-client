package customer.bill.services.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import customer.bill.services.entity.Bill;



@FeignClient(value ="billservices" ,url="http://localhost:1235")
public interface BillWebService {
	
	@PostMapping("/bill")
	public Bill createBill(@RequestBody Bill bill);
	
	
	@PutMapping("/bill/{id}")
	public Bill updateBill(@PathVariable long id, @RequestBody Bill bill);
	
	
	
	@GetMapping("/bill/cust/{customerId}")
	public Bill getBillByCustomerId(@PathVariable long customerId);
		
	
	
	@GetMapping("/allbills")
	public List<Bill> getAllBills();
	
	
	@DeleteMapping("/bill/delete/{id}")

	public String deleteBill(@PathVariable long id);
	

}
