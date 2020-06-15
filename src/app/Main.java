package app;

import util.BruteForceQ4;
import util.DynamicProgrammingQ4;
import util.Timer;

public class Main {

    public static void main(String[] args) {
        try{
            final int arraySize = 1000;
            int[] array = new int[arraySize];
            for (int i=0; i< arraySize; i++){
                array[i] = (int) (Math.random() * 10);
            }
            Timer questao4 = new Timer();
//            System.out.println(BruteForceQ4.getBiggestSubsetBruteForce(array));
            System.out.println(DynamicProgrammingQ4.getBiggestSubsetDynamicProgramming(array));
            System.out.println("Tempo decorrido: " + questao4.getTotalTime());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
