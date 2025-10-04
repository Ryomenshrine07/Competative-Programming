package Leetcode;

import java.util.Scanner;




class Leet11{
    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int area = Math.min(height[left],height[right]) * (right-left);
            maxArea = Math.max(maxArea,area);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i=0;i<n;i++){
            height[i] = sc.nextInt();
        }
        int ans = maxArea(height);
        System.out.println("Ans :"+ans);
        sc.close();
    }
}
