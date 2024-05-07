package hello.core.order;

public interface OrderSevice {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
