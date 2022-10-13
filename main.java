import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class main{
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]) throws IOException{
        while(true){
        System.out.println("Which operation do you want to perform 1. Compression 2. Decompression ");
        int choice=sc.nextInt();
        switch(choice){
            case 1: try 
           { 
            LZWCompression lzw = new LZWCompression();

            Scanner input = new Scanner(System.in);
               
            System.out.println("Enter the name of your (input.txt) file.");
            String str = input.nextLine();

            File file = new File(str);

            Scanner fileScanner = new Scanner(file);

            String line = "";
long originalfileSize = file.length();       
        System.out.format("The size of the original file: %d bytes", originalfileSize);
 System.out.println();
 int count=0;
 while(fileScanner.hasNext()){
     fileScanner.next();
     count++;
 }
 System.out.println("Number of words in the original file:"+count);
            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                }
            long starttime=System.nanoTime();
            lzw.compress(str);
            long stoptime=System.nanoTime();
            long totaltime=(stoptime-starttime);
            System.out.println("\nCompression of your file is complete!");
            System.out.println("Total time taken : "+totaltime/1000000000 + " seconds");
            System.out.println("Your new file is named: " + str.concat(".lzw"));
            System.out.println();
       break;
        
      
   
        
        } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
           
            case 2:        try {
            LZWDecompression lzw = new LZWDecompression();

            Scanner input = new Scanner(System.in);

            System.out.println("Enter the name of your (input.txt.lzw) file.");
            
            String str = input.nextLine();

            File file = new File(str);
              
            Scanner fileScanner = new Scanner(file);

            String line = "";
              long compressedfileSize = file.length();       
        System.out.format("The size of the compressed file: %d bytes", compressedfileSize);
 System.out.println();
 
            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                System.out.println("Contents of your file being decompressed:\n"+ line);
            }
             long originalfilesize = file.length();     
         FileInputStream fis = new FileInputStream(file);
      byte[] byteArray = new byte[(int)file.length()];
      fis.read(byteArray);
      String data = new String(byteArray);
      String[] stringArray = data.split("\r\n");
      long stime=System.nanoTime();
            lzw.LZW_Decompress(str);
             long sttime=System.nanoTime();
            long tttime=(sttime-stime);
            System.out.println("Decompression of your file is complete!");
            System.out.println("Total time take to Decompress : "+tttime/1000000000 +" seconds");
            System.out.println("Your new file is named: "+ str.replace(".lzw", ""));
            
            System.out.println();
            break;
                    } catch (FileNotFoundException e) {
            System.out.println("File was not found!");
        }
    }
}
    }
}
