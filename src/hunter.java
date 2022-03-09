import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hunter { //사냥터별 차이는 레벨제한
    String mapName="";
    int damage; //캐릭터합산
    Scanner sc=new Scanner(System.in);
    int stage;
    int num;
    int temp;
    int random;
    int setUserDamage(User user,Monster monster){
        //유저의 방어력이 몹의 공격력보다 크면 데미지0
        int damage = user.getDefense() - monster.getAttack();
        if(damage>0){
            damage=0;
        }
        return damage;
    }
    int setMosterDamage(User user,Monster monster){
        //유저의 방어력이 몹의 공격력보다 크면 데미지0
        int damage = monster.getDefense() - user.getAttack();
        System.out.println(damage+"damage");
        if(damage>0){
            damage=0;
        }

        return damage;
    }
    void 사냥터입구(User user,Skills skills,Inventory inventory,Store store){
        int num;
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.초보자사냥터  ㅣ  2.숙련자사냥터  ㅣ  3.상급자사냥터  ㅣ  4.보스   ㅣ  ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        num= sc.nextInt();
        switch (num){
            case 1: //초급
                초급사냥터(user, skills, inventory,store);
                break;
            case 2: //중급
                중급사냥터(user, skills, inventory,store);
                break;
            case 3: //상급
                break;
            case 4: //보스
                break;
        }
    }


    User 중급사냥터(User user, Skills skills, Inventory inventory, Store store){
        int ranChar=1;
        switch (ranChar){
            case 1: //리자드
                중급Battle(user, skills, inventory,store);
                break;
            case 2:
                break;
            case 3:
                break;
        }
        
        return user;
    }

    User 중급Battle(User user, Skills skills, Inventory inventory, Store store){
        Monster 리자드=new Monster(
                "리자드",
                4,
                40,
                40,
                40,
                40,
                40,
                40,
                1,
                40,
                "리자드의 꼬리",
                40,
                40);

        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(리자드.getName()+"와 전투를 합니다");
        System.out.println("현재HP  / 총HP  : " + 리자드.getRealHp() + " / " + 리자드.getHp());
        System.out.println(" 공격력         : " + 리자드.getAttack());
        System.out.println(" 방어력         : " + 리자드.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=sc.nextInt();
            switch (num){
                case 1:
                    System.out.println(user.getName()+"님의 일반공격!");
                    //파이리 현재체력 = 기존체력-(파이리 방어력 -유저 공격력)
                    setUserDamage(user,리자드);
                    리자드.setRealHp(리자드.getRealHp()+setUserDamage(user,리자드));
                    System.out.println(setUserDamage(user,리자드));
                    break;
                case 2:
                    System.out.println(user.getName()+"님의 화염발사!!");
                    리자드.setRealHp(리자드.getRealHp()-(setUserDamage(user,리자드)*skills.getFire()));
                    user.setRealMp(user.getRealHp()-5);
                    break;
                case 3:
                    System.out.println(user.getName()+"님의 물대포!!");
                    리자드.setRealHp(리자드.getRealHp()-(리자드.getDefense()-user.getAttack())*skills.getWater()*2);
                    user.setRealMp(user.getRealHp()-5);
                    break;
                case 4:
                    System.out.println(user.getName()+"님의 나뭇잎날리기!!");
                    리자드.setRealHp(리자드.getRealHp()-(리자드.getDefense()-user.getAttack())* skills.getForest()*1/2);
                    break;
                case 5:
                    System.out.println(user.getName()+"님의 체력회복");
                    skills.hpRecovery(user,skills);
                    break;
                case 6:
                    System.out.println(user.getName()+"님의 방어력증가");
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
            }
            if(리자드.getRealHp()<=0){
                System.out.println("리자드를 처치했습니다.");
                user.setExperience(user.getExperience()+리자드.getMonEX(),user,skills);
                inventory.inventoryList.add(리자드.dropItem);
                inventory.setCash(inventory.getCash()+10);
                System.out.println("보상아이템 :  "+리자드.dropItem+" ㅣ 금화:  "+리자드.getDropCash()+"  ㅣ  경험치 : "+리자드.getMonEX());
                game=false;
                break;
            }
            random=((int)(Math.random()*2+1));
            switch (1){
                case 1:
                    setMosterDamage(user,리자드);
                    user.setRealHp(user.getRealHp()-  setMosterDamage(user,리자드));
                    System.out.println("리자드의 몸통 박치기!!"+리자드.getAttack()+"at"+"set"+setMosterDamage(user,리자드));
                    break;
                case 2:

                    setMosterDamage(user,리자드);
                    user.setRealHp(user.getRealHp()-setMosterDamage(user,리자드)*2);
                    System.out.println("리자드의 불꽃세례!!"+리자드.getAttack()+"at"+"set"+setMosterDamage(user,리자드));
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("리자드의 현재HP  / 총HP  : " + 리자드.getRealHp() + " / " + 리자드.getHp());
        }
        return user;
    }
    User 초급사냥터(User user,Skills skills,Inventory inventory,Store store){ //user만 들어가는게 맞음
        int random=((int)(Math.random()*10+1));
        //int ranChar=((int)(Math.random()*3+1));
        int ranChar=1;
        switch (ranChar){ //속성 1 파이리 , 2꼬북이  3이상해씨
           case 1:
               Battle(user,skills,inventory,store);
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return user;
    }
boolean game=true;
    User Battle(User user,Skills skills,Inventory inventory,Store store){
        Monster 파이리=new Monster(
                "파이리",
                1,
                10,
                10,
                10,
                10,
                10,
                10,
                1,
                10,
                "파이리의 꼬리",
                10,
                10);
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println(파이리.getName()+"와 전투를 합니다");
            System.out.println("현재HP  / 총HP  : " + 파이리.getRealHp() + " / " + 파이리.getHp());
            System.out.println(" 공격력         : " + 파이리.getAttack());
            System.out.println(" 방어력         : " + 파이리.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
            while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=sc.nextInt();
            switch (num){
                case 1:
                    System.out.println(user.getName()+"님의 일반공격!");
                    파이리.setRealHp(파이리.getRealHp()+파이리.getDefense()-user.getAttack());
                    break;
                case 2:
                    System.out.println(user.getName()+"님의 화염발사!!");
                    파이리.setRealHp(파이리.getRealHp()-(파이리.getDefense()-user.getAttack()*skills.getFire()));
                    break;
                case 3:
                    System.out.println(user.getName()+"님의 물대포!!");
                    파이리.setRealHp(파이리.getRealHp()-(파이리.getDefense()-user.getAttack())*skills.getWater()*2);
                    break;
                case 4:
                    System.out.println(user.getName()+"님의 나뭇잎날리기!!");
                    파이리.setRealHp(파이리.getRealHp()-(파이리.getDefense()-user.getAttack())* skills.getForest()*1/2);
                    break;
                case 5:
                    System.out.println(user.getName()+"님의 체력회복");
                    skills.hpRecovery(user,skills);
                    break;
                case 6:
                    System.out.println(user.getName()+"님의 방어력증가");
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
             }
            if(파이리.getRealHp()<=0){
                System.out.println("파이리를 처치했습니다.");
                user.setExperience(user.getExperience()+파이리.getMonEX(),user,skills);
                inventory.inventoryList.add(파이리.dropItem);
                inventory.setCash(inventory.getCash()+10);
                System.out.println("보상아이템 :  "+파이리.dropItem+" ㅣ 금화:  "+파이리.getDropCash()+"  ㅣ  경험치 : "+파이리.getMonEX());
                game=false;
                break;
            }
            random=((int)(Math.random()*2+1));
            switch (1){
                case 1:
                    user.setRealHp(user.getRealHp()-(user.getDefense()-파이리.getAttack()));
                    System.out.println("파이리의 몸통 박치기!!");
                    break;
                case 2:
                    user.setRealHp(user.getRealHp()-(user.getDefense()-파이리.getAttack())*2);
                    System.out.println("파이리의 불꽃세례!!");
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("파이리의 현재HP  / 총HP  : " + 파이리.getRealHp() + " / " + 파이리.getHp());

        }


        return user;
        
    }

}

