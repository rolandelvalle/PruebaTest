package com.sp2.apirestmongo.security.jwt;

import com.sp2.apirestmongo.model.User;

import java.util.Calendar;

public interface OperationJwt {
    String generateJwt(User user, Calendar expirationData);
}
