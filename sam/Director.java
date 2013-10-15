public class Director

{

private Ford ford;

private int x = 4;

public Director()

{

ford = new Ford( this );

x -= ford.getNumber();

display();

}

public void display()

{

System.out.println( x );

}

}