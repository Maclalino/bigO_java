import java.util.ArrayList;
import java.util.List;

public class Subconjuntos {

    public static List<List<Integer>> encontrarSubconjuntos(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        encontrarSubconjuntos(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void encontrarSubconjuntos(int[] nums, int index, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset)); // Adiciona o subconjunto atual à lista de resultados

        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]); // Adiciona o elemento atual ao subconjunto
            encontrarSubconjuntos(nums, i + 1, subset, result); // Recursivamente encontra subconjuntos a partir do próximo índice
            subset.remove(subset.size() - 1); // Remove o elemento atual para explorar outras possibilidades
        }
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        List<List<Integer>> subconjuntos = encontrarSubconjuntos(conjunto);

        System.out.println("Subconjuntos:");
        for (List<Integer> subset : subconjuntos) {
            System.out.println(subset);
        }
    }
}
