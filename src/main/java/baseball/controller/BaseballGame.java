package baseball.controller;

import baseball.model.ComputerNumber;
import global.ValidationInput;
import view.InputView;

import java.io.IOException;
import java.util.HashMap;

public class BaseballGame {
    private final InputView inputView;
    private final ValidationInput validationInput;

    public BaseballGame() {
        this.inputView = new InputView();
        this.validationInput = new ValidationInput();
    }

    public void play() throws IOException {


        while (true) {
            ComputerNumber computerNumber = new ComputerNumber();
            HashMap<Integer, Integer> answer = computerNumber.getAnswer();

            while (true) {
                String userNumber = validationNumber();
                if (!validationStrikeAndBall(answer, userNumber)) {
                    break;
                }

            }

            if (inputView.isExit()) {
                return;
            }
        }
    }

    public String validationNumber() throws IOException {
        String input;

        do {
            input = inputView.getUserNumber();
        } while (!validationInput.isValidationAll(input));

        return input;
    }

    public boolean validationStrikeAndBall(HashMap<Integer, Integer> answer, String userNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userNumber.length(); i++) {
            int digit = Character.getNumericValue(userNumber.charAt(i));
            Integer answerValue = answer.get(digit);

            if (answerValue != null) {
                if (answerValue.equals(i + 1)) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }

        if (strike == 3) {
            System.out.println("정답입니다.");
            return false;
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫씽");
            return true;
        }

        if (strike > 0 && ball == 0) {
            System.out.printf("%s 스트라이크%s", strike, System.lineSeparator());
            return true;
        }

        if (strike == 0 && ball > 0) {
            System.out.printf("%s 볼%s", ball, System.lineSeparator());
            return true;
        }

        if (strike > 0 && ball > 0) {
            System.out.printf("%s 스트라이크, %s 볼%s", strike, ball, System.lineSeparator());
            return true;
        }
        return true;
    }



}
