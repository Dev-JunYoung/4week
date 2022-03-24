import java.util.Scanner;

public class upgradeEquipment{

Scanner sc=new Scanner(System.in);
Thread l=new Thread(new LodingBar());
void loding() throws InterruptedException {
    l.start();
    l.join();
    System.out.println();}
    int Upgrade(User user,Inventory inventory,Store store) throws InterruptedException {
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  초보자의 검 강화조건   :    초보자의 검   ㅣ    파이리의 꼬리     ㅣ   금화 100    ㅣ ");
        System.out.println("ㅣ  초보자의 갑옷 강화조건  :   초보자의 갑옷  ㅣ   꼬북이의 등딱지    ㅣ   금화 100    ㅣ");
        System.out.println("ㅣ  초보자의 신발 강화조건  :   초보자의 신발  ㅣ   이상해씨의 씨앗    ㅣ   금화 100    ㅣ ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  숙련자의 검 강화조건   :    숙련자의 검   ㅣ    리자드의 꼬리     ㅣ   금화 300    ㅣ ");
        System.out.println("ㅣ  숙련자의 갑옷 강화조건  :   숙련자의 갑옷  ㅣ   어니부기의 등딱지    ㅣ   금화 300    ㅣ");
        System.out.println("ㅣ  숙련자의 신발 강화조건  :   숙련자의 신발  ㅣ   이상해풀의 풀입    ㅣ   금화 300    ㅣ ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        System.out.println("ㅣ  마스터의 검 강화조건   :    마스터의 검   ㅣ    리자몽의 꼬리     ㅣ   금화 600    ㅣ ");
        System.out.println("ㅣ  미스터의 갑옷 강화조건  :   마스터의 갑옷  ㅣ  거북왕의 등딱지    ㅣ   금화 600    ㅣ ");
        System.out.println("ㅣ  마스터의 신발 강화조건  :   마스터의 신발  ㅣ   이상해꽃의 꽃    ㅣ   금화 600    ㅣ ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        //유효성 검사
        System.out.println("기타 재료 ");
        for (int i = 0; i < inventory.inventoryList.size(); i++) {
            System.out.print("[" + inventory.inventoryList.get(i) +"]");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<inventory.list.size();i++){
            System.out.println((i+1)+" : "+inventory.list.get(i).name);
        }
        System.out.println(" 재료에 사용된 아이템과 금화는 사라집니다.");
        System.out.println("강화 할 아이템의 번호를 입력하세요 .   돌아가기 : (0)");
        try {
            int num=project.예외();
            if(num==0){
                return 0;
            }else if(inventory.list.isEmpty()){
                return 0;
            }
            Equipments chooseItem= (Equipments) inventory.list.get(num-1);
            chooseItem.upgradeEquipment(user,inventory,store);
        }catch (IndexOutOfBoundsException ido){
            System.out.println("입력하신 번호에 아이템이 없습니다.");
            return 0;
        }

return 0;
    }
}
