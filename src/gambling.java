import java.util.Scanner;
import static java.lang.Thread.State.TERMINATED;
public class gambling {
    //랜덤몬스터객체 생성 둘중하나에 배팅을 건다, 배팅한 몬스터가 승리하면 2배, 지면 돈을 잃음 게임비가 든다.
    // 필요한것 : 제한시간, 몬스터객체생성 ,결과값 or 배팅값 반환변수
    int random=0;
    int num=0;
    int batNum=0;
    int batCash=0;
    boolean 결과=true;
    Runnable myMonster=null;
    Runnable vsMonster = null;
    User user;
    Inventory inventory;
    Scanner sc=new Scanner(System.in);
    public gambling(User user) {
        this.user = user;
    }
    void 입장() {
        System.out.println("" +
                "██████╗  ██████╗ ██╗  ██╗███████╗███╗   ███╗ ██████╗ ███╗   ██╗     █████╗ ██████╗ ███████╗███╗   ██╗ █████╗ \n" +
                "██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝████╗ ████║██╔═══██╗████╗  ██║    ██╔══██╗██╔══██╗██╔════╝████╗  ██║██╔══██╗\n" +
                "██████╔╝██║   ██║█████╔╝ █████╗  ██╔████╔██║██║   ██║██╔██╗ ██║    ███████║██████╔╝█████╗  ██╔██╗ ██║███████║\n" +
                "██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║╚██╔╝██║██║   ██║██║╚██╗██║    ██╔══██║██╔══██╗██╔══╝  ██║╚██╗██║██╔══██║\n" +
                "██║     ╚██████╔╝██║  ██╗███████╗██║ ╚═╝ ██║╚██████╔╝██║ ╚████║    ██║  ██║██║  ██║███████╗██║ ╚████║██║  ██║\n" +
                "╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝    ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝╚═╝  ╚═╝\n" +
                " ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  게임장입니다. 포켓몬을 선택하면 랜덤으로 생성된 다른 포켓몬들과 결투를 합니다.        ㅣ");
        System.out.println("ㅣ  전투에 승리할 포켓몬을 예측하고, 예측에 성공하면 배팅했던 금화에 2배를 획득합니다.    ㅣ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ     1. 진행한다.    ㅣ    2. 돌아가기    |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        num=project.예외();
        if(num==1){
            진행();
        }else {
        }
    }
    void 진행(){ //view 선수목록
        while (true){
            System.out.println("" +
                    " ██████╗██╗  ██╗ ██████╗  ██████╗ ███████╗███████╗    ██████╗  ██████╗ ██╗  ██╗███████╗███╗   ███╗ ██████╗ ███╗   ██╗\n" +
                    "██╔════╝██║  ██║██╔═══██╗██╔═══██╗██╔════╝██╔════╝    ██╔══██╗██╔═══██╗██║ ██╔╝██╔════╝████╗ ████║██╔═══██╗████╗  ██║\n" +
                    "██║     ███████║██║   ██║██║   ██║███████╗█████╗      ██████╔╝██║   ██║█████╔╝ █████╗  ██╔████╔██║██║   ██║██╔██╗ ██║\n" +
                    "██║     ██╔══██║██║   ██║██║   ██║╚════██║██╔══╝      ██╔═══╝ ██║   ██║██╔═██╗ ██╔══╝  ██║╚██╔╝██║██║   ██║██║╚██╗██║\n" +
                    "╚██████╗██║  ██║╚██████╔╝╚██████╔╝███████║███████╗    ██║     ╚██████╔╝██║  ██╗███████╗██║ ╚═╝ ██║╚██████╔╝██║ ╚████║\n" +
                    " ╚═════╝╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚══════╝╚══════╝    ╚═╝      ╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                    "                                                                                                                     ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  포켓몬을 선택합니다.        ㅣ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print(ConsoleColors.FONT_RED+"ㅣ     1. 리자몽.    "+ConsoleColors.RESET);
        System.out.print(ConsoleColors.FONT_BLUE+"ㅣ     2. 거북왕.    "+ConsoleColors.RESET);
        System.out.println(ConsoleColors.FONT_GREEN+"ㅣ     3. 이상해꽃.    |"+ConsoleColors.RESET);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            batNum=project.예외(); //1,2,3 만 들어와야함
            if(batNum<4 &&batNum>0){
                배팅금액();
                break;
            }else {
                System.out.println(ConsoleColors.FONT_YELLOW+"보기에 있는 숫자를 누르세요"+ConsoleColors.RESET);
            }
        }
    }
    void 배팅금액(){
        System.out.println("" +
                "██╗  ██╗ ██████╗ ██╗    ██╗    ███╗   ███╗██╗   ██╗ ██████╗██╗  ██╗     ██████╗  ██████╗ ██╗     ██████╗     ██████╗ ██████╗ \n" +
                "██║  ██║██╔═══██╗██║    ██║    ████╗ ████║██║   ██║██╔════╝██║  ██║    ██╔════╝ ██╔═══██╗██║     ██╔══██╗    ╚════██╗╚════██╗\n" +
                "███████║██║   ██║██║ █╗ ██║    ██╔████╔██║██║   ██║██║     ███████║    ██║  ███╗██║   ██║██║     ██║  ██║      ▄███╔╝  ▄███╔╝\n" +
                "██╔══██║██║   ██║██║███╗██║    ██║╚██╔╝██║██║   ██║██║     ██╔══██║    ██║   ██║██║   ██║██║     ██║  ██║      ▀▀══╝   ▀▀══╝ \n" +
                "██║  ██║╚██████╔╝╚███╔███╔╝    ██║ ╚═╝ ██║╚██████╔╝╚██████╗██║  ██║    ╚██████╔╝╚██████╔╝███████╗██████╔╝      ██╗     ██╗   \n" +
                "╚═╝  ╚═╝ ╚═════╝  ╚══╝╚══╝     ╚═╝     ╚═╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝     ╚═════╝  ╚═════╝ ╚══════╝╚═════╝       ╚═╝     ╚═╝   \n" +
                "                                                                                                                             ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(ConsoleColors.FONT_YELLOW+"ㅣ          배팅할 금액을 입력하시오.         현재 금화 : "+user.getInventory().getCash()+"     ㅣ"+ConsoleColors.RESET);
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        batCash=project.예외();
        if(user.getInventory().getCash()>0&&user.getInventory().getCash()>=batCash){
            user.getInventory().setCash(user.getInventory().getCash()-batCash);
            System.out.println(ConsoleColors.FONT_YELLOW+" 배팅금액 : "+batCash+"현재 금화 : "+user.getInventory().getCash()+ConsoleColors.RESET);
            choose포켓몬();
            랜덤포켓몬();
            view(choose포켓몬(),랜덤포켓몬());
        }else {
            System.out.println("금화가 부족합니다.");
        }
    }
    Monster choose포켓몬(){
        int myDamage=((int)(Math.random()*10+1));
        int myDefense=((int)(Math.random()*5+1));
        switch (batNum){
            case 1://리자몽
                myMonster = new Monster(
                        "리자몽",
                        100,
                        100,
                        100,
                        100,
                        myDamage,
                        myDefense,
                        1,
                        1,user
                );
                break;
            case 2://거북왕
                myMonster = new Monster(
                        "거북왕",
                        100,
                        100,
                        100,
                        100,
                        myDamage,
                        myDefense,
                        2,
                        1,user
                );
                break;
            case 3://이상해꽃
                myMonster = new Monster(
                        "이상해꽃",
                        100,
                        100,
                        100,
                        100,
                        myDamage,
                        myDefense,
                        3,
                        1,user
                );
                break;
        }
        return (Monster) myMonster;
    }
    Monster 랜덤포켓몬(){
        random=((int)(Math.random()*3+1));
        int comDamage=((int)(Math.random()*10+1));
        int comDefense=((int)(Math.random()*5+1));
        switch (random){
            case 1://리자몽
                vsMonster = new Monster(
                        "리자몽",
                        100,
                        100,
                        100,
                        100,
                        comDamage,
                        comDefense,
                        1,
                        2,user
                );
                break;
            case 2://거북왕
                vsMonster = new Monster(
                        "거북왕",
                        100,
                        100,
                        100,
                        100,
                        comDamage,
                        comDefense,
                        2,
                        2,user
                );
                break;
            case 3://이상해꽃
                vsMonster = new Monster(
                        "이상해꽃",
                        100,
                        100,
                        100,
                        100,
                        comDamage,
                        comDefense,
                        3,
                        2,user
                );
                break;
        }

        return (Monster) vsMonster;
    }
    void view(Monster myMonster,Monster vsMonster){
        System.out.println("" +
                "██████╗  █████╗ ████████╗████████╗██╗     ███████╗\n" +
                "██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝\n" +
                "██████╔╝███████║   ██║      ██║   ██║     █████╗  \n" +
                "██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝  \n" +
                "██████╔╝██║  ██║   ██║      ██║   ███████╗███████╗\n" +
                "╚═════╝ ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚══════╝╚══════╝\n" +
                "                                                  ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("ㅣ "+ConsoleColors.FONT_YELLOW+"(pick) "+ConsoleColors.RESET+myMonster.getName()+"        VS ");System.out.println("     "+vsMonster.getName()+"    |   시작하기 : Enter  ");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        sc.nextLine();
        myMonster.setMonster((Monster) this.vsMonster);
        vsMonster.setMonster((Monster) this.myMonster);
        시작(myMonster,vsMonster);
    }
    void 시작(Monster myMonster,Monster vsMonster){
        System.out.println("" +
                "███████╗██╗ ██████╗ ██╗  ██╗████████╗██╗██╗██╗\n" +
                "██╔════╝██║██╔════╝ ██║  ██║╚══██╔══╝██║██║██║\n" +
                "█████╗  ██║██║  ███╗███████║   ██║   ██║██║██║\n" +
                "██╔══╝  ██║██║   ██║██╔══██║   ██║   ╚═╝╚═╝╚═╝\n" +
                "██║     ██║╚██████╔╝██║  ██║   ██║   ██╗██╗██╗\n" +
                "╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝╚═╝╚═╝\n" +
                "                                              ");
        Thread pickTh=new Thread(myMonster);
        Thread opponentTh=new Thread(vsMonster);
        Runnable limit=new questTime(user,pickTh,opponentTh);
        Thread TimeTh=new Thread(limit);
        user.set유저모드(2);
        //투기장 시간스레드 시작
        TimeTh.start();
        //
        while(true){
            if(TimeTh.getState()==TERMINATED){
                break;
                // 두개의 포켓몬 스레드중 하나종료되면 나머지 시간,포켓몬스레드종료
            }if(pickTh.getState()==TERMINATED){
                TimeTh.interrupt();
                opponentTh.interrupt();
                break;
            }if(opponentTh.getState()==TERMINATED){
                TimeTh.interrupt();
                pickTh.interrupt();
                break;
            }
        }
        if(myMonster.getRealHp()>vsMonster.getRealHp()){결과=true;}
        else {결과=false;}
        결과();
    }
    void 결과(){
        user.set유저모드(0);
        System.out.println("" +
                "███╗   ███╗ █████╗ ████████╗ ██████╗██╗  ██╗    ██████╗ ███████╗███████╗██╗   ██╗██╗  ████████╗\n" +
                "████╗ ████║██╔══██╗╚══██╔══╝██╔════╝██║  ██║    ██╔══██╗██╔════╝██╔════╝██║   ██║██║  ╚══██╔══╝\n" +
                "██╔████╔██║███████║   ██║   ██║     ███████║    ██████╔╝█████╗  ███████╗██║   ██║██║     ██║   \n" +
                "██║╚██╔╝██║██╔══██║   ██║   ██║     ██╔══██║    ██╔══██╗██╔══╝  ╚════██║██║   ██║██║     ██║   \n" +
                "██║ ╚═╝ ██║██║  ██║   ██║   ╚██████╗██║  ██║    ██║  ██║███████╗███████║╚██████╔╝███████╗██║   \n" +
                "╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝    ╚═════╝╚═╝  ╚═╝    ╚═╝  ╚═╝╚══════╝╚══════╝ ╚═════╝ ╚══════╝╚═╝   \n" +
                "                                                                                               ");
        if(결과==true){
            System.out.println("" +
                    "███████╗██╗   ██╗ ██████╗ ██████╗███████╗███████╗███████╗██╗██╗\n" +
                    "██╔════╝██║   ██║██╔════╝██╔════╝██╔════╝██╔════╝██╔════╝██║██║\n" +
                    "███████╗██║   ██║██║     ██║     █████╗  ███████╗███████╗██║██║\n" +
                    "╚════██║██║   ██║██║     ██║     ██╔══╝  ╚════██║╚════██║╚═╝╚═╝\n" +
                    "███████║╚██████╔╝╚██████╗╚██████╗███████╗███████║███████║██╗██╗\n" +
                    "╚══════╝ ╚═════╝  ╚═════╝ ╚═════╝╚══════╝╚══════╝╚══════╝╚═╝╚═╝\n" +
                    "                                                               ");
            user.getInventory().setCash(user.getInventory().getCash()+batCash*2);
            System.out.println(ConsoleColors.FONT_YELLOW+"------------------------------------------------------------------------------------------------------------"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_YELLOW+"획득금화 :"+" + "+batCash*2+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_YELLOW+"현재금화 :      "+user.getInventory().getCash()+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_YELLOW+"------------------------------------------------------------------------------------------------------------"+ConsoleColors.RESET);
        }else {
            System.out.println("" +
                    "███████╗ █████╗ ██╗██╗           \n" +
                    "██╔════╝██╔══██╗██║██║           \n" +
                    "█████╗  ███████║██║██║           \n" +
                    "██╔══╝  ██╔══██║██║██║           \n" +
                    "██║     ██║  ██║██║███████╗██╗██╗\n" +
                    "╚═╝     ╚═╝  ╚═╝╚═╝╚══════╝╚═╝╚═╝\n" +
                    "                                 ");
        }
        System.out.println("|   넘어가기 : Enter  |");
        sc.nextLine();
    }
}
