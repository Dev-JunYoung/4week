import java.sql.SQLOutput;
import java.util.*;

public class project {
    public static void main(String args[]) {
        
        Scanner sc=new Scanner(System.in);
        int random=((int)(Math.random()*10+1));
        int 목록num=0;
        String cheat=null;
        System.out.println("흑화된 포켓몬들을 물리치고 최종보스인 뮤츠를 싸워 세상을 구하라");
        System.out.print("세상을 구할 당신의 이름은 무엇인가");
        //유저객체생성 + //생성자(name)

        User user =new User(sc.nextLine());
        //스킬,인벤토리,상점객체생성
        Skills skills=new Skills(3);
        Inventory invertory=new Inventory();
        Store store=new Store();
        ending ending=new ending();
        //유저이름설정
        System.out.println("당신의 이름은 "+user.getName()+"입니다. (enter)");
        sc.nextLine();
        //능력치조정 랜덤으로 재분배가능
        //초기값
        user.startUser(user);
        invertory.inventoryInit(user,invertory);
        System.out.println();
        //게임시작--------------------------------------------------------------------------------------
        while(true){
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("1.사냥하기  ㅣ  2.유저상태  ㅣ  3.인벤토리  ㅣ  4.장비강화  ㅣ  5.상점  ㅣ  6.회복실  ㅣ  7.태초마을오박사네 ㅣ   8.종료   ㅣ");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            목록num=sc.nextInt();
            switch (목록num){
                case 1:
                    hunter hunter=new hunter();//사냥터객체
                    hunter.사냥터입구(user,skills,invertory,store);
                    break;
                case 2: //userStatus 능력치,스킬스탯확인, 증가, 착용장비확인 완료
                    user.userStatus(user,invertory,skills);
                    break;
                case 3: //인벤토리 확인및 장착,포션사용 기능
                    invertory.inventoryView(user,store,invertory);
                    break;
                case 4://장비강화
                    upgradeEquipment upgradeEquipment=new upgradeEquipment();
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
                    /*invertory.inventoryList.add("뮤츠의 유골");
                    invertory.inventoryList.add("리자몽의 꼬리");
                    invertory.inventoryList.add("거북왕의 등딱지");
                    invertory.inventoryList.add("이상해꽃의 꽃");*/
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

