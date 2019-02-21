package com.gorbunov.validator;

public interface ValidationService {

    void validateAge(int age) throws BusinessException;
    void validateEmail(String email) throws BusinessException;
    void validatePhoneNum(String phoneNum) throws BusinessException;
}
