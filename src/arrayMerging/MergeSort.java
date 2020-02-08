package arrayMerging;

import java.util.ArrayList;

class MergeSort {
    int[][] arrays;
    public MergeSort(int[][] arrays) {
        this.arrays = arrays;
    }

    private int[] merge(int firstArray[], int secondArray[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        int firstSize = firstArray.length;
        int secondSize = secondArray.length;
        int i = 0, j = 0;

        while (i < firstSize && j < secondSize) {
            if (firstArray[i] < secondArray[j]) {
                arr.add(firstArray[i]);
                i++;
            } else if (firstArray[i] == secondArray[j]) {
                arr.add(firstArray[i]);
                i++;
                j++;
            } else {
                arr.add(secondArray[j]);
                j++;
            }
        }

        while (i < firstSize) {
            arr.add(firstArray[i]);
            i++;
        }

        while (j < secondSize) {
            arr.add(secondArray[j]);
            j++;
        }
        int[] ret = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            ret[k] = arr.get(k);
        }
        return ret;
    }

    public String[] thing(){
        int[] rawRet;
        String[] ret;
        ArrayList<int[]> temps = new ArrayList<>();
        for(int i = 0; i < arrays.length/2; i++){
            temps.add(merge(arrays[i], arrays[i+1]));
        }
        while(temps.size()>1){
            for(int i = 0; i< temps.size()/2; i++){
                int[] metaTemp = merge(temps.get(i), temps.get(i+1));
                temps.remove(i);
                temps.remove(i+1);
            }
        }
        if(arrays.length%2==1){
            rawRet = merge(arrays[arrays.length-1], temps.get(0));
        }else{
            rawRet = temps.get(0);
        }
        ret = new String[rawRet.length];
        for(int i = 0; i < rawRet.length; i++){
            ret[i]=""+rawRet[i];
        }
        return ret;
    }
}