## Controller에서 객체로 파라미터 받기
@RequestParam이나 @ModelAttribute를 통해 파라미터를 Map, String, int로 이루어진 변수를 받고 있다가, 객체로 받으면 개발하면서 더 가시적이지 않을까라는 생각에 객체로 파라미터를 받는 법을 찾아보았다.


기존에 쓰던 방식.
```javascript

$.ajax({
    type: "GET",
    url: "<c:url value='/zorba/hello'/>",
    dataType: 'json',
    data: {"idx": idx, "factoryName": factoryName, "ownerName": ownerName, "location": location},
    success: function(data){
       // success
    }    
})
```

```java
    @ReqeustMapping(value="/zorba/hello")
    @ResponseBody
    public ChocolateBrand getChocolateBrand(HttpServletRequest request
        , @RequestParam int idx
        , @RequestParam String factoryName
        , @RequestParam String ownerName
        , @RequestParam String location){

        // something to do..

        return chocolateService.findChocolateBrand(파라미터);
    }
```


기존처럼 사용할 경우, 파라미터가 1~2개면 @RequestParam으로 받는 것이 눈으로 더 명확해보이지만, 파라미터가 3개가 넘어가면 파라미터를 줄줄 늘어놓는 것 같아 객체로 받는게 더 나은 것 같다. 

<u>클라이언트단에서 jQuery를 사용해서 ajax를 날리는데, **ajax를 날리는 파라미터 변수명과 Controller에서 받을 객체명을 동일** 하게 하면 Spring에서 자동으로 매핑해준다.</u>

그리고 바인딩을 위해서 객체(예시에서 ChocolateBrand)에는 파라미터로 들어갈 변수들에 대한 **getter/setter** 가 존재해야 받을 수 있다.


Controller에서 바로 객체로 받기
```javascript

var chocolateBrand = {};
chocolateBrand.idx = idx;
chocolateBrand.factoryName = factoryName;
chocolateBrand.ownerName = ownerName;
chocolateBrand.location = location;

$.ajax({
    type: "GET",
    url: "<c:url value='/zorba/hello'/>",
    dataType: 'json',
    data: chocolateBrand,
    success: function(data){
      // success
    }    
})

```
```java

    @ReqeustMapping(value="/zorba/hello")
    @ResponseBody
    public ChocolateBrand getChocolateBrand(HttpServletRequest request
        , ChocolateBrand chocolateBrand){

        // something to do..

        return chocolateService.findChocolateBrand(파라미터);
    }

```

```java

public class ChocolateBrand{
    // variables

    // getter, setter
}
```

일단 사용하긴 했는데, 마음에 안드는 부분은 setter 때문에 객체가 언제나 변할 수 있게 되었다는 것이다. setter 없이도 binding 할 수 있는 방법을 찾아봐야겠다.
(엇 힌트로 @InitBinder를 찾은거 같은데 더 찾아봐야겠다.)

참고 : https://stackoverflow.com/questions/16942193/spring-mvc-complex-object-as-get-requestparam
