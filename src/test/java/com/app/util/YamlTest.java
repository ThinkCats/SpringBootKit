package com.app.util;

import com.app.BaseApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

/**
 * Created by wl on 16/7/7.
 */

@Slf4j
public class YamlTest extends BaseApplicationTests {

    @Test
    public void testYaml() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("config/yml/test.yml");
        try {
            TestModel model = mapper.readValue(resource.getInputStream(), TestModel.class);
            log.info("model:" + model.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("resource:" + resource);
    }
}

@Data
class TestModel {
    private String title;
    private String subtitle;
    private String description;
    private String author;
}