import java.util.logging.ConsoleHandler;

import static jdk.jfr.internal.consumer.EventLog.stop;

public class HpSkill extends Skills implements Runnable{
    User user;
    Skills skills;
    Monster monster;
    public HpSkill(User user, Skills skills,Monster monster){
        this.skills=skills;
        this.user=user;
        this.monster=monster;
    }
    public HpSkill(User user, Skills skills){
        this.skills=skills;
        this.user=user;
        this.monster=monster;
    }
    int i=0;
    boolean flag=true;
    @Override
    public void run() {
        try {
            if(user.getRealHp()<0){
                i=skills.getHpSkill();
                Thread.interrupted();
                return;
            }
            System.out.println(ConsoleColors.FONT_BLUE+"현재 MP : "+user.getRealMp()+" / 총 MP : "+user.getMp()+ConsoleColors.RESET);
            for(int i=0;i< skills.getHpSkill();i++){ //스킬 포인트만큼 횟수
                if(user.getRealHp()<0){
                    i=skills.getHpSkill();
                    Thread.interrupted();
                    break;
                }
                hpRecovery(user,skills);
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                System.out.println(ConsoleColors.BACKGROUND_BLUE+"                                                    "+(i+1)+"번쨰 hill"+ConsoleColors.RESET);
                System.out.println(ConsoleColors.FONT_BLUE+"                                                   "+user.getRealHp()+" / "+user.getHp()+ConsoleColors.RESET);
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                if(user.getRealHp()<0){
                    i=skills.getHpSkill();
                    Thread.interrupted();
                    break;
                }
                Thread.sleep(3000); //3초마다 ex)체력스킬이 3이면 3회 3초간격으로 체력회복
            }

            if(user.getRealHp()>0){
                System.out.println("                                                             체력회복스킬 완료!!!(메뉴탭 : 0)");
                return;
            }
            if(user.getRealHp()<0){
                i=skills.getHpSkill();
                Thread.interrupted();
                return;
            }
        }catch (InterruptedException  e){
        }
    }

    public void stopThread() {

    }
    public HpSkill(int skillPoint) {
        super(skillPoint);
    }

    @Override
    public int getSkillPoint() {
        return super.getSkillPoint();
    }

    @Override
    public void setSkillPoint(int skillPoint) {
        super.setSkillPoint(skillPoint);
    }

    @Override
    Skills skillsUp(Skills skills) {
        return super.skillsUp(skills);
    }

    @Override
    void fireUp(Skills skills) {
        super.fireUp(skills);
    }

    @Override
    void waterUp(Skills skills) {
        super.waterUp(skills);
    }

    @Override
    void forestUp(Skills skills) {
        super.forestUp(skills);
    }

    @Override
    void hpSkillUp(Skills skills) {
        super.hpSkillUp(skills);
    }

    @Override
    void armorSkill(Skills skills) {
        super.armorSkill(skills);
    }


    @Override
    void hpRecovery(User user, Skills skills) {
        super.hpRecovery(user, skills);
    }

    @Override
    public int getWater() {
        return super.getWater();
    }

    @Override
    public void setWater(int water) {
        super.setWater(water);
    }

    @Override
    public int getFire() {
        return super.getFire();
    }

    @Override
    public void setFire(int fire) {
        super.setFire(fire);
    }

    @Override
    public int getForest() {
        return super.getForest();
    }

    @Override
    public void setForest(int forest) {
        super.setForest(forest);
    }

    @Override
    public int getHpSkill() {
        return super.getHpSkill();
    }

    @Override
    public void setHpSkill(int hpSkill) {
        super.setHpSkill(hpSkill);
    }

    @Override
    public int getArmorSkill() {
        return super.getArmorSkill();
    }

    @Override
    public void setArmorSkill(int armorSkill) {
        super.setArmorSkill(armorSkill);
    }

    @Override
    public int getSkillPower() {
        return super.getSkillPower();
    }

    @Override
    public void setSkillPower(int skillPower) {
        super.setSkillPower(skillPower);
    }


}
