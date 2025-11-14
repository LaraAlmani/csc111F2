/*

Names :

lara majed almani
 
nourah abdulmajeed aljeraisy

ID'S :

446202834

446202896

Section number :

78688

Lab instructor's name :

abeer ibrahim aldrees
 
*/



class Key       //Key class
{
public static int numKeys = 0;   // Attributes for Key class 
private int ID;
private String original;
private String code;
private boolean isSet;         

public Key() // default constructor
{
numKeys++;
ID = numKeys;
original = "";
code = "";
isSet = false;
}

public boolean setKey (String o , String c) //setKey method that check if the key is valid or not
{
if ( validKey(o, c)  )
{
original = o;
code = c;
isSet = true;
return true;
}
else 
{
original = "";
code = "";
isSet = false;
return false;
}
}

private boolean validKey (String o , String c){ // validKey method return true if the len of ori and code are the same and the ori len is not 0  

return o.length() == c.length() && o.length() > 0;

}

public void displayMe() // displayMe method is for display the ori and code characters and show if there is a key set or not 
{
System.out.println ("\n +-------------------+");
System.out.println("| Key#" + ID);

if (isSet)
{
System.out.println("|set    |");
System.out.println("|---+---|");
System.out.println("| o | c |");
System.out.println("|---+---|");
for (int i = 0 ; i < original.length(); i++ )
System.out.println("| " + original.charAt(i) + " | " + code.charAt(i) + " |" );
}
else 
{
System.out.println ("|not set|");
}
System.out.println ("\n +-------------------+");
}


public boolean getisSet (){ // getisSet method is to check is it set or not 

return isSet ;
}

public int getID(){ // getID method return the ID

return ID;
}

public String getoriginal (){ // getoriginal method return the ori 

return original;
}

public String getcode (){ // getcode method return the code 

return code;
}
} //end class Key 
