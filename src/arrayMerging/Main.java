package arrayMerging;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Arrays;

public class Main {
    final String path;
    final DecimalFormat df = new DecimalFormat("#.###");

    public static void main(String args[]) throws IOException {
        Main main = new Main();
    }

    public Main() throws IOException {
        path = getInput();
        long startTime = System.nanoTime();

        int[][] arrays = split(read(setReader(path)));

        System.out.println("Getting averages");
        MergeSort sorter = new MergeSort(arrays);
        String[] results =sorter.thing();
        System.out.println("Got averages");

        write(results);

        long endTime = System.nanoTime();
        long execTime = (endTime - startTime);
        System.out.println("Took : " + execTime / (long) 1000000000 + " second(s)");
    }

    public void write(String[] results) throws IOException {
        Pattern pattern = Pattern.compile("\\\\|/");
        String[] pathParts = pattern.split(path);
        String outPath = "";
        char separator = '/';
        if (System.getProperty("os.name").startsWith("Windows")) {
            separator = '\\';
        }
        for (int i = 0; i < pathParts.length - 1; i++) {
            outPath += pathParts[i] + separator;
        }
        outPath += "output.txt";
        System.out.println(outPath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(outPath));
        for (String st : results) {
            writer.write(st);
            writer.newLine();
        }
        writer.close();
    }

    /*
     * parses the queries
     * 
     * @param string queries from file
     * 
     * @return the queries
     */
    private int[][] getArrays(String[] raw) {
        int[][] out = new int[raw.length][2];
        Pattern pattern = Pattern.compile("\\s");
        String[] temp;
        for (int i = 0; i < raw.length; i++) {
            temp = pattern.split(raw[i]);
            for (int j = 0; j < 2; j++) {
                out[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return out;
    }

    /*
     * splits the raw lines into queries and numbers
     * 
     * @param lines raw lines from file
     */
    public int[][] split(String[] lines) {
        String[] firstline = lines[0].split("[0-9]+");
        int nOfArrays = Integer.parseInt(firstline[1]);
        int[][] arrays = new int[nOfArrays][];
        for (int i = 0; i < arrays.length; i++) {
            int arraySize = Integer.parseInt(lines[i + 1].split("[0-9]+")[0]);
            int[] array = new int[arraySize];
            String[] line = lines[i + 1].split("[0-9]+");
            for (int j = 0; j < line.length; j++) {
                array[j] = Integer.parseInt(line[j + 1]);
            }
            arrays[i] = array;
        }
        return arrays;
    }

    /*
     * sets the reading file
     * 
     * @param path of file
     * 
     * @return the reader to be used
     */
    public BufferedReader setReader(String path) throws FileNotFoundException {
        File input = new File(path);
        FileInputStream fis = new FileInputStream(input);
        InputStreamReader isr = new InputStreamReader(fis);
        return new BufferedReader(isr);
    }

    /*
     * reads file, gives lines
     * 
     * @param br the reader
     * 
     * @return the lines
     */
    private String[] read(BufferedReader br) throws IOException {
        ArrayList<String> outList = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            outList.add(line);
        }
        String[] out = new String[outList.size()];
        for (int i = 0; i < outList.size(); i++) {
            out[i] = outList.get(i);
        }
        br.close();
        return out;
    }

    /*
     * gets the path for read file
     * 
     * @return filepath
     */
    private String getInput() {
        Scanner in = new Scanner(System.in);
        System.out.println(
                "Enter (full) file path. Note that an output file will be created or overwritten in this directory");
        String out = in.nextLine();
        in.close();
        return out;
    }
}
