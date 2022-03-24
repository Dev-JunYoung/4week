public class unit {
    protected String name; //사용자,com이름
    protected int level; //레벨 max10
    protected int hp; //
    protected int realHp; //
    protected int mp; //
    protected int realMp; //
    protected int Attack;
    protected int Defense;
    int Experience=0;


    /*public unit(String name, int level, int hp, int realHp, int mp, int realMp, int attack, int defense, int experience, int revelUpExperience) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.realHp = realHp;
        this.mp = mp;
        this.realMp = realMp;
        Attack = attack;
        Defense = defense;
        Experience = experience;
        this.revelUpExperience = revelUpExperience;
    }
*/  //몬스터,유저는 공격, 스킬을 사용 할수있다.
    void Attack(){
    }
    void Skill(){

    }

    public int getRealHp() {
        return realHp;
    }

    public void setRealHp(int realHp) {
        this.realHp = realHp;
    }


    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPhysicalAttack() {
        return Attack;
    }

    public void setPhysicalAttack(int Attack) {
        this.Attack = Attack;
    }

    public int getPhysicalDefense() {
        return Defense;
    }

    public void setPhysicalDefense(int Defense) {
        this.Defense = Defense;
    }

    public int getAttack() {
        return Attack;
    }

    public User setAttack(int attack) {
        Attack = attack;
        return null;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int defense) {
        Defense = defense;
    }

    public int getRealMp() {
        return realMp;
    }

    public void setRealMp(int realMp) {
        this.realMp = realMp;
    }
}
