package blog.spring.pick;

import blog.spring.justme.SomeController;
import blog.spring.justme.SomeService;
import blog.spring.notme.Dependency;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.internal.matchers.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test example include beans individually on Spring context. Dependency mock initialized at {@code SomeConfig}
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                SomeConfig.class,
                SomeController.class,
                SomeService.class
        })
public class SomeControllerPickBeanITTest {

    @Autowired
    private Dependency dependency;

    @Autowired
    private SomeController someController;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(someController).build();
    }

    @Test
    public void testWithBeanPickForContext() throws Exception {
        String id = "id";
        String description = "description";

        when(dependency.getItemDescription(id)).thenReturn(description);

        mvc.perform(
                get("/item/" + id)).
                andExpect(status().isOk()).
                andExpect(content().string(containsString("description")));
    }
}
