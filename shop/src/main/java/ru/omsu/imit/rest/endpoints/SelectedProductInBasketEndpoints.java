package ru.omsu.imit.rest.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInBasketRequest;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInPurchaseRequest;
import ru.omsu.imit.dto.response.ProductResponse;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInBasketResponse;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInPurchaseResponse;
import ru.omsu.imit.spring_service.SelectedProductInBasketService;
import ru.omsu.imit.spring_service.SelectedProductPurchaseServiceSpring;

import java.util.List;

@RestController
public class SelectedProductInBasketEndpoints {
    private final SelectedProductInBasketService service;

    @Autowired
    public SelectedProductInBasketEndpoints(SelectedProductInBasketService productServiceSpring){
        service = productServiceSpring;
    }

    @PostMapping(value = "/api/selectedProductsInBasket",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SelectedProductInBasketResponse addProductInBasket(@RequestBody SelectedProductInBasketRequest request){
        return service.addProductInBasket(request);
    }

    @GetMapping(value = "/api/basket/products/{buyerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductResponse> getProductsInBasket(@PathVariable("buyerId") int buyerId){
        return service.getProductsInBasket(buyerId);
    }

}
