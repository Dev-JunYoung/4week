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
    //Item 오버라이드 메서드
    @Override
    public void 상호작용(User user , Store store) {
        switch (upgrade){
            case 1:
                System.out.println();
                System.out.print("초보자의 ");
                user.getInventory().setSoad(this,user,store);
                break;
            case 2:
                System.out.print("숙련자의 ");
                user.getInventory().setSoad2(this, user,store);
                break;
            case 3:
                System.out.print("마스터의 ");
                user.getInventory().setSoad3(this,user,store);
                break;
            case 4:
                System.out.print("강화된 초보자의 ");
                user.getInventory().setUpgradeSoad(this,user,store);
                break;
            case 5:
                System.out.print("강화된 숙련자의 ");
                user.getInventory().setUpgradeSoad2(this,user,store);
                break;
            case 6:
                System.out.print("강화된 마스터의 ");
                user.getInventory().setUpgradeSoad3(this,user,store);
                break;
        }
    }
    //Equipment 오버라이드 메서드
    @Override
    public void upgradeEquipment(User user,Store store) {
        switch (upgrade){
            case 1:
                if(user.getInventory().getCash()>=100&&
                    user.getInventory().inventoryList.contains("파이리의 꼬리")&&raise==0){
                user.getInventory().list.remove(this);
                user.getInventory().inventoryList.remove("파이리의 꼬리");
                user.getInventory().list.add(store.upgradeSoad);
                    user.getInventory().setCash(user.getInventory().getCash()-100);
                    System.out.println(ConsoleColors.FONT_YELLOW+"" +
                            "███████╗██╗   ██╗ ██████╗ ██████╗███████╗███████╗███████╗\n" +
                            "██╔════╝██║   ██║██╔════╝██╔════╝██╔════╝██╔════╝██╔════╝\n" +
                            "███████╗██║   ██║██║     ██║     █████╗  ███████╗███████╗\n" +
                            "╚════██║██║   ██║██║     ██║     ██╔══╝  ╚════██║╚════██║\n" +
                            "███████║╚██████╔╝╚██████╗╚██████╗███████╗███████║███████║\n" +
                            "╚══════╝ ╚═════╝  ╚═════╝ ╚═════╝╚══════╝╚══════╝╚══════╝\n" +
                            "                                                         "+ConsoleColors.RESET);
            }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
            case 2:
                if(user.getInventory().getCash()>=300&&
                        user.getInventory().inventoryList.contains("리자드의 꼬리")&&raise==0){
                    user.getInventory().list.remove(this);
                    user.getInventory().inventoryList.remove("리자드의 꼬리");
                    user.getInventory().list.add(store.upgradeSoad2);
                    user.getInventory().setCash(user.getInventory().getCash()-300);
                    System.out.println(ConsoleColors.FONT_YELLOW+"" +
                            "███████╗██╗   ██╗ ██████╗ ██████╗███████╗███████╗███████╗\n" +
                            "██╔════╝██║   ██║██╔════╝██╔════╝██╔════╝██╔════╝██╔════╝\n" +
                            "███████╗██║   ██║██║     ██║     █████╗  ███████╗███████╗\n" +
                            "╚════██║██║   ██║██║     ██║     ██╔══╝  ╚════██║╚════██║\n" +
                            "███████║╚██████╔╝╚██████╗╚██████╗███████╗███████║███████║\n" +
                            "╚══════╝ ╚═════╝  ╚═════╝ ╚═════╝╚══════╝╚══════╝╚══════╝\n" +
                            "                                                         "+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
            case 3:
                if(user.getInventory().getCash()>=600&&
                        user.getInventory().inventoryList.contains("리자몽의 꼬리")&&raise==0){
                    user.getInventory().list.remove(this);
                    user.getInventory().inventoryList.remove("리자몽의 꼬리");
                    user.getInventory().list.add(store.upgradeSoad3);
                    user.getInventory().setCash(user.getInventory().getCash()-600);
                    System.out.println(ConsoleColors.FONT_YELLOW+"" +
                            "███████╗██╗   ██╗ ██████╗ ██████╗███████╗███████╗███████╗\n" +
                            "██╔════╝██║   ██║██╔════╝██╔════╝██╔════╝██╔════╝██╔════╝\n" +
                            "███████╗██║   ██║██║     ██║     █████╗  ███████╗███████╗\n" +
                            "╚════██║██║   ██║██║     ██║     ██╔══╝  ╚════██║╚════██║\n" +
                            "███████║╚██████╔╝╚██████╗╚██████╗███████╗███████║███████║\n" +
                            "╚══════╝ ╚═════╝  ╚═════╝ ╚═════╝╚══════╝╚══════╝╚══════╝\n" +
                            "                                                         "+ConsoleColors.RESET);
                }else {
                    System.out.println("재료가 부족합니다");
                }
                break;
        }
    }
    @Override
    public void sell(User user) {
        user.getInventory().setCash(user.getInventory().getCash()+this.getPrice());
        System.out.println(ConsoleColors.FONT_YELLOW+this.getName()+"   판매완료!!! 얻은 금화   :    "+this.getPrice()+ConsoleColors.RESET);
    }


    //getter, setter
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
    @Override
    public int getUpgrade() {
        return super.getUpgrade();
    }
    public int getAttackPower() {
        return AttackPower;
    }
    public void setAttackPower(int attackPower) {
        AttackPower = attackPower;
    }
}
