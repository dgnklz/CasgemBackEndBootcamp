package kodlama.io.rentACar.business.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarResponse {
	private int id;
	private String model;
	private int unitsInStok;
	private int unitPrice;
	private int brandId;
}
