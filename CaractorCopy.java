import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CaractorCopy{
    //String utf8String = new String(bytes, StandardCharsets.UTF_8);
    private static final String UNICODE_FORMAT="UTF-8";
//FSRNSYV
    char commandLineValue;
    int key;
    char[] plain_text;
    char[] cipher_text;

    String uSpanish = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    String spanish = "abcdefghijklmnñopqrstuvwxyz";

    String turkish="abcçdefgğhıijklmnoöprsştuüvyz";
    String uTurkish="ABCÇDEFGĞHIIJKLMNOÖPRSŞTUÜVYZ";

    String uenglish ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String english ="abcdefghijklmnopqrstuvwxyz";

    char english_aplabet[] = english.toCharArray();
    char english_aplabet_upper[] = uenglish.toCharArray(); 
    
    char spanish_aplabet[] = spanish.toCharArray();
    char spanish_aplabet_upper[] = uSpanish.toCharArray();
    
    char turkish_aplabet[] = turkish.toCharArray();
    char turkish_aplabet_upper[] = uTurkish.toCharArray();
    
    public static void main(String[] args){
        System.out.println(-5%2);
        
        //check the correctness of the argument command
        if(args.length != 1){
            System.out.println("\n Usage: java Caractor.java Key");
            System.out.println("Example: java Caractor.java 4");
        }
        CaractorCopy car = new CaractorCopy();
        //convect at caracter string into a char
        car.commandLineValue = args[0].charAt(0);
        //,, 1 for French, , 3 for Turkish 
        //menu cript crypt
        System.out.println("------------------------------------------------");
        System.out.println("!         Choose Encrypt Or Decrypt             !");
        System.out.println("!-----------------------------------------------!");
        System.out.println("!              0. Encrypt                       !");
        System.out.println("!              1. De-crypt                      !");
        System.out.println("!-----------------------------------------------!");
        System.out.print("!Enter your choise please: ");
        
        Scanner scan = new Scanner(System.in);
        int choiceed = scan.nextInt();
        if(choiceed == 0){
            //menu language
            System.out.println("------------------------------------------------");
            System.out.println("!         choose Language for Crypting             !");
            System.out.println("!-----------------------------------------------!");
            System.out.println("!          0. For English                       !");
            System.out.println("!          1. For French                        !");
            System.out.println("!          2. For Spanish                       !");
            System.out.println("!          3  For Turkish                       !");
            System.out.println("!-----------------------------------------------!");
            System.out.print("!Enter your choise please: ");
            Scanner scan2 = new Scanner(System.in);
            int choice = scan2.nextInt();
            
            switch(choice){
                case 0:
                    car.encrypt(car.english_aplabet_upper, car.english_aplabet); 
                break;
                case 1:
                    car.encrypt(car.english_aplabet_upper, car.english_aplabet); 
                break;
                case 2:
                    car.encrypt(car.spanish_aplabet_upper, car.spanish_aplabet); 
                break;
                case 3:
                    car.encrypt(car.turkish_aplabet_upper, car.turkish_aplabet); 
                break;
                
                default:
                System.out.print("You need make a choice between 0 to 3");
                break;
            }   
        }
        else if(choiceed == 1){
            //menu language
            System.out.println("------------------------------------------------");
            System.out.println("!     choose Language For Decrypting            !");
            System.out.println("!-----------------------------------------------!");
            System.out.println("!          0. For English                       !");
            System.out.println("!          1. For French                        !");
            System.out.println("!          2. For Spanish                       !");
            System.out.println("!          3  For Turkish                       !");
            System.out.println("!-----------------------------------------------!");
            System.out.print("!Enter your choise please: ");
            
            Scanner scan3 = new Scanner(System.in);
            int choice = scan3.nextInt();
            
            switch(choice){
                case 0:
                    car.decrypt(car.english_aplabet_upper, car.english_aplabet); 
                break;
                case 1:
                    car.decrypt(car.english_aplabet_upper, car.english_aplabet); 
                break;
                case 2:
                    car.decrypt(car.spanish_aplabet_upper, car.spanish_aplabet); 
                break;
                case 3:
                    car.decrypt(car.turkish_aplabet_upper, car.turkish_aplabet); 
                break;
                
                default:
                System.out.print("You need make a choice between 0 to 3");
                break;
            }
        }
        else{
            System.out.println("!Enter The right Choice between 0 Or 1");
        }
        

          
    }
    
    public void encrypt(char[] dictionnaryUpper, char[] dictionnaryLower){
        int nbr = dictionnaryLower.length;
        
        //key = Integer.parseInt(commandLineValue);
        key = Character.getNumericValue(commandLineValue);
        System.out.println(key);
        

        //get plain text from the keyboard
        System.out.printf("Enter Plain text: ");
        Scanner getFromKeyboard = new Scanner(System.in); 
        String pt = getFromKeyboard.nextLine();

        //convert sitring into array of caracter
        plain_text = pt.toCharArray();
        cipher_text = new char[plain_text.length];

        //cipher
        for(int i = 0; i < plain_text.length; i++){
            //compy no aphabet caractor as plain text into thr cipher array
            if(!(Character.isAlphabetic(plain_text[i]))){
                
                cipher_text[i] = plain_text[i];
                //System.out.print(cipher_text[i]);
            }
            //cipher upper caractor and put it into the cipher_text array
            if(Character.isUpperCase(plain_text[i])){
                for(int j = 0; j < nbr; j++){
                    if(plain_text[i] == dictionnaryUpper[j]){
                        cipher_text[i] = dictionnaryUpper[(j+key )% nbr];
                        //System.out.print(cipher_text[i]);
                    }   
                } 
            }
            //copy the ciphered text into the into thecipher text array
            for(int j = 0; j < nbr; j++){
                if(plain_text[i] == dictionnaryLower[j]){
                    cipher_text[i] = dictionnaryLower[(j+key) % nbr];
                    //System.out.print(cipher_text[i]);
                }   
            } 
        }

        //write in filletr
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("cypher.txt"));
            //uppercases every caracter in
            for (int i = 0; i < cipher_text.length; i++) {
                if(Character.isUpperCase(cipher_text[i]))
                {
                    writer.write(cipher_text[i]);
                    System.out.print(Character.toLowerCase(cipher_text[i]));
                }
                else{
                    writer.write(cipher_text[i]);
                    System.out.print(Character.toUpperCase(cipher_text[i]));

                }
                //System.out.print(cipher_text[i]);  
            }
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    } 
    //decript
    public void decrypt(char[] dictionnaryUpper, char[] dictionnaryLower){
        int nbr = dictionnaryLower.length;
        key = Character.getNumericValue(commandLineValue);
        System.out.println(key);
        
        //get plain text from the keyboard
        System.out.printf("Enter Cipher text: ");
        Scanner getFromKeyboard = new Scanner(System.in); 
        String pt = getFromKeyboard.nextLine();
        
        //convert sitring into array of caracter
        plain_text = pt.toCharArray();
        cipher_text = new char[plain_text.length];

        //cipher
        //int j = 0;

        for(int i = 0; i < plain_text.length; i++){
            //compy no aphabet caractor as plain text into thr cipher array
            if(!(Character.isAlphabetic(plain_text[i]))){
                cipher_text[i] = plain_text[i];
                System.out.print(cipher_text[i]);
            }
            //cipher upper caractor and put it into the cipher_text array
            if(Character.isUpperCase(plain_text[i]) ){//&& (i-key) % nbr >= 0
                for(int j = 0; j < nbr; j++){
                    if(plain_text[i] == dictionnaryUpper[j]){
                        cipher_text[i] = dictionnaryLower[(((j-key) % nbr)>=0)?((j-key) % nbr):nbr-(((j-key) % nbr)*(-1))];
                        
                    }   
                } 
            }
            //copy the ciphered text into the into thecipher text array
            if(Character.isLowerCase(plain_text[i]) ){//&& (i-key) % nbr >= 0

                for(int j = 0; j < nbr; j++){
                    if(plain_text[i] == dictionnaryLower[j]){
                        
                        cipher_text[i] = dictionnaryLower[(((j-key) % nbr)>=0)?((j-key) % nbr):nbr-(((j-key) % nbr)*(-1))];
                        //System.out.print(cipher_text[i]);
                    }   
                }
            } 
        }
        //DECRYPT FROM A FILE
        

        //uppercases every caracter in
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("uncipher.txt"));
            for (int i = 0; i < cipher_text.length; i++) {
                if(Character.isUpperCase(cipher_text[i]))
                {
                    writer.write(cipher_text[i]);
                    System.out.print(Character.toLowerCase(cipher_text[i]));
                }else if(Character.isLowerCase(cipher_text[i])){
                    System.out.print(Character.toUpperCase(cipher_text[i]));
                    writer.write(cipher_text[i]);
                }
                else{
                    writer.write(cipher_text[i]);
                    System.out.print(cipher_text[i]);
                }
                //System.out.print(cipher_text[i]); 
            }
            writer.close();

        }catch(IOException e){
            e.printStackTrace();
        }
        
    } 
}