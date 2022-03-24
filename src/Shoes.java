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
    public void 상호작용(User user, Inventory inventory, Store store) {
        switch (upgrade){
            case 1:
                System.out.print("초보자의 ");
                inventory.setShoes(this,user,store);
                break;
            case 2:
                System.out.print("숙련자의 ");
                inventory.setShoes2(this, user,store);
                break;
            case 3:
                System.out.print("마스터의 ");
                inventory.setShoes3(this,user,store);
                break;
            case 4:
                System.out.print("강화된 초보자의 ");
                inventory.setUpgradeShoes(this,user,store);
                break;
            case 5:
                System.out.print("강화된 숙련자의 ");
                inventory.setUpgradeShoes2(this,user,store);
                break;
            case 6:
                System.out.print("강화된 마스터의 ");
                inventory.setUpgradeShoes3(this,user,store);
                break;
        }
    }
    @Override
    public void sell(Inventory inventory) {
        inventory.setCash(inventory.getCash()+this.getPrice());
        System.out.println(ConsoleColors.FONT_YELLOW+this.getName()+"   판매완료!!! 얻은 금화   :    "+this.getPrice()+ConsoleColors.RESET);
    }
    @Override
    public void upgradeEquipment(User user, Inventory inventory, Store store) {
        switch (upgrade){
            case 1:
                if(inventory.getCash()>=100&&
                        inventory.inventoryList.contains("이상해씨의 씨앗")&&raise==0){
                    inventory.list.remove(this);
                    inventory.inventoryList.remove("이상해씨의 씨앗");
                    inventory.list.add(store.upgradeShoes);
                    inventory.setCash(inventory.getCash()-100);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
            case 2:
                if(inventory.getCash()>=300&&
                        inventory.inventoryList.contains("이상해풀의 풀입")&&raise==0){
                    inventory.list.remove(this);
                    inventory.inventoryList.remove("이상해풀의 풀입");
                    inventory.list.add(store.upgradeShoes2);
                    inventory.setCash(inventory.getCash()-300);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
            case 3:
                if(inventory.getCash()>=600&&
                        inventory.inventoryList.contains("이상해꽃의 꽃")&&raise==0){
                    inventory.list.remove(this);
                    inventory.inventoryList.remove("이상해꽃의 꽃");
                    inventory.list.add(store.upgradeShoes3);
                    inventory.setCash(inventory.getCash()-600);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
        }
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
