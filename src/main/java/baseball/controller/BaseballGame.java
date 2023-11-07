package baseball.controller;

import baseball.model.ComputerNumber;
import global.ValidationInput;
import view.InputView;

import java.io.IOException;
import java.util.HashMap;

public class BaseballGame {
    private InputView inputView;
    private ValidationInput validationInput;
    private ComputerNumber computerNumber;

    public BaseballGame() {
        this.inputView = new InputView();
        this.validationInput = new ValidationInput();
        this.computerNumber = new ComputerNumber();
    }

    public void play() throws IOException {
        HashMap<Integer, Integer> answer = computerNumber.getAnswer();
        String userNumber = validationNumber();

        int strike = 0;
        int ball = 0;

        if (answer.get(Character.getNumericValue(userNumber.charAt(0))) != null) {
            if (answer.get(Character.getNumericValue(userNumber.charAt(0))).equals(1)) {
                strike = strike + 1;
            } else {
                ball = ball + 1;
            }
        }

        if (answer.get(Character.getNumericValue(userNumber.charAt(1))) != null) {
            if (answer.get(Character.getNumericValue(userNumber.charAt(1))).equals(2)) {
                strike = strike + 1;
            } else {
                ball = ball + 1;
            }
        }

        if (answer.get(Character.getNumericValue(userNumber.charAt(2))) != null) {
            if (answer.get(Character.getNumericValue(userNumber.charAt(2))).equals(3)) {
                strike = strike + 1;
            } else {
                ball = ball + 1;
            }
        }

        if (strike == 3) {
            System.out.println("정답입니다.");
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫씽");
        }

        if (strike > 0 && ball == 0) {
            System.out.printf("%s 스트라이크%s", strike, System.lineSeparator());
        }

        if (strike == 0 && ball > 0) {
            System.out.printf("%s 볼%s", ball, System.lineSeparator());
        }

        if (strike > 0 && ball > 0) {
            System.out.printf("%s 스트라이크, %s 볼%s", strike, ball, System.lineSeparator());
        }
    }

    public String validationNumber() throws IOException {
        String input;
        while (true) {
            input = inputView.getInput();
            if (validationInput.isValidationAll(input)){
                break;
            }
        }
        return input;
    }

}
