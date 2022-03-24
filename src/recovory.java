import org.w3c.dom.ls.LSOutput;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class recovory { //implements Runnable

Scanner sc=new Scanner(System.in);
int num=0;

User user;
Inventory inventory;
//생성자의 매개변수를 Run
public recovory(User user,Inventory inventory){
    this.user = user;
    this.inventory=inventory;
}
  /*  @Override
    public void run() {
        System.out.println(user);
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.회복하기(금화100사용)  ㅣ  2.돌아가기   ㅣ  ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("현재 hp"+user.getRealHp() +" / 총 hp"+user.getHp());
        num=project.예외();
        if(num==1){
            if(inventory.getCash()<100){
                System.out.println("금화가 부족합니다");
            }else {
                System.out.println("체력을 회복합니다");
                inventory.setCash(inventory.getCash()-100);
                try{
                    for(int i=1;user.getRealHp()<user.getHp();){

                        user.setRealHp(user.getRealHp()+50*i);
                        Thread.sleep(3000);
                        System.out.println("hp+50 "+"현재 hp"+user.getRealHp() +" / 총 hp"+user.getHp());

                    }//for 문
                }catch (Exception e){
                }
            }
        }
        System.out.println("완료 되었습니다");
    }*/

    // 쓰레드 입히기 전
    User recovory(User user,Inventory inventory){

        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.회복하기(금화100사용)  ㅣ  2.돌아가기   ㅣ  ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("현재 hp"+user.getRealHp() +" / 총 hp"+user.getHp());
        num=project.예외();
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