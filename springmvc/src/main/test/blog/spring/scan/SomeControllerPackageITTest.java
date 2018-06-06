package blog.spring.scan;

import blog.spring.justme.SomeController;
import blog.spring.notme.Dependency;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.inject.Inject;

import static org.junit.internal.matchers.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SomeConfigPackageScan.class })
public class SomeControllerPackageITTest {

    @Inject
    private SomeController someController;

    @Inject
    private Dependency dependency;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(someController).build();
    }

    @Test
    public void testWithPackageScanAnnotation() throws Exception {
        String id = "id";
        String description = "description";

        when(dependency.getItemDescription(id)).thenReturn(description);

        mvc.perform(
                get("/item/" + id)).
                andExpect(status().isOk()).
                andExpect(content().string(containsString("description")));
    }
}
