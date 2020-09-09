import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SumTest {

  Sum sum;
  int [] intArray;

  @BeforeEach
  public void setSum(){
    sum = new Sum();
  }

  @Test
  void sumFunctionWithPositiveInt() {
    intArray = new int[] {1, 2, 3, 4, 5};
    assertEquals(15,sum.sumOfIntArray(intArray));
  }

  @Test
  void sumFunctionWithNegativeInt() {
    intArray = new int[] {-1, -2, -3, -4, -5};
    assertEquals(-15,sum.sumOfIntArray(intArray));
  }

  @Test
  void sumFunctionWithEmptyList() {
    intArray = new int[] {};
    assertEquals((Integer) 0,sum.sumOfIntArray(intArray));
  }

  @Test()
  void sumFunctionWithNull() {
    intArray =  null;
    Assertions.assertThrows(NullPointerException.class, () -> sum.sumOfIntArray(intArray));
  }
}