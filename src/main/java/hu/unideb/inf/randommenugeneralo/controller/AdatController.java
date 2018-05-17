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

import hu.unideb.inf.randommenugeneralo.model.NevFelvetele;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bekérjük a generáló vezetéknevét és keresztnevét.
 *
 * @author Kozma Richard
 */
public class AdatController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdatController.class);
	
    @FXML
    private Label vezeteknevLabel;

    @FXML
    private Button nextButton;

    @FXML
    private TextField vezeteknevInput;

    @FXML
    private TextField keresztnevInput;

    @FXML
    private void backButtonAction(ActionEvent event) throws IOException {
        Stage stageBack = (Stage) vezeteknevLabel.getScene().getWindow();

        Parent rootBack = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene sceneBack = new Scene(rootBack);
        sceneBack.getStylesheets().add("/styles/Styles.css");

        stageBack.setResizable(false);
        stageBack.setTitle("Étel Generáló");
        stageBack.setScene(sceneBack);
        stageBack.show();
    }

    @FXML
    private void nextButtonAction(ActionEvent event) throws IOException {
        if (!(vezeteknevInput.getText().isEmpty() && keresztnevInput.getText().isEmpty())) {
        	LOGGER.info("A felhasználó nevének felvétele.");
            NevFelvetele.setNevek(vezeteknevInput.getText(), keresztnevInput.getText());
        } else {
            NevFelvetele.setNevek("Sablon", "Nev");
            LOGGER.info("A felhasználó nem adott meg nevet.");
        }
        Stage stageNext = (Stage) vezeteknevLabel.getScene().getWindow();

        Parent rootNext = FXMLLoader.load(getClass().getResource("/fxml/Generalo.fxml"));

        Scene sceneNext = new Scene(rootNext);
        sceneNext.getStylesheets().add("/styles/Generalo.css");

        stageNext.setResizable(false);
        stageNext.setTitle("Menük generálása");
        stageNext.setScene(sceneNext);
        stageNext.show();

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
}
