package ru.omsu.imit.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private int id;
    private Buyer buyer;
    private List<SelectedProductInBasket> productsInBasket;

    public Basket(int id,Buyer buyer,List<SelectedProductInBasket> productsInBasket){
        this.id=id;
        setBuyer(buyer);
        this.productsInBasket = productsInBasket;

    }
    public Basket(){}
    public Basket(int id,Buyer buyer){
        this(id,buyer,new ArrayList<>());
    }

    public List<SelectedProductInBasket> getProductsInBasket() {
        return productsInBasket;
    }

    public void setProductsInBasket(List<SelectedProductInBasket> productsInBasket) {
        this.productsInBasket = productsInBasket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;

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
