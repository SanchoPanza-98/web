package ru.omsu.imit.dto.response.selectedProduct;

import ru.omsu.imit.dto.response.ProductResponse;
import ru.omsu.imit.dto.response.PurchaseResponse;

public class SelectedProductInPurchaseResponse {
    private int id,quantity;
    private ProductResponse product;
    private PurchaseResponse purchase;

    public SelectedProductInPurchaseResponse(int id, PurchaseResponse purchase, ProductResponse product, int quantity){
        setId(id);
        setPurchase(purchase);
        setProduct(product);
        setQuantity(quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductResponse getProduct() {
        return product;
    }

    public void setProduct(ProductResponse product) {
        this.product = product;
    }

    public PurchaseResponse getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseResponse purchase) {
        this.purchase = purchase;
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

        SelectedProductInPurchaseResponse that = (SelectedProductInPurchaseResponse) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return purchase != null ? purchase.equals(that.purchase) : that.purchase == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + quantity;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (purchase != null ? purchase.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SelectedProductInPurchase" +
                "[id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                ", purchase=" + purchase +
                "]";
    }

}
