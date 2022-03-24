public class ArmorSkill extends Skills implements Runnable{
    User user;
    Skills skills;
    Monster monster;
    public ArmorSkill(User user, Skills skills){
        this.skills=skills;
        this.user=user;
    }
    public ArmorSkill(User user, Skills skills,Monster monster){
        this.skills=skills;
        this.user=user;
        this.monster=monster;
    }
    @Override
    public void run() {
        try {
            int temp=0;
            temp=user.getDefense();
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(ConsoleColors.BACKGROUND_CYAN+"                     방어력 버프!!!!!!"+ConsoleColors.RESET);
            System.out.println(" 기존방어력     : "+ user.getDefense());
            skills.ArmorUp(user,skills);
            System.out.println(ConsoleColors.FONT_CYAN+"                     mp -5"+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_CYAN+"현재 MP : "+user.getRealMp()+" / 총 MP : "+user.getMp()+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_CYAN+" 증가된방어력   : "+user.getDefense()+ConsoleColors.RESET);
            System.out.println(ConsoleColors.FONT_CYAN+" 지속시간      : "+skills.getArmorSkill()*3+ConsoleColors.RESET);
            System.out.println("-----------------------------------------------------------------------------");
            Thread.sleep(skills.getArmorSkill()*10000); //10초간지속
            if(monster.getRealHp()>=0){
                return;
            }
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println(ConsoleColors.FONT_CYAN+"방어력 버프 해제"+ConsoleColors.RESET);
            user.setDefense(temp);
            System.out.println(" 현재방어력       : "+user.getDefense());
            System.out.println("-----------------------------------------------------------------------------");
            Thread.interrupted(); //
        }catch (Exception e){

        }
    }

}
