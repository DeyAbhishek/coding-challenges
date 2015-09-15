// Link To Compilable Code: http://goo.gl/2fBF7I

public class MINIMUMwithoutIfElse{

     public static void main(String []args){
        System.out.println(getMIN(222, 44));
     }
     
     private static int flip(int a){
         return 1 ^ a;
     }
     
     private static int getSign(int a){
         
         return (a >> 31) & 0x1;
     }
     
     private static int getMIN(int a, int b){
         int sign = getSign(a - b);
         int oppositeSign = flip(sign);
         return a * sign + b * oppositeSign;
         
     }
}
