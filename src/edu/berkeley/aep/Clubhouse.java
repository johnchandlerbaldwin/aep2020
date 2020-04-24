package edu.berkeley.aep;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

//Understands how to specify tee groups from a list of groups of people
public class Clubhouse {

    private ArrayList<Integer> list = new ArrayList<Integer>();

    public Clubhouse(ArrayList<Integer> constructor_list) {
        this.list = constructor_list;
    }

    public int get_tee_groups() {
        int tee_group_cnt = 0;

        //Iterate through list until it reaches 0 elements
        //while (list.size() > 0) {
        //    int group_size_tally = 0;

        //    Iterator<Integer> listIterator = list.iterator();
        return(1);
        }
    }

    // num_groups initialized at 0
    // Have an array of values between 1 and 4
    // Take the first value
    // If the next value + the first value are less than 4, then add them together
    // Iterate and do this until value is 4 or end of array is reached
    // Add 1 to num_groups and delete the parts of the array that were used
    // Continue this process until the array is empty
    // Return num_groups
