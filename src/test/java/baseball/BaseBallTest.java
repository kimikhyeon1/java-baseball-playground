package baseball;

import baseball.model.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;

public class BaseBallTest {
    //given
    //when
    //then

    @Test
    @DisplayName("컴퓨터 숫자 생성 테스트")
    void CREATE_RANDOM_NUMBER_TO_COMPUTER(){
        //given
        Computer computer = new Computer();
        computer.getComputerNumber();

        //when
        HashMap<Integer,Integer> number = computer.getAnswer();


        //then
        assertThat(number.size()).isEqualTo(3);
    }
}
