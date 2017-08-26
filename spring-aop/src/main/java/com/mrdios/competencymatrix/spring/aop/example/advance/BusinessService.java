package com.mrdios.competencymatrix.spring.aop.example.advance;

import org.springframework.context.annotation.Configuration;

import java.text.MessageFormat;

/**
 * 模拟业务接口
 *
 * @author mrdios
 * @date 2017-08-26
 */
@Configuration
public class BusinessService {

    /**
     * 模拟转账操作
     *
     * @param from  转账人
     * @param to    收款人
     * @param money 转账金额
     * @return 是否成功
     */
    @LogRequired
    public boolean transferMoney(String from, String to, double money) {
        System.out.println(MessageFormat.format("{0}向{1}转账{2}元", from, to, money));
        return true;
    }
}
