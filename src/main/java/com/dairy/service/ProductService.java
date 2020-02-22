package com.dairy.service;

import com.dairy.RequestDto.ProductUploadRequestDto;
import com.dairy.model.Products;
import com.dairy.repository.ProductRepo;
import com.mongodb.gridfs.GridFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

@Autowired
ProductRepo productRepo;

 public boolean insertProduct(ProductUploadRequestDto dto){

     Products products = new Products();
     products.setProductId(UtilityServices.productIdgenerator(0));
     products.setProductName(dto.getProductName());
     products.setProductDescription(dto.getProductDescription());









     return true;
 }





}
