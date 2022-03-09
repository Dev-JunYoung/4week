import java.util.Scanner;

public class upgradeEquipment {

Scanner sc=new Scanner(System.in);
String 이름;
    Inventory Upgrade(Inventory inventory,Store store){
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  숙련자의 검 획득조건   :    초보자의 검   ㅣ    파이리의 꼬리     ㅣ   금화 300    ㅣ ");
        System.out.println("ㅣ  숙련자의 갑옷 획득조건  :   초보자의 갑옷  ㅣ   꼬북이의 등딱지    ㅣ   금화 300    ㅣ");
        System.out.println("ㅣ  숙련자의 신발 획득조건  :   초보자의 신발  ㅣ   이상해씨의 씨앗    ㅣ   금화 300    ㅣ ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  마스터의 검 획득조건   :    숙련자의 검   ㅣ    리자드의 꼬리     ㅣ   금화 600    ㅣ ");
        System.out.println("ㅣ  미스터의 갑옷 획득조건  :   숙련자의 갑옷  ㅣ  어니부기의 등딱지    ㅣ   금화 600    ㅣ ");
        System.out.println("ㅣ  마스터의 신발 획득조건  :   숙련자의 신발  ㅣ   이상해풀의 풀립    ㅣ   금화 600    ㅣ ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        //유효성 검사
        //드랍아이템, 금화 확인해서 부족하면 실행 ㄴㄴ
        //확인을....if(리스트의 이르
    // if(이름.equals("초보자의 신발")&&
    // inventory.inventoryList.equals("파이리의 꼬리"))&&
    // inventory.getCash()>300 /세개다 있으면 실행 오...... 해보자
        for (int i = 0; i < inventory.inventoryList.size(); i++) {
            System.out.println(i + ":" + inventory.inventoryList.get(i) + "    ");
        }
        System.out.println("  입력하시오     (나가기:0)");
        이름 = sc.nextLine();
        if(inventory.getCash()>300){
            if (이름.equals("초보자의 검")) {
                                upgradeSoad(inventory,store);
            } else if (이름.equals("초보자의 갑옷")) {
                upgradeArmor(inventory,store);
            } else if (이름.equals("초보자의 신발")) {
                upgradeShoes(inventory,store);               
            } else if(이름.equals("초보자의 신발")&&inventory.inventoryList.equals("파이리의 꼬리")&&inventory.getCash()>300){
                
            }else{
                System.out.println("입력하신 아이템은 강화대상이 아닙니다.");
            }
        }else {
            System.out.println("강화에 필요한 금화가 부족합니다.");
        }

        return inventory;
    }
    void upgradeSoad(Inventory inventory,Store store){
        inventory.inventoryList.remove("파이리의 꼬리");
        inventory.inventoryList.remove("초보자의 검");
        inventory.setCash(inventory.getCash()-300);
        inventory.inventoryList.add(store.soad2.getName());
        System.out.println(store.soad2.getName()+"을 획득했습니다.");
    }
    void upgradeArmor(Inventory inventory,Store store){
        inventory.inventoryList.remove("꼬북이의 등딱지");
        inventory.inventoryList.remove("초보자의 갑옷");
        inventory.setCash(inventory.getCash()-300);
        inventory.inventoryList.add(store.armor2.getName());
        System.out.println(store.armor2.getName()+"을 획득했습니다.");
    }
    void upgradeShoes(Inventory inventory,Store store){
        inventory.inventoryList.remove("이상해씨의 씨앗");
        inventory.inventoryList.remove("초보자의 신발");
        inventory.setCash(inventory.getCash()-300);
        inventory.inventoryList.add(store.shoes2.getName());
        System.out.println(store.shoes2.getName()+"을 획득했습니다.");
    }
}
