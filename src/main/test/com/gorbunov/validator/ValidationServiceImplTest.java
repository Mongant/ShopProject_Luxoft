package com.gorbunov.validator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationServiceImplTest {

    private ValidationService validationService;

    @Before
    public void init(){
        validationService = new ValidationServiceImpl();
    }

    @Test
    public void validatePhoneNumberTest() {
        final String[] VALID_NUMBER = {"+380970000000", "+380670000000", "+380500000000"};
        try {
            for(String phoneNumber : VALID_NUMBER) {
                validationService.validatePhoneNum(phoneNumber);
            }
        } catch (BusinessException e) {
            assertEquals("", e.getMessage());
        }
    }

    @Test
    public void invalidPhoneNumberTest() {
        final String[] INVALID_NUMBER = {"380970000000", "0970000000", "+38050000", "+38050000000a", "+390670000000"};
        try {
            for(String phoneNumber : INVALID_NUMBER) {
                validationService.validatePhoneNum(phoneNumber);
            }
        } catch (BusinessException e) {
            assertEquals("Incorrect phone format!", e.getMessage());
        }
    }

    @Test
    public void validEmailAddressTest() {
        final String[] VALID_EMAIL = {"test@gmail.com", "trst_124@gmail.com", "test.test_1@gmail.com", "1515.sss.asd_151@gmail.org"};
        try {
            for(String email : VALID_EMAIL) {
                validationService.validateEmail(email);
            }
        } catch (BusinessException e) {
            assertEquals("", e.getMessage());
        }
    }

    @Test
    public void invalidEmailAddressTest() {
        final String[] INVALID_EMAIL = {"test.gmail.com", "test@gmail_com", "test@gmail", "@test@gmail.com", "test@gmail.co"};
        try {
            for(String email : INVALID_EMAIL) {
                validationService.validateEmail(email);
            }
        } catch (BusinessException e) {
            assertEquals("Incorrect email format!", e.getMessage());
        }
    }

    @Test
    public void  validAgeTest() {
        try {
            validationService.validateAge(50);
        } catch (BusinessException e) {
            assertEquals("", e.getMessage());
        }
    }

    @Test
    public void invalidAgeTest() {
        try {
            validationService.validateAge(200);
        } catch (BusinessException e) {
            assertEquals("Incorrect age!", e.getMessage());
        }
    }

    @After
    public void tearDown() {
        validationService = null;
    }
}