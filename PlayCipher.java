import java.util.Scanner;
public class PlayCipher{
    //public String  = "By JOACHIM";
    public String plainText;
    public static void main(String[] args){
        char matrix[][] = new char[5][5];
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        Scanner  scan = new Scanner(System.in);
        PlayCipher pc = new PlayCipher();
    
        System.out.print("\nPlease enter your key >: ");
        String key = scan.nextLine();

        System.out.print("\nEnter input > : ");
        String input = scan.nextLine(); 

        String uperKey = key.toUpperCase().replaceAll(" ", "");
        String inwj =uperKey.replace("J","I");
        String inPut = input.toUpperCase().replaceAll(" ", "");
       

        String letter = inwj + alphabet;

        String norep="";
        //replace j with i
        for(int i = 0; i < letter.length(); i++){
            String current = Character.toString(letter.charAt(i));
            if(!norep.contains(current)){
                norep += current;
            }
        }
        char[] caraters = norep.toCharArray();
        System.out.println("\nPlayfair application will use following key matrix >: \n");
        int z = 0;
       for(int i =0; i < 5; i++){
          
            for(int j=0; j<5;j++){

                    matrix[i][j] = caraters[z];
                    z +=1;
            }
        }
       for(int i =0; i<5; i++){
        for(int j=0; j<5;j++){
                System.out.print(matrix[i][j]+" "); 
            }
            System.out.println("\n");
        }
        
        String formateInput="";
        //elimenate  j in plain text
        if(inPut.contains("J")){
            inPut =inPut.replace("J", "I");
        }
       // System.out.println(inPut);
        for(int i = 0; i<inPut.length()-1; i=i+2){

           //System.out.println(Character.toString(inPut.charAt(i)));
            if(inPut.charAt(i) != inPut.charAt(i+1)){
                formateInput += inPut.charAt(i);
                formateInput += inPut.charAt(i+1);
            }
            else{
                //push lef and write X
                formateInput += inPut.charAt(i);
                formateInput +="X";
                i=i-1;
            }
        }
        //deal with the length of for mated text
        if(formateInput.length()%2!=0){
            formateInput +="X";
        }

        System.out.println("Chose operation: \n");
        System.out.println("+====================================+");
        System.out.println("|   (1). For encryption Enter 1      |");
        System.out.println("|   (2). For decryption Enter 2      |");
        System.out.println("+====================================+\n");
        
        int operation = scan.nextInt();
        scan.close();
        switch(operation){
            case 1:
            pc.position(matrix,'T');
                pc.encrypt(matrix, formateInput);
            break;

            case 2:
                pc.decrypt(matrix, formateInput);
            break;
        }  
    }
    //get position of each lleter matrix
    public int[] position (char[][] twoDimensionTable, char letter){
        int position[] = new int[2];
        
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(letter == twoDimensionTable[i][j]){
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        } 
        return position;
    }

    public void encrypt(char[][] twoDimensionTable, String  formateInput){
        //System.out.println("Cipher cipher: "+encryptedText);
        String encryptedText= "";
        
        int row1, col1, row2, col2;
        //to char the lenth of the text
        char[] format = formateInput.toCharArray();
       // System.out.println("fomat length: "+format.length);

        for(int i = 0; i < format.length; i= i+2){
           int[]rowcol = position(twoDimensionTable,  format[i]);
           row1 = rowcol[0];
           col1 = rowcol[1];
           int[]rowcol2 = position(twoDimensionTable,  format[i+1]);
           row2 =rowcol2[0];
           col2 =rowcol2[1];

            //same row
           if(row1 == row2){
                encryptedText += twoDimensionTable[row1][(col1+1)%5];
                encryptedText += twoDimensionTable[row2][(col2+1)%5];
           }//same col
           else if(col1 == col2){
                encryptedText += twoDimensionTable[(row1+1)%5][col1];
                encryptedText += twoDimensionTable[(row2+1)%5][col2];
           }
           else{
                encryptedText +=twoDimensionTable[row1][col2];
                encryptedText +=twoDimensionTable[row2][col1];
           }
          
        }
        System.out.println("Cipher output : "+encryptedText);
    }
    public void decrypt(char[][] twoDimensionTable, String  formateInput){
        String encryptedText= "";
        String decryptedText= "";
        int row1, col1, row2, col2;
        //int lengthText = formateInput.length;
        char[] format = formateInput.toCharArray();
        //System.out.println("fomat length: "+format.length);
        for(int i = 0; i < format.length; i= i+2){
           int[]rowcol = position(twoDimensionTable,  format[i]);
           row1 = rowcol[0];
           col1 = rowcol[1];
           int[]rowcol2 = position(twoDimensionTable,  format[i+1]);
           row2 =rowcol2[0];
           col2 =rowcol2[1];

            //same row
           if(row1 == row2){
                encryptedText += twoDimensionTable[row1][((col1-1)%5>=0)?((col1-1)%5):((col1-1)%5)*(-1)];
                encryptedText += twoDimensionTable[row2][((col2-1)%5>=0)?((col2-1)%5):((col2-1)%5)*(-1)];
           }//same col
           else if(col1 == col2){
                encryptedText += twoDimensionTable[((row1-1)%5>=0)?((row1-1)%5):((row1-1)%5)*(-1)][col1];
                encryptedText += twoDimensionTable[((row2-1)%5>=0)?((row2-1)%5):((row2-1)%5)*(-1)][col2];
           }
           else{
                encryptedText +=twoDimensionTable[row1][col2];
                encryptedText +=twoDimensionTable[row2][col1];
           }
           
        }
        System.out.println("\n\nPlaintext output: "+encryptedText);    
    }
}
