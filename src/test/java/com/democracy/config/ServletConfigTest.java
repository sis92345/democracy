package com.democracy.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;

public class ServletConfigTest extends StandardSpringTest {

    @Test
    public void jasypt() {
        String url = "my_db_url";
        String username = "my_db_username";
        String password = "my_db_password";
        String scretKey = "democracy_jwt_scretKey_1q2w3e4r";

        System.out.println(jasyptEncoding(url));
        System.out.println(jasyptEncoding(username));
        System.out.println(jasyptEncoding(password));
        System.out.println(jasyptEncoding(scretKey));
    }

    public String jasyptEncoding(String value) {

        String key = "democracy_password";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }

}