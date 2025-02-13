import java.util.LinkedList;
import java.util.Queue;

class CircularTourQueue {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        Queue<Integer> queue = new LinkedList<>();
        int surplus = 0, start = 0, i = 0, n = petrol.length;

        while (queue.size() < n) {
            surplus += petrol[i] - distance[i];
            queue.add(i);

            while (surplus < 0 && !queue.isEmpty()) {
                surplus -= petrol[queue.peek()] - distance[queue.poll()];
                start = queue.isEmpty() ? i + 1 : start;
            }
            i = (i + 1) % n;
        }

        return queue.size() == n ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        System.out.println("Starting Pump Index: " + findStartingPoint(petrol, distance));
    }
}
