import static java.lang.Thread.State.*;
public class hunter {
    Thread l=new Thread(new LodingBar(10));
    //진입시 로딩바 스레드
    void loding() throws InterruptedException {
        l.start();
        l.join();
    }
    boolean game=true;
    boolean afternoon = TimerRunnable.afternoon;
    int num;
    int skillDamage;
    void 사냥터입구(User user,Store store){
        System.out.println("" +
                "██╗  ██╗██╗   ██╗███╗   ██╗████████╗██╗███╗   ██╗ ██████╗     \n" +
                "██║  ██║██║   ██║████╗  ██║╚══██╔══╝██║████╗  ██║██╔════╝     \n" +
                "███████║██║   ██║██╔██╗ ██║   ██║   ██║██╔██╗ ██║██║  ███╗    \n" +
                "██╔══██║██║   ██║██║╚██╗██║   ██║   ██║██║╚██╗██║██║   ██║    \n" +
                "██║  ██║╚██████╔╝██║ ╚████║   ██║   ██║██║ ╚████║╚██████╔╝    \n" +
                "╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝   ╚═╝   ╚═╝╚═╝  ╚═══╝ ╚═════╝     \n" +            "                                                              "

        );
        int num;
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.초보자사냥터  ㅣ  2.숙련자사냥터  ㅣ  3.상급자사냥터  ㅣ  4.보스   ㅣ  5.돌아가기  ㅣ  ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        num=project.예외();
        //loding();
        switch (num){
            case 1: //초급
                초급사냥터(user,store);
                break;
            case 2: //중급
                if(user.getLevel()>4){
                    중급사냥터(user,store);
                }else {
                    System.out.println("레벨이 낮아, 진입 할 수 없습니다.");
                }
                break;
            case 3: //상급
                if(user.getLevel()>7){
                    상급사냥터(user,store);
                }else {
                    System.out.println("레벨이 낮아, 진입 할 수 없습니다.");
                }
                break;
            case 4: //보스
                if(user.getLevel()>=10){
                    보스사냥터(user,store);
                }else {
                    System.out.println("레벨이 낮아, 진입 할 수 없습니다.");
                }
                break;
            case 5:
                break;
        }
        project.대기(4);
    }
//--------------------------------------------------------------------------------------------------------------
    User 보스사냥터(User user,Store store){
        System.out.println("" +
                "██████╗  ██████╗ ███████╗███████╗\n" +
                "██╔══██╗██╔═══██╗██╔════╝██╔════╝\n" +
                "██████╔╝██║   ██║███████╗███████╗\n" +
                "██╔══██╗██║   ██║╚════██║╚════██║\n" +
                "██████╔╝╚██████╔╝███████║███████║\n" +
                "╚═════╝  ╚═════╝ ╚══════╝╚══════╝\n" +
                "                                 ");
        //보스는 매 턴마다 속성이 달라짐,
        int ranChar=((int)(Math.random()*3+1));
        Runnable 뮤츠=new boss(
                "뮤츠",
                10,
                10000,
                10000,
                200,
                200,
                10,
                10,
                0,
                200,
                "뮤츠의 유골",
                2000,
                100,
                10,user
        ) ;
        Battle뮤츠(user,store,(boss)뮤츠);
        return user;
    }
    User Battle뮤츠(User user,Store store,boss 뮤츠){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+뮤츠.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
        System.out.println(" 공격력         : " + 뮤츠.getAttack());
        System.out.println(" 방어력         : " + 뮤츠.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(뮤츠);
        //아머스킬쓰레드 runnable 상태 (실행대기)
        Runnable armor=new ArmorSkill(user);
        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)
        Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        //몬스터자동공격스레드
        th.start();
        game=true;
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            num=project.예외();
            switch (num){
                case 1: //일반공격
                    if(뮤츠.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            뮤츠의 HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                        뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        //쿨타임스레드
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 2: //내가 불공격
                        switch (뮤츠.getProperty()){
                            case 1:   //case 1 불뮤츠
                                skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10));
                                if(뮤츠.getDefense()<skillDamage){
                                    if(user.getRealMp()>5){
                                        user.setRealMp(user.getRealMp()-5);
                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        System.out.println(ConsoleColors.FONT_YELLOW+"같은 상성입니다"+ConsoleColors.RESET);
                                        System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                        System.out.println("");
                                        System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                        뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                        System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                        System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        Runnable a=new Action();
                                        Thread aTh=new Thread(a);
                                        aTh.start();
                                        try {
                                            aTh.join();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }else {
                                        System.out.println("MP가 부족합니다.");
                                    }
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(user.getName()+"님이 공격했습니다.");
                                }else {
                                    System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                                }
                                break;
                            case 2:    //case 2 물뮤츠 내가 불공격
                                skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10)*2/3);
                                if(뮤츠.getDefense()<skillDamage){
                                    if(user.getRealMp()>5){
                                        user.setRealMp(user.getRealMp()-5);
                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        System.out.println(ConsoleColors.FONT_YELLOW+"상성에 불리합니다"+ConsoleColors.RESET);
                                        System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                        System.out.println("");
                                        System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                        뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                        System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                        System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        Runnable a=new Action();
                                        Thread aTh=new Thread(a);
                                        aTh.start();
                                        try {
                                            aTh.join();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }else {
                                        System.out.println("MP가 부족합니다.");
                                    }
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(user.getName()+"님이 공격했습니다.");
                                }else {
                                    System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                                }
                                break;
                            case 3:  //case 3 풀뮤츠
                                skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10)*3/2);
                                if(뮤츠.getDefense()<skillDamage){
                                    if(user.getRealMp()>5){
                                        user.setRealMp(user.getRealMp()-5);
                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        System.out.println(ConsoleColors.FONT_YELLOW+"상성에 유리합니다"+ConsoleColors.RESET);
                                        System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                        System.out.println("");
                                        System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                        뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                        System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                        System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                        System.out.println("----------------------------------------------------------------------------------------------");
                                        Runnable a=new Action();
                                        Thread aTh=new Thread(a);
                                        aTh.start();
                                        try {
                                            aTh.join();
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                    }else {
                                        System.out.println("MP가 부족합니다.");
                                    }
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(user.getName()+"님이 공격했습니다.");
                                }else {
                                    System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                                }
                                break;
                        }
                    break;
                case 3: //내가 물공격
                    switch (뮤츠.getProperty()){
                        case 1:   //case 1 불뮤츠
                            skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10)*3/2);
                            if(뮤츠.getDefense()<skillDamage){
                                if(user.getRealMp()>5){
                                    user.setRealMp(user.getRealMp()-5);
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    System.out.println(ConsoleColors.FONT_YELLOW+"상성에 유리합니다"+ConsoleColors.RESET);
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                                    System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                    System.out.println("");
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    Runnable a=new Action();
                                    Thread aTh=new Thread(a);
                                    aTh.start();
                                    try {
                                        aTh.join();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    System.out.println("MP가 부족합니다.");
                                }
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                        case 2:    //case 2 물뮤츠 내가 물공격
                            skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10));
                            if(뮤츠.getDefense()<skillDamage){
                                if(user.getRealMp()>5){
                                    user.setRealMp(user.getRealMp()-5);
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    System.out.println(ConsoleColors.FONT_YELLOW+"같은 상성입니다"+ConsoleColors.RESET);
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                                    System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                    System.out.println("");
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    Runnable a=new Action();
                                    Thread aTh=new Thread(a);
                                    aTh.start();
                                    try {
                                        aTh.join();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    System.out.println("MP가 부족합니다.");
                                }
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                        case 3:  //case 3 풀뮤츠 물공격
                            skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10)*2/3);
                            if(뮤츠.getDefense()<skillDamage){
                                if(user.getRealMp()>5){
                                    user.setRealMp(user.getRealMp()-5);
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    System.out.println(ConsoleColors.FONT_YELLOW+"상성에 불리합니다"+ConsoleColors.RESET);
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                                    System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                    System.out.println("");
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    Runnable a=new Action();
                                    Thread aTh=new Thread(a);
                                    aTh.start();
                                    try {
                                        aTh.join();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    System.out.println("MP가 부족합니다.");
                                }
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                    }
                    break;
                case 4: //user 풀
                    switch (뮤츠.getProperty()){
                        case 1:   //case 1 불뮤츠 user  풀
                            skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10)*2/3);
                            if(뮤츠.getDefense()<skillDamage){
                                if(user.getRealMp()>5){
                                    user.setRealMp(user.getRealMp()-5);
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    System.out.println(ConsoleColors.FONT_YELLOW+"상성에 불리합니다"+ConsoleColors.RESET);
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                                    System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                    System.out.println("");
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    Runnable a=new Action();
                                    Thread aTh=new Thread(a);
                                    aTh.start();
                                    try {
                                        aTh.join();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    System.out.println("MP가 부족합니다.");
                                }
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                        case 2:    //case 2 물뮤츠 내가 풀공격
                            skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10)*3/2);
                            if(뮤츠.getDefense()<skillDamage){
                                if(user.getRealMp()>5){
                                    user.setRealMp(user.getRealMp()-5);
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    System.out.println(ConsoleColors.FONT_YELLOW+"상성에 유리합니다"+ConsoleColors.RESET);
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                                    System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                    System.out.println("");
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    Runnable a=new Action();
                                    Thread aTh=new Thread(a);
                                    aTh.start();
                                    try {
                                        aTh.join();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    System.out.println("MP가 부족합니다.");
                                }
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                        case 3:  //case 3 풀뮤츠 풀공격
                            skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10));
                            if(뮤츠.getDefense()<skillDamage){
                                if(user.getRealMp()>5){
                                    user.setRealMp(user.getRealMp()-5);
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    System.out.println(ConsoleColors.FONT_YELLOW+"같은 상성입니다"+ConsoleColors.RESET);
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                                    System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                                    System.out.println("");
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  : " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                    System.out.println(ConsoleColors.FONT_YELLOW+"                            뮤츠에게 입힌 데미지    : "+(뮤츠.getDefense()-skillDamage)+ConsoleColors.RESET);
                                    System.out.println("                            뮤츠의 현재HP  / 총HP  :  " + 뮤츠.getRealHp() + " / " + 뮤츠.getHp());
                                    System.out.println("----------------------------------------------------------------------------------------------");
                                    Runnable a=new Action();
                                    Thread aTh=new Thread(a);
                                    aTh.start();
                                    try {
                                        aTh.join();
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                    System.out.println("MP가 부족합니다.");
                                }
                                뮤츠.setRealHp(뮤츠.getRealHp()+(뮤츠.getDefense()-skillDamage));
                                System.out.println(user.getName()+"님이 공격했습니다.");
                            }else {
                                System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                            }
                            break;
                    }
                    break;
                case 5:
                    //체력회복스레드
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //방어력 증가 스레드
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }//내공격끝
            if(뮤츠.getRealHp()<=0){
                th.interrupt();
                System.out.println(ConsoleColors.FONT_YELLOW+"뮤츠를 처치했습니다."+ConsoleColors.RESET);
                user.setExperience(user.getExperience()+뮤츠.getMonEX(),user);
                user.getInventory().inventoryList.add(뮤츠.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+뮤츠.dropItem+" ㅣ 금화:  "+뮤츠.getDropCash()+"  ㅣ  경험치 : "+뮤츠.getMonEX()+ConsoleColors.RESET);
                game=false;
                break;
            }
        }//몬스터 자동공격스레드 종료시 진행중이던 버프스레드 모두종료
        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
            System.out.println("버프 스킬 종료");
        }
        return user;
    }
