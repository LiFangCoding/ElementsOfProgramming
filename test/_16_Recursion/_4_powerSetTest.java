package _16_Recursion;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class _4_powerSetTest {

    @Test
    void generatePowerSet() {
        List<Integer> inputset = Arrays.asList(2, 2, 6);
        System.out.println(_4_powerSet.DirectSol.generatePowerSet(inputset));
        System.out.println(_4_powerSet.RecurSol.generatePowerSet(inputset));
    }

    @Test
    void generatePowerSet2() {
        List<Integer> inputset = Arrays.asList(2, 2, 2, 2);
        System.out.println(_4_powerSet.DirectSol.generatePowerSet(inputset));
        System.out.println(_4_powerSet.RecurSol.generatePowerSet(inputset));
    }
}