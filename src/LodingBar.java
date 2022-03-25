public class LodingBar implements Runnable {
    //로딩바 스레드
int num=0;
    public LodingBar(int num) {
        this.num=num;
    }
    @Override
    public void run() {
        for (int i=0;i<num;i++){
            try {
                Thread.sleep(500);
                System.out.print(ConsoleColors.FONT_GREEN+"■"+ConsoleColors.RESET);
            }catch (Exception e){
            }
        }
        System.out.println("");
    }
}
