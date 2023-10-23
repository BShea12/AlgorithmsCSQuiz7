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
        * Complete the 'icecreamParlor' function below.
        *
        * The function is expected to return an INTEGER_ARRAY.
        * The function accepts following parameters:
        *  1. INTEGER m
        *  2. INTEGER_ARRAY arr
        */
        public static List<Integer> icecreamParlorHelp(int m, List<Integer> arr, int alreadyFound1, int alreadyFound2){
        if(alreadyFound1 != -1){
            
            
            if(alreadyFound2 != -1){
                int max = 0;
                for(int i = alreadyFound2; i< arr.size();i++){
                    if(arr.get(i) > arr.get(max) & arr.get(i) + alreadyFound1 + alreadyFound2 < m){
                        max = i;
                    }
                        if(max == 0){
                            return -1;
                        }
                        return [i];
                    }
                }
                
                int maxNum = -1;
                int found2 = -1;
                int found3 = -1;
                
                
                for(int i = alreadyFound1; i <arr.size();i++){
                    int ans = iceCreamParlorHelp(m, arr, alreadyFound1, i)
                    if(arr.get(ans) + arr.get(i) > max & alreadyFound1 + arr.get(i) + arr.get(ans) < m){
                        max = arr.get(ans) + arr.get(i);
                        found2 = i;
                        found3 = ans;
                    }
                    if(max == -1){
                        return [-1,-1];
                    }
                    return [found2, found3];
                }  
        }  
            int maxNum = -1;
            int found1 = -1;
            int found2 = -1;
            int found3 = -1;
            for(int i = 0; i <arr.size();i++){
                int ans = iceCreamParlorHelp(m, arr, i, -1)
                if(arr.get(ans[0]) + arr.get(ans[1]) + arr.get(i) > max & + arr.get(i) + arr.get(ans)[1] + arr.get(ans[0]) < m){
                    max = arr.get(ans[0]) + arr.get(ans[1]) + arr.get(i);
                    found1 = i;
                    found2 = ans[0];
                    found3 = ans[1]
                }
            }
                if(max == -1){
                    return [-1,-1, -1];
                }
                return [found1, found2, found3];      
        
        
        
        
        
        }
        
        public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        
            
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    int m = Integer.parseInt(bufferedReader.readLine().trim());

                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                    List<Integer> result = Result.icecreamParlor(m, arr);

                    bufferedWriter.write(
                        result.stream()
                            .map(Object::toString)
                            .collect(joining(" "))
                        + "\n"
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }
