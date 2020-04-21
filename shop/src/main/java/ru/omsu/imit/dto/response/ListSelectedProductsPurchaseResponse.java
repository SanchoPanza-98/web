package ru.omsu.imit.dto.response;

import ru.omsu.imit.model.SelectedProductInPurchase;
import java.util.List;

public class ListSelectedProductsPurchaseResponse {

    private List<SelectedProductInPurchase> selectedProducts;

    public ListSelectedProductsPurchaseResponse(List<SelectedProductInPurchase> selectedProducts) {
        this.selectedProducts = selectedProducts;

    }

    public List<SelectedProductInPurchase> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<SelectedProductInPurchase> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    @Override
    public String toString() {
        return "ListSelectedProductsPurchaseResponse{" +
                "selectedProducts=" + selectedProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSelectedProductsPurchaseResponse that = (ListSelectedProductsPurchaseResponse) o;

        return selectedProducts != null ? selectedProducts.equals(that.selectedProducts) : that.selectedProducts == null;
    }

    @Override
    public int hashCode() {
        return selectedProducts != null ? selectedProducts.hashCode() : 0;
    }
}
