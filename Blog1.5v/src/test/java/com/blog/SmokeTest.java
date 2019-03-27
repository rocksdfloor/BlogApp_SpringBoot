package com.blog;
  

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import controllers.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmokeTest.class)
@ComponentScan(basePackages = { "services", "models", "controllers" })
public class SmokeTest {

    @Autowired
    private HomeController controller;

    @Test
    public void passParametersWithModelAndView() throws Exception {
    	System.out.println("In Smoke test");
        assertThat(controller).isNotNull();
    }
}