class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)->y[0]-x[0]);
        if(a>0) maxHeap.add(new int[]{a,'a'});
        if(b>0) maxHeap.add(new int[]{b,'b'});
        if(c>0) maxHeap.add(new int[]{c,'c'});
        
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            int[] first = maxHeap.poll();
            int len = sb.length();
            if(len>=2 && sb.charAt(len-1)==first[1] && sb.charAt(len-2)==first[1]){
                if(maxHeap.isEmpty()){
                    break;
                }
                int[] second = maxHeap.poll();
                sb.append((char) second[1]);
                second[0]--;
                if(second[0]>0){
                    maxHeap.add(second);
                }
                maxHeap.add(first);
            } else{
                sb.append((char) first[1]);
                first[0]--;
                if(first[0]>0){
                    maxHeap.add(first);
                }
            }
        }
        return sb.toString();
    }
}