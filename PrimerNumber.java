import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimerNumber {
    public static int number;
    
    static ArrayList<Integer>  composit = new ArrayList<Integer>();

    public static void main(String[] args) {
        ArrayList <Integer> factors = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.print("Please give a number->");
        number = scan.nextInt();
        
        //number of interation;
        int nmbrInt = 0;

        for(int i=2; i<number; i++){
           if((number % i == 0) && !composit.contains(i)){
               composit.add(i); 
            }
            nmbrInt = nmbrInt +1;
        }
        
        for(int z=0; z < composit.size(); z++){
            if(composit.get(z)%2 == 0 &&!factors.contains(2)){
                factors.add(2);
            }
            if(composit.get(z)%3 == 0 &&!factors.contains(3)){
                factors.add(3);
            }
            if(composit.get(z)%5 == 0 &&!factors.contains(5)){
                factors.add(5);
            }
            if(composit.get(z)%7 == 0 &&!factors.contains(7)){
                factors.add(7);
            }
            
            if(composit.get(z)%11 == 0 &&!factors.contains(11)){
                factors.add(11);
            }
            if(composit.get(z)%13 == 0 &&!factors.contains(13)){
                factors.add(13);
            }
            if(composit.get(z)%17 == 0 &&!factors.contains(17)){
                factors.add(17);
            }
            if(composit.get(z)%19 == 0 &&!factors.contains(19)){
                factors.add(19);
            }
        }
        if(!composit.isEmpty()){
            System.out.print(number+" is composite number and factors are ->");
            System.out.println(factors);
        }
        if(composit.isEmpty()){
            System.out.print(number+" is primer number and factors are -> "+"\n");
        }
        System.out.println("With 1st method number of iteration  is: "+nmbrInt);
        //System.out.println("factor"+factors);
        seconMethod( nmbrInt);
    }
    public static void seconMethod(int nuber){ 
        int n = number;
        int x = n;
        
        int sqrtOfB =(int)sqrt(n);
        int i = 2;
        int inte =0;
        
        while(x > 1 && i <= sqrtOfB){
            inte =inte+1;
            while(x%i == 0){
                x = x/i;
               inte = i;
            }
            i=i+1; 
        }
        System.out.println("With 2nd method number of iteration  is: "+inte);   
    }
}