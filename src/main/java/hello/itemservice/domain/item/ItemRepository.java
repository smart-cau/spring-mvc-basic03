package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(sequence++);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long itemId) {
        return store.get(itemId);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    // 정석으로 한다면, updateParam 용 class를 새로 만드는게 맞음. updateDto라는 이름. Item의 id를 안쓰기 때문. 중복 vs 명확성 -> 명확성을 쓰는게 맞다.
    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
