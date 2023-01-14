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
    // Zapisywanie ostatniego operatora
    String lastOp = "";
    // Pierwsza liczba
    String first = "";
    // Druga liczba
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
                // Poebiranie pierwszej liczby
                first = equationField.getText();
                // Zapisanie liczby do asnwerlabel
                answerLabel.setText(calculate(first, null, operationText));
                // Wyczyszczenei pierwszej zmiennej i equationField
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
            // Pobieranie drugiej liczby
            second = equationField.getText();
            // Obliczneie i wyświtlenie odpowiedzi
            answerLabel.setText(calculate(first, second, lastOp));
            // Wyczyszczenie zmiennych i pola
            equationField.clear();
            first = "";
            second = "";
            }
        }
    }

