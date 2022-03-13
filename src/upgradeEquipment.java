import java.util.Scanner;

public class upgradeEquipment {

Scanner sc=new Scanner(System.in);
String 이름;
    Inventory Upgrade(Inventory inventory,Store store){
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  초보자의 검 강화조건   :    초보자의 검   ㅣ    파이리의 꼬리     ㅣ   금화 100    ㅣ ");
        System.out.println("ㅣ  초보자의 갑옷 강화조건  :   초보자의 갑옷  ㅣ   꼬북이의 등딱지    ㅣ   금화 100    ㅣ");
        System.out.println("ㅣ  초보자의 신발 강화조건  :   초보자의 신발  ㅣ   이상해씨의 씨앗    ㅣ   금화 100    ㅣ ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  숙련자의 검 강화조건   :    초보자의 검   ㅣ    파이리의 꼬리     ㅣ   금화 300    ㅣ ");
        System.out.println("ㅣ  숙련자의 갑옷 강화조건  :   초보자의 갑옷  ㅣ   꼬북이의 등딱지    ㅣ   금화 300    ㅣ");
        System.out.println("ㅣ  숙련자의 신발 강화조건  :   초보자의 신발  ㅣ   이상해씨의 씨앗    ㅣ   금화 300    ㅣ ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  마스터의 검 강화조건   :    숙련자의 검   ㅣ    리자드의 꼬리     ㅣ   금화 600    ㅣ ");
        System.out.println("ㅣ  미스터의 갑옷 강화조건  :   숙련자의 갑옷  ㅣ  어니부기의 등딱지    ㅣ   금화 600    ㅣ ");
        System.out.println("ㅣ  마스터의 신발 강화조건  :   숙련자의 신발  ㅣ   이상해풀의 풀입    ㅣ   금화 600    ㅣ ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        //유효성 검사

    // inventory.getCash()>300 /세개다 있으면 실행 오...... 해보자
        for (int i = 0; i < inventory.inventoryList.size(); i++) {
            System.out.println(i + ":" + inventory.inventoryList.get(i) + "    ");
        }
        System.out.println(" 재료에 사용된 아이템과 금화는 사라집니다.");
        System.out.println(" 강화할 아이템을 정확하게 입력하시오    (나가기:0)");
        이름 = sc.nextLine();
        if(이름.equals("초보자의 검")){
            if(inventory.getCash()>=300&&
                    inventory.inventoryList.contains("초보자의 검")&&
                    inventory.inventoryList.contains("파이리의 꼬리")){
                                    upgradeSoad(inventory,store);

            }else {
                System.out.println("재료가 부족합니다");
            }
        }
        else if(이름.equals("초보자의 갑옷")){
                if(inventory.getCash()>=300&&
                        inventory.inventoryList.contains("초보자의 갑옷")&&
                        inventory.inventoryList.contains("꼬북이의 등딱지")){
                    upgradeArmor(inventory,store);
                }else {
                    System.out.println("재료가 부족합니다");
                }
        }
        else if(이름.equals("초보자의 신발")){
                if(inventory.getCash()>=300&&
                        inventory.inventoryList.contains("초보자의 신발")&&
                        inventory.inventoryList.contains("이상해씨의 씨앗")){
                    upgradeShoes(inventory,store);
                }else {
                    System.out.println("재료가 부족합니다");
                }
        }
        else if(이름.equals("숙련자의 검")){
            if(inventory.getCash()>=600&&
                    inventory.inventoryList.contains("숙련자의 검")&&
                    inventory.inventoryList.contains("리자드의 꼬리")){
                upgradeSoad2(inventory,store);
            }else {
                System.out.println("재료가 부족합니다");
            }
        }
        else if(이름.equals("숙련자의 갑옷")){
            if(inventory.getCash()>=600&&
                    inventory.inventoryList.contains("숙련자의 갑옷")&&
                    inventory.inventoryList.contains("어니부기의 등딱지")){
                upgradeArmor2(inventory,store);
            }else {
                System.out.println("재료가 부족합니다");
            }
        }
        else if(이름.equals("숙련자의 신발")){
            if(inventory.getCash()>=600&&
                    inventory.inventoryList.contains("숙련자의 신발")&&
                    inventory.inventoryList.contains("이상해풀의 풀입")){
                upgradeShoes2(inventory,store);
            }else {
                System.out.println("재료가 부족합니다");
            }
        }else if(이름.equals("마스터의 검")){
            if(inventory.getCash()>=1000&&
                    inventory.inventoryList.contains("마스터의 검")&&
                    inventory.inventoryList.contains("리자몽의 꼬리")){
                upgradeSoad3(inventory,store);
            }else {
                System.out.println("재료가 부족합니다");
            }
        }else if(이름.equals("마스터의 갑옷")){
            if(inventory.getCash()>=1000&&
                    inventory.inventoryList.contains("마스터의 갑옷")&&
                    inventory.inventoryList.contains("거북왕의 등딱지")){
                upgradeArmor3(inventory,store);
            }else {
                System.out.println("재료가 부족합니다");
            }
        }else if(이름.equals("마스터의 신발")){
            if(inventory.getCash()>=1000&&
                    inventory.inventoryList.contains("마스터의 신발")&&
                    inventory.inventoryList.contains("이상해꽃의 꽃")){
                upgradeShoes3(inventory,store);
            }else {
                System.out.println("재료가 부족합니다");
            }
        }






        else {
            System.out.println("정확하게 입력하지 않았거나, 인벤토리에 없는 아이템입니다.");
        }
        return inventory;
    }
    soad upgradeSoad=new soad("초보자의 검(강화)",200,2  ,20);
    Armor UpgradeArmor=new Armor("초보자의 갑옷(강화)",200,2,20);
    Shoes UpgradeShoes=new Shoes("초보자의 신발(강화)",200,2,20);
    soad upgradeSoad2=new soad("숙련자의 검(강화)",500,3,40);
    Armor upgradeArmor2=new Armor("숙련자의 갑옷(강화)",500,3,40);
    Shoes upgradeShoes2=new Shoes("숙련자의 신발(강화)",500,3,40);
    soad upgradeSoad3=new soad("마스터의 검(강화)",1000,4,100);
    Armor upgradeArmor3=new Armor("마스터의 갑옷(강화)",1000,4,100);
    Shoes upgradeShoes3=new Shoes("마스터의 신발(강화)",1000,4,100);
    //3티어----------------------------------------------------------------------------------------------------------
    void upgradeSoad(Inventory inventory, Store store){
        inventory.inventoryList.remove("파이리의 꼬리");
        inventory.inventoryList.remove("초보자의 검");
        inventory.setCash(inventory.getCash()-300);

        //soad soadUpgrade=new soad("초보자의 검(강화)",200,2  ,20);
        inventory.inventoryList.add(upgradeSoad.getName());
        System.out.println(upgradeSoad.getName()+"을 획득했습니다.");
    }
    void upgradeArmor(Inventory inventory,Store store){
        inventory.inventoryList.remove("꼬북이의 등딱지");
        inventory.inventoryList.remove("초보자의 갑옷");
        inventory.setCash(inventory.getCash()-300);


        inventory.inventoryList.add(UpgradeArmor.getName());
        System.out.println(UpgradeArmor.getName()+"을 획득했습니다.");
    }
    void upgradeShoes(Inventory inventory,Store store){
        inventory.inventoryList.remove("이상해씨의 씨앗");
        inventory.inventoryList.remove("초보자의 신발");
        inventory.setCash(inventory.getCash()-300);
        inventory.inventoryList.add(UpgradeShoes.getName());
        System.out.println(UpgradeShoes.getName()+"을 획득했습니다.");
    }
    //----------------------------------------------------------------------------------------------------------
    void upgradeSoad2(Inventory inventory,Store store){
        inventory.inventoryList.remove("리자드의 꼬리");
        inventory.inventoryList.remove("숙련자의 검");
        inventory.setCash(inventory.getCash()-600);


        inventory.inventoryList.add(upgradeSoad2.getName());
        System.out.println(upgradeSoad2.getName()+"을 획득했습니다.");
    }
    void upgradeArmor2(Inventory inventory,Store store){
        inventory.inventoryList.remove("어니부기의 등딱지");
        inventory.inventoryList.remove("숙련자의 갑옷");
        inventory.setCash(inventory.getCash()-600);


        inventory.inventoryList.add(upgradeArmor2.getName());
        System.out.println(upgradeArmor2.getName()+"을 획득했습니다.");
    }
    void upgradeShoes2(Inventory inventory,Store store){
        inventory.inventoryList.remove("이상해풀의 풀입");
        inventory.inventoryList.remove("숙련자의 신발");
        inventory.setCash(inventory.getCash()-600);


        inventory.inventoryList.add(upgradeShoes2.getName());
        System.out.println(upgradeShoes2.getName()+"을 획득했습니다.");
    }
    //----------------------------------------------------------------------------------------------------------
    void upgradeSoad3(Inventory inventory,Store store){
        inventory.inventoryList.remove("리자몽의 꼬리");
        inventory.inventoryList.remove("마스터의 검");
        inventory.setCash(inventory.getCash()-600);


        inventory.inventoryList.add(upgradeSoad3.getName());
        System.out.println(upgradeSoad3.getName()+"을 획득했습니다.");
    }
    void upgradeArmor3(Inventory inventory,Store store){
        inventory.inventoryList.remove("거북왕의 등딱지");
        inventory.inventoryList.remove("마스터의 갑옷");
        inventory.setCash(inventory.getCash()-600);


        inventory.inventoryList.add(upgradeArmor3.getName());
        System.out.println(upgradeArmor3.getName()+"을 획득했습니다.");
    }
    void upgradeShoes3(Inventory inventory,Store store){
        inventory.inventoryList.remove("이상해꽃의 꽃");
        inventory.inventoryList.remove("마스터의 신발");
        inventory.setCash(inventory.getCash()-600);


        inventory.inventoryList.add(upgradeShoes3.getName());
        System.out.println(upgradeShoes3.getName()+"을 획득했습니다.");
    }
}
