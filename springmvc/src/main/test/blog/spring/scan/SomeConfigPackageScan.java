package blog.spring.scan;

import blog.spring.notme.Dependency;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
@ComponentScan("blog.spring.justme")
public class SomeConfigPackageScan {

    @Bean
    public Dependency dependency() {
        return mock(Dependency.class);
    }
}

