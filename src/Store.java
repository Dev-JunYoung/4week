import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Store { //buy() 장비각각 3종류식 총9개, 포션종류2가지,
                     //sell() 아이템구분없이
  Potion hpPotion=new Potion("hpPotion50",50,50,1);
    Potion mpPotion=new Potion("mpPotion50",50,50,2);
  Potion hpPotion2=new Potion("hpPotion100",100,50,1);
  Potion mpPotion2=new Potion("mpPotion100",100,50,2);
  Potion hpPotion3=new Potion("hpPotion200",200,50,1);
  Potion mpPotion3=new Potion("mpPotion200",200,50,2);
  soad soad=new soad("초보자의 검",100,1,10);
  Armor armor=new Armor("초보자의 갑옷",100,1,10);
  Shoes shoes=new Shoes("초보자의 신발",100,1,10);
  soad soad2=new soad("숙련자의검",500,2,20);
  Armor armor2=new Armor("숙련자의 갑옷",500,2,20);
  Shoes shoes2=new Shoes("숙련자의 신발",500,2,20);
  soad soad3=new soad("마스터의 검",1000,3,50);
  Armor armor3=new Armor("마스터의 갑옷",1000,3,50);
  Shoes shoes3=new Shoes("마스터의 신발",1000,3,50);
  ArrayList StoreList=new ArrayList();
  void storeInit(){
    StoreList.add("         이름       가격       회복량");
    StoreList.add("1. "+hpPotion.getName()+" :     "+ hpPotion.price+"       "+hpPotion.recoveryAmount);
    StoreList.add("2. "+mpPotion.getName()+" :     "+ mpPotion.price+"       "+hpPotion.recoveryAmount);
    StoreList.add("3. "+hpPotion2.getName()+":     "+ hpPotion2.price+"      "+hpPotion2.recoveryAmount);
    StoreList.add("4. "+mpPotion2.getName()+" :    "+ mpPotion2.price+"      "+hpPotion2.recoveryAmount);
    StoreList.add("5. "+hpPotion3.getName()+" :    "+ hpPotion3.price+"      "+hpPotion3.recoveryAmount);
    StoreList.add("6. "+hpPotion3.getName()+" :    "+ mpPotion3.price+"     "+hpPotion3.recoveryAmount);
    StoreList.add("-------------------------------------------------------------------------------------------------");
    StoreList.add("7. "+soad.getName()+" :"+soad.getPrice()+"ㅣ   공격력증가 :  "+soad.getAttackPower());
    StoreList.add("8. "+armor.getName()+" :"+armor.getPrice()+"ㅣ   방어력증가  "+armor.getArmorPower());
    StoreList.add("9. "+shoes.getName()+" :"+shoes.getPrice()+"ㅣ   명중률증가:  "+shoes.getAvoidUp());
    StoreList.add("-------------------------------------------------------------------------------------------------");
    StoreList.add("10. "+soad2.getName()+" :"+soad2.getPrice()+"ㅣ   공격력증가 :  "+soad2.getAttackPower());
    StoreList.add("11. "+armor2.getName()+" :"+armor2.getPrice()+"ㅣ   방어력증가  "+armor2.getArmorPower());
    StoreList.add("12. "+shoes2.getName()+" :"+shoes2.getPrice()+"ㅣ   명중률증가:  "+shoes2.getAvoidUp());
    StoreList.add("-------------------------------------------------------------------------------------------------");
    StoreList.add("13. "+soad3.getName()+" :"+soad3.getPrice()+"ㅣ   공격력증가 :  "+soad3.getAttackPower());
    StoreList.add("14. "+armor3.getName()+" :"+armor3.getPrice()+"ㅣ   명중률증가:  "+armor3.getArmorPower());
    StoreList.add("15. "+shoes3.getName()+" :"+shoes3.getPrice()+"ㅣ   방어력증가  "+shoes3.getAvoidUp());
  }
  void storeView(){

    System.out.println("---------------------------------------------------------------------");
    for(int i=0;i< StoreList.size();i++) {
      System.out.println(StoreList.get(i)+"    ");
    }
    System.out.println("---------------------------------------------------------------------");
  }

  void buy(){

  }

  void buyHpPotion(Inventory inventory){
    if(inventory.getCash()<hpPotion.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(hpPotion.getName());
      inventory.setCash(inventory.getCash()- hpPotion.getPrice());
      System.out.println(hpPotion.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }

  }
  void buyHpPotion2(Inventory inventory){
    if(inventory.getCash()<hpPotion2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(hpPotion2.getName());
      inventory.setCash(inventory.getCash()-hpPotion2.getPrice());
      System.out.println(hpPotion2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyHpPotion3(Inventory inventory){
    if(inventory.getCash()<hpPotion3.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(hpPotion3.getName());
      inventory.setCash(inventory.getCash()-hpPotion3.getPrice());
      System.out.println(hpPotion3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyMpPotion(Inventory inventory){

    if(inventory.getCash()<mpPotion.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(mpPotion.getName());
      inventory.setCash(inventory.getCash()-mpPotion.getPrice());
      System.out.println(mpPotion.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyMpPotion2(Inventory inventory){
    if(inventory.getCash()<mpPotion2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(mpPotion2.getName());
      inventory.setCash(inventory.getCash()-mpPotion2.getPrice());
      System.out.println(mpPotion2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }

  }
  void buyMpPotion3(Inventory inventory){
    if(inventory.getCash()<mpPotion3.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(mpPotion3.getName());
      inventory.setCash(inventory.getCash()-mpPotion3.getPrice());
      System.out.println(mpPotion3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }

  void buySoad(Inventory inventory){
    if(inventory.getCash()<soad.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(soad.getName());
      inventory.setCash(inventory.getCash()-soad.getPrice());
      System.out.println(soad.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buySoad2(Inventory inventory){
    if(inventory.getCash()<soad.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(soad2.getName());
      inventory.setCash(inventory.getCash()-soad2.getPrice());
      System.out.println(soad2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buySoad3(Inventory inventory){
    if(inventory.getCash()<soad3.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(soad3.getName());
      inventory.setCash(inventory.getCash()-soad3.getPrice());
      System.out.println(soad3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyArmor(Inventory inventory){
    if(inventory.getCash()<armor.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(armor.getName());
      inventory.setCash(inventory.getCash()-armor.getPrice());
      System.out.println(armor.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyArmor2(Inventory inventory){
    if(inventory.getCash()<armor2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(armor2.getName());
      inventory.setCash(inventory.getCash()-armor2.getPrice());
      System.out.println(armor2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyArmor3(Inventory inventory){
    if(inventory.getCash()<armor3.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(armor3.getName());
      inventory.setCash(inventory.getCash()-armor3.getPrice());
      System.out.println(armor3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyShoes(Inventory inventory){
    if(inventory.getCash()<shoes.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(shoes.getName());
      inventory.setCash(inventory.getCash()-shoes.getPrice());
      System.out.println(shoes.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyShoes2(Inventory inventory){
    if(inventory.getCash()<shoes2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(shoes2.getName());
      inventory.setCash(inventory.getCash()-shoes2.getPrice());
      System.out.println(shoes2.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
  void buyShoes3(Inventory inventory){
    if(inventory.getCash()<shoes2.getPrice()){
      System.out.println("구매할수없습니다.");
    } else{
      inventory.inventoryList.add(shoes3.getName());
      inventory.setCash(inventory.getCash()-shoes3.getPrice());
      System.out.println(shoes3.getName()+"을 구매했습니다.  남은금화: "+inventory.getCash());
    }
  }
}
