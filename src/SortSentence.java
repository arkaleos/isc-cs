import java.io.*;
import java.util.*;

public class SortSentence {

    // Declaring vaiables
    String sent, rsent;
    String[] data;
    boolean term;

    // Constructor for initializing variables
    SortSentence() {
        sent = "";
        rsent = "";
        term = false;
    }

    // Main method for running the program
    public static void main(String[] args) throws IOException {
        SortSentence ss = new SortSentence();
        ss.input();
        ss.checkTermination();
        ss.compute();
        ss.output();
    }

    // Input method for taking inputs from the user
    void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Input: ");
        sent = in.readLine().toLowerCase();
    }

    // Check method to check if the sentence is terminated successfully
    void checkTermination() {
        if (sent.charAt(sent.length() - 1) == '.' || sent.charAt(sent.length() - 1) == '?' || sent.charAt(sent.length() - 1) == '!')
            term = true;
    }

    // Compute method for computing the data
    void compute() {
        StringTokenizer st = new StringTokenizer(sent, " .?!");

        data = new String[st.countTokens()];

        for (int i = 0, l = st.countTokens(); i < l; i++)
            data[i] = st.nextToken();

        for (int i = 0, l = data.length; i < l - 1; i++)
            for (int j = 0; j < l-i-1; j++)
                if (data[j].length() > data[j + 1].length()) {
                    String temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }

        for (int i = 0; i < data.length; i++) {
            if (i > 0)
                rsent += ' ';
            
            rsent += data[i];
        }

        rsent += sent.charAt(sent.length() - 1);

        String temp = Character.toUpperCase(sent.charAt(0)) + "";
        temp += sent.substring(1);
        sent = temp;
        rsent = Character.toUpperCase(rsent.charAt(0)) + rsent.substring(1);
    }

    // Output method for displaying the results
    void output() {
        if (term) {
            System.out.println("Output: " + sent);
            System.out.println("Output: " + rsent);
        }

        else
            System.out.println("Output: The entered sentence was not terminated successfully.");
    }
}
