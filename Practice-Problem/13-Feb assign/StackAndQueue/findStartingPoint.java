class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalPetrol = 0, totalDistance = 0;
        int start = 0, surplus = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            surplus += petrol[i] - distance[i];

            if (surplus < 0) {
                start = i + 1;
                surplus = 0;
            }
        }

        return (totalPetrol >= totalDistance) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        System.out.println("Starting Pump Index: " + findStartingPoint(petrol, distance));
    }
}
