package com.crater.backoffice.service.impl;

import com.crater.backoffice.bean.dto.UserDetailInfoDto;
import com.crater.backoffice.bean.dto.UserRegisterDto;
import com.crater.backoffice.dao.mapper.UserMapper;
import com.crater.backoffice.exception.DBOperationsException;
import com.crater.backoffice.exception.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class UserEditServiceImplTest {
    private UserMapper userMapper;
    private UserEditServiceImpl testTarget;

    @BeforeEach
    void setUp() {
        userMapper = Mockito.mock(UserMapper.class);
        testTarget = new UserEditServiceImpl().setUserMapper(userMapper);
    }

    @Test
    void registerUser_throwUserException() {
        var userRegisterDto = new UserRegisterDto("ken", "xxx@gmail.com", "xxx");
        Mockito.when(userMapper.queryUserInfoByUserId(Mockito.anyString()))
                .thenReturn(new UserDetailInfoDto(1, "ken", "xxx@gmail.com",
                        "XXX", 1, LocalDateTime.now(), "ken", LocalDateTime.now(),
                        "ken"));
        var userException = Assertions.assertThrows(UserException.class, () -> testTarget.registerUser(userRegisterDto));
        Assertions.assertEquals("註冊重複的使用者ID", userException.getMessage());
    }

    @Test
    void registerUser_throwRunTimeException() {
        var userRegisterDto = new UserRegisterDto("ken", "xxx@gmail.com", "xxx");
        Mockito.when(userMapper.queryUserInfoByUserId(Mockito.anyString())).thenReturn(null);
        Mockito.when(userMapper.insertUser(Mockito.any())).thenThrow(new RuntimeException("test exception"));
        var runtimeException = Assertions.assertThrows(DBOperationsException.class, () -> testTarget.registerUser(userRegisterDto));
        Assertions.assertEquals("insert user fail", runtimeException.getMessage());
    }

    @Test
    void registerUser_success() {
        var userRegisterDto = new UserRegisterDto("ken", "xxx@gmail.com", "xxx");
        Mockito.when(userMapper.queryUserInfoByUserId(Mockito.anyString())).thenReturn(null);
        Mockito.when(userMapper.insertUser(Mockito.any())).thenReturn(1);
        testTarget.registerUser(userRegisterDto);
    }
}
