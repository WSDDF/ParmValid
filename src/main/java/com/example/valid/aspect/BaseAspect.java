package com.example.valid.aspect;

import com.example.valid.dao.OutPutParam;
import com.example.valid.exception.ParamException;
import com.example.valid.result.BaseResult;
import com.example.valid.result.CfResult;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.stream.Stream;

public class BaseAspect {
    public void paramValidate(Object[] params) {
        if (ArrayUtils.isEmpty(params)) {
            return;
        }
        Stream.of(params).forEach(param -> {
            if (!Objects.isNull(param)) {
                ValidatorUtils.validate(param);
            }
        });
    }

    public  <T extends BaseResult> T handleException(Throwable t, Method currentMethod, Object[] params) throws InstantiationException, IllegalAccessException {
        CfResult cfResult = new CfResult();
        cfResult.setSuccess(false);
        cfResult.setCode(300);
        cfResult.setMsg(t.getMessage());

        T response = (T) currentMethod.getReturnType().newInstance();
        response.setCfResult(cfResult);
        System.out.println(response.toString());
        return response;
    }

//    private ParamException getParamException(Throwable t, Method currentMethod, Object[] params, ParamException paramException) {
//        if (t instanceof ParamException) {
//            paramException = (ParamException) t;
//        }
//        System.out.println(paramException == null);
//        return paramException;
//    }
}
