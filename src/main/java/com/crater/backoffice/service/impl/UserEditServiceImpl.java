package com.crater.backoffice.service.impl;

import com.crater.backoffice.bean.dto.InsertUserDbDto;
import com.crater.backoffice.bean.dto.UserRegisterDto;
import com.crater.backoffice.dao.mapper.UserMapper;
import com.crater.backoffice.exception.DBOperationsException;
import com.crater.backoffice.exception.UserException;
import com.crater.backoffice.service.UserEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserEditServiceImpl implements UserEditService {
    private UserMapper userMapper;

    @Transactional
    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        try {
            if (isHaveRepeatedUserId(userRegisterDto.userId())) {
                throw new UserException("註冊重複的使用者ID");
            }
            var dbDto = generateInsertUserDbDto(userRegisterDto);
            insertUser(dbDto);
        } catch (UserException | DBOperationsException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isHaveRepeatedUserId(String userId) {
        try {
            var queryResult = userMapper.queryUserInfoByUserId(userId);
            return !(queryResult == null);
        } catch (Exception e) {
            throw new DBOperationsException("query have Repeated UserId fail", e);
        }
    }

    private InsertUserDbDto generateInsertUserDbDto(UserRegisterDto userRegisterDto) {
        try {
            return new InsertUserDbDto(userRegisterDto.userId(), userRegisterDto.email(), userRegisterDto.password());
        } catch (Exception e) {
            throw new RuntimeException("generate insert user db dto fail", e);
        }
    }

    private void insertUser(InsertUserDbDto insertUserDbDto) {
        try {
            userMapper.insertUser(insertUserDbDto);
        } catch (Exception e) {
            throw new DBOperationsException("insert user fail", e);
        }
    }

    @Autowired
    public UserEditServiceImpl setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
        return this;
    }
}
