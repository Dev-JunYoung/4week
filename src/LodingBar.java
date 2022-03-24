import java.util.ArrayList;

public class LodingBar implements Runnable {


    @Override
    public void run() {
        ArrayList<String> lodingBar=new ArrayList<String>();
        for (int i=0;i<10;i++){
            try {
                Thread.sleep(500);
                System.out.print("■");
            }catch (Exception e){
            }
        }
    }
}
