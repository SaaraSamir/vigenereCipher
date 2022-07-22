
package vigenerecipher;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class VigenereCipher {

   
    public static void main(String[] args) throws IOException {
           File encryptedfile = new File("Encrypt.txt");      
            encryptionfile(encryptedfile, "deceptive");
        File decryptedfile = new File("Decrypt.txt");
        
            decryptionfile(decryptedfile, "deceptive");

    }
 
     static String encryption(String plain ,String key) {
        String C = "";
        int stop = 0;
        for (int i = 0; i < plain.length(); i++) {
            if (plain.charAt(i) == ' ') {
                C += ' ';
            } else {
                int value =(plain.charAt(i) - 97);
                int k= (key.charAt(stop %key.length())-97);
                
                stop++;
                C += (char) ((( value + k) % 26) + 97);
            }
            }
        return C;
    
    }
     static String decryption(String cipher ,String key ) {
        String P = "";
         int stop = 0;
        for (int i = 0; i < cipher.length(); i++) {
            if (cipher.charAt(i) == ' ') {
                P += ' ';
            } else {
                int value =  (cipher.charAt(i) - 97);
                int k=  (key.charAt(stop %key.length())-97);
                int flag =  (( value - k) % 26) ;
                 stop++ ;
                  

                if (flag < 0) {
                    flag += 26;
                }
                P += (char) (flag + 97);
            }
        }
        return P;
    }
     static void encryptionfile(File plainTextFile, String key) throws IOException {

        Scanner scanner = new Scanner(plainTextFile);

        File output = new File("encryption.txt");
        PrintWriter pw = new PrintWriter(output);

        while (scanner.hasNext()) {
            pw.println(encryption(scanner.nextLine(), key));
        }

        pw.flush();
        pw.close();
    }

    static void decryptionfile(File cipherTextFile, String key) throws IOException {
        Scanner input = new Scanner(cipherTextFile);
        File output = new File("decryption.txt");
        PrintWriter pw = new PrintWriter(output);
        
        while (input.hasNext()) {
            pw.println(decryption(input.nextLine(), key));
        }

        pw.flush();
        pw.close();
    }
}
