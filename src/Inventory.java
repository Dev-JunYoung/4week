import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    Scanner sc=new Scanner(System.in);
    int num;
    int cash;
    String 이름;
    boolean loop=true;
    
    public int getCash() {
        return cash;
    } 
    public void setCash(int cash) {
        this.cash = cash;
    }
    //상품구입, 아이템관련 메서드 필요한 객체 생성
    Store store=new Store();
    
    //인벤토리 저장 리스트
    ArrayList inventoryList=new ArrayList();

    //착용장비배열
   String[] wearing=new String[3];
    //인벤토리목록
    void inventoryView(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){

            System.out.println("---------------------------------------------------------------------");
            for (int i = 0; i < inventoryList.size(); i++) {
                System.out.println(i + ":" + inventoryList.get(i) + "    ");
            }
            System.out.println("보유금화   :   " + getCash());
            System.out.println("---------------------------------------------------------------------");
            System.out.println("문자열로 입력하시오.  장비는 장착, 포션은 사용     (나가기:0)");
            이름 = sc.nextLine();
            if (이름.equals("hpPotion50")) {
                setHpPotion(user, store, inventory);
            } else if (이름.equals("mpPotion50")) {
                setMpPotion(user, store, inventory);
            }else if (이름.equals("hpPotion100")) {
                setHpPotion100(user, store, inventory);
            }else if (이름.equals("mpPotion100")) {
                setMpPotion100(user, store, inventory);
            }else if (이름.equals("hpPotion200")) {
                setHpPotion200(user, store, inventory);
            }else if (이름.equals("mpPotion200")) {
                setMpPotion200(user, store, inventory);
            }
            //setPotion  끝
            else if (이름.equals("초보자의 검")) {
                setSoad(user, store, inventory,upgradeEquipment);

            }   else if (이름.equals("숙련자의 검")) {
                setSoad2(user, store, inventory,upgradeEquipment);
            }
            else if (이름.equals("마스터의 검")) {
                setSoad3(user, store, inventory,upgradeEquipment);
            }
           else if (이름.equals("초보자의 갑옷")) {
                setArmor(user, store, inventory,upgradeEquipment);
            } else if (이름.equals("숙련자의 갑옷")) {
                setArmor2(user, store, inventory,upgradeEquipment);
            } else if (이름.equals("마스터의 갑옷")) {
                setArmor3(user, store, inventory,upgradeEquipment);
            }

            else if (이름.equals("초보자의 신발")) {
                setShoes(user, store, inventory,upgradeEquipment);
            }
            else if (이름.equals("숙련자의 신발")) {
                setShoes2(user, store, inventory,upgradeEquipment);
            }
            else if (이름.equals("마스터의 신발")) {
                setShoes3(user, store, inventory,upgradeEquipment);
            }
//강화---------------------------------------------------------------------------
            else if (이름.equals("초보자의 검(강화)")) {
                setUpgradeSoad(user, store, inventory,upgradeEquipment);

            }   else if (이름.equals("숙련자의 검(강화)")) {
                setUpgradeSoad2(user, store, inventory,upgradeEquipment);
            }
            else if (이름.equals("마스터의 검(강화)")) {
                setUpgradeSoad3(user, store, inventory,upgradeEquipment);
                //-------------------------------------------------------------------
            }else if (이름.equals("초보자의 갑옷(강화)")) {
                setUpgradeArmor(user, store, inventory,upgradeEquipment);

            }   else if (이름.equals("숙련자의 갑옷(강화)")) {
                setUpgradeArmor2(user, store, inventory,upgradeEquipment);
            }
            else if (이름.equals("마스터의 갑옷(강화)")) {
                setUpgradeArmor3(user, store, inventory,upgradeEquipment);
            }//----------------------------------------------------------------------------
            else if (이름.equals("초보자의 신발(강화)")) {
                setUpgradeShoes(user, store, inventory,upgradeEquipment);

            }   else if (이름.equals("숙련자의 신발(강화)")) {
                setUpgradeShoes2(user, store, inventory,upgradeEquipment);
            }
            else if (이름.equals("마스터의 신발(강화)")) {
                setUpgradeShoes3(user, store, inventory,upgradeEquipment);
            }

//----------------------------------------------------------------------------------------------------------
            else {
                System.out.println("입력하신 아이템은 없습니다.");
            }
    }
    //목록초기화 (치트키 유무)
    void inventoryInit(User user,Inventory inventory){
       if( user.getName().equals("cheat")){
           inventory.setCash(100000);
           inventory.inventoryList.add("파이리의 꼬리");
           inventory.inventoryList.add("꼬북이의 등딱지");
           inventory.inventoryList.add("이상해씨의 씨앗");
           inventory.inventoryList.add("리자드의 꼬리");
           inventory.inventoryList.add("어니부기의 등딱지");
           inventory.inventoryList.add("이상해풀의 풀입");
           inventory.inventoryList.add("리자몽의 꼬리");
           inventory.inventoryList.add("거북왕의 등딱지");
           inventory.inventoryList.add("이상해꽃의 꽃");
           inventory.inventoryList.add("뮤츠의 유골");

       }else {
           inventory.setCash(1000);
       }
    }
    //착용장비
    void wearing(User user,Inventory inventory){
        System.out.println("----------------------------------------------------------------------------------");
                for(int i=0;i<wearing.length;i++){
                    System.out.println("착용장비 : "+wearing[i]+"  ");
                }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ    1.돌아가기    ㅣ    ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        num=sc.nextInt();
        if(num==1){

        }
    }
    //검장착 업그레이드장비까지끝------------------------------------------------------------------------------------------
    void setSoad(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            inventoryList.remove("초보자의 검");
            wearing[0] = "초보자의 검";
        } else if (wearing[0].equals("초보자의 검")) { //있으면 삭제하고장착 1
            inventoryList.remove("초보자의 검"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            wearing[0] = "초보자의 검";
            inventoryList.add("초보자의 검"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("초보자의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            wearing[0] = "초보자의 검";
            inventoryList.add("숙련자의 검");
        } else if (wearing[0].equals("마스터의 검")) { //있으면 삭제하고장착 3
            inventoryList.remove("초보자의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            wearing[0] = "초보자의 검";
            inventoryList.add("마스터의 검");

            //초보자의 검 착용하는데 (강화가 있는경우 3가지)
        }else if (wearing[0].equals("초보자의 검(강화)")) { //있으면 삭제하고장착 1
            inventoryList.remove("초보자의 검"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            wearing[0] = "초보자의 검";
            inventoryList.add("초보자의 검(강화)"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("초보자의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            wearing[0] = "초보자의 검";
            inventoryList.add("숙련자의 검(강화)");
        } else if (wearing[0].equals("마스터의 검(강화)")) { //있으면 삭제하고장착 3
            inventoryList.remove("초보자의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            wearing[0] = "초보자의 검";
            inventoryList.add("마스터의 검(강화)");
        }



    }
    void setSoad2(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment) {
        if (wearing[0] == null) {  //비어있으면 바로 장착
            inventoryList.remove("초보자의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] = "숙련자의 검";
        } else if (wearing[0].equals("초보자의 검")) { //있으면 삭제하고장착 1
            inventoryList.remove("숙련자의 검"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] = "숙련자의 검"; //wearing 배열에 추가
            inventoryList.add("초보자의 검"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("숙련자의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] = "숙련자의 검";
            inventoryList.add("숙련자의 검");
        } else if (wearing[0].equals("마스터의 검")) { //있으면 삭제하고장착 3
            inventoryList.remove("숙련자의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] = "숙련자의 검";
            inventoryList.add("마스터의 검");
            //--------------------------------------------------------------------------------

        }else if (wearing[0].equals("초보자의 검(강화)")) { //있으면 삭제하고장착 1
            inventoryList.remove("숙련자의 검"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] = "숙련자의 검";
            inventoryList.add("초보자의 검(강화)"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("숙련자의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] = "숙련자의 검";
            inventoryList.add("숙련자의 검(강화)");
        } else if (wearing[0].equals("마스터의 검(강화)")) { //있으면 삭제하고장착 3
            inventoryList.remove("마스터의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] = "숙련자의 검";
            inventoryList.add("마스터의 검(강화)");
        }
    }
    void setSoad3(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment) {
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            inventoryList.remove("마스터의 검");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검";
        }
        else if (wearing[0].equals("초보자의 검")) { //있으면 삭제하고장착 1
            inventoryList.remove("마스터의 검"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검"; //wearing 배열에 추가
            inventoryList.add("초보자의 검"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("마스터의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검";
            inventoryList.add("숙련자의 검");
        } else if (wearing[0].equals("마스터의 검")) { //있으면 삭제하고장착 3
            inventoryList.remove("마스터의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검";
            inventoryList.add("마스터의 검");
        }else if (wearing[0].equals("초보자의 검(강화)")) { //있으면 삭제하고장착 1
            inventoryList.remove("마스터의 검"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검"; //wearing 배열에 추가
            inventoryList.add("초보자의 검(강화)"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("마스터의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검";
            inventoryList.add("숙련자의 검(강화)");
        } else if (wearing[0].equals("마스터의 검(강화)")) { //있으면 삭제하고장착 3
            inventoryList.remove("마스터의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검";
            inventoryList.add("마스터의 검(강화)");
        }
        //---------------------------------------------------------------------------------
        else if (wearing[0].equals("초보자의 검(강화)")) { //있으면 삭제하고장착 1
            inventoryList.remove("마스터의 검"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검"; //wearing 배열에 추가
            inventoryList.add("초보자의 검(강화)"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("마스터의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검";
            inventoryList.add("숙련자의 검(강화)");
        } else if (wearing[0].equals("마스터의 검(강화)")) { //있으면 삭제하고장착 3
            inventoryList.remove("마스터의 검");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] = "마스터의 검";
            inventoryList.add("마스터의 검(강화)");
        }
    }

    //--------------------------------------------------------------------------------------------
    //갑옷장착 업그레이드장비까지끝----------------------------------------------------------------------------------------------------
    void setArmor(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[1]==null){
            wearing[1]="초보자의 갑옷";
            inventoryList.remove("초보자의 갑옷");
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("초보자의 갑옷")){
            inventoryList.add("초보자의 갑옷");
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            wearing[1] = "초보자의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷")){
            inventoryList.add("숙련자의 갑옷");
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            wearing[1] = "초보자의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷")){
            inventoryList.add("마스터의 갑옷");
            user.setAttack(user.getAttack() + store.armor.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            wearing[1] = "초보자의 갑옷";
            System.out.println("갑옷 장착!");

        }//----------------------------------------------------------------------
        else if(wearing[1].equals("초보자의 갑옷(강화)")){
            inventoryList.add("초보자의 갑옷(강화)");
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            wearing[1] = "초보자의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷(강화)")){
            inventoryList.add("숙련자의 갑옷(강화)");
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            wearing[1] = "초보자의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷(강화)")){
            inventoryList.add("마스터의 갑옷(강화)");
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            wearing[1] = "초보자의 갑옷";
            System.out.println("갑옷 장착!");
        }
    }
    void setArmor2(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[1]==null){
            wearing[1]="숙련자의 갑옷";
            inventoryList.remove("숙련자의 갑옷");
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("초보자의 갑옷")){
            inventoryList.add("초보자의 갑옷");
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷");
            wearing[1]="숙련자의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷")){
            inventoryList.add("숙련자의 갑옷");
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷");
            wearing[1]="숙련자의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷")){
            inventoryList.add("마스터의 갑옷");
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷");
            wearing[1]="숙련자의 갑옷";
            System.out.println("갑옷 장착!");
        }//---------------------------------------------------------------------------------------
        else if(wearing[1].equals("초보자의 갑옷(강화)")){
            inventoryList.add("초보자의 갑옷(강화)");
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷");
            wearing[1]="숙련자의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷(강화)")){
            inventoryList.add("숙련자의 갑옷(강화)");
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷");
            wearing[1]="숙련자의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷(강화)")){
            inventoryList.add("마스터의 갑옷(강화)");
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷");
            wearing[1]="숙련자의 갑옷";
            System.out.println("갑옷 장착!");
        }
    }
    void setArmor3(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[1]==null){

            wearing[1]="마스터의 갑옷";
            inventoryList.remove("마스터의 갑옷");
            user.setDefense(user.getDefense()+store.armor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("초보자의 갑옷")){
            inventoryList.add("초보자의 갑옷");
            user.setDefense(user.getAttack() + store.armor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷");
            wearing[1]="마스터의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷")){
            inventoryList.add("숙련자의 갑옷");
            user.setDefense(user.getAttack() + store.armor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷");
            wearing[1]="마스터의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷")){
            inventoryList.add("마스터의 갑옷");
            user.setDefense(user.getAttack() + store.armor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷");
            wearing[1]="마스터의 갑옷";
            System.out.println("갑옷 장착!");
        }
        else if(wearing[1].equals("초보자의 갑옷(강화)")){
            inventoryList.add("초보자의 갑옷(강화)");
            user.setDefense(user.getAttack() + store.armor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷");
            wearing[1]="마스터의 갑옷";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷(강화)")){
            inventoryList.add("숙련자의 갑옷(강화)");
            user.setDefense(user.getAttack() + store.armor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷(강화)");
            wearing[1]="마스터의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷(강화)")){
            inventoryList.add("마스터의 갑옷(강화)");
            user.setDefense(user.getAttack() + store.armor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷");
            wearing[1]="마스터의 갑옷";
            System.out.println("갑옷 장착!");
        }
    }

    //신발장착-------------------------------------------------------------------------------------------------
    void setShoes(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[2]==null){
            wearing[2]="초보자의 신발";
            inventoryList.remove("초보자의 신발");
            user.setAvoid(user.getAvoid()+store.shoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("초보자의 신발")){
            inventoryList.add("초보자의 신발");
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            inventoryList.remove("초보자의 신발");
            wearing[2]="초보자의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발")){
            inventoryList.add("숙련자의 신발");
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            inventoryList.remove("초보자의 신발");
            wearing[2]="초보자의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발")){
            inventoryList.add("마스터의 신발");
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            inventoryList.remove("초보자의 신발");
            wearing[2]="초보자의 신발";
            System.out.println("신발 장착!");
        }
        else if(wearing[2].equals("초보자의 신발(강화)")){
            inventoryList.add("초보자의 신발(강화)");
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            inventoryList.remove("초보자의 신발");
            wearing[2]="초보자의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발(강화)")){
            inventoryList.add("숙련자의 신발(강화)");
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            inventoryList.remove("초보자의 신발");
            wearing[2]="초보자의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발(강화)")){
            inventoryList.add("마스터의 신발(강화)");
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            inventoryList.remove("초보자의 신발");
            wearing[2]="초보자의 신발";
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }
    void setShoes2(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[2]==null){
            wearing[2]="숙련자의 신발";
            inventoryList.remove("숙련자의 신발");
            user.setDefense(user.getDefense()+store.shoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("초보자의 신발")){
            inventoryList.add("초보자의 신발");
            user.setAttack(user.getAttack() + store.shoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발");
            wearing[2]="숙련자의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발")){
            inventoryList.add("숙련자의 신발");
            user.setAttack(user.getAttack() + store.shoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발");
            wearing[2]="숙련자의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발")){
            inventoryList.add("마스터의 신발");
            user.setAttack(user.getAttack() + store.shoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발");
            wearing[2]="숙련자의 신발";
            System.out.println("신발 장착!");
        }//----------------------------------------------------
        else if(wearing[2].equals("초보자의 신발(강화)")){
            inventoryList.add("초보자의 신발(강화)");
            user.setAttack(user.getAttack() + store.shoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발");
            wearing[2]="숙련자의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발(강화)")){
            inventoryList.add("숙련자의 신발(강화)");
            user.setAttack(user.getAttack() + store.shoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발");
            wearing[2]="숙련자의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발(강화)")){
            inventoryList.add("마스터의 신발(강화)");
            user.setAttack(user.getAttack() + store.shoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발");
            wearing[2]="숙련자의 신발";
            System.out.println("신발 장착!");
        }
    }
    void setShoes3(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[2]==null){
            wearing[2]="마스터의 신발";
            inventoryList.remove("마스터의 신발");
            user.setDefense(user.getDefense()+store.shoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("초보자의 신발")){
            inventoryList.add("초보자의 신발");
            user.setAttack(user.getAttack() + store.shoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발");
            wearing[2]="마스터의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발")){
            inventoryList.add("숙련자의 신발");
            user.setAttack(user.getAttack() + store.shoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발");
            wearing[2]="마스터의 신발";
            System.out.println("마스터의 신발!");
        }else if(wearing[2].equals("마스터의 신발")){
            inventoryList.add("마스터의 신발");
            user.setAttack(user.getAttack() + store.shoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발");
            wearing[2]="마스터의 신발";
            System.out.println("신발 장착!");
        }//-------------------------------------------------------------------------
        else if(wearing[2].equals("초보자의 신발(강화)")){
            inventoryList.add("초보자의 신발");
            user.setAttack(user.getAttack() + store.shoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발(강화)");
            wearing[2]="마스터의 신발";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발(강화)")){
            inventoryList.add("숙련자의 신발");
            user.setAttack(user.getAttack() + store.shoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발(강화)");
            wearing[2]="마스터의 신발";
            System.out.println("마스터의 신발!");
        }else if(wearing[2].equals("마스터의 신발(강화)")){
            inventoryList.add("마스터의 신발(강화)");
            user.setAttack(user.getAttack() + store.shoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발");
            wearing[2]="마스터의 신발";
            System.out.println("신발 장착!");
        }
    }
    //--------------------------------------------------------------------------------------------
    
    //업그레이드 검장착----------------------------------------------------------------------------------------------------
    void setUpgradeSoad(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() +upgradeEquipment.upgradeSoad.getAttackPower());
            wearing[0] = "초보자의 검(강화)";
            inventoryList.remove("초보자의 검(강화)");
        } else if (wearing[0].equals("초보자의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("초보자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad.getAttackPower());
            wearing[0] = "초보자의 검(강화)";
            inventoryList.add("초보자의 검");
        } else if (wearing[0].equals("숙련자의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("초보자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad.getAttackPower());
            wearing[0] = "초보자의 검(강화)";
            inventoryList.add("숙련자의 검");
        }else if (wearing[0].equals("마스터의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("초보자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad.getAttackPower());
            wearing[0] = "초보자의 검(강화)";
            inventoryList.add("마스터의 검");
        }//---------------------------------------------------------------------------------
        else if (wearing[0].equals("초보자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("초보자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad.getAttackPower());
            wearing[0] = "초보자의 검(강화)";
            inventoryList.add("초보자의 검(강화)");
        } else if (wearing[0].equals("숙련자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("초보자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad.getAttackPower());
            wearing[0] = "초보자의 검(강화)";
            inventoryList.add("숙련자의 검(강화)");
        }else if (wearing[0].equals("마스터의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("초보자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad.getAttackPower());
            wearing[0] = "초보자의 검(강화)";
            inventoryList.add("마스터의 검(강화)");
        }

        //---------------------------------------------------------------------------------------------------------
    }
    void setUpgradeSoad2(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment) {
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() +upgradeEquipment.upgradeSoad2.getAttackPower());
            wearing[0] = "숙련자의 검(강화)";
        } else if (wearing[0].equals("초보자의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("숙련자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad2.getAttackPower());
            wearing[0] = "숙련자의 검(강화)";
            inventoryList.add("초보자의 검");
        } else if (wearing[0].equals("숙련자의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("숙련자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad2.getAttackPower());
            wearing[0] = "숙련자의 검(강화)";
            inventoryList.add("숙련자의 검");
        }else if (wearing[0].equals("마스터의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("숙련자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad2.getAttackPower());
            wearing[0] = "숙련자의 검(강화)";
            inventoryList.add("마스터의 검");
        }//---------------------------------------------------------------------------------
        else if (wearing[0].equals("초보자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("숙련자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad2.getAttackPower());
            wearing[0] = "숙련자의 검(강화)";
            inventoryList.add("초보자의 검(강화)");
        } else if (wearing[0].equals("숙련자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("숙련자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad2.getAttackPower());
            wearing[0] = "숙련자의 검(강화)";
            inventoryList.add("숙련자의 검(강화)");
        }else if (wearing[0].equals("마스터의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("숙련자의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad2.getAttackPower());
            wearing[0] = "숙련자의 검(강화)";
            inventoryList.add("마스터의 검(강화)");
        }
    }
    void setUpgradeSoad3(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment) {
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad3.getAttackPower());
            wearing[0] = "마스터의 검(강화)";
        } else if (wearing[0].equals("초보자의 검")) { //있으면 삭제하고장착 1
            inventoryList.remove("마스터의 검(강화)"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad3.getAttackPower());
            wearing[0] = "마스터의 검(강화)"; //wearing 배열에 추가
            inventoryList.add("초보자의 검"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검")) { //있으면 삭제하고장착 2
            inventoryList.remove("마스터의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad3.getAttackPower());
            wearing[0] = "마스터의 검(강화)";
            inventoryList.add("숙련자의 검");
        } else if (wearing[0].equals("마스터의 검")) { //있으면 삭제하고장착 3
            inventoryList.remove("마스터의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad3.getAttackPower());
            wearing[0] = "마스터의 검(강화)";
            inventoryList.add("마스터의 검");
        }
        //--------------------------------------------------------------------------------------------------------
        else if (wearing[0].equals("초보자의 검(강화)")) { //있으면 삭제하고장착 1
            inventoryList.remove("마스터의 검(강화)"); //장착할거니까 리스트에서는 지워야됌
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad3.getAttackPower());
            wearing[0] = "마스터의 검(강화)"; //wearing 배열에 추가
            inventoryList.add("초보자의 검(강화)"); //착용하고있었던거는 추가
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].equals("숙련자의 검(강화)")) { //있으면 삭제하고장착 2
            inventoryList.remove("마스터의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad3.getAttackPower());
            wearing[0] = "마스터의 검(강화)";
            inventoryList.add("숙련자의 검(강화)");
        } else if (wearing[0].equals("마스터의 검(강화)")) { //있으면 삭제하고장착 3
            inventoryList.remove("마스터의 검(강화)");
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + upgradeEquipment.upgradeSoad3.getAttackPower());
            wearing[0] = "마스터의 검(강화)";
            inventoryList.add("마스터의 검(강화)");
        }
    }
    //업그레이드 갑옷장착----------------------------------------------------------------------------------------------------\
    void setUpgradeArmor(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[1]==null){
            wearing[1]="초보자의 갑옷(강화)";
            inventoryList.remove("초보자의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.UpgradeArmor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("초보자의 갑옷")){
            inventoryList.add("초보자의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.UpgradeArmor.getArmorPower());
            inventoryList.remove("초보자의 갑옷(강화)");
            wearing[1] = "초보자의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷")){
            inventoryList.add("숙련자의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.UpgradeArmor.getArmorPower());
            inventoryList.remove("초보자의 갑옷(강화)");
            wearing[1] = "초보자의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷")){
            inventoryList.add("마스터의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.UpgradeArmor.getArmorPower());
            inventoryList.remove("초보자의 갑옷(강화)");
            wearing[1] = "초보자의 갑옷(강화)";
            System.out.println("갑옷 장착!");

        }//----------------------------------------------------------------------
        else if(wearing[1].equals("초보자의 갑옷(강화)")){
            inventoryList.add("초보자의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.UpgradeArmor.getArmorPower());
            inventoryList.remove("초보자의 갑옷(강화)");
            wearing[1] = "초보자의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷(강화)")){
            inventoryList.add("숙련자의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.UpgradeArmor.getArmorPower());
            inventoryList.remove("초보자의 갑옷(강화)");
            wearing[1] = "초보자의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷(강화)")){
            inventoryList.add("마스터의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.UpgradeArmor.getArmorPower());
            inventoryList.remove("초보자의 갑옷(강화)");
            wearing[1] = "초보자의 갑옷(강화)";
            System.out.println("갑옷 장착!");

        }
    }
    void setUpgradeArmor2(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[1]==null){
            System.out.println("갑옷 장착!");
            wearing[1]="숙련자의 갑옷(강화)";
            inventoryList.remove("숙련자의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("초보자의 갑옷")){
            inventoryList.add("초보자의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷(강화)");
            wearing[1] = "숙련자의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷")){
            inventoryList.add("숙련자의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷(강화)");
            wearing[1] = "숙련자의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷")){
            inventoryList.add("마스터의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷(강화)");
            wearing[1] = "숙련자의 갑옷(강화)";
            System.out.println("갑옷 장착!");

        }//----------------------------------------------------------------------
        else if(wearing[1].equals("초보자의 갑옷(강화)")){
            inventoryList.add("초보자의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷(강화)");
            wearing[1] = "숙련자의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷(강화)")){
            inventoryList.add("숙련자의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷(강화)");
            wearing[1] = "숙련자의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷(강화)")){
            inventoryList.add("마스터의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor2.getArmorPower());
            inventoryList.remove("숙련자의 갑옷(강화)");
            wearing[1] = "숙련자의 갑옷(강화)";
            System.out.println("갑옷 장착!");

        }
    }
    void setUpgradeArmor3(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[1]==null){
            System.out.println("갑옷 장착!");
            wearing[1]="마스터의 갑옷(강화)";
            inventoryList.remove("마스터의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("초보자의 갑옷")){
            inventoryList.add("초보자의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷(강화)");
            wearing[1] = "마스터의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷")){
            inventoryList.add("숙련자의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷(강화)");
            wearing[1] = "마스터의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷")){
            inventoryList.add("마스터의 갑옷");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷(강화)");
            wearing[1] = "마스터의 갑옷(강화)";
            System.out.println("갑옷 장착!");

        }//----------------------------------------------------------------------
        else if(wearing[1].equals("초보자의 갑옷(강화)")){
            inventoryList.add("초보자의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷(강화)");
            wearing[1] = "마스터의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("숙련자의 갑옷(강화)")){
            inventoryList.add("숙련자의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷(강화)");
            wearing[1] = "마스터의 갑옷(강화)";
            System.out.println("갑옷 장착!");
        }else if(wearing[1].equals("마스터의 갑옷(강화)")){
            inventoryList.add("마스터의 갑옷(강화)");
            user.setDefense(user.getDefense()+upgradeEquipment.upgradeArmor3.getArmorPower());
            inventoryList.remove("마스터의 갑옷(강화)");
            wearing[1] = "마스터의 갑옷(강화)";
            System.out.println("갑옷 장착!");

        }
    }
    //업그레이드 신발장착----------------------------------------------------------------------------------------------------
    void setUpgradeShoes(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[2]==null){
            wearing[2]="초보자의 신발(강화)";
            inventoryList.remove("초보자의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.UpgradeShoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("초보자의 신발")){
            inventoryList.add("초보자의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.UpgradeShoes.getAvoidUp());
            inventoryList.remove("초보자의 신발(강화)");
            wearing[2]="초보자의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발")){
            inventoryList.add("숙련자의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.UpgradeShoes.getAvoidUp());
            inventoryList.remove("초보자의 신발(강화)");
            wearing[2]="초보자의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발")){
            inventoryList.add("마스터의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.UpgradeShoes.getAvoidUp());
            inventoryList.remove("초보자의 신발(강화)");
            wearing[2]="초보자의 신발(강화)";
            System.out.println("신발 장착!");
        }
        else if(wearing[2].equals("초보자의 신발(강화)")){
            inventoryList.add("초보자의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.UpgradeShoes.getAvoidUp());
            inventoryList.remove("초보자의 신발(강화)");
            wearing[2]="초보자의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발(강화)")){
            inventoryList.add("숙련자의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.UpgradeShoes.getAvoidUp());
            inventoryList.remove("초보자의 신발(강화)");
            wearing[2]="초보자의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발(강화)")){
            inventoryList.add("마스터의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.UpgradeShoes.getAvoidUp());
            inventoryList.remove("초보자의 신발(강화)");
            wearing[2]="초보자의 신발(강화)";
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }
    void setUpgradeShoes2(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[2]==null){
            wearing[2]="숙련자의 신발(강화)";
            inventoryList.remove("숙련자의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("초보자의 신발")){
            inventoryList.add("초보자의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발(강화)");
            wearing[2]="숙련자의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발")){
            inventoryList.add("숙련자의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발(강화)");
            wearing[2]="숙련자의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발")){
            inventoryList.add("마스터의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발(강화)");
            wearing[2]="숙련자의 신발(강화)";
            System.out.println("신발 장착!");
        }
        else if(wearing[2].equals("초보자의 신발(강화)")){
            inventoryList.add("초보자의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발(강화)");
            wearing[2]="숙련자의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발(강화)")){
            inventoryList.add("숙련자의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발(강화)");
            wearing[2]="숙련자의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발(강화)")){
            inventoryList.add("마스터의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes2.getAvoidUp());
            inventoryList.remove("숙련자의 신발(강화)");
            wearing[2]="숙련자의 신발(강화)";
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }
    void setUpgradeShoes3(User user,Store store,Inventory inventory,upgradeEquipment upgradeEquipment){
        if(wearing[2]==null){
            wearing[2]="마스터의 신발(강화)";
            inventoryList.remove("마스터의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("초보자의 신발")){
            inventoryList.add("초보자의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발(강화)");
            wearing[2]="마스터의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발")){
            inventoryList.add("숙련자의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발(강화)");
            wearing[2]="마스터의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발")){
            inventoryList.add("마스터의 신발");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발(강화)");
            wearing[2]="마스터의 신발(강화)";
            System.out.println("신발 장착!");
        }
        else if(wearing[2].equals("초보자의 신발(강화)")){
            inventoryList.add("초보자의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발(강화)");
            wearing[2]="마스터의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("숙련자의 신발(강화)")){
            inventoryList.add("숙련자의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발(강화)");
            wearing[2]="마스터의 신발(강화)";
            System.out.println("신발 장착!");
        }else if(wearing[2].equals("마스터의 신발(강화)")){
            inventoryList.add("마스터의 신발(강화)");
            user.setAvoid(user.getAvoid() +upgradeEquipment.upgradeShoes3.getAvoidUp());
            inventoryList.remove("마스터의 신발(강화)");
            wearing[2]="마스터의 신발(강화)";
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }



// 물약 먹음 --------------------------------------------------------------------------------------
    void setHpPotion(User user,Store store,Inventory inventory){ //물약먹음
    //총 hp < 현재hp +포션량

    //if문추가 - 총hp>포션먹은hp == 총hp
    if(user.realHp+store.hpPotion.getRecoveryAmount()>user.getHp()){
        user.realHp=user.getHp();
    }
    user.setRealHp(user.getRealHp()+store.hpPotion.getRecoveryAmount());
    inventoryList.remove("hpPotion50");
    System.out.println("체력회복완료!");
}
    void setMpPotion(User user,Store store,Inventory inventory){ //
        if(user.getMp()<user.realMp+store.mpPotion.getRecoveryAmount()){
            user.setRealMp(user.getMp());
        }
        user.setRealMp(user.getRealMp()+store.mpPotion.getRecoveryAmount());
        inventoryList.remove("mpPotion50");
        System.out.println("마나회복완료!");
    }
    //---------------------------------------------------------------------------------------------
    void setHpPotion100(User user,Store store,Inventory inventory){ //물약먹음
        //총 hp < 현재hp +포션량
      /*  if(user.getHp()<user.realHp+store.hpPotion.getRecoveryAmount()){
            user.setRealHp(user.getHp());
        }*/
        //if문추가 - 총hp>포션먹은hp == 총hp
        if(user.realHp+store.hpPotion2.getRecoveryAmount()>user.getHp()){
            user.realHp=user.getHp();
        }
        user.setRealHp(user.getRealHp()+store.hpPotion2.getRecoveryAmount());
        inventoryList.remove("hpPotion100");
        System.out.println("체력회복완료!");
    }
    void setMpPotion100(User user,Store store,Inventory inventory){ //
        if(user.getMp()<user.realMp+store.mpPotion2.getRecoveryAmount()){
            user.setRealMp(user.getMp());
        }
        user.setRealMp(user.getRealMp()+store.mpPotion2.getRecoveryAmount());
        inventoryList.remove("mpPotion100");
        System.out.println("마나회복완료!");
    }
    //---------------------------------------------------------------------------------------------
    void setHpPotion200(User user,Store store,Inventory inventory){ //물약먹음
        //총 hp < 현재hp +포션량
      /*  if(user.getHp()<user.realHp+store.hpPotion.getRecoveryAmount()){
            user.setRealHp(user.getHp());
        }*/
        //if문추가 - 총hp>포션먹은hp == 총hp
        if(user.realHp+store.hpPotion3.getRecoveryAmount()>user.getHp()){
            user.realHp=user.getHp();
        }
        user.setRealHp(user.getRealHp()+store.hpPotion3.getRecoveryAmount());
        inventoryList.remove("hpPotion200");
        System.out.println("체력회복완료!");
    }
    void setMpPotion200(User user,Store store,Inventory inventory){ //
        if(user.getMp()<user.realMp+store.mpPotion3.getRecoveryAmount()){
            user.setRealMp(user.getMp());
        }
        user.setRealMp(user.getRealMp()+store.mpPotion3.getRecoveryAmount());
        inventoryList.remove("mpPotion200");
        System.out.println("마나회복완료!");
    }
    //---------------------------------------------------------------------------------------------
    //팔기메서드 완료
    //인벤토리에 있는 항목삭제, setCash로 반환
    void sell(Inventory inventory,User user){

        System.out.println("---------------------------------------------------------------------");
        for (int i = 0; i < inventoryList.size(); i++) {
            System.out.println(i + ":" + inventoryList.get(i) + "    ");
        }
        System.out.println("보유금화   :   " + getCash());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("  판매할 물건을 정확히 입력하시오     (나가기:0)");
        이름 = sc.nextLine();

        if (이름.equals("hpPotion50")) {
            inventoryList.remove("hpPotion50");
            setCash(getCash()+50);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        } else if (이름.equals("mpPotion50")) {
            inventoryList.remove("mpPotion50");
            setCash(getCash()+50);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        } else if (이름.equals("hpPotion100")) {
            inventoryList.remove("hpPotion100");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("mpPotion100")) {
            inventoryList.remove("mpPotion100");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("hpPotion200")) {
            inventoryList.remove("hpPotion200");
            setCash(getCash()+200);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("mpPotion200")) {
            inventoryList.remove("mpPotion200");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }
        else if (이름.equals("초보자의 검")) {
            inventoryList.remove("초보자의 검");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }
        else if (이름.equals("초보자의 갑옷")) {
            inventoryList.remove("초보자의 갑옷");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }
        else if (이름.equals("초보자의 신발")) {
            inventoryList.remove("초보자의 신발");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }  else if (이름.equals("숙련자의검")) {
            inventoryList.remove("숙련자의검");
            setCash(getCash()+500);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }  else if (이름.equals("숙련자의 갑옷")) {
            inventoryList.remove("초보자의 신발");
            setCash(getCash()+500);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }  else if (이름.equals("숙련자의 신발")) {
            inventoryList.remove("숙련자의 신발");
            setCash(getCash()+500);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("마스터의 검")) {
            inventoryList.remove("마스터의 검");
            setCash(getCash()+1000);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("마스터의 갑옷")) {
            inventoryList.remove("마스터의 갑옷");
            setCash(getCash()+1000);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("마스터의 신발")) {
            inventoryList.remove("마스터의 신발");
            setCash(getCash()+1000);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("리자몽의 꼬리")) {
            inventoryList.remove("리자몽의 꼬리");
            setCash(getCash()+500);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }
        else if (이름.equals("거북왕의 등딱지")) {
            inventoryList.remove("거북왕의 등딱지");
            setCash(getCash()+500);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("이상해꽃의 꽃")) {
            inventoryList.remove("이상해꽃의 꽃");
            setCash(getCash()+500);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("이상해풀의 풀입")) {
            inventoryList.remove("이상해풀의 풀입");
            setCash(getCash()+300);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("어니부기의 등딱지")) {
            inventoryList.remove("어니부기의 등딱지");
            setCash(getCash()+300);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("리자드의 꼬리")) {
            inventoryList.remove("리자드의 꼬리");
            setCash(getCash()+300);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("이상해씨의 씨앗")) {
            inventoryList.remove("이상해씨의 씨앗");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("꼬북이의 등딱지")) {
            inventoryList.remove("꼬북이의 등딱지");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else if (이름.equals("파이리의 꼬리")) {
            inventoryList.remove("파이리의 꼬리");
            setCash(getCash()+100);
            System.out.println("판매완료.  ");
            System.out.println("보유금화   :   " + getCash());
        }else {
            System.out.println("정확하게 입력하지 않았거나, 소지하고 있지않습니다.");
        }
    }
}


/*else if(wearing[0].equals(upgradeEquipment.upgradeSoad.getName())){
            inventory.inventoryList.remove(store.soad.getName());
            System.out.println("검 장착");
            user.setAttack(user.getAttack()+ upgradeEquipment.upgradeSoad.getAttackPower());
            wearing[0]=upgradeEquipment.upgradeSoad.getName();
            inventoryList.add(equals(upgradeEquipment.upgradeSoad.getName()));
        }*/