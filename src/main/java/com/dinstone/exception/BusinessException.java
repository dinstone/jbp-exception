/**
 * Copyright (C) 2012~2014 dinstone<dinstone@163.com>
 */

package com.dinstone.exception;

/**
 * @author guojinfei
 * @version 1.0.0.2014-11-14
 */
public class BusinessException extends ApplicationException {

    /**  */
    private static final long serialVersionUID = 1L;

    public BusinessException(ExceptionType errorType) {
        super(errorType);
    }

    public BusinessException(ExceptionType errorType, Throwable cause) {
        super(errorType, cause);
    }

}
