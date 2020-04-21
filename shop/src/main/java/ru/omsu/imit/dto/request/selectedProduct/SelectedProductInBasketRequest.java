package ru.omsu.imit.dto.request.selectedProduct;

import ru.omsu.imit.dto.request.BasketRequest;
import ru.omsu.imit.dto.request.ProductRequest;

public class SelectedProductInBasketRequest {
    private int id;
    private BasketRequest basket;
    private ProductRequest product;
    private int quantity;

    public SelectedProductInBasketRequest(int id, BasketRequest basket, ProductRequest product, int quantity){
        setId(id);
        setBasket(basket);
        setProduct(product);
        setQuantity(quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductRequest getProduct() {
        return product;
    }

    public void setProduct(ProductRequest product) {
        this.product = product;
    }

    public BasketRequest getBasket() {
        return basket;
    }

    public void setBasket(BasketRequest basket) {
        this.basket = basket;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectedProductInBasketRequest that = (SelectedProductInBasketRequest) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        if (basket != null ? !basket.equals(that.basket) : that.basket != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (basket != null ? basket.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "SelectedProductInBasket" +
                "[id=" + id +
                ", basket=" + basket +
                ", product=" + product +
                ", quantity=" + quantity +
                "]";
    }
}
