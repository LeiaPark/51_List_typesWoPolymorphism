/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    private int[]    intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list

    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
       intElements = new int[INITIAL_CAPACITY];
       doubleElements = new double[INITIAL_CAPACITY];
       stringElements = new String[INITIAL_CAPACITY];
       typeOfElements = new int[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
      return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
      String result = "[";
      for (int i = 0; i < filledElements; i++) {
        if (typeOfElements[i] == 0)
          result += intElements[i] + ",";
        if (typeOfElements[i] == 1)
          result += doubleElements[i] + ",";
        if (typeOfElements[i] == 2)
          result += stringElements[i] + ",";
        }
      return result + "]";
}



    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int intValue
                       , double doubleValue
                       , String stringValue
                       ) {
            if (filledElements >= typeOfElements.length) expand();
            if (type == 0)
              intElements[filledElements] = intValue;
              typeOfElements[filledElements] = 0;
            if (type == 1)
              doubleElements[filledElements] = doubleValue;
              typeOfElements[filledElements] = 1;
            if (type == 2)
              stringElements[filledElements] = stringValue;
              typeOfElements[filledElements] = 2;
            filledElements++;
            return true;

     }


    private void expand() {
        System.out.println( "expand... (for debugging)");
        int ctr0 = typeOfElements.length - 1;
        int[] newList1 = new int[typeOfElements.length * 2];
        while (ctr0 >= 0) {
            newList1[ctr0] = typeOfElements[ctr0];
            ctr0 = ctr0 - 1;
        }
        typeOfElements = newList1;

        int ctr1 = intElements.length - 1;
        int[] newList2 = new int[intElements.length * 2];
        while (ctr1 >= 0) {
            newList2[ctr1] = intElements[ctr1];
            ctr1 = ctr1 - 1;
        }
        intElements = newList2;

        int ctr2 = doubleElements.length - 1;
        double[] newList3 = new double[doubleElements.length * 2];
        while (ctr2 >= 0) {
            newList3[ctr2] = doubleElements[ctr2];
            ctr2 = ctr2 - 1;
        }
        doubleElements = newList3;

        int ctr3 = stringElements.length - 1;
        String[] newList4 = new String[stringElements.length * 2];
        while (ctr3 >= 0) {
            newList4[ctr3] = stringElements[ctr3];
            ctr3 = ctr3 - 1;
        }
        stringElements = newList4;
    }
}
