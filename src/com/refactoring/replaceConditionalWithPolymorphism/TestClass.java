package com.refactoring.replaceConditionalWithPolymorphism;

public class TestClass {

    class EmployeeType{

        public int getSalary() {
            return 1;
        }
    }

    abstract class abstractClass{

        abstract int payment(EmployeeType emp);
    }


    class Saleman extends abstractClass {

        @Override
        int payment(EmployeeType emp) {
            return emp.getSalary() + 10;
        }

    }

    class Manager extends abstractClass {

        @Override
        int payment(EmployeeType emp) {
            return emp.getSalary() + 20;
        }

    }

    public void testMethod() {
        abstractClass temp = new Saleman();
        temp.payment(new EmployeeType());
    }





}

