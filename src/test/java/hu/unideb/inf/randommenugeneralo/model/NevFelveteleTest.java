package hu.unideb.inf.randommenugeneralo.model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Kozma Richard
 */
public class NevFelveteleTest {    
    
    @Test
    public void testGetNevConcat() {
        NevFelvetele barmi = new NevFelvetele();
        barmi.setNevek("kozma", "richard");
        assertEquals("kozmarichard", NevFelvetele.getNevConcat());
    }

    

}
