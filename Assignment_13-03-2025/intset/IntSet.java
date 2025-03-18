package intset;

/** class IntSet used to perform all the operations
 * like union, complement, difference, intersection etc.
 */
public class IntSet {
    private final int MAX_SIZE = 1001;
    private final boolean[] booleanSet;
    private int[] set;
    

    //constructor to initialize
    public IntSet(int[] input) {
        if(input == null || input.length == 0){
            throw new AssertionError("Array cannot be empty");
        }
        booleanSet = new boolean[MAX_SIZE];

        // Update boolean set based on input values
        for (int i : input) {
            booleanSet[i] = true;
        }
        createIntArray();
    }

    private IntSet(boolean[] input) {
        booleanSet = input;
        createIntArray();
    }

    private void createIntArray() {
        int size = 0;
      for (boolean b : booleanSet) {
        if (b) size++;
      }

      set = new int[size];
      int idx = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (booleanSet[i]) {
                set[idx] = i;
                idx++;
            }
        }
    }
    

    //getters
    public int[] getSet() {
        return set;
    }

    public boolean[] getBooleanSet() {
        return booleanSet;
    }
    

    // isMember Method
    public boolean isMemeber(int x) {
        return booleanSet[x];
    }

    public int size() {
        return set.length;
    }

    public boolean isSubset(IntSet s) {
        int[] subset = s.getSet();
        for (int subsetItem : subset) {
            if (!this.booleanSet[subsetItem]) {
                return false;
            }
        }

        return true;
    }

    public IntSet getComplement() {
        boolean[] boolArray = new boolean[1001];
        int index = 0;
        for (boolean b : this.booleanSet) {
            boolArray[index] = !b;
            index++;
        }
        return new IntSet(boolArray);
    }

    public IntSet union(IntSet another) {
        boolean[] result = new boolean[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            if (this.booleanSet[i] || another.getBooleanSet()[i]) {
                result[i] = true;
            }
        }
        return new IntSet(result);
    }

    public IntSet intersection(IntSet another) {
        boolean[] result = new boolean[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            if (this.booleanSet[i] && another.booleanSet[i]) {
                result[i] = true;
            }
        }
        return new IntSet(result);
    }
    

    //calculate the difference method
    public IntSet difference(IntSet another) {

        boolean[] result = new boolean[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            if (this.booleanSet[i] && !another.booleanSet[i]) {
                result[i] = true;
            }
        }
        return new IntSet(result);
    }
    

    // to write the output string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean isFirst = true;
        for (int setValue : this.set) {
            if (isFirst)
                isFirst = false;
            sb.append(setValue);
            if (!isFirst)
                sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

}
