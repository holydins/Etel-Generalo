/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.randommenugeneralo.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author rich
 */
public class MenuMenteseTest {

    @Test
    public void IdoLetrehozasaTest() {
        LocalDateTime jelenlegiIdo = LocalDateTime.now();
        MenuMentese nezzuk = new MenuMentese();
        DateTimeFormatter formazas = DateTimeFormatter.ofPattern("yyMMdd-hhmm");
        assertEquals(jelenlegiIdo.format(formazas), nezzuk.idoLetrehozasa());
    }

    @Test
    public void XmlFajlNeveTest() {
        MenuMentese testeles = new MenuMentese();
        NevFelvetele.setNevek("kozma", "richard");
        String ido = "180513-091714";
        String nev = "kozmarichard";

        assertEquals("kozmarichard" + MenuMentese.idoLetrehozasa() + ".xml", testeles.xmlFajlNeve());
    }

}
