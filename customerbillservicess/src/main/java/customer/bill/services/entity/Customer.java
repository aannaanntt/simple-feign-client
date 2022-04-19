package customer.bill.services.entity;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;


@Data
@Getter
@Setter

@NoArgsConstructor
public class Customer {
	

	private long custId;
	
	@NotNull(message="customer name cannot be empty")
	private String custName;
	
	@Max(value=1000000,message = "value can't be greater than 1000000")
	private float salary;
	
	@NotNull(message="bill cannot be null")
	@Valid
	private Bill bill;

	

}
