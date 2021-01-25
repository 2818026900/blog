package com.lmy.blog.domain.datasourceconfig;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author lmy
 * @email 2818026900@qq.com
 */
@Component
@PropertySource(value = {"classpath:/config/databases.yaml"}, encoding = "UTF-8", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "spring.datasource.druid")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DruidDataSourceConfig {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
    private int initialSize;
    private int maxActive;
    private int maxWait;
    private int minIdle;
    private int timeBetweenEvictionRunsMills;
    private int minEvictableIdleTimeMillis;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private String validationQuery;
    private int validationQueryTimeout;
    private String filters;

    @Bean
    @Primary // 在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSourceSetting() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMills);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setValidationQueryTimeout(validationQueryTimeout);
        try {
            datasource.setFilters(filters);
        } catch (SQLException e) {
            System.err.println("druid configuration initialization filter: " + e);
        }
        return datasource;
    }

}
