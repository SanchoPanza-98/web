package ru.omsu.imit.mappers;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.omsu.imit.model.Buyer;
import ru.omsu.imit.model.User;

import java.util.List;


@Component
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user ( login, password, roleid) " +
            "VALUES "
            + "( #{login}, #{password}, #{role.roleId})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "id")
    Integer insert(User user);

    @Select("SELECT login, password FROM user WHERE id = #{id}")
    User getById(int id);

    @Select("SELECT id,login, password FROM user WHERE user.login = #{login}")
    @Results({
            @Result(property = "userId", column = "id")
    })
    User getByLogin(@Param("login") String login);

    @Delete("DELETE FROM user WHERE id = #{user.id}")
    void delete(@Param("user") User user);

    @Delete("DELETE FROM user WHERE roleid = 1")
    void deleteBuyers();

    @Update("UPDATE user SET login = #{user.login} , password = #{user.password}"+
            "WHERE id = #{user.id} ")
    void update(@Param("user") User user);
}