//--------------------------------------------------------------------------------------------------------------
    User 상급사냥터(User user, Store store){
        System.out.println(" " +
                "█████╗ ██████╗ ██╗   ██╗███████╗███╗   ██╗ ██████╗███████╗██████╗ \n" +
                "██╔══██╗██╔══██╗██║   ██║██╔════╝████╗  ██║██╔════╝██╔════╝██╔══██╗\n" +
                "███████║██║  ██║██║   ██║█████╗  ██╔██╗ ██║██║     █████╗  ██║  ██║\n" +
                "██╔══██║██║  ██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║     ██╔══╝  ██║  ██║\n" +
                "██║  ██║██████╔╝ ╚████╔╝ ███████╗██║ ╚████║╚██████╗███████╗██████╔╝\n" +
                "╚═╝  ╚═╝╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═══╝ ╚═════╝╚══════╝╚═════╝ \n" +
                "                                                                   ");
        game=true;
        int ranChar=((int)(Math.random()*3+1));
        switch (ranChar){
            case 1: //
                Runnable 리자몽=new Monster(
                        "리자몽",
                        7,
                        100,
                        100,
                        100,
                        100,
                        70,
                        35,
                        1,
                        70,
                        "리자몽의 꼬리",
                        500,
                        50,
                        7,
                        user
                );
                Battle리자몽(user, store,(Monster)리자몽);
                break;
            case 2:Runnable 거북왕=new Monster(
                    "거북왕",
                    7,
                    100,
                    100,
                    100,
                    100,
                    100,
                    35,
                    2,
                    70,
                    "거북왕의 등딱지",
                    500,
                    50,
                    8,
                    user
            );
                Battle거북왕(user, store,(Monster)거북왕);
                break;
            case 3:Runnable 이상해꽃=new Monster(
                    "이상해꽃",
                    7,
                    100,
                    100,
                    100,
                    100,
                    100,
                    35,
                    3,
                    70,
                    "이상해꽃의 꽃",
                    500,
                    50,
                    9,
                    user
            );
                Battle이상해꽃(user, store,(Monster)이상해꽃);
                break;
        }
        return user;
    }
    User Battle이상해꽃(User user, Store store,Monster 이상해꽃){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+이상해꽃.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
        System.out.println(" 공격력         : " + 이상해꽃.getAttack());
        System.out.println(" 방어력         : " + 이상해꽃.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(이상해꽃);
        //아머스킬쓰레드 runnable 상태 (실행대기)
        Runnable armor=new ArmorSkill(user);

        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)

        Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        th.start();

        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(th.getState()==TERMINATED){
                game=false;
            }
            num=project.예외();
            if(user.getRealHp()<0){
                game=false;
                num=0;
            }
            switch (num){
                case 0: user.userDie(user);
                    break;
                case 1: //일반공격
                    if(이상해꽃.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            이상해꽃의 HP  / 총HP  : " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
                        이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해꽃에게 입힌 데미지    : "+(이상해꽃.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            이상해꽃의 현재HP  / 총HP  :  " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                    break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10))*3/2;
                    if(이상해꽃.getDefense()<skillDamage){
                        if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            이상해꽃의 현재HP  / 총HP  : " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
                            이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해꽃에게 입힌 데미지    : "+(이상해꽃.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            이상해꽃의 현재HP  / 총HP  :  " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");

                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("MP가 부족합니다.");
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10))*2/3;
                    if(이상해꽃.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        System.out.println("                            이상해꽃의 현재HP  / 총HP  : " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
                        이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해꽃에게 입힌 데미지    : "+(이상해꽃.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            이상해꽃의 현재HP  / 총HP  :  " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10));
                    if(이상해꽃.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                        System.out.println("                            이상해꽃의 현재HP  / 총HP  : " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        이상해꽃.setRealHp(이상해꽃.getRealHp()+(이상해꽃.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해꽃에게 입힌 데미지    : "+(이상해꽃.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            이상해꽃의 현재HP  / 총HP  :  " + 이상해꽃.getRealHp() + " / " + 이상해꽃.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }
            if(이상해꽃.getRealHp()<=0){
                th.interrupt();
                System.out.println("이상해꽃를 처치했습니다.");
                user.setExperience(user.getExperience()+이상해꽃.getMonEX(),user);
                user.getInventory().inventoryList.add(이상해꽃.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+이상해꽃.dropItem+" ㅣ 금화:  "+이상해꽃.getDropCash()+"  ㅣ  경험치 : "+이상해꽃.getMonEX()+ConsoleColors.RESET);
                game=false;
                break;
            }
        }


        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
        return user;
    }
    User Battle거북왕(User user, Store store,Monster 거북왕){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+거북왕.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
        System.out.println(" 공격력         : " + 거북왕.getAttack());
        System.out.println(" 방어력         : " + 거북왕.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(거북왕);
        //아머스킬쓰레드 runnable 상태 (실행대기)
        Runnable armor=new ArmorSkill(user);
        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)
         Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        th.start();

        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(th.getState()==TERMINATED){
                game=false;
            }
            num=project.예외();
            if(user.getRealHp()<0){
                game=false;
                num=0;
            }
            switch (num){
                case 0: user.userDie(user);
                    break;
                case 1: //일반공격
                    if(거북왕.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            거북왕의 HP  / 총HP  : " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
                        거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            거북왕에게 입힌 데미지    : "+(거북왕.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            거북왕의 현재HP  / 총HP  :  " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                    break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10))*2/3;
                    if(거북왕.getDefense()<skillDamage){
                        if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            거북왕의 현재HP  / 총HP  : " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
                            거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            거북왕에게 입힌 데미지    : "+(거북왕.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            거북왕의 현재HP  / 총HP  :  " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");

                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("MP가 부족합니다.");
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10));
                    if(거북왕.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        System.out.println("                            거북왕의 현재HP  / 총HP  : " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
                        거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            거북왕에게 입힌 데미지    : "+(거북왕.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            거북왕의 현재HP  / 총HP  :  " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10))*3/2;
                    if(거북왕.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                        System.out.println("                            거북왕의 현재HP  / 총HP  : " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        거북왕.setRealHp(거북왕.getRealHp()+(거북왕.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            거북왕에게 입힌 데미지    : "+(거북왕.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            거북왕의 현재HP  / 총HP  :  " + 거북왕.getRealHp() + " / " + 거북왕.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }
            if(거북왕.getRealHp()<=0){
                th.interrupt();
                System.out.println("거북왕를 처치했습니다.");
                user.setExperience(user.getExperience()+거북왕.getMonEX(),user);
                user.getInventory().inventoryList.add(거북왕.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+거북왕.dropItem+" ㅣ 금화:  "+거북왕.getDropCash()+"  ㅣ  경험치 : "+거북왕.getMonEX()+ConsoleColors.RESET);
                game=false;
                break;
            }
        }

        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
        return user;
    }
    User Battle리자몽(User user, Store store,Monster 리자몽){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+리자몽.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
        System.out.println(" 공격력         : " + 리자몽.getAttack());
        System.out.println(" 방어력         : " + 리자몽.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(리자몽);
        //아머스킬쓰레드 runnable 상태 (실행대기)
        Runnable armor=new ArmorSkill(user);
        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)

         Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        th.start();

        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(th.getState()==TERMINATED){
                game=false;
            }
            num=project.예외();
            if(user.getRealHp()<0){
                game=false;
                num=0;
            }
            switch (num){
                case 0: user.userDie(user);
                    break;
                case 1: //일반공격
                    if(리자몽.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            리자몽의 HP  / 총HP  : " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
                        리자몽.setRealHp(리자몽.getRealHp()+(리자몽.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            리자몽에게 입힌 데미지    : "+(리자몽.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            리자몽의 현재HP  / 총HP  :  " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                    break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10));
                    if(리자몽.getDefense()<skillDamage){
                        if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            리자몽의 현재HP  / 총HP  : " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
                            리자몽.setRealHp(리자몽.getRealHp()+(리자몽.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            리자몽에게 입힌 데미지    : "+(리자몽.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            리자몽의 현재HP  / 총HP  :  " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");

                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("MP가 부족합니다.");
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10))*3/2;
                    if(리자몽.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        System.out.println("                            리자몽의 현재HP  / 총HP  : " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
                        리자몽.setRealHp(리자몽.getRealHp()+(리자몽.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            리자몽에게 입힌 데미지    : "+(리자몽.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            리자몽의 현재HP  / 총HP  :  " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10))*2/3;
                    if(리자몽.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                        System.out.println("                            리자몽의 현재HP  / 총HP  : " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        리자몽.setRealHp(리자몽.getRealHp()+(리자몽.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            리자몽에게 입힌 데미지    : "+(리자몽.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            리자몽의 현재HP  / 총HP  :  " + 리자몽.getRealHp() + " / " + 리자몽.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }
            if(리자몽.getRealHp()<=0){
                th.interrupt();
                System.out.println("리자몽를 처치했습니다.");
                user.setExperience(user.getExperience()+리자몽.getMonEX(),user);
                user.getInventory().inventoryList.add(리자몽.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+리자몽.dropItem+" ㅣ 금화:  "+리자몽.getDropCash()+"  ㅣ  경험치 : "+리자몽.getMonEX()+ConsoleColors.RESET);
                game=false;
                break;
            }
        } if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
        return user;
    }
//--------------------------------------------------------------------------------------------------------------
    User 중급사냥터(User user, Store store){
        System.out.println(
                "███████╗███████╗███╗   ██╗██╗ ██████╗ ██████╗ \n" +
                "██╔════╝██╔════╝████╗  ██║██║██╔═══██╗██╔══██╗\n" +
                "███████╗█████╗  ██╔██╗ ██║██║██║   ██║██████╔╝\n" +
                "╚════██║██╔══╝  ██║╚██╗██║██║██║   ██║██╔══██╗\n" +
                "███████║███████╗██║ ╚████║██║╚██████╔╝██║  ██║\n" +
                "╚══════╝╚══════╝╚═╝  ╚═══╝╚═╝ ╚═════╝ ╚═╝  ╚═╝\n" +
                "                                              ");
        game=true;
        int ranChar=((int)(Math.random()*3+1));
        switch (ranChar){
            case 1: //리자드
                Runnable 리자드=new Monster(
                        "리자드",
                        4,
                        70,
                        70,
                        70,
                        70,
                        70,
                        20,
                        1,
                        70,
                        "리자드의 꼬리",
                        200,
                        30,
                        4,
                        user
                );
                Battle리자드(user,store, (Monster)리자드);
                break;
            case 2:
                Runnable 어니부기=new Monster(
                        "어니부기",
                        4,
                        70,
                        70,
                        70,
                        70,
                        70,
                        20,
                        2,
                        70,
                        "어니부기의 등딱지",
                        200,
                        30,
                        5,
                        user
                );
                Battle어니부기(user, store, (Monster)어니부기);
                break;
            case 3:
                Runnable 이상해풀=new Monster(
                        "이상해풀",
                        4,
                        70,
                        70,
                        70,
                        70,
                        70,
                        20,
                        3,
                        70,
                        "이상해풀의 풀입",
                        200,
                        30,
                        6,
                        user
                );
                Battle이상해풀(user, store, (Monster)이상해풀);
                break;
        }

        return user;
    }
    User Battle이상해풀(User user,Store store,Monster 이상해풀){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+이상해풀.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
        System.out.println(" 공격력         : " + 이상해풀.getAttack());
        System.out.println(" 방어력         : " + 이상해풀.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(이상해풀);
        //아머스킬쓰레드 runnable 상태 (실행대기)
        Runnable armor=new ArmorSkill(user);
        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)

         Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        th.start();

        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(th.getState()==TERMINATED){
                game=false;
            }
            num=project.예외();
            if(user.getRealHp()<0){
                game=false;
                num=0;
            }
            switch (num){
                case 0: user.userDie(user);
                    break;
                case 1: //일반공격
                    if(이상해풀.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            이상해풀의 HP  / 총HP  : " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
                        이상해풀.setRealHp(이상해풀.getRealHp()+(이상해풀.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해풀에게 입힌 데미지    : "+(이상해풀.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            이상해풀의 현재HP  / 총HP  :  " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                    break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10))*3/2;
                    if(이상해풀.getDefense()<skillDamage){
                        if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            이상해풀의 현재HP  / 총HP  : " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
                            이상해풀.setRealHp(이상해풀.getRealHp()+(이상해풀.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해풀에게 입힌 데미지    : "+(이상해풀.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            이상해풀의 현재HP  / 총HP  :  " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");

                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("MP가 부족합니다.");
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10))*2/3;
                    if(이상해풀.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        System.out.println("                            이상해풀의 현재HP  / 총HP  : " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
                        이상해풀.setRealHp(이상해풀.getRealHp()+(이상해풀.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해풀에게 입힌 데미지    : "+(이상해풀.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            이상해풀의 현재HP  / 총HP  :  " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10));
                    if(이상해풀.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                        System.out.println("                            이상해풀의 현재HP  / 총HP  : " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        이상해풀.setRealHp(이상해풀.getRealHp()+(이상해풀.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해풀에게 입힌 데미지    : "+(이상해풀.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            이상해풀의 현재HP  / 총HP  :  " + 이상해풀.getRealHp() + " / " + 이상해풀.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }
            if(이상해풀.getRealHp()<=0){
                th.interrupt();
                System.out.println("이상해풀를 처치했습니다.");
                user.setExperience(user.getExperience()+이상해풀.getMonEX(),user);
                user.getInventory().inventoryList.add(이상해풀.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+이상해풀.dropItem+" ㅣ 금화:  "+이상해풀.getDropCash()+"  ㅣ  경험치 : "+이상해풀.getMonEX()+ConsoleColors.RESET);
                game=false;
                break;
            }
        }
        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
        return user;
    }
    User Battle리자드(User user, Store store, Monster 리자드){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+리자드.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 리자드.getRealHp() + " / " + 리자드.getHp());
        System.out.println(" 공격력         : " + 리자드.getAttack());
        System.out.println(" 방어력         : " + 리자드.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(리자드);
        //아머스킬쓰레드 runnable 상태 (실행대기)

        Runnable armor=new ArmorSkill(user);
        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)

         Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        th.start();

        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(th.getState()==TERMINATED){
                game=false;
            }
            num=project.예외();
            if(user.getRealHp()<0){
                game=false;
                num=0;
            }
            switch (num){
                case 0: user.userDie(user);
                    break;
                case 1: //일반공격
                    if(리자드.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            리자드의 HP  / 총HP  : " + 리자드.getRealHp() + " / " + 리자드.getHp());
                        리자드.setRealHp(리자드.getRealHp()+(리자드.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            리자드에게 입힌 데미지    : "+(리자드.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            리자드의 현재HP  / 총HP  :  " + 리자드.getRealHp() + " / " + 리자드.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                    break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10));
                    if(리자드.getDefense()<skillDamage){
                        if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            리자드의 현재HP  / 총HP  : " + 리자드.getRealHp() + " / " + 리자드.getHp());
                            리자드.setRealHp(리자드.getRealHp()+(리자드.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            리자드에게 입힌 데미지    : "+(리자드.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            리자드의 현재HP  / 총HP  :  " + 리자드.getRealHp() + " / " + 리자드.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");

                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("MP가 부족합니다.");
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10))*3/2;
                    if(리자드.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        System.out.println("                            리자드의 현재HP  / 총HP  : " + 리자드.getRealHp() + " / " + 리자드.getHp());
                        리자드.setRealHp(리자드.getRealHp()+(리자드.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            리자드에게 입힌 데미지    : "+(리자드.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            리자드의 현재HP  / 총HP  :  " + 리자드.getRealHp() + " / " + 리자드.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10))*2/3;
                    if(리자드.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                        System.out.println("                            리자드의 현재HP  / 총HP  : " + 리자드.getRealHp() + " / " + 리자드.getHp());
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        리자드.setRealHp(리자드.getRealHp()+(리자드.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            리자드에게 입힌 데미지    : "+(리자드.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            리자드의 현재HP  / 총HP  :  " + 리자드.getRealHp() + " / " + 리자드.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }
            if(리자드.getRealHp()<=0){
                th.interrupt();
                System.out.println("리자드를 처치했습니다.");
                user.setExperience(user.getExperience()+리자드.getMonEX(),user);
                user.getInventory().inventoryList.add(리자드.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+리자드.dropItem+" ㅣ 금화:  "+리자드.getDropCash()+"  ㅣ  경험치 : "+리자드.getMonEX()+ConsoleColors.RESET);
                game=false;
                break;
            }
        }
        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
        return user;
    }
    User Battle어니부기(User user,Store store,Monster 어니부기){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+어니부기.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
        System.out.println(" 공격력         : " + 어니부기.getAttack());
        System.out.println(" 방어력         : " + 어니부기.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(어니부기);
        //아머스킬쓰레드 runnable 상태 (실행대기)
        Runnable armor=new ArmorSkill(user);
        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)

         Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        th.start();

        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(th.getState()==TERMINATED){
                game=false;
            }
            num=project.예외();
            if(user.getRealHp()<0){
                game=false;
                num=0;
            }
            switch (num){
                case 0: user.userDie(user);
                    break;
                case 1: //일반공격
                    if(어니부기.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            어니부기의 HP  / 총HP  : " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
                        어니부기.setRealHp(어니부기.getRealHp()+(어니부기.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            어니부기에게 입힌 데미지    : "+(어니부기.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            어니부기의 현재HP  / 총HP  :  " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                    break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10))*2/3;
                    if(어니부기.getDefense()<skillDamage){
                        if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            어니부기의 현재HP  / 총HP  : " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
                            어니부기.setRealHp(어니부기.getRealHp()+(어니부기.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            어니부기에게 입힌 데미지    : "+(어니부기.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            어니부기의 현재HP  / 총HP  :  " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");

                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("MP가 부족합니다.");
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10));
                    if(어니부기.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        System.out.println("                            어니부기의 현재HP  / 총HP  : " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
                        어니부기.setRealHp(어니부기.getRealHp()+(어니부기.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            어니부기에게 입힌 데미지    : "+(어니부기.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            어니부기의 현재HP  / 총HP  :  " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10))*3/2;
                    if(어니부기.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                        System.out.println("                            어니부기의 현재HP  / 총HP  : " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        어니부기.setRealHp(어니부기.getRealHp()+(어니부기.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            어니부기에게 입힌 데미지    : "+(어니부기.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            어니부기의 현재HP  / 총HP  :  " + 어니부기.getRealHp() + " / " + 어니부기.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }
            if(어니부기.getRealHp()<=0){
                th.interrupt();
                System.out.println("어니부기를 처치했습니다.");
                user.setExperience(user.getExperience()+어니부기.getMonEX(),user);
                user.getInventory().inventoryList.add(어니부기.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+어니부기.dropItem+" ㅣ 금화:  "+어니부기.getDropCash()+"  ㅣ  경험치 : "+어니부기.getMonEX()+ConsoleColors.RESET);
                game=false;
                break;
            }
        }
        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
        return user;
    }
//--------------------------------------------------------------------------------------------------------------
    User 초급사냥터(User user, Store store){
        System.out.println("" +
                "██████╗ ███████╗ ██████╗ ██╗███╗   ██╗███╗   ██╗███████╗██████╗ \n" +
                "██╔══██╗██╔════╝██╔════╝ ██║████╗  ██║████╗  ██║██╔════╝██╔══██╗\n" +
                "██████╔╝█████╗  ██║  ███╗██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝\n" +
                "██╔══██╗██╔══╝  ██║   ██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗\n" +
                "██████╔╝███████╗╚██████╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║\n" +
                "╚═════╝ ╚══════╝ ╚═════╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝\n" +
                "                                                                ");
        game=true;
    int ranChar=((int)(Math.random()*3+1));

    switch (ranChar){ //속성 1 파이리 , 2꼬북이  3이상해씨
        case 1:
            Runnable 파이리=new Monster(
                    "파이리",
                    3,
                    50,
                    50,
                    30,
                    30,
                    30,
                    10,
                    1,
                    30,
                    "파이리의 꼬리",
                    100,
                    20,
                    1
                    ,user
            );
         Battle파이리(user,store, (Monster) 파이리);
            break;
        case 2:Runnable 꼬북이=new Monster(
                "꼬북이",
                3,
                50,
                50,
                30,
                30,
                30,
                10,
                2,
                30,
                "꼬북이의 등딱지",
                100,
                20,
                2,
                user
        );
         Battle꼬북이(user,store, (Monster)꼬북이);
            break;
        case 3:Runnable 이상해씨=new Monster(
                "이상해씨",
                3,
                50,
                50,
                30,
                30,
                30,
                10,
                3,
                30,
                "이상해씨의 씨앗",
                100,
                20,
                3,
                user
        );
            Battle이상해씨(user,store, (Monster)이상해씨);
            break;
    }
    return user;
    } //switch
    User Battle파이리(User user, Store store,Monster 파이리){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+파이리.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 파이리.getRealHp() + " / " + 파이리.getHp());
        System.out.println(" 공격력         : " + 파이리.getAttack());
        System.out.println(" 방어력         : " + 파이리.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(파이리);
        //아머스킬쓰레드 runnable 상태 (실행대기)

        Runnable armor=new ArmorSkill(user);
        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)
         Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        th.start();

        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(th.getState()==TERMINATED){
                game=false;
            }
            num=project.예외();
            if(user.getRealHp()<0){
                game=false;
                num=0;
            }
            switch (num){
                case 0: user.userDie(user);
                    break;
                case 1: //일반공격
                    if(파이리.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            파이리의 HP  / 총HP  : " + 파이리.getRealHp() + " / " + 파이리.getHp());
                        파이리.setRealHp(파이리.getRealHp()+(파이리.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            파이리에게 입힌 데미지    : "+(파이리.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            파이리의 현재HP  / 총HP  :  " + 파이리.getRealHp() + " / " + 파이리.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                    break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10));
                    if(파이리.getDefense()<skillDamage){
                        if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            파이리의 현재HP  / 총HP  : " + 파이리.getRealHp() + " / " + 파이리.getHp());
                            파이리.setRealHp(파이리.getRealHp()+(파이리.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            파이리에게 입힌 데미지    : "+(파이리.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            파이리의 현재HP  / 총HP  :  " + 파이리.getRealHp() + " / " + 파이리.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");

                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("MP가 부족합니다.");
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10))*3/2;
                    if(파이리.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        System.out.println("                            파이리의 현재HP  / 총HP  : " + 파이리.getRealHp() + " / " + 파이리.getHp());
                        파이리.setRealHp(파이리.getRealHp()+(파이리.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            파이리에게 입힌 데미지    : "+(파이리.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            파이리의 현재HP  / 총HP  :  " + 파이리.getRealHp() + " / " + 파이리.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10))*2/3;
                    if(파이리.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                        System.out.println("                            파이리의 현재HP  / 총HP  : " + 파이리.getRealHp() + " / " + 파이리.getHp());
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        파이리.setRealHp(파이리.getRealHp()+(파이리.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            파이리에게 입힌 데미지    : "+(파이리.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            파이리의 현재HP  / 총HP  :  " + 파이리.getRealHp() + " / " + 파이리.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }
            if(파이리.getRealHp()<=0){
                th.interrupt();
                System.out.println("파이리를 처치했습니다.");
                user.setExperience(user.getExperience()+파이리.getMonEX(),user);
                user.getInventory().inventoryList.add(파이리.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+파이리.dropItem+" ㅣ 금화:  "+파이리.getDropCash()+"  ㅣ  경험치 : "+파이리.getMonEX()+ConsoleColors.RESET);
                game=false;
                break;
            }
        }
        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
        return user;
    }
    User Battle꼬북이(User user, Store store,Monster 꼬북이){
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println(ConsoleColors.FONT_RED+꼬북이.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
            System.out.println("현재HP  / 총HP  : " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
            System.out.println(" 공격력         : " + 꼬북이.getAttack());
            System.out.println(" 방어력         : " + 꼬북이.getDefense());
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
            System.out.println("");
            Thread th=new Thread(꼬북이);
            //아머스킬쓰레드 runnable 상태 (실행대기)
            Runnable armor=new ArmorSkill(user);
            Thread armorTh=new Thread(armor);
            //스킬쓰레드 runnable 상태 (실행대기)
             Runnable hp=new HpSkill(user);
            Thread hpTh=new Thread(hp);
            th.start();
            while (game) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                if(th.getState()==TERMINATED){
                    System.out.println("터미네이티드");
                    game=false;
                }
                num=project.예외();
                if(user.getRealHp()<0){
                    game=false;
                    num=0;
                }
                switch (num){
                    case 0: user.userDie(user);
                        break;
                    case 1: //일반공격
                        if(꼬북이.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                            System.out.println("                            꼬북이의 HP  / 총HP  : " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
                            꼬북이.setRealHp(꼬북이.getRealHp()+(꼬북이.getDefense()-user.getPower()));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            꼬북이에게 입힌 데미지    : "+(꼬북이.getDefense()-user.getPower())+ConsoleColors.RESET);
                            System.out.println("                            꼬북이의 현재HP  / 총HP  :  " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                        break;
                    case 2://불공격
                        ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                        skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10))*2/3;
                        if(꼬북이.getDefense()<skillDamage){
                            if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            꼬북이의 현재HP  / 총HP  : " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
                            꼬북이.setRealHp(꼬북이.getRealHp()+(꼬북이.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            꼬북이에게 입힌 데미지    : "+(꼬북이.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            꼬북이의 현재HP  / 총HP  :  " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");
                                Runnable a=new Action();
                                Thread aTh=new Thread(a);
                                aTh.start();
                                try {
                                    aTh.join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }else {
                                System.out.println("MP가 부족합니다.");
                            }
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 3: //물공격
                        skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10));
                        if(꼬북이.getDefense()<skillDamage){
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            꼬북이의 현재HP  / 총HP  : " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
                            꼬북이.setRealHp(꼬북이.getRealHp()+(꼬북이.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            꼬북이에게 입힌 데미지    : "+(꼬북이.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            꼬북이의 현재HP  / 총HP  :  " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");
                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 4: //풀공격
                        skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10))*3/2;
                        if(꼬북이.getDefense()<skillDamage){
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                            System.out.println("                            꼬북이의 현재HP  / 총HP  : " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            꼬북이.setRealHp(꼬북이.getRealHp()+(꼬북이.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            꼬북이에게 입힌 데미지    : "+(꼬북이.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            꼬북이의 현재HP  / 총HP  :  " + 꼬북이.getRealHp() + " / " + 꼬북이.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");
                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                        }
                        break;
                    case 5:
                        if(hpTh.getState()==NEW){
                            hpTh.start();
                            break;
                        }
                        if(hpTh.getState()==TERMINATED){
                            hpTh=new Thread(hp);
                            hpTh.start();
                            break;
                        }
                        if(hpTh.getState()==TIMED_WAITING){
                            System.out.println("--------------------------------------------------------------------------------------");
                            System.out.println("");
                            System.out.println("스킬이 실행중입니다다.");
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------------");
                           break;
                        }else {
                        }
                        break;
                    case 6:
                        //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                        System.out.println("-----------------------------------------------------------------------");
                        System.out.println("                                        스킬종료!!");
                        System.out.println("-----------------------------------------------------------------------");
                        break;
                    case 7:
                        user.getInventory().listView(user,store);
                        break;
                    case 8:
                        game=false;
                        th.interrupt();
                        return user;
                }
                if(꼬북이.getRealHp()<=0){
                    th.interrupt();
                    System.out.println("꼬북이를 처치했습니다.");
                    user.setExperience(user.getExperience()+꼬북이.getMonEX(),user);
                    user.getInventory().inventoryList.add(꼬북이.dropItem);
                    user.getInventory().setCash(user.getInventory().getCash()+100);
                    System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+꼬북이.dropItem+" ㅣ 금화:  "+꼬북이.getDropCash()+"  ㅣ  경험치 : "+꼬북이.getMonEX()+ConsoleColors.RESET);
                    game=false;
                    break;
                }
            }
        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
            return user;
        }
    User Battle이상해씨(User user, Store store,Monster 이상해씨){
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_RED+이상해씨.getName()+"와 전투를 합니다"+ConsoleColors.RESET);
        System.out.println("현재HP  / 총HP  : " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
        System.out.println(" 공격력         : " + 이상해씨.getAttack());
        System.out.println(" 방어력         : " + 이상해씨.getDefense());
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+user.getName()+"님의       현재HP  / 총HP  : " + user.getRealHp() + " / " + user.getHp()+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_YELLOW+"                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp()+ConsoleColors.RESET);
        System.out.println("");
        Thread th=new Thread(이상해씨);
        //아머스킬쓰레드 runnable 상태 (실행대기)

        Runnable armor=new ArmorSkill(user);
        Thread armorTh=new Thread(armor);
        //스킬쓰레드 runnable 상태 (실행대기)
         Runnable hp=new HpSkill(user);
        Thread hpTh=new Thread(hp);
        th.start();
        while (game) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("ㅣ  1.일반공격  ㅣ    2.화염발사    ㅣ  3. 물대포    ㅣ  4.나뭇잎날리기    ㅣ  5.체력회복    ㅣ  6.방어력증가    ㅣ    7.포션 및 장비교환    ㅣ    8.도망가기    ㅣ");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            if(th.getState()==TERMINATED){
                game=false;
            }
            num=project.예외();
            if(user.getRealHp()<0){
                game=false;
                num=0;
            }
            switch (num){
                case 0: user.userDie(user);
                    break;
                case 1: //일반공격
                    if(이상해씨.getDefense()-user.getPower()<0){ //양수가 되면 안됌
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 일반공격!!!"+ConsoleColors.RESET);
                        System.out.println("                            이상해씨의 HP  / 총HP  : " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
                        이상해씨.setRealHp(이상해씨.getRealHp()+(이상해씨.getDefense()-user.getPower()));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해씨에게 입힌 데미지    : "+(이상해씨.getDefense()-user.getPower())+ConsoleColors.RESET);
                        System.out.println("                            이상해씨의 현재HP  / 총HP  :  " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        //new Th1(시간 쿨타임 start();
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("상대의 방어력이 높아 타격을 줄 수 없습니다");                    }
                    break;
                case 2://불공격
                    ///현재 데미지+(현재데미지* 스킬포인트/10 ) * 3/2(상성)
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getFire()/10))*3/2;
                    if(이상해씨.getDefense()<skillDamage){
                        if(user.getRealMp()>5){
                            user.setRealMp(user.getRealMp()-5);
                            System.out.println("----------------------------------------------------------------------------------------------");
                            System.out.println(ConsoleColors.FONT_YELLOW+"                   mp -5      "+user.getName()+"님의 화염발사!!!"+ConsoleColors.RESET);
                            System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                            System.out.println("");
                            System.out.println("                            이상해씨의 현재HP  / 총HP  : " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
                            이상해씨.setRealHp(이상해씨.getRealHp()+(이상해씨.getDefense()-skillDamage));
                            System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해씨에게 입힌 데미지    : "+(이상해씨.getDefense()-skillDamage)+ConsoleColors.RESET);
                            System.out.println("                            이상해씨의 현재HP  / 총HP  :  " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
                            System.out.println("----------------------------------------------------------------------------------------------");

                            Runnable a=new Action();
                            Thread aTh=new Thread(a);
                            aTh.start();
                            try {
                                aTh.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else {
                            System.out.println("MP가 부족합니다.");
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 3: //물공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getWater()/10))*2/3;
                    if(이상해씨.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 물대포!!!"+ConsoleColors.RESET);
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        System.out.println("                            이상해씨의 현재HP  / 총HP  : " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
                        이상해씨.setRealHp(이상해씨.getRealHp()+(이상해씨.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해씨에게 입힌 데미지    : "+(이상해씨.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            이상해씨의 현재HP  / 총HP  :  " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 4: //풀공격
                    skillDamage=(user.getPower()+ (user.getPower())*(user.getSkills().getForest()/10));
                    if(이상해씨.getDefense()<skillDamage){
                        System.out.println("----------------------------------------------------------------------------------------------");
                        System.out.println(ConsoleColors.FONT_YELLOW+"                             "+user.getName()+"님의 나뭇잎날리기!!!"+ConsoleColors.RESET);
                        System.out.println("                            이상해씨의 현재HP  / 총HP  : " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
                        System.out.println("                 현재MP  / 총MP  : " + user.getRealMp() + " / " + user.getMp());
                        System.out.println("");
                        이상해씨.setRealHp(이상해씨.getRealHp()+(이상해씨.getDefense()-skillDamage));
                        System.out.println(ConsoleColors.FONT_YELLOW+"                            이상해씨에게 입힌 데미지    : "+(이상해씨.getDefense()-skillDamage)+ConsoleColors.RESET);
                        System.out.println("                            이상해씨의 현재HP  / 총HP  :  " + 이상해씨.getRealHp() + " / " + 이상해씨.getHp());
                        System.out.println("----------------------------------------------------------------------------------------------");
                        Runnable a=new Action();
                        Thread aTh=new Thread(a);
                        aTh.start();
                        try {
                            aTh.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("포켓몬의 방어력이 높아 타격을 줄 수 없습니다");
                    }
                    break;
                case 5:
                    if(hpTh.getState()==NEW){
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TERMINATED){
                        hpTh=new Thread(hp);
                        hpTh.start();
                        break;
                    }
                    if(hpTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다다.");
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    break;
                case 6:
                    //running
                    if(armorTh.getState()==NEW){
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TERMINATED){
                        armorTh=new Thread(armor);
                        armorTh.start();
                        break;
                    }
                    if(armorTh.getState()==TIMED_WAITING){
                        System.out.println("--------------------------------------------------------------------------------------");
                        System.out.println("");
                        System.out.println("스킬이 실행중입니다.");

                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;
                    }else {
                    }
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("                                        스킬종료!!");
                    System.out.println("-----------------------------------------------------------------------");
                    break;
                case 7:
                    user.getInventory().listView(user,store);
                    break;
                case 8:
                    game=false;
                    th.interrupt();
                    return user;
            }
            if(이상해씨.getRealHp()<=0){
                th.interrupt();
                System.out.println("이상해씨를 처치했습니다.");
                user.setExperience(user.getExperience()+이상해씨.getMonEX(),user);
                user.getInventory().inventoryList.add(이상해씨.dropItem);
                user.getInventory().setCash(user.getInventory().getCash()+100);
                if(afternoon==true){
                    System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+이상해씨.dropItem+" ㅣ 금화:  "+이상해씨.getDropCash()+"  ㅣ  경험치 : "+이상해씨.getMonEX()+ConsoleColors.RESET);
                }else {
                    System.out.println(ConsoleColors.FONT_YELLOW+"보상아이템 :  "+이상해씨.dropItem+" ㅣ 금화:  "+이상해씨.getDropCash()*2+"  ㅣ  경험치 : "+이상해씨.getMonEX()*2+ConsoleColors.RESET);
                    System.out.println(ConsoleColors.FONT_YELLOW+"밤에는 경험치와 보상아이템이 2배입니다!!!"+ConsoleColors.RESET);
                }
                game=false;
                break;
            }else{
            }
        }
        if(th.getState()==TERMINATED){
            hpTh.interrupt();
            armorTh.interrupt();
        }
        return user;
    }
//--------------------------------------------------------------------------------------------------------------
}

