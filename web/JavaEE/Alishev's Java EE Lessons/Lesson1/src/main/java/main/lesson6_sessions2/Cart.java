package main.lesson6_sessions2;

import java.util.*;

public class Cart {
    TreeMap<String, Item> itemList = new TreeMap<>();

    public void addItem(Item newItem) {
        if (itemList.containsKey(newItem.getName())) {
            Item item = itemList.get(newItem.getName());
            item.setQuantity(item.getQuantity() + newItem.getQuantity());
        } else {
            itemList.put(newItem.getName(), newItem);
        }

    }

    public void clear() {
        itemList.clear();
    }

    public TreeMap<String, Item> getItemList() {
        return itemList;
    }

    public String toString() {
        return itemList.toString();
    }
}
