import java.util.ArrayList;
import java.util.Scanner;

public class User extends unit {
    /*   String name; 상속
      int level;
      int hp;
      int Attack;
      int Defense;
      int avoid;
      int Experience;
      */
    int revelUpExperience = 100;
    int skill = 0;
    int avoid;
    int statPoint = 0;

    public int getRevelUpExperience() {
        return revelUpExperience;
    }

    public void setRevelUpExperience(int revelUpExperience) {
        this.revelUpExperience = revelUpExperience;
    }

    @Override
    void Attack() {
        super.Attack();
    }

    @Override
    void Skill() {
        super.Skill();
    }

    Scanner sc = new Scanner(System.in);

    //게임시작 유저 초기화값
    User userInitSet(User user) {
        super.setLevel(1);
        super.setHp(1000);
        super.setRealHp(1000);
        this.setRevelUpExperience(100);
        super.setMp(100);
        super.setRealMp(100);
        super.setAttack(((int) (Math.random() * 20 + 10)));
        super.setDefense(((int) (Math.random() * 20 + 10)));
        this.setAvoid(((int) (Math.random() * 20 + 10)));
        return user;
    }
    //유저 상태 메서드 (main.2)
    void userStatus(User user,Inventory inventory,Skills skills){
        int 뎁스1num;
        int 뎁스2num;
        while(true){
            user.userStatList(user);
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("1.능력치 올리기 ㅣ   2.스킬   ㅣ   3.착용장비확인     ㅣ   4.돌아가기"    );
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            뎁스1num= sc.nextInt();
            switch (뎁스1num){           //     1.wearingEquipments
                //              2.userSkills
                //              3.inventory
                case 1: //능력치올리기완성
                    if(user.statPoint>0){
                        user.userStatUp(user);
                        break;
                    }else{
                        System.out.println("스탯포인트가 부족합니다");
                        sc.nextLine();
                    }
                    break;
                case 2: //스킬 skillView()호출 -1. 스킬리스트
                    //                     2.  스킬 올리기 (스탯없으면 X)
                    while(true){
                        skills.skillView(skills);
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("1.스킬 올리기 ㅣ   2.돌아가기   ㅣ ");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        뎁스2num= sc.nextInt();
                        if(뎁스2num==1){
                            if(skills.getSkillPoint()>0){
                                skills.skillsUp(skills);
                            }else{
                                System.out.println("스킬포인트가 부족합니다.(enter)");
                                sc.nextLine();
                                break;
                            }
                        }else if(뎁스2num==2){
                            break;
                        }
                        break;
                    }break;
                case 3:
                    //착용장비확인 장비메서드호출
                    inventory.wearing(user,inventory);
                    sc.nextLine();
                    break;
                case 4: 뎁스1num=4; //돌아가기
            }
            if(뎁스1num==4){ //돌아가기
                break;
            }

        }
    }
    // 유저 스탯 리스트
    User userStatList(User user) {
        System.out.println();
        ArrayList member = new ArrayList();
        System.out.println(user.getName() + "님의 능력치 : ");
        member.add("유저닉네임  : " + user.name);
        member.add("레벨       : "+ user.level);
        member.add("체력       : " + user.getRealHp() + " / " + user.getHp());
        member.add("마나       : " + user.getRealMp() + " / " + user.getMp());
        member.add("공격력     : " + user.getAttack());
        member.add("방어력     : " + user.getDefense());
        member.add("명중률     : " + user.getAvoid());
        member.add("경험치     : " + user.getExperience() + " / " + user.getRevelUpExperience());
        member.add("스탯포인트  : " + user.getStatPoint());
        //member.add("스킬포인트  : "+skill.
        System.out.println("User Status");
        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < member.size(); i++) {
            System.out.println(member.get(i) + "    ");
        }
        System.out.println("---------------------------------------------------------------------");
        return user;
    }
    //장비착용시 능력치 업그레이드

    // 유저 레벨업시 스탯 UP 메서드
    User userLavelUp(User user) {
        setLevel(getLevel()+1);
        statPoint = statPoint + 6;
        setHp(getHp() + 50);
        setMp(getMp() + 20);
        setAttack(getAttack() + 1);
        setDefense(getDefense() + 1);
        setAvoid(getAttack() + 1);
        System.out.println(user.getName() + "님의 레벨이 " + getLevel() + "이 되었습니다.");
        //스킬포인트 추가해야됌
        user.setExperience(0); //레벨업--> 경험치 초기화
        //레벨없할때 +3
        return user;
    }
    // 레벨업 하면 기본적으로 능력치가 1증가, hp,ml도 증가
    User userStatUp(User user) {
        int num;
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1. HP+20  ㅣ   2.MP+10  ㅣ    3.공격력+1  ㅣ  4.방어력+1  ㅣ   5.민첩성+1  ㅣ   6.돌아가기");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        num = sc.nextInt();
        switch (num) {
            case 1:
                hpUp(user);
                break;
            case 2:
                mpUp(user);
                break;
            case 3:
                AttackUp(user);
                break;
            case 4:
                DefenseUp(user);
                break;
            case 5:
                avoidUp(user);
                break;
            case 6:
                break;
        }
        return user;
    }

    // 스텟업메서드 해당스탯+1 보유스탯-1
    void AttackUp(User user) {
        setAttack(getAttack() + 1);
        setExperience(getStatPoint() - 1);
    }

    void DefenseUp(User user) {
        setDefense(getDefense() + 1);
        setStatPoint(getStatPoint() - 1);
    }

    void avoidUp(User user) {
        setAvoid(getAttack() + 1);
        setStatPoint(getStatPoint() - 1);
        System.out.println("민첩성 +1");
    }

    void hpUp(User user) {
        setHp(getHp() + 20);
        setStatPoint(getStatPoint() - 1);
    }

    void mpUp(User user) {
        setMp(getMp() + 10);
        setStatPoint(getStatPoint() - 1);
    }//스탯업 메서드끝


    //user 생성자, 객세생성될때 무조건있어야 하는값들
    public User(String name) {
        super.name = name;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }


    public int getStatPoint() {
        return statPoint;
    }

    public void setStatPoint(int statPoint) {

        this.statPoint = statPoint;

    }


    public int getAvoid() {
        return avoid;
    }

    public void setAvoid(int avoid) {
        this.avoid = avoid;
    }


    @Override
    public int getExperience() {
        return super.getExperience();
    }

    @Override //경험치100넘으면 0초기화
    public void setExperience(int experience) {
        if (experience > 100) {
            experience = 0;
        }
        super.setExperience(experience);
    }
    //deal 메서드를 만들어야겠음
    //deal의 개념  몬스터체력=몬스터체력-(내공격력-몬스터방어력) 이거임
    // 근데 (내공격력-몬스터방어력)  이게 음수가 되면안됌
    //스킬딜이랑은 따로 분리

    User setExperience(int experience, User user,Skills skills) {
        if (experience >= 100) {
            experience = 0;
            setLevel(getLevel()+1);
            statPoint = statPoint + 6;
            skills.setSkillPoint(getStatPoint()+3);
            setHp(getHp() + 50);
            setRealHp(getHp());
            setMp(getMp() + 20);
            setAttack(getAttack() + 1);
            setDefense(getDefense() + 1);
            setAvoid(getAttack() + 1);
            System.out.println(user.getName() + "님의 레벨이 " + getLevel() + "이 되었습니다.");
            //스킬포인트 추가해야됌
            user.setExperience(0); //레벨업--> 경험치 초기화
            //레벨없할때 +3
            return user;
        }
        super.setExperience(experience);
        return user;
    }
    @Override
    public int getMp() {
        return super.getMp();
    }

    @Override
    public void setMp(int mp) {
        if (getStatPoint() > 0) {
            super.setMp(mp);
        } else {
            System.out.println("스탯포인트가 부족합니다.");
        }
    }

    public void setName(String name) {

    }

    @Override
    public String getName() {
        return super.getName();
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
        if (getStatPoint() > 0) {
            super.setHp(hp);
        } else {
            System.out.println("스탯포인트가 부족합니다.");
        }

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
    public int getRealHp() {
        return super.getRealHp();
    }

    @Override
    public void setRealHp(int realHp) { //real hp 셋팅중 1000 /1000 헌재체력이 넘으면 안됌()
        super.setRealHp(realHp);
    }
    //오버라이딩을 사용해서 현재 hp가 총 hp를 넘어가는것을 막아볼까..
    public void setRealHp(int realHp,User user) { //real hp 셋팅중 1000 /1000 헌재체력이 넘으면 안됌()
        super.setRealHp(realHp);
    }

    @Override
    public int getRealMp() {
        return super.getRealMp();
    }

    @Override
    public void setRealMp(int realMp) {
        super.setRealMp(realMp);
    }
}