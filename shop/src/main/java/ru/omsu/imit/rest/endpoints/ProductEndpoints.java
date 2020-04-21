package ru.omsu.imit.rest.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.omsu.imit.dto.request.ProductRequest;
import ru.omsu.imit.dto.response.BuyerResponse;
import ru.omsu.imit.dto.response.ProductResponse;
import ru.omsu.imit.spring_service.ProductServiceSpring;

import java.util.List;

@RestController
public class ProductEndpoints {

    private final ProductServiceSpring productServiceSpring;

    @Autowired
    public ProductEndpoints(ProductServiceSpring productServiceSpring){
        this.productServiceSpring = productServiceSpring;
    }

    @PostMapping(value = "/api/product",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse insertProductSpring(@RequestBody ProductRequest request){
        return productServiceSpring.addProduct(request);
    }

    @PutMapping(value = "/api/product/{productId}", produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ProductResponse updateProduct(@PathVariable("productId") int productId
            ,@RequestBody ProductRequest request){
        return productServiceSpring.updateProduct(productId,request);
    }

    @GetMapping(value = "/api/products", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<ProductResponse> getProducts(){
        return productServiceSpring.getAllProducts();

    }

    @GetMapping(value = "/api/productget/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductResponse getProductById(@PathVariable("productId") int productId){
        return productServiceSpring.getProductById(productId);
    }

    @GetMapping(value = "/api/productsget/{productName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> getProductByName(@PathVariable("productName") String productName){
        return  productServiceSpring.getProductsByProductName(productName);
    }
}
