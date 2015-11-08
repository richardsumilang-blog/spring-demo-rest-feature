package com.richardsumilang.feature;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FeatureApplication.class)
@WebAppConfiguration
public class FeatureApplicationTests {

	@Test
	public void contextLoads() {
	}

}
