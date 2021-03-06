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

import java.io.IOException;
import java.net.URL;
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
 * FXML Controller class
 *
 * @author rich
 */
public class VegeController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(VegeController.class);
	
    @FXML
    private Label vegeLabel;

    @FXML
    private void ujGeneralasAction(ActionEvent event) throws IOException {
    	LOGGER.info("Új étel generálásának kezdete...");
        Stage stageBack = (Stage) vegeLabel.getScene().getWindow();

        Parent rootStage = FXMLLoader.load(getClass().getResource("/fxml/Adat.fxml"));

        Scene sceneBack = new Scene(rootStage);

        sceneBack.getStylesheets().add("/styles/Adat.css");
        stageBack.setTitle("Adat felvétel");
        stageBack.setScene(sceneBack);
        stageBack.show();
    }

    @FXML
    private void kilepesAction(ActionEvent event) {
    	LOGGER.info("Az alkalmazás bezárása...");
        System.exit(0);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
