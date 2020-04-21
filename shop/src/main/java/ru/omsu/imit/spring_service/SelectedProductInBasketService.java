package ru.omsu.imit.spring_service;

import org.springframework.stereotype.Service;
import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInBasketRequest;
import ru.omsu.imit.dto.response.BasketResponse;
import ru.omsu.imit.dto.response.BuyerResponse;
import ru.omsu.imit.dto.response.ProductResponse;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInBasketResponse;
import ru.omsu.imit.exceptions.ProjectException;
import ru.omsu.imit.model.Basket;
import ru.omsu.imit.model.Buyer;
import ru.omsu.imit.model.Product;
import ru.omsu.imit.model.SelectedProductInBasket;
import ru.omsu.imit.utils.ProjectErrorCode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class SelectedProductInBasketService extends BaseService {


    public SelectedProductInBasketResponse addProductInBasket(SelectedProductInBasketRequest request){
        try {
            //SelectedProductInBasketRequest request = ListUtils.getClassInstanceFromJson(GSON, json,SelectedProductInBasketRequest.class);
            if (request.getQuantity()<=0){
                throw new ProjectException(ProjectErrorCode.WRONG_QUANTITY);
            }
            if(request.getBasket()==null){
                throw new ProjectException(ProjectErrorCode.NULL_BASKET);
            }
            BuyerRequest buyerRequest = request.getBasket().getBuyer();
            Buyer buyer = new Buyer(buyerRequest.getId(),0,buyerRequest.getFirstName(),buyerRequest.getSecondName()
                    ,buyerRequest.getPatronymic(), buyerRequest.getBirthday(),buyerRequest.getEmail()
                    ,buyerRequest.getLogin(),buyerRequest.getPassword()
                    ,buyerRequest.getTelephoneNum());
            Basket basket = new Basket(request.getBasket().getId(),buyer);
            Product product = new Product(request.getProduct().getId(),request.getProduct().getCost()
                    ,request.getProduct().getProductName());
            SelectedProductInBasket selectedProduct = new SelectedProductInBasket(request.getId(),basket,product
                    ,request.getQuantity());
            SelectedProductInBasket addedProduct = productInBasketDAO.insert(selectedProduct);

            ProductResponse productResponse = new ProductResponse(request.getProduct().getId()
                    ,request.getProduct().getCost(),request.getProduct().getProductName());
            BuyerResponse buyerResponse = new BuyerResponse(buyerRequest.getId(),buyerRequest.getFirstName(),buyerRequest.getSecondName()
                    ,buyerRequest.getPatronymic(), buyerRequest.getBirthday(),buyerRequest.getEmail(),buyerRequest.getLogin()
                    ,buyerRequest.getTelephoneNum());
            BasketResponse basketResponse = new BasketResponse(request.getBasket().getId(),buyerResponse);
            SelectedProductInBasketResponse selectedProductBasketResponse = new SelectedProductInBasketResponse(addedProduct.getId(),
                    basketResponse,productResponse,request.getQuantity());

            return selectedProductBasketResponse;
        } catch (ProjectException ex) {
            return null;
        }
    }

    public SelectedProductInBasketResponse deleteProductFromBasket(SelectedProductInBasketRequest request){

            Product product = new Product(request.getProduct().getId(),request.getProduct().getCost()
                    ,request.getProduct().getProductName());
            BuyerRequest buyerRequest = request.getBasket().getBuyer();
            Buyer buyer = new Buyer(buyerRequest.getId(),0,buyerRequest.getFirstName(),buyerRequest.getSecondName()
                    ,buyerRequest.getPatronymic(), buyerRequest.getBirthday(),buyerRequest.getEmail()
                    ,buyerRequest.getLogin(),buyerRequest.getPassword()
                    ,buyerRequest.getTelephoneNum());
            Basket basket = new Basket(request.getBasket().getId(),buyer);
            SelectedProductInBasket productInBasket = new SelectedProductInBasket(request.getId(),basket,product,request.getQuantity());

            SelectedProductInBasket deletedProduct = productInBasketDAO.deleteById(productInBasket);
            ProductResponse productResponse = new ProductResponse(request.getProduct().getId()
                    ,request.getProduct().getCost(),request.getProduct().getProductName());
            BuyerResponse buyerResponse = new BuyerResponse(buyerRequest.getId(),buyerRequest.getFirstName(),buyerRequest.getSecondName()
                    ,buyerRequest.getPatronymic(), buyerRequest.getBirthday(),buyerRequest.getEmail(),
                    buyerRequest.getLogin()
                    ,buyerRequest.getTelephoneNum());
            BasketResponse basketResponse = new BasketResponse(request.getBasket().getId(),buyerResponse);
            SelectedProductInBasketResponse selectedProductBasketResponse = new SelectedProductInBasketResponse(deletedProduct.getId(),
                    basketResponse,productResponse,request.getQuantity());
            return selectedProductBasketResponse;

    }


    public List<ProductResponse> getProductsInBasket(int buyerId) {
        Basket basket = basketDAO.getByBuyer(buyerId);
        if (basket == null){
            return null;
        }
        List<SelectedProductInBasket> products = productInBasketDAO.getByBasket(basket);
        if (products == null){
            return null;
        }
        List<ProductResponse> productsResponse = new ArrayList<>();
        for (SelectedProductInBasket item: products){
            productsResponse.add(new ProductResponse(item.getProduct().getId(),item.getProduct().getCost()
                    ,item.getProduct().getProductName()));
        }
        return productsResponse;
    }
}
