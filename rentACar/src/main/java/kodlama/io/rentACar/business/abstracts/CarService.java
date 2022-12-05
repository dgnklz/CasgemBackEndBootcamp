package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.car.CreateCarRequest;
import kodlama.io.rentACar.business.requests.car.DeleteCarRequest;
import kodlama.io.rentACar.business.requests.car.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.CreateCarResponse;
import kodlama.io.rentACar.business.responses.car.DeleteCarResponse;
import kodlama.io.rentACar.business.responses.car.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.car.UpdateCarResponse;

public interface CarService {
	List<GetAllCarResponse> getAll();
	CreateCarResponse add(CreateCarRequest createCarRequest);
	UpdateCarResponse update(UpdateCarRequest updateCarRequest);
	DeleteCarResponse delete(DeleteCarRequest deleteCarRequest);
}
