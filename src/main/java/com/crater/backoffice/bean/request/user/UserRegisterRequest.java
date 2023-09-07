package com.crater.backoffice.bean.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.lang.NonNull;

public record UserRegisterRequest(@Schema(example = "ken", description = "使用者id") @NonNull String userId,
                                  @Schema(example = "abc@gmail.com", description = "email") @NonNull String email,
                                  @Schema(example = "xxxxx", description = "使用者的密碼，目前使用明碼將來會用BCrypt傳進來，") @NonNull String password) {
}
