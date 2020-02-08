import java.util.*;
import java.io.*;
import java.lang.StringBuffer;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int sum = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int j = 0;
            sum = a;
            while(j < n) {
                sum += (Math.pow(2, j) * b);
                sb.insert(sb.length(), sum + " ");
                j++;
            }
        System.out.println(sb);
        sb.delete(0, sb.length());
        }
        in.close();
    }
}

