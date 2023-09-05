package com.crater.backoffice.controller;

import com.crater.backoffice.bean.dto.UserRegisterDto;
import com.crater.backoffice.bean.request.user.UserRegisterRequest;
import com.crater.backoffice.bean.response.ErrorMessage;
import com.crater.backoffice.bean.response.user.UserRegisterResponse;
import com.crater.backoffice.service.UserEditService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Tag(name = "使用者編輯與登入")
@Controller
public class UserEditController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private UserEditService userEditService;

    @Operation(description = "註冊使用者 API ， userId 不可以重複")
    @RequestMapping(value = "/user/register/", method = RequestMethod.POST)
    @ResponseBody
    public UserRegisterResponse registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        try {
            var dto = generateUserRegisterDto(userRegisterRequest);
            registerUser(dto);
            var response = new UserRegisterResponse();
            response.setErrorMessage(new ErrorMessage().setSuccess(true));
            return response;
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
            throw e;
        }
    }

    private UserRegisterDto generateUserRegisterDto(UserRegisterRequest request) {
        return new UserRegisterDto(request.userId(), request.email(), request.password(), request.userId());
    }

    private void registerUser(UserRegisterDto userRegisterDto) {
        userEditService.registerUser(userRegisterDto);
    }

    @Autowired
    public UserEditController setUserEditService(UserEditService userEditService) {
        this.userEditService = userEditService;
        return this;
    }
}
