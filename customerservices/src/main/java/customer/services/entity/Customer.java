package customer.services.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cust")
public class Customer {
	@Id
	private long custId;
	private String custName;
	private float salary;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(long custId, String custName, float salary) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.salary = salary;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", salary=" + salary + "]";
	}

}
