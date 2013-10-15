
  /**
   * This class uses a do while loop to convert base 10 intgers to base 2, 8, or 16.
   * 
   * @author Mike Truong
   * @version 5.0    5/15/10
   */
 public class Converter{
   private static String rA="A", rB="B", rC="C", rD="D", rE="E", rF="F";//base 16 remainders

  /**
   * Converts bases by recursivity
   * @param baseNumber the base 10 inputted number from the scanner
   * @param base the new base that baseNumber will be converted to
   */
 public static String convert(int baseNumber, int base){//method that converts bases. baseNumber is inputted base 10 and base is inputted base to convert to)
   int divide; 
   int modRemainder; 

   divide = (baseNumber / base); //division
   modRemainder = (baseNumber % base);//mod division

 do{ //do while loop is used to convert
   if (modRemainder==10) {return ("" + (convert(baseNumber/base, base) + rA));} //recursive technique
   else if (modRemainder==11) { return ("" + (convert(baseNumber/base, base) + rB));}
   else if (modRemainder==12) { return ("" + (convert(baseNumber/base, base) + rC));}
   else if (modRemainder==13) { return ("" + (convert(baseNumber/base, base) + rD));}
   else if (modRemainder==14) { return ("" + (convert(baseNumber/base, base) + rE));}
   else if (modRemainder==15) { return ("" + (convert(baseNumber/base, base) + rF));}
   else if (divide > 0) {return ("" + (convert(baseNumber/base, base) + modRemainder ));}
   else {return ("" + modRemainder );}
 }
 while(divide>0);
  }

}