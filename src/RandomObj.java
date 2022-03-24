public class RandomObj implements Runnable{
    hunter hunter;
    User user;

    public RandomObj(hunter hunter, User user) {
        this.hunter = hunter;
        this.user = user;
    }
int cnt=1;;
    @Override
    public void run() {
        System.out.println(hunter);
        while(true){
            hunter.초급퀘스트객체생성(user);
            System.out.println("랜덤객체생성 ");
            System.out.println("생성객체이름"+hunter.초급퀘스트객체생성(user).getName());
            try {
                System.out.println(cnt);
                System.out.println(cnt+"랜덤객체생성 횟수");
                Thread.sleep(20000);
                cnt=cnt+1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(cnt<6){
                Thread.interrupted();
                System.out.println("랜덤객체생성쓰레드 런아웃");
            }

        }
    }
}
