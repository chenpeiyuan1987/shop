package org.yuan.demo.shop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

public class SqlUtil {

    /**
     * 运行sql脚本
     * 
     * @param sql
     * 脚本文件
     */
    public static void run(String sql) {
        try {
            // 获取数据库相关配置信息
            Properties props = Resources.getResourceAsProperties("jdbc.properties");

            // jdbc 连接信息: 注: 现在版本的JDBC不需要配置driver，因为不需要Class.forName手动加载驱动
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");

            // 建立连接
            Connection conn = DriverManager.getConnection(url, username, password);

            // 创建ScriptRunner，用于执行SQL脚本
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);

            // 执行SQL脚本
            runner.runScript(Resources.getResourceAsReader(sql));

            // 关闭连接
            conn.close();

            // 若成功，打印提示信息
            System.out.println("====== SUCCESS ======");
        }
        catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}
