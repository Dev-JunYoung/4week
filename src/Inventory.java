import java.util.ArrayList;
import java.util.Scanner;
public class Inventory {
    Scanner sc=new Scanner(System.in);
    int num;
    int cash;
    String 이름;
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
    void chooseItem(User user,Store store,Inventory inventory) {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.장비 및 포션  ㅣ  2.기타  ㅣ  3.돌아가기  ㅣ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        num=project.예외();
        if(num==1){
            listView(user,inventory,store);
        }else if(num==2){
            inventoryView();
        }else {
            return;
        }
    }
    //착용장비배열
   Equipments[] wearing=new Equipments[3];
   ArrayList<Item> list=new ArrayList<>();
    String soadWearing(Store store){
        String str="";
        if(this.wearing[0]==null){
        }else {
            if(wearing[0].getName()==store.soad.getName()){
                str="+"+Integer.toString(store.soad.getAttackPower());
            }
            if(wearing[0].getName()==store.soad2.getName()){
                str="+"+Integer.toString(store.soad2.getAttackPower());
            }
            if(wearing[0].getName()==store.soad3.getName()){
                str="+"+Integer.toString(store.soad3.getAttackPower());
            }
            if(wearing[0].getName()==store.upgradeSoad.getName()){
                str="+"+Integer.toString(store.upgradeSoad.getAttackPower());
            }
            if(wearing[0].getName()==store.upgradeSoad2.getName()){
                str="+"+Integer.toString(store.upgradeSoad2.getAttackPower());
            }
            if(wearing[0].getName()==store.upgradeSoad3.getName()){
                str="+"+Integer.toString(store.upgradeSoad3.getAttackPower());
            }
            return str;
        }
        return "";
    }
    String shoesWearing(Store store){
        String str="";
        if(this.wearing[2]==null){
        }else {
            if(wearing[2].getName()==store.shoes.getName()){
                str="+"+Integer.toString(store.shoes.getAvoidUp());
            }
            if(wearing[2].getName()==store.shoes2.getName()){
                str="+"+Integer.toString(store.shoes2.getAvoidUp());
            }
            if(wearing[2].getName()==store.shoes3.getName()){
                str="+"+Integer.toString(store.shoes3.getAvoidUp());
            }
            if(wearing[2].getName()==store.upgradeShoes.getName()){
                str="+"+Integer.toString(store.upgradeShoes.getAvoidUp());
            }
            if(wearing[2].getName()==store.upgradeShoes2.getName()){
                str="+"+Integer.toString(store.upgradeShoes2.getAvoidUp());
            }
            if(wearing[2].getName()==store.upgradeShoes3.getName()){
                str="+"+Integer.toString(store.upgradeShoes3.getAvoidUp());
            }
            return str;
        }
        return "";
    }
    String armorWearing(Store store){
        String str="";
        if(this.wearing[1]==null){
        }else {
            if(wearing[1].getName()==store.armor.getName()){
                str="+"+Integer.toString(store.armor.getArmorPower());
            }
            if(wearing[1].getName()==store.armor2.getName()){
                str="+"+Integer.toString(store.armor2.getArmorPower());
            }
            if(wearing[1].getName()==store.armor3.getName()){
                str="+"+Integer.toString(store.armor3.getArmorPower());
            }
            if(wearing[1].getName()==store.upgradeArmor.getName()){
                str="+"+Integer.toString(store.upgradeArmor.getArmorPower());
            }
            if(wearing[1].getName()==store.upgradeArmor2.getName()){
                str="+"+Integer.toString(store.upgradeArmor2.getArmorPower());
            }
            if(wearing[1].getName()==store.upgradeArmor3.getName()){
                str="+"+Integer.toString(store.upgradeArmor3.getArmorPower());
            }
            return str;
        }
        return "";
    }
    //인벤토리목록
    void inventoryView(){
            int j=inventoryList.size();
            System.out.println("---------------------------------------------------------------------");
            for (int i = 0; i < inventoryList.size(); i++) {
                System.out.println((i+1) + ":" + inventoryList.get(i) + "    ");
            }
            System.out.println("보유금화   :   " + getCash());
            System.out.println("---------------------------------------------------------------------");
            System.out.println("나가기 : Enter");
        sc.nextLine();
        sc.nextLine();


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
    void wearing(){
        System.out.println("----------------------------------------------------------------------------------");
                for(int i=0;i<wearing.length;i++){
                    if(wearing[i]==null){
                        System.out.println("null");
                    }else {
                        System.out.println("착용장비 : " + wearing[i].getName() + "  ");
                    }
                }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ    1.돌아가기    ㅣ    ");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        num= project.예외();
        if(num==1){
        }
    }
    void setSoad(soad soad,User user,Store store){
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            list.remove(soad);
            wearing[0] = soad;
        } else if (wearing[0].equals(soad.getName())) { //있으면 삭제하고장착 1
        }else if (wearing[0].getName()=="숙련자의 검") { //있으면 삭제하고장착 2
            list.remove(soad);
            list.add(wearing[0]);
            wearing[0] = soad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack()-store.soad2.getAttackPower());
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
        } else if (wearing[0].getName()=="마스터의 검") { //있으면 삭제하고장착 3
            list.remove(soad);
            list.add(wearing[0]);
            wearing[0] = soad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack()-store.soad3.getAttackPower());
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
        }else if (wearing[0].getName()=="강화된 초보자의 검") { //있으면 삭제하고장착 1
            list.remove(soad);
            list.add(wearing[0]);
            wearing[0] = soad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad.getAttackPower());
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
            //-------완료  이게 로직에 맞는거임
        }else if (wearing[0].getName()=="강화된 숙련자의 검") { //있으면 삭제하고장착 1
            list.remove(soad);
            list.add(wearing[0]);
            wearing[0] = soad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad2.getAttackPower());
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
        } else if (wearing[0].getName()=="강화된 마스터의 검") { //있으면 삭제하고장착 2
            list.remove(soad);
            list.add(wearing[0]);
            wearing[0] = soad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad3.getAttackPower());
            user.setAttack(user.getAttack() + store.soad.getAttackPower());
        }
    }    
    void setSoad2(soad soad2,User user,Store store) {
        if (wearing[0] == null) {  //비어있으면 바로 장착
            list.remove(soad2);            
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] =soad2;
        } else if (wearing[0].getName()=="초보자의 검") { //있으면 삭제하고장착 1
            list.remove(soad2); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =soad2;//wearing 배열에 추가
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad.getAttackPower());
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
        } else if (wearing[0].equals("숙련자의 검")) { //있으면 삭제하고장착 2
        } else if (wearing[0].getName()=="마스터의 검") { //있으면 삭제하고장착 3
            list.remove(soad2);
            list.add(wearing[0]);
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad3.getAttackPower());
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            wearing[0] =soad2;
            //--------------------------------------------------------------------------------
        }else if (wearing[0].getName()=="강화된 초보자의 검") { //있으면 삭제하고장착 1
            list.remove(soad2);
            list.add(wearing[0]);
            wearing[0] =soad2;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad.getAttackPower());
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
            //-------완료  이게 로직에 맞는거임
        }else if (wearing[0].getName()=="강화된 숙련자의 검") { //있으면 삭제하고장착 1
            list.remove(soad2);
            list.add(wearing[0]);
            wearing[0] = soad2;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad2.getAttackPower());
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
        } else if (wearing[0].getName()=="강화된 마스터의 검") { //있으면 삭제하고장착 2
            list.remove(soad2);
            list.add(wearing[0]);
            wearing[0] = soad2;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad3.getAttackPower());
            user.setAttack(user.getAttack() + store.soad2.getAttackPower());
        }
    }
    void setSoad3(soad soad3, User user, Store store) {
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            list.remove(soad3);
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            wearing[0] =  soad3;
        }
        else if (wearing[0].getName()=="초보자의 검") { //있으면 삭제하고장착 1
            list.remove(soad3); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =  soad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad.getAttackPower());
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].getName()=="숙련자의 검") { //있으면 삭제하고장착 2
            list.remove(soad3);
            list.add(wearing[0]);
            wearing[0] =  soad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
        } else if (wearing[0].equals("마스터의 검")) { //있으면 삭제하고장착 3
        }else if (wearing[0].getName()=="강화된 초보자의 검") { //있으면 삭제하고장착 1
            list.remove(soad3); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =  soad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad.getAttackPower());
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());

        }else if (wearing[0].getName()=="강화된 숙련자의 검") { //있으면 삭제하고장착 1
            list.remove(soad3); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =  soad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad2.getAttackPower());
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
        } else if (wearing[0].getName()=="강화된 마스터의 검") { //있으면 삭제하고장착 2
            list.remove(soad3); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =  soad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad3.getAttackPower());
            user.setAttack(user.getAttack() + store.soad3.getAttackPower());
        }
    }

    //--------------------------------------------------------------------------------------------
    void setArmor(Armor armor,User user,Store store){
        if(wearing[1]==null){
            wearing[1]=armor;
            list.remove(armor);
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="초보자의 갑옷"){
        }else if(wearing[1].getName()=="숙련자의 갑옷"){
            list.remove(armor);
            list.add(wearing[1]);
            wearing[1] =armor;
            user.setDefense(user.getDefense()-store.armor2.getArmorPower());
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="마스터의 갑옷"){
            list.remove(armor);
            list.add(wearing[1]);
            wearing[1] =armor;
            user.setDefense(user.getDefense()-store.armor3.getArmorPower());
            user.setAttack(user.getAttack() + store.armor.getArmorPower());
            System.out.println("갑옷 장착!");
        }//----------------------------------------------------------------------
        else if(wearing[1].getName()=="강화된 초보자의 갑옷"){
            list.remove(armor);
            list.add(wearing[1]);
            wearing[1] =armor;
            user.setDefense(user.getDefense()-store.upgradeArmor.getArmorPower());
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 숙련자의 갑옷"){
            list.remove(armor);
            list.add(wearing[1]);
            wearing[1] =armor;
            user.setDefense(user.getDefense()-store.upgradeArmor2.getArmorPower());
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 마스터의 갑옷"){
            list.remove(armor);
            list.add(wearing[1]);
            wearing[1] =armor;
            user.setDefense(user.getDefense()-store.upgradeArmor3.getArmorPower());
            user.setDefense(user.getDefense()+store.armor.getArmorPower());
            System.out.println("갑옷 장착!");
        }
    }
    void setArmor2(Armor armor2, User user, Store store){
        if(wearing[1]==null){
            wearing[1]=armor2;
            list.remove(armor2);
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="초보자의 갑옷"){
            list.remove(armor2);
            list.add(wearing[1]);
            wearing[1] =armor2;
            user.setDefense(user.getDefense()-store.armor.getArmorPower());
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="숙련자의 갑옷"){
        }else if(wearing[1].getName()=="마스터의 갑옷"){
            list.remove(armor2);
            list.add(wearing[1]);
            wearing[1] =armor2;
            user.setDefense(user.getDefense()-store.armor3.getArmorPower());
            user.setAttack(user.getAttack() + store.armor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }//----------------------------------------------------------------------
        else if(wearing[1].getName()=="강화된 초보자의 갑옷"){
            list.remove(armor2);
            list.add(wearing[1]);
            wearing[1] =armor2;
            user.setDefense(user.getDefense()-store.upgradeArmor.getArmorPower());
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 숙련자의 갑옷"){
            list.remove(armor2);
            list.add(wearing[1]);
            wearing[1] =armor2;
            user.setDefense(user.getDefense()-store.upgradeArmor2.getArmorPower());
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 마스터의 갑옷"){
            list.remove(armor2);
            list.add(wearing[1]);
            wearing[1] =armor2;
            user.setDefense(user.getDefense()-store.upgradeArmor3.getArmorPower());
            user.setDefense(user.getDefense()+store.armor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }
    }
    void setArmor3(Armor armor3, User user, Store store){
        if(wearing[1]==null){
            wearing[1]=armor3;
            list.remove(armor3);
            user.setDefense(user.getDefense()+store.armor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="초보자의 갑옷"){
            list.remove(armor3);
            list.add(wearing[1]);
            wearing[1] =armor3;
            user.setDefense(user.getDefense()-store.armor.getArmorPower());
            user.setDefense(user.getDefense()+store.armor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="숙련자의 갑옷"){
            list.remove(armor3);
            list.add(wearing[1]);
            wearing[1] =armor3;
            user.setDefense(user.getDefense()-store.armor2.getArmorPower());
            user.setAttack(user.getAttack() + store.armor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="마스터의 갑옷"){
        }//----------------------------------------------------------------------
        else if(wearing[1].getName()=="강화된 초보자의 갑옷"){
            list.remove(armor3);
            list.add(wearing[1]);
            wearing[1] =armor3;
            user.setDefense(user.getDefense()-store.upgradeArmor.getArmorPower());
            user.setDefense(user.getDefense()+store.armor3.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 숙련자의 갑옷"){
            list.remove(armor3);
            list.add(wearing[1]);
            wearing[1] =armor3;
            user.setDefense(user.getDefense()-store.upgradeArmor2.getArmorPower());
            user.setDefense(user.getDefense()+store.armor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 마스터의 갑옷"){
            list.remove(armor3);
            list.add(wearing[1]);
            wearing[1] =armor3;
            user.setDefense(user.getDefense()-store.upgradeArmor3.getArmorPower());
            user.setDefense(user.getDefense()+store.armor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }
    }

    //신발장착-------------------------------------------------------------------------------------------------
    void setShoes(Shoes shoes,User user,Store store){
        if(wearing[2]==null){
            wearing[2]=shoes;
            list.remove(shoes);
            user.setAvoid(user.getAvoid()+store.shoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()=="초보자의 신발"){
            list.remove(shoes);
            list.add(wearing[2]);
            wearing[2]=shoes;
            user.setAvoid(user.getAvoid() - store.shoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("숙련자의 신발")){
            list.remove(shoes);
            list.add(wearing[2]);
            wearing[2]=shoes;
            user.setAvoid(user.getAvoid() - store.shoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("마스터의 신발")){
            list.remove(shoes);
            list.add(wearing[2]);
            wearing[2]=shoes;
            user.setAvoid(user.getAvoid() - store.shoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            System.out.println("신발 장착!");
        }
        else if(wearing[2].getName()=="강화된 초보자의 신발"){
            list.remove(shoes);
            list.add(wearing[2]);
            wearing[2]=shoes;
            user.setAvoid(user.getAvoid() - store.upgradeShoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 숙련자의 신발")){
            list.remove(shoes);
            list.add(wearing[2]);
            wearing[2]=shoes;
            user.setAvoid(user.getAvoid() - store.upgradeShoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 마스터의 신발")){
            list.remove(shoes);
            list.add(wearing[2]);
            wearing[2]=shoes;
            user.setAvoid(user.getAvoid() - store.upgradeShoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes.getAvoidUp());
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }
    void setShoes2(Shoes shoes2,User user,Store store  ){
        if(wearing[2]==null){
            wearing[2]=shoes2;
            list.remove(shoes2);
            user.setAvoid(user.getAvoid()+store.shoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()=="초보자의 신발"){
            list.remove(shoes2);
            list.add(wearing[2]);
            wearing[2]=shoes2;
            user.setAvoid(user.getAvoid() - store.shoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("숙련자의 신발")){
        }else if(wearing[2].getName()==("마스터의 신발")){
            list.remove(shoes2);
            list.add(wearing[2]);
            wearing[2]=shoes2;
            user.setAvoid(user.getAvoid() - store.shoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }
        else if(wearing[2].getName()=="강화된 초보자의 신발"){
            list.remove(shoes2);
            list.add(wearing[2]);
            wearing[2]=shoes2;
            user.setAvoid(user.getAvoid() - store.upgradeShoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 숙련자의 신발")){
            list.remove(shoes2);
            list.add(wearing[2]);
            wearing[2]=shoes2;
            user.setAvoid(user.getAvoid() - store.upgradeShoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 마스터의 신발")){
            list.remove(shoes2);
            list.add(wearing[2]);
            wearing[2]=shoes2;
            user.setAvoid(user.getAvoid() - store.upgradeShoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }
    void setShoes3(Shoes shoes3,User user,Store store){
        if(wearing[2]==null){
            wearing[2]=shoes3;
            list.remove(shoes3);
            user.setAvoid(user.getAvoid()+store.shoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()=="초보자의 신발"){
            list.remove(shoes3);
            list.add(wearing[2]);
            wearing[2]=shoes3;
            user.setAvoid(user.getAvoid() - store.shoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("숙련자의 신발")){
            list.remove(shoes3);
            list.add(wearing[2]);
            wearing[2]=shoes3;
            user.setAvoid(user.getAvoid() - store.shoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("마스터의 신발")){
            list.remove(shoes3);
            list.add(wearing[2]);
            wearing[2]=shoes3;
            user.setAvoid(user.getAvoid() - store.shoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }
        else if(wearing[2].getName()=="강화된 초보자의 신발"){
            list.remove(shoes3);
            list.add(wearing[2]);
            wearing[2]=shoes3;
            user.setAvoid(user.getAvoid() - store.upgradeShoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 숙련자의 신발")){
            list.remove(shoes3);
            list.add(wearing[2]);
            wearing[2]=shoes3;
            user.setAvoid(user.getAvoid() - store.upgradeShoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 마스터의 신발")){
            list.remove(shoes3);
            list.add(wearing[2]);
            wearing[2]=shoes3;
            user.setAvoid(user.getAvoid() - store.upgradeShoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.shoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }
    //--------------------------------------------------------------------------------------------

    //업그레이드 검장착----------------------------------------------------------------------------------------------------
    void setUpgradeSoad(soad upgradeSoad,User user,Store store){
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.upgradeSoad.getAttackPower());
            list.remove(upgradeSoad);
            wearing[0] = upgradeSoad;
        }else if (wearing[0].getName()=="초보자의 검") {
            list.remove(upgradeSoad);
            list.add(wearing[0]);
            wearing[0] = upgradeSoad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack()-store.soad.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad.getAttackPower());
        } else if (wearing[0].getName()=="숙련자의 검") {
            list.remove(upgradeSoad);
            list.add(wearing[0]);
            wearing[0] = upgradeSoad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack()-store.soad2.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad.getAttackPower());
        } else if (wearing[0].getName()=="마스터의 검") { //있으면 삭제하고장착 3
            list.remove(upgradeSoad);
            list.add(wearing[0]);
            wearing[0] = upgradeSoad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack()-store.soad3.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad.getAttackPower());
        }else if (wearing[0].getName()=="강화된 초보자의 검") { //있으면 삭제하고장착 1
            list.remove(upgradeSoad);
            list.add(wearing[0]);
            wearing[0] = upgradeSoad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad.getAttackPower());
            //-------완료  이게 로직에 맞는거임
        }else if (wearing[0].getName()=="강화된 숙련자의 검") { //있으면 삭제하고장착 1
            list.remove(upgradeSoad);
            list.add(wearing[0]);
            wearing[0] = upgradeSoad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad2.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad.getAttackPower());
        } else if (wearing[0].getName()=="강화된 마스터의 검") { //있으면 삭제하고장착 2
            list.remove(upgradeSoad);
            list.add(wearing[0]);
            wearing[0] = upgradeSoad;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad3.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad.getAttackPower());
        }
    }
    void setUpgradeSoad2(soad upgradeSoad2,User user,Store store){
        if (wearing[0] == null) {  //비어있으면 바로 장착
            list.remove(upgradeSoad2);
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() + store.upgradeSoad2.getAttackPower());
            wearing[0] =upgradeSoad2;
        } else if (wearing[0].getName()=="초보자의 검") { //있으면 삭제하고장착 1
            list.remove(upgradeSoad2); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =upgradeSoad2;//wearing 배열에 추가
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad2.getAttackPower());
        } else if (wearing[0].equals("숙련자의 검")) {
            list.remove(upgradeSoad2);
            list.add(wearing[0]);
            wearing[0] =upgradeSoad2;//wearing 배열에 추가
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad2.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad2.getAttackPower());
        } else if (wearing[0].getName()=="마스터의 검") { //있으면 삭제하고장착 3
            list.remove(upgradeSoad2);
            list.add(wearing[0]);
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad3.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad2.getAttackPower());
            wearing[0] =upgradeSoad2;
            //--------------------------------------------------------------------------------
        }else if (wearing[0].getName()=="강화된 초보자의 검") { //있으면 삭제하고장착 1
            list.remove(upgradeSoad2);
            list.add(wearing[0]);
            wearing[0] =upgradeSoad2;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad2.getAttackPower());

            //-------완료  이게 로직에 맞는거임
        }else if (wearing[0].getName()=="강화된 마스터의 검") { //있으면 삭제하고장착 2
            list.remove(upgradeSoad2);
            list.add(wearing[0]);
            wearing[0] = upgradeSoad2;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad3.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad2.getAttackPower());
        }
    }
    void setUpgradeSoad3(soad upgradeSoad3,User user,Store store){
        if (wearing[0] == null) {  //비어있으면 바로 장착
            System.out.println("검 장착!");
            list.remove(upgradeSoad3);
            user.setAttack(user.getAttack() + store.upgradeSoad3.getAttackPower());
            wearing[0] =  upgradeSoad3;
        }
        else if (wearing[0].getName()=="초보자의 검") { //있으면 삭제하고장착 1
            list.remove(upgradeSoad3); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =  upgradeSoad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad3.getAttackPower());
            //-------완료  이게 로직에 맞는거임
        } else if (wearing[0].getName()=="숙련자의 검") { //있으면 삭제하고장착 2
            list.remove(upgradeSoad3);
            list.add(wearing[0]);
            wearing[0] =  upgradeSoad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad2.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad3.getAttackPower());
        } else if (wearing[0].equals("마스터의 검")) {
            list.remove(upgradeSoad3);
            list.add(wearing[0]);
            wearing[0] =  upgradeSoad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.soad3.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad3.getAttackPower());
        }else if (wearing[0].getName()=="강화된 초보자의 검") { //있으면 삭제하고장착 1
            list.remove(upgradeSoad3); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =  upgradeSoad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad3.getAttackPower());
            //-------완료  이게 로직에 맞는거임
        }else if (wearing[0].getName()=="강화된 숙련자의 검") { //있으면 삭제하고장착 1
            list.remove(upgradeSoad3); //장착할거니까 리스트에서는 지워야됌
            list.add(wearing[0]); //착용하고있었던거는 추가
            wearing[0] =  upgradeSoad3;
            System.out.println("검 장착!");
            user.setAttack(user.getAttack() - store.upgradeSoad2.getAttackPower());
            user.setAttack(user.getAttack() + store.upgradeSoad3.getAttackPower());
        }
    }

    void setUpgradeArmor(Armor upgradeArmor,User user,Store store){
        if(wearing[1]==null){
            wearing[1]=upgradeArmor;
            list.remove(upgradeArmor);
            user.setDefense(user.getDefense()+store.upgradeArmor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="초보자의 갑옷"){
            list.remove(upgradeArmor);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor;
            user.setDefense(user.getDefense()-store.armor.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="숙련자의 갑옷"){
            list.remove(upgradeArmor);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor;
            user.setDefense(user.getDefense()-store.armor2.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="마스터의 갑옷"){
            list.remove(upgradeArmor);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor;
            user.setDefense(user.getDefense()-store.armor3.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor.getArmorPower());
            System.out.println("갑옷 장착!");
        }//----------------------------------------------------------------------
        else if(wearing[1].getName()=="강화된 초보자의 갑옷"){
            list.remove(upgradeArmor);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor;
            user.setDefense(user.getDefense()-store.upgradeArmor.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 숙련자의 갑옷"){
            list.remove(upgradeArmor);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor;
            user.setDefense(user.getDefense()-store.upgradeArmor2.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 마스터의 갑옷"){
            list.remove(upgradeArmor);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor;
            user.setDefense(user.getDefense()-store.upgradeArmor3.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor.getArmorPower());
            System.out.println("갑옷 장착!");
        }
    }
    void setUpgradeArmor2(Armor upgradeArmor2,User user,Store store){
        if(wearing[1]==null){
            wearing[1]=upgradeArmor2;
            list.remove(upgradeArmor2);
            user.setDefense(user.getDefense()+store.upgradeArmor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="초보자의 갑옷"){
            list.remove(upgradeArmor2);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor2;
            user.setDefense(user.getDefense()-store.armor.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="숙련자의 갑옷"){
            list.remove(upgradeArmor2);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor2;
            user.setDefense(user.getDefense()-store.armor2.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="마스터의 갑옷"){
            list.remove(upgradeArmor2);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor2;
            user.setDefense(user.getDefense()-store.armor3.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }//----------------------------------------------------------------------
        else if(wearing[1].getName()=="강화된 초보자의 갑옷"){
            list.remove(upgradeArmor2);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor2;
            user.setDefense(user.getDefense()-store.upgradeArmor.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor2.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 숙련자의 갑옷"){
            list.remove(upgradeArmor2);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor2;
            user.setDefense(user.getDefense()-store.upgradeArmor2.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 마스터의 갑옷"){
            list.remove(upgradeArmor2);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor2;
            user.setDefense(user.getDefense()-store.upgradeArmor3.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor2.getArmorPower());
            System.out.println("갑옷 장착!");
        }
    }
    void setUpgradeArmor3(Armor upgradeArmor3,User user,Store store){
        if(wearing[1]==null){
            wearing[1]=upgradeArmor3;
            list.remove(upgradeArmor3);
            user.setDefense(user.getDefense()+store.upgradeArmor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="초보자의 갑옷"){
            list.remove(upgradeArmor3);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor3;
            user.setDefense(user.getDefense()-store.armor.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="숙련자의 갑옷"){
            list.remove(upgradeArmor3);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor3;
            user.setDefense(user.getDefense()-store.armor2.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="마스터의 갑옷"){
            list.remove(upgradeArmor3);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor3;
            user.setDefense(user.getDefense()-store.armor3.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }//----------------------------------------------------------------------
        else if(wearing[1].getName()=="강화된 초보자의 갑옷"){
            list.remove(upgradeArmor3);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor3;
            user.setDefense(user.getDefense()-store.upgradeArmor.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor3.getArmorPower());
            inventoryList.remove("초보자의 갑옷");
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 숙련자의 갑옷"){
            list.remove(upgradeArmor3);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor3;
            user.setDefense(user.getDefense()-store.upgradeArmor3.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }else if(wearing[1].getName()=="강화된 마스터의 갑옷"){
            list.remove(upgradeArmor3);
            list.add(wearing[1]);
            wearing[1] =upgradeArmor3;
            user.setDefense(user.getDefense()-store.upgradeArmor3.getArmorPower());
            user.setDefense(user.getDefense()+store.upgradeArmor3.getArmorPower());
            System.out.println("갑옷 장착!");
        }
    }

    void setUpgradeShoes(Shoes upgradeShoes,User user,Store store){
        if(wearing[2]==null){
            wearing[2]=upgradeShoes;
            list.remove(upgradeShoes);
            user.setAvoid(user.getAvoid()+store.upgradeShoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()=="초보자의 신발"){
            list.remove(upgradeShoes);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes;
            user.setAvoid(user.getAvoid() - store.shoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("숙련자의 신발")){
            list.remove(upgradeShoes);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes;
            user.setAvoid(user.getAvoid() - store.shoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("마스터의 신발")){
            list.remove(upgradeShoes);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes;
            user.setAvoid(user.getAvoid() - store.shoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes.getAvoidUp());
            System.out.println("신발 장착!");
        }
        else if(wearing[2].getName()=="강화된 초보자의 신발"){
            list.remove(upgradeShoes);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes;
            user.setAvoid(user.getAvoid() - store.upgradeShoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 숙련자의 신발")){
            list.remove(upgradeShoes);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes;
            user.setAvoid(user.getAvoid() - store.upgradeShoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 마스터의 신발")){
            list.remove(upgradeShoes);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes;
            user.setAvoid(user.getAvoid() - store.upgradeShoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes.getAvoidUp());
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }
    void setUpgradeShoes2(Shoes upgradeShoes2,User user,Store store){
        if(wearing[2]==null){
            wearing[2]=upgradeShoes2;
            list.remove(upgradeShoes2);
            user.setAvoid(user.getAvoid()+store.upgradeShoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()=="초보자의 신발"){
            list.remove(upgradeShoes2);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes2;
            user.setAvoid(user.getAvoid() - store.shoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("숙련자의 신발")){
            list.remove(upgradeShoes2);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes2;
            user.setAvoid(user.getAvoid() - store.shoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("마스터의 신발")){
            list.remove(upgradeShoes2);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes2;
            user.setAvoid(user.getAvoid() - store.shoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }
        else if(wearing[2].getName()=="강화된 초보자의 신발"){
            list.remove(upgradeShoes2);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes2;
            user.setAvoid(user.getAvoid() - store.upgradeShoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 숙련자의 신발")){
            list.remove(upgradeShoes2);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes2;
            user.setAvoid(user.getAvoid() - store.upgradeShoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 마스터의 신발")){
            list.remove(upgradeShoes2);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes2;
            user.setAvoid(user.getAvoid() - store.upgradeShoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes2.getAvoidUp());
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------

    }
    void setUpgradeShoes3(Shoes upgradeShoes3,User user,Store store){
        if(wearing[2]==null){
            wearing[2]=upgradeShoes3;
            list.remove(upgradeShoes3);
            user.setAvoid(user.getAvoid()+store.upgradeShoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()=="초보자의 신발"){
            list.remove(upgradeShoes3);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes3;
            user.setAvoid(user.getAvoid() - store.shoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("숙련자의 신발")){
            list.remove(upgradeShoes3);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes3;
            user.setAvoid(user.getAvoid() - store.shoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("마스터의 신발")){
            list.remove(upgradeShoes3);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes3;
            user.setAvoid(user.getAvoid() - store.shoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }
        else if(wearing[2].getName()=="강화된 초보자의 신발"){
            list.remove(upgradeShoes3);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes3;
            user.setAvoid(user.getAvoid() - store.upgradeShoes.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 숙련자의 신발")){
            list.remove(upgradeShoes3);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes3;
            user.setAvoid(user.getAvoid() - store.upgradeShoes2.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }else if(wearing[2].getName()==("강화된 마스터의 신발")){
            list.remove(upgradeShoes3);
            list.add(wearing[2]);
            wearing[2]=upgradeShoes3;
            user.setAvoid(user.getAvoid() - store.upgradeShoes3.getAvoidUp());
            user.setAvoid(user.getAvoid() + store.upgradeShoes3.getAvoidUp());
            System.out.println("신발 장착!");
        }
        //--------------------------------------------------------------------------------------
    }
// 물약 먹음 --------------------------------------------------------------------------------------
    void setHpPotion(Potion hpPotion,User user,Store store,Inventory inventory){ //물약먹음
        if(user.realHp+store.hpPotion.getRecoveryAmount()>user.getHp()){
            user.realHp=user.getHp();
        }
        user.setRealHp(user.getRealHp()+store.hpPotion.getRecoveryAmount());
        list.remove(hpPotion);
        System.out.println("체력회복완료!");

    }
    void setMpPotion(Potion mpPotion,User user,Store store,Inventory inventory){ //
        if(user.getMp()<user.realMp+store.mpPotion.getRecoveryAmount()){
            user.setRealMp(user.getMp());
        }
        user.setRealMp(user.getRealMp()+store.mpPotion.getRecoveryAmount());
        list.remove(mpPotion);
        System.out.println("마나50회복완료!");
    }
    //---------------------------------------------------------------------------------------------
    void setHpPotion100(Potion hpPotion2,User user,Store store,Inventory inventory){ //물약먹음
        if(user.realHp+store.hpPotion2.getRecoveryAmount()>user.getHp()){
            user.realHp=user.getHp();
        }
        user.setRealHp(user.getRealHp()+store.hpPotion2.getRecoveryAmount());
        list.remove(hpPotion2);
        System.out.println("체력100회복완료!");
    }
    void setMpPotion100(Potion mpPotion2,User user,Store store,Inventory inventory){ //
        if(user.getMp()<user.realMp+store.mpPotion2.getRecoveryAmount()){
            user.setRealMp(user.getMp());
        }
        user.setRealMp(user.getRealMp()+store.mpPotion2.getRecoveryAmount());

        list.remove(mpPotion2);
        System.out.println("마나100회복완료!");
    }
    //---------------------------------------------------------------------------------------------
    void setHpPotion200(Potion hpPotion3,User user,Store store,Inventory inventory){ //물약먹음
        if(user.realHp+store.hpPotion3.getRecoveryAmount()>user.getHp()){
            user.realHp=user.getHp();
        }
        user.setRealHp(user.getRealHp()+store.hpPotion3.getRecoveryAmount());
        list.remove(hpPotion3);
        System.out.println("체력200회복완료!");
    }
    void setMpPotion200(Potion mpPotion3, User user,Store store,Inventory inventory){ //
        if(user.getMp()<user.realMp+store.mpPotion3.getRecoveryAmount()){
            user.setRealMp(user.getMp());
        }
        user.setRealMp(user.getRealMp()+store.mpPotion3.getRecoveryAmount());
        list.remove(mpPotion3);
        System.out.println("마나200회복완료!");
    }
    //---------------------------------------------------------------------------------------------
    int hpPotionCnt(Store store){
        int cnt=0;
        for(int i=0; i<list.size();i++){
            if(list.get(i).getName()== store.hpPotion.getName()){
                cnt=cnt+1;
            }
        }
        return cnt;
    }

    int listView(User user,Inventory inventory,Store store) throws IndexOutOfBoundsException{
        for(int i=0; i<list.size();i++){
                System.out.println((i+1)+" : "+list.get(i).name);
        }
        System.out.println("돌아가기 : (0)");
        try {
            num=project.예외();
            if(num==0){
                return 0;
            }else if(list.isEmpty()){
                return 0;
            }
            //아이템 선택
            Item chooseItem=this.list.get(num-1);
            chooseItem.상호작용(user,inventory,store);
        }catch (IndexOutOfBoundsException ido){
            System.out.println("입력하신 번호에 아이템이 없습니다.");
            return 0;
        }
        //인덱스에 해당하는 아이템
        return 0;
    }
    ArrayList<String> haveList(){
        ArrayList<String> arr=new ArrayList<>();
        for(int i=0; i<list.size();i++){
            arr.add(i, list.get(i).name);
        }
        return arr;
    }
}
