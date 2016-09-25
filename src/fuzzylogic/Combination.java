/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

/**
 *
 * @author Husnayain
 */

public class Combination 
{
    static void printCombinations(String[] sequence, int N) 
    {
        String[] data = new String[N];
        for (int r = 0; r < sequence.length; r++)
            combinations(sequence, data, 0, N - 1, 0, r);
    }
 
    static void combinations(String[] sequence, String[] data, int start, int end,
            int index, int r) 
    {
 
        if (index == r) 
        {
            for (int j = 0; j < r; j++)
                System.out.print(data[j] + " ");
            System.out.println();
        }
 
        for (int i = start; i <= end && ((end - i + 1) >= (r - index)); i++) 
        {
            data[index] = sequence[i];
            combinations(sequence, data, i + 1, end, index + 1, r);
        }
    }
 
//    public static void main(String args[]) 
//    {
//        String[] sequence = { "low", "mid", "high","mid","low"};
//        System.out.print("The combinations are: ");
//        printCombinations(sequence, sequence.length);
//    }
}