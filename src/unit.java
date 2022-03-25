public class unit {
    // unit - [user / monster] - boss
    protected String name;
    protected int level;
    protected int hp; //
    protected int realHp;
    protected int mp;
    protected int realMp;
    protected int Attack;
    protected int Defense;
    int Experience=0;

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
