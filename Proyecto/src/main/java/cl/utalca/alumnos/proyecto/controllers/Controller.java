package cl.utalca.alumnos.proyecto.controllers;

import cl.utalca.alumnos.proyecto.functions.Coords.Coords;
import cl.utalca.alumnos.proyecto.functions.Draw;
import cl.utalca.alumnos.proyecto.functions.numbers.Numbers;
import cl.utalca.alumnos.proyecto.functions.operators.Operators;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static int posX, posY;

    @FXML
    private TextField textInput;
    public int statusA = 2, statusB = 2, statusParentesis = 0, statusC;
    public ArrayList<String> text = new ArrayList<>();

    @FXML
    private ColorPicker ColorPicker;
    public static Color currentColor;

    @FXML
    public Canvas canvas;
    @FXML
    public Canvas canvasCoordenadas;

    private GraphicsContext gc;
    private GraphicsContext gcCoordenadas;
    private int ContCoord = 0;


    public void ClickBorrarTodo (ActionEvent borratodo){
        textInput.setText("");
        statusA = 2;
        statusB = statusA;
        gc.clearRect(0,0,515,313);
        gcCoordenadas.clearRect(0,0,515,313);
        ContCoord = 0;
        posX = 0;
        posY =0;
        text.clear();
    }

    /*public void ClickBorrar (ActionEvent borrauno){
        String borrar = textInput.getText();
        if(borrar != null && borrar.length() > 0){
            borrar = borrar.substring(0, borrar.length()-1);
            textInput.setText(borrar);
            statusA = statusB;
            contador-=1;
            //gc.clearRect();
            //Borrar en canvas
        }
    }*/

    public void ClickCambioColor (ActionEvent cambiocolor){
        Controller.setColor(ColorPicker.getValue());
        Color test = ColorPicker.getValue();
        System.out.println(test);

    }
    public static void setColor(Color color){
        currentColor = color;
    }
    public static Color getColor(){
        return currentColor;
    }

    public void ClickCoordenadas (ActionEvent coord){
        if(ContCoord == 0){
            posX = 0;
            for(int i = 0; i < text.size(); i++){
                Coords.DrawCoord(text.get(i), gcCoordenadas, posX);
                posX += 30;
                ContCoord++;
            }
        }
        else {
            gcCoordenadas.clearRect(0,0,515,313);
            //posX = 0;
            //posY = 0;
            //for (int i = 0; i < text.size(); i++) {
            //    if (Objects.equals(text.get(i), "+") || Objects.equals(text.get(i), "-") || Objects.equals(text.get(i), "*") || Objects.equals(text.get(i), "/")) {
            //        Operators.draw(text.get(i), gc, posX);
            //    }
            //    else {
            //        int num = Integer.parseInt(text.get(i));
            //        Numbers.draw(num, gc, posX, posY);
            //    }
            //    posX += 30;
            //}
            ContCoord = 0;
        }
    }

    public void ClickNumero (ActionEvent num){
        String numero = ((Button)num.getSource()).getText();
        textInput.setText(textInput.getText()+numero);
        text.add(numero);
        statusB = statusA;
        statusA = 1;

        switch (numero) {
            case "1" -> {
                Numbers.draw(1, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            case "2" -> {
                Numbers.draw(2, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            case "3" -> {
                Numbers.draw(3, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            case "4" -> {
                Numbers.draw(4, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            case "5" -> {
                Numbers.draw(5, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            case "6" -> {
                Numbers.draw(6, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            case "7" -> {
                Numbers.draw(7, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            case "8" -> {
                Numbers.draw(8, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            case "9" -> {
                Numbers.draw(9, gc, posX, posY);
                posX += 30;
                posY =0;
            }
            default -> {
                if(posY != 60){
                    Numbers.draw(0, gc, posX, posY);
                    posX += 30;
                }
            }
        }
    }



    public void ClickOperadores (ActionEvent oper){
        if (statusA != 2){
            String operador = ((Button)oper.getSource()).getText();
            textInput.setText(textInput.getText()+operador);
            text.add(operador);
            statusB = statusA;
            statusA = 2;
            switch (operador) {
                case"+" ->{
                    Operators.draw("+", gc, posX);
                    posX += 30;
                }
                case"-" ->{
                    Operators.draw("-",gc, posX);
                    posX += 30;
                }
                case"*" ->{
                    Operators.draw("*",gc, posX);
                    posX += 30;
                }
                case"/" ->{
                    posX -=30;
                    Operators.draw("/",gc, posX);
                    posY =60;
                }

            }
        }
    }

    public void ClickPrimerParentesis (ActionEvent par){
        String parentesis = ((Button)par.getSource()).getText();
        textInput.setText(textInput.getText()+parentesis);
        statusB = statusA;
        statusA = 3;
        statusParentesis+=1;

        Operators.draw("(", gc, posX);
        posX +=30;
    }

    public void  ClickSegundoParentesis(ActionEvent par2){
        String parentesis = ((Button)par2.getSource()).getText();
        if(statusParentesis > 0){
            statusParentesis -=1;
            textInput.setText(textInput.getText()+parentesis);
            statusB = statusA;
            statusA = 3;

            Operators.draw(")",gc, posX);
            posX += 30;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        gcCoordenadas = canvasCoordenadas.getGraphicsContext2D();
    }

}