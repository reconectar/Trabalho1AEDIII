package util;

import java.util.ArrayList;
import java.util.Arrays;

public class SubArrayUtil {

    private static ArrayList<Integer> getSubsetsStartIndex(int array[])
    {
        Arrays.sort(array); //Ordena o vetor
        ArrayList<Integer> indexes = new ArrayList<>();

        int count = 1;
        //No for abaixo, para cada quebra de sequencia, salva o indice da proxima pos
        for (int i = 0; i < array.length - 1; i++) { //Para cada quebra de sequencia, salva o indice da proxima pos
            if (array[i] + 1 != array[i + 1])
                indexes.add(i+1);
        }
        indexes.add(array.length); //usado para garantir que seja adicionado valores até o final do vetor
        return indexes;
    }

    private static ArrayList<ArrayList<Integer>> divideSet(int array[], ArrayList<Integer> indexes){
        int numberOfSubsets = indexes.size();
        int lastIndex = 0;
        ArrayList<ArrayList<Integer>> listOfSubsets = new ArrayList<>();
        ArrayList<Integer> subSet = new ArrayList<>();
        if(array.length > 1){ //Fail safe para o caso do array possuir tamanho = 1
            int j;
            // No for abaixo é utilizado o numero de subconjuntos e seus indices de inicio para gerar os subconjuntos
            for (int i=0; i<numberOfSubsets; i++){
                int subsetEnding = indexes.remove(0);
                for (j=lastIndex;j<subsetEnding;j++){
                    subSet.add(array[j]);
                }
                lastIndex=j;
                listOfSubsets.add(new ArrayList<Integer>(subSet)); // Todos os subconjuntos sao adicionados em um lista dinamica
                subSet.clear();
            }
        }else if(array.length == 1){
            subSet.add(array[0]);
        }
        return listOfSubsets;
    }

    private static ArrayList<Integer> findBiggestSubset(ArrayList<ArrayList<Integer>> listOfSubsets){
        int indexOfBiggest = 0;
        int biggestSize = 0;
        // O for abaixo encontra o maior subconjunto na tentativa e erro e salva seu indice
        for (int i=0; i<listOfSubsets.size(); i++){
            if (listOfSubsets.get(i).size() > biggestSize){
                indexOfBiggest = i;
                biggestSize = listOfSubsets.get(i).size();
            }
        }
        return listOfSubsets.get(indexOfBiggest); // o metodo retorna o subconjunto a partir do indice encontrado
    }

    // Unico metodo publico para encapsular a logica
    public static ArrayList<Integer> getBiggestSubset(int array[]){
        return findBiggestSubset(divideSet(array, getSubsetsStartIndex(array)));
    }

}
