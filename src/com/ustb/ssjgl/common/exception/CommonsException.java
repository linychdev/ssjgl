/*
 * @(#)CommonsException.java 2018年4月12日下午5:39:22
 * ssjgl
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.common.exception;

/**
 * CommonsException
 * @author linych
 * @version 1.0
 *
 */
public class CommonsException extends RuntimeException {

    private static final long serialVersionUID = 699978142734398943L;

    public CommonsException() {
        super();
    }

    public CommonsException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CommonsException(Throwable cause) {
        super(cause);
    }

    public CommonsException(String message) {
        super(message);
    }
}
