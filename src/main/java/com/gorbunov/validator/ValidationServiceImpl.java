package com.gorbunov.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationServiceImpl implements ValidationService {

    private static final String REG_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String REG_PHONE_NUMBER = "^(\\+380){1}(67|97|50)?[0-9]{7}";

    @Override
    public void validateAge(int age) throws BusinessException {
        if(age < 0 || age > 150) {
            throw  new BusinessException("Incorrect age!");
        }
    }

    @Override
    public void validateEmail(String email) throws BusinessException {
        Pattern pattern = Pattern.compile(REG_EMAIL);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) {
            throw new BusinessException("Incorrect email format!");
        }
    }

    @Override
    public void validatePhoneNum(String phoneNum) throws BusinessException {
        Pattern pattern = Pattern.compile(REG_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNum);
        if(!matcher.matches()) {
            throw new BusinessException("Incorrect phone format!");
        }
    }
}
