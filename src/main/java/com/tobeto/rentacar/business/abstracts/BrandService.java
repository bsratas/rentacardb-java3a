package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.brand.CreatedBrandRequest;
import com.tobeto.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.GetAllBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreatedBrandRequest createBrandRequest);

    List<GetAllBrandResponse> getAll();

}
