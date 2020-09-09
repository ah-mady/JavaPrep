public class Sum {
  public int sumOfIntArray(int[] intArray){
    int sum = 0;
    for (int i = 0; i < intArray.length; i++) {
      sum+= intArray[i];
    }
    return sum;
  }
}
