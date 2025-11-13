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

import java.util.*;
class Key
{
public static int numKeys = 0;
private int ID;
private String original;
private String code;
private boolean isSet;

public Key()
{
numKeys++;
ID = numKeys;
original = "";
code = "";
isSet = false;
}

public boolean setKey (String o , String c)
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

private boolean validKey (String o , String c){

return o.length() == c.length() && o.length() > 0;

}

public void displayMe()
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


public boolean getisSet (){

return isSet ;
}

public int getID(){

return ID;
}

public String getoriginal (){

return original;
}

public String getcode (){

return code;
}
}



class SecureSentence{

private String sentence;
private Key keyUsed;
private boolean encrypted;

public SecureSentence(){
sentence ="";
keyUsed = null;
encrypted = false;
}


public void setSentence(String s){
sentence = s;
encrypted = false;
keyUsed = null;
}

public void setSentence(String s , Key key){

sentence = s;
encrypted = true;
keyUsed = key;
}

public void encrypt (Key key){

if (sentence.equals("") || !key.getisSet()){
System.out.println("Encryption failed : ( Key not set or sentence missing ).  ");
return;
}
if (encrypted) {
System.out.println("Encryption failed : Sentence already encrypted.  ");
return;
}

String result = "";
String o = key.getoriginal();
String c = key.getcode();
for (int i = 0; i < sentence.length(); i++ ){

char ch = sentence.charAt(i);
int pos = o.indexOf(ch);

if (pos !=-1){
result += c.charAt(pos);}
else{
result += ch;
}
}
sentence = result ;
encrypted = true;
keyUsed = key;
System.out.println("Sentence has encrypted successfully! ");
}

public void decrypt(){
if (!encrypted){
System.out.println("Decryption failed : ( not encrypted ).  ");
return;
}

String result = "";
String o = keyUsed.getoriginal();
String c = keyUsed.getcode();

for (int i = 0; i < sentence.length(); i++ ){

char ch = sentence.charAt(i);
int pos = c.indexOf(ch);

if (pos !=-1){

result += o.charAt(pos);}

else{
result += ch;
}
}
sentence = result ;
encrypted = false;
System.out.println("Sentence has decrypted successfully! ");

}


public void displayMe(){

System.out.println("--------------------------");
System.out.println("Sentence : " + sentence);
System.out.println("Encrypted : " + encrypted);
if (keyUsed != null){
System.out.println("Using Key ID : #" + keyUsed.getID());
}
else {
System.out.println(" No key used. ");}
System.out.println("--------------------------");
}

public boolean isEncrypted(){
return encrypted;
}
}

public class projectF2
{
static String systemPin = "";

static Scanner read = new Scanner (System.in);

public static void setPin (){

String pinstr;
boolean val;

do 
{
System.out.println("Enter a 4-digit PIN that does not start with zero : ");
pinstr = read.nextLine();
val = true ; 
if (pinstr.length() != 4 || pinstr.charAt(0) == '0'){
System.out.println("Invalid PIN (start with a '0' or not 4 digit). ");
val = false ; 
continue ; 
}
for (int i = 0 ; i < pinstr.length() ; i++ ){

if (pinstr.charAt(i) <'0' || pinstr.charAt(i) > '9'){
System.out.println("Invalid PIN (you entered a character). ");

val = false ; 
break ; 
}
}
}
while (val == false );
systemPin = pinstr;
System.out.println("PIN set successfully . ");
}

public static boolean pinMatches(String pin){

return pin.equals(systemPin);
}

public static int menu(){


System.out.println("\n --- Main Menu ---");       // The main menu .

         System.out.println("1. Set / Change a key "); 
         
         System.out.println("2. Display all keys ");
         
         System.out.println("3. Select a SecureSentence object ");
         
         System.out.println("4. Enter a sentence ");
         
          System.out.println("5. Display  sentence ");
          
         System.out.println("6. Encrypt  sentence ");
         
         System.out.println("7. Decrypt the sentence ");
         
          System.out.println("8. Display all SecureSentence objects ");
          
         System.out.println("9. Exit ");
         
         System.out.println("\n Enter choice : ");
         
         int input = read.nextInt();

         return input;
         }
       
      static Key key1 = new Key ();
      static Key key2 = new Key ();
      static Key key3 = new Key ();
      
      static SecureSentence s1 = new SecureSentence ();
      static SecureSentence s2 = new SecureSentence ();
      static SecureSentence currentSentence = null;


