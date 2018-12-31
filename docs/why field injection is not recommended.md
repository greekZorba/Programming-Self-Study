## Field Injection을 추천하지 않는 이유(+Contructor Injection을 추천하는 이유)
의존성 주입을 할 때 Field Injection은 좋지 않다는 글을 읽고 왜 그런지 찾아봤다. 스택오버플로 뿐만 아니라 스프링팀에서도 Field Injection을 추천하지 않았다. 왜 그런지 몇가지 글을 보고 종합해서 정리해본다.<br>

일단, 의존성 주입의 종류로는 Constructor, Setter, Field 타입이 있다. 

1. **Constructor(생성자)**
```java
public class ExampleCase{

    private final ChocolateService chocolateService;

    private final DrinkService drinkService;

    @Autowired
    public ExampleCase(ChocolateService chocolateService, DrinkService drinkService){
        this.chocolateService = chocolateService;
        this.drinkService = drinkService;
    }
}
``` 
2. **Setter**
```java
public class ExampleCase{
    
    private ChocolateService chocolateService;

    private DrinkService drinkService;

    @Autowired
    public void setChocolateService(ChocolateService chocolateService){
        this.chocolateService = chocolateService;
    }

    @Autowired
    public void setDrinkService(DrinkService drinkService){
        this.drinkService = drinkService;
    }
}
```
3. **Field**
```java
public class ExampleCase{

    @Autowired
    private ChocolateService chocolateService;

    @Autowired
    private DrinkService drinkService;
}
```
사실 Field Injection이 사용하기 간편하고 코드도 심플해보인다. 그래도 추천하지 않는 이유는 무엇일까? <br>

**단일 책임의 원칙 위반** <br>
의존성을 주입하기가 쉽다. @Autowired 선언 아래 3개든 10개든 막 추가할 수 있으니 말이다. 여기서 Constructor Injection을 사용하면 다른 Injection 타입에 비해 위기감 같은 걸 느끼게 해준다. Constructor의 파라미터가 많아짐과 동시에 하나의 클래스가 많은 책임을 떠안는다는 걸 알게된다. 이때 이러한 징조들이 리팩토링을 해야한다는 신호가 될 수 있다. <br><br>
**의존성이 숨는다.**<br>
DI(Dependency Injection) 컨테이너를 사용한다는 것은 클래스가 자신의 의존성만 책임진다는게 아니다. 제공된 의존성 또한 책임진다. 그래서 클래스가 어떤 의존성을 책임지지 않을 때, 메서드나 생성자를 통해(Setter나 Contructor) 확실히 커뮤니케이션이 되어야한다. 하지만 Field Injection은 숨은 의존성만 제공해준다.
<br><br>
**DI 컨테이너의 결합성과 테스트 용이성**<br>
DI 프레임워크의 핵심 아이디어는 관리되는 클래스가 DI 컨테이너에 의존성이 없어야 한다. 즉, 필요한 의존성을 전달하면 독립적으로 인스턴스화 할 수 있는 단순 POJO여야한다. DI 컨테이너 없이도 유닛테스트에서 인스턴스화 시킬 수 있고, 각각 나누어서 테스트도 할 수 있다. 컨테이너의 결합성이 없다면 관리하거나 관리하지 않는 클래스를 사용할 수 있고, 심지어 다른 DI 컨테이너로 전환할 수 있다. <br>
하지만, Field Injection을 사용하면 필요한 의존성을 가진 클래스를 곧바로 인스턴스화 시킬 수 없다. 
<br><br>
**불변성(Immutability)**<br>
Contructor Injection과 다르게 Field Injection은 final을 선언할 수 없다. 그래서 객체가 변할 수 있다.  
<br><br>
**순환 의존성**<br>
Constructor Injection에서 순환 의존성을 가질 경우 BeanCurrentlyCreationExeption을 발생시킴으로써 순환 의존성을 알 수 있다. 
* 순환 의존성이란? First Class가 Second Class를 참조하는데 Second Class가 다시 First Class를 참조할 경우 혹은 First Class가 Second Class를 참조하고, Second Class가 Third Class를 참조하고 Third Class가 First Class를 참조하는 경우 이를 순환 의존성이라고 부른다. 
<br><br>

**Setter Injection Vs Contructor Injection** <br><br>
**Setter Injection**<br>
Setter Injection은 선택적인 의존성을 사용할 때 유용하다. 상황에 따라 의존성 주입이 가능하다. 스프링 3.x 다큐멘테이션에서는 Setter Injection을 추천했었다. 
<br><br>
**Constructor Injection**<br>
Constructor Injection은 필수적인 의존성 주입에 유용하다. 게다가 final을 선언할 수 있으므로 객체가 불변하도록 할 수 있다. 또한 위에서 언급했듯이 순환 의존성도 알 수 있다. 그로인해 나쁜 디자인 패턴인지 아닌지 판단할 수 있다. <br> 스프링 4.3버전부터는 클래스를 완벽하게 DI 프레임워크로부터 분리할 수 있다. 단일 생성자에 한해 @Autowired를 붙이지 않아도 된다.(완전 편한데?!) 이러한 장점들 때문에 스프링 4.x 다큐멘테이션에서는 더이상 Setter Injection이 아닌 Constructor Injection을 권장한다. 굳이 Setter Injection을 사용한다면, 합리적인 디폴트를 부여할 수 있고 선택적인(optional) 의존성을 사용할 때만 사용해야한다고 말한다. 그렇지 않으면 not-null 체크를 의존성을 사용하는 모든 코드에 구현해야한다.
<br><br>
후기 : Field Injection이 읽기 쉽고 사용하기 쉽다는 평이 있지만, 절대 다수가 Contructor Injection 사용을 권장하고 있다는 걸 느꼈다. Field Injection이 사용하기에는 간단하지만, 더 좋은 디자인 패턴과 코드 품질을 위해 Contructor Injection을 사용해야겠다. 포스팅을 하면서 왜 Contructor Injection을 써야하는지 알게 된 계기도 됐고 말이다.



