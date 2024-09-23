package org.example.readerapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HelloController {
    @FXML
    private TextField welcomeText;
    @FXML
    private TextArea Output;

    @FXML
    protected void onHelloButtonClick() throws IOException {

        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pdf Files", "*.pdf"));
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(null);
            String keyvalue = welcomeText.getText();
            if (keyvalue.isEmpty() || keyvalue == null) {
                Output.setText("Enter the text to be searched");
            } else {
                Main main = new Main();
                List<Integer> pagenumber = main.readPdf(file, keyvalue);
                if (pagenumber.isEmpty())
                    Output.setText("List of page number contains specific code : " + pagenumber);
                else if (pagenumber.get(0) != -1)
                    Output.setText("List of page number contains specific code : " + pagenumber);
                else
                    Output.setText("Please add non corrupted file  : " + file.getName());

            }
        }
        catch(Exception e){
            System.out.println("File not selected");

        }
    }
}