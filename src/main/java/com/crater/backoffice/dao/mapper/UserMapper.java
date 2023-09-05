package com.crater.backoffice.dao.mapper;

import com.crater.backoffice.bean.dto.InsertUserDbDto;
import com.crater.backoffice.bean.dto.UserDetailInfoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserDetailInfoDto queryUserInfoByUserId(String userId);
    void insertUser(InsertUserDbDto insertUserDbDto);
}
