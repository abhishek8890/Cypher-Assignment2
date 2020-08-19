// Java program  to replace each element by its rank in the given array

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

class Rank
{
public static void transform(int[] arr)
{
Map<Integer, Integer> map = new TreeMap<>();

for (int i = 0; i < arr.length; i++) {
map.put(arr[i], i);
}

int rank = 1;

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
arr[entry.getValue()] = rank++;
}
}

public static void main(String[] args)
{
int[] A = { 13, 6, 7, 11, 9, 20, 1 };

transform(A);

System.out.println(Arrays.toString(A));
}
}