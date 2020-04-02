package com.example.valid.aspect;

import com.example.valid.dao.OutPutParam;
import com.example.valid.exception.ParamException;
import com.example.valid.result.BaseResult;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.stream.Stream;

public class BaseAspect {
    public void paramValidate(Object[] params) {
        if (ArrayUtils.isEmpty(params)) {
            System.out.println("没有异常");
            return;
        }
        System.out.println("zheli");
        Stream.of(params).forEach(param -> {
            System.out.println("param="+param);
            if (!Objects.isNull(param)) {
                System.out.println("lllll");
                ValidatorUtils.validate(param);
            }
        });
    }

    public  <T extends BaseResult> T handleException(Throwable t, Method currentMethod, Object[] params) throws InstantiationException, IllegalAccessException {
        OutPutParam outPutParam = new OutPutParam();
        ParamException paramException = null;
        paramException = getParamException(t, currentMethod, params, paramException);
        if (paramException != null) {
            outPutParam.setCode(paramException.getCode());
        }

        T response = (T) currentMethod.getReturnType().newInstance();
        response.setCode(outPutParam.getCode());
        return response;
    }

    private ParamException getParamException(Throwable t, Method currentMethod, Object[] params, ParamException paramException) {
        if (t instanceof ParamException) {
            paramException = (ParamException) t;
        }
        System.out.println(paramException == null);
        return paramException;
    }
}
