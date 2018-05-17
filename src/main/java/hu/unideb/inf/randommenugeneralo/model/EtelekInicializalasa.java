/**
 *Copyright 2018 Kozma Richard
 * 
 *Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 *to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 *and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 *The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 *THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 *INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 *TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package hu.unideb.inf.randommenugeneralo.model;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Felvesszük a reggeliket, ebédeket, vacsorákat külön-külön listába.
 *
 * @author Kozma Richard
 */
public class EtelekInicializalasa {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(EtelekInicializalasa.class);

    /**
     * Tartalmazza az összes lehetséges reggelit.
     */
    public static List<String> reggelik;
    
    /**
     * Tartalmazza az összes lehetséges ebédet.
     */
    public static List<String> ebedek;
    
    /**
     * Tartalmazza az összes lehetséges vacsorát.
     */
    public static List<String> vacsorak;

    /**
     * Alapértelmezett konstruktor.
     */
    public EtelekInicializalasa() {
    	 
    }

    URL url = getClass().getResource("reggeli.xml");
    /**
     * Felvesszük a reggeliket, a {@code reggeli.xml} fájlból és feltöltjük a
     * {@code reggelik} listát.
     *
     */
    public static void setReggelik() {
        try {
            if (reggelik == null) {
                reggelik = new ArrayList<>();
                //File reggeliXML = new File("@../src/main/resource/xml/reggeli.xml");
                File reggeliXmlFile = new File("target/classes/xml/reggeli.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = (Document) dBuilder.parse(reggeliXmlFile);

                NodeList nList = doc.getElementsByTagName("reggeli");
                Node nNode;

                for (int i = 0; i < nList.getLength(); i++) {
                    nNode = nList.item(i);
                    reggelik.add(nNode.getTextContent());
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * Felvesszük az ebédeket, az {@code ebedek.xml} fájlból és feltöltjük a
     * .{@code ebedek} listát
     */
    public static void setEbedek() {
        try {
            if (ebedek == null) {
                ebedek = new ArrayList<>();
                File ebedXmlFile = new File("target/classes/xml/ebed.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = (Document) dBuilder.parse(ebedXmlFile);

                NodeList nList = doc.getElementsByTagName("ebed");
                Node nNode;

                for (int i = 0; i < nList.getLength(); i++) {
                    nNode = nList.item(i);
                    ebedek.add(nNode.getTextContent());
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }

    /**
     * Felvesszük a vacsorákat, a {@code vacsorak.xml} fájlból és feltöltjük a
     *  {@code vacsora} listát.
     */
    public static void setVacsorak() {
        try {
            if (vacsorak == null) {
                vacsorak = new ArrayList<>();
                File vacsoraXmlFile = new File("target/classes/xml/vacsora.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = (Document) dBuilder.parse(vacsoraXmlFile);

                NodeList nList = doc.getElementsByTagName("vacsora");
                Node nNode;

                for (int i = 0; i < nList.getLength(); i++) {
                    nNode = nList.item(i);
                    vacsorak.add(nNode.getTextContent());
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
