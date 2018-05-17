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

/**Felvesszük a generáló nevét.
 *
 * @author Kozma Richard
 */
public class NevFelvetele {

    /**A generáló vezetékneve.*/
    private static String vezeteknev;
    
    /**A generáló keresztneve.*/
    private static String keresztnev;

    /** Alapértelmezett konstruktor */
    public NevFelvetele() {

    }

    /**
     * Felvesszük a generáló nevét, amelyet kisbetűssé alakítunk.
     *
     * @param veznev a generáló vezetékneve.
     * @param kernev a generáló keresztneve.
     */
    public static void setNevek(String veznev, String kernev) {
        vezeteknev = veznev.toLowerCase();
        keresztnev = kernev.toLowerCase();
    }

    /**
     * A vezetéknevet és a keresztnevet összekonkatenáljuk ,hogy később
     * felhasználjuk a menteni kívánt xml fájl nevéhez.
     *
     * @return A vezeteknev és keresztnev konkatenációja.
     */
    public static String getNevConcat() {
        return vezeteknev.concat(keresztnev);
    }

    /**
     * 
     * @return Visszaadja a felhasználó vezetéknevét.
     */
    public static String getVezeteknev() {
        return vezeteknev;
    }
    
    /**
     * 
     * @return Visszaadja a felhasználó keresztnevét.
     */
    public static String getKeresztnev() {
        return keresztnev;
    }

}
