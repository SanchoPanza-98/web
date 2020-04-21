package ru.omsu.imit.model;

public class SelectedProductInPurchase {
    private int id;
    private Product product;
    private Purchase purchase;
    private int quantity;

    public SelectedProductInPurchase(int id, Purchase purchase, Product product, int quantity){
        setId(id);
        setPurchase(purchase);
        setProduct(product);
        setQuantity(quantity);
    }

    public SelectedProductInPurchase(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
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

        SelectedProductInPurchase that = (SelectedProductInPurchase) o;

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
