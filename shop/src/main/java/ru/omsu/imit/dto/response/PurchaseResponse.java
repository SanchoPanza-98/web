package ru.omsu.imit.dto.response;

import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInPurchaseResponse;
import ru.omsu.imit.model.Payment;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PurchaseResponse {
    private int id;
    private BuyerResponse buyer;
    private String purchaseDate;
    private Payment payment;
    private int sum;

    private List<SelectedProductInPurchaseResponse> selectedProducts;


    public PurchaseResponse(int id, BuyerResponse buyer, Timestamp purchaseDate, String payment, List<SelectedProductInPurchaseResponse> selectedProducts){
        setId(id);
        setBuyer(buyer);
        setPurchaseDate(purchaseDate.toString());
        setPayment(Payment.valueOf(payment));
        this.selectedProducts = selectedProducts;
        this.sum = 0;
    }

    public PurchaseResponse(int id, BuyerResponse buyer, Timestamp purchaseDate, String payment){
        this(id,buyer,purchaseDate,payment,new ArrayList<>());
    }

    public PurchaseResponse(){

    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
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

        PurchaseResponse purchase = (PurchaseResponse) o;

        if (id != purchase.id) return false;
        if (buyer != null ? !buyer.equals(purchase.buyer) : purchase.buyer != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(purchase.purchaseDate) : purchase.purchaseDate != null)
            return false;
        if (payment != purchase.payment) return false;
        return selectedProducts != null ? selectedProducts.equals(purchase.selectedProducts) : purchase.selectedProducts == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (payment != null ? payment.hashCode() : 0);
        result = 31 * result + (selectedProducts != null ? selectedProducts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Purchase [id=" + id + ", buyer=" + buyer + ", purchaseDate='" + purchaseDate + ", payment=" + payment +
                ", sum=" + sum + ", selectedProducts=" + selectedProducts + "]";
    }
}
