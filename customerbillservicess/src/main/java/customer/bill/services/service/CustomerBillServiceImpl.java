package customer.bill.services.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customer.bill.services.entity.Bill;
import customer.bill.services.entity.Customer;
import customer.bill.services.exception.BusinessException;

@Service
public class CustomerBillServiceImpl implements CustomerBillService {

	private static final Logger log = LoggerFactory.getLogger(CustomerBillServiceImpl.class);

	@Autowired
	CustomerWebService custWebService;

	@Autowired
	BillWebService billwebservice;

	@Override
	public List<Customer> getCustomers() {

		List<Customer> custList = custWebService.getAllCustomer();
		if (custList.isEmpty()) {

			throw new BusinessException("601", "Customer List is Empty");
		}
		System.out.println(custList);
		for (Customer cust : custList) {

			System.out.println(cust.getCustId());
			cust.setBill(billwebservice.getBillByCustomerId(cust.getCustId()));
		}

		return custList;
	}

	@Override
	public Customer addCustomerBill(Customer customer) {
		
		System.out.println(customer);
		Bill b1 = new Bill();
//	
		if (customer.getCustId() != customer.getBill().getCustomerId()) {
			throw new BusinessException("720", "Customer Id's should be same");
		} else {

			b1 = customer.getBill();
			System.out.println(b1.getCustomerId());
			b1.setCustomerId(customer.getCustId());

			System.out.println(b1);

			try {

				System.out.println(customer.getCustName());

				custWebService.createCustomer(customer);

				System.out.println(b1);
				customer.setBill(billwebservice.createBill(b1));

				return customer;

			} catch (IllegalArgumentException e) {

				throw new BusinessException("610", "given Cutomer is null" + e.getMessage());
			} catch (Exception e) {

				throw new BusinessException("611", "Something went wrong in service layer" + e.getMessage());
			}
		}
	}

	@Override
	public Customer updateCustomer(long id, Customer cust) {

		Customer updaCustomer = null;
		Bill updatedBill = null;

		System.out.println(id + " " + cust);
		Bill b = cust.getBill();

		try {

			updatedBill = billwebservice.updateBill(b.getBillId(), b);

			updaCustomer = custWebService.updateCustomer(id, cust);

			updaCustomer.setBill(updatedBill);

		} catch (IllegalArgumentException e) {
			throw new BusinessException("607", "given employee id is either null or not present " + e.getMessage());
		} catch (NoSuchElementException e) {

			throw new BusinessException("608", "given employee id dosen't exist in DB" + e.getMessage());

		}

		return updaCustomer;
	}

	@Override
	public String deleteCustomer(long id) {
		if (id == 0) {
			throw new BusinessException("605", "send the id to delete");
		}

		try {
			custWebService.deleteCustomer(id);
			billwebservice.deleteBill(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "given employee id is null please send some id" + e.getMessage());
		}

		return "deleted";
	}

}
