package ru.omsu.imit.spring_service;

import org.springframework.stereotype.Service;
import ru.omsu.imit.dto.request.PurchaseRequest;
import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInPurchaseRequest;
import ru.omsu.imit.dto.response.BuyerResponse;
import ru.omsu.imit.dto.response.ProductResponse;
import ru.omsu.imit.dto.response.PurchaseResponse;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInPurchaseResponse;
import ru.omsu.imit.exceptions.ProjectException;
import ru.omsu.imit.model.Buyer;
import ru.omsu.imit.model.Product;
import ru.omsu.imit.model.Purchase;
import ru.omsu.imit.model.SelectedProductInPurchase;
import ru.omsu.imit.utils.ProjectErrorCode;

import java.sql.Date;
import java.sql.Timestamp;
@Service
public class SelectedProductPurchaseServiceSpring extends BaseService {

    public SelectedProductInPurchaseResponse addProductInPurchase(SelectedProductInPurchaseRequest request){
        try {
            //SelectedProductInPurchaseRequest request = ListUtils.getClassInstanceFromJson(GSON, json, SelectedProductInPurchaseRequest.class);
            if (request.getQuantity()<=0){
                throw new ProjectException(ProjectErrorCode.WRONG_QUANTITY);
            }
            if(request.getPurchase().getPayment()==null){
                throw new ProjectException(ProjectErrorCode.NULL_PAYMENT);
            }

            BuyerRequest buyerRequest = request.getPurchase().getBuyer();
            Buyer buyer = new Buyer (buyerRequest.getId(),0,buyerRequest.getFirstName(),buyerRequest.getSecondName()
                    ,buyerRequest.getPatronymic(), buyerRequest.getBirthday(),buyerRequest.getEmail()
                    ,buyerRequest.getLogin(),buyerRequest.getPassword(),
                    buyerRequest.getTelephoneNum());

            PurchaseRequest purchaseRequest = request.getPurchase();
            Purchase purchase =  new Purchase(purchaseRequest.getId(),buyer, Timestamp.valueOf(purchaseRequest.getPurchaseDate()),
                    purchaseRequest.getPayment().toString());
            Purchase addedPurchase = purchaseDAO.insert(purchase);

            Product product = new Product(request.getProduct().getId(),request.getProduct().getCost(),
                    request.getProduct().getProductName());

            SelectedProductInPurchase selectedProduct = new SelectedProductInPurchase(1,addedPurchase,product,request.getQuantity());
            SelectedProductInPurchase  addedSelectedProduct = productInPurchaseDAO.insert(selectedProduct);

            int sumPurchase = purchaseDAO.getSumPurchase(addedPurchase);
            Purchase updatedPurchase = purchaseDAO.updateSum(addedPurchase,sumPurchase);


            BuyerResponse buyerResponse = new BuyerResponse(buyer.getId(),buyer.getFirstName(),buyer.getSecondName()
                    ,buyer.getPatronymic(), buyer.getBirthday(),buyer.getEmail(),buyer.getLogin());
            ProductResponse productResponse = new ProductResponse(request.getProduct().getId()
                    ,request.getProduct().getCost(),request.getProduct().getProductName());
            PurchaseResponse purchaseResponse = new PurchaseResponse(updatedPurchase.getId(),buyerResponse
                    ,Timestamp.valueOf(updatedPurchase.getPurchaseDate()),updatedPurchase.getPayment().toString());

            SelectedProductInPurchaseResponse selectedProductPurchaseResponse = new SelectedProductInPurchaseResponse(
                    addedSelectedProduct.getId(), purchaseResponse, productResponse
                    ,addedSelectedProduct.getQuantity());

            return selectedProductPurchaseResponse;
        } catch (ProjectException ex) {
            return null;
        }
    }

}
