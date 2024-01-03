import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc1","abc2","abc3"})
    void testCase1(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,10})
    void testCase2(int numbers){
        Assertions.assertEquals(0,numbers % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc1","abc2","abc3"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String args){
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String args){
        assertNotNull(args);

    }

    static String[] stringProvider(){
        return new String[]{"abc1","abc2","abc3"};
    }

    @ParameterizedTest
    @CsvSource({"10,20,30","20,20,40","30,20,100"})
    void testCase5(int num1,int num2,int result){
        assertEquals(result,Calculator.add(num1,num2));

    }

    @ParameterizedTest
   @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)
    void testCase6(int num1,int num2,int result){
        assertEquals(result,Calculator.add(num1,num2));

    }

}
