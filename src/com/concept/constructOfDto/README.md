# DTO에서 생성자를 통해 default value 생성하기
insert를 할 경우 기본값이 있다면 DTO에서 만들어주고 Primary key가 될 변수만 새로운 값을 넣어주면 된다.<br>

<u>생성자를 통해 default 값을 만든 이유는 현재 회사에서 개발중인 메뉴가 __환경설정__ 부분이기 때문이다.</u> 사용자가 따로 설정해두지 않으면 default값이 들어가 있도록 하기 위해서다. _(최초 메뉴 사용 시 설정된 값이 없을 것이기 때문에 최초 메뉴 클릭시 default를 insert 해주도록)_<br>

기본 생성자를 통해 default값을 만들 수도 있고, 오버로딩을 통해 생성자에 매개변수를 넣어서 기본 값을 만들 수 있다.<br>

만들어 본 코드 예시
```java
public class ConstructDto {

    private String compName; // 회사 이름

    private String empName; // 사원 이름

    private String hobby; // 취미

    private boolean marryYn; // 결혼 유/무

    private Date joinDate; // 입사일

    private String positionName; // 직책명

    private int wage; // 월급


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

    /** 아무 매개변수 없이 default값을 생성해주는 생성자 */
    public ConstructDto(){

        this.compName = "chocolateFactory";

        this.empName = "zorba";

        this.hobby = "coding";

        this.marryYn = false;

        this.joinDate = new Date();
    }

    /** 직책명과 월급을 입력해주었을 때 직책명과 월급을 포함해 나머지 default값을 생성해준다 */
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
```
<br>
메인에서 호출할 때 코드

```java
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
```
<br>
결과 값은 아래처럼 나온다.<br>

```bash
DTO에서 생성자를 통해 default 값 세팅 
회사 이름 default: chocolateFactory
사원 이름 default: zorba
취미 default: coding
결혼 유/무 default: false
입사일 default: Tue Nov 20 01:10:05 KST 2018


positionName과 wage를 매개변수로 하는 생성자로 default 값 세팅하기 
회사 이름 default: chocolateFactory
사원 이름 default: zorba
취미 default: coding
결혼 유/무 default: false
입사일 default: Tue Nov 20 01:10:05 KST 2018
직책 이름 default: 연구원
월급 default: 1000000
```



