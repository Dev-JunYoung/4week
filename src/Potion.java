public class Potion extends Item{
    int recoveryAmount; //회복량
    int type; //회복종류 1.hp , 2.mp
    public Potion(String name,int price,int recoveryAmount, int type) {
        setName(name);
        setPrice(price);
        setRecoveryAmount(recoveryAmount);
        setType(type);
    }
    @Override
    public void sell(Inventory inventory) {
        inventory.setCash(inventory.getCash()+this.getPrice());
        System.out.println(ConsoleColors.FONT_YELLOW+this.getName()+"   판매완료!!! 얻은 금화   :    "+this.getPrice()+ConsoleColors.RESET);
    }
    @Override
    public void 상호작용(User user, Inventory inventory, Store store) {
       if(this.getType()==1){ //hp
           if(getRecoveryAmount()==50){
               inventory.setHpPotion(this,user,store,inventory);
           }else if(getRecoveryAmount()==100){
               inventory.setHpPotion100(this,user,store,inventory);
           }else {
               inventory.setHpPotion200(this,user,store,inventory);
           }
       }else if(this.getType()==2){ //mp
           if(getRecoveryAmount()==50){
               inventory.setMpPotion(this,user,store,inventory);
           }else if(getRecoveryAmount()==100){
               inventory.setMpPotion100(this,user,store,inventory);
           }else {
               inventory.setMpPotion200(this,user,store,inventory);
           }
       }
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
