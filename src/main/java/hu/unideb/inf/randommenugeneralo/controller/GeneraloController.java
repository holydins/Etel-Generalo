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

package hu.unideb.inf.randommenugeneralo.controller;

import hu.unideb.inf.randommenugeneralo.model.EtelekInicializalasa;
import hu.unideb.inf.randommenugeneralo.model.MenuMentese;
import hu.unideb.inf.randommenugeneralo.model.RandomEtelValasztas;
import hu.unideb.inf.randommenugeneralo.model.ToroltEtelek;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A felhasználó a {@code generalás} gombbal minden egyes napra tud generálni ételt,
 * a napok alatt elhelyezkedő gombokkal pedig a nem szimpatikus ételeket tudjuk megváltoztatni.
 *
 * @author Kozma Richard
 */
public class GeneraloController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneraloController.class);
	
    @FXML
    private Label nezzuk;

    @FXML
    private Label hibajelento;

    @FXML
    private Label hetfoReggeliLabel, hetfoEbedLabel, hetfoVacsoraLabel;

    @FXML
    private Label keddReggeliLabel, keddEbedLabel, keddVacsoraLabel;

    @FXML
    private Label szerdaReggeliLabel, szerdaEbedLabel, szerdaVacsoraLabel;

    @FXML
    private Label csutortokReggeliLabel, csutortokEbedLabel, csutortokVacsoraLabel;

    @FXML
    private Label pentekReggeliLabel, pentekEbedLabel, pentekVacsoraLabel;

    @FXML
    private Label szombatReggeliLabel, szombatEbedLabel, szombatVacsoraLabel;

    @FXML
    private Label vasarnapReggeliLabel, vasarnapEbedLabel, vasarnapVacsoraLabel;

    @FXML
    private void visszaButtonAction(ActionEvent event) throws IOException {
        if (ToroltEtelek.toroltReggelik != null || ToroltEtelek.toroltEbedek != null || ToroltEtelek.toroltVacsorak != null) {
            ToroltEtelek.ToroltEtelekVisszatoltese();
            LOGGER.info("A törölt ételek visszatöltése.");
        }
        Stage stageBack = (Stage) hibajelento.getScene().getWindow();

        Parent rootBack = FXMLLoader.load(getClass().getResource("/fxml/Adat.fxml"));

        Scene sceneBack = new Scene(rootBack);
        sceneBack.getStylesheets().add("/styles/Adat.css");
        stageBack.setResizable(false);
        stageBack.setTitle("Adat felvétel");
        stageBack.setScene(sceneBack);
        stageBack.show();
    }

    @FXML
    private void generalasButtonAction(ActionEvent event) {

        if (EtelekInicializalasa.reggelik.size() < 7 || EtelekInicializalasa.ebedek.size() < 7 || EtelekInicializalasa.vacsorak.size() < 7) {
            hibajelento.setText("Sajnos minden napra nem lehetséges új ételt generálni!");
            LOGGER.info("Kevesebb mint 7 lehetőség van hátra...");
        } else {
        	LOGGER.info("Menük generálása.");
            hibajelento.setText("");

            hetfoReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
            hetfoEbedLabel.setText(RandomEtelValasztas.RandomEbed());
            hetfoVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());

            keddReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
            keddEbedLabel.setText(RandomEtelValasztas.RandomEbed());
            keddVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());

            szerdaReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
            szerdaEbedLabel.setText(RandomEtelValasztas.RandomEbed());
            szerdaVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());

            csutortokReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
            csutortokEbedLabel.setText(RandomEtelValasztas.RandomEbed());
            csutortokVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());

            pentekReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
            pentekEbedLabel.setText(RandomEtelValasztas.RandomEbed());
            pentekVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());

            szombatReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
            szombatEbedLabel.setText(RandomEtelValasztas.RandomEbed());
            szombatVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());

            vasarnapReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
            vasarnapEbedLabel.setText(RandomEtelValasztas.RandomEbed());
            vasarnapVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());
        }
    }

    @FXML
    private void mentesButtonAction(ActionEvent event) throws IOException {
        if (hetfoReggeliLabel.getText().isEmpty() || hetfoEbedLabel.getText().isEmpty() || hetfoVacsoraLabel.getText().isEmpty()
                || keddReggeliLabel.getText().isEmpty() || keddEbedLabel.getText().isEmpty() || hetfoVacsoraLabel.getText().isEmpty()
                || szerdaReggeliLabel.getText().isEmpty() || szerdaEbedLabel.getText().isEmpty() || szerdaVacsoraLabel.getText().isEmpty()
                || csutortokReggeliLabel.getText().isEmpty() || csutortokEbedLabel.getText().isEmpty() || csutortokVacsoraLabel.getText().isEmpty()
                || pentekReggeliLabel.getText().isEmpty() || pentekEbedLabel.getText().isEmpty() || pentekVacsoraLabel.getText().isEmpty()
                || szombatReggeliLabel.getText().isEmpty() || szombatEbedLabel.getText().isEmpty() || szombatVacsoraLabel.getText().isEmpty()
                || vasarnapReggeliLabel.getText().isEmpty() || vasarnapEbedLabel.getText().isEmpty() || vasarnapVacsoraLabel.getText().isEmpty()) {
            hibajelento.setText("Sajnos nem mindenhol található érték, kérem válasszon egyet!");
            LOGGER.info("Nincs mindenhol érték.");
        } else {
            List<String> menuk = Arrays.asList(
                    hetfoReggeliLabel.getText(),
                    hetfoEbedLabel.getText(),
                    hetfoVacsoraLabel.getText(),
                    keddReggeliLabel.getText(),
                    keddEbedLabel.getText(),
                    keddVacsoraLabel.getText(),
                    szerdaReggeliLabel.getText(),
                    szerdaEbedLabel.getText(),
                    szerdaVacsoraLabel.getText(),
                    csutortokReggeliLabel.getText(),
                    csutortokEbedLabel.getText(),
                    csutortokVacsoraLabel.getText(),
                    pentekReggeliLabel.getText(),
                    pentekEbedLabel.getText(),
                    pentekVacsoraLabel.getText(),
                    szombatReggeliLabel.getText(),
                    szombatEbedLabel.getText(),
                    szombatVacsoraLabel.getText(),
                    vasarnapReggeliLabel.getText(),
                    vasarnapEbedLabel.getText(),
                    vasarnapVacsoraLabel.getText());
            
            LOGGER.info("A generált menük mentésének kezdete...");
            
            MenuMentese.xmlFajlElkeszitese(menuk);

            Stage stageStart = (Stage) hibajelento.getScene().getWindow();

            Parent rootStage = FXMLLoader.load(getClass().getResource("/fxml/Vege.fxml"));

            Scene sceneStart = new Scene(rootStage);

            stageStart.setResizable(false);
            sceneStart.getStylesheets().add("/styles/vege.css");
            stageStart.setTitle("Étel Generáló");
            stageStart.setScene(sceneStart);
            stageStart.show();
        }
    }

    @FXML
    private void hetfoReggeliAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.reggelik.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új reggelit ajánlani.");
        } else {
            hetfoReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
        }
    }

    @FXML
    private void keddReggeliAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.reggelik.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új reggelit ajánlani.");
        } else {
            keddReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
        }
    }

    @FXML
    private void szerdaReggeliAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.reggelik.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új reggelit ajánlani.");
        } else {
            szerdaReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
        }
    }

    @FXML
    private void csutortokReggeliAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.reggelik.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új reggelit ajánlani.");
        } else {
            csutortokReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
        }
    }

    @FXML
    private void pentekReggeliAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.reggelik.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új reggelit ajánlani.");
        } else {
            pentekReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
        }
    }

    @FXML
    private void szombatReggeliAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.reggelik.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új reggelit ajánlani.");
        } else {
            szombatReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
        }
    }

    @FXML
    private void vasarnapReggeliAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.reggelik.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új reggelit ajánlani.");
        } else {
            vasarnapReggeliLabel.setText(RandomEtelValasztas.RandomReggeli());
        }
    }

    @FXML
    private void hetfoEbedAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.ebedek.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új ebédet ajánlani.");
        } else {
            hetfoEbedLabel.setText(RandomEtelValasztas.RandomEbed());
        }
    }

    @FXML
    private void keddEbedAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.ebedek.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új ebédet ajánlani.");
        } else {
            keddEbedLabel.setText(RandomEtelValasztas.RandomEbed());
        }
    }

    @FXML
    private void szerdaEbedAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.ebedek.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új ebédet ajánlani.");
        } else {
            szerdaEbedLabel.setText(RandomEtelValasztas.RandomEbed());
        }
    }

    @FXML
    private void csutortokEbedAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.ebedek.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új ebédet ajánlani.");
        } else {
            csutortokEbedLabel.setText(RandomEtelValasztas.RandomEbed());
        }
    }

    @FXML
    private void pentekEbedAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.ebedek.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új ebédet ajánlani.");
        } else {
            pentekEbedLabel.setText(RandomEtelValasztas.RandomEbed());
        }
    }

    @FXML
    private void szombatEbedAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.ebedek.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új ebédet ajánlani.");
        } else {
            szombatEbedLabel.setText(RandomEtelValasztas.RandomEbed());
        }
    }

    @FXML
    private void vasarnapEbedAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.ebedek.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új ebédet ajánlani.");
        } else {
            vasarnapEbedLabel.setText(RandomEtelValasztas.RandomEbed());
        }
    }

    @FXML
    private void hetfoVacsoraAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.vacsorak.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új vacsorát ajánlani.");
        } else {
            hetfoVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());
        }
    }

    @FXML
    private void keddVacsoraAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.vacsorak.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új vacsorát ajánlani.");
        } else {
            keddVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());
        }
    }

    @FXML
    private void szerdaVacsoraAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.vacsorak.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új vacsorát ajánlani.");
        } else {
            szerdaVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());
        }
    }

    @FXML
    private void csutortokVacsoraAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.vacsorak.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új vacsorát ajánlani.");
        } else {
            csutortokVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());
        }
    }

    @FXML
    private void pentekVacsoraAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.vacsorak.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új vacsorát ajánlani.");
        } else {
            pentekVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());
        }
    }

    @FXML
    private void szombatVacsoraAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.vacsorak.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új vacsorát ajánlani.");
        } else {
            szombatVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());
        }
    }

    @FXML
    private void vasarnapVacsoraAction(ActionEvent event) {
        hibajelento.setText("");
        if (EtelekInicializalasa.vacsorak.isEmpty()) {
            hibajelento.setText("Sajnos nem tudok új vacsorát ajánlani.");
        } else {
            vasarnapVacsoraLabel.setText(RandomEtelValasztas.RandomVacsora());
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	if(EtelekInicializalasa.reggelik == null && EtelekInicializalasa.ebedek == null && EtelekInicializalasa.vacsorak == null) {
    		LOGGER.info("Ételek betöltése...");
    	EtelekInicializalasa.setReggelik();
        EtelekInicializalasa.setEbedek();
        EtelekInicializalasa.setVacsorak();
    	}
    }

}
