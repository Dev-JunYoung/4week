public class Armor extends Equipments{
    int armorPower; //상승방어력
    public Armor(String name,int price, int upgrade ,int armorPower) {
        setName(name);
        setPrice(price);
        setUpgrade(upgrade);
        setArmorPower(armorPower);
    }

    @Override
    public void 상호작용(User user, Inventory inventory, Store store) {
        switch (upgrade){
            case 1:
                System.out.print("초보자의 ");
                inventory.setArmor(this,user,store);
                break;
            case 2:
                System.out.print("숙련자의 ");
                inventory.setArmor2(this, user,store);
                break;
            case 3:
                System.out.print("마스터의 ");
                inventory.setArmor3(this,user,store);
                break;
            case 4:
                System.out.print("강화된 초보자의 ");
                inventory.setUpgradeArmor(this,user,store);
                break;
            case 5:
                System.out.print("강화된 숙련자의 ");
                inventory.setUpgradeArmor2(this,user,store);
                break;
            case 6:
                System.out.print("강화된 마스터의 ");
                inventory.setUpgradeArmor3(this,user,store);
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
                        inventory.inventoryList.contains("꼬북이의 등딱지")&&raise==0){
                    inventory.list.remove(this);
                    inventory.inventoryList.remove("꼬북이의 등딱지");
                    inventory.list.add(store.upgradeArmor);
                    inventory.setCash(inventory.getCash()-100);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
            case 2:
                if(inventory.getCash()>=300&&
                        inventory.inventoryList.contains("어니부기의 등딱지")&&raise==0){
                    inventory.list.remove(this);
                    inventory.inventoryList.remove("어니부기의 등딱지");
                    inventory.list.add(store.upgradeArmor2);
                    inventory.setCash(inventory.getCash()-300);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
            case 3:
                if(inventory.getCash()>=600&&
                        inventory.inventoryList.contains("거북왕의 등딱지")&&raise==0){
                    inventory.list.remove(this);
                    inventory.inventoryList.remove("거북왕의 등딱지");
                    inventory.list.add(store.upgradeArmor3);
                    inventory.setCash(inventory.getCash()-600);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
        }
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
