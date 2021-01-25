package com.lmy.blog.domain.datasourceconfig;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author lmy
 * @email 2818026900@qq.com
 * @apiNote 实现yaml配置文件的加载解析
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String s, EncodedResource encodedResource) throws IOException {
        Properties propertiesFromYaml = loadYamlIntoProperties(encodedResource);
        String sourceName = s != null ? s :  encodedResource.getResource().getFilename();
        return new PropertiesPropertySource(sourceName, propertiesFromYaml);
    }

    private Properties loadYamlIntoProperties(EncodedResource encodedResource) throws FileNotFoundException {
        try{
            YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
            factoryBean.setResources(encodedResource.getResource());
            factoryBean.afterPropertiesSet();
            return factoryBean.getObject();
        }catch (IllegalStateException e){
            Throwable cause = e.getCause();
            if(cause instanceof  FileNotFoundException) {
                throw (FileNotFoundException)
                        e.getCause();
            }
            throw e;
        }
    }
}
