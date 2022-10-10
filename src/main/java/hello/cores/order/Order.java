package hello.cores.order;

public class Order {
    private Long mebmerId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    public Order(Long mebmerId, String itemName, int itemPrice, int discountPrice) {
        this.mebmerId = mebmerId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int calculatePrice(){
        return itemPrice - discountPrice;
    }

    public Long getMebmerId() {
        return mebmerId;
    }

    public void setMebmerId(Long mebmerId) {
        this.mebmerId = mebmerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "mebmerId=" + mebmerId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
