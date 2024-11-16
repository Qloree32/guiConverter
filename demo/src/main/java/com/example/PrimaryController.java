package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField inputField;

    @FXML
    private ComboBox<String> fromUnit;

    @FXML
    private ComboBox<String> toUnit;

    @FXML
    private Label resultLabel;

    public void initialize() {
        fromUnit.getItems().addAll("Meters", "Kilometers", "Centimeters", "Inches");
        toUnit.getItems().addAll("Meters", "Kilometers", "Centimeters", "Inches");
    }

    @FXML
    private void handleConvert() {
        try {
            double inputValue = Double.parseDouble(inputField.getText());
            String from = fromUnit.getValue();
            String to = toUnit.getValue();

            double result = convert(inputValue, from, to);
            resultLabel.setText(String.format("Result: %.2f %s", result, to));
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    private double convert(double value, String from, String to) {
        if (from.equals("Meters") && to.equals("Kilometers")) {
            return value / 1000;
        } else if (from.equals("Kilometers") && to.equals("Meters")) {
            return value * 1000;
        } else if (from.equals("Centimeters") && to.equals("Inches")) {
            return value / 2.54;
        } else if (from.equals("Inches") && to.equals("Centimeters")) {
            return value * 2.54;
        } else if (from.equals("Meters") && to.equals("Centimeters")) {
            return value * 100;
        } else if (from.equals("Meters") && to.equals("Inches")) {
            return value * 39.37;
        } else if (from.equals("Kilometers") && to.equals("Centimeters")) {
            return value * 100000;
        } else if (from.equals("Kilometers") && to.equals("Inches")) {
            return value * 39370.10;
        } else if (from.equals("Centimeters") && to.equals("Meters")) {
            return value / 100;
        } else if (from.equals("Inches") && to.equals("Meters")) {
            return value / 39.37;
        } else if (from.equals("Inches") && to.equals("Kilometers")) {
            return value / 39370;
        } else if (from.equals("Centimeters") && to.equals("Kilometers")) {
            return value / 100000;
        }
        return value;
    }
}
