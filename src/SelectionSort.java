import java.io.*;
import java.util.*;

public class SelectionSort {

    // Declaring vaiables
    int[] data;
    int[] sorted_data;

    // Constructor for initializing variables
    SelectionSort(int size) {
        data = new int[size];
        sorted_data = new int[size];
    }

    // Main method for running the program
    public static void main(String[] args) throws IOException {
        SelectionSort bs = new SelectionSort(10);
        bs.input();
        bs.sort();
        bs.output();
    }

    // Input method for taking inputs from the user
    void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the array elements below:-");
        for (int i = 0; i < data.length; i++) {
            System.out.print("Enter an integer at [" + i + "]: ");
            data[i] = Integer.parseInt(in.readLine());
        }
    }

    // Sorting method for sorting the array in ascending order
    void sort() {
        int[] temp_data = new int[data.length];
        for (int i = 0; i < data.length; i++)
            temp_data[i] = data[i];

        for (int i = 0, l = temp_data.length; i < l - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < l; j++)
                if (temp_data[j] < temp_data[min_idx])
                    min_idx = j;

            int temp = temp_data[min_idx];
            temp_data[min_idx] = temp_data[i];
            temp_data[i] = temp;
        }

        for (int i = 0; i < temp_data.length; i++)
            sorted_data[i] = temp_data[i];
    }

    // Output method for displaying the results
    void output() {
        System.out.println("Original array - " + Arrays.toString(data));
        System.out.println("Sorted array - " + Arrays.toString(sorted_data));
    }
}
