package Commonss; 



class BTree{
    int val;
    BTree left;
    BTree right;
    BTree(int x) { val = x; }
}

class Pair<U, V> {
    public U first;
    public V second;
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}



public class template {

    public int modAdd(int a, int b, int mod) { return (int)(((long)a + b) % mod); }
    
    public int modMul(int a, int b, int mod) { return (int)(((long)a * b) % mod); } 
    
    public long modPow(long base, long exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }


    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    private int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }

    private int factorial(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }
        return dp[n];
    }
    

    private int[] getCharFreq(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        return freq;
    }
    
}
