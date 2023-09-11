//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends




class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
    //  ArrayList<Integer> lst = new ArrayList<>();

    //  int i=0;
    //  int j=1;
    //  int sum=arr[0];
    //  boolean flag=false;
    //  while(i<n && j<n){
    //      sum+=arr[j];
    //      if(sum==s){
    //          lst.add(i+1);
    //          lst.add(j+1);
    //          flag=true;
    //          break;
    //      }
    //      else if(sum<s){
    //          j++;
    //      }
    //      else if(sum>s){
    //          i++;
    //          sum=arr[i];
    //          j=i+1;
    //      }
    //  }
    //  if(flag){
    //      return lst;
         
    //  }
    //  else{
    //      lst.add(-1);
    //      return lst;
    //  }
     
    // }
    
ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(-1);
        
        if(s == 0){
            int su = 0;
            for(int it : arr){
                su += it;
                if(su > s)return indexes;
            }
        }
        
        int left = 0, right = 0;
        int sum = 0;
        while(right < n){
            sum += arr[right];
            while(left <= right && sum > s){
                sum -= arr[left++];
            }
            
            if(sum == s){
                indexes.set(0, left+1);
                indexes.add(right+1);
                break;
            }
            right++;
        }
        
        return indexes;
    }
}