package blog.spring.jaxrs;

import com.google.common.collect.ImmutableSet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.Set;

/**
 * Supporting code for tests  - Starts a JAX-RS application. Spring context is started manually, using
 * {@code AnnotationConfigApplicationContext}. This annotation enables Spring annotation-based
 * configuration. All annotated Spring beans contained in packages 'blog.spring.justme' and
 * 'blog.spring.jaxrs' are included in the Spring context.
 */
@ApplicationPath("rs")
public class JaxRsApplication extends Application {
    protected ApplicationContext springContext;

    @Context
    protected ServletContext servletContext;

    public Set<Object> getSingletons() {
        try {

            springContext = new AnnotationConfigApplicationContext("blog.spring.justme", "blog.spring.jaxrs");

            return ImmutableSet.of(springContext.getBean("jaxRsController"));

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public ApplicationContext springContext() {
        return springContext;
    }

}
