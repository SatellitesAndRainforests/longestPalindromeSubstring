import java.util.List;
import java.util.ArrayList;

// this approach works but there are faster implementations on leet code
// can test strings for palindromes in the main method, output to the terminal

class Solution {
    

    public static void main (String [] args ) {
     
        Solution test = new Solution();
        
	// can test strings for palindromes here
        System.out.println(     test.longestPalindrome( "abcdracecarabcd"   ));
        System.out.println(     test.longestPalindrome( "ottoracecar"   )); 
        System.out.println(     test.longestPalindrome( "a"   ));
        System.out.println(     test.longestPalindrome( "123otto123"   ));
        System.out.println(     test.longestPalindrome( "" ));
        System.out.println(     test.longestPalindrome( "" ));
        
    }
    
    
    public String longestPalindrome(String s) {
      
        List<Pair> pairs =  new ArrayList<Pair>();
        String currentHighest = "";
        
        
        // generate List of all possible subStrings (start character, and end character); there are n(n-1)/2 pair combinations.
        for (int i=0;i<=s.length();i++){
            int l = i;
            for (int j=i+1; j <= s.length(); j++) {
                int r = j;
                pairs.add(new Pair(l,r));
            }
        }
        
        
        // check if each possible substring is a palindrom and update the currentHighest found  
        for(Pair p: pairs) {
         //   System.out.println("start: " + p.L + " end: " + p.R);
            if (s.substring(p.L, p.R).equals( new StringBuffer(s.substring(p.L, p.R)).reverse().toString())) {
                if (s.substring(p.L, p.R).length() > currentHighest.length())  currentHighest = s.substring(p.L, p.R);
            }
        }
        
        return currentHighest;
    
    }
    
    // inner class to define a Pair
        class Pair {
            int L;
            int R;
            Pair (int l, int r){
                 this.L = l;
                 this.R = r;
              }
         }
    
}
