public class Armor extends Equipments{
    int armorPower; //상승방어력

    public Armor(String name,int price, int upgrade ,int armorPower) {
        setName(name);
        setPrice(price);
        setUpgrade(upgrade);
        setArmorPower(armorPower);
    }

    @Override
    void statUp() {
        super.statUp();
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

    public int getArmorPower() {
        return armorPower;
    }

    public void setArmorPower(int armorPower) {
        this.armorPower = armorPower;
    }
}
