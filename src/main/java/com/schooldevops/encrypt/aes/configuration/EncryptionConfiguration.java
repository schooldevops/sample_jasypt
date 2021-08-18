package com.schooldevops.encrypt.aes.configuration;

import com.schooldevops.encrypt.aes.EncryptionProperties;
import com.schooldevops.encrypt.aes.services.Encryptor;
import com.schooldevops.encrypt.aes.services.EncryptorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(EncryptorImpl.class)
@EnableConfigurationProperties(value = {EncryptionProperties.class})
public class EncryptionConfiguration {

    @Autowired
    private EncryptionProperties properties;

    @Bean("encryptor")
    @ConditionalOnClass(value = EncryptionProperties.class)
    @ConditionalOnMissingBean
    public Encryptor encryptor() {
        return new EncryptorImpl(properties);
    }

}
