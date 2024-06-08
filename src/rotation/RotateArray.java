// Importing required functions
import java.util.*;

class RotateArray {
    static void moveZerosToLeft(int[] nums) {
        // Return if the list is empty
        if (nums.length < 1) {
            return;
        }

        int numsLength = nums.length;

        // Initializing the two markers
        int writeIndex = numsLength - 1;
        int readIndex = numsLength - 1;

        // Iterate read_index marker till the index is less than or equal to 0
        while (readIndex >= 0) {
            // Replacing write_index value with read_index value
            // This step moves the next non-zero value "back" in the array,
            // making space for the zero at the head of the array
            if (nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                writeIndex--;
            }

            readIndex--;
        }

        // Replacing initial values with zeroes
        while (writeIndex >= 0) {
            nums[writeIndex] = 0;
            writeIndex--;
        }
    }

    public static void main(String[] args) {
        int[][] numsList = {{1, 10, 20, 0, 59, 63, 0, 88, 0}, {1, 0, 2, 3, 0}, {0},
                {-1, 0, 0, -2, 9}, {1, 2, 3, 4, 5}, {2}};

        for (int i = 0; i < numsList.length; i++) {
            System.out.println((i + 1) + ". Before list:\t" + Arrays.toString(numsList[i]));
            moveZerosToLeft(numsList[i]);
            System.out.println("   After list:\t" + Arrays.toString(numsList[i]));
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }
}
