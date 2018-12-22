## [JUnit] Argument(s) are different! Wanted:
JUnit Controller 테스트에서 validation 중에 발생한 에러!! 에러가 설명하듯이 인자가 다르단다. 어? 근데 콘솔 찍히는거보면 똑같은데 왜 다르다고 뜨지?라는 의문이 생겼다. <br>
테스트 코드는 아래와 같이 작성했었다. coffeeDTO에 데이터를 심고 getCustomerList에 coffeeDTO를 담아서 컨트롤러와 서비스가 잘 동작하고 있는지 체크하는 테스트코드다. 
```java
CoffeeDTO coffeeDTO = new CoffeeDTO;
coffeeDTO.setCoffeeName("블루마운틴");
coffeeDTO.setCountry("Jamaica");
coffeeDTO.setPrice("4000");

/**
* 다른 컨트롤러 테스트...
*/

verify(getCoffeeService, times(1)).getCustomerList(coffeeDTO);
```
왜 안되는지 찾아보니 <u>Object(객체)의 비교가 동작이 잘 안될 때도 있단다.</u> 테스트코드 서비스의 메서드에 넣어준 coffeeDTO와 실제 controller를 거치면서 가공된 coffeeDTO가 동일한지 비교하는 것으로 보였다. (예를 들어 컨트롤러를 탈 때 컨트롤러 메서드 안에서 매개변수가 변형될 수도 있다. 컨트롤러 메서드 안에서 coffeeDTO.setOtherObject("some content") 등이 추가될 수 있으니까)<br>

인자가 똑같도록 맞춰주었음에도 객체 비교가 잘 안되는지 Argument(s) are different! Wanted: 에러를 뱉었다. <br>

해결방법은 <u>mockito가 제공하는 Matchers 클래스의 **refEq()** 를 사용하면 된다.</u> javadoc에는 refEq()에 대해 이렇게 설명한다. <br>

*Object argument that is reflection-equal to the given value with support for excluding selected fields from a class.*  <br>

발해석을 해보자면 클래스에서 선택된 필드를 제외하고 주어진 값을 그대로 반영하는 객체 인자(?)라는 의미로 보인다. 이렇게 감싸니 같은 객체로 인식했는지 테스트가 통과했다! <br>

변경된 테스트 코드
```java
CoffeeDTO coffeeDTO = new CoffeeDTO;
coffeeDTO.setCoffeeName("블루마운틴");
coffeeDTO.setCountry("Jamaica");
coffeeDTO.setPrice("4000");

/**
* 다른 컨트롤러 테스트...
*/

verify(getCoffeeService, times(1)).getCustomerList(refEq(coffeeDTO));
```