package hello.itemservice.domain.item;

import lombok.Data;

@Data // 이 annotation은 너무 많은 것들을 포함하기에 위험함. 하지만 예제니까 일단 쓴다
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
