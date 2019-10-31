import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here

        //Initialization
        int lastAnswer = 0;
        int x =0, y =0, size =0, query =0, value;

        List<Integer> answerList = new ArrayList<Integer>();
        List<List<Integer>> seqList = new ArrayList<>();

        // Accept the input in the Sequence List
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList());
        }

        
        for (int i = 0; i < queries.size(); i++) {
            
            query = queries.get(i).get(0);
            x = queries.get(i).get(1);
            y = queries.get(i).get(2);
            value = (x ^lastAnswer) %n;
            if (query == 1) {
                seqList.get(value).add(y);
            } else if (query == 2) {
                size = seqList.get(value).size();
                lastAnswer = seqList.get(value).get(y %size);
                answerList.add(lastAnswer);
            }
        }
        return answerList;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
