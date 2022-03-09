import java.util.ArrayList;
import java.util.Scanner;

public class Skills {

    public Skills(){
    }
    //객체생성될때 스킬포인트3갖고 생성
    public Skills(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }

    int skillPoint;
    int water=0; //2
    int fire=0; //1
    int forest=0;  //3
    int hpSkill=0;
    int armorSkill=0;
    
    int damage;


    User user;
Scanner sc=new Scanner(System.in);
    ///skillView
    public static Skills skillView(Skills skills){
        ArrayList view=new ArrayList();
        view.add("화염발사           :  "+skills.getFire());
        view.add("물대포             :  "+skills.getWater());
        view.add("나뭇잎날리기        :  "+skills.getForest());
        view.add("체력회복           :  "+skills.getHpSkill());
        view.add("방어력증가         :   "+skills.getArmorSkill());
        view.add("보유스킬포인드      :   "+skills.getSkillPoint());
        System.out.println("User Skills");
        System.out.println("---------------------------------------------------------------------");
        for(int i=0;i< view.size();i++) {
            System.out.println(view.get(i)+"    ");
        }
        System.out.println("---------------------------------------------------------------------");
        return skills;
    }
    //skillUp
    Skills skillsUp(Skills skills){
        int num;
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. 화염발사  ㅣ   2.물대포  ㅣ    3.나뭇잎날리기  ㅣ  4.체력회복  ㅣ   5.방어력증가  ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        num= sc.nextInt();
        switch (num){
            case 1: fireUp(skills);
                break;
            case 2: waterUp(skills);
                break;
            case 3: forestUp(skills);
                break;
            case 4: hpSkillUp(skills);
                break;
            case 5: armorSkill(skills);
                break;
        }
            return skills;
    }

    //skillUp메서드 해당스킬스탯+1, 보유스킬스탯-1
    //-------------------------------------------------
    void fireUp(Skills skills){
        System.out.println("파이어");
        setFire(getFire()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    void waterUp(Skills skills){
        System.out.println("물");
        setWater(getWater()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    void forestUp(Skills skills){
        setForest(getForest()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    void hpSkillUp(Skills skills){
        setHpSkill(getHpSkill()+20);
        setSkillPoint(getSkillPoint()-1);
    }
    void armorSkill(Skills skills){
        setArmorSkill(getArmorSkill()+1);
        setSkillPoint(getSkillPoint()-1);
    }
    //스킬포인트-------------------------------------------------



    //스킬메서드
    void ArmorUp(User user,Skills skills){
        user.setDefense(user.getDefense()+skills.getArmorSkill()*3);
    }
    void hpRecovery(User user,Skills skills){
        user.setRealHp(user.getHp()+skills.getHpSkill()*10);
    }
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
        if(user.realHp>user.getHp()){
            user.realHp=user.getHp();
        }
        this.hpSkill = hpSkill;
    }

    public int getArmorSkill() {
        return armorSkill;
    }

    public void setArmorSkill(int armorSkill) {
        this.armorSkill = armorSkill;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

   /* public Com getCom() {
        return com;
    }

    public void setCom(Com com) {
        this.com = com;
    }*/
}
//속성에따라 데미지 다름
