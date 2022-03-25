public class Action implements Runnable{
    //유저 공격 쿨타임쓰레드
    @Override
    public void run() {
        System.out.println("공격!!");
        try {
            for(int i=3;i>0;i--){
                System.out.println("공격제한 : "+i);
                Thread.sleep(500);
            }
            return;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
