package com.concept.constructOfDto;

import java.util.Date;

public class ConstructDto {

    private String compName;

    private String empName;

    private String hobby;

    private boolean marryYn;

    private Date joinDate;

    private String positionName;

    private int wage;


    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean isMarryYn() {
        return marryYn;
    }

    public void setMarryYn(boolean marryYn) {
        this.marryYn = marryYn;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public ConstructDto(){

        this.compName = "chocolateFactory";

        this.empName = "zorba";

        this.hobby = "coding";

        this.marryYn = false;

        this.joinDate = new Date();
    }

    public ConstructDto(String positionName, int wage){

        this.compName = "chocolateFactory";

        this.empName = "zorba";

        this.hobby = "coding";

        this.marryYn = false;

        this.joinDate = new Date();

        this.positionName = positionName;

        this.wage = wage;
    }

    @Override
    public String toString() {
        return "ConstructDto{" +
                "compName='" + compName + '\'' +
                ", empName='" + empName + '\'' +
                ", hobby='" + hobby + '\'' +
                ", marryYn=" + marryYn +
                ", joinDate=" + joinDate +
                ", positionName='" + positionName + '\'' +
                ", wage=" + wage +
                '}';
    }




}
