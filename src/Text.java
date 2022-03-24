import java.util.ArrayList;

public class Text implements Runnable{ // implements Runnable

    @Override
    public void run() {
        ArrayList<String> scriptList=new ArrayList<>();
        scriptList.add("태초마을을 위협하는 포켓몬을 물리치고 최종 포켓몬인 뮤츠를 물리쳐서,");
        scriptList.add("증표인 리자몽의 꼬리, 거북왕의 등딱지, 이상해꽃의 꽃, 뮤츠의 유골을");
        scriptList.add("오박사에게 건네주어라..");
        scriptList.add("태초마을을 구할 당신의 이름은 무엇인가");
        for(int i=0;i<scriptList.size();i++){
            try{
                Thread.sleep(1000);
                System.out.println(scriptList.get(i));
            }catch (Exception e){
            }
        }
    }
}
class secondText implements Runnable{
    @Override
    public void run() {
        ArrayList<String> scriptList=new ArrayList<>();
        scriptList.add("주의 할 점을 얘기해주지 ");
        scriptList.add("포켓몬은 물, 불, 풀 총 3가지의 속성이 있네");
        scriptList.add("스킬공격시 상성에 맞게 사용하도록 하게");
        scriptList.add("캐릭터가 생성되면 스킬포인트 3이 주어지니, ");
        scriptList.add("잘 분배하길 바라네. ");
        scriptList.add("그럼 이제 포켓몬들을 물리쳐 주게나. 부탁하겠네 (Enter)");
        for(int i=0;i<scriptList.size();i++){
            try{
                Thread.sleep(1000);
                System.out.println(scriptList.get(i));
            }catch (Exception e){
            }
        }
    }
}
class EndingText implements Runnable{

    @Override
    public void run() {
        ArrayList<String> scriptList=new ArrayList<>();
        scriptList.add("이제 자네 할일은 끝났네.. ");
        scriptList.add("덕분에 마을이 이제 평화롭다네..");
        scriptList.add("고맙네.. 잘지내시게 ");
        scriptList.add("The End");
        scriptList.add("3");
        scriptList.add("2");
        scriptList.add("1");
        scriptList.add(".");
        for(int i=0;i<scriptList.size();i++){
            try{
                Thread.sleep(1000);
                System.out.println(scriptList.get(i));
            }catch (Exception e){
            }
        }
    }
}