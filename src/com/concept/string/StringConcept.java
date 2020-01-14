package com.concept.string;

/**
 *
 * 자바에서 쓰이는 모든 String 객체는 상수 풀에서 관리한다.
 * 상수 풀은 객체가 생성되는 영역인 heap의 permanent generation 영역에 생성되어
 * 자바 프로세스가 종료될 때 까지 함께한다.
 *
 * 상수 풀을 이용하여 String을 관리하는 이유는
 * 중복 문자열에 대한 효율적인 메모리 관리 때문이다.
 * 같은 문자열이 이미 존재하는데 다시 동일한 문자열이 상수 풀에 삽입되려는 경우,
 * 삽입을 위해 heap에 생성되었던 문자열을 해제하고 상수 풀에서 관리하는 래퍼런스로 반환한다.
 * 이렇게 함으로서 동일한 문자열로 인해 메모리가 낭비되는 현상을 해결한다.
 *
 * String 객체를 생성하는 방법에는 크게 2가지가 존재한다.
 * 첫번째로 리터럴("")을 이용한 방법
 * 이 경우 내부적으로 String 생성자로 객체를 heap 영역에 생성한 후
 * intern 메소드가 호출되어 상수 풀에 해당 객체를 등록하는 과정을 거친다.
 *
 * 두번째로 String 생성자를 이용하는 방법이 있다.
 * 이 경우 heap의 어떤 영역에 단순한 인스턴스로 저장한다.
 * 이 경우 상수 풀에 등록되지 않는다.
 * 후에 명시적으로 intern 메소드를 호출하여 상수 풀로 옮겨줄 수 있다.
 *
 * 상수 풀에 등록되어있는 문자열 객체의 경우 == 연산자를 이용하면,
 * 바로 두 문자열이 같은지 boolean 값으로 확인할 수 있다.
 * 하지만 String 생성자를 이용해 heap의 한 영역에 생성된 문자열 객체의 경우,
 * == 연산자를 이용하여 바로 두 문자열이 같은지 비교할 수 없다.
 * 두 문자열 객체의 래퍼런스 값이 다르기 때문이다.
 * 이 경우 String 클래스의 equals를 이용하여 두 문자열의 값을 비교할 수 있다.
 *
 *
 * * 알겠지만, '==' 연산자는 주소값(reference value)으로 값들을 비교한다.
 *
 * */
public class StringConcept {

    public boolean objectString() {
        String foo = new String("foo");
        String foo2 = new String("foo");

        return foo == foo2;
    }

    public boolean constantString() {
        String foo = "foo";
        String foo2 = "foo";

        return foo == foo2;
    }

    public boolean internString() {
        String foo = new String("foo");
        String foo2 = new String("foo");

        String internFoo = foo.intern();
        String internFoo2 = foo2.intern();

        return internFoo == internFoo2;
    }


    public static void main(String[] args) {
        StringConcept stringConcept = new StringConcept();

        System.out.println("new를 통해 객체로 만든 string으로 '==' 연산 비교 결과 : " + stringConcept.objectString());
        System.out.println("상수풀에서 관리되는 string으로 '==' 연산 비교 결과 : " + stringConcept.constantString());
        System.out.println("new를 통해 객체를 만든 string으로 다시 constant화 시키기 위해 intern 메서드를 적용 후, '==' 연산 비교 결과 : " + stringConcept.internString());

    }
}
