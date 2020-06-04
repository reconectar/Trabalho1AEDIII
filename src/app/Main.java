package app;

import util.SubArrayUtil;
import util.Timer;

public class Main {

    public static void main(String[] args) {
        try{
            int[] array = {-2, -1, 0, 1, 4, 5, 6, 8, 9, 10, 11, 12, 13};
            Timer questao4 = new Timer();
//            System.out.println(SubArrayUtil.getBiggestSubsetBruteForce(array));
//            System.out.println(SubArrayUtil.getBiggestSubsetDynamicProgramming(array));
            System.out.println("Tempo decorrido: " + questao4.getTotalTimeInNano() + " nanosegundos");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
