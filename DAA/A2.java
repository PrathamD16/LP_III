import java.util.*;

class HuffManNode implements Comparable<HuffManNode> {
    char data;
    int frequency;
    HuffManNode left, right;

    public HuffManNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffManNode node) {
        return this.frequency - node.frequency;
    }
}

public class A2 {
    static HashMap<Character,String>buildHuffmanCodes(char data[], int freq[]){
        // s = s.replaceAll("\\s", "");
        HashMap<Character,Integer>freqCount = new HashMap<>();
        for(int i = 0; i < data.length; i++){
            freqCount.put(data[i], freq[i]);
        }
        // for(char x: s.toCharArray()){
        //     freqCount.put(x, freqCount.getOrDefault(x, 0)+1);
        // }
        
        System.out.println(freqCount);

        PriorityQueue<HuffManNode>pq = new PriorityQueue<>();
        for(HashMap.Entry<Character, Integer>keys: freqCount.entrySet()){
            pq.add(new HuffManNode(keys.getKey(), keys.getValue()));
        }

        // while(!pq.isEmpty()){
        //     System.out.println(pq.peek().data + " -- " + pq.poll().frequency);
        // }

        while(pq.size() > 1){
            HuffManNode left = pq.poll();
            HuffManNode right = pq.poll();
            HuffManNode combined = new HuffManNode('\0', left.frequency + right.frequency);
            combined.left = left;
            combined.right = right;
            pq.add(combined);
        }

        HuffManNode root = pq.poll();
        HashMap<Character, String>table = new HashMap<>();
        buildCodes(root, "", table);

        return table;
    }

    static void buildCodes(HuffManNode root, String code, HashMap<Character, String>table){
        if(root == null)return ;
        if(root.left == null && root.right == null){
            table.put(root.data, code);
        }

        buildCodes(root.left, code + '0', table);
        buildCodes(root.right, code + '1', table);
    }

    public static void main(String[] args) {
        // String X = "this is a string";
        char data[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        int freq[] = new int[]{5, 9, 12, 13, 16, 45};
        HashMap<Character,String>ans = buildHuffmanCodes(data, freq);
        System.out.println(ans);
        
    }
}
