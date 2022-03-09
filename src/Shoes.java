public class Shoes extends Equipments{
    int avoidUp;

    public Shoes(String name,int price,int upgrade,int avoidUp) {
        setName(name);
        setPrice(price);
        setUpgrade(upgrade);
        setAvoidUp(avoidUp);
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
    void statUp() {
        super.statUp();
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

    public int getAvoidUp() {
        return avoidUp;
    }

    public void setAvoidUp(int avoidUp) {
        this.avoidUp = avoidUp;
    }
}
