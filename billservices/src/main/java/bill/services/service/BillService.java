package bill.services.service;

import java.util.List;

import bill.services.entity.Bill;

public interface BillService {
	
	public List<Bill> getAllBills();
	
	public Bill createBill(Bill bill);
	
	public Bill getBillByCustomerId(long custId);
	
	public Bill updateBill(long id,Bill bill);
	
	public String deleteBill(long id);

}
