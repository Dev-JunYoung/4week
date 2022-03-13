import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hunter {

    Scanner sc=new Scanner(System.in);
    int stage;
    int num;
    int random;
    int skillDamage;
    void 사냥터입구(User user,Skills skills,Inventory inventory,Store store){
        int num;
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.초보자사냥터  ㅣ  2.숙련자사냥터  ㅣ  3.상급자사냥터  ㅣ  4.보스   ㅣ  5.돌아가기  ㅣ  ");
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
                상급사냥터(user, skills, inventory,store);
                break;
            case 4: //보스
                보스사냥터(user, skills, inventory,store);
                break;
            case 5:
                break;
        }
    }
//--------------------------------------------------------------------------------------------------------------
    //보스 추가메서드 필살기
    User 보스사냥터(User user, Skills skills, Inventory inventory, Store store){
        //보스는 매 턴마다 속성이 달라짐,
        int ranChar=((int)(Math.random()*3+1));
        boss 뮤츠=new boss(
                "뮤츠",
                10,
                200,
                200,
                200,
                200,
                150,
                100,
                0,
                200,
                "뮤츠의 유골",
                2000,
                100
        ) ;
        Battle뮤츠(user,skills,inventory,store,뮤츠);
        return user;
    }
    //--------------------------------------------------------------------------------------------------------------
    User Battle뮤츠(User user, Skills skills, Inventory inventory, Store store,boss 뮤츠){
        뮤츠.property=((int)(Math.random()*3+1));
        String 속성 = null;
        if(뮤츠.property==1){
            속성="'불' 속성";
        }else if(뮤츠.property==2){
            속성="'물' 속성";
        }else if(뮤츠.property==3){
            속성="'풀' 속성";
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(뮤츠.getName()+"와 전투를 합니다");
        System.out.println("현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
        System.out.println(" 공격력         : " + 뮤츠.getAttack());
        System.out.println(" 방어력         : " + 뮤츠.getDefense());
        System.out.println("뮤츠의 현재 속성은 "+속성+" 입니다");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=sc.nextInt();
            switch (num){
                case 1: //일반공격
                    if(뮤츠.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-user.getPower()));
                    }  else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 2: //내가 불공격
                        switch (뮤츠.property){
                            case 1:   //case 1 불뮤츠
                                skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10));
                                if(뮤츠.getDefense()<skillDamage){
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(user.getName()+"님이 공격했습니다.");
                                }else {
                                    System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                                }
                                break;
                            case 2:    //case 2 물뮤츠
                                skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10))*2/3;
                                if(뮤츠.getDefense()<skillDamage){
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(user.getName()+"님이 공격했습니다.");
                                }else {
                                    System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                                }
                                break;
                            case 3:  //case 3 풀뮤츠
                                skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10))*3/2;
                                if(뮤츠.getDefense()<skillDamage){
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(user.getName()+"님이 공격했습니다.");
                                }else {
                                    System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                                }
                                break;
                        }
                    break;
                case 3: //내가 물공격
                    switch (뮤츠.property){
                        case 1:   //case 1 불뮤츠
                            skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10))*3/2;
                            if(뮤츠.getDefense()<skillDamage){
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                        case 2:    //case 2 물뮤츠
                            skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10));
                            if(뮤츠.getDefense()<skillDamage){
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                        case 3:  //case 3 풀뮤츠
                            skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10))*2/3;
                            if(뮤츠.getDefense()<skillDamage){
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                    }
                    break;
                case 4: //user 풀
                    switch (뮤츠.property){
                        case 1:   //case 1 불뮤츠
                            skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10))*2/3;
                            if(뮤츠.getDefense()<skillDamage){
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                        case 2:    //case 2 물뮤츠
                            skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10))*3/2;
                            if(뮤츠.getDefense()<skillDamage){
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                        case 3:  //case 3 풀뮤츠
                            skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10));
                            if(뮤츠.getDefense()<skillDamage){
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                    }
                    break;
                case 5:
                    skills.hpRecovery(user, skills);
                    break;
                case 6:
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
            }//내공격끝

            if(뮤츠.getRealHp()<=0){

                System.out.println("뮤츠를 처치했습니다.");
                user.setExperience(user.getExperience()+뮤츠.getMonEX(),user,skills);
                inventory.inventoryList.add(뮤츠.dropItem);
                inventory.setCash(inventory.getCash()+100);
                System.out.println("보상아이템 :  "+뮤츠.dropItem+" ㅣ 금화:  "+뮤츠.getDropCash()+"  ㅣ  경험치 : "+뮤츠.getMonEX());
                game=false;
                break;
            }
            System.out.println("뮤츠의 공격");
            sc.nextLine();
            random=((int)(Math.random()*4+1));
            switch (random){
                case 1: // 평타
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    System.out.println("드레인펀치!!");
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    user.setRealHp(user.getRealHp()-100);
                    if(user.getDefense()-뮤츠.getAttack()<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-뮤츠.getAttack()));
                        System.out.println("칼등치기!!");
                    }else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 2: //스킬
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    System.out.println("솔라빔!!");
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    user.setRealHp(user.getRealHp()-100);
                    break;
                case 3: //스킬
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    System.out.println("파괴광선!!");
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    user.setRealHp(user.getRealHp()-100);
                    break;
                case 4: //스킬
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    System.out.println("1000만볼트!!");
                    System.out.println("----------------------------------------------------------------------------------------------------------");
                    user.setRealHp(user.getRealHp()-100);
                    break;
            }
            뮤츠.property=((int)(Math.random()*3+1));
            if(뮤츠.property==1){
                속성="'물' 속성";
            }else if(뮤츠.property==2){
                속성="'불' 속성";
            }else {
                속성="'풀' 속성";
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            if(user.getRealHp()<0){
                user.userDie(user);
                return user;
            }
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
            System.out.println("뮤츠의 현재 속성은 "+속성+" 입니다");
            System.out.println();
        }

        return user;
    }
    void 뮤츠속성별공격력변화(User user,boss 뮤츠){
        switch (뮤츠.property){
            case 1: //불
                //뮤츠불속성(user, 뮤츠);
                break;
            case 2: //물
                //뮤츠물속성(user, 뮤츠);
                break;
            case 3: //풀
                //뮤츠풀속성(user, 뮤츠);
                break;
        }
    }
    void 뮤츠불속성(User user,boss 뮤츠){ //뮤츠 불속성일때
        switch (뮤츠.property){
            case 1: //불속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-30);
                user.setRealMp(user.getRealMp()-3);
                break;
            case 2: //물속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-60);
                user.setRealMp(user.getRealMp()-3);
                break;
            case 3: //풀속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-15);
                user.setRealMp(user.getRealMp()-3);
                break;
        }
    }
    void 뮤츠물속성(User user,boss 뮤츠){
        switch (뮤츠.property){
            case 1: //불속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-15);
                user.setRealMp(user.getRealMp()-3);
                break;
            case 2: //물속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-30);
                user.setRealMp(user.getRealMp()-3);
                break;
            case 3: //풀속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-60);
                user.setRealMp(user.getRealMp()-3);
                break;
        }
    }
    void 뮤츠풀속성(User user,boss 뮤츠){
        switch (뮤츠.property){

            case 1: //불속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-60);
                user.setRealMp(user.getRealMp()-3);
                break;
            case 2: //물속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-15);
                user.setRealMp(user.getRealMp()-3);
                break;
            case 3: //풀속성공격
                뮤츠.setRealHp(뮤츠.getRealHp()-30);
                user.setRealMp(user.getRealMp()-3);
                break;
        }
    }
    //완성
    User 상급사냥터(User user, Skills skills, Inventory inventory, Store store){
        int ranChar=((int)(Math.random()*3+1));
        switch (ranChar){
            case 1: //
                Monster 리자몽=new Monster(
                        "리자몽",
                        7,
                        100,
                        100,
                        100,
                        100,
                        70,
                        70,
                        1,
                        70,
                        "리자몽의 꼬리",
                        500,
                        50
                );
                Battle리자몽(user, skills, inventory, store,리자몽);
                break;
            case 2:Monster 거북왕=new Monster(
                    "거북왕",
                    7,
                    100,
                    100,
                    100,
                    100,
                    100,
                    100,
                    2,
                    70,
                    "거북왕의 등딱지",
                    500,
                    50
            );
                Battle거북왕(user, skills, inventory, store,거북왕);
                break;
            case 3:Monster 이상해꽃=new Monster(
                    "이상해꽃",
                    7,
                    100,
                    100,
                    100,
                    100,
                    100,
                    100,
                    3,
                    70,
                    "이상해꽃의 꽃",
                    500,
                    50
            );
                Battle이상해꽃(user, skills, inventory, store,이상해꽃);
                break;
        }
        return user;
    }
    User Battle이상해꽃(User user, Skills skills, Inventory inventory, Store store,Monster 이상해꽃){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(이상해꽃.getName()+"와 전투를 합니다");
        System.out.println("현재HP  / 총HP  : " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
        System.out.println(" 공격력         : " + 이상해꽃.getAttack());
        System.out.println(" 방어력         : " + 이상해꽃.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=sc.nextInt();
            switch (num){
                case 1: //일반공격
                    if(이상해꽃.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-user.getPower()));
                    }  else {
                    System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                }
                    break;
                case 2:
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10))*3/2;
                    if(이상해꽃.getDefense()<skillDamage){
                        이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3:
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10))*2/3;
                    if(이상해꽃.getDefense()<skillDamage){
                        이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4:
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10));
                    if(이상해꽃.getDefense()<skillDamage){
                        이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    skills.hpRecovery(user, skills);
                    break;
                case 6:
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
            }//내공격끝
            //리자몽공격
            if(이상해꽃.getRealHp()<=0){
                System.out.println("이상해꽃을 처치했습니다.");
                user.setExperience(user.getExperience()+이상해꽃.getMonEX(),user,skills);
                inventory.inventoryList.add(이상해꽃.dropItem);
                inventory.setCash(inventory.getCash()+300);
                System.out.println("보상아이템 :  "+이상해꽃.dropItem+" ㅣ 금화:  "+이상해꽃.getDropCash()+"  ㅣ  경험치 : "+이상해꽃.getMonEX());
                game=false;
                break;
            }
            System.out.println("이상해꽃의 공격");
            sc.nextLine();
            random=((int)(Math.random()*2+1));
            switch (random){
                case 1: // 평타

                    if(user.getDefense()-이상해꽃.getAttack()<0){ //양수가 되면 안됌
                    user.setRealHp(user.getRealHp()+(user.getDefense()-이상해꽃.getAttack()));
                        System.out.println("칼등치기!!"); }else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 2: //스킬

                    if(이상해꽃.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-user.getPower()));
                        System.out.println("솔라빔!!");
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            if(user.getRealHp()<0){
                user.userDie(user);
                return user;
            }
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("이상해꽃의 현재HP  / 총HP  : " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
        }
        return user;
    }
    User Battle거북왕(User user, Skills skills, Inventory inventory, Store store,Monster 거북왕){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(거북왕.getName()+"와 전투를 합니다");
        System.out.println("현재HP  / 총HP  : " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
        System.out.println(" 공격력         : " + 거북왕.getAttack());
        System.out.println(" 방어력         : " + 거북왕.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=sc.nextInt();
            switch (num){
                case 1: //일반공격
                    if(거북왕.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-user.getPower()));
                    } else {
                    System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                }
                    break;
                case 2:
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10))*2/3;
                    if(거북왕.getDefense()<skillDamage){
                        거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10));
                    if(거북왕.getDefense()<skillDamage){
                        거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10))*3/2;
                    if(거북왕.getDefense()<skillDamage){
                        거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    skills.hpRecovery(user, skills);
                    break;
                case 6:
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
            }//내공격끝
            //리자몽공격
            if(거북왕.getRealHp()<=0){
                System.out.println("거북왕을 처치했습니다.");
                user.setExperience(user.getExperience()+거북왕.getMonEX(),user,skills);
                inventory.inventoryList.add(거북왕.dropItem);
                inventory.setCash(inventory.getCash()+300);
                System.out.println("보상아이템 :  "+거북왕.dropItem+" ㅣ 금화:  "+거북왕.getDropCash()+"  ㅣ  경험치 : "+거북왕.getMonEX());
                game=false;
                break;
            }
            System.out.println("거북왕의 공격");
            sc.nextLine();
            random=((int)(Math.random()*2+1));
            switch (random){
                case 1: // 평타

                    if(user.getDefense()-거북왕.getAttack()<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-거북왕.getAttack()));
                        System.out.println("거북왕펀치!!");
                    }
                    break;
                case 2: //스킬

                    if(거북왕.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-user.getPower()));
                        System.out.println("하이드로빔!!");
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            if(user.getRealHp()<0){
                user.userDie(user);
                return user;
            }
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("거북왕의 현재HP  / 총HP  : " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
        }
        return user;
    }
    User Battle리자몽(User user, Skills skills, Inventory inventory, Store store,Monster 리자몽){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(리자몽.getName()+"와 전투를 합니다");
        System.out.println("현재HP  / 총HP  : " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
        System.out.println(" 공격력         : " + 리자몽.getAttack());
        System.out.println(" 방어력         : " + 리자몽.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=sc.nextInt();
            switch (num){
                case 1: //일반공격
                    if(리자몽.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        리자몽.setRealHp(리자몽.getRealHp()+(리자몽.getDefense()-user.getPower()));
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 2:
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10));
                    if(리자몽.getDefense()<skillDamage){
                        리자몽.setRealHp(리자몽.getRealHp()+(리자몽.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10))*3/2;
                    if(리자몽.getDefense()<skillDamage){
                        리자몽.setRealHp(리자몽.getRealHp()+(리자몽.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10))*2/3;
                    if(리자몽.getDefense()<skillDamage){
                        리자몽.setRealHp(리자몽.getRealHp()+(리자몽.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    skills.hpRecovery(user, skills);
                    break;
                case 6:
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
            }//내공격끝
            //리자몽공격
            if(리자몽.getRealHp()<=0){
                System.out.println("리자몽을 처치했습니다.");
                user.setExperience(user.getExperience()+리자몽.getMonEX(),user,skills);
                inventory.inventoryList.add(리자몽.dropItem);
                inventory.setCash(inventory.getCash()+300);
                System.out.println("보상아이템 :  "+리자몽.dropItem+" ㅣ 금화:  "+리자몽.getDropCash()+"  ㅣ  경험치 : "+리자몽.getMonEX());
                game=false;
                break;
            }
            System.out.println("리자몽의 공격");
            sc.nextLine();
            random=((int)(Math.random()*2+1));
            switch (random){
                case 1: // 평타

                    if(user.getDefense()-리자몽.getAttack()<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-리자몽.getAttack()));
                        System.out.println("마구 할퀴기!!");
                    }
                    break;
                case 2: //스킬

                    if(user.getDefense()-리자몽.getAttack()*4/3<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-리자몽.getAttack()));
                        System.out.println("회오리 불꽃!!");

                    }else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            if(user.getRealHp()<0){
                user.userDie(user);
                return user;
            }
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("리자몽의 현재HP  / 총HP  : " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
        }
        return user;
    }
//--------------------------------------------------------------------------------------------------------------
    User 중급사냥터(User user, Skills skills, Inventory inventory, Store store){
        int ranChar=((int)(Math.random()*3+1));
        switch (ranChar){
            case 1: //리자드
                Monster 리자드=new Monster(
                        "리자드",
                        4,
                        70,
                        70,
                        70,
                        70,
                        70,
                        70,
                        1,
                        70,
                        "리자드의 꼬리",
                        200,
                        30
                );
                Battle리자드(user, skills, inventory,store,리자드);
                break;
            case 2:
                Monster 어니부기=new Monster(
                        "어니부기",
                        4,
                        70,
                        70,
                        70,
                        70,
                        70,
                        70,
                        2,
                        70,
                        "어니부기의 등딱지",
                        200,
                        30
                );
                Battle어니부기(user, skills, inventory, store,어니부기);
                break;
            case 3:
                Monster 이상해풀=new Monster(
                        "이상해풀",
                        4,
                        70,
                        70,
                        70,
                        70,
                        70,
                        70,
                        3,
                        70,
                        "이상해풀의 풀입",
                        200,
                        30
                );
                Battle이상해풀(user, skills, inventory, store,이상해풀);
                break;
        }

        return user;
    } //switch
    User Battle이상해풀(User user,Skills skills,Inventory inventory,Store store,Monster 이상해풀){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(이상해풀.getName()+"와 전투를 합니다");
        System.out.println("현재HP  / 총HP  : " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
        System.out.println(" 공격력         : " + 이상해풀.getAttack());
        System.out.println(" 방어력         : " + 이상해풀.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=sc.nextInt();
            switch (num){
                case 1: //일반공격
                    if(이상해풀.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        이상해풀.setRealHp(이상해풀.getRealHp()+(이상해풀.getDefense()-user.getPower()));
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 2:
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10))*3/2;
                    if(이상해풀.getDefense()<skillDamage){
                        이상해풀.setRealHp(이상해풀.getRealHp()+(이상해풀.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3:
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10))*2/3;
                    if(이상해풀.getDefense()<skillDamage){
                        이상해풀.setRealHp(이상해풀.getRealHp()+(이상해풀.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4:
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10));
                    if(이상해풀.getDefense()<skillDamage){
                        이상해풀.setRealHp(이상해풀.getRealHp()+(이상해풀.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    skills.hpRecovery(user, skills);
                    break;
                case 6:
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
            }//내공격끝
            //
            sc.nextLine();
            if(이상해풀.getRealHp()<=0){
                System.out.println("이상해풀을 처치했습니다.");
                user.setExperience(user.getExperience()+이상해풀.getMonEX(),user,skills);
                inventory.inventoryList.add(이상해풀.dropItem);
                inventory.setCash(inventory.getCash()+200);
                System.out.println("보상아이템 :  "+이상해풀.dropItem+" ㅣ 금화:  "+이상해풀.getDropCash()+"  ㅣ  경험치 : "+이상해풀.getMonEX());
                game=false;
                break;
            }
            System.out.println("이상해풀의 공격");
            sc.nextLine();
            random=((int)(Math.random()*2+1));
            switch (random){
                case 1: // 평타
                    if(user.getDefense()-이상해풀.getAttack()<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-이상해풀.getAttack()));
                        System.out.println("땅울리기!!");
                    }
                    break;
                case 2: //스킬
                    if(user.getDefense()-이상해풀.getAttack()*4/3<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-이상해풀.getAttack()));
                       System.out.println("풀입날리기!!");

                    }else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            if(user.getRealHp()<0){
                user.userDie(user);
                return user;
            }
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("이상해풀의 현재HP  / 총HP  : " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
        }
        return user;
    }
    User Battle리자드(User user, Skills skills, Inventory inventory, Store store, Monster 리자드){
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
                case 1: //일반공격
                    if(리자드.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        리자드.setRealHp(리자드.getRealHp()+(리자드.getDefense()-user.getPower()));
                    } else {
                    System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                }
                    break;
                case 2:
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10));
                    if(리자드.getDefense()<skillDamage){
                        리자드.setRealHp(리자드.getRealHp()+(리자드.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10))*3/2;
                    if(리자드.getDefense()<skillDamage){
                        리자드.setRealHp(리자드.getRealHp()+(리자드.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10))*2/3;
                    if(리자드.getDefense()<skillDamage){
                        리자드.setRealHp(리자드.getRealHp()+(리자드.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;

                case 5:
                    skills.hpRecovery(user, skills);
                    break;
                case 6:
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
            }//내공격끝
            //
            sc.nextLine();
            if(리자드.getRealHp()<=0){
                System.out.println("리자드를 처치했습니다.");
                user.setExperience(user.getExperience()+리자드.getMonEX(),user,skills);
                inventory.inventoryList.add(리자드.dropItem);
                inventory.setCash(inventory.getCash()+200);
                System.out.println("보상아이템 :  "+리자드.dropItem+" ㅣ 금화:  "+리자드.getDropCash()+"  ㅣ  경험치 : "+리자드.getMonEX());
                game=false;
                break;
            }
            System.out.println("리자드의 공격");
            sc.nextLine();
            random=((int)(Math.random()*2+1));
            switch (random){
                case 1: // 평타
                    if(user.getDefense()-리자드.getAttack()<0){ //양수가 되면 안됌
                    user.setRealHp(user.getRealHp()+(user.getDefense()-리자드.getAttack()));
                        System.out.println("손톱할퀴기!!"); }
                    break;
                case 2: //스킬

                    if(user.getDefense()-리자드.getAttack()*4/3<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-리자드.getAttack()));
                        System.out.println("불꽃세례!!");
                    }else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            if(user.getRealHp()<0){
                user.userDie(user);
                return user;
            }
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("리자드의 현재HP  / 총HP  : " + 리자드.getRealHp() + " / " + 리자드.getHp());
        }
        return user;
    } //리자드
    User Battle어니부기(User user, Skills skills, Inventory inventory, Store store,Monster 어니부기){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(어니부기.getName()+"와 전투를 합니다");
        System.out.println("현재HP  / 총HP  : " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
        System.out.println(" 공격력         : " + 어니부기.getAttack());
        System.out.println(" 방어력         : " + 어니부기.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=sc.nextInt();
            switch (num){
                case 1: //일반공격
                    if(어니부기.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        어니부기.setRealHp(어니부기.getRealHp()+(어니부기.getDefense()-user.getPower()));
                    } else {
                    System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                }
                    break;
                ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                case 2:
                skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10))*2/3;
                if(어니부기.getDefense()<skillDamage){
                    어니부기.setRealHp(어니부기.getRealHp()+(어니부기.getDefense()-skillDamage));
                    System.out.println(user.getName()+"님이 공격했습니다.");
                }else {
                    System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                }
                break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10));
                    if(어니부기.getDefense()<skillDamage){
                        어니부기.setRealHp(어니부기.getRealHp()+(어니부기.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10))*3/2;
                    if(어니부기.getDefense()<skillDamage){
                        어니부기.setRealHp(어니부기.getRealHp()+(어니부기.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;

                case 5:
                    skills.hpRecovery(user, skills);
                    break;
                case 6:
                    skills.ArmorUp(user,skills);
                    break;
                case 7:
                    game=false;
                    return user;
            }//내공격끝
            sc.nextLine();
            if(어니부기.getRealHp()<=0){
                System.out.println("어니부기을 처치했습니다.");
                user.setExperience(user.getExperience()+어니부기.getMonEX(),user,skills);
                inventory.inventoryList.add(어니부기.dropItem);
                inventory.setCash(inventory.getCash()+200);
                System.out.println("보상아이템 :  "+어니부기.dropItem+" ㅣ 금화:  "+어니부기.getDropCash()+"  ㅣ  경험치 : "+어니부기.getMonEX());
                game=false;
                break;
            }

            System.out.println("어니부기의 공격");
            sc.nextLine();sc.nextLine();
            random=((int)(Math.random()*2+1));
            switch (random){
                case 1: // 평타
                    if(user.getDefense()-어니부기.getAttack()<0){ //양수가 되면 안됌
                    user.setRealHp(user.getRealHp()+(user.getDefense()-어니부기.getAttack()));
                        System.out.println("등딱지 박치기!!"); }
                    break;
                case 2: //스킬

                    if(user.getDefense()-어니부기.getAttack()*4/3<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-어니부기.getAttack()));
                        System.out.println("물대포!!");
                    }else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            if(user.getRealHp()<0){
                user.userDie(user);
                return user;
            }
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("어니부기의 현재HP  / 총HP  : " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
        }
        return user;
    }
//--------------------------------------------------------------------------------------------------------------
    User 초급사냥터(User user,Skills skills,Inventory inventory,Store store){
    int ranChar=((int)(Math.random()*3+1));
    switch (ranChar){ //속성 1 파이리 , 2꼬북이  3이상해씨
        case 1:
            Monster 파이리=new Monster(
                    "파이리",
                    3,
                    30,
                    30,
                    30,
                    30,
                    30,
                    30,
                    1,
                    30,
                    "파이리의 꼬리",
                    100,
                    20
            );
         Battle파이리(user,skills,inventory,store,파이리);
            break;
        case 2:Monster 꼬북이=new Monster(
                "꼬북이",
                3,
                30,
                30,
                30,
                30,
                30,
                30,
                2,
                30,
                "꼬북이의 등딱지",
                100,
                20
        );
         Battle꼬북이(user,skills,inventory,store,꼬북이);
            break;
        case 3:Monster 이상해씨=new Monster(
                "이상해씨",
                3,
                30,
                30,
                30,
                30,
                30,
                30,
                3,
                30,
                "이상해씨의 씨앗",
                100,
                20
        );
            Battle이상해씨(user,skills,inventory,store,이상해씨);
            break;
    }
    return user;
    } //switch
    User Battle파이리(User user, Skills skills, Inventory inventory, Store store,Monster 파이리){
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
                case 1: //일반공격
                    if(파이리.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        파이리.setRealHp(파이리.getRealHp()+(파이리.getDefense()-user.getPower()));
                    }
                    else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                        break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10));
                    if(파이리.getDefense()<skillDamage){
                        파이리.setRealHp(파이리.getRealHp()+(파이리.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10))*3/2;
                    if(파이리.getDefense()<skillDamage){
                        파이리.setRealHp(파이리.getRealHp()+(파이리.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10))*2/3;
                    if(파이리.getDefense()<skillDamage){
                        파이리.setRealHp(파이리.getRealHp()+(파이리.getDefense()-skillDamage));
                        System.out.println(user.getName()+"님이 공격했습니다.");
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                    case 5:
                        skills.hpRecovery(user, skills);
                        break;
                    case 6:
                        skills.ArmorUp(user,skills);
                        break;
                    case 7:
                        game=false;
                        return user;
            }//내공격끝
            if(파이리.getRealHp()<=0){
                System.out.println("파이리을 처치했습니다.");
                user.setExperience(user.getExperience()+파이리.getMonEX(),user,skills);
                inventory.inventoryList.add(파이리.dropItem);
                inventory.setCash(inventory.getCash()+100);
                System.out.println("보상아이템 :  "+파이리.dropItem+" ㅣ 금화:  "+파이리.getDropCash()+"  ㅣ  경험치 : "+파이리.getMonEX());
                game=false;
                break;
            }
            System.out.println("파이리의 공격 차례입니다");
            sc.nextLine();
            random=((int)(Math.random()*2+1));
            switch (random){
                case 1: // 평타
                    System.out.println("파이리 펀치!!");
                    if(user.getDefense()-파이리.getAttack()<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-파이리.getAttack()));
                    }
                    break;
                case 2: //스킬

                    if(user.getDefense()-파이리.getAttack()*4/3<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-파이리.getAttack()));
                        System.out.println("불꽃발사!!");
                    }else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
            }
            stage=stage+1;
            System.out.println("진행횟수  :  "+stage);
            if(user.getRealHp()<0){
                user.userDie(user);
                return user;
            }
            System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
            System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("파이리의 현재HP  / 총HP  : " + 파이리.getRealHp() + " / " + 파이리.getHp());
        }
        return user;
    }
    User Battle꼬북이(User user, Skills skills, Inventory inventory, Store store,Monster 꼬북이){
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println(꼬북이.getName()+"와 전투를 합니다");
            System.out.println("현재HP  / 총HP  : " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
            System.out.println(" 공격력         : " + 꼬북이.getAttack());
            System.out.println(" 방어력         : " + 꼬북이.getDefense());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            while (game) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                num=sc.nextInt();
                switch (num){
                    case 1: //일반공격
                        if(꼬북이.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                            꼬북이.setRealHp(꼬북이.getRealHp()+(꼬북이.getDefense()-user.getPower()));
                        } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                        break;
                    case 2://불공격
                        ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                        skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10))*2/3;
                        if(꼬북이.getDefense()<skillDamage){
                            꼬북이.setRealHp(꼬북이.getRealHp()+(꼬북이.getDefense()-skillDamage));
                            System.out.println(user.getName()+"님이 공격했습니다.");
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 3: //물공격
                        skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10));
                        if(꼬북이.getDefense()<skillDamage){
                            꼬북이.setRealHp(꼬북이.getRealHp()+(꼬북이.getDefense()-skillDamage));
                            System.out.println(user.getName()+"님이 공격했습니다.");
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 4: //풀공격
                        skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10))*3/2;
                        if(꼬북이.getDefense()<skillDamage){
                            꼬북이.setRealHp(꼬북이.getRealHp()+(꼬북이.getDefense()-skillDamage));
                            System.out.println(user.getName()+"님이 공격했습니다.");
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 5:
                        skills.hpRecovery(user, skills);
                        break;
                    case 6:
                        skills.ArmorUp(user,skills);
                        break;
                    case 7:
                        game=false;
                        return user;
                }//내공격끝
                if(꼬북이.getRealHp()<=0){
                    System.out.println("꼬북이를 처치했습니다.");
                    user.setExperience(user.getExperience()+꼬북이.getMonEX(),user,skills);
                    inventory.inventoryList.add(꼬북이.dropItem);
                    inventory.setCash(inventory.getCash()+100);
                    System.out.println("보상아이템 :  "+꼬북이.dropItem+" ㅣ 금화:  "+꼬북이.getDropCash()+"  ㅣ  경험치 : "+꼬북이.getMonEX());
                    game=false;
                    break;
                }
                System.out.println("꼬북이의 공격 차례입니다");
                sc.nextLine();
                random=((int)(Math.random()*2+1));
                switch (random){
                    case 1: // 평타
                        System.out.println("몸통박치기!!");
                        if(user.getDefense()-꼬북이.getAttack()<0){ //양수가 되면 안됌
                            user.setRealHp(user.getRealHp()+(user.getDefense()-꼬북이.getAttack()));
                        }
                        break;
                    case 2: //스킬

                        if(user.getDefense()-꼬북이.getAttack()*4/3<0){ //양수가 되면 안됌
                            user.setRealHp(user.getRealHp()+(user.getDefense()-꼬북이.getAttack()));
                            System.out.println("물뿌리기!!");
                        }else {
                            System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                }
                stage=stage+1;
                System.out.println("진행횟수  :  "+stage);
                if(user.getRealHp()<0){
                    user.userDie(user);
                    return user;
                }

                System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out.println("꼬북이의 현재HP  / 총HP  : " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
            }
            return user;
        }
    User Battle이상해씨(User user, Skills skills, Inventory inventory, Store store,Monster 이상해씨){
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println(이상해씨.getName()+"와 전투를 합니다");
            System.out.println("현재HP  / 총HP  : " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
            System.out.println(" 공격력         : " + 이상해씨.getAttack());
            System.out.println(" 방어력         : " + 이상해씨.getDefense());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            while (game) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.도망가기    ㅣ");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                num=sc.nextInt();
                switch (num){
                    case 1: //일반공격

                        if(이상해씨.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                            이상해씨.setRealHp(이상해씨.getRealHp()+(이상해씨.getDefense()-user.getPower()));
                        } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                        break;
                    case 2://불>풀
                        ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                         skillDamage=(user.getPower()+ (user.getPower())*(skills.getFire()/10))*3/2;
                        if(이상해씨.getDefense()<skillDamage){
                            이상해씨.setRealHp(이상해씨.getRealHp()+(이상해씨.getDefense()-skillDamage));
                            System.out.println(user.getName()+"님이 공격했습니다.");
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 3:
                        skillDamage=(user.getPower()+ (user.getPower())*(skills.getWater()/10))*2/3;
                        if(이상해씨.getDefense()<skillDamage){
                            이상해씨.setRealHp(이상해씨.getRealHp()+(이상해씨.getDefense()-skillDamage));
                            System.out.println(user.getName()+"님이 공격했습니다.");
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 4:
                        skillDamage=(user.getPower()+ (user.getPower())*(skills.getForest()/10));
                        if(이상해씨.getDefense()<skillDamage){
                            이상해씨.setRealHp(이상해씨.getRealHp()+(이상해씨.getDefense()-skillDamage));
                            System.out.println(user.getName()+"님이 공격했습니다.");
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 5:
                        skills.hpRecovery(user, skills);
                        break;
                    case 6:
                        skills.ArmorUp(user,skills);
                        break;
                    case 7:
                        game=false;
                        return user;
                }//내공격끝

                if(이상해씨.getRealHp()<=0){
                    System.out.println("이상해씨을 처치했습니다.");
                    user.setExperience(user.getExperience()+이상해씨.getMonEX(),user,skills);
                    inventory.inventoryList.add(이상해씨.dropItem);
                    inventory.setCash(inventory.getCash()+100);
                    System.out.println("보상아이템 :  "+이상해씨.dropItem+" ㅣ 금화:  "+이상해씨.getDropCash()+"  ㅣ  경험치 : "+이상해씨.getMonEX());
                    game=false;
                    break;
                }
                System.out.println("이상해씨의 공격");
                sc.nextLine();
                random=((int)(Math.random()*2+1));
                switch (random){
                    case 1: // 평타

                    if(user.getDefense()-이상해씨.getAttack()<0){ //양수가 되면 안됌
                        user.setRealHp(user.getRealHp()+(user.getDefense()-이상해씨.getAttack()));
                        System.out.println("몸통박치기!!");
                    }else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }

                    break;
                    case 2: //스킬

                        if(user.getDefense()-이상해씨.getAttack()*4/3<0){ //양수가 되면 안됌
                            user.setRealHp(user.getRealHp()+(user.getDefense()-이상해씨.getAttack()));
                            System.out.println("씨폭탄!!");

                        }else {
                            System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                }
                stage=stage+1;
                System.out.println("진행횟수  :  "+stage);
                if(user.getRealHp()<0){
                    user.userDie(user);
                    return user;
                }
                System.out.println(user.getName()+"님의  현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp());
                System.out.println("    현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                System.out.println("----------------------------------------------------------------------------------------------------------");
                System.out.println("이상해씨의 현재HP  / 총HP  : " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
            }
            return user;
    }
//--------------------------------------------------------------------------------------------------------------

boolean game=true;

}

