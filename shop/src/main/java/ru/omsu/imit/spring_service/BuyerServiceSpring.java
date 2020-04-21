package ru.omsu.imit.spring_service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.stereotype.Service;
import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.dto.response.BuyerResponse;
import ru.omsu.imit.dto.response.ListSelectedProductsPurchaseResponse;
import ru.omsu.imit.dto.response.ListSelectedProductsResponse;
import ru.omsu.imit.exceptions.ProjectException;
import ru.omsu.imit.model.Basket;
import ru.omsu.imit.model.Buyer;
import ru.omsu.imit.model.SelectedProductInBasket;
import ru.omsu.imit.model.SelectedProductInPurchase;
import ru.omsu.imit.utils.ProjectErrorCode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class BuyerServiceSpring extends BaseService{

    public BuyerResponse createBuyer(BuyerRequest buyerRequest){
        try{
        Buyer buyer = new Buyer(buyerRequest.getId(),0,buyerRequest.getFirstName(),buyerRequest.getSecondName()
        ,buyerRequest.getPatronymic(), buyerRequest.getBirthday()
                ,buyerRequest.getEmail(),buyerRequest.getLogin(), buyerRequest.getPassword() ,buyerRequest.getTelephoneNum());

            Buyer addedBuyer =  buyerDAO.insert(buyer);
            Basket newBasket = new Basket(1,addedBuyer);
            basketDAO.insert(newBasket);
            BuyerResponse buyerResponse = new BuyerResponse(addedBuyer.getId(),addedBuyer.getFirstName(),addedBuyer.getSecondName()
                    ,addedBuyer.getPatronymic(),addedBuyer.getBirthday(),addedBuyer.getEmail(),addedBuyer.getLogin(),addedBuyer.getTelephoneNum());

            //String response = GSON.toJson(buyerResponse);
            return buyerResponse;
        } catch (MySQLIntegrityConstraintViolationException e) {
            return new BuyerResponse(0,buyerRequest.getFirstName(),buyerRequest.getSecondName()
                    ,buyerRequest.getPatronymic(), buyerRequest.getBirthday(),buyerRequest.getTelephoneNum()
                    ,buyerRequest.getEmail());
        }
    }



    public BuyerResponse deleteBuyer(int buyerId){

        Buyer buyerForDelete = buyerDAO.getById(buyerId);
        Buyer deletedBuyer = buyerDAO.delete(buyerForDelete);
        BuyerResponse buyerResponse = new BuyerResponse(deletedBuyer.getId(),deletedBuyer.getFirstName(),deletedBuyer.getSecondName()
                ,deletedBuyer.getPatronymic(),deletedBuyer.getBirthday(),deletedBuyer.getEmail(),deletedBuyer.getLogin(),deletedBuyer.getTelephoneNum());
        return buyerResponse;
    }

    public BuyerResponse getBuyerById(int id) {

        try {

            Buyer gettedBuyer = buyerDAO.getById(id);
            if (gettedBuyer == null){
                throw new ProjectException(ProjectErrorCode.ITEM_NOT_FOUND);
            }
            BuyerResponse buyerResponse = new BuyerResponse(gettedBuyer.getId(),gettedBuyer.getFirstName(),gettedBuyer.getSecondName()
                    ,gettedBuyer.getPatronymic(),gettedBuyer.getBirthday(),gettedBuyer.getEmail()
                    ,gettedBuyer.getLogin()
                    ,gettedBuyer.getTelephoneNum());
            return buyerResponse;

        } catch (ProjectException e) {
            return null;
        }
    }

    public List<BuyerResponse> getAllBuyers(){
        List<Buyer> response = buyerDAO.getAllLazy();
        List<BuyerResponse> result = new ArrayList<>();
        if( response!=null){

            for (Buyer b: response){
                result.add(new BuyerResponse(b.getId(),b.getFirstName(),b.getSecondName()
                        ,b.getPatronymic(),b.getBirthday(),b.getEmail(),b.getLogin(),b.getTelephoneNum()));
            }
        }
        return result;
    }

    public BuyerResponse updateBuyer(int id , BuyerRequest request){


        try {
            //BuyerRequest request = ListUtils.getClassInstanceFromJson(GSON, json, BuyerRequest.class);
            if (request.getFirstName()==null || request.getFirstName().isEmpty()){
                throw new ProjectException(ProjectErrorCode.WRONG_FIRSTNAME);
            }
            if (request.getSecondName()==null || request.getSecondName().isEmpty()){
                throw new ProjectException(ProjectErrorCode.WRONG_LASTNAME);
            }
            if (request.getBirthday() == null){
                throw new ProjectException(ProjectErrorCode.WRONG_BIRTHDAY);
            }
            if (request.getEmail() == null || request.getEmail().isEmpty()){
                throw new ProjectException(ProjectErrorCode.WRONG_EMAIL);
            }


            Buyer buyer =  new Buyer(id,0,request.getFirstName(),request.getSecondName(),request.getPatronymic()
                    ,request.getBirthday(),request.getEmail(),request.getLogin(),request.getPassword()
                    ,request.getTelephoneNum());
            Buyer updatedBuyer = buyerDAO.updateBuyer(buyer);

            BuyerResponse buyerResponse = new BuyerResponse(updatedBuyer.getId()
                    ,updatedBuyer.getFirstName(),updatedBuyer.getSecondName(),updatedBuyer.getPatronymic()
                    ,updatedBuyer.getBirthday(),updatedBuyer.getEmail(),updatedBuyer.getLogin()
                    ,updatedBuyer.getTelephoneNum());
            return buyerResponse;
        } catch (ProjectException ex) {
            return null;
        }
    }

    public ListSelectedProductsPurchaseResponse getAllPurchases(int buyerId){

        try {
            //Integer request = ListUtils.getClassInstanceFromJson(GSON, json, Integer.class);

            List<SelectedProductInPurchase> gettedProducts = purchaseDAO.getProductsInPurchase(buyerId);
            if (gettedProducts == null){
                throw new ProjectException(ProjectErrorCode.ITEM_NOT_FOUND);
            }
            ListSelectedProductsPurchaseResponse allPurchases = new ListSelectedProductsPurchaseResponse(gettedProducts);
            return allPurchases;
        } catch (ProjectException ex) {
            return null;
        }
    }

    public ListSelectedProductsResponse getAllProductsInBasket(int buyerId){

        try {

            List<SelectedProductInBasket> gettedProduct = basketDAO.getProductsInBasket(buyerId);
            if (gettedProduct == null){
                throw new ProjectException(ProjectErrorCode.ITEM_NOT_FOUND);
            }
            ListSelectedProductsResponse allProductsInBasket = new ListSelectedProductsResponse(gettedProduct);

            return allProductsInBasket;
        } catch (ProjectException ex) {
            return null;
        }
    }
}
