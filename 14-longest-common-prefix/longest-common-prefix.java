class Solution {
    public String longestCommonPrefix(String[] strs) {
//          This is a standard and efficient solution to the Longest Common Prefix problem (LeetCode 14). It uses a technique called Horizontal Scanning.

// Here is a breakdown of how this code works, a step-by-step dry run, and an analysis of its performance.

// 1. How the Logic Works
// The philosophy of this solution is: "Assume the first string is the answer, then chip away at it until it matches everyone else."

// Base Case: It grabs the first string (strs[0]) and calls it the prefix.

// Iteration: It loops through every other string in the array one by one.

// Comparison (while loop): It checks if the current string starts with the prefix.

// It uses indexOf. If strs[i].indexOf(prefix) returns 0, it means the string starts with the prefix.

// If it returns anything else (-1 or >0), the prefix is too long or not a match.

// Reduction: Inside the while loop, if there is no match, it shortens the prefix by one character from the end (substring) and tries again.

// Result: If the prefix becomes empty, it returns "". Otherwise, after checking all strings, the remaining prefix is the answer.
        if(strs==null || strs.length==0) return "";
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}