import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactorySpi;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Analysis{
    
    
    public static void main(String[] args){
        //String[] difrenquencys = {"th","he","in","er","an","re","nd","at","on","nt","nt","ha","es","st","en","ed","it","ou","ea","hi","is","or"};
        //char[] frenquencychar= frenquencys.toCharArray();
        //check the correctness of the argument command
        String uenglish ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String frenquencys ="etaoinsrhdlucmfywgpbvkxqjz";
        char[] uenglishalphabet = uenglish.toCharArray();
        
            if(args.length != 1){
                System.out.println("\nUsage: java Analysis.java file.txt");
                System.out.println("Example: java  Analysis.java cipher.txt");
            }
            System.out.println("Cipher Text:\n");
            String textLines="";
            try{
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                String line;
                while((line = reader.readLine()) != null){
                    textLines = textLines.concat(line);
                }
                reader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            //convect string to array of char 
            char textlines[] = textLines.toCharArray();
            char alphabet[] = uenglish.toCharArray();
            System.out.println("");
            
            System.out.println(textLines+ "\n");
           
        /////////////////////////////////////////////////////   
     
        //methode
        int nbr = 0;

        int[] key = new int [uenglishalphabet.length];
        char[] value = new char[uenglishalphabet.length];
        //popular array
        for(int i = 0; i < alphabet.length; i++){
            nbr = 0;
            for(int j = 0; j < textlines.length; j++)
            {
                if( alphabet[i] == textlines[j]){
                    nbr++;
                }
            }
            if(Character.isAlphabetic(alphabet[i])){
                key[i] = nbr;
                value[i] = alphabet[i]; 
            }
        }
        //sort data
        int temp;
        char tempc;
        int key_copy[] = new int[uenglish.length()];
        int value_copy[] = new int[uenglish.length()];
        for(int i = 0; i<key_copy.length; i++){
            for(int j = i; j< key_copy.length; j++){
                if(key[i] < key[j] || key[i] == key[j] && key[i]!= 0){
                    temp = key[i];
                    tempc = value[i];

                    key[i]=key[j];
                    value[i] = value[j];

                    key[j] = temp;
                    value[j]= tempc;
                }
            }
            temp = 0;  
        }
        System.out.println("Analysis: \n");
        for(int i = 0; i< key.length; i++){
            if(key[i] != 0|| value[i] != ' '){
                 System.out.print(value[i]+"->"+key[i]+" ");
            }
            //System.out.print();
         }
        
       
        Scanner sc = new Scanner(System.in);
       

        
       // System.out.print(dictionary);
        System.out.println("\n");
        
        
        //System.out.println(dictionary); 
        System.out.println();
        System.out.println("+---------------------------------+");
        System.out.println("|          Options:               |");
        System.out.println("+---------------------------------+");
        System.out.println("|       1) Take replace rule      |");
        System.out.println("|       2) Exit                   |");
        System.out.println("+---------------------------------+");
       
        System.out.print("Enter number Of option: ");
       
        int option = sc.nextInt();
        System.out.println("Plain text:\n");

        if(option == 1){
            for(int i = 0; i<key.length; i++){
                if(i == 0)
                    textLines = textLines.replace(value[i], 'e');
               if(i == 1)
                    textLines = textLines.replace(value[i], 't');
                if(i == 2)
                    textLines = textLines.replace(value[i], 'o'); 
                if(i == 3)
                    textLines = textLines.replace(value[i], 'n');
               if(i == 4)
                    textLines = textLines.replace(value[i], 'l');
                if(i == 5)
                    textLines = textLines.replace(value[i], 's');
                if(i == 6)
                    textLines = textLines.replace(value[i], 'a');
                if(i == 7)
                    textLines = textLines.replace(value[i], 'r');
                if(i == 12)
                    textLines = textLines.replace(value[i], 'm');
                if(i == 13)
                    textLines = textLines.replace(value[i], 'd'); 
                if(i == 14)
                    textLines = textLines.replace(value[i], 'g');
                if(i == 9)
                    textLines = textLines.replace(value[i], 'i');
                if(i == 10)
                    textLines = textLines.replace(value[i], 'c');
                  
                if(i == 11)
                    textLines = textLines.replace(value[i], 'f');
                 
                if(i == 22)
                    textLines = textLines.replace(value[i], 'k');
                if(i == 23)
                    textLines = textLines.replace(value[i], 'q');
                if(i == 16)
                    textLines = textLines.replace(value[i], 'u');
                if(i == 8)
                    textLines = textLines.replace(value[i], 'h');
                if(i == 15)
                    textLines = textLines.replace(value[i], 'w');
                if(i == 17)
                    textLines = textLines.replace(value[i], 'y');
                if(i == 18)
                    textLines = textLines.replace(value[i], 'p'); 
                if(i == 20)
                    textLines = textLines.replace(value[i], 'a');
            }
            System.out.print( textLines);
            //System.out.print( textLines);
       }else if(option == 2){
        System.out.println("Bye!");
        }
        else{
            System.out.println("Wrong Option!");
        } 
    }   
}
