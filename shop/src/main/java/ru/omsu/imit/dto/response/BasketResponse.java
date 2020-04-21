package ru.omsu.imit.dto.response;

import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInBasketResponse;
import java.util.ArrayList;
import java.util.List;

public class BasketResponse {
    private int id;
    private BuyerResponse buyer;
    private List<SelectedProductInBasketResponse> productsInBasket;

    public BasketResponse(int id, BuyerResponse buyer, List<SelectedProductInBasketResponse> productsInBasket){
        this.id=id;
        setBuyer(buyer);
        this.productsInBasket = productsInBasket;

    }

    public BasketResponse(int id, BuyerResponse buyer){
        this(id,buyer,new ArrayList<>());
    }

    public List<SelectedProductInBasketResponse> getProductsInBasket() {
        return productsInBasket;
    }

    public void setProductsInBasket(List<SelectedProductInBasketResponse> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BuyerResponse getBuyer() {
        return buyer;
    }

    public void setBuyer(BuyerResponse buyer) {
        this.buyer = buyer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasketResponse basket = (BasketResponse) o;

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
