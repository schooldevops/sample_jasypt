package com.schooldevops.encrypt.aes.services;

public interface Encryptor {

    String encrypt(String plainText);
    String decrypt(String encryptedText);

}
