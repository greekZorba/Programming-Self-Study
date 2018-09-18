package com.concept.aboutDTO;

public class ChildDTO extends ParentDTO{ // ParentDTO를 부모 클래스로 상속받음 - 자식 DTO

    private String childValue = "";

    public String getChildValue() {
        return childValue;
    }

    public void setChildValue(String childValue) {
        this.childValue = childValue;
    }
}
