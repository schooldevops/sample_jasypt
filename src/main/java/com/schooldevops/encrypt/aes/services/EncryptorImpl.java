package com.schooldevops.encrypt.aes.services;

import com.schooldevops.encrypt.aes.EncryptionProperties;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class EncryptorImpl implements Encryptor {

    private EncryptionProperties properties;
    private PooledPBEStringEncryptor encryptor = null;

    public EncryptorImpl(EncryptionProperties properties) {
        this.properties = properties;

        encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(properties.getPoolSize());
        
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(properties.getKeys());
        config.setAlgorithm(properties.getAlgorithm());
        config.setKeyObtentionIterations("1000");
        config.setPoolSize(properties.getPoolSize());
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");

        encryptor.setConfig(config);
    }

    @Override
    public String encrypt(String plainText) {
        return this.encryptor.encrypt(plainText);
    }

    @Override
    public String decrypt(String encryptedText) {
        return this.encryptor.decrypt(encryptedText);
    }
}
