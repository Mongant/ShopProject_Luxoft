package com.gorbunov.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationServiceImpl implements ValidationService {

    private static final String REG_EMAIL_EXSPRESSION = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String REG_PHONE_NUMBER = "^[+]380[1-9]\\d{7,8}$";

    @Override
    public void validateAge(int age) throws BusinessException {
        if(age < 0 || age > 150) {
            throw  new BusinessException("Incorrect age!");
        }
    }

    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(REG_EMAIL_EXSPRESSION);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean validatePhoneNum(String phoneNum) {
        Pattern pattern = Pattern.compile(REG_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }
}
