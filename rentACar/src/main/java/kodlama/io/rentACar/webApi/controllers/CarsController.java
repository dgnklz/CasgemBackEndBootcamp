package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.car.CreateCarRequest;
import kodlama.io.rentACar.business.requests.car.DeleteCarRequest;
import kodlama.io.rentACar.business.requests.car.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.car.CreateCarResponse;
import kodlama.io.rentACar.business.responses.car.DeleteCarResponse;
import kodlama.io.rentACar.business.responses.car.GetAllCarResponse;
import kodlama.io.rentACar.business.responses.car.UpdateCarResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarsController {
	private CarService carService;
	
	@GetMapping("/getAll")
	public List<GetAllCarResponse> getAll(){
		return carService.getAll();
	}
	
	@PostMapping("/add")
	public CreateCarResponse add(@RequestBody CreateCarRequest createCarRequest) {
		return carService.add(createCarRequest);
	}
	
	@PutMapping("/update")
	public UpdateCarResponse update(@RequestBody UpdateCarRequest updateCarRequest) {
		return carService.update(updateCarRequest);
	}
	
	@DeleteMapping("/delete")
	public DeleteCarResponse delete(@RequestBody DeleteCarRequest deleteCarRequest) {
		return carService.delete(deleteCarRequest);
	}
}
