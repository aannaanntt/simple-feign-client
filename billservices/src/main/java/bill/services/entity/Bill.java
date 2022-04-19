package bill.services.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {

	@Id
	private long billId;

	private int totalDays;

	private int totalCost;
	
	
	private long customerId; //->0

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(long billId, int totalDays, int totalCost, long customerId) {
		super();
		this.billId = billId;
		this.totalDays = totalDays;
		this.totalCost = totalCost;
		this.customerId = customerId;
	}

	public long getBillId() {
		return billId;
	}

	public void setBillId(long billId) {
		this.billId = billId;
	}

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
	
		this.customerId =customerId;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", totalDays=" + totalDays + ", totalCost=" + totalCost + ", customerId="
				+ customerId + "]";
	}

}
