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

import java.util.ArrayList;
import java.util.List;

/**
 * Felvesszük a felhasználónak kigenerált értéket és tároljuk,
 * hogyha kell akkor vissza tudjuk adni az eredeti listához a törölt értékeket.
 *
 * @author Kozma Richard
 */
public class ToroltEtelek {

    public static List<String> toroltReggelik;
    public static List<String> toroltEbedek;
    public static List<String> toroltVacsorak;

    /**
     * Felvesszük a {@code toroltReggelik} listába,
     * a {@code reggelik} listából kitörölt elemet.
     * 
     * @param toroltReggeli A felhasználó által generált reggeli.
     */
    public static void setToroltReggeli(String toroltReggeli) {
        if (toroltReggelik == null) {
            toroltReggelik = new ArrayList<>();
        }
        toroltReggelik.add(toroltReggeli);
    }

    /**
     * Felvesszük a {@code toroltEbedek} listába,
     * a {@code ebedek} listából kitörölt elemet
     * 
     * @param toroltEbed A felhasználó által generált ebéd.
     */
    public static void setToroltEbed(String toroltEbed) {
        if (toroltEbedek == null) {
            toroltEbedek = new ArrayList<>();
        }
        toroltEbedek.add(toroltEbed);
    }

    
    /**
     * Felvesszük a {@code toroltVacsorak} listába,
     * a {@code vacsorak} listából kitörölt elemet.
     * @param toroltVacsora
     */
    public static void setToroltVacsora(String toroltVacsora) {
        if (toroltVacsorak == null) {
            toroltVacsorak = new ArrayList<>();
        }
        toroltVacsorak.add(toroltVacsora);
    }

    
    /**
     * Ha a felhasználó visszalép a {@code Generalo} nézetről,
     * akkor visszatöltjük a már kitörölt ételeket a {@code reggelik, ebedek, vacsorak} listába.
     */
    public static void ToroltEtelekVisszatoltese() {
        if (toroltReggelik != null) {
            for (int i = 0; i < toroltReggelik.size(); i++) {
                EtelekInicializalasa.reggelik.add(toroltReggelik.get(i));
            }
            toroltReggelik = null;
        }
        if (toroltEbedek != null) {
            for (int i = 0; i < toroltEbedek.size(); i++) {
                EtelekInicializalasa.ebedek.add(toroltEbedek.get(i));
            }
            toroltEbedek = null;
        }
        if (toroltVacsorak != null) {
            for (int i = 0; i < toroltVacsorak.size(); i++) {
                EtelekInicializalasa.vacsorak.add(toroltVacsorak.get(i));
            }
            toroltVacsorak = null;
        }
    }
}
