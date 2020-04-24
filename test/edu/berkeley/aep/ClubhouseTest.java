package edu.berkeley.aep;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ClubhouseTest {

    @Test
    public void clubhouseWithValuesTwoThreeTwoOneShouldOutputTwo() {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);

        var club_list = new Clubhouse(list);
        assertEquals(club_list.get_tee_groups(), 2);
    }

    @Test
    public void clubhouseWithValueOneShouldOutputOne() {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);

        var club_list = new Clubhouse(list);
        assertEquals(club_list.get_tee_groups(), 1);
    }
}
