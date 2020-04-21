package ru.omsu.imit.dto.request.selectedProduct;

import ru.omsu.imit.dto.request.ProductRequest;
import ru.omsu.imit.dto.request.PurchaseRequest;

public class SelectedProductInPurchaseRequest {
    private int id;
    private ProductRequest product;
    private PurchaseRequest purchase;
    private int quantity;

    public SelectedProductInPurchaseRequest(int id, PurchaseRequest purchase, ProductRequest product, int quantity){
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

    public ProductRequest getProduct() {
        return product;
    }

    public void setProduct(ProductRequest product) {
        this.product = product;
    }

    public PurchaseRequest getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseRequest purchase) {
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

        SelectedProductInPurchaseRequest that = (SelectedProductInPurchaseRequest) o;

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
