public abstract class Equipments extends Item{
    int upgrade; //강화단계
    int raise;
    public int getRaise() {
        return raise;
    }
    public void setEquipment(User user,Inventory inventory){}

    public void setRaise(int raise) {
        this.raise = raise;
    }

    public int getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(int upgrade) {
        this.upgrade = upgrade;
    }
    void statUp(){
    }
    public abstract void upgradeEquipment(User user, Inventory inventory, Store store);
}

