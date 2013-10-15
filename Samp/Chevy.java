public class Chevy

{

private Ford ford;

private int r = 3;

public Chevy( Ford f)

{

ford = f;

}

public int getAValue(){

ford.show();

return r + 1;

}

}