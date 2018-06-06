package blog.spring.jaxrs;

import blog.spring.justme.JaxRsController;
import blog.spring.notme.Dependency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class JaxRsConfig {

    @Bean
    public Dependency dependency() {
        return mock(Dependency.class);
    }

    @Bean
    public JaxRsController jaxRsController() { return new JaxRsController();}
}
