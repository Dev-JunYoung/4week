public class boss extends Monster{

    public boss(String name, int ravel, int hp, int realHp, int mp, int realMp, int Attack, int Defense, int property, int skillAttack, String dropItem, int dropCash, int monEX) {
        super(name, ravel, hp, realHp, mp, realMp, Attack, Defense, property, skillAttack, dropItem, dropCash, monEX);
    }

    @Override
    void mosterAttack() {
        super.mosterAttack();
    }
    //필살기(몬스터클래스 메서드 오버라이딩)
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
    public int getDropCash() {
        return super.getDropCash();
    }

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
    public int getProperty() {
        return super.getProperty();
    }

    @Override
    public void setProperty(int property) {
        super.setProperty(property);
    }
}
