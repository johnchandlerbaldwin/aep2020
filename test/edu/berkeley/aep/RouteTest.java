package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class RouteTest {

    //Checks generic lookup function
    @Test
    public void hTobShouldReturn1(){
        Route rt = new Route();
        assertEquals(rt.canReach('h', 'b'), 1);
    }

    //Checks that a node can return itself
    @Test
    public void dToeShouldReturn1(){
        Route rt = new Route();
        assertEquals(rt.canReach('d', 'e'), 1);
    }

    @Test
    public void gTohShouldReturnCannotReach(){
        Route rt = new Route();
        assertEquals(rt.canReach('g', 'h'), "Cannot Reach");
    }

    @Test
    public void dTofShouldReturn4(){
        Route rt = new Route();
        assertEquals(rt.canReach('d','f'), 4);
    }

    @Test
    public void dTodShouldReturn0(){
        Route rt = new Route();
        assertEquals(rt.canReach('d','d'), 0);
    }

}
