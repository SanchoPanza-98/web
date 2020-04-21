package ru.omsu.imit.rest.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.dto.response.BuyerResponse;
import ru.omsu.imit.dto.response.ListSelectedProductsPurchaseResponse;
import ru.omsu.imit.dto.response.ListSelectedProductsResponse;
import ru.omsu.imit.spring_service.BuyerServiceSpring;

import java.util.List;

@RestController

public class BuyerEndpoints {

    private final BuyerServiceSpring buyerServiceSpring;

    @Autowired
    public BuyerEndpoints(BuyerServiceSpring buyerService){
        this.buyerServiceSpring = buyerService;
    }

    @PostMapping(value = "/api/buyer", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BuyerResponse createBuyer(@RequestBody BuyerRequest request){
        return buyerServiceSpring.createBuyer(request);

    }

    @PutMapping(value = "/api/buyer/{buyerId}", produces ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BuyerResponse updateBuyer(@PathVariable("buyerId") int buyerId
            ,@RequestBody BuyerRequest request){
        return buyerServiceSpring.updateBuyer(buyerId,request);

    }

    @GetMapping(value = "/api/buyers", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<BuyerResponse> getBuyers(){
        return buyerServiceSpring.getAllBuyers();

    }

    @GetMapping(value = "/api/buyer/{buyerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BuyerResponse getBuyerById(@PathVariable("buyerId") int buyerId){
        return buyerServiceSpring.getBuyerById(buyerId);

    }

    @GetMapping(value = "/api/buyer/{buyerId}/purchase", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListSelectedProductsPurchaseResponse getPurchasesByBuyerId(@PathVariable("buyerId") int buyerId){
        return buyerServiceSpring.getAllPurchases(buyerId);
    }

    @GetMapping(value = "/api/buyer/{buyerId}/basket", produces = MediaType.APPLICATION_JSON_VALUE)
    public ListSelectedProductsResponse getBasketByBuyerId(@PathVariable("buyerId") int buyerId){
        return buyerServiceSpring.getAllProductsInBasket(buyerId);
    }

    @DeleteMapping(value = "/api/buyer/{buyerId}", produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void  deleteBuyerById(@PathVariable("buyerId") int buyerId){
         buyerServiceSpring.deleteBuyer(buyerId);

    }



       /* @RequestMapping("/")
        @ResponseBody
        String hello() {
            return "Hello World!";
        }*/



}
