package de.aw3s.btDiary.security;

import org.apache.commons.codec.digest.DigestUtils;

public class HashFunction {
    public static String sha(String string) {
        return DigestUtils.sha512Hex(string);
    }
}
