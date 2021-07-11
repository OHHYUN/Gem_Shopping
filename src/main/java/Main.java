import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] answer = solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        Arrays.stream(answer).forEach(
                x -> System.out.println(x)
        );
    }

    public static int[] solution(String[] gems) {
        HashSet<String> hashSet = new HashSet<>(); // 보석의 종류
        HashMap<String, Integer> hashMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        int startPoint = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        for(String gem : gems){
            hashSet.add(gem);
        }

        for(int i = 0; i<gems.length; i++){
            if(!hashMap.containsKey(gems[i])){
                hashMap.put(gems[i], 1);
            }else{
                hashMap.replace(gems[i], hashMap.get(gems[i]) + 1);
            }

            queue.add(gems[i]);
//            System.out.println("queue = " + queue.size());
//            System.out.println("length = " + length);
            while(true) {
                String firstGem = queue.peek();
                if (hashMap.get(firstGem) > 1) {
                    hashMap.replace(firstGem, hashMap.get(firstGem) - 1);
                    queue.poll();
                    startPoint++;
                }else{
                    break;
                }
            }
            if(hashMap.size() == hashSet.size() && length > queue.size()){
                start = startPoint;
                length = queue.size();
            }
        }

//        System.out.println(hashSet.toString());

        int[] answer = {start + 1 , start + length};
        return answer;
    }

}
