package ru.omsu.imit.dto.response;

import ru.omsu.imit.model.SelectedProductInBasket;
import java.util.List;

public class ListSelectedProductsResponse {

    private List<SelectedProductInBasket> selectedProducts;

    public ListSelectedProductsResponse(List<SelectedProductInBasket> selectedProducts) {
        this.selectedProducts = selectedProducts;

    }

    public List<SelectedProductInBasket> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<SelectedProductInBasket> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    @Override
    public String toString() {
        return "ListSelectedProductsResponse{" +
                "selectedProducts=" + selectedProducts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSelectedProductsResponse that = (ListSelectedProductsResponse) o;

        return selectedProducts != null ? selectedProducts.equals(that.selectedProducts) : that.selectedProducts == null;
    }

    @Override
    public int hashCode() {
        return selectedProducts != null ? selectedProducts.hashCode() : 0;
    }
}
