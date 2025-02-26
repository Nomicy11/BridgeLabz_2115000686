package org.JSON;



import java.io.*;

public class IplCensorCsv {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("ipl.csv"));
             PrintWriter pw = new PrintWriter(new FileWriter("ipl_censored.csv"))) {

            String header = br.readLine();
            pw.println(header);  // Write header as is

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                fields[1] = fields[1].replaceAll(" ([A-Za-z]+)$", " ***");  // Team1
                fields[2] = fields[2].replaceAll(" ([A-Za-z]+)$", " ***");  // Team2
                fields[6] = "REDACTED";  // Player of the match

                pw.println(String.join(",", fields));
            }

            System.out.println("Censored CSV file created!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
