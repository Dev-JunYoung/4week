import java.util.ArrayList;
import java.util.Scanner;

public class Store { //buy() 장비각각 3종류식 총9개, 포션종류2가지,
                     //sell() 아이템구분없이
  Potion hpPotion=new Potion("hpPotion50",50,50,1);
    Potion mpPotion=new Potion("mpPotion50",50,50,2);
  Potion hpPotion2=new Potion("hpPotion100",100,100,1);
  Potion mpPotion2=new Potion("mpPotion100",100,100,2);
  Potion hpPotion3=new Potion("hpPotion200",200,200,1);
  Potion mpPotion3=new Potion("mpPotion200",200,200,2);
  soad soad=new soad("초보자의 검",100,1,10,0);
  Armor armor=new Armor("초보자의 갑옷",100,1,10);
  Shoes shoes=new Shoes("초보자의 신발",100,1,10);
  soad soad2=new soad("숙련자의 검",500,2,20,0);
  Armor armor2=new Armor("숙련자의 갑옷",500,2,20);
  Shoes shoes2=new Shoes("숙련자의 신발",500,2,20);
  soad soad3=new soad("마스터의 검",1000,3,50,0);
  Armor armor3=new Armor("마스터의 갑옷",1000,3,50);
  Shoes shoes3=new Shoes("마스터의 신발",1000,3,50);

  soad upgradeSoad=new soad("강화된 초보자의 검",300,4,20,1);
  Armor upgradeArmor=new Armor("강화된 초보자의 갑옷",300,4,20);
  Shoes upgradeShoes=new Shoes("강화된 초보자의 신발",300,4,20);
  soad upgradeSoad2=new soad("강화된 숙련자의 검",1000,5,40,1);
  Armor upgradeArmor2=new Armor("강화된 숙련자의 갑옷",1000,5,40);
  Shoes upgradeShoes2=new Shoes("강화된 숙련자의 신발",1000,5,40);
  soad upgradeSoad3=new soad("강화된 마스터의 검",1500,6,100,1);
  Armor upgradeArmor3=new Armor("강화된 마스터의 갑옷",1500,6,100);
  Shoes upgradeShoes3=new Shoes("강화된 마스터의 신발",1500,6,100);
  ArrayList StoreList=new ArrayList();
  Scanner sc=new Scanner(System.in);
  int 뎁스1num;
  int 뎁스2num;
  void store(Inventory inventory,Store store){
    while (true){
      System.out.println("----------------------------------------------------------------------------------------------------------------------");
      System.out.println("1.구매하기  ㅣ  2.판매하기  ㅣ  3.돌아가기  ㅣ  ");
      System.out.println("----------------------------------------------------------------------------------------------------------------------");
      뎁스1num=project.예외();
      switch (뎁스1num){
        case 1:  //구매
          while(true){
            store.storeView(); //뷰보여줌
            System.out.println(inventory.haveList());
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("구매하실 번호를 눌러주세요.    ㅣ   돌아가기:0");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("보유금화:  "+inventory.getCash());
            뎁스2num=project.예외();
            switch (뎁스2num){
              case 0:
                break;
              case 1:store.buyHpPotion(inventory);
                break;
              case 2:store.buyMpPotion(inventory);
                break;
              case 3:store.buyHpPotion2(inventory);
                break;
              case 4:store.buyMpPotion2(inventory);
                break;
              case 5:store.buyHpPotion3(inventory);
                break;
              case 6:store.buyMpPotion3(inventory);
                break;
              case 7:store.buySoad(inventory);
                break;
              case 8:store.buyArmor(inventory);
                break;
              case 9:store.buyShoes(inventory);
                break;
              case 10:store.buySoad2(inventory);
                break;
              case 11:store.buyArmor2(inventory);
                break;
              case 12:store.buyShoes2(inventory);
                break;
              case 13:store.buySoad3(inventory);
                break;
              case 14:store.buyArmor3(inventory);
                break;
              case 15:store.buyShoes3(inventory);
                break;
            }
            if(뎁스2num==0){
              break;
            }
          }
          break;
        case 2: //판매
          sell(inventory,store);

          break;
        case 3: //돌아가기
          break;
      }
      break;
    }
  }
  int sell(Inventory inventory, Store store)throws IndexOutOfBoundsException{
  int num=0;
    for(int i=0; i<inventory.list.size();i++){
      System.out.println((i+1)+" : "+inventory.list.get(i).name);
    }
    System.out.println("돌아가기 : (0)");
    try {
      num=project.예외();
      if(num==0){
        return 0;
      }else if(inventory.list.isEmpty()){
        return 0;
      }
      //아이템 선택
      Item chooseItem=inventory.list.get(num-1);
      inventory.list.remove(num-1);
      chooseItem.sell(inventory);
    }catch (IndexOutOfBoundsException ido){
      System.out.println("입력하신 번호에 아이템이 없습니다.");
      return 0;
    }
    System.out.println(ConsoleColors.FONT_YELLOW+"현재 금화 : "+inventory.getCash()+ConsoleColors.RESET);
    return 0;
  }

