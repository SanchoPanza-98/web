package ru.omsu.imit.dto.request;

import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInBasketRequest;


import java.util.ArrayList;
import java.util.List;

public class BasketRequest {
    private int id;
    private BuyerRequest buyer;
    private List<SelectedProductInBasketRequest> productsInBasket;


    public BasketRequest() {
    }

    public BasketRequest(int id, BuyerRequest buyer, List<SelectedProductInBasketRequest> productsInBasket){
        this.id=id;
        setBuyer(buyer);
        this.productsInBasket = productsInBasket;

    }

    public BasketRequest(int id, BuyerRequest buyer){
        this(id,buyer,new ArrayList<>());
    }

    public List<SelectedProductInBasketRequest> getProductsInBasket() {
        return productsInBasket;
    }

    public void setProductsInBasket(List<SelectedProductInBasketRequest> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuyerRequest getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerRequest buyer) {
        this.buyer = buyer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasketRequest basket = (BasketRequest) o;

        if (id != basket.id) return false;
        if (buyer != null ? !buyer.equals(basket.buyer) : basket.buyer != null) return false;
        return productsInBasket != null ? productsInBasket.equals(basket.productsInBasket) : basket.productsInBasket == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + (productsInBasket != null ? productsInBasket.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Basket " +
                "[id=" + id +
                ", buyer=" + buyer +
                ", productsInBasket=" + productsInBasket +
                "]";
    }
}
