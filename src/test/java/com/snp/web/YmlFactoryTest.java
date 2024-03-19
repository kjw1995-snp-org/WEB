package com.snp.web;

import com.snp.web.configuration.properties.BaseProperties;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class YmlFactoryTest {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BaseProperties baseProperties;

    @Test
    public void ymlFactoryTest() {

        logger.info("Host = {}", baseProperties.getUserService().getHost());

    }


}
