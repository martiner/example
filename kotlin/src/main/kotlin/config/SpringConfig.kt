package config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ComponentScan

[Configuration]
[ComponentScan(array("dao"))]
public open class SpringConfig {

}