package blog.spring.jaxrs;

import blog.spring.justme.JaxRsController;
import blog.spring.notme.Dependency;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Simple example on how to start Spring context, using a annotation-based approach.
 */
public class JaxRsSpringContextITTest {

    @Test
    public void testSimplyStartingSpringContext(){
        ApplicationContext springContext = new AnnotationConfigApplicationContext("blog.spring.justme", "blog.spring.jaxrs");

        Dependency dependency = springContext.getBean(Dependency.class);
        JaxRsController jaxRsController =  (JaxRsController) springContext.getBean("jaxRsController");
        String id = "id";
        String description = "description";
        when(dependency.getItemDescription(id)).thenReturn(description);

        assertThat(jaxRsController.getItemDescription(id), is(description));
    }

}
