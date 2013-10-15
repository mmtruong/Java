import java.lang.Math.*;

  /**
   * Vector class computes common calculations with vectors
   *
   * @author Mike Truong
   * @version 2010 CSC142 
   */
  ////////////////////
  ////Vector Class////
  ///////////////////
  public class Vector {
  private double i, j, k;  // i,j,k are instance variables

  //// Two Constructors for the Vector Class////
  /////////////////////////////////////////////
 /**
  * Constructor for objects of class Vector for a vector at default point (0, 0, 0)
  */
  public Vector() {
    i = 0;
    j = 0;
    k = 0;
   }
  
  /**
   * Constructor for objects of class Vector for a vector at any given inital point
   * @param initialX is the initial value of the x-scalar component
   * @param initialY is the initial value of the y-scalar component
   * @param initialZ is the initial value of the z-scalar component
   */
  public Vector (double initialX, double initialY, double initialZ) {
    i = initialX; //Input any given points for x, y, z components.
    j = initialY;
    k = initialZ;
   }

   ////Update Methods//// Changes the state of the object.
   /////////////////////
  /**
   * Sets a new value for the x-component of the vector
   * @param updateX is the new updated value for x-scalar component
   */
  public void setXComp(double updateX) {
    i = updateX;
   }

  /**
   * Sets a new value for the y-component of the vector
   * @param updateY is the new updated value for y-scalar component
   */
  public void setYComp(double updateY) {
    j = updateY;
   }

  /**
   * Sets a new value for the z-component of the vector
   * @param updateZ is the new updated value for z-scalar component
   */
  public void setZComp(double updateZ) {
    k = updateZ;
   }
  
   ////Vector Calculations//// 
   //////////////////////////
  /** 
   * Calculates the unit vector
   * @return a new Vector with its unit vector components. To test, the magnitude of this new vector = 1
   */
  public Vector getUnitVector(){
      double iunit = i/getMagnitude(); //Method calls getMagnitude method.
      double junit = j/getMagnitude();//Calculate each component separately
      double kunit = k/getMagnitude();
    return new Vector( iunit, junit, kunit);
  }  

  /** 
   * Calculates the addition of two vectors
   * @param addVector is the other vector used as an argument
   * @return a new vector as a result of sumation with two vectors
   */
  public Vector add(Vector addVector) {
       double iadd = i + addVector.i; //Adding every component separately
       double jadd = j + addVector.j;
       double kadd = k + addVector.k;
    return new Vector (iadd, jadd, kadd);
  }

  /** 
   * Calculates a vector when multiplied by a constant
   * @param constant is the value that is multiplied to the vector
   * @return a new vector as a result of multiplying the constant to the vector
   */  
  public Vector scalar(double constant) {
       double itimes = constant*i; //Multiplying the constant to each component
       double jtimes = constant*j; 
       double ktimes = constant*k;
    return new Vector (itimes, jtimes, ktimes);
  }
  
  /** 
   * Calculates the magnitude of the vector
   * @return the magnitude of the vector
   */
  public double getMagnitude() {
    return Math.sqrt(i * i + j * j + k * k); //The magnitude is a scalar result
  }
 
  /** 
   * Calculates the dot product between two vectors
   * @param dotVector is the other vector used as an argument
   * @return a scalar value as a result of the dot product
   */  
  public double dot(Vector dotVector){
    return i*dotVector.i + j*dotVector.j + k*dotVector.k;
  }
   
  /** 
   * Calculates the cross product between two vectors
   * @param crossVector is the other vector used as an argument
   * @return a new vector as a result of the cross product
   */  
  public Vector cross(Vector crossVector) {
       double icross = ((this.j* crossVector.k) - (this.k * crossVector.j)); //"this" refers to this instance
       double jcross = ((this.k* crossVector.i) - (this.i * crossVector.k)); //calculate all components separately
       double kcross = ((this.i* crossVector.j) - (this.j * crossVector.i)); 
    return new Vector (icross, jcross, kcross);
  }
  
   //// Query Methods//// Does not change the state of the object.
   /////////////////////
  /** 
   * Gets the x-scalar component of this Vector
   * @return the x-scalar component
   */
  public double getXComp() {
    return i;
  }
  
  /** 
   * Gets the y-scalar component of this Vector
   * @return the y-scalar component
   */
  public double getYComp() {
    return j;
  }

  /** 
   * Gets the z-scalar component of this Vector
   * @return the z-scalar component
   */
  public double getZComp() {
    return k;
  }
  
  /**
   * The String version of the vector
   * @return the String representation
   */
  public String toString() {
    return "(" + i + ", " + j + ", " + k + ")";
  }
 }
  
  
 