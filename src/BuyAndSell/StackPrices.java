// Importing required functions
import java.util.*;

// Creating a tuple class as java does not support returning
// multiple arguments
class Tuple<X, Y>{
    public X x;
    public Y y;

    public Tuple(X x , Y y){
        this.x = x;
        this.y = y;
    }
}


class StockPrices {
        public static Tuple<Integer, Integer> findBuySellStockPrices(int[] stackNums){
            if(stackNums == null || stackNums.length < 2){
                return null;
            }

            int currentBuy = stackNums[0];
            int globalSell = stackNums[1];

            int globalProfit =  globalSell-currentBuy;
            int currentProfit =Integer.MIN_VALUE;

            for (int i = 0; i < stackNums.length; i++)
            {
                currentProfit = stackNums[i] - currentBuy;
                if(currentProfit > globalProfit)
                {
                    globalProfit = currentProfit;
                    globalSell = stackNums[i];
                }

                if(currentBuy > stackNums[i])
                {
                    currentBuy = stackNums[i];
                }
            }
            Tuple<Integer, Integer> result = new Tuple<>(globalSell - globalProfit,globalSell);
            return result;
    }

    public static void main(String[] args) {

        int[][] stockPricesData =
                {{1, 2, 3, 4, 3, 2, 1, 2, 5}, {8, 6, 5, 4, 3, 2, 1}, {12, 30, 40, 90, 110}, {2}};

        for (int i = 0; i < stockPricesData.length; i++) {
            Tuple<Integer, Integer> result = findBuySellStockPrices(stockPricesData[i]);
            System.out.println((i + 1) + ". Day stocks: " + Arrays.toString(stockPricesData[i]));
            if (result != null) {
                System.out.println("   Buy Price: " + result.x + ", Sell Price: " + result.y);
            } else {
                System.out.println("   Buy Price: null, Sell Price: null");
            }
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------\n");
        }
    }
}
