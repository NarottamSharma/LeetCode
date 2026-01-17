class Solution {
    public int characterReplacement(String s, int k) {
        int counts[] = new int[26];// check freq
        int maxC =0;
        int max= 0;
        int i=0;
        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            counts[c-'A']++;
            maxC = Math.max(counts[c-'A'],maxC);
            if((j-i+1)-maxC >k){
                char left =s.charAt(i);
                counts[left-'A']--;
                i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}