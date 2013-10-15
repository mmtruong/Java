public class Ford

{

private Chevy chevy;

private int z = 3;

private Director director;

public Ford( Director d)

{

director = d;

z--;

chevy = new Chevy( this );

director.display();

}

public int getNumber() {

return z + chevy.getAValue();

}

public void show(){

director.display();

}

}