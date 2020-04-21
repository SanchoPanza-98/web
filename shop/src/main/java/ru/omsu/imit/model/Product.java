package ru.omsu.imit.model;

public class Product {
    private int id;
    private int cost;
    private String productName;

    public Product (int id,int cost,String productName){
        this.id = id;
        this.cost = cost;
        this.productName = productName;
    }
    public Product(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (cost != product.cost) return false;
        return productName != null ? productName.equals(product.productName) : product.productName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cost;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product[" +
                "id=" + id +
                ", cost=" + cost +
                ", productName='" + productName +
                "]";
    }
}
