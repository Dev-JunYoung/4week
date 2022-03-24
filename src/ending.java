import java.util.Arrays;
import java.util.Scanner;

public class ending {
    String 이름;
    Scanner sc=new Scanner(System.in);
    int num;
    String[] finish=new String[4];
    boolean a=true;
    void ending(User user,Inventory inventory){
        System.out.println("");
        System.out.println("모험을 모두마쳤나 "+user.getName()+"군");
        System.out.println("확인을 위해  ㅣ 뮤츠의 유골 ㅣ 리자몽의 꼬리 ㅣ 거북왕의 등딱지 ㅣ 이상해꽃의 꽃 ㅣ 을 보여주게나");
        while(a){
            System.out.println("정확하게 입력하시오  (나가기:Enter -> 0) ");
            이름 = sc.nextLine();
            if(이름.equals("뮤츠의 유골")){
                inventory.inventoryList.contains("뮤츠의 유골");
                finish[0]="뮤츠의 유골";
                System.out.println("뮤츠의 유골");
            }else if(이름.equals("리자몽의 꼬리")){
                inventory.inventoryList.contains("리자몽의 꼬리");
                finish[1]="리자몽의 꼬리";
                System.out.println("리자몽의 꼬리");
            }
            else if(이름.equals("거북왕의 등딱지")){
                inventory.inventoryList.contains("거북왕의 등딱지");
                finish[2]="거북왕의 등딱지";
                System.out.println("거북왕의 등딱지");
            }
            else if(이름.equals("이상해꽃의 꽃")){
                inventory.inventoryList.contains("이상해꽃의 꽃");
                finish[3]="이상해꽃의 꽃";
                System.out.println("이상해꽃의 꽃");
            }else {
                System.out.println("정확하게 입력하지 않았거나, 인벤토리에 없는 아이템입니다.");
            }

            System.out.println("제출한 아이템");
            for(int i=0;i<finish.length;i++){

                System.out.print("   ㅣ   "+  finish[i] +"   ㅣ   ");
                System.out.println("");
            }

            if(Arrays.asList(finish).contains("뮤츠의 유골")&&
                Arrays.asList(finish).contains("리자몽의 꼬리")&&
                Arrays.asList(finish).contains("거북왕의 등딱지")&&
                Arrays.asList(finish).contains("이상해꽃의 꽃")){

              /*  System.out.println(" ");
                System.out.println("자네덕에 마을에 평화가 찾아왔네 ");
                System.out.println("이제 자네의 역할은 끝났네 ..  ");
                System.out.println(user.getName()+"의 이름을 기억하겠네.... (end)  ");
              */  user.setStatus(0);
                return ;
            }
            if(num==0){
                return;
            }
        }
    }
}
