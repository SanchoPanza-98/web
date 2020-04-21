package ru.omsu.imit.mappers;

import org.apache.ibatis.annotations.*;
import ru.omsu.imit.model.Product;
import java.util.List;

public interface ProductMapper {
    @Insert("INSERT INTO product ( productName, cost) VALUES "
            + "( #{productName}, #{cost})")
    @Options(useGeneratedKeys = true)
    public Integer insert(Product product);

    @Select("SELECT id, cost, productName FROM product WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id")
    })
    public Product getById(int id);

    @Delete("DELETE FROM product")
    public void deleteAll();

    @Select("SELECT id, cost, productName FROM product WHERE cost = #{cost}")
    @Results({
            @Result(property = "id", column = "id")
    })
    public List<Product> getByCost(int cost);

    @Select("SELECT id, cost, productName FROM product WHERE productName = #{productName}")
    @Results({
            @Result(property = "id", column = "id")
    })
    public List<Product> getByProductName(String productName);

    @Select("SELECT id, cost, productName FROM product")
    @Results({
            @Result(property = "id", column = "id")
    })
    public List<Product> getAllLazy();

    @Delete("DELETE FROM product WHERE id = #{productId}")
    public int delete(@Param("productId") int id);

    @Update("update product set cost = #{prod.cost},productName = #{prod.productName} where id = #{prod.id}")
    public void updateProduct(@Param("prod") Product prod);
}
