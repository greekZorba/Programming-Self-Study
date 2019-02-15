## context:component-scan 사용법
@Controller, @Service, @Repository, @Component 등의 애노테이션을 component-scan을 xml에 선언해서 사용하고 있다. 기존에 사용하는 component-scan 사용방식이 불필요해보여서 정리할 필요가 있다고 느껴져 선임님과 같이 찾아보고 수정을 했다. component-scan으로 애노테이션을 어떻게 스캔해서 사용하는지 정리하려고 한다. 
<br><br>
base-package는 패키지를 어디부터 스캔할지 지정해주는 부분이다. <u>스캔할 패키지를 여러개로 지정해줄 수도 있다.</u> 
```
<context:component:scan base-package="com.zorba.chocolate, com.zorba.redWine">
```
[spring 공식문서](https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch03s10.html)를 보면 component-scan 방법에 대해 잘 나와있다. 스프링 2.5버전 이상부터 stereotype 애노테이션인 @Component, @Service, @Controller, @Repository를 사용할 수 있다. 여기서 stereotype은 간략히 말해, 고정된 또는 일반적인 패턴을 의미한다. 그래서 @Controller가 선언된 클래스는 '아 컨트롤러로 사용하는 클래스구나'를 알 수 있다. 
  
component-scan은 커스텀으로 만들어서 스캔할 수도 있다지만 커스텀용 빈을 만들어쓰진 않아서 찾아보진 않았다. 여기서 **디폴트**가 중요한데, @Component, @Controller, @Service, @Repository로 등록된 빈은 **디폴트**로 스캔해준다. 
  
```java
  package com.zorba.chocolate;
  
  @Controller
  public class ChocolateController{
     // ... do something
  }
```
  
```
  <context:component:scan base-package="com.zorba.chocolate">
```
  
디폴트(@Component, @Controller, @Service, @Repository) 애노테이션을 스캔하지 않는 방법도 있는데, <u>use-default-filters</u>를 이용하면 된다. 기본값은 true이기 때문에 false로 선언해주면 디폴트 애노테이션들을 스캔하지 않는다.
  
```
  <context:component:scan base-package="com.zorba.chocolate" use-default-filters="false">
```
  
사용자가 원하는데로 이런 스캔되는 빈들을 넣고 빼고 해줄 수 있는데, 예를 들어 우리 회사의 경우 @Controller를 스캔하는 xml과 @Service, @Repository를 스캔하는 xml을 따로 두고 있다. 그래서 @Controller만 스캔하는 xml에서는 나머지는 애노테이션들은 스캔할 필요가 없다. @Service, @Repository를 이용하는 xml에서는 @Controller 애노테이션을 스캔할 필요없다.
  
*include-filter* 옵션을 사용하면 해당되는 애노테이션을 스캔대상에 포함할 수 있고, *exclude-filter*옵션을 사용하면 해당되는 애노테이션을 스캔대상에서 제외할 수 있다.
  
*exclude-filter*를 사용해 @Controller를 스캔대상에서 제외시켰고, 나머지 애노테이션들은 디폴트로 스캔한다.
  
```
  <context:component-scan base-package="com.zorba.redWine">
  	<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller" />		
  </context:component-scan>
```
  
*include-filter*와 *use-default-filters* 옵션들을 사용해 디폴트 애노테이션들을 스캔대상에서 제외하고 @Controller만 스캔할 수 있도록 설정하였다.
  
```
  <context:component-scan base-package="com.zorba.redWine" use-default-filters="false">
	<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller" />
  </context:component-scan>
```
  
최근에는 component-scan을 xml보다는 java단에서 애노테이션으로 정리한다고 하는데, 스프링부트가 아닌 스프링 레거시 프로젝트를 사용하는 회사에서는 xml로 설정된 것이 많을거라고 생각해서 정리해보았다.(우리 회사 포함) 회사에서 사용하던 기존 레거시는 급하게 만들었는지 디폴트로 스캔하는 애노테이션들까지 include-filter로 포함시키고 있었고 이번 공부를 통해서 불필요한 xml 선언들을 제거할 수 있었다.  