  void buyHpPotion(Inventory inventory){
    if(inventory.getCash()<hpPotion.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(hpPotion);
      inventory.setCash(inventory.getCash()- hpPotion.getPrice());
      System.out.println(hpPotion.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }

  }
  void buyHpPotion2(Inventory inventory){
    if(inventory.getCash()<hpPotion2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(hpPotion2);
      inventory.setCash(inventory.getCash()-hpPotion2.getPrice());
      System.out.println(hpPotion2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyHpPotion3(Inventory inventory){
    if(inventory.getCash()<hpPotion3.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(hpPotion3);
      inventory.setCash(inventory.getCash()-hpPotion3.getPrice());
      System.out.println(hpPotion3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyMpPotion(Inventory inventory){
    if(inventory.getCash()<mpPotion.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(mpPotion);
      inventory.setCash(inventory.getCash()-mpPotion.getPrice());
      System.out.println(mpPotion.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyMpPotion2(Inventory inventory){
    if(inventory.getCash()<mpPotion2.getPrice()){
      System.out.println("구매할수없습니다 .");
    } else{
      inventory.list.add(mpPotion2);
      inventory.setCash(inventory.getCash()-mpPotion2.getPrice());
      System.out.println(mpPotion2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }

  }
  void buyMpPotion3(Inventory inventory){
    if(inventory.getCash()<mpPotion3.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(mpPotion3);
      inventory.setCash(inventory.getCash()-mpPotion3.getPrice());
      System.out.println(mpPotion3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buySoad(Inventory inventory){
    if(inventory.getCash()<soad.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(this.soad);
      inventory.setCash(inventory.getCash()-soad.getPrice());
      System.out.println(soad.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buySoad2(Inventory inventory){
    if(inventory.getCash()<soad.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(soad2);
      inventory.setCash(inventory.getCash()-soad2.getPrice());
      System.out.println(soad2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
      System.out.println(this.soad2+"   상점구매한검2 ");
    }
  }
  void buySoad3(Inventory inventory){
    if(inventory.getCash()<soad3.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(soad3);
      inventory.setCash(inventory.getCash()-soad3.getPrice());
      System.out.println(soad3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
      System.out.println(this.soad3+"    상점구매한검2 ");
    }
  }
  void buyArmor(Inventory inventory){
    if(inventory.getCash()<armor.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(armor);
      inventory.setCash(inventory.getCash()-armor.getPrice());
      System.out.println(armor.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyArmor2(Inventory inventory){
    if(inventory.getCash()<armor2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(armor2);
      inventory.setCash(inventory.getCash()-armor2.getPrice());
      System.out.println(armor2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyArmor3(Inventory inventory){
    if(inventory.getCash()<armor3.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(armor3);
      inventory.setCash(inventory.getCash()-armor3.getPrice());
      System.out.println(armor3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyShoes(Inventory inventory){
    if(inventory.getCash()<shoes.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(shoes);
      inventory.setCash(inventory.getCash()-shoes.getPrice());
      System.out.println(shoes.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyShoes2(Inventory inventory){
    if(inventory.getCash()<shoes2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(shoes2);
      inventory.setCash(inventory.getCash()-shoes2.getPrice());
      System.out.println(shoes2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyShoes3(Inventory inventory){
    if(inventory.getCash()<shoes2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.list.add(shoes3);
      inventory.setCash(inventory.getCash()-shoes3.getPrice());
      System.out.println(shoes3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }

  void storeInit(){
    StoreList.add("         이름       가격       회복량");
    StoreList.add("1. "+hpPotion.getName()+" :     "+ hpPotion.price+"       "+hpPotion.recoveryAmount);
    StoreList.add("2. "+mpPotion.getName()+" :     "+ mpPotion.price+"       "+hpPotion.recoveryAmount);
    StoreList.add("3. "+hpPotion2.getName()+":     "+ hpPotion2.price+"      "+hpPotion2.recoveryAmount);
    StoreList.add("4. "+mpPotion2.getName()+" :    "+ mpPotion2.price+"      "+hpPotion2.recoveryAmount);
    StoreList.add("5. "+hpPotion3.getName()+" :    "+ hpPotion3.price+"      "+hpPotion3.recoveryAmount);
    StoreList.add("6. "+hpPotion3.getName()+" :    "+ mpPotion3.price+"     "+hpPotion3.recoveryAmount);
    StoreList.add("-------------------------------------------------------------------------------------------------");
    StoreList.add("7. "+soad.getName()+" :"+soad.getPrice()+"     ㅣ   공격력증가 :  "+soad.getAttackPower());
    StoreList.add("8. "+armor.getName()+" :"+armor.getPrice()+"   ㅣ   방어력증가 :  "+armor.getArmorPower());
    StoreList.add("9. "+shoes.getName()+" :"+shoes.getPrice()+"   ㅣ   명중률증가 :  "+shoes.getAvoidUp());
    StoreList.add("-------------------------------------------------------------------------------------------------");
    StoreList.add("10. "+soad2.getName()+" :"+soad2.getPrice()+"  ㅣ   공격력증가 :  "+soad2.getAttackPower());
    StoreList.add("11. "+armor2.getName()+" :"+armor2.getPrice()+"ㅣ   방어력증가 : "+armor2.getArmorPower());
    StoreList.add("12. "+shoes2.getName()+" :"+shoes2.getPrice()+"ㅣ   명중률증가 : "+shoes2.getAvoidUp());
    StoreList.add("-------------------------------------------------------------------------------------------------");
    StoreList.add("13. "+soad3.getName()+" :"+soad3.getPrice()+"  ㅣ   공격력증가 :  "+soad3.getAttackPower());
    StoreList.add("14. "+armor3.getName()+" :"+armor3.getPrice()+"ㅣ   방어력증가 :  "+armor3.getArmorPower());
    StoreList.add("15. "+shoes3.getName()+" :"+shoes3.getPrice()+"ㅣ   명중률증가 :  "+shoes3.getAvoidUp());
  }
  void storeView(){
    System.out.println("---------------------------------------------------------------------");
    for(int i=0;i< StoreList.size();i++) {
      System.out.println(StoreList.get(i)+"    ");
    }
    System.out.println("---------------------------------------------------------------------");
  }

}
