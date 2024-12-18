package cn.example.demo.service;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JasyptService {
    private final StringEncryptor stringEncryptor;

    public static void main(String[] args) {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("yourpassword");
        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        String encrypt = encryptor.encrypt("6femf7e59kfk&d");
        System.out.println(encrypt);

        String decrypt = encryptor.decrypt(encrypt);
        System.out.println(decrypt);
    }

    public String encrypt(String text) {
        return stringEncryptor.encrypt(text);
    }

    /**
     * 解密
     *
     * @param text 密文
     * @return 明文
     */
    public String decrypt(String text) {
        return stringEncryptor.decrypt(text);
    }
}
