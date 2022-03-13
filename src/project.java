import java.awt.*;
import javax.swing.*;
import java.sql.SQLOutput;
import java.util.*;
public class project extends JFrame implements Runnable{
    project(){
        setTitle("java JFrame");
        setSize(300,400);
        setVisible(true);
        run();

    }
    int seq;
    public int Sample(int seq) {
        this.seq = seq;
        return seq;
    }
    @Override
    public void run() {
        System.out.println(this.seq + " thread start.");  // 쓰레드 시작
        try {
           // Thread.sleep(10000);  // 1초 대기한다.
        } catch (Exception e) {
        }
        System.out.println(this.seq + " thread end.");  // 쓰레드 종료
    }
    public static void main(String args[]) {
        new project();
        Scanner sc=new Scanner(System.in);
        int random=((int)(Math.random()*10+1));
        int 목록num=0;
        String cheat=null;
        System.out.println("태초마을을 위협하는 포켓몬을 물리치고 최종 포켓몬인 뮤츠를 물리쳐서, ");
        System.out.println("증표인 리자몽의 꼬리, 거북왕의 등딱지, 이상해꽃의 꽃, 뮤츠의 유골을");
        System.out.println("오박사에게 건네주어라..");
        System.out.print("태초마을을 구할 당신의 이름은 무엇인가");
        //유저객체생성 + //생성자(name)
        User user =new User(sc.nextLine());
        //스킬,인벤토리,상점객체생성
        Skills skills=new Skills(3);
        Inventory invertory=new Inventory();
        Store store=new Store();
        ending ending=new ending();
        upgradeEquipment upgradeEquipment=new upgradeEquipment();
        //유저이름설정
        System.out.println("당신의 이름은 "+user.getName()+"입니다. (enter)");
        sc.nextLine();
        //능력치조정 랜덤으로 재분배가능
        //초기값
        user.startUser(user);
        invertory.inventoryInit(user,invertory);
        invertory.setCash(10000);

        //게임시작--------------------------------------------------------------------------------------
        while(true){
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("1.사냥하기  ㅣ  2.유저상태  ㅣ  3.인벤토리  ㅣ  4.장비강화  ㅣ  5.상점  ㅣ  6.회복실  ㅣ  7.태초마을오박사네 ㅣ   8.종료   ㅣ");
            System.out.println("---------------------------------------------------------------------------------------------------------------------");

            try{
                목록num=sc.nextInt();
            }catch (Exception e){//InputMismatchException ime
                System.out.println("잘못된 입력입니다");
                System.out.println("보기 숫자중 입력하세요 ");
                sc.nextLine();
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                System.out.println("1.사냥하기  ㅣ  2.유저상태  ㅣ  3.인벤토리  ㅣ  4.장비강화  ㅣ  5.상점  ㅣ  6.회복실  ㅣ  7.태초마을오박사네 ㅣ   8.종료   ㅣ");
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                목록num=sc.nextInt();
            }
            switch (목록num){
                case 1:
                    hunter hunter=new hunter();//사냥터객체
                    hunter.사냥터입구(user,skills,invertory,store);
                    break;
                case 2: //userStatus 능력치,스킬스탯확인, 증가, 착용장비확인 완료
                    user.userStatus(user,invertory,skills);
                    break;
                case 3: //인벤토리 확인및 장착,포션사용 기능
                    invertory.inventoryView(user,store,invertory,upgradeEquipment);
                    break;
                case 4://장비강화

                    upgradeEquipment.Upgrade(invertory,store);
                    break;
                case 5://상점모든기능완료(buy,sell)
                    store.storeInit();
                    store.store(invertory,store,user);
                    break;
                case 6: //recovery  recovery()호출, 반환:HP=HP+@
                    recovory recovory=new recovory();
                    recovory.recovory(user,invertory);
                    break;
                case 7: //오박사
                    ending.ending(user,invertory);
                    if(user.getStatus() == 0){
                        System.out.println("게임을 종료하겠습니다. 수고하셨습니다.");
                        return;
                    }
                    break;
                case 8: //게임종료
                    if(목록num==8){
                        System.out.println("게임을 종료하겠습니다. 수고하셨습니다.");
                        return;
                    }
                    break;
            }
        }

    }

}

