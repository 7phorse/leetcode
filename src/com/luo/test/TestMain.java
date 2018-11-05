package com.luo.test;

import java.util.logging.Logger;

/**
 * @Description:
 * @Author: luoxusheng
 * @Date: 2018/9/8 16:55
 */
public class TestMain {

    private static Logger logger = Logger.getLogger("com.luo.test.TestMain");
    public static void main(String[] args) {
        String str = "luoxusheng123";
//        StringUtils.substringBefore(email,"@")+"123"
        str = str.replaceAll("[^a-z^A-Z]", "");
        logger.info(str);
        logger.warning(str);


    }
}
