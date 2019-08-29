package com.java8.lamda;

import java.util.function.Function;

public class LamdaRunnable {

    private String foo;

    public LamdaRunnable(String foo) {
        this.foo = foo;
    }

    public String getFoo() {
        return foo;
    }

    public static void main(String[] args) {

        // 인터페이스에 바로 코드 전달
        // 매개변수 없음
        // Runnable에 있는 유일한 메소드인 run에 대해 화살표 우측으로 재정의함
        Runnable run = () -> System.out.println("runnable!!!");
        run.run();

        // 생성자로 코드를 전달해서 실행
        Thread thread = new Thread(() -> System.out.println("runnable in Thread"));
        thread.start();
        thread.interrupt();

        // Function<매개변수 타입, 반환타입>
        // Class 이름 :: 해당 클래스의 메서드
        Function<String, LamdaRunnable> lamdaRunnableFunction = LamdaRunnable :: new;
        LamdaRunnable anotherRunnable = lamdaRunnableFunction.apply("foo");
        System.out.println(anotherRunnable.getFoo());

        TempLamdaInterface lamdaInterface = () -> System.out.println("tempLamda init run");
        lamdaInterface.init();

        ExtendLamdaInterface extendLamdaInterface = new ExtendLamdaInterface(() -> System.out.println("tempLamda run in class"));
        extendLamdaInterface.init();
    }

}
