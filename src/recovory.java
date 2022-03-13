import org.w3c.dom.ls.LSOutput;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class recovory {

Scanner sc=new Scanner(System.in);
int num=0;

    User recovory(User user,Inventory inventory){

        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.회복하기(금화100사용)  ㅣ  2.돌아가기   ㅣ  ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("현재 hp"+user.getRealHp() +" / 총 hp"+user.getHp());
        num=sc.nextInt();
        if(num==1){
            if(inventory.getCash()<100){
                System.out.println("금화가 부족합니다");
            }else{
                inventory.setCash(inventory.getCash()-100);
                user.setRealHp(user.getHp());
                System.out.println("회복완료!!");
                System.out.println("현재 hp"+user.getRealHp() +" / 총 hp"+user.getHp());
            }
        }


        return user;
    }
}
