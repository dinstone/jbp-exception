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

import com.dinstone.exception.BusinessException;

public class ApplicationExceptionExample2 {

    private static final int MIN_LENGTH = 10;

    public static void main(String[] args) {
        validate("email", "abc");
    }

    public static void validate(String field, String value) {
        if (value == null || value.length() < MIN_LENGTH) {
            throw new BusinessException(ValidationErrorType.VALUE_TOO_SHORT).setProperty("field", field)
                .setProperty("value", value).setProperty("min-length", MIN_LENGTH);
        }
    }

}