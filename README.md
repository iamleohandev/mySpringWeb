mySpringWeb
===========
Caption:

When I work on sperating the two contexts (web applicationContext and root applicationContext), 
I put the component-scan for the @Controller in the web applicationContext, and component-scan for the 
@Service, @Repository, @Component in the root applicationContext.

It all works fine, until the Spring security kickin


if add multiple security:authentication-provider then, it will cause a autowired problem, I will take at look at it later
