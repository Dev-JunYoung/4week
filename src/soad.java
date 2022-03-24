public class soad extends Equipments{
    //상승공격력
    int AttackPower;
    public soad(String name, int price, int upgrade  , int attackPower, int raise) {
        setName(name);
        setPrice(price);
        setUpgrade(upgrade);
        setAttackPower(attackPower);
        setRaise(raise);
    }
    @Override
    public void 상호작용(User user, Inventory inventory, Store store) {
        switch (upgrade){
            case 1:
                System.out.println();
                System.out.print("초보자의 ");
                inventory.setSoad(this,user,store);
                break;
            case 2:
                System.out.print("숙련자의 ");
                inventory.setSoad2(this, user,store);
                break;
            case 3:
                System.out.print("마스터의 ");
                inventory.setSoad3(this,user,store);
                break;
            case 4:
                System.out.print("강화된 초보자의 ");
                inventory.setUpgradeSoad(this,user,store);
                break;
            case 5:
                System.out.print("강화된 숙련자의 ");
                inventory.setUpgradeSoad2(this,user,store);
                break;
            case 6:
                System.out.print("강화된 마스터의 ");
                inventory.setUpgradeSoad3(this,user,store);
                break;
        }
    }

    @Override
    public void upgradeEquipment(User user, Inventory inventory,Store store) {
        switch (upgrade){
            case 1:
                if(inventory.getCash()>=100&&
                    inventory.inventoryList.contains("파이리의 꼬리")&&raise==0){
                inventory.list.remove(this);
                inventory.inventoryList.remove("파이리의 꼬리");
                inventory.list.add(store.upgradeSoad);
                    inventory.setCash(inventory.getCash()-100);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
            }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
            case 2:
                if(inventory.getCash()>=300&&
                        inventory.inventoryList.contains("리자드의 꼬리")&&raise==0){
                    inventory.list.remove(this);
                    inventory.inventoryList.remove("리자드의 꼬리");
                    inventory.list.add(store.upgradeSoad2);
                    inventory.setCash(inventory.getCash()-300);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
            case 3:
                if(inventory.getCash()>=600&&
                        inventory.inventoryList.contains("리자몽의 꼬리")&&raise==0){
                    inventory.list.remove(this);
                    inventory.inventoryList.remove("리자몽의 꼬리");
                    inventory.list.add(store.upgradeSoad3);
                    inventory.setCash(inventory.getCash()-600);
                    System.out.println(ConsoleColors.FONT_YELLOW+"강화 성공!!!"+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
        }




    }

    @Override
    public void sell(Inventory inventory) {
        inventory.setCash(inventory.getCash()+this.getPrice());
        System.out.println(ConsoleColors.FONT_YELLOW+this.getName()+"   판매완료!!! 얻은 금화   :    "+this.getPrice()+ConsoleColors.RESET);
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
