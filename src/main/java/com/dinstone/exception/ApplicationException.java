/*
 * Copyright (C) 2012~2013 dinstone<dinstone@163.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dinstone.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final Map<String, Object> properties = new HashMap<String, Object>();

    private ExceptionType exceptionType;

    public ApplicationException(ExceptionType exceptionType) {
        this(exceptionType, null);
    }

    public ApplicationException(ExceptionType exceptionType, Throwable cause) {
        super(exceptionType == null ? null : exceptionType.getMessage(), cause);
        this.exceptionType = exceptionType;
    }

    /**
     * the exceptionType to get
     * 
     * @return the exceptionType
     * @see ApplicationException#exceptionType
     */
    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    /**
     * the properties to get
     * 
     * @return the properties
     * @see ApplicationException#properties
     */
    public Map<String, Object> getProperties() {
        return properties;
    }

    public ApplicationException setProperty(String name, Object value) {
        properties.put(name, value);
        return this;
    }

    @Override
    public void printStackTrace(PrintStream s) {
        synchronized (s) {
            printStackTrace(new PrintWriter(s));
        }
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        synchronized (s) {
            s.println(this);

            if (exceptionType != null) {
                s.print("\tep ");
                s.print(exceptionType.getClass().getName() + "." + exceptionType + " @ ");
                s.println(properties.toString());
            }

            StackTraceElement[] trace = getStackTrace();
            for (int i = 0; i < trace.length; i++) {
                s.println("\tat " + trace[i]);
            }

            Throwable ourCause = getCause();
            if (ourCause != null) {
                ourCause.printStackTrace(s);
            }
            s.flush();
        }
    }

    public static ApplicationException wrap(Throwable exception) {
        return wrap(null, exception);
    }

    public static ApplicationException wrap(ExceptionType exceptionType, Throwable exception) {
        if (exception instanceof ApplicationException) {
            ApplicationException ae = (ApplicationException) exception;
            if (exceptionType != null && exceptionType != ae.getExceptionType()) {
                return new ApplicationException(exceptionType, exception);
            }
            return ae;
        } else {
            return new ApplicationException(exceptionType, exception);
        }
    }

}
