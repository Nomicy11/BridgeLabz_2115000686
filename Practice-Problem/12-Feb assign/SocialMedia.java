import java.util.*;

class Friend {
    int friendId;
    Friend next;

    Friend(int id) {
        this.friendId = id;
        this.next = null;
    }
}

class User {
    int userId;
    String name;
    int age;
    Friend friendList;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
    }

    void addFriend(int friendId) {
        Friend newFriend = new Friend(friendId);
        newFriend.next = friendList;
        friendList = newFriend;
    }

    void removeFriend(int friendId) {
        if (friendList == null) return;
        if (friendList.friendId == friendId) {
            friendList = friendList.next;
            return;
        }
        Friend temp = friendList;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }
        if (temp.next != null) temp.next = temp.next.next;
    }

    void displayFriends() {
        System.out.print("Friends of " + name + " (" + userId + "): ");
        Friend temp = friendList;
        if (temp == null) {
            System.out.println("No friends.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int countFriends() {
        int count = 0;
        Friend temp = friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class SocialNetwork {
    private User head;

    void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    User searchUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    void addFriendConnection(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    void removeFriendConnection(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    void findMutualFriends(int userId1, int userId2) {
        User user1 = searchUser(userId1);
        User user2 = searchUser(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> friends1 = new HashSet<>();
        Friend temp = user1.friendList;
        while (temp != null) {
            friends1.add(temp.friendId);
            temp = temp.next;
        }

        System.out.print("Mutual friends of " + user1.name + " and " + user2.name + ": ");
        boolean found = false;
        temp = user2.friendList;
        while (temp != null) {
            if (friends1.contains(temp.friendId)) {
                System.out.print(temp.friendId + " ");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.print("None");
        System.out.println();
    }

    void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.userId + ": " + temp.name + " (" + temp.age + " years old)");
            temp.displayFriends();
            temp = temp.next;
        }
    }
}

public class SocialMedia {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        
        network.addUser(1, "A", 25);
        network.addUser(2, "B", 23);
        network.addUser(3, "C", 27);
        network.addUser(4, "D", 22);

        // Adding Friend Connections
        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 4);
        network.addFriendConnection(3, 4);

        network.displayAllUsers();

       
        network.findMutualFriends(1, 3);
        network.findMutualFriends(2, 3);

        
        network.removeFriendConnection(1, 3);
        network.displayAllUsers();
    }
}
