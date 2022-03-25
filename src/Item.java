public class Item {
    int price;
    String name;

    //오버라이딩 메서드
    public void 상호작용(User user, Store store){    }
    public void sell(User user){    }


    //getter,setter
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}