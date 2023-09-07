package com.crater.backoffice.controller;

import com.crater.backoffice.bean.dto.UserRegisterDto;
import com.crater.backoffice.bean.request.user.UserRegisterRequest;
import com.crater.backoffice.exception.RequestDataException;
import com.crater.backoffice.exception.UserException;
import com.crater.backoffice.service.UserEditService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class UserEditControllerTest {
    private UserEditController testTarget;
    private UserEditService userEditService;

    private final static String TEST_USER_ID = "ken";
    private final static String TEST_EMAIL = "aaa@gmail.com";
    private final static String TEST_PASSWORD = "XXX";

    @BeforeEach
    void setUp() {
        testTarget = new UserEditController();
        userEditService = Mockito.mock(UserEditService.class);
        testTarget.setUserEditService(userEditService);
    }

    @Test
    void registerUser_AllNull_throwRequestException() {
        var request = new UserRegisterRequest("", "", "");
        var requestException = Assertions.assertThrows(RequestDataException.class, () -> testTarget.registerUser(request));
        Assertions.assertEquals("userId, email, password 不可為空", requestException.getMessage());
    }

    @Test
    void registerUser_success() {
        var request = new UserRegisterRequest(TEST_USER_ID, TEST_EMAIL, TEST_PASSWORD);
        Mockito.doNothing().when(userEditService).registerUser(Mockito.any());
        Mockito.doAnswer(i -> {
            var dto = i.getArgument(0, UserRegisterDto.class);
            Assertions.assertEquals(TEST_USER_ID, dto.userId());
            Assertions.assertEquals(TEST_EMAIL, dto.email());
            Assertions.assertEquals(TEST_PASSWORD, dto.password());
            return null;
        }).when(userEditService).registerUser(Mockito.any(UserRegisterDto.class));
        testTarget.registerUser(request);
    }

    @Test
    void registerUser_throwUserException() {
        var request = new UserRegisterRequest(TEST_USER_ID, TEST_EMAIL, TEST_PASSWORD);
        Mockito.doNothing().when(userEditService).registerUser(Mockito.any());
        Mockito.doAnswer(i -> {
            throw new UserException("註冊重複的使用者ID");
        }).when(userEditService).registerUser(Mockito.any(UserRegisterDto.class));
        var userException = Assertions.assertThrows(UserException.class, () -> testTarget.registerUser(request));
        Assertions.assertEquals("註冊重複的使用者ID", userException.getMessage());
    }
}
