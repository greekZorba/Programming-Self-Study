## Controller에서 객체로 파라미터 받기
@RequestParam이나 @ModelAttribute를 통해 파라미터를 Map, String, int로 이루어진 변수를 받고 있다가, 객체로 받으면 개발하면서 더 가시적이지 않을까라는 생각에 객체로 파라미터를 받는 법을 찾아보았다.

기존에 쓰던 방식.
```java
    @ReqeustMapping(value="/zorba/hello")
    @ResponseBody
    public ChocolateBrand getChocolateBrand(HttpServletRequest request, @RequestParam int idx, @RequestParam String factoryName, @RequestParam String ownerName){

        // something to do..

        return chocolateService.getChocolateBrand(파라미터);
    }
```

기존처럼 사용할 경우, 파라미터가 1~2개면 @RequestParam으로 받는 것이 눈으로 더 명확해보이지만, 파라미터가 3개가 넘어가면 파라미터를 줄줄 늘어놓는 것 같아 객체로 받는게 더 나은 것 같다. 

클라이언트단에서 jQuery를 사용해서 ajax를 날리는데, ajax를 날리는 변수명과 Controller에서 받을 객체명을 동일하게 하면 Spring에서 자동으로 매핑해준다.




참고: https://blog.trifork.com/2011/12/08/use-immutable-objects-in-your-spring-mvc-controller-by-implementing-your-own-webargumentresolver/