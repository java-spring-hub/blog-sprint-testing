package blog.spring.jaxrs;

import blog.spring.justme.JaxRsController;
import blog.spring.notme.Dependency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

/**
 * Configuration bean for JAX-RS tests. It sets up Dependency mock on Spring context to be used on tests.
 */
@Configuration
public class JaxRsConfig {

    @Bean
    public Dependency dependency() {
        return mock(Dependency.class);
    }
}
