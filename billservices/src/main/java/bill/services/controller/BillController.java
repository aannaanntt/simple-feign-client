package bill.services.controller;

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

import bill.services.entity.Bill;
import bill.services.service.BillService;

@RestController

public class BillController {
	
	@Autowired
	BillService billService;
	
	
	@PostMapping(value="/bill")
	public ResponseEntity<?> createBill(@RequestBody Bill bill){
		System.out.println(bill);
		return new ResponseEntity<>(billService.createBill(bill),HttpStatus.OK);
	}
	
	@PutMapping(value="/bill/{id}")
	public ResponseEntity<?> updateBill(@PathVariable long id,@RequestBody Bill bill){
		return new ResponseEntity<>(billService.updateBill(id, bill),HttpStatus.OK);
	}
	
	
	@GetMapping(value="/bill/cust/{customerId}")
	public ResponseEntity<?> getBillByCustomerId(@PathVariable long customerId) {
		
		System.out.println(customerId);
		return new ResponseEntity<>(billService.getBillByCustomerId(customerId),HttpStatus.OK);
	}
	
	@GetMapping(value="/allbills")
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}
	
	
	@DeleteMapping(value="/bill/delete/{id}")
	
	public ResponseEntity<String> deleteBill(@PathVariable long id){
		return new ResponseEntity<String>(billService.deleteBill(id),HttpStatus.OK);
	}

}
