import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class SortColors {
    public static int[] sortColors (int[] colors) {
        int start = 0;
        int current = 0;
        int end =  colors.length - 1;
        while(current <= end){
            if(colors[current] == 0){
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;
                start++;
                current++;
            }else if(colors[current] == 1){
                current++;
            }else if(colors[current] == 2){
                int temp = colors[current];
                colors[current]= colors[end];
                colors[end] = temp;
                end--;
            }
        }

        return colors;
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {

            int[] sortedColors = SortColors.sortColors(inputs[i].clone());
            System.out.println(Arrays.toString(sortedColors));
        }
    }
}