package blog.spring.pick;

import blog.spring.notme.Dependency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
public class SomeConfig {

    @Bean
    public Dependency dependency() {
        return mock(Dependency.class);
    }
}

