package arrayMerging;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    final String path;
    final DecimalFormat df = new DecimalFormat("#.###");
    int nOfArrays;

    public static void main(String args[]) throws IOException {
        Main main = new Main();
    }

    /**
     * runs the sorting algorithm, prints time taken, writes output to output.txt
     * @throws IOException not bothering to handle an actual exception correctly lol
     */
    public Main() throws IOException {
        path = getInput();
        long startTime = System.nanoTime();

        Integer[][] arrays = split(
                read(new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))))));

        System.out.println("Sorting");

        Sorter sorter = new Sorter(arrays);
        sorter.run(); //forgot about due date, did not have time to multithread

        String[] results = sorter.getResults();
        System.out.println("Finished");
        write(results);

        long endTime = System.nanoTime();
        long execTime = (endTime - startTime);
        System.out.println("Took : " + (double) execTime /  1000000000. + " second(s)");
    }

    /**
     * writes the end result to a file
     * 
     * @param results end result
     */
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
            writer.write(st+' ');
        }
        writer.close();
    }

    /**
     * splits the raw lines into arrays
     * 
     * @param lines raw lines from file
     */
    public Integer[][] split(String[] lines) {
        String[] firstline = lines[0].split("\\s");
        nOfArrays = Integer.parseInt(firstline[1]);
        Integer[][] arrays = new Integer[nOfArrays][];
        for (int i = 0; i < arrays.length; i++) {
            int arraySize = Integer.parseInt(lines[i + 1].split("\\s")[0]);
            Integer[] array = new Integer[arraySize];
            String[] line = lines[i + 1].split("\\s");
            for (int j = 1; j < line.length; j++) {
                array[j - 1] = Integer.parseInt(line[j]);
            }
            arrays[i] = array;
        }
        return arrays;
    }

    /**
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

    /**
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
