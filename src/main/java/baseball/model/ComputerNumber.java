package baseball.model;

import java.util.HashMap;
import java.util.Random;

public class ComputerNumber {
    private final HashMap<Integer,Integer> answer;
    Random random = new Random();

    public ComputerNumber() {
        this.answer = getComputerNumber();
    }

    public HashMap<Integer, Integer> getAnswer() {
        return answer;
    }

    public HashMap<Integer, Integer> getComputerNumber() {
        HashMap<Integer,Integer> answer = new HashMap<>();

        int START_NUMBER = 1;
        int END_NUMBER = 3;

        for (int i = START_NUMBER; i <= END_NUMBER; i++){
            int randomNumber = getRandomNumber();
            if (answer.containsKey(randomNumber)){
                i--;
                continue;
            }
            answer.put(randomNumber,i);
        }
        return answer;
    }

    public int getRandomNumber(){
        return random.nextInt(9) + 1;
    }

}
