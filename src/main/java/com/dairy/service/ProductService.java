package com.dairy.service;

import com.dairy.enums.*;
import com.dairy.exception.CustomException;
import com.dairy.exception.UserException;
import com.dairy.model.Products;
import com.dairy.repository.ProductRepo;
import com.dairy.requestDto.ProductUploadRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService{

 @Autowired
 ProductRepo productRepo;


 // Save a single product , Returns the Product Custom id
 @Transactional(rollbackFor = UserException.class)
 public synchronized Optional<String> insertProduct(ProductUploadRequestDto dto) throws UserException {

     Products products = new Products();
     products.setProductId(UtilityServices.productIdgenerator(0));
     products.setProductName(dto.getProductName());
     products.setProductDescription(dto.getProductDescription());
     products.setProductImage(dto.getProductImage());
     products.setProductCategory(ProductCategory.valueOf(dto.getProductCategory()));
     products.setProductType(ProductType.valueOf(dto.getProductType()));
     products.setProductPrice(dto.getProductPrice());
     products.setDiscount(dto.getDiscount());
     products.setInventoryCount(dto.getInventoryCount());
     products.setProductPackagingWeight(ProductPackagingWeight.valueOf(dto.getProductSizeVariant()));
     products.setBrandCategory(BrandCategory.valueOf(dto.getBrandType()));

     if(dto.getInventoryCount() > 0)
         products.setProductAvailability(ProductAvailability.AVAILABILE);
     else
         products.setProductAvailability(ProductAvailability.OUT_OF_STOCK);

     products = productRepo.save(products);

     if(products != null)
         return Optional.ofNullable(products.getProductId());
     else
         throw new UserException("Failed to save Product" , CustomException.PRODUCT_SAVE_FAILED);

 }


 // todo: handle fatal exception in case of no product found with specified ID
 @Transactional
 public Optional<Products> viewProductByProductId(String productId) throws UserException {

     Optional<Products> products = Optional.ofNullable(productRepo.findByProductId(productId));

     if(productId.equals(products.get().getProductId()))
         return products;

     else
         throw new UserException("NO PRODUCT FOUND WITH SPECIFIED ID" ,CustomException.PRODUCT_NOT_FOUND);
 }

 public Optional<List<Products>> viewProductByProductType(int productType) throws UserException {

     Optional<Optional<List<Products>>> products = Optional.ofNullable(productRepo.findByProductType(ProductType.valueOf(productType)));

     if(products.isPresent())
         return products.get();

     else
         throw new UserException("NO PRODUCTS FOUND IN THE SPECIFIED TYPE" ,CustomException.PRODUCT_NOT_FOUND);

 }

 public boolean removeProductByProductId(String id) throws UserException {

     Optional<Products> products = Optional.ofNullable(productRepo.findByProductId(id));

     if(products.isPresent())
     {
         productRepo.deleteByProductId(id);
         return true;
     }
     else
         throw new UserException("NO PRODUCT FOUND WITH SPECIFIED ID", CustomException.PRODUCT_NOT_FOUND);

 }

 public List<Products> showAllAvailableProducts() throws UserException {

     List<Products> products = productRepo.findByProductAvailability(ProductAvailability.AVAILABILE);
     return products;
 }

 public List<Products> showAllProducts() throws UserException {

     List<Products> products = productRepo.findAll();
     return products;
 }

 public List<Products> showProductsByBrand(BrandCategory brandCategory) throws UserException {



     List<Products> products = productRepo.findByBrandCategory(brandCategory);
     return products;
 }

}
