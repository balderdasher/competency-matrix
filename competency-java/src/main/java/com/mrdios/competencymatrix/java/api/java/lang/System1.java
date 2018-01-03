package com.mrdios.competencymatrix.java.api.java.lang;

import java.util.Map;

/**
 * @author CodePorter
 * @date 2017-12-15
 */
public class System1 {

    /**
     * 获取系统环境变量集合
     *
     * @return map
     */
    public static Map<String, String> getSysEnv() {
        return java.lang.System.getenv();
    }


}
