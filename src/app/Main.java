package app;

import util.BruteForceQ4;
import util.DynamicProgrammingQ4;
import util.Timer;

public class Main {

    public static void main(String[] args) {
        try{
            int[] array = {-2, -1, 0, 1, 0, 5, 6, 8, 9, 10, 11, 12, 13};
            Timer questao4 = new Timer();
            System.out.println(BruteForceQ4.getBiggestSubsetBruteForce(array));
//            System.out.println(DynamicProgrammingQ4.getBiggestSubsetDynamicProgramming(array));
            System.out.println("Tempo decorrido: " + questao4.getTotalTime());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
