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

import com.dinstone.exception.ApplicationException;
import com.dinstone.exception.BusinessException;

public class ApplicationExceptionExample {

    public static void main(String[] args) {
        try {
            businessException();
        } catch (BusinessException e) {
            e.printStackTrace();
            if (e.getExceptionType() == PaymentErrorType.CREDIT_CARD_EXPIRED) {
                System.out.println("Credit card expired");
            }
        }

        try {
            applicationException();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    private static void businessException() {
        throw new BusinessException(PaymentErrorType.CREDIT_CARD_EXPIRED);
    }

    private static void applicationException() {
        RuntimeException exception = new RuntimeException();
        throw BusinessException.wrap(exception);
    }

}