package com.dairy.service;

import com.dairy.RequestDto.ProductUploadRequestDto;
import com.dairy.enums.ProductAvailability;
import com.dairy.enums.ProductCategory;
import com.dairy.enums.ProductType;
import com.dairy.exception.CustomException;
import com.dairy.exception.UserException;
import com.dairy.model.Products;
import com.dairy.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService{

 @Autowired
 static ProductRepo productRepo;


 // Save a single product , Returns the Product Custom id
 @Transactional(rollbackFor = UserException.class)
 public synchronized Optional<String> insertProduct(ProductUploadRequestDto dto) throws UserException {

     Optional<Products> products = Optional.of(new Products());
     products.get().setProductId(UtilityServices.productIdgenerator(0));
     products.get().setProductName(dto.getProductName());
     products.get().setProductDescription(dto.getProductDescription());
     products.get().setProductImage(dto.getProductImage());
     products.get().setProductCategory(ProductCategory.valueOf(dto.getProductCategory()));
     products.get().setProductType(ProductType.valueOf(dto.getProductType()));
     products.get().setProductPrice(dto.getProductPrice());
     products.get().setProductAvailability(ProductAvailability.valueOf(dto.getProductAvailability()));
     products.get().setDiscount(dto.getDiscount());
     products.get().setInventoryCount(dto.getInventoryCount());
     products = productRepo.save(products.get());

     if(products.isPresent())
         return Optional.ofNullable(products.get().getProductId());
     else
         throw new UserException("Failed to save Product" , CustomException.PRODUCT_SAVE_FAILED);

 }

 public static Optional<Products> viewProductByProductId(String productId) throws UserException {

     Optional<Products> products = Optional.ofNullable(productRepo.findByProductId(productId));

     if(productId.equals(products.get().getProductId()))
         return products;

     else
         throw new UserException("NO PRODUCT FOUND WITH SPECIFIED ID" ,CustomException.PRODUCT_NOT_FOUND);
 }

 public static Optional<Products> viewProductByProductType(int productType) throws UserException {

     Optional<Products> products = Optional.ofNullable(productRepo.findByProductType(ProductType.valueOf(productType)));

     if(products.isPresent())
         return products;

     else
         throw new UserException("NO PRODUCTS FOUND IN THE SPECIFIED TYPE" ,CustomException.PRODUCT_NOT_FOUND);

 }

 public static boolean removeProductByProductId(String id){

 }







}
