package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Objects;


public class HelloController extends Doing{
    // Pole dla wyświetlania cyfer
    public TextField equationField;
    // Pole dla odpowiedzi
    public Label answerLabel;
    String lastOp = "";
    String first = "";
    String second = "";

    // Event po niciskaniu klawiszy
    public void Number(ActionEvent ae){
        // Pobieranie nacisnietej cyfery
        String numberText = (((Button)ae.getSource()).getText());
        equationField.setText(equationField.getText() + numberText);
    }

    // Event po naciskaniu operatora
    public void Operation(ActionEvent ae){
        // Pobieranie operatora
        String operationText = (((Button)ae.getSource()).getText());

        if(!operationText.equals("=")){
            // Obliczenie pierwiastka
            if(operationText.equals("√")) {
                first = equationField.getText();
                answerLabel.setText(calculate(first, null, operationText));
                first = "";
                equationField.clear();
            // Negacja liczby
            }else if(Objects.equals(equationField.getText(), "") || Objects.equals(operationText, "-")) {
                equationField.setText(operationText);

            // Obliczenie innych operatorów
            }else{
                first = equationField.getText();
                answerLabel.setText(first + operationText);
                equationField.clear();
                lastOp = operationText;
            }

        // Po kliknięciu "=", przypisanie durgiej liczby -> wyświtlenie odpowiedzi w answerlabel -> zerowanie first i second
        }else{
            second = equationField.getText();
            answerLabel.setText(calculate(first, second, lastOp));
            equationField.clear();
            first = "";
            second = "";
            }
        }
    }

