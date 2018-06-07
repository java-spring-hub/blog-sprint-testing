# blog-sprint-testing

Source Code for examples at eBay blog post "Your own Spring test context".

The examples show how to limited the number of Spring beans initialized
on tests, reducing drastically its execution time.

Useful for considerably heavy Spring applications, where Spring context
initialization is slow.

## Examples:

### springmvc - Test examples using Spring MVC

 - `SomeControllerPickBeanITTest` - specifying each bean individually
 - `SomeControllerPackageITTest` - use package scan annotation to include beans

### jaxrs - Test examples using JAX-RS

 - `JaxRsSpringContextITTest` - start Spring context manually
 - `JaxRsControllerITTest` - starting web server with a JAX-RS REST controller registered

## Run tests
Go to the examples base directory and execute `mvn test`

## Requirements
* Maven 2+
* Java 7+
