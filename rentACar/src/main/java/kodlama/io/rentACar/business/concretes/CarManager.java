package kodlama.io.rentACar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.car.CreateCarRequest;
import kodlama.io.rentACar.business.requests.car.DeleteCarRequest;
import kodlama.io.rentACar.business.requests.car.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.CreateCarResponse;
import kodlama.io.rentACar.business.responses.car.DeleteCarResponse;
import kodlama.io.rentACar.business.responses.car.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.car.UpdateCarResponse;
import kodlama.io.rentACar.core.utilities.mapping.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CarManager implements CarService{

	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllCarResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		
//		List<GetAllCarResponse> carResponses = new ArrayList<>();
//		for (Car car : cars) {
//			GetAllCarResponse responseItem = this.modelMapperService.forResponse().map(car, GetAllCarResponse.class);
//			carResponses.add(responseItem);
//		}
		
		List<GetAllCarResponse> carResponses = cars.stream()
				.map(car->modelMapperService.forResponse()
						.map(car, GetAllCarResponse.class)).toList();
		return carResponses;
	}
	
	
	@Override
	public CreateCarResponse add(CreateCarRequest createCarRequest) {
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		
		carRepository.save(car);
		
		CreateCarResponse carResponse = this.modelMapperService.forResponse().map(car, CreateCarResponse.class);
		return carResponse;
	}
	
	@Override
	public UpdateCarResponse update(UpdateCarRequest updateCarRequest) {
		Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		
		carRepository.save(car);
		
		UpdateCarResponse carResponse = this.modelMapperService.forResponse().map(car, UpdateCarResponse.class);
		
		return carResponse;
	}

	@Override
	public DeleteCarResponse delete(DeleteCarRequest deleteCarRequest) {
		Car car = this.modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		
		carRepository.delete(car);
		
		DeleteCarResponse carResponse = this.modelMapperService.forResponse().map(car, DeleteCarResponse.class);
		return carResponse;
	}
	
}
