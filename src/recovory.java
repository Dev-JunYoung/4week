import java.util.Scanner;
public class recovory {
//금화 100 == 체력회복 100
Scanner sc=new Scanner(System.in);
int num=0;
public recovory( ){}
    void recovory(User user){
        System.out.println("" +
                "██████╗ ███████╗ ██████╗ ██████╗ ██╗   ██╗███████╗██████╗ ██╗   ██╗    ██████╗  ██████╗  ██████╗ ███╗   ███╗\n" +
                "██╔══██╗██╔════╝██╔════╝██╔═══██╗██║   ██║██╔════╝██╔══██╗╚██╗ ██╔╝    ██╔══██╗██╔═══██╗██╔═══██╗████╗ ████║\n" +
                "██████╔╝█████╗  ██║     ██║   ██║██║   ██║█████╗  ██████╔╝ ╚████╔╝     ██████╔╝██║   ██║██║   ██║██╔████╔██║\n" +
                "██╔══██╗██╔══╝  ██║     ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗  ╚██╔╝      ██╔══██╗██║   ██║██║   ██║██║╚██╔╝██║\n" +
                "██║  ██║███████╗╚██████╗╚██████╔╝ ╚████╔╝ ███████╗██║  ██║   ██║       ██║  ██║╚██████╔╝╚██████╔╝██║ ╚═╝ ██║\n" +
                "╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝   ╚═╝       ╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚═╝     ╚═╝\n" +
                "                                                                                                            ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("1.회복하기(금화100사용)  ㅣ  2.돌아가기   ㅣ  ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        System.out.println("현재 hp"+user.getRealHp() +" / 총 hp"+user.getHp());
        num=project.예외();
        if(num==1){
            if(user.getInventory().getCash()<100){
                System.out.println("금화가 부족합니다");
            }else{
                user.getInventory().setCash(user.getInventory().getCash()-100);
                user.setRealHp(user.getRealHp()+100);
                System.out.println(ConsoleColors.FONT_YELLOW+"회복완료!!"+ConsoleColors.RESET);
                System.out.println(ConsoleColors.FONT_YELLOW+"현재 hp"+user.getRealHp() +" / 총 hp"+user.getHp()+ConsoleColors.RESET);
                System.out.println(ConsoleColors.FONT_YELLOW+"현재 금화"+user.getInventory().getCash()+ConsoleColors.RESET);
            }
        }
    }
}