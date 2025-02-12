import java.util.Scanner;

class Item {
    String name;
    int id, quantity;
    double price;
    Item next;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    private Item head;

    void addAtBeginning(int id, String name, int quantity, double price) {
        Item newItem = new Item(id, name, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    void addAtEnd(int id, String name, int quantity, double price) {
        Item newItem = new Item(id, name, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    void addAtPosition(int id, String name, int quantity, double price, int position) {
        if (position <= 1) {
            addAtBeginning(id, name, quantity, price);
            return;
        }
        Item newItem = new Item(id, name, quantity, price);
        Item temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(id, name, quantity, price);
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    void removeItem(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) temp.next = temp.next.next;
    }

    void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    Item searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    Item searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    double totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.id + " | " + temp.name + " | " + temp.quantity + " | $" + temp.price);
            temp = temp.next;
        }
    }

    void sortByName() {
        head = mergeSort(head, "name");
    }

    void sortByPrice() {
        head = mergeSort(head, "price");
    }

    private Item mergeSort(Item head, String criteria) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, criteria);
        Item right = mergeSort(nextOfMiddle, criteria);

        return merge(left, right, criteria);
    }

    private Item merge(Item left, Item right, String criteria) {
        if (left == null) return right;
        if (right == null) return left;

        Item result;
        if ((criteria.equals("name") && left.name.compareToIgnoreCase(right.name) <= 0) ||
            (criteria.equals("price") && left.price <= right.price)) {
            result = left;
            result.next = merge(left.next, right, criteria);
        } else {
            result = right;
            result.next = merge(left, right.next, criteria);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);

        inventory.addAtBeginning(101, "Laptop", 5, 800);
        inventory.addAtEnd(102, "Mouse", 15, 20);
        inventory.displayInventory();

        System.out.println("Total Inventory Value: $" + inventory.totalInventoryValue());

        System.out.print("Enter Item ID to Remove: ");
        inventory.removeItem(sc.nextInt());
        inventory.displayInventory();

        System.out.println("Sorting Inventory by Price...");
        inventory.sortByPrice();
        inventory.displayInventory();
    }
}
