package _18_GreedyAlgAndInvariants;

import java.util.List;

/**
 * You need to visit all cities and come back to the starting city.
 * A certain amount of gas is available at each city.
 * <p>
 * Call a city ample if you can begin at that city with an empty tank, refill at it, then travel through all the remaining cities,
 * refilling at each, and return to the ample city, without running out of gas at any point.
 * <p>
 * Given an instance of the gasup problem, how would you efficiently compute an ample city?
 * You can assume that there exists an ample city.
 */
public class _6_GasupProblem {
    // Hint: Think about starting with more than enough gas to complete the circuit without gassing up.
    // Track the amount of gas as you perform the circuit, gassing up at each city.

    private static final int MPG = 20;

    /**
     * T = O(n)
     * S = O(1)
     * gallons[i] is the amount of gas in city i, and distances[i] is the distance city i to the next city.
     */
    public static int findAmpleCity(List<Integer> gallons, List<Integer> distances) {
        int remainingGallons = 0;
        CityAndRemainingGas min = new CityAndRemainingGas(0, 0);
        final int numCities = gallons.size();
        for (int i = 1; i < numCities; i++) {
            remainingGallons += gallons.get(i - 1) - distances.get(i - 1) / MPG;
            if (remainingGallons < min.remainingGallons) {
                min = new CityAndRemainingGas(i, remainingGallons);
            }
        }
        return min.city;
    }

    private static class CityAndRemainingGas {
        public int city;
        public int remainingGallons;

        public CityAndRemainingGas(int city, int remainingGallons) {
            this.city = city;
            this.remainingGallons = remainingGallons;
        }
    }
}
