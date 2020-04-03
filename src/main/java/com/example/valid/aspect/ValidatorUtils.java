package com.example.valid.aspect;

import com.example.valid.exception.ParamException;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Objects;
import java.util.Set;

public class ValidatorUtils {
    private static Validator validator;

    private ValidatorUtils() {
    }

    public static <T> void validate(T obj) {
        Set<ConstraintViolation<T>> constraintViolations = getValidator().validate(obj);
        if (CollectionUtils.isEmpty(constraintViolations)) {
            return;
        }
        StringBuffer paramMsg = new StringBuffer();
        constraintViolations.forEach(violation -> {
            paramMsg.append(violation.getPropertyPath() + violation.getMessage()).append("；");
        }

        );
        throw new ParamException(300, paramMsg.toString());
    }

    private static Validator getValidator() {
        if (Objects.isNull(validator)) {
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            validator = validatorFactory.getValidator();
        }
        return validator;
    }
}
