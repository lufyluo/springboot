package com.example.mybatis.dao;

import com.example.mybatis.bean.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserRepo {
    //@Insert("insert into user (name, createTime) values (#{name,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP})")
    @Insert("insert into user (name, createTime) values (#name, #createTime)")
    int insert(User user);

    @Insert({
            "<script>",
            "insert into user(name, createTime) values ",
            "<foreach collection='userLists' item='item' index='index' separator=','>",
            "(#{item.name}, #{item.createTime})",
            "</foreach>",
            "</script>"})
    int batchInsert(@Param(value="userLists")List<User> testLists);

    @InsertProvider(type = SqlProvider.class,method = "prepareData")
    int prepareData(@Param(value="users")List<User> users);
}
