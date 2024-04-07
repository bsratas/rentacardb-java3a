package com.tobeto.rentacar.api.controllers;

import com.tobeto.rentacar.business.abstracts.BrandService;
import com.tobeto.rentacar.business.dtos.requests.brand.CreatedBrandRequest;
import com.tobeto.rentacar.business.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacar.business.dtos.responses.brand.CreatedBrandResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.GetAllBrandResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.GetBrandByIdResponse;
import com.tobeto.rentacar.business.dtos.responses.brand.UpdateBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {
    private BrandService brandService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@RequestBody @Valid CreatedBrandRequest request) {
        return brandService.add(request);
    }

    @GetMapping("getall")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandByIdResponse getBrandById(
            @PathVariable int id
    ){
        return brandService.getBrandById(id);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse updateBrandById(
            @RequestBody UpdateBrandRequest request,
            @PathVariable int id
    ) {
        return brandService.updateBrandById(request,id);
    }

    @DeleteMapping("/{id}")
    void deleteBrandById(
            @PathVariable int id
    ){
        brandService.deleteBrandById(id);
    }
}
