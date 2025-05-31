package cleancode.minesweeper.asis;

import java.util.List;
import java.util.Optional;

public class Order {

    private List<String> items;
    private int price;
    //private Customer customer;
    //private Optional<Customer> customer = Optional.empty();

    public boolean validateOrder(Order order) {

        if(order.isOrderItemsListEmpty()) {
            return printErrorMessage("주문 항목이 없습니다.");
        }

        if(order.isTotalPriceBelowZero()) {
            return printErrorMessage("올바르지 않은 총 가격입니다.");
        }

        if(order.hasNotCustomerInfo()) {
            return printErrorMessage("사용자 정보가 없습니다.");
        }

        return true;
    }

    private boolean hasNotCustomerInfo() {
        //return customer == null;
        //return customer.isEmpty();
        return false;
    }

    private boolean isTotalPriceBelowZero() {
        return price < 0;
    }

    private boolean isOrderItemsListEmpty() {
        return items.isEmpty();
    }

    private boolean printErrorMessage(String message) {
        //log.info(message);
        return false;
    }
}
