package com.tobeto.rentacar.business.abstracts;

import com.tobeto.rentacar.business.dtos.requests.brand.CreatedBrandRequest;
import com.tobeto.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.GetAllBrandResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.GetBrandByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.UpdateBrandResponse;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreatedBrandRequest createBrandRequest);

    List<GetAllBrandResponse> getAll();

    GetBrandByIdResponse getBrandById(
            int id
    );
    UpdateBrandResponse updateBrandById(
            UpdateBrandRequest request,
            int id
    );
    void deleteBrandById(
            int id
    );
}
