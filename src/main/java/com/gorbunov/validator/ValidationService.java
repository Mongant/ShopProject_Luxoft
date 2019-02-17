package com.gorbunov.validator;

public interface ValidationService {
    void validateAge(int age) throws BusinessException;
}
