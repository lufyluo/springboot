package com.example.aop.mapper;

import com.example.aop.bean.Address;
import com.example.aop.bean.AddressVo;
import com.example.aop.bean.UserInfo;
import com.example.aop.bean.UserInfoVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PojoMapper {
    PojoMapper INSTANCE = Mappers.getMapper(PojoMapper.class);

    @Mappings({
            @Mapping(source = "address",target = "addressVo"),
            @Mapping(source = "no",target = "noVo"),
            @Mapping(source = "createTime",target = "createTimeVo",dateFormat = "yyyy-MM-dd HH:mm:ss"),
    })
    AddressVo getAddressVo(Address address);

    @Mappings({
            @Mapping(source = "name",target = "nameVo"),
            @Mapping(source = "age",target = "ageVo"),
            @Mapping(source = "createTime",target = "createTimeVo",dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(expression = "java(PojoMapper.INSTANCE.getAddressVo(userInfo.getAddress()))",target = "addressVo"),
    })
    UserInfoVo getUserInfo(UserInfo userInfo);
}
