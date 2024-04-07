package com.tobeto.rentacar.business.concretes;

import com.tobeto.rentacar.business.abstracts.BrandService;
import com.tobeto.rentacar.business.dtos.requests.brand.CreatedBrandRequest;
import com.tobeto.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.GetAllBrandResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.GetBrandByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.UpdateBrandResponse;
import com.tobeto.rentacar.business.rules.BrandBusinessRules;
import com.tobeto.rentacar.core.utilities.mapping.ModelMapperService;
import com.tobeto.rentacar.dataAccess.abstracts.BrandRepository;
import com.tobeto.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;


    @Override
    public CreatedBrandResponse add(CreatedBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setCreatedDate(LocalDateTime.now());
        Brand createdBrand = this.brandRepository.save(brand);
        CreatedBrandResponse createdBrandResponse = this.modelMapperService.forResponse().map(createdBrand, CreatedBrandResponse.class);
        return createdBrandResponse;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand>  brands = brandRepository.findAll();
        List<GetAllBrandResponse> response = brands.stream().map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public GetBrandByIdResponse getBrandById(
            int id
    ) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this ID."));

        GetBrandByIdResponse response = modelMapperService.forResponse()
                .map(brand, GetBrandByIdResponse.class);

        return response;
    }

    @Override
    public UpdateBrandResponse updateBrandById(
            UpdateBrandRequest request,
            int id
    ) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this ID."));

        Brand updatedBrand = modelMapperService.forRequest()
                .map(request,Brand.class);

        brand.setId(id);
        brand.setUpdatedDate(LocalDateTime.now());

        brand.setName(updatedBrand.getName() != null ? updatedBrand.getName() : brand.getName());

        brandRepository.save(brand);

        UpdateBrandResponse response = modelMapperService.forResponse()
                .map(brand, UpdateBrandResponse.class);

        return response;

    }
    @Override
    public void deleteBrandById(
            int id
    ) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this ID."));

        brand.setDeletedDate(LocalDateTime.now());
        brandRepository.deleteById(id);
    }
}