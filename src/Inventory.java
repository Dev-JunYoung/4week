import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    int cash;
    Scanner sc=new Scanner(System.in);
    int num;
    String 이름;
    public int getCash() {
        return cash;
    }
    public void setCash(int cash) {
        this.cash = cash;
    }
    /*Potion hpPotion=new Potion("물약(hp증가50)",50,50,1);
    Potion mpPotion=new Potion("물약(mp증가50)",50,50,2);
    soad soad=new soad("초보자의검",0,1,10);
    Armor armor=new Armor("초보자의갑옷",0,1,10);
    Shoes shoes=new Shoes("초보자의신발",0,1,10);*/
    ArrayList inventoryList=new ArrayList();
   /*void inventoryInitInsert(){
       System.out.println("이닛인벤토리");
        setCash(100);
        inventoryList.add("보유금화 :" +this.getCash());
    }*/
    //인벤토리목록
   String[] wearing=new String[3];
    void inventoryView(User user,Store store,Inventory inventory){
        while(true) {
            System.out.println("---------------------------------------------------------------------");
            for (int i = 0; i < inventoryList.size(); i++) {
                System.out.println(i + ":" + inventoryList.get(i) + "    ");
            }
            System.out.println("보유금화   :   " + getCash());
            System.out.println("---------------------------------------------------------------------");
            System.out.println("입력하시오 ");
            이름 = sc.nextLine();
            if (이름.equals("hpPotion50")) {
                setHpPotion(user, store, inventory);
            } else if (이름.equals("mpPotion50")) {
                setMpPotion(user, store, inventory);
            } else if (이름.equals("초보자의 검")) {
                setSoad(user, store, inventory);
            } else if (이름.equals("초보자의 갑옷")) {
                setArmor(user, store, inventory);
            } else if (이름.equals("초보자의 신발")) {
                setShoes(user, store, inventory);
            } else {
                System.out.println("입력하신 아이템은 없습니다.");
            }
            if(num==0){
                break;
            }
        }
    }
    //착용장비

    void wearing(User user,Inventory inventory){
        System.out.println("----------------------------------------------------------------------------------");
                for(int i=0;i<wearing.length;i++){
                    System.out.println("착용장비 : "+wearing[i]+"  ");
                }
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("넘어가기(enter)");
                sc.nextLine();
    }
    //장착
    User setSoad(User user,Store store,Inventory inventory){
                wearing[0]="초보자의 검";
                inventoryList.remove("초보자의 검");
                user.setAttack(user.getAttack()+store.soad.getAttackPower());
        return user;
    }
    void setArmor(User user,Store store,Inventory inventory){
        wearing[1]="초보자의 갑옷";
        inventoryList.remove("초보자의 갑옷");
        user.setDefense(user.getDefense()+store.armor.getArmorPower());
    }

    void setShoes(User user,Store store,Inventory inventory){
        wearing[2]="초보자의 신발";
        user.setAvoid(user.getAvoid()+store.shoes.getAvoidUp());
        inventoryList.remove("초보자의 신발");
    }


    void setHpPotion(User user,Store store,Inventory inventory){ //물약먹음
       //총 hp < 현재hp +포션량
      /*  if(user.getHp()<user.realHp+store.hpPotion.getRecoveryAmount()){
            user.setRealHp(user.getHp());
        }*/
        //if문추가 - 총hp>포션먹은hp == 총hp
        if(user.realHp+store.hpPotion.getRecoveryAmount()>user.getHp()){
            user.realHp=user.getHp();
        }
       user.setRealHp(user.getRealHp()+store.hpPotion.getRecoveryAmount());
        inventoryList.remove("hpPotion50");
    }
    void setMpPotion(User user,Store store,Inventory inventory){ //
        if(user.getMp()<user.realMp+store.mpPotion.getRecoveryAmount()){
            user.setRealMp(user.getMp());
        }
        user.setRealMp(user.getRealMp()+store.mpPotion.getRecoveryAmount());
        inventoryList.remove("mpPotion50");
    }

    

}
