public class Equipments extends Item{
    int upgrade; //강화단계

    public int getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(int upgrade) {
        this.upgrade = upgrade;
    }
    void statUp(){
        //set능력치=user.get능력치+능력치statup
    }
}

