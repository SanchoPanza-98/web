package ru.omsu.imit.rest.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInPurchaseRequest;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInPurchaseResponse;
import ru.omsu.imit.spring_service.SelectedProductPurchaseServiceSpring;

@RestController
public class SelectedProductInPurchaseEndpoints {
    private final SelectedProductPurchaseServiceSpring service;

    @Autowired
    public SelectedProductInPurchaseEndpoints(SelectedProductPurchaseServiceSpring productServiceSpring){
        service = productServiceSpring;
    }

    @PostMapping(value = "/api/selectedProductsInPurchase",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public SelectedProductInPurchaseResponse addProductInPurchase(@RequestBody SelectedProductInPurchaseRequest request){
        return service.addProductInPurchase(request);
    }
}
