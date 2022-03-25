import java.io.IOException;
import java.util.*;

public class project {
    public static void main(String args[]) throws IOException, InterruptedException,InputMismatchException {
        System.out.println("" +
                "███████╗████████╗ █████╗ ██████╗ ████████╗██╗██╗██╗\n" +
                "██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝██║██║██║\n" +
                "███████╗   ██║   ███████║██████╔╝   ██║   ██║██║██║\n" +
                "╚════██║   ██║   ██╔══██║██╔══██╗   ██║   ╚═╝╚═╝╚═╝\n" +
                "███████║   ██║   ██║  ██║██║  ██║   ██║   ██╗██╗██╗\n" +
                "╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝╚═╝╚═╝\n" +
                "                                                   ");
       // 대사스레드 1
        Thread t=new Thread(new Text()); //Text implements Runnable 클래스를 인자로 갖는 스레드객체생성
        t.start(); //시작
        t.join();
        Scanner sc=new Scanner(System.in);
        int 목록num=0;
        //객체생성
        Skills skills=new Skills(3);
        Inventory inventory=new Inventory();
        User user =new User(sc.nextLine(),inventory,skills);
        Store store=new Store();
        ending ending=new ending();
        upgradeEquipment upgradeEquipment=new upgradeEquipment();
        hunter hunter=new hunter();
        new RunnableTimerEx();
        System.out.println("그래, "+user.getName()+"군 ");
        //대사스레드 2
        Thread t2=new Thread(new secondText()); //Text implements Runnable 클래스를 인자로 갖는 스레드객체생성
        t2.start();
        t.join();
        sc.nextLine();
        user.startUser(user);
        user.getInventory().inventoryInit(user);
        user.getInventory().setCash(10000);
        //스킬포인트 임의 조정부분
        //게임시작-------------------------------------------------------------------------------------
        while(true){
                if(user.getRealHp()<=0){
                    user.userDie(user);
                }
            System.out.println("" +
                    "███╗   ███╗███████╗███╗   ██╗██╗   ██╗\n" +
                    "████╗ ████║██╔════╝████╗  ██║██║   ██║\n" +
                    "██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║\n" +
                    "██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║\n" +
                    "██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝\n" +
                    "╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ \n" +
                    "                                      ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1.사냥하기  ㅣ  2.유저상태  ㅣ  3.인벤토리  ㅣ  4.장비강화  ㅣ  5.상점  ㅣ  6.회복실  ㅣ  7.태초마을오박사네 ㅣ  8.투기장   ㅣ   9.종료   ㅣ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                목록num=project.예외();
            switch (목록num){
                case 1:
                    hunter.사냥터입구(user,store);
                    break;
                case 2: //userStatus 능력치,스킬스탯확인, 증가, 착용장비확인 완료
                    user.userStatus(user);
                    break;
                case 3: //인벤토리 확인및 장착,포션사용 기능
                   inventory.chooseItem(user,store);
                    break;
                case 4://장비강화
                   upgradeEquipment.Upgrade(user,inventory,store);
                    break;
                case 5://상점모든기능완료(buy,sell)
                    store.storeInit();
                    store.store(user,store);
                    break;
                case 6:
                    recovory recovory=new recovory();
                    recovory.recovory(user);
                    break;
                case 7: //오박사
                    ending.ending(user);
                    if(user.getStatus() == 0){
                        //대사스레드 2
                        Thread t3=new Thread(new EndingText());
                        t3.start();
                        t3.join();
                        System.exit(0);
                        return;
                    }
                    break;
                case 8:
                    new gambling(user).입장();
                    break;
                case 9:
                    if(목록num==9){
                        user.setStatus(0);
                        if(user.getStatus() == 0){
                            System.out.println("게임을 종료하겠습니다. 수고하셨습니다.");
                            System.exit(0);
                        }
                        return;
                    }
                    break;
                case 0:
                    break;
            }
            project.대기(3);
        }
    }
    public static int 예외(){
        int num=0;
        Scanner sc=new Scanner(System.in);
        try{
            num= sc.nextInt();
        }catch (InputMismatchException e){//InputMismatchException ime
            System.out.println(ConsoleColors.FONT_YELLOW+"잘못된 입력입니다"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_YELLOW+"보기 숫자중 입력하세요 "+ConsoleColors.RESET);
            sc=new Scanner(System.in);
            try{
                num= sc.nextInt();
            }catch (InputMismatchException e2){
                System.out.println(ConsoleColors.FONT_RED+"2번째 잘못된 입력입니다 "+ConsoleColors.RESET);
            }
        }
        return num;
    }
    //로딩바스레드
    static void 대기(int num){
        LodingBar l=new LodingBar(num);
        Thread th=new Thread(l);
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

