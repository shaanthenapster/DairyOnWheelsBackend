package com.dairy.api;

import com.dairy.enums.BrandCategory;
import com.dairy.enums.SuccessCodes;
import com.dairy.exception.CustomException;
import com.dairy.exception.ProductUploadException;
import com.dairy.exception.UserException;
import com.dairy.model.Products;
import com.dairy.requestDto.ProductUploadRequestDto;
import com.dairy.responseDto.ErrorResponseDto;
import com.dairy.responseDto.SuccessResponseDto;
import com.dairy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @PostMapping("/api/product")
    public ResponseEntity<?> addProducts(@RequestBody ProductUploadRequestDto dto) {

//        SuccessResponseDto srdto = new SuccessResponseDto();
//        ErrorResponseDto erdto = new ErrorResponseDto();
//
//        if (StringUtils.isEmpty(dto.getProductName()) || StringUtils.isEmpty(dto.getProductPrice()) || StringUtils.isEmpty(dto.getInventoryCount()) ||
//                StringUtils.isEmpty(dto.getProductDescription()))
//            throw new UserException("REQUIRED FILEDS MISSING", CustomException.INVALID_PARAMETERS);
//
//        Optional<String> productId = productService.insertProduct(dto);
//
//        if (productId.isPresent()) {
//            srdto.setSuccessCode(SuccessCodes.API_SUCCESS);
//            srdto.getExtraData().put("PRODUCT_ID", productId);
//            return ResponseEntity.ok().body(srdto);
//        }

        throw new ProductUploadException("PRODUCT_UPLOAD_FAILED",HttpStatus.EXPECTATION_FAILED,CustomException.PRODUCT_SAVE_FAILED);
    }

    @GetMapping("/product")
    public ResponseEntity<?> showProductById(@RequestParam String productId) throws UserException {
        SuccessResponseDto srdto = new SuccessResponseDto();
        ErrorResponseDto erdto = new ErrorResponseDto();

        Optional<Products> products = productService.viewProductByProductId(productId);

        if (products.isPresent()) {
            srdto.setSuccessCode(SuccessCodes.API_SUCCESS);
            srdto.getExtraData().put("PRODUCT", products);
            return ResponseEntity.ok().body(srdto);
        } else {
            erdto.setException(CustomException.PRODUCT_NOT_FOUND);
//            erdto.getMsg().add("INVALID_PRODUCT_ID");
            return ResponseEntity.ok().body(erdto);
        }
    }

    @GetMapping("/product/showAll")
    public ResponseEntity<?> showAllProducts() throws UserException {
        SuccessResponseDto srdto = new SuccessResponseDto();
        ErrorResponseDto erdto = new ErrorResponseDto();

        List<Products> products = productService.showAllProducts();

        if (!products.isEmpty()) {
            srdto.setSuccessCode(SuccessCodes.API_SUCCESS);
            srdto.getExtraData().put("PRODUCT", products);
            return ResponseEntity.ok().body(srdto);
        } else {
            erdto.setException(CustomException.PRODUCT_NOT_FOUND);
//            erdto.getMsg().add("INVALID_PRODUCT_ID");
            return ResponseEntity.ok().body(erdto);
        }
    }

    @GetMapping("/product/type")
    public ResponseEntity<?> showProductByType(@RequestParam int type) throws UserException {

        SuccessResponseDto srdto = new SuccessResponseDto();
        ErrorResponseDto erdto = new ErrorResponseDto();

        Optional<List<Products>> products = productService.viewProductByProductType(type);

        if(products.isPresent()){
            srdto.setSuccessCode(SuccessCodes.API_SUCCESS);
            srdto.getExtraData().put("PRODUCTS" , products);
            return ResponseEntity.ok().body(srdto);
        } else {
            erdto.setException(CustomException.PRODUCT_NOT_FOUND);
//            erdto.getMsg().add("NO_PRODUCT_FOUND_IN_SPECIFIED_TYPE");
            return ResponseEntity.ok().body(erdto);
        }
    }

    @DeleteMapping("/api/product")
    public ResponseEntity<?> deleteProductById(@RequestParam String id) throws UserException {
        SuccessResponseDto srdto = new SuccessResponseDto();
        ErrorResponseDto erdto = new ErrorResponseDto();

      boolean products = productService.removeProductByProductId(id);

        if(products){
            srdto.setSuccessCode(SuccessCodes.API_SUCCESS);
            srdto.getExtraData().put("PRODUCT REMOVED" , products);
            return ResponseEntity.ok().body(srdto);
        } else {
            erdto.setException(CustomException.PRODUCT_NOT_FOUND);
//            erdto.getMsg().add("NO_PRODUCT_EXIST_WITH_SPECIFIED_ID");
            return ResponseEntity.ok().body(erdto);
        }

    }

    @GetMapping("/product/available")
    public ResponseEntity<?> showAllAvailableProducts() throws UserException {

        SuccessResponseDto srdto = new SuccessResponseDto();
        ErrorResponseDto erdto = new ErrorResponseDto();

        List<Products> products = productService.showAllAvailableProducts();

        if(products.isEmpty()){
            erdto.setException(CustomException.PRODUCT_NOT_AVALIABLE);
//            erdto.getMsg().add("NO PRODUCTS AVALIABLE");
            return ResponseEntity.ok().body(erdto);
        }else {
            srdto.setSuccessCode(SuccessCodes.API_SUCCESS);
            srdto.getExtraData()
                    .put("PRODUCTS" , products);
            return ResponseEntity.ok().body(srdto);
        }

    }

    @GetMapping("/product/brand")
    public ResponseEntity<?> showProductsByBrand(@RequestParam BrandCategory brandCategory) throws UserException {

        SuccessResponseDto srdto = new SuccessResponseDto();
        ErrorResponseDto erdto = new ErrorResponseDto();

        List<Products> products = productService.showProductsByBrand(brandCategory);

        if(products.isEmpty()){
            erdto.setException(CustomException.PRODUCT_NOT_AVALIABLE);
//            erdto.getMsg().add("NO PRODUCTS AVALIABLE OF GIVEN BRAND");
            return ResponseEntity.ok().body(erdto);
        }else {
            srdto.setSuccessCode(SuccessCodes.API_SUCCESS);
            srdto.getExtraData().put("PRODUCTS" , products);
            return ResponseEntity.ok().body(srdto);
        }

    }
}
