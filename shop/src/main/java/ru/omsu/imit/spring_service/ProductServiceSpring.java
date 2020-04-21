package ru.omsu.imit.spring_service;

import org.springframework.stereotype.Service;
import ru.omsu.imit.dto.request.ProductRequest;
import ru.omsu.imit.dto.response.ProductResponse;
import ru.omsu.imit.exceptions.ProjectException;
import ru.omsu.imit.model.Product;
import ru.omsu.imit.utils.ProjectErrorCode;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceSpring extends BaseService {
    //ProductDAO productDAO = new ProductDAOImpl();
    public ProductResponse addProduct(ProductRequest request){
        //LOGGER.debug("Add product " + json);
        /*try {
            /*ProductRequest request = ListUtils.getClassInstanceFromJson(GSON, json, ProductRequest.class);
            if (request.getProductName()==null || request.getProductName().isEmpty()){
                throw new ProjectException(ProjectErrorCode.WRONG_PRODUCT_NAME);
            }
            if(request.getCost()<= 0){
                throw new ProjectException(ProjectErrorCode.WRONG_COST);
            }*/
            Product product = new Product(request.getId(),request.getCost(),request.getProductName());
            Product addedProduct = productDAO.insert(product);
            ProductResponse productResponse = new ProductResponse(addedProduct.getId(),addedProduct.getCost()
                    ,addedProduct.getProductName());
            //String response = GSON.toJson(productResponse);
            //return Response.ok(response, MediaType.APPLICATION_JSON).build();
            return productResponse;
        /*} catch (ProjectException ex) {
            return ListUtils.failureResponse(ex);
        }*/

    }

    public ProductResponse getProductById(int productId) {

        Product gettedProduct = productDAO.getById(productId);
        if (gettedProduct == null){
            return null;
        }
        ProductResponse productResponse = new ProductResponse(gettedProduct.getId(),gettedProduct.getCost()
                ,gettedProduct.getProductName());
        return productResponse;
    }

    public List<ProductResponse> getProductsByProductName(String productName) {

        List<Product> gettedProduct = productDAO.getByProductName(productName);
        if (gettedProduct == null){
            return null;
        }
        List<ProductResponse> responseProducts =  new ArrayList<>(gettedProduct.size());
        for (Product item: gettedProduct){
            responseProducts.add(new ProductResponse(item.getId(),item.getCost(),item.getProductName()));
        }
        return responseProducts;

    }

    public List<ProductResponse> getAllProducts() {

        List<Product> gettedProduct = productDAO.getAllLazy();
        if (gettedProduct == null){
            return null;
        }
        List<ProductResponse> responseProducts =  new ArrayList<>(gettedProduct.size());
        for (Product item: gettedProduct){
            responseProducts.add(new ProductResponse(item.getId(),item.getCost(),item.getProductName()));
        }
        return responseProducts;

    }

    public void deleteProduct(int productId){
        productDAO.delete(productId);

    }
    public ProductResponse updateProduct(int id, ProductRequest request){
        Product product = new Product(id,request.getCost(),request.getProductName());
        Product updatedProduct = productDAO.updateProduct(product);
        return new ProductResponse(updatedProduct.getId(),updatedProduct.getCost(),updatedProduct.getProductName());
    }

}
