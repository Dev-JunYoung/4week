public class Armor extends Equipments{
    //갑옷 클래스
    int armorPower; //상승방어력
    public Armor(String name,int price, int upgrade ,int armorPower) {
        setName(name);
        setPrice(price);
        setUpgrade(upgrade);
        setArmorPower(armorPower);
    }
    //오버라이딩 메서드
    @Override
    public void 상호작용(User user, Store store) {
        switch (upgrade){
            case 1:
                System.out.print("초보자의 ");
                user.getInventory().setArmor(this,user,store);
                break;
            case 2:
                System.out.print("숙련자의 ");
                user.getInventory().setArmor2(this, user,store);
                break;
            case 3:
                System.out.print("마스터의 ");
                user.getInventory().setArmor3(this,user,store);
                break;
            case 4:
                System.out.print("강화된 초보자의 ");
                user.getInventory().setUpgradeArmor(this,user,store);
                break;
            case 5:
                System.out.print("강화된 숙련자의 ");
                user.getInventory().setUpgradeArmor2(this,user,store);
                break;
            case 6:
                System.out.print("강화된 마스터의 ");
                user.getInventory().setUpgradeArmor3(this,user,store);
                break;
        }
    }
    @Override
    public void sell(User user) {
        user.getInventory().setCash(user.getInventory().getCash()+this.getPrice());
        System.out.println(ConsoleColors.FONT_YELLOW+this.getName()+"   판매완료!!! 얻은 금화   :    "+this.getPrice()+ConsoleColors.RESET);
    }
    @Override
    public void upgradeEquipment(User user, Store store) {
        switch (upgrade){
            case 1:
                if(user.getInventory().getCash()>=100&&
                        user.getInventory().inventoryList.contains("꼬북이의 등딱지")&&raise==0){
                    user.getInventory().list.remove(this);
                    user.getInventory().inventoryList.remove("꼬북이의 등딱지");
                    user.getInventory().list.add(store.upgradeArmor);
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
                        user.getInventory().inventoryList.contains("어니부기의 등딱지")&&raise==0){
                    user.getInventory().list.remove(this);
                    user.getInventory().inventoryList.remove("어니부기의 등딱지");
                    user.getInventory().list.add(store.upgradeArmor2);
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
                        user.getInventory().inventoryList.contains("거북왕의 등딱지")&&raise==0){
                    user.getInventory().list.remove(this);
                    user.getInventory().inventoryList.remove("거북왕의 등딱지");
                    user.getInventory().list.add(store.upgradeArmor3);
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
    //getter,setter
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
