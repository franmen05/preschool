package com.preschool.util;

//import java.security.SecureRandom;




/*
 * Copyright 2016-2021 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see https://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.bouncycastle.crypto.fips.FipsSecureRandom;

/**
 * Utility class for generating random Strings.
*/
public class RandomUtil {
    private static final int DEF_COUNT = 20;

//    private static final FipsSecureRandom SECURE_RANDOM;

//    static {
////        SECURE_RANDOM = new FipsSecureRandom();
////        SECURE_RANDOM.nextBytes(new byte[64]);
//    }

    private RandomUtil() {
    }

    /**
     * <p>generateRandomAlphanumericString.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public static String generateRandomAlphanumericString() {
//        return RandomStringUtils.random(DEF_COUNT, 0, 0, true, true, null, SECURE_RANDOM);
        return  "";
    }


    /**
     * Generate a password.
     *
     * @return the generated password.
     */
    public static String generatePassword() {
        return generateRandomAlphanumericString();
    }

    /**
     * Generate an activation key.
     *
     * @return the generated activation key.
     */
    public static String generateActivationKey() {
        return generateRandomAlphanumericString();
    }

    /**
     * Generate a reset key.
     *
     * @return the generated reset key.
     */
    public static String generateResetKey() {
        return generateRandomAlphanumericString();
    }
}
