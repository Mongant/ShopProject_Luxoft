package com.gorbunov.validator;

public class ValidationServiceImpl implements ValidationService {

    @Override
    public void validateAge(int age) throws BusinessException {
        if(age < 0 || age >200) {
            throw  new BusinessException("Incorrect age!");
        }
    }
}
