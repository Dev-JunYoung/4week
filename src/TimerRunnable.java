import javax.swing.*;

public class TimerRunnable implements Runnable{

    private JLabel timerLabel; //타이머 값이 출력된 레이블
    public TimerRunnable(JLabel timerLabel){
        this.timerLabel=timerLabel; //초카운트를 출력할 레이블
    }

    public static boolean afternoon=true;
    public static int second=0;
    public static int minute=0;
    public TimerRunnable(){}

    //스레드 코드
    @Override
    public void run() { //start() 에 의해 실행을 시작하는 코드
        while(true){
            if(second==60){
                second=0;
                minute++;
            }
            if(minute%2==1){
                timerLabel.setText("밤 "+Integer.toString(minute)+"분:"+Integer.toString(second)+"초"); //레이블에 카운트 값 출력
                afternoon=false;
            }
            if(minute%2==0){ //짝수
                timerLabel.setText("낮 "+Integer.toString(minute)+"분:"+Integer.toString(second)+"초"); //레이블에 카운트 값 출력
                afternoon=true;
            }
            second++;
            try {
                Thread.sleep(1000); //1초 잠잔다.
            }catch (InterruptedException e){
            }

        }
    }
}
