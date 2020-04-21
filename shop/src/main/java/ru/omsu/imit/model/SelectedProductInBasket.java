package ru.omsu.imit.model;

public class SelectedProductInBasket {
    private int id;
    private Basket basket;
    private Product product;
    private int quantity;

    public SelectedProductInBasket(int id, Basket basket,Product product, int quantity){
        this.id = id;
        setBasket(basket);
        setProduct(product);
        setQuantity(quantity);
    }

    public SelectedProductInBasket(){}

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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

   /* public int getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectedProductInBasket that = (SelectedProductInBasket) o;

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
