public class Monster extends unit {
    /*protected String name; //사용자,com이름
    protected int level; //레벨 max10
    protected int hp; //
    protected int realHp; //
    protected int mp; //
    protected int realMp; //
    protected int Attack;
    protected int Defense;
    int Experience=0;
    int revelUpExperience=100;*/
    //속성이다름 
    int property;
    //스킬이다름
    int skillAttack;
    String dropItem;
    int dropCash;
    int monEX;
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
                   int monEX) {
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
    }

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
}
