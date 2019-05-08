package com.example.aop.util;

import com.example.aop.bean.PojoUser;
import com.example.aop.bean.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PojoMapper {
    PojoMapper INSTANCE = Mappers.getMapper(PojoMapper.class);
    @Mappings({@Mapping(expression = "java( userInfo.getAddress().getAddress())",target = "address"),
            @Mapping(expression = "java( userInfo.getAddress().getNo())",target = "addressNo")  })
    PojoUser toPojoUser(UserInfo userInfo);
}
