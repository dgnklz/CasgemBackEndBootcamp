package kodlama.io.rentACar.business.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
	private String model;
	private int unitsInStok;
	private int unitPrice;
	private int brandId;
}
