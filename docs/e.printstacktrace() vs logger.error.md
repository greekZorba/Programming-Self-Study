## e.printStackTrace() vs logger.error
e.printStackTrace()를 사용하지 말고 logger.error를 사용하라는 글을 읽었던 기억이 있다. 부가적인 설명이 있었는데, 뭔가 구체적으로 알고 싶어 스택오버플로를 뒤져봤다. 왜 써야하는지 많은 개발자분들이 댓글을 달아놨는데, 그 댓글들을 모아서 해석해 정리해두려한다.(별이 많은 댓글 중심으로 정리!) <br>
### answers
1. logback이나 log4j같은 logging framework를 사용하지 않으면 아래와 같은 코드를 작성할 것이다. 
```java
e.printStackTrace();
``` 
logging framework를 사용한다면, 아래와 같이 작성할 수 있다.
```java
logger.error("Error Occurs!!", e);
```
logging framework는 많은 다양성을 부여한다. 로그를 콘솔에 남길 것인지 파일에 남길 것인지 선택할 수 있고, 관계없다고 생각하는 메세지들을 건너뛸 수 있다. <br>

2. 예외 추적을 위해 printStackTrace()를 call한다면, System.err로 쓰여진다. 그리고 이는 제어하기 힘들다.(또는 필터링하거나) 대신 예외 로그를 남길 때 logging framework를 사용하면 아래와 같은 점들을 이용할 수 있다. 
- 로그를 다른 장소에 동시에 남길 수 있다. (예를 들어, 콘솔과 파일)
- 중요도 혹은 엄격성(예를 들어, error,debug,info,warning etc)에 따라 그리고 기본골격(?)(보통 package, class 기반) 로그를 필터링 할 수 있다.
- 코드 변화 없이 로그 포맷에 영향을 줄 수 있다.


개인적으로 e.printStackTrace()가 톰캣의 catalina.out에만 남지만, logger는 다른 위치에 파일로 저장할 수 있고, error message를 간단히 남길 수 있어서 좋다. 

참조글:<br> [Avoid printStackTrace(); use a logger call instead](https://stackoverflow.com/questions/10477607/avoid-printstacktrace-use-a-logger-call-instead/10477680)