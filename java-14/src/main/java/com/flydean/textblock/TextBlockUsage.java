package com.flydean.textblock;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author wayne
 * @version TextBlockUsage,  2020/4/27 3:13 下午
 */
@Slf4j
public class TextBlockUsage {

    @Test
    public void useTextBlockHtml(){
        String html = """
                
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                """;
        log.info("{}",html);
    }

    @Test
    public void useTextBlockSQL(){
        String query = """
                SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
                WHERE `CITY` = 'INDIANAPOLIS'
                ORDER BY `EMP_ID`, `LAST_NAME`;
                """;
        log.info("{}",query);
    }

    @Test
    public void useEscape(){
        String code =
                """
                "
                ""
                \s\s\s\s\s保留这行前面的空白
                String text = \"""
                    这里展示的是escape的用法！
                \""";
                跟大家说个密码，这一行很长，我准备分行\
                来写，哈哈！
                """;
        log.info("{}",code);
    }

    @Test
    public void useMethod(){
        String query1 = """
                SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
                WHERE `CITY` = '%s'
                ORDER BY `EMP_ID`, `LAST_NAME`;
                """;

        log.info(query1.formatted("我是一个参数"));
//        log.info(query1.stripIndent());
//        log.info(query1.translateEscapes());
    }




}
