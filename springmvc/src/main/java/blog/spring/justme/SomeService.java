package blog.spring.justme;

import blog.spring.notme.Dependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeService {

    @Autowired
    Dependency dependency;

    public String getItemDescription(String id){
        return dependency.getItemDescription(id);
    }
}
