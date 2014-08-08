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

public class ApplicationExceptionExample {

    public static void main(String[] args) {
        first();
        second();
    }

    private static void first() {
        try {
            throw new ApplicationException(PaymentErrorType.CREDIT_CARD_EXPIRED);
        } catch (ApplicationException e) {
            e.printStackTrace();
            if (e.getErrorType() == PaymentErrorType.CREDIT_CARD_EXPIRED) {
                System.out.println("Credit card expired");
            }
        }
    }

    private static void second() {
        try {
            throw new ApplicationException(null);
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

}