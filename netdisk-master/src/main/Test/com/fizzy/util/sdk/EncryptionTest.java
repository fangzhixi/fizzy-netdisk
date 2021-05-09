package com.fizzy.util.sdk;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncryptionTest {

    private static final String PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEpAIBAAKCAQEAuw4T755fepEyXTM66pzf6nv8NtnukQTMGnhmBFIFHp/P2vEp\n" +
            "xjXUBBDUpzKkVFR3wuK9O1FNmRDAGNGYC0N/9cZNdhykA1NixJfKQzncN31VJTmN\n" +
            "qJNZW0x7H9ZGoh2aE0zCCZpRlC1Rf5rL0SVlBoQkn/n9LnYFwyLLIK5/d/y/NZVL\n" +
            "6Z6Lcyvga0zRajamLIjY0Dy/8YIwVV6kaSsHeRv2cOB03eam6gbhLGIz/l8wuJhI\n" +
            "n1rOyJLQ36IOJymbbNmcC7+2hEQJP40qLvH7hZ1LaAkgQUHjfi8RvH2T1Jmce7XG\n" +
            "PxCoEd0yfeFz+pL1KeSWNey6cL3N5hJZE8EntQIDAQABAoIBAGim1ayIFK8EMQNH\n" +
            "uDyui/Aqcc9WWky0PGTK23irUsXxb1708gQ89WNY70Cj6qBrqZ1VMb3QHPP4FSFN\n" +
            "kh0rJJoi2g+ssm5R5r5KlhTKeFRrQInVC1Y3KhUUUwZa4aWtnhgSJ7Urq1yVhjU4\n" +
            "K7PVkhH1OHBwcp/d1Bd6jd65AgPkY63P+WpcARJkClmQ1RhgoRwThyJdpKrV4/gO\n" +
            "ha0AUGlJNRNvRwiZxP0zaI5C8RdrG96SnVpeYOcD0z/M1HVlkoYMXsXLKttwLfpK\n" +
            "88Igtm6ZJwRpfuMF5VA+9hHaYGCBdGz0B/rMp2fc+EtrOavYQGrWIWi2RL1Qk6Rt\n" +
            "BUyeTgECgYEA9anj4n/cak1MT+hbNFsL31mJXryl1eVNjEZj/iPMztpdS15CmFgj\n" +
            "Kjr9UuintjSiK7Is43nZUWWyP1XQjRhVi2uP7PRIv92QNl/YteWD6tYCInJHKe2J\n" +
            "QqYyZrElezsdayXb5DK6bi1UIYYji90g79N7x6pOR0UnQNQUXTv+Y8ECgYEAwuzl\n" +
            "6Ez4BSXIIL9NK41jfNMa73Utfl5oO1f6mHM2KbILqaFE76PSgEeXDbOKdcjCbbqC\n" +
            "KCGjwyPd+Clehg4vkYXTq1y2SQGHwfz7DilPSOxhPY9ND7lGbeNzDUK4x8xe52hd\n" +
            "MWKdgqeqCK83e5D0ihzRiMah8dbxmlfLAOZ3sPUCgYEA0dT9Czg/YqUHq7FCReQG\n" +
            "rg3iYgMsexjTNh/hxO97PqwRyBCJPWr7DlU4j5qdteobIsubv+kSEI6Ww7Ze3kWM\n" +
            "u/tyAeleQlPTnD4d8rBKD0ogpJ+L3WpBNaaToldpNmr149GAktgpmXYqSEA1GIAW\n" +
            "ZAL11UPIfOO6dYswobpevYECgYEApSosSODnCx2PbMgL8IpWMU+DNEF6sef2s8oB\n" +
            "aam9zCi0HyCqE9AhLlb61D48ZT8eF/IAFVcjttauX3dWQ4rDna/iwgHF5yhnyuS8\n" +
            "KayxJJ4+avYAmwEnfzdJpoPRpGI0TCovRQhFZI8C0Wb+QTJ7Mofmt9lvIUc64sff\n" +
            "GD0wT/0CgYASMf708dmc5Bpzcis++EgMJVb0q+ORmWzSai1NB4bf3LsNS6suWNNU\n" +
            "zj/JGtMaGvQo5vzGU4exNkhpQo8yUU5YbHlA8RCj7SYkmP78kCewEqxlx7dbcuj2\n" +
            "LAPWpiDca8StTfEphoKEVfCPHaUk0MlBHR4lCrnAkEtz23vhZKWhFw==\n" +
            "-----END RSA PRIVATE KEY-----";

    @Test
    public void format() {
        Encryption encryption = new Encryption("HMAC-SHA256",
                "gd_abcdefghijklmn",
                398888,
                1590719810);
        String e = encryption.format();
        String result = Encryption.sha256_HMAC(e, PRIVATE_KEY);
        System.out.println(result);
    }

    @Test
    public void sha256_HMAC() {
        Encryption encryption = new Encryption("HMAC-SHA256",
                "gd_abcdefghijklmn",
                398888,
                1590719810);
        encryption.setSignature(Encryption.sha256_HMAC(encryption.format(), PRIVATE_KEY));
        System.out.println(encryption.format());
    }
}