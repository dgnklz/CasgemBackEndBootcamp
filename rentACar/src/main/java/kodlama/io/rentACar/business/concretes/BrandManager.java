package kodlama.io.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.brand.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.brand.DeleteBrandRequest;
import kodlama.io.rentACar.business.requests.brand.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.brand.CreateBrandResponse;
import kodlama.io.rentACar.business.responses.brand.DeleteBrandResponse;
import kodlama.io.rentACar.business.responses.brand.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.brand.UpdateBrandResponse;
import kodlama.io.rentACar.core.utilities.mapping.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {
//		List<Brand> brands = brandRepository.findAll();
//		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//		for (Brand brand : brands) {
//			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//			responseItem.setId(brand.getId());
//			responseItem.setName(brand.getName());
//			brandsResponse.add(responseItem);
//		}
		
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponse> brandsResponses = new ArrayList<>();
		
		for (Brand brand : brands) {
			GetAllBrandsResponse responseItem = this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class);
			brandsResponses.add(responseItem);
		}
		
		return brandsResponses;
	}

	@Override
	public CreateBrandResponse add(CreateBrandRequest createBrandRequest) {

		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		brandRepository.save(brand);
		
		CreateBrandResponse brandResponse = this.modelMapperService.forResponse().map(brand, CreateBrandResponse.class);
		
		return brandResponse;
	}

	@Override
	public UpdateBrandResponse update(UpdateBrandRequest updateBrandRequest) {
//		Brand brand = brandRepository.findById(updateBrandRequest.getId()).get();
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		brandRepository.save(brand);
		UpdateBrandResponse brandResponse = this.modelMapperService.forResponse().map(brand, UpdateBrandResponse.class);
		return brandResponse;
	}

	@Override
	public DeleteBrandResponse delete(DeleteBrandRequest deleteBrandRequest) {
//		Brand brand = brandRepository.findById(deleteBrandRequest.getId()).get();
		Brand brand = this.modelMapperService.forRequest().map(deleteBrandRequest, Brand.class);
		brandRepository.delete(brand);
		DeleteBrandResponse brandResponse = this.modelMapperService.forResponse().map(brand, DeleteBrandResponse.class);
		return brandResponse;
	}
	
}
