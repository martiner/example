/*
 * Copyright (C) 2007-2013, GoodData(R) Corporation. All rights reserved.
 */
package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("web")
public class SpringWebConfig {
}
