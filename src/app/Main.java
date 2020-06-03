package app;

import util.SubArrayUtil;
import util.Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try{
            int[] array = {1, 2, 4, 5, 6, 8, 9, 10, 11};
            Timer questao4 = new Timer();
            System.out.println(SubArrayUtil.getBiggestSubset(array));
            System.out.println("Tempo decorrido: " + questao4.getTotalTimeInNano() + " nanosegundos");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
