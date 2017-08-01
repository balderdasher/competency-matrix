package com.mrdios.competencymatrix.springboot.example.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义配置类：用于获取在配置文件中设置的自定义配置属性
 *
 * @author MrDios
 * @date 2017-08-01
 */
@Component
public class CustomConfig {
    @Value("${config.product.name}")
    private String productName;
    @Value("${config.product.desc}")
    private String productDesc;
    @Value("${config.product.author}")
    private String productAuthor;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductAuthor() {
        return productAuthor;
    }

    public void setProductAuthor(String productAuthor) {
        this.productAuthor = productAuthor;
    }
}
