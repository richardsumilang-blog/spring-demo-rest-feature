package com.richardsumilang.feature;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class FeatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeatureApplication.class, args);
    }

}

@RestController
class FeatureRestController {

    @Autowired
    private EnvironmentConfig ec;

    @Value(value = "${ab:b}")
    private String ab;

    @RequestMapping ("/feature")
    Map<String, Object> feature() {
        Map<String, Object> config = new HashMap<>();
        config.put("feature1", ec.isFeature1());
        config.put("feature2", ec.isFeature2());
        config.put("ab", this.ab);
        return config;
    }

}

@Component
@RefreshScope
@ConfigurationProperties(prefix = "rest")
class EnvironmentConfig {

    private boolean feature1, feature2;

    public void setFeature1(boolean feature1) {
        this.feature1 = feature1;
    }

    public void setFeature2(boolean feature2) {
        this.feature2 = feature2;
    }

    public boolean isFeature1() {
        return feature1;
    }

    public boolean isFeature2() {
        return feature2;
    }
}