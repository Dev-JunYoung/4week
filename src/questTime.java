public class questTime implements Runnable{
User user;
Thread pickTh;
Thread opponentTh;
    //시간스레드(몬스터스레드+몬스터스레드)
    public questTime(User user,Thread pickTh,Thread opponentTh) {
        this.user = user;
        this.pickTh = pickTh;
        this.opponentTh = opponentTh;
    }
    int questSecond=1;
    int questMinute=1;
    int Second=1; ;
    boolean limitTime =false;
    @Override
    public void run() {
        //퀘스트모드(구현못함)
        if(user.get유저모드()==1) {
            System.out.println("퀘스트 제한시간 시작 ");
            while (limitTime == false) {
                if (questSecond == 60) {
                    System.out.println("퀘스트타임:30초지났습니다 ");
                    questSecond = 0;
                    questMinute++;
                }
                if (questSecond == 30) {
                    System.out.println("퀘스트타임:30초지났습니다 ");
                }
                questSecond++;
                try {
                    Thread.sleep(1000); //1초 잠잔다.
                } catch (InterruptedException e) {
                    return;
                }
                //제한시간 1분30초
                if (questMinute == 1) {
                    if (questSecond == 30) {
                        limitTime = true;
                        System.out.println("퀘스트타임끝!!");
                        Thread.interrupted();
                    }
                }
            }
        }
        //투기장모드
        else if(user.get유저모드()==2){
            System.out.println(" 게임 시작 !!!");
            //투기장스레드 (두개의 객체 시작)
            this.pickTh.start();
            this.opponentTh.start();
            while (limitTime == false) {
                if (Second == 10) {
                    System.out.println(" 10초지났습니다 ");
                }
                if (Second == 20) {
                    System.out.println(" 20초지났습니다 ");
                }
                try {
                    Thread.sleep(1000); //1초 잠잔다.
                    Second++;
                } catch (InterruptedException e) {
                    return;
                }
                //제한시간 스레드종료시 2개의 몬스터스레드도 종료
                if(Second==30){
                    System.out.println("제한시간 완료");
                    this.pickTh.interrupt();
                    this.opponentTh.interrupt();
                    limitTime=true;
                    Thread.interrupted();
                }
            }
        }
    }
}
