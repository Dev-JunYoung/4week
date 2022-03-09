import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class project {
    public static void main(String args[]) {
        
        Scanner sc=new Scanner(System.in);
        int random=((int)(Math.random()*10+1));
        int 목록num=0;
        int 뎁스1num=0;
        int 뎁스2num=0;
        System.out.println("흑화된 포켓몬들을 물리치고 최종보스인 뮤츠를 싸워 세상을 구하라");
        System.out.print("세상을 구할 당신의 이름은 무엇인가");
        //유저객체생성 + //생성자(name)
        User user =new User(sc.nextLine());
        //스킬,인벤토리,상점객체생성
        Skills skills=new Skills(3);
        Inventory invertory=new Inventory();
        Store store=new Store();
        //초기값
        invertory.setCash(1000);
        user=user.userInitSet(user);

        //유저이름설정
        System.out.println("당신의 이름은 "+user.getName()+"입니다. (enter)");
        sc.nextLine();
        //능력치조정 랜덤으로 재분배가능
        System.out.println("---------------------------------------------------------------------");
        while(true){
            System.out.println("능력치가 랜덤으로 부여됩니다. ");
            user.userStatList(user);
            System.out.println("1.완료     2.능력치 재분배");
            if(sc.nextInt()==1){
                break;
            }
            user=user.userInitSet(user);
        }
        //능력치 while끝
        System.out.println(user.getName()+"님의 캐릭터가 능력치가 설정되었습니다.");
        System.out.println();

        //게임시작--------------------------------------------------------------------------------------
        while(true){
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            System.out.println("1.사냥하기  ㅣ  2.유저상태  ㅣ  3.인벤토리  ㅣ  4.장비강화  ㅣ  5.상점  ㅣ  6.회복실  ㅣ  7.종료");
            System.out.println("----------------------------------------------------------------------------------------------------------------------");
            목록num=sc.nextInt();
            switch (목록num){
                case 1:
                    hunter hunter=new hunter();//사냥터객체
                    hunter.사냥터입구(user,skills,invertory,store);
                    break;
                case 2: //userStatus 능력치,스킬스탯확인, 증가, 착용장비확인
                    user.userStatus(user,invertory,skills);
                 //ee /*  while(true){
                        user.userStatList(user);
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("1.능력치 올리기 ㅣ   2.스킬   ㅣ   3.착용장비확인     ㅣ   4.돌아가기"    );
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        뎁스1num= sc.nextInt();
                        switch (뎁스1num){           //     1.wearingEquipments
                            //              2.userSkills
                            //              3.inventory
                            case 1: //능력치올리기완성
                                if(user.statPoint>0){
                                    user.userStatUp(user);
                                    break;
                                }else{
                                    System.out.println("스탯포인트가 부족합니다");
                                    sc.nextLine();
                                }
                                break;
                            case 2: //스킬 skillView()호출 -1. 스킬리스트
                                    //                     2.  스킬 올리기 (스탯없으면 X)
                                while(true){
                                    skills.skillView(skills);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("1.스킬 올리기 ㅣ   2.돌아가기   ㅣ ");
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                    뎁스2num= sc.nextInt();
                                    if(뎁스2num==1){
                                        if(skills.getSkillPoint()>0){
                                            skills.skillsUp(skills);
                                        }else{
                                            System.out.println("스킬포인트가 부족합니다.(enter)");
                                            sc.nextLine();
                                            break;
                                        }
                                    }else if(뎁스2num==2){
                                        break;
                                    }
                                    break;
                                }break;
                            case 3:
                                //착용장비확인 장비메서드호출
                                invertory.wearing(user,invertory);
                                sc.nextLine();
                                break;
                            case 4: 뎁스1num=4; //돌아가기
                        }
                        if(뎁스1num==4){ //돌아가기
                            break;
                        }
                    }*/
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
                    /*while (true){
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("1.구매하기  ㅣ  2.판매하기  ㅣ  3.돌아가기  ㅣ  ");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------");
                        뎁스1num=sc.nextInt();
                        switch (뎁스1num){
                            case 1:  //구매
                                while(true){
                                    store.storeView(); //뷰보여줌
                                    System.out.println(invertory.inventoryList);
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("구매하실 번호를 눌러주세요.    ㅣ   돌아가기:0");
                                    System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("보유금화:  "+invertory.getCash());
                                    뎁스2num= sc.nextInt();
                                    switch (뎁스2num){
                                        case 0:
                                            break;
                                        case 1:store.buyHpPotion(invertory);
                                            break;
                                        case 2:store.buyMpPotion(invertory);
                                            break;
                                        case 3:store.buyHpPotion2(invertory);
                                            break;
                                        case 4:store.buyMpPotion2(invertory);
                                            break;
                                        case 5:store.buyHpPotion3(invertory);
                                            break;
                                        case 6:store.buyMpPotion3(invertory);
                                            break;
                                        case 7:store.buySoad(invertory);
                                            break;
                                        case 8:store.buyArmor(invertory);
                                            break;
                                        case 9:store.buyShoes(invertory);
                                            break;
                                        case 10:store.buySoad2(invertory);
                                            break;
                                        case 11:store.buyArmor2(invertory);
                                            break;
                                        case 12:store.buyShoes2(invertory);
                                            break;
                                        case 13:store.buySoad3(invertory);
                                            break;
                                        case 14:store.buyArmor3(invertory);
                                            break;
                                        case 15:store.buyShoes3(invertory);
                                            break;
                                    }
                                    sc.nextLine();
                                    if(뎁스2num==0){
                                        break;
                                    }
                            }
                                break;
                            case 2: //판매
                                invertory.sell(invertory,user);
                                break;
                            case 3: //돌아가기
                                break;
                        }
                        break;
                    }*/
                    break;
                case 6: //recovery  recovery()호출, 반환:HP=HP+@
                    recovory recovory=new recovory();
                    recovory.recovory(user,invertory);
                    break;
                case 7: //게임종료
                    if(목록num==7){
                        System.out.println("게임을 종료하겠습니다. 수고하셨습니다.");
                        return;
                    }
                    break;
                default:
                    
            }
        }

    }

}

