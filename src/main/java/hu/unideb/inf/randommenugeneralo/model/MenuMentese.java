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
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * A generáló által generált menüket lementi egy xml kiterjesztésű fájlba.
 *
 * @author Kozma Richard
 */
public class MenuMentese {
	public static LocalDateTime jelenlegiIdo;
	public static int napSzamlalo;
	/**
	 * A hét minden napját tartalmazó {@code lista}.
	 */
	public static final List<String> NAPOK = Arrays.asList("Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat",
			"Vasárnap");
	static DocumentBuilderFactory dbFactory;
	static DocumentBuilder dBuilder;
	static Document doc;

	/**
	 * Visszaadja a felhasználó mentés gomb aktiválásakor az aktuális időt,
	 * formázva, stringként.
	 *
	 * @return a mentés pillanatában levő időt stringként adja vissza.
	 */
	public static String idoLetrehozasa() {
		jelenlegiIdo = LocalDateTime.now();
		DateTimeFormatter formazas = DateTimeFormatter.ofPattern("yyMMdd-hhmm");
		return jelenlegiIdo.format(formazas);
	}

	/**
	 * Létrehozza a menteni kívánt xml fájl nevét, a felhasználó nevéből, az
	 * aktuális időből és az xml kiterjesztés konkatenációjából.
	 *
	 * @return a mentés gomb kattintásakor levő idő és a felhasználó által megadott
	 *         név konkatenációja xml kiterjesztéssel.
	 */
	public static String xmlFajlNeve() {
		return NevFelvetele.getNevConcat().concat(idoLetrehozasa()).concat(".xml");
	}

	/**
	 * Létrehozza a generált ételek listájából az xml fájlt.
	 *
	 * @param menukLista
	 *            a felhasználó által generált ételek listája.
	 * @throws IOException
	 *             A fájl létrehozásához szükséges.
	 */
	public static void xmlFajlElkeszitese(List<String> menukLista) throws IOException {
		try {
			napSzamlalo = 0;
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.newDocument();

			Element menuk = doc.createElement("menuk");
			doc.appendChild(menuk);

			Element generalo = doc.createElement("generáló");
			generalo.appendChild(
					doc.createTextNode(NevFelvetele.getVezeteknev().concat(" ").concat(NevFelvetele.getKeresztnev())));
			menuk.appendChild(generalo);

			for (int i = 0; i < menukLista.size(); i++) {
				Element menu = doc.createElement("menu");
				Attr nap = doc.createAttribute("nap");
				nap.setValue(NAPOK.get(napSzamlalo++));
				menu.setAttributeNode(nap);
				menuk.appendChild(menu);

				Element reggeliElem = doc.createElement("reggeli");
				reggeliElem.appendChild(doc.createTextNode(menukLista.get(i++)));
				menu.appendChild(reggeliElem);

				Element ebedElem = doc.createElement("ebéd");
				ebedElem.appendChild(doc.createTextNode(menukLista.get(i++)));
				menu.appendChild(ebedElem);

				Element vacsoraElem = doc.createElement("vacsora");
				vacsoraElem.appendChild(doc.createTextNode(menukLista.get(i)));
				menu.appendChild(vacsoraElem);
			}
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			DOMSource source = new DOMSource(doc);

			StreamResult result = new StreamResult(new File(xmlFajlNeve()));
			transformer.transform(source, result);

		} catch (IllegalArgumentException | ParserConfigurationException | TransformerException | DOMException e) {
			System.out.println(e.getMessage());
		}

	}
}
