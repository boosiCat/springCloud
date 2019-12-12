package com.core.accessory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件变量配置
 */
@Component
@ConfigurationProperties(prefix = "app")
public class ConfigBean {
}
