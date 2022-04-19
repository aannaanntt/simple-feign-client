package customer.bill.services.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import customer.bill.services.entity.Customer;
import customer.bill.services.exception.BusinessException;
import customer.bill.services.exception.ControllerException;
import customer.bill.services.service.CustomerBillService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class CustomerBillController {

	@Autowired
	CustomerBillService custbillservice;

	@Operation(summary = "get all customers")
	@ApiResponses(value= {@ApiResponse(responseCode = "500",description = "Internal server Error"),@ApiResponse(responseCode = "200",description = "ok")})
	@GetMapping(value = "/")
	public List<Customer> getCustomer() {
		
		return custbillservice.getCustomers();
	}
	
	@Operation(summary="Create a new customer")
	@ApiResponses(value= {@ApiResponse(responseCode = "500",description = "Internal Server Error"),@ApiResponse(responseCode ="200",description = "ok" )})
	@PostMapping(value = "/")
	public ResponseEntity<?> saveCustomer(@Valid @RequestBody Customer cust) {
		
		System.out.println(cust);

		try {

			return new ResponseEntity<Customer>(custbillservice.addCustomerBill(cust), HttpStatus.OK);

		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getDesc(), e.getErrorCode());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("611", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}
	
	@Operation(summary="Update Existing Customer")
	@ApiResponses(value= {@ApiResponse(responseCode = "500",description = "Internal Server Error"),@ApiResponse(responseCode ="200",description = "ok" )})

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateCustomer( @PathVariable long id, @RequestBody Customer cust) {

		try {
			return new ResponseEntity<>(custbillservice.updateCustomer(id, cust), HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getDesc(), e.getErrorCode());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException ce = new ControllerException("612", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary="delete a customer")
	@ApiResponses(value= {@ApiResponse(responseCode = "500",description = "Internal Server Error"),@ApiResponse(responseCode ="200",description = "ok" )})
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer( @PathVariable long id) {

		try {
			return new ResponseEntity<String>(custbillservice.deleteCustomer(id), HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getDesc(), e.getErrorCode());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			ControllerException ce = new ControllerException("613", "something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}

	}
}
