import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baseballGame{
    public static void main(String[]args) throws IOException {
        Random rd = new Random();

        HashMap<String,String> baseballNumberSpace = new HashMap<>();

        for (int i = 1; i < 4; i++){
            String randomNumber = Integer.toString(rd.nextInt(9) + 1);
            if (baseballNumberSpace.containsKey(randomNumber)){
                i--;
                continue;
            }
            baseballNumberSpace.put(randomNumber,Integer.toString(i));
        }

        for (Map.Entry<String, String> entrySet : baseballNumberSpace.entrySet()){
            System.out.println(entrySet.getKey() +" " + entrySet.getValue() );
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String str = reader.readLine();

            if (str.isEmpty() || str.contains(" ")) {
                System.out.println("공백을 입력하셨습니다.");
                continue;
            }

            if (str.length() != 3) {
                System.out.println("3자리를 입력해 주세요.");
                continue;
            }

            if (str.contains("0")) {
                System.out.println("1~9를 입력해 주세요.");
                continue;
            }

            Set<Character> test = new HashSet<>();
            boolean isDuplicate = false;

            for (int i = 0; i < str.length(); i++) {
                char word = str.charAt(i);
                if (!test.add(word)) {
                    System.out.println("숫자는 중복되면 안됩니다.");
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                continue;
            }

            int strike = 0;
            int ball = 0;

            if (baseballNumberSpace.get(String.valueOf(str.charAt(0))) != null) {
                if (baseballNumberSpace.get(String.valueOf(str.charAt(0))).equals("1")) {
                    strike = strike + 1;
                } else {
                    ball = ball + 1;
                }
            }

            if (baseballNumberSpace.get(String.valueOf(str.charAt(1))) != null) {
                if (baseballNumberSpace.get(String.valueOf(str.charAt(1))).equals("2")) {
                    strike = strike + 1;
                } else {
                    ball = ball + 1;
                }
            }

            if (baseballNumberSpace.get(String.valueOf(str.charAt(2))) != null) {
                if (baseballNumberSpace.get(String.valueOf(str.charAt(2))).equals("3")) {
                    strike = strike + 1;
                } else {
                    ball = ball + 1;
                }
            }

            if (strike == 3) {
                System.out.println("정답입니다.");
                break;
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
    }
}
