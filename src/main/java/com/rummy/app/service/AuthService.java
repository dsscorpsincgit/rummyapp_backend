package com.rummy.app.service;

import com.rummy.app.Dto.LoginRegisterRequest;
import com.rummy.app.Dto.LoginResponse;

public interface AuthService {

    LoginResponse register(LoginRegisterRequest request);

    LoginResponse login(LoginRegisterRequest request);
}
