import java.io.*;
import java.util.*;

class Solution {
    int[] network;
    
    public int solution(int n, int[][] computers) {
        network = new int[n];
        for(int i=0;i<n;i++)
            network[i] = i;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(computers[i][j] == 1){
                    combine(i, j);
                }
            }
        }
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<n;i++)
            set.add(find(i));
        return set.size();
    }
    
    int find(int a){
        if(network[a] == a) return a;
        return network[a] = find(network[a]);
    }
    
    void combine(int a, int b){
        if(find(a) == find(b)) return;
        network[find(b)] = find(network[find(a)]);
    }
    
    
}