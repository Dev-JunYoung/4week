public class HpSkill extends Skills implements Runnable{
    //체력회복클래스 - 스레드
    User user;
    public HpSkill(User user){
        user.setSkills(user.getSkills());
        this.user=user;
    }
    int i=0;
    @Override
    public void run() {
        try {
            if(user.getRealHp()<0){
                i=user.getSkills().getHpSkill();
                Thread.interrupted();
                return;
            }
            System.out.println(ConsoleColors.FONT_BLUE+"현재 MP : "+user.getRealMp()+" / 총 MP : "+user.getMp()+ConsoleColors.RESET);
            for(int i=0;i< user.getSkills().getHpSkill();i++){ //스킬 포인트만큼 횟수
                if(user.getRealHp()<0){
                    i=user.getSkills().getHpSkill();
                    Thread.interrupted();
                    break;
                }
                hpRecovery(user);
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                System.out.println(ConsoleColors.BACKGROUND_BLUE+"                                                    "+(i+1)+"번쨰 hill"+ConsoleColors.RESET);
                System.out.println(ConsoleColors.FONT_BLUE+"                                                   "+user.getRealHp()+" / "+user.getHp()+ConsoleColors.RESET);
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                if(user.getRealHp()<0){
                    i=user.getSkills().getHpSkill();
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
                i=user.getSkills().getHpSkill();
                Thread.interrupted();
                return;
            }
        }catch (InterruptedException  e){
        }
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
    Skills skillsUp(User user) {
        return super.skillsUp(user);
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
    void hpRecovery(User user) {
        super.hpRecovery(user);
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
