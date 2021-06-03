package com.viktor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayCoupleTest {

    private ArrayCouple arrayCouple;
    private int[] arrayContainOnlyReversedCouple;
    private int[] arrayWithUnreversedCouple;

    @BeforeEach
    public void init() {
        arrayCouple = new ArrayCouple();
        arrayContainOnlyReversedCouple = new int[]{5, 4, 6, 7, 7, 6, 4, 5};
        arrayWithUnreversedCouple = new int[] {5, 14, 2, 1, 1, 2, 3, 3};
    }

    @AfterEach
    public void tearDown() {
        arrayCouple = null;
        arrayContainOnlyReversedCouple = null;
        arrayWithUnreversedCouple = null;

    }

    @Test
    void testArrayChallengeMethodContainOnlyReversedCouple() {
        assertEquals("yes", arrayCouple.arrayChallenge(arrayContainOnlyReversedCouple));
        assertNotEquals("yes", arrayCouple.arrayChallenge(arrayWithUnreversedCouple));
    }

    @Test
    void testArrayChallengeMethodWithUnreversedCouple() {
        assertNotEquals("yes", arrayCouple.arrayChallenge(arrayWithUnreversedCouple));
        assertNotEquals("5,14", arrayCouple.arrayChallenge(arrayWithUnreversedCouple));
        assertNotEquals("3,3", arrayCouple.arrayChallenge(arrayWithUnreversedCouple));
        assertEquals("5,14,3,3", arrayCouple.arrayChallenge(arrayWithUnreversedCouple));
    }

    @Test
    void testArrayChallengeMethodWithUnreversedCoupleByTheirOrder() {
        assertNotEquals("3,3,5,14", arrayCouple.arrayChallenge(arrayWithUnreversedCouple));
        assertEquals("5,14,3,3", arrayCouple.arrayChallenge(arrayWithUnreversedCouple));
    }
}
