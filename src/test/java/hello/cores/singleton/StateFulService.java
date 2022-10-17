package hello.cores.singleton;

public class StateFulService {
    private int price ; // 가격

    public int order(String name , int price){
        System.out.println("name = " + name+"price : "+price);
        this.price = price;
        return price;
    }

    public int getPrice() {
        return price;
    }
}
