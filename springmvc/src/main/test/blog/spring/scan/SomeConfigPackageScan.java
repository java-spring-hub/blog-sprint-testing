package blog.spring.scan;

import blog.spring.notme.Dependency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

/**
 * Configuration bean required to setup Dependency mock.
 *
 * Uses {@code ComponentScan} to include directory 'blog.spring.justme' on Spring context.
 */
@Configuration
@ComponentScan("blog.spring.justme")
public class SomeConfigPackageScan {

    @Bean
    public Dependency dependency() {
        return mock(Dependency.class);
    }
}

