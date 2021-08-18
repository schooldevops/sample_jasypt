package com.schooldevops.encrypt.aes;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "encrypt")
public class EncryptionProperties {

    private String DEF_ALGORITHM = "PBEWITHHMACSHA512ANDAES_256";
    private int DEF_POOLSIZE = 5;

    private String keys;
    private String algorithm = DEF_ALGORITHM;
    private int poolSize = DEF_POOLSIZE;

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}
