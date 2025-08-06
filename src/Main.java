import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int k =sc.nextInt();
        int j =sc.nextInt();
        int m = sc.nextInt();
        int p =sc.nextInt();
        int res=0;
        if(k!=0||j!=0){
            int r =m/k;
            int y=p/j;
            res=r+y;
            System.out.println("No.of Monkey lefts on the tree: "+(n-res));
    }
        else{
            System.out.println("INVALID OUTPUT");
        }
} }