package com.example.inMemoryUsersRegistration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "some.shit") // If prefix absent spring will check yaml's first level
public class PermittedUrls {
    public String[] list;
}
