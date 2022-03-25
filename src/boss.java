public class boss extends Monster implements Runnable{
    User user;
    public boss(String name,
                int ravel,
                int hp,
                int realHp,
                int mp,
                int realMp,
                int Attack,
                int Defense,
                int property,
                int skillAttack,
                String dropItem,
                int dropCash,
                int monEX,
                int monNum,
                User user) {
        super(name, ravel, hp, realHp, mp, realMp, Attack, Defense, property, skillAttack, dropItem, dropCash, monEX, monNum, user);
        setName(name);
        setLevel(level);
        setHp(hp);
        setRealHp(realHp);
        setMp(mp);
        setRealMp(realMp);
        setAttack(Attack);
        setDefense(Defense);
        setProperty(property);
        setSkillAttack(skillAttack);
        setDropItem(dropItem);
        setDropCash(dropCash);
        setMonEX(monEX);
        setMonNum(monNum);
        this.user=user;
    }

    @Override
    public void run() {
        try {
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

            if (user.getRealHp() < 0 || this.getRealHp() < 0) {
                flag = false;
            }
                while(flag){
                    setProperty((int) (Math.random() * 3 + 1));
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("뮤츠의 속성이 변화했습니다 ");
                    System.out.print("뮤츠속성 : "); System.out.println(this.propertyView()+ "  ");
                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                    for (int i = 0; i < 5; i++) { //3회 공격시 속성 변경
                    Thread.sleep(3000);
                    int random=((int)(Math.random()*2+1)); //평타공격,일반공격
                    switch (random){
                        case 1: //평타
                            System.out.println(ConsoleColors.FONT_RED+"                                        드레인펀치!!"+ConsoleColors.RESET);
                            if(user.getDefense()-this.getAttack()<0){ //양수가 되면 안됌
                                System.out.println(this.user.getName()+"님의  현재HP  / 총HP  : " + this.user.getRealHp() + " / " + this.user.getHp());
                                user.setRealHp(user.getRealHp()+(user.getDefense()-this.getAttack()));
                                System.out.println(ConsoleColors.FONT_RED+user.getName()+"님의 데미지 : "+(user.getDefense()-this.getAttack())+ConsoleColors.RESET);
                                System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                            }
                            break;
                        case 2: //스킬 -> 속성별 스킬
                            switch (this.getProperty()){
                                case 1: //불sout
                                    System.out.println(ConsoleColors.FONT_RED+"                                                    회오리 불꽃!!"+ConsoleColors.RESET);
                                    break;
                                case 2: //물
                                    System.out.println(ConsoleColors.FONT_RED+"                                                    하이드로빔!!"+ConsoleColors.RESET);
                                    break;
                                case 3: //풀
                                    System.out.println(ConsoleColors.FONT_RED+"                                                    솔라빔!!"+ConsoleColors.RESET);
                                    break;
                            }
                            if(user.getDefense()-this.getAttack()*5/3<0){ //양수가 되면 안됌
                                System.out.println("");
                                System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                                user.setRealHp(user.getRealHp()+(user.getDefense()-this.getAttack())*5/3);
                                System.out.println(ConsoleColors.FONT_RED+user.getName()+"님의 데미지 : "+(user.getDefense()-this.getAttack())*5/3+ConsoleColors.RESET);
                                System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                            }else {
                                System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                    } //switch
                if(user.getRealHp()<=0){
                    Thread.interrupted(); //false 로 초기화
                    flag=false;
                    System.out.println(ConsoleColors.FONT_RED+"사망하셨습니다.   ( 아무숫자를 누르세요  )"+ConsoleColors.RESET);
                    return;
                } //if
                i++; // 뮤츠의 공격3회 끝나면 속성변경
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                } //while
            } } //for //try
        catch (Exception e){
        }



    }

    String propertyView(){
        String 속성 = null;
        if(this.getProperty()==1){
            속성=ConsoleColors.FONT_RED+" 불"+ConsoleColors.RESET;
        }else if(this.getProperty()==2){
            속성=ConsoleColors.FONT_BLUE+"물"+ConsoleColors.RESET;
        }else {
            속성=ConsoleColors.FONT_GREEN+"풀"+ConsoleColors.RESET;
        }
        return 속성;
    }
    //getter,setter
    @Override
    public int getMonNum() {
        return super.getMonNum();
    }
    @Override
    public void setMonNum(int monNum) {
        super.setMonNum(monNum);
    }
    @Override
    void mosterAttack() {
        super.mosterAttack();
    }
    void mosterAttack(boss boss) {
        super.mosterAttack();
    }
    @Override
    public String getDropItem() {
        return super.getDropItem();
    }
    @Override
    public void setDropItem(String dropItem) {
        super.setDropItem(dropItem);
    }
    @Override
    public int getDropCash() {return super.getDropCash();}
    @Override
    public void setDropCash(int dropCash) {
        super.setDropCash(dropCash);
    }
    @Override
    public int getMonEX() {
        return super.getMonEX();
    }
    @Override
    public void setMonEX(int monEX) {
        super.setMonEX(monEX);
    }
    @Override
    public int getSkillAttack() {
        return super.getSkillAttack();
    }
    @Override
    public void setSkillAttack(int skillAttack) {
        super.setSkillAttack(skillAttack);
    }
    @Override
    void Attack() {
        super.Attack();
    }
    @Override
    void Skill() {
        super.Skill();
    }
    @Override
    public int getRealHp() {
        return super.getRealHp();
    }
    @Override
    public void setRealHp(int realHp) {
        super.setRealHp(realHp);
    }
    @Override
    public int getExperience() {
        return super.getExperience();
    }
    @Override
    public void setExperience(int experience) {
        super.setExperience(experience);
    }
    @Override
    public int getMp() {
        return super.getMp();
    }
    @Override
    public void setMp(int mp) {
        super.setMp(mp);
    }
    @Override
    public String getName() {
        return super.getName();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public int getLevel() {
        return super.getLevel();
    }
    @Override
    public void setLevel(int level) {
        super.setLevel(level);
    }
    @Override
    public int getHp() {
        return super.getHp();
    }
    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }
    @Override
    public int getAttack() {
        return super.getAttack();
    }
    @Override
    public User setAttack(int attack) {
        return super.setAttack(attack);
    }
    @Override
    public int getDefense() {
        return super.getDefense();
    }
    @Override
    public void setDefense(int defense) {
        super.setDefense(defense);
    }
    @Override
    public int getRealMp() {
        return super.getRealMp();
    }
    @Override
    public void setRealMp(int realMp) {
        super.setRealMp(realMp);
    }
    @Override
    public int getProperty() {return super.getProperty(); }
    @Override
    public void setProperty(int property) {
        super.setProperty(property);
    }
}

