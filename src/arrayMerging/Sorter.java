package arrayMerging;

import java.util.ArrayList;

public class Sorter extends Thread {
    // unit test
    public static void main(String[] args) {

    }

    Integer[][] arrays;
    /**
     * merges all arrays sequentially
     */
    @Override
    public void run() {
        for (int i = 1; i < arrays.length; i++) {
            arrays[0]=merge(arrays[0],arrays[i]);
        }
    }
    /**
     * constructs sorter with arrays
     * @param arrays arrays to be sorted
     */
    Sorter(Integer[][] arrays) {
        this.arrays = arrays;
    }
    /**
     * merges two sorted arrays into one
     * @param leftArr array one
     * @param rightArr array two
     * @return a single sorted array with both inputs, with repeats removed
     */
    public Integer[] merge(Integer[] leftArr, Integer[] rightArr) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int j = 0;
        //so as to iterate over both arrays as long as their index isn't exceeded
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                if (arr.size() == 0) { //dont get a indexoutofbounds on first iter
                    arr.add(leftArr[i]);
                } else if (leftArr[i] != arr.get(arr.size() - 1)) { //skip repeats
                    arr.add(leftArr[i]);
                }
                i++; 
            } else if (leftArr[i] == rightArr[j]) {
                if (arr.size() == 0) { //dont get a indexoutofbounds on first iter
                    arr.add(leftArr[i]);
                } else if (leftArr[i] != arr.get(arr.size() - 1)) { //skip repeats
                    arr.add(leftArr[i]);
                }
                i++;
                j++;
            } else {
                if (arr.size() == 0) { //dont get a indexoutofbounds on first iter
                    arr.add(rightArr[i]);
                } else if (rightArr[j] != arr.get(arr.size() - 1)) { //skip repeats
                    arr.add(rightArr[j]);
                }
                j++;
            }

        }

        while (i < leftArr.length) { //add rest
            arr.add(leftArr[i]);
            i++;
        }

        while (j < rightArr.length) { //add rest
            arr.add(rightArr[j]);
            j++;
        }

        return arr.toArray(new Integer[arr.size()]);
    }
    /**
     * returns output as a string
     * @return string-ified result
     */
    public String[] getResults() {
        String[] st = new String[arrays[0].length];
        for (int i = 0; i < arrays[0].length; i++) {
            st[i] = "" + arrays[0][i];
        }
        return st;
    }
}