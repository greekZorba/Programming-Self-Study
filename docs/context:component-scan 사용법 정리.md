## context:component-scan 사용법
@Controller, @Service, @Repository, @Component 등의 애노테이션을 component-scan을 xml에 선언해서 사용하고 있다. 기존에 사용하는 component-scan 사용방식이 불필요해보여서 정리할 필요가 있다고 느껴져 선임님과 같이 찾아보고 수정을 했다. component-scan으로 애노테이션을 어떻게 스캔해서 사용하는지 정리하려고 한다. 
<br><br>
base-package는 패키지를 어디부터 스캔할지 지정해주는 부분이다. <u>스캔할 패키지를 여러개로 지정해줄 수도 있다.</u> 
```
<context:component:scan base-package="com.zorba.chocolate, com.zorba.redWine">
```
[spring 공식문서](https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch03s10.html)를 보면 component-scan 방법에 대해 잘 나와있다. 스프링 2.5버전 이상부터 stereotype 애노테이션인 @Component, @Service, @Controller, @Repository를 사용할 수 있다. 여기서 stereotype은 간략히 말해, 고정된 또는 일반적인 패턴을 의미한다. 그래서 @Controller가 선언된 클래스는 '아 컨트롤러로 사용하는 클래스구나'를 알 수 있다. 