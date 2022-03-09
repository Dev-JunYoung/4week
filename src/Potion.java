public class Potion extends Item{
    int recoveryAmount; //회복량
    int type; //회복종류 1.hp , 2.mp

    public Potion(String name,int price,int recoveryAmount, int type) {
        setName(name);
        setPrice(price);
        setRecoveryAmount(recoveryAmount);
        setType(type);
    }

    public int getRecoveryAmount() {
        return recoveryAmount;
    }

    public void setRecoveryAmount(int recoveryAmount) {
        this.recoveryAmount = recoveryAmount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
