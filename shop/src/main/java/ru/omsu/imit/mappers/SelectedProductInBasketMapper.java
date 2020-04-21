package ru.omsu.imit.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.model.*;
import java.util.List;

public interface SelectedProductInBasketMapper {

    @Insert("INSERT INTO selectedProductsInBasket( basketid, productid, quantity) VALUES " +
            "( #{selectedProduct.basket.id},#{selectedProduct.product.id}," +
            "#{selectedProduct.quantity})" )
    @Options(useGeneratedKeys = true ,keyProperty = "selectedProduct.id", keyColumn = "id")
    public Integer insert(@Param("selectedProduct") SelectedProductInBasket selectedProduct);

    @Select("SELECT * FROM selectedProductsInBasket WHERE id = #{id}")
    @Results(value = {
            @Result(property = "id", column = "id")
    })
    public SelectedProductInBasket getById(int id);

    @Select("SELECT * from selectedProductsInBasket WHERE productid= #{product.id}")
    public List<SelectedProductInBasket> getByProduct(@Param("product")Product product);

    @Select("SELECT * from selectedProductsInBasket WHERE basketid= #{basket.id}")
    public List<SelectedProductInBasket> getByBasket(@Param("basket")Basket basket);

    @Delete("DELETE FROM selectedProductsInBasket")
    public int deleteAll();

    @Delete("DELETE FROM selectedProductsInBasket WHERE selectedProductsInBasket.basketid = #{basket.id}" +
            " AND selectedProductsInBasket.productid = #{product.id}")
    public int deleteByBasketAndProduct(@Param("basket") Basket basket, @Param("product") Product product);

    @Delete("DELETE FROM selectedProductsInBasket WHERE id = #{id}")
    public int deleteById(@Param("id")int id);


}