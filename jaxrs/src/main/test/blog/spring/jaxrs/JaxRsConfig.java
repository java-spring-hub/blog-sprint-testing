package blog.spring.jaxrs;

import blog.spring.justme.JaxRsController;
import blog.spring.notme.Dependency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class JaxRsConfig {

    @Bean
    public JaxRsController jaxRcController() {
        return new JaxRsController();
    }


    @Bean
    public Dependency dependency() {
        return mock(Dependency.class);
    }
}
