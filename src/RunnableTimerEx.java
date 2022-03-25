import javax.swing.*;
import java.awt.*;

public class RunnableTimerEx extends JFrame {
    public static Thread th;
    public RunnableTimerEx(){
        setTitle("타이머쓰레드");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(new FlowLayout());
        JLabel timerLabe1=new JLabel();
        timerLabe1.setFont(new Font("Gothic",Font.ITALIC,50));
        c.add(timerLabe1); //레이블을 컨텐트팬에 부착
        setSize(400,150);
        setVisible(true);
        //타이머 스레드로 사용할 러너블객체생성. 타이머값을 출력할 레이블을 생성자에 전달
        TimerRunnable runnable=new TimerRunnable(timerLabe1);
        Thread th=new Thread(runnable);//쓰레드 객체 생성
        th.setDaemon(true);
        //시간스레드사용
        th.start(); //타이머스레드가 실행시작

        //러너블한 객체 생성 생성자로 set 데이터들 전달
        //스레드객체 생성
                //시작
    }
}
