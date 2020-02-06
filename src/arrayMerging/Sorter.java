package src.arrayMerging;

public class Sorter{
    /**
     * arrays: stores the input arrays
     * iterations: stores the current index of each array
     * size: stores the size of each array
     */
    private final int[][] arrays;
    private final int[] iterations;
    private final int[] size;
    private boolean[] states;

    private final int[] retval;

    public Sorter(int[][] arrays, int maxSize) {
        this.arrays = arrays;
        this.retval = new int[maxSize];
        this.iterations = new int[arrays.length];
        this.size = new int[arrays.length];
        for (int i = 0; i < this.arrays.length; i++) {
            this.size[i] = arrays[i].length;
        }
    }
    public int[] sort(){
        for(int i = 0; i<arrays.length; i++){
            if(iterations[i]<size[i]){

            }
        }
        return retval;
    }
    /**
     * iterate through arrays if( 2 or more are same ) -> place that value, move all
     * indices up one if( 1 is greater than others) -> stop iterating through it,
     * iterate through non-frozens until an equal or greater value is found
     */
}