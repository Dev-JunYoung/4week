public class soad extends Equipments{

    //상승공격력
    int AttackPower;

    public soad(String name,int price,int upgrade  ,int attackPower) {
        setName(name);
        setPrice(price);
        setUpgrade(upgrade);
        setAttackPower(attackPower);
    }

    @Override
    void statUp() {
        super.statUp();
    }

    public int getAttackPower() {
        return AttackPower;
    }

    public void setAttackPower(int attackPower) {
        AttackPower = attackPower;
    }


    @Override
    public int getUpgrade() {
        return super.getUpgrade();
    }

    @Override
    public void setUpgrade(int upgrade) {
        super.setUpgrade(upgrade);
    }


    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
