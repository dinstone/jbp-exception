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

package com.dinstone.exception.example;

import java.util.ResourceBundle;

import com.dinstone.exception.ExceptionType;

public class ApplicationExceptionExample3 {

    public static void main(String[] args) {
        System.out.println(getUserText(ValidationErrorType.VALUE_TOO_SHORT));
    }

    public static String getUserText(ExceptionType errorCode) {
        if (errorCode == null) {
            return null;
        }
        System.out.println("et message = " + errorCode.getMessage());
        System.out.println("et code = " + errorCode.getCode());
        String key = errorCode.getCode();
        ResourceBundle bundle = ResourceBundle.getBundle("exceptions");
        String value = bundle.getString(key);
        return value;
    }

}
