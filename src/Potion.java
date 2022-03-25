public class Potion extends Item{

    int recoveryAmount; //회복량
    int type; //회복종류 1.hp , 2.mp

    public Potion(String name,int price,int recoveryAmount, int type) {
        setName(name);
        setPrice(price);
        setRecoveryAmount(recoveryAmount);
        setType(type);
    }

    //오버라이딩 메서드
    @Override
    public void sell(User user) {
        user.getInventory().setCash(user.getInventory().getCash()+this.getPrice());
        System.out.println(ConsoleColors.FONT_YELLOW+this.getName()+"   판매완료!!! 얻은 금화   :    "+this.getPrice()+ConsoleColors.RESET);
    }
    @Override
    public void 상호작용(User user, Store store) {
       if(this.getType()==1){ //hp
           if(getRecoveryAmount()==50){
               user.getInventory().setHpPotion(this,user,store);
           }else if(getRecoveryAmount()==100){
               user.getInventory().setHpPotion100(this,user,store);
           }else {
               user.getInventory().setHpPotion200(this,user,store);
           }
       }else if(this.getType()==2){ //mp
           if(getRecoveryAmount()==50){
               user.getInventory().setMpPotion(this,user,store);
           }else if(getRecoveryAmount()==100){
               user.getInventory().setMpPotion100(this,user,store);
           }else {
               user.getInventory().setMpPotion200(this,user,store);
           }
       }
    }

    //getter,setter
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
