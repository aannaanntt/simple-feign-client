package customer.bill.services.entity;

import javax.annotation.Generated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

@Data
@Getter
@Setter

@NoArgsConstructor
public class Bill {

	@NotNull(message = "bill id cannot be empty")
	@NotBlank

	private String billId;
	@Max(value = 10)
	@Min(value = 2)
	private int totalDays;

	@NotNull(message = "Invalid cost")
	@NotBlank
	private String totalCost;

	private long customerId;

}
