import java.util.ArrayList;
import java.util.Scanner;

public class Skills {
    Scanner sc=new Scanner(System.in);
    public Skills(){
    }
    //객체생성될때 스킬포인트3갖고 생성
    private int skillPoint;
    private int water=0; //2
    private int fire=0; //1
    private int forest=0;  //3
    private int hpSkill=0;
    private int armorSkill=0;
    private int skillPower;
    ///skillView
    public Skills skillView(User user){
        ArrayList view=new ArrayList();
        view.add("화염발사           : [ "+user.getSkills().getFire()+" ]");
        view.add("물대포             : [ "+user.getSkills().getWater()+" ]");
        view.add("나뭇잎날리기        : [ "+user.getSkills().getForest()+" ]");
        view.add("체력회복           : [ "+user.getSkills().getHpSkill()+" ]");
        view.add("방어력증가         : [ "+user.getSkills().getArmorSkill()+" ]");
        view.add("보유스킬포인드      : [ "+user.getSkills().getSkillPoint()+" ]");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("User Skills");
        System.out.println("---------------------------------------------------------------------");
        for(int i=0;i< view.size();i++) {
            System.out.println(view.get(i)+"    ");
        }
        System.out.println("---------------------------------------------------------------------");
        return user.getSkills();
    }
    //skillUp
    Skills skillsUp(User user){
        System.out.println("" +
                        "███████╗██╗  ██╗██╗██╗     ██╗         ██╗     ██╗███████╗████████╗\n" +
                        "██╔════╝██║ ██╔╝██║██║     ██║         ██║     ██║██╔════╝╚══██╔══╝\n" +
                        "███████╗█████╔╝ ██║██║     ██║         ██║     ██║███████╗   ██║   \n" +
                        "╚════██║██╔═██╗ ██║██║     ██║         ██║     ██║╚════██║   ██║   \n" +
                        "███████║██║  ██╗██║███████╗███████╗    ███████╗██║███████║   ██║   \n" +
                        "╚══════╝╚═╝  ╚═╝╚═╝╚══════╝╚══════╝    ╚══════╝╚═╝╚══════╝   ╚═╝   \n" +
                        "                                                                   ");
        int num;
        boolean flag=true;
        while(flag) {
            user.getSkills().skillView(user);
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("1. 화염발사  ㅣ   2.물대포  ㅣ    3.나뭇잎날리기  ㅣ  4.체력회복  ㅣ   5.방어력증가  ㅣ  6.돌아가기");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            num = project.예외();
            if (user.getSkills().getSkillPoint() > 0) {
                switch (num) {
                    case 1:
                        fireUp(user.getSkills());
                        System.out.println(ConsoleColors.FONT_YELLOW+" 화염발사 +1 "+ConsoleColors.RESET);
                        break;
                    case 2:
                        waterUp(user.getSkills());
                        System.out.println(ConsoleColors.FONT_YELLOW+" 물대포 +1 "+ConsoleColors.RESET);
                        break;
                    case 3:
                        forestUp(user.getSkills());
                        System.out.println(ConsoleColors.FONT_YELLOW+" 나뭇잎날리기 +1 "+ConsoleColors.RESET);
                        break;
                    case 4:
                        hpSkillUp(user.getSkills());
                        System.out.println(ConsoleColors.FONT_YELLOW+"  체력회복+1 "+ConsoleColors.RESET);
                        break;
                    case 5:
                        armorSkill(user.getSkills());
                        System.out.println(ConsoleColors.FONT_YELLOW+" 방어력증가 +1 "+ConsoleColors.RESET);
                        break;
                    case 6:
                        flag=false;
                        break;
                }
            } else {
                if(num==6){
                    flag=false;
                }else {
                    System.out.println(ConsoleColors.FONT_RED + "스킬포인트가 부족합니다.( 나가기 : 6 )" + ConsoleColors.RESET);
                }
            }
        }
        return user.getSkills();
    }
    //-------------------------------------------------
    void fireUp(Skills skills){
        setFire(getFire()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    void waterUp(Skills skills){
        setWater(getWater()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    void forestUp(Skills skills){
        setForest(getForest()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    void hpSkillUp(Skills skills){
        setHpSkill(getHpSkill()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    void armorSkill(Skills skills){
        setArmorSkill(getArmorSkill()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    //스킬메서드
    int ArmorUp(User user){
        user.setDefense(user.getDefense()+user.getSkills().getArmorSkill()*3);
        user.setRealMp(user.getRealMp()-5);
        return user.getSkills().getArmorSkill();
    }
    void hpRecovery(User user){
        if(user.getSkills().getHpSkill()==0){
            System.out.println("스킬포인트가 0 입니다. 사용할 수 없습니다");
        }else {
            user.setRealHp(user.getRealHp()+user.getSkills().getHpSkill()*20);
            user.setRealMp(user.getRealMp()-5);
        }
    }

    // getter, setter
    public int getWater() {
        return water;
    }
    public void setWater(int water) {
        this.water = water;
    }
    public int getFire() {
        return fire;
    }
    public void setFire(int fire) {
        this.fire = fire;
    }
    public int getForest() {
        return forest;
    }
    public void setForest(int forest) {
        this.forest = forest;
    }
    public int getHpSkill() {
        return hpSkill;
    }
    public void setHpSkill(int hpSkill) {
        this.hpSkill = hpSkill;
    }
    public int getArmorSkill() {
        return armorSkill;
    }
    public void setArmorSkill(int armorSkill) {
        this.armorSkill = armorSkill;
    }
    public int getSkillPower() {
        return skillPower;
    }
    public Skills(int skillPoint) {
        this.skillPoint = skillPoint;
    }
    public int getSkillPoint() {
        return skillPoint;
    }
    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }
    public void setSkillPower(int skillPower) {
        this.skillPower = skillPower;
    }
}
