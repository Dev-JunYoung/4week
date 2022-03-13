public class Action { //전투 시 딜값계산하는 클래스
    //일반공격력메서드 /
    // *User : super.Attack / this.Avoid
    //moster : realHp, Defense //일반공격은 상성이 없음.*/

    void monsterHit(hunter hunter,Skills skills,User user){
        int skillDamage = user.getPower()
                + (user.getPower() * skills.fire)
                / 10 * skills.fire;
    }

    void monsterProperty(){

    }
}
