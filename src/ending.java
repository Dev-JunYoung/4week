import java.util.Arrays;
import java.util.Scanner;
public class ending {
    //시나리오 완료 project case :7
    String 이름;
    Scanner sc=new Scanner(System.in);
    String[] finish=new String[4];
    boolean flag=true;
    void ending(User user){
        flag=true;
        System.out.println("모험을 모두마쳤나 "+user.getName()+"군 확인을 위해 ");
        while(flag){
            System.out.println("");
            System.out.println("" +
                "██████╗ ██████╗         ██████╗ ██╗  ██╗\n" +
                "██╔══██╗██╔══██╗       ██╔═══██╗██║  ██║\n" +
                "██║  ██║██████╔╝       ██║   ██║███████║\n" +
                "██║  ██║██╔══██╗       ██║   ██║██╔══██║\n" +
                "██████╔╝██║  ██║██╗    ╚██████╔╝██║  ██║\n" +
                "╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═════╝ ╚═╝  ╚═╝\n" +
                "                                        ");

        System.out.println(" [1]. 뮤츠의 유골 ㅣ [2]. 리자몽의 꼬리 ㅣ [3]. 거북왕의 등딱지 ㅣ [4]. 이상해꽃의 꽃 ㅣ 을 보여주게나");
            System.out.println("입력하세요  (나가기:Enter -> 0) ");
            이름 = sc.nextLine();
            if(이름.equals("1")){
                if(user.getInventory().inventoryList.contains("뮤츠의 유골")){
                    finish[0]="뮤츠의 유골";
                    제출();
                }
            }else if(이름.equals("2")){
                if(user.getInventory().inventoryList.contains("리자몽의 꼬리")){
                    finish[1]="리자몽의 꼬리";
                    제출();
                }
            }
            else if(이름.equals("3")){
                if(user.getInventory().inventoryList.contains("거북왕의 등딱지")){
                    finish[2]="거북왕의 등딱지";
                    제출();
                }
            }
            else if(이름.equals("4")){
                if(user.getInventory().inventoryList.contains("이상해꽃의 꽃"));{
                    finish[3]="이상해꽃의 꽃";
                    제출();
                }
            }
            else if(이름.equals("0")){
                flag=false;
            }
            else {
                System.out.println("정확하게 입력하지 않았거나, 인벤토리에 없는 아이템입니다.");
            }
            if(Arrays.asList(finish).contains("뮤츠의 유골")&&
                Arrays.asList(finish).contains("리자몽의 꼬리")&&
                Arrays.asList(finish).contains("거북왕의 등딱지")&&
                Arrays.asList(finish).contains("이상해꽃의 꽃")){
                user.setStatus(0);
                return ;
            }
        }
    }
    void 제출(){
        System.out.println("");
        System.out.println("제출한 아이템");
        System.out.println("-------------------------------------------------------------");
        for(int i=0;i<finish.length;i++){
            System.out.print("   ㅣ   "+  finish[i] +"   ㅣ   ");
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
    }
}
