package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.io.rentACar.entities.concretes.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
//	List<Brand> findByModel(String model);
}
