package bill.services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bill.services.entity.Bill;
import bill.services.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billrepo;

	@Override
	public List<Bill> getAllBills() {
		return billrepo.findAll();
	}

	@Override
	public Bill createBill(Bill bill) {
		System.out.println(bill);
	System.out.println(bill.getCustomerId());

		return billrepo.save(bill);

	}

	@Override
	public Bill getBillByCustomerId(long customerId) {

		System.out.println(customerId);
		return billrepo.getBillByCustomerId(customerId);
	}

	@Override
	public Bill updateBill(long id, Bill bill) {
		Bill bil = billrepo.findById(id).get();

		bil.setCustomerId(bill.getCustomerId());
		bil.setTotalCost(bill.getTotalCost());
		bil.setTotalDays(bill.getTotalDays());
		return billrepo.save(bil);
	}

	@Override
	public String deleteBill(long id) {

		billrepo.deleteById(id);
		return "Bill deleted";
	}

}
