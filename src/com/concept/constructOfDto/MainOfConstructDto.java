package com.concept.constructOfDto;

public class MainOfConstructDto {

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        ConstructDto constructDto = new ConstructDto();

        sb.append("DTO에서 생성자를 통해 default 값 세팅 \n");
        sb.append("회사 이름 default: "+constructDto.getCompName()+"\n");
        sb.append("사원 이름 default: "+constructDto.getEmpName()+"\n");
        sb.append("취미 default: "+constructDto.getHobby()+"\n");
        sb.append("결혼 유/무 default: "+constructDto.isMarryYn()+"\n");
        sb.append("입사일 default: "+constructDto.getJoinDate()+"\n\n\n");

        constructDto = new ConstructDto("연구원", 1000000);
        sb.append("positionName과 wage를 매개변수로 하는 생성자로 default 값 세팅하기 \n");
        sb.append("회사 이름 default: "+constructDto.getCompName()+"\n");
        sb.append("사원 이름 default: "+constructDto.getEmpName()+"\n");
        sb.append("취미 default: "+constructDto.getHobby()+"\n");
        sb.append("결혼 유/무 default: "+constructDto.isMarryYn()+"\n");
        sb.append("입사일 default: "+constructDto.getJoinDate()+"\n");
        sb.append("직책 이름 default: "+constructDto.getPositionName()+"\n");
        sb.append("월급 default: "+constructDto.getWage());

        System.out.println(sb.toString());
    }
}
