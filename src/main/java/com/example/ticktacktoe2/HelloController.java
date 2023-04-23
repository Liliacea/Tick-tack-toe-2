package com.example.ticktacktoe2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Button first;
    @FXML
    private Button second;
    @FXML
    private Button third;
    @FXML
    private Button fourth;
    @FXML
    private Button fifth;
    @FXML
    private Button sixth;
    @FXML
    private Button seventh;
    @FXML
    private Button eighth;
    @FXML
    private Button ninth;
    private enum State {Empty, Cross, Zero;}
    private final static int size = 3;
    boolean indicator = true;
    private State [][] gameField = new State[size][size];
    private void changeState(Button button, int row, int col){
        if(gameField[row][col] == State.Empty){
        gameField[row][col] = indicator?State.Cross:State.Zero;
        button.setText(indicator?"X":"O");
        indicator = !indicator;
        checkResult();
    }
    }
    private boolean checkRows() {

        for (int i = 0; i < size; i++) {
            boolean isGameOver = true;
            State state = gameField[i][0];
            if (state == State.Empty) {
                continue;
            }
            for (int j = 0; j < size; j++) {
                if (gameField[i][j] != state) {
                    isGameOver = false;
                     break;
                }
            }
            if(isGameOver) return true;
        }
        return false;
    }
    private boolean checkColumns(){
        for (int i = 0; i < size; i++) {
        boolean isGameOver = true;
        State state = gameField[0][i];
        if(state==State.Empty){
            continue;
        }
            for (int j = 0; j < size; j++) {
                if(gameField[j][i] != state){
                    isGameOver = false;
                    break;
                }

            }
            if(isGameOver) return true;
        }
        return false;
    }
    private boolean checkDiagonals(){
        State state = gameField[0][0];
        if(state != State.Empty){
            boolean isGameOver = true;
            for (int i = 0; i < size; i++) {
                if(gameField[i][i] != state){
                   isGameOver = false;
                   break;
                }

            } if(isGameOver) return true;
        }
        state = gameField[0][size-1];
        if(state != State.Empty){
            boolean isGameOver = true;
            for (int i = 0; i < size; i++) {
                if(gameField[i][size-i-1] != state){
                    isGameOver = false;
                    break;
                }

            } if(isGameOver) return true;
        }return false;
        }

    private boolean checkEmptyFields(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if(gameField[i][j] == State.Empty){
                   return false;
                }
            }
        } return true;
    }
    private void checkResult(){
        boolean isGameOver = checkDiagonals()||checkRows()||checkColumns()||checkEmptyFields();
        if(isGameOver){
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Игра завершена");
            alert.showAndWait();
        }

    }


    @FXML
    private void initialize(){
        indicator = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                gameField[i][j] = State.Empty;
            }
        }
        first.setText("");
        second.setText("");
        third.setText("");
        fourth.setText("");
        fifth.setText("");
        sixth.setText("");
        seventh.setText("");
        eighth.setText("");
        ninth.setText("");
    }
   @FXML
    private void OnStartButtonClick(){
     initialize();
    }
    @FXML
    private void firstButtonClick(){

        changeState(first,0,0);
    }
    @FXML
    private void secondButtonClick(){

        changeState(second,0,1);
    }
    @FXML
    private void thirdButtonClick(){

        changeState(third,0,2);
    }
    @FXML
    private void fourthButtonClick(){

        changeState(fourth,1,0);
    }
    @FXML
    private void fifthButtonClick(){

        changeState(fifth,1,1);
    }
    @FXML
    private void sixthButtonClick(){

        changeState(sixth,1,2);
    }
    @FXML
    private void seventhButtonClick(){

        changeState(seventh,2,0);
    }
    @FXML
    private void eighthButtonClick(){

        changeState(eighth,2,1);
    }
    @FXML
    private void ninthButtonClick(){

        changeState(ninth,2,2);
    }


}