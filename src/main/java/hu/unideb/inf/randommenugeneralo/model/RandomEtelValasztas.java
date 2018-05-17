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

import java.util.Random;

/**
 * Kiválasztunk egyet-egyet a listákból ,amelyet törlünk is a listából.
 *
 * @author Kozma Richard
 */
public class RandomEtelValasztas {

    /**
     * Kiválasztunk véletlenszerűen egy reggelit
     *  a {@code reggelik} listából,
     *   amelyet ki is törlünk a listából.
     *
     * @return Egy reggelit ad vissza a {@code reggelik} listából.
     */
    public static String RandomReggeli() {
        Random random = new Random();
        int reggeliIndexe = random.nextInt(EtelekInicializalasa.reggelik.size());
        String aktualisReggeli = EtelekInicializalasa.reggelik.get(reggeliIndexe);

        EtelekInicializalasa.reggelik.remove(aktualisReggeli);

        ToroltEtelek.setToroltReggeli(aktualisReggeli);

        return aktualisReggeli;
    }

    /**
     * Kiválasztunk véletlenszerűen egy ebédet
     * a {@code ebedek} listából,
     * amelyet ki is törlünk a listából.
     *
     * @return Egy ebédet ad vissza a {@code ebedek} listából.
     */
    public static String RandomEbed() {
        Random random = new Random();
        int ebedIndexe = random.nextInt(EtelekInicializalasa.ebedek.size());
        String aktualisEbed = EtelekInicializalasa.ebedek.get(ebedIndexe);

        EtelekInicializalasa.ebedek.remove(aktualisEbed);

        ToroltEtelek.setToroltEbed(aktualisEbed);

        return aktualisEbed;
    }

    /**
     * Kiválasztunk véletlenszerűen egy ebédet
     * a {@code vacsorak} listából,
     * amelyet ki is törlünk a listából.
     *
     * @return Egy vacsorát ad vossza a {@code vacsorak} listából.
     */
    public static String RandomVacsora() {
        Random random = new Random();
        int vacsoraIndexe = random.nextInt(EtelekInicializalasa.vacsorak.size());
        String aktualisVacsora = EtelekInicializalasa.vacsorak.get(vacsoraIndexe);

        EtelekInicializalasa.vacsorak.remove(aktualisVacsora);

        ToroltEtelek.setToroltVacsora(aktualisVacsora);

        return aktualisVacsora;
    }
}
