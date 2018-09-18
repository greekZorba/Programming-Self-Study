package com.concept.aboutDTO;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/******************************************************************************************
 *
 * 2019.09.18
 *
 * DTO를 상속해서 사용하면 곧바로 자식 DTO에서 부모 DTO를 꺼내 쓰는 건 가능하지만,
 * HashMap에 담는 순간, 파라미터는 자식 DTO의 객체만 들어간다.
 *
 *****************************************************************************************/
public class TestMain {

    public static void main(String[] args){
        ChildDTO childDTO = new ChildDTO();

        childDTO.setParentValue("이것은 부모 DTO의 객체");

        System.out.println("자식 DTO에서 부모 DTO로 바로 접근했을 경우 부모 객체의 값: "
                            + childDTO.getParentValue());

        /* DTO를 Map 형식으로 바꿔줌 */
        Map<String, Object> param = new HashMap<>();
        try {
            Field[] fields = childDTO.getClass().getDeclaredFields();

            for (int i = 0; i <= fields.length - 1; i++) {
                fields[i].setAccessible(true);
                param.put(fields[i].getName(), fields[i].get(childDTO));
            }
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("자식 DTO를 HashMap에 담았을 경우, 결과 값: "+param.toString());

    }
}
