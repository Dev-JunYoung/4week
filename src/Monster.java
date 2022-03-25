import org.w3c.dom.ls.LSOutput;

public class Monster extends unit implements Runnable {
    int property;
    int skillAttack;
    String dropItem;
    int dropCash;
    int monEX;
    User user;
    // 1파이리 2꼬북이 3이상해씨
    // 4리자드 5어니부기6이상해풀
    // 7리자몽 8거북왕 9 이상해꽃
    int monNum=0;
    int 모드=0;
    int second = TimerRunnable.second;
    boolean flag=true;
    @Override
    public void run() {
        // 0 == vs 일반사냥터
        // 2 == vs 투기장
        if(user.get유저모드()==0){
            밤();
            try {
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("내 상태                                         포켓몬");
            if(user.getRealHp()<0||this.getRealHp()<0){
                flag=false;
            }
            while(flag){
                Thread.sleep(3000);
                int random=((int)(Math.random()*2+1));
                switch (random){
                    case 1: // 평타
                        switch (this.monNum){
                            case 1: System.out.println(ConsoleColors.FONT_RED+"                                        파이리 펀치!!"+ConsoleColors.RESET);
                                break;
                            case 2: System.out.println(ConsoleColors.FONT_RED+"                                        몸통박치기!!"+ConsoleColors.RESET);
                                break;
                            case 3: System.out.println(ConsoleColors.FONT_RED+"                                        덩굴 채찍!!"+ConsoleColors.RESET);
                                break;
                            case 4: System.out.println(ConsoleColors.FONT_RED+"                                        손톱할퀴기!!"+ConsoleColors.RESET);
                                break;
                            case 5: System.out.println(ConsoleColors.FONT_RED+"                                        등딱지 박치기!!"+ConsoleColors.RESET);
                                break;
                            case 6: System.out.println(ConsoleColors.FONT_RED+"                                        땅울리기!!"+ConsoleColors.RESET);
                                break;
                            case 7: System.out.println(ConsoleColors.FONT_RED+"                                        마구 할퀴기!!"+ConsoleColors.RESET);
                                break;
                            case 8: System.out.println(ConsoleColors.FONT_RED+"                                        거북왕펀치!!"+ConsoleColors.RESET);
                                break;
                            case 9: System.out.println(ConsoleColors.FONT_RED+"                                        칼등치기!!"+ConsoleColors.RESET);
                                break;
                        }
                        if(user.getDefense()-this.getAttack()<0){ //양수가 되면 안됌
                            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                            user.setRealHp(user.getRealHp()+(user.getDefense()-this.getAttack()));
                            System.out.println(ConsoleColors.FONT_RED+user.getName()+"님의 데미지 : "+(user.getDefense()-this.getAttack())+ConsoleColors.RESET);
                            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                        }
                        break;
                    case 2: //스킬
                        switch (this.monNum){ //
                            //출력이 스트링으로 나오는데
                            case 1:     System.out.println(ConsoleColors.FONT_RED+"                                                    불꽃발사!!"+ConsoleColors.RESET);
                                break;
                            case 2:     System.out.println(ConsoleColors.FONT_RED+"                                                    물뿌리기!!"+ConsoleColors.RESET);
                                break;
                            case 3:     System.out.println(ConsoleColors.FONT_RED+"                                                    씨폭탄!!"+ConsoleColors.RESET);
                                break;
                            case 4:System.out.println(ConsoleColors.FONT_RED+"                                                    불꽃세례!!"+ConsoleColors.RESET);
                                break;
                            case 5:System.out.println(ConsoleColors.FONT_RED+"                                                    물대포!!"+ConsoleColors.RESET);
                                break;
                            case 6:System.out.println(ConsoleColors.FONT_RED+"                                                    풀입날리기!!"+ConsoleColors.RESET);
                                break;
                            case 7:System.out.println(ConsoleColors.FONT_RED+"                                                    회오리 불꽃!!"+ConsoleColors.RESET);
                                break;
                            case 8:System.out.println(ConsoleColors.FONT_RED+"                                                    하이드로빔!!"+ConsoleColors.RESET);
                                break;
                            case 9:System.out.println(ConsoleColors.FONT_RED+"                                                    솔라빔!!"+ConsoleColors.RESET);
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
                    user.set유저모드(0);
                    flag=false;
                    System.out.println(ConsoleColors.FONT_RED+"사망하셨습니다.   ( 아무숫자를 누르세요  )"+ConsoleColors.RESET);
                    return;
                }
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
            }
        }catch (Exception e){}
        }else if(user.get유저모드()==1){ //유저모드
            if(second%10==1){
                System.out.println("second값"+second);
            }
            int delayAttack=0;
            try {

                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("내 상태                                         포켓몬");
                if(user.getRealHp()<0||this.getRealHp()<0){
                    flag=false;
                }
                while(flag){
                    delayAttack=((int)(Math.random()*10+1));
                    System.out.println(delayAttack);
                    Thread.sleep(1000*delayAttack);
                    int random=((int)(Math.random()*2+1));
                    switch (random){
                        case 1: // 평타
                            switch (this.monNum){
                                case 1: System.out.println(ConsoleColors.FONT_RED+"                                        파이리 펀치!!"+ConsoleColors.RESET);
                                    break;
                                case 2: System.out.println(ConsoleColors.FONT_RED+"                                        몸통박치기!!"+ConsoleColors.RESET);
                                    break;
                                case 3: System.out.println(ConsoleColors.FONT_RED+"                                        덩굴 채찍!!"+ConsoleColors.RESET);
                                    break;
                                case 4: System.out.println(ConsoleColors.FONT_RED+"                                        손톱할퀴기!!"+ConsoleColors.RESET);
                                    break;
                                case 5: System.out.println(ConsoleColors.FONT_RED+"                                        등딱지 박치기!!"+ConsoleColors.RESET);
                                    break;
                                case 6: System.out.println(ConsoleColors.FONT_RED+"                                        땅울리기!!"+ConsoleColors.RESET);
                                    break;
                                case 7: System.out.println(ConsoleColors.FONT_RED+"                                        마구 할퀴기!!"+ConsoleColors.RESET);
                                    break;
                                case 8: System.out.println(ConsoleColors.FONT_RED+"                                        거북왕펀치!!"+ConsoleColors.RESET);
                                    break;
                                case 9: System.out.println(ConsoleColors.FONT_RED+"                                        칼등치기!!"+ConsoleColors.RESET);
                                    break;
                            }
                            if(user.getDefense()-this.getAttack()<0){ //양수가 되면 안됌
                                System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                                user.setRealHp(user.getRealHp()+(user.getDefense()-this.getAttack()));
                                System.out.println(ConsoleColors.FONT_RED+user.getName()+"님의 데미지 : "+(user.getDefense()-this.getAttack())+ConsoleColors.RESET);
                                System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                            }
                            break;
                        case 2: //스킬
                            switch (this.monNum){ //
                                //출력이 스트링으로 나오는데
                                case 1:     System.out.println(ConsoleColors.FONT_RED+"                                                    불꽃발사!!"+ConsoleColors.RESET);
                                    break;
                                case 2:     System.out.println(ConsoleColors.FONT_RED+"                                                    물뿌리기!!"+ConsoleColors.RESET);
                                    break;
                                case 3:     System.out.println(ConsoleColors.FONT_RED+"                                                    씨폭탄!!"+ConsoleColors.RESET);
                                    break;
                                case 4:System.out.println(ConsoleColors.FONT_RED+"                                                    불꽃세례!!"+ConsoleColors.RESET);
                                    break;
                                case 5:System.out.println(ConsoleColors.FONT_RED+"                                                    물대포!!"+ConsoleColors.RESET);
                                    break;
                                case 6:System.out.println(ConsoleColors.FONT_RED+"                                                    풀입날리기!!"+ConsoleColors.RESET);
                                    break;
                                case 7:System.out.println(ConsoleColors.FONT_RED+"                                                    회오리 불꽃!!"+ConsoleColors.RESET);
                                    break;
                                case 8:System.out.println(ConsoleColors.FONT_RED+"                                                    하이드로빔!!"+ConsoleColors.RESET);
                                    break;
                                case 9:System.out.println(ConsoleColors.FONT_RED+"                                                    솔라빔!!"+ConsoleColors.RESET);
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
                        user.set유저모드(0);
                        System.out.println(ConsoleColors.FONT_RED+"사망하셨습니다.   ( 아무숫자를 누르세요  )"+ConsoleColors.RESET);
                        return;
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("");
                }
            }catch (Exception e){
            }
        }
            else if(user.get유저모드()==2){
            int random = 0;
            random=random();
            while(flag){
                if(this.get모드()==1){ // myMonster
                    남은체력(this);
                    this.setAttack(randomAttack());
                    random=random();
                    try {
                        Thread.sleep(random*500);
                        this.Attack();
                        flag=check(this);
                        }
                    catch (InterruptedException e) {
                        return;
                    }
                    if(this.getRealHp()<0){
                        Thread.interrupted();
                        return;
                    }
                    if(this.monster.getRealHp()<0){
                        남은체력(this);
                        Thread.interrupted();
                        return;
                    }
                    random=random();
                }else if(this.get모드()==2) {//vsMonster
                    this.setAttack(randomAttack());
                    random=random();
                    try {
                            Thread.sleep(random*500);
                            this.Attack();
                            flag=check(this);
                    } catch (InterruptedException e) {
                        return;
                    }
                    if(this.getRealHp()<0){
                        Thread.interrupted();
                        return;
                    }
                    if(this.monster.getRealHp()<0){
                        남은체력(this);
                        Thread.interrupted();
                        return;
                    }
                }else{
                }
                random=random();
            }
        }
        }
    //-------------------------------------------------------------
    void 밤(){
        //밤스레드
        if(TimerRunnable.afternoon==false){
            this.setAttack(getAttack()*2);
            this.setDropCash(this.getDropCash()*2);
            this.setMonEX(this.getMonEX()*2);
            System.out.println(ConsoleColors.FONT_YELLOW+"밤입니다. 포켓몬의 데미지가 강력해집니다."+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_YELLOW+"대신 획득 경험치와 보상금화가 2배입니다."+ConsoleColors.RESET);
        }
    }
    @Override
    void Attack() {
        this.monster.setRealHp(this.monster.getRealHp()-this.getAttack());
        super.Attack();
    }
    void 남은체력(Monster monster){
        if(monster.get모드()==1){
            System.out.println("=================================================================================================================================================");
            System.out.println(this.getName()+"의 현재 체력 "+this.getRealHp()+" ");
            if(this.getRealHp()==100){
                System.out.println("■■■■■■■■■■■■■■■■■■■■");
            }else if (this.getRealHp()>90){
                System.out.println("■■■■■■■■■■■■■■■■■■");
            }else if (this.getRealHp()>80){
                System.out.println("■■■■■■■■■■■■■■■■");
            }else if (this.getRealHp()>70){
                System.out.println("■■■■■■■■■■■■■■");
            }else if (this.getRealHp()>60){
                System.out.println("■■■■■■■■■■■■");
            }else if (this.getRealHp()>50){
                System.out.println("■■■■■■■■■■");
            }else if (this.getRealHp()>40){
                System.out.println("■■■■■■■■");
            }else if (this.getRealHp()>30){
                System.out.println("■■■■■■");
            }else if (this.getRealHp()>20){
                System.out.println("■■■■");
            }else if (this.getRealHp()>10){
                System.out.println("■■");
            }else if(this.getRealHp()>0){
                System.out.println("■");
            }else if(this.getRealHp()<=0){
                System.out.println(" ");
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(ConsoleColors.FONT_RED+this.monster.getName()+"의 현재 체력 "+this.monster.getRealHp()+" "+ConsoleColors.RESET);
            if(this.monster.getRealHp()==100){
                System.out.println("■■■■■■■■■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>90){
                System.out.println("■■■■■■■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>80){
                System.out.println("■■■■■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>70){
                System.out.println("■■■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>60){
                System.out.println("■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>50){
                System.out.println("■■■■■■■■■■");
            }else if (this.monster.getRealHp()>40){
                System.out.println("■■■■■■■■");
            }else if (this.monster.getRealHp()>30){
                System.out.println("■■■■■■");
            }else if (this.monster.getRealHp()>20){
                System.out.println("■■■■");
            }else if (this.monster.getRealHp()>10){
                System.out.println("■■");
            }else if(this.monster.getRealHp()>0){
                System.out.println("■");
            }else if(this.monster.getRealHp()<=0){
                System.out.println(" ");
            }
            System.out.println(ConsoleColors.FONT_RED+"================================================================================================================================================="+ConsoleColors.RESET);
            System.out.println("");
            if(this.realHp<0||this.monster.realHp<=0){
                System.out.println(ConsoleColors.FONT_YELLOW+"경기가 끝났습니다 "+ConsoleColors.RESET);
            }else {
                if(this.realHp>this.monster.realHp){
                    System.out.println(ConsoleColors.FONT_YELLOW+"우세합니다!!!"+ConsoleColors.RESET);
                }else if(this.realHp==this.monster.realHp){
                    System.out.println(ConsoleColors.FONT_YELLOW+" 동등합니다 "+ConsoleColors.RESET);
                }else {
                    System.out.println(ConsoleColors.FONT_YELLOW+"지고 있습니다 ..."+ConsoleColors.RESET);
                }
            }
        }else {
            System.out.println("=================================================================================================================================================");
            System.out.println(this.monster.getName()+"의 현재 체력 "+this.monster.getRealHp()+" ");
            if(this.monster.getRealHp()==100){
                System.out.println("■■■■■■■■■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>90){
                System.out.println("■■■■■■■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>80){
                System.out.println("■■■■■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>70){
                System.out.println("■■■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>60){
                System.out.println("■■■■■■■■■■■■");
            }else if (this.monster.getRealHp()>50){
                System.out.println("■■■■■■■■■■");
            }else if (this.monster.getRealHp()>40){
                System.out.println("■■■■■■■■");
            }else if (this.monster.getRealHp()>30){
                System.out.println("■■■■■■");
            }else if (this.monster.getRealHp()>20){
                System.out.println("■■■■");
            }else if (this.monster.getRealHp()>10){
                System.out.println("■■");
            }else if(this.monster.getRealHp()>0){
                System.out.println("■");
            }else if(this.monster.getRealHp()<=0){
                System.out.println(" ");
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(ConsoleColors.FONT_RED+this.getName()+"의 현재 체력 "+this.getRealHp()+" "+ConsoleColors.RESET);
            if(this.getRealHp()==100){
                System.out.println("■■■■■■■■■■■■■■■■■■■■");
            }else if (this.getRealHp()>90){
                System.out.println("■■■■■■■■■■■■■■■■■■");
            }else if (this.getRealHp()>80){
                System.out.println("■■■■■■■■■■■■■■■■");
            }else if (this.getRealHp()>70){
                System.out.println("■■■■■■■■■■■■■■");
            }else if (this.getRealHp()>60){
                System.out.println("■■■■■■■■■■■■");
            }else if (this.getRealHp()>50){
                System.out.println("■■■■■■■■■■");
            }else if (this.getRealHp()>40){
                System.out.println("■■■■■■■■");
            }else if (this.getRealHp()>30){
                System.out.println("■■■■■■");
            }else if (this.getRealHp()>20){
                System.out.println("■■■■");
            }else if (this.getRealHp()>10){
                System.out.println("■■");
            }else if(this.getRealHp()>0){
                System.out.println("■");
            }else if(this.getRealHp()<=0){
                System.out.println(" ");
            }
            System.out.println(ConsoleColors.FONT_RED+"================================================================================================================================================="+ConsoleColors.RESET);
            System.out.println("");
            if(this.realHp<0||this.monster.realHp<=0){
                System.out.println(ConsoleColors.FONT_YELLOW+"경기가 끝났습니다 "+ConsoleColors.RESET);
            }
        }
    }
    int random(){
        int random = ((int) (Math.random() * 4 + 1));
        return random;
    }
    //-------------------------------------------------------------
    public String getDropItem() {
        return dropItem;
    }
    public void setDropItem(String dropItem) {
        this.dropItem = dropItem;
    }
    public int getDropCash() {
        return dropCash;
    }
    public void setDropCash(int dropCash) {
        this.dropCash = dropCash;
    }
    public int getMonEX() {
        return monEX;
    }
    public void setMonEX(int monEX) {
        this.monEX = monEX;
    }
    public int getSkillAttack() {
        return skillAttack;
    }
    public void setSkillAttack(int skillAttack) {
        this.skillAttack = skillAttack;
    }
    boolean check(Monster monster){
        if(this.realHp<=0){
            return false;
        }
        return true;
}
    int randomAttack(){
    int randomAttack=((int)(Math.random()*10+1));
return randomAttack;
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
    public int getMonNum() {
        return monNum;
    }
    public void setMonNum(int monNum) {
        this.monNum = monNum;
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
        super.setAttack(attack);
        return null;
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
    public int getProperty() {
        return property;
    }
    public void setProperty(int property) {
        this.property = property;
    }
    public int get모드() {
        return 모드;
    }
    public void set모드(int 모드) {
        this.모드 = 모드;
    }
    public Monster getMonster() {
        return monster;
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    Monster monster;
    public Monster(){
    }
    //일반전투 몬스터 생성자
    public Monster(String name,
                   int ravel,
                   int hp,
                   int realHp,
                   int mp,
                   int realMp,
                   int Attack,
                   int Defense,
                   int property, //속성
                   int skillAttack,
                   String dropItem,
                   int dropCash,
                   int monEX,
                   int monNum,
                   User user) {
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
    //투기장 몬스터 생성자
    public Monster(String name,
                   int hp,
                   int realHp,
                   int mp,
                   int realMp,
                   int Attack,
                   int Defense,
                   int property,
                   int 모드,
                   User user){
        setName(name);
        setHp(hp);
        setRealHp(realHp);
        setMp(mp);
        setRealMp(realMp);
        setAttack(Attack);
        setDefense(Defense);
        setProperty(property);
        this.user=user;
        set모드(모드);
    } public Monster(String name,
                     int hp,
                     int realHp,
                     int mp,
                     int realMp,
                     int Attack,
                     int Defense,
                     int property,
                     int 모드,
                     User user,
                     Monster monster){
        setName(name);
        setHp(hp);
        setRealHp(realHp);
        setMp(mp);
        setRealMp(realMp);
        setAttack(Attack);
        setDefense(Defense);
        setProperty(property);
        set모드(모드);
        this.user=user;
        this.monster=monster;
    }
    void mosterAttack(){
    }
}
