package solutions.pack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void printAllSubsets_Recursive(List<Integer> set) {
        List<Integer> currentSubset = new ArrayList<>();
        List<List<Integer>> allSubsets = new ArrayList<>();
        printAllSubsets_Recurse_Helper(set, currentSubset, 0, allSubsets);
        System.out.println(allSubsets);
    }

    private static void printAllSubsets_Recurse_Helper(List<Integer> set, List<Integer> currentSubset, int index, List<List<Integer>> allSubsets) {
        if (index == set.size()) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        currentSubset.add(set.get(index));
        printAllSubsets_Recurse_Helper(set, currentSubset, index + 1, allSubsets);

        currentSubset.remove(currentSubset.size() - 1);
        printAllSubsets_Recurse_Helper(set, currentSubset, index + 1, allSubsets);
    }

    public static void printAllSubsets_DP(List<Integer> set) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        allSubsets.add(new ArrayList<>()); 

        for (Integer element : set) {
            List<List<Integer>> newSubsets = new ArrayList<>();

            for (List<Integer> subset : allSubsets) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(element);
                newSubsets.add(newSubset);
            }

            allSubsets.addAll(newSubsets);
        }

        System.out.println(allSubsets);
    }



    public static void main(String[] args) {
        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        printAllSubsets_Recursive(set);
        printAllSubsets_DP(set);
    }

}
