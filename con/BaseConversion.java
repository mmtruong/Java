
import java.util.Scanner;


 /**
  * Takes input from the user
  * 
  * @author Mike Truong
  * @version 5.0    5/15/10
  */
 public class BaseConversion{
   private static Converter Yes;//supplier 
   private static String baser;// for text output
   private static boolean goodInput=true;//flag variable

 /**
  * Main method that displays user interface
  */
 public static void main (){
   int enterBase10;//base 10 integer input
   int convertBase;// base ninput to convert
   Scanner input = new Scanner(System.in);

   System.out.println ();
   System.out.println ("This program converts base 10 numbers to either base 2, base 8, or base 16. Enter 0 0 to quit. ");
   System.out.print ("Please input an integer of base10, followed by a space, then a base integer : ");
   enterBase10 = input.nextInt();
   convertBase = input.nextInt();


 if  (convertBase==0 && enterBase10==0){//Input validation. Exit program if input is 0 0
   System.out.println("Bye. Thanks for using my program");
   goodInput= false;
 }
 else if ((convertBase!=2 && convertBase!=8 && convertBase!=16)){//input validation if not 2, 8, or 16
   System.out.println("Try Again.");
   main();
 }
 else if (enterBase10<0){//input validation for base 10 numbers < 0
   System.out.println("Try Again.");
   main();
 }
     

 if (goodInput){  //if boolean true then proceed with method call
   if (convertBase==2){ baser="(base 2)";}//text output
   else if (convertBase==8){ baser="(base 8)";}
   else if (convertBase==16){ baser="(base 16)";}
   System.out.println(Yes.convert(enterBase10, convertBase) + baser );//call covert method from Converter class
   main();
   }


 
 }
}