      public static void main (String [] args)
      {
            
      setPin();
      
      int choice;
       do
       {
       choice = menu();
       
       switch (choice)
       {
       case 1:
       setOrChangeKey();
       break;
       
       case 2:
       displayAllKeys();
       break;
       
       case 3:
       selectSecureSentence();
       break;
       
       case 4:
       enterSentence();
       break;
       
       case 5:
       displayCurrentSentence();
       break;
       
       case 6:
       encryptSentence();
       break;
       
       case 7:
       decryptSentence();
       break;
       
       case 8:
       displayAllSentences();
       break;
       
       case 9:
       System.out.println(" Goodbye :) ");
       break;
       
       default:
       System.out.println(" Invalid Choice, please enter a number 1-9 .");
    }
    }

     while (choice != 9);
    }
       
     public static void setOrChangeKey()
     {
    System.out.println(" Enter PIN : ");
    read.nextLine();
    String pInput = read.nextLine();
    if ( pinMatches(pInput) )
    {
    System.out.println("Choose key number (1-3) : ");
    int kNum = read.nextInt();
    
       while (kNum < 1 || kNum > 3) {
    System.out.println("Invalid key number.\n");
    System.out.println("Choose key number (1-3) : ");
    kNum = read.nextInt();
}

        
        System.out.println("Enter original key : ");
            read.nextLine();
    String o = read.nextLine();

    System.out.println("Enter code key : ");
    String c = read.next();
    
    boolean select = false;
    switch (kNum){
    case 1 :
    select = key1.setKey(o , c);
    break;
    
    case 2 :
    select = key2.setKey(o , c);
    break;
    
    case 3 :
    select = key3.setKey(o , c);
  break;
  
  default: System.out.println("Invalid choice you must choose from (1-3).  ");
}
    if (select)
    System.out.println("Key set successfully. ");
    else 
    System.out.println("Invalid key. ");
    }
    else
    {  
    System.out.println("Incorrect PIN. ");
    }
     
     } 
      
public static void displayAllKeys()
{
 System.out.println(" Enter PIN : ");
     read.nextLine();

 String pInput = read.nextLine();
 
 if (  pinMatches(pInput) )
 {
 key1.displayMe();
 key2.displayMe();
 key3.displayMe();
 }
else 
{
System.out.println("Incorrect PIN. ");
}
}
       
public static void selectSecureSentence()
{
System.out.print(" Select Secure Sentence (1 or 2) : ");
int s = read.nextInt();

if (s == 1){
currentSentence = s1;
System.out.println("SecureSentence1 selected . ");}
else 
  if (s == 2){
currentSentence = s2;
System.out.println("SecureSentence2 selected . ");}

else
System.out.println(" Invalid selection . ");
}      
      
public static void enterSentence()
{
if (currentSentence == null )   
{
System.out.println(" No Secure Sentence selected . ");
}//check
System.out.print(" Enter a Sentence : ");
    read.nextLine();

String s = read.nextLine();

System.out.print(" is the Sentence already encrypted? (Yes / No ) : ");

String answer = read.next();

if (answer.equalsIgnoreCase( "Yes" ) )
{
System.out.print("Enter key number used (1-3) : ");
int kNum = read.nextInt();

Key k = null;   

if (kNum == 1)
    k = key1;
    else
    if (kNum == 2)
    k = key2;
    else
    if (kNum == 3)
    k = key3;
    
    if ( k != null && k.getisSet())
    {
    currentSentence.setSentence(s , k);
    }
    else 
    {
    System.out.println(" Invalid key . ");
    }   
}
else 
{
currentSentence.setSentence(s);
}
}    
      
 public static void displayCurrentSentence(){
  if (currentSentence != null) 
   currentSentence.displayMe();
   else 
  System.out.println("No Secrue Sentence selected . ");
  }
  
  public static void encryptSentence()
{
if (currentSentence == null){
System.out.println("No Secrue Sentence selected . ");
}//check
  System.out.println("Enter key number (1-3) to use for encryption : ");
  int kNum = read.nextInt();
Key k = null;   

if (kNum == 1)
    k = key1;
    else
    if (kNum == 2)
    k = key2;
    else
    if (kNum == 3)
    k = key3;
if ( k == null ){
System.out.println("Invalid key number .");
}//check
currentSentence.encrypt(k);
}
public static void decryptSentence(){

if (currentSentence == null){

System.out.println("No Secrue Sentence selected . ");

return;
}

currentSentence.decrypt();

}

public static void displayAllSentences(){

System.out.println("Sentence #1 : ");
s1.displayMe();
System.out.println("Sentence #2 : ");
s2.displayMe();

if (currentSentence == s1)

System.out.println("Current sentence : #1 ");
else if (currentSentence == s2)
System.out.println("Current sentence : #2 ");

}
}