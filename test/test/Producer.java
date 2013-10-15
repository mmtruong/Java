public class Producer{

 

  private int x;

  public static int c = 0;

 

  public Producer( int newX ){

    x = newX;

    c = c + 1;  }

 

  public int modify( int q ){

    int temp = x;

    x += q;

    return x;  }

 

  public void setX( int newX ){

    x = newX; }

 

  public int getX( ){

    return x;  }
    
     
  public int getC( ){

    return c;  }
    

}

