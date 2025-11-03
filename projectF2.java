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

public boolean isSet(){

return isSet ;
}

public void setisSet(boolean val){

isSet = val ;
}




public void displayMe()
{
System.out.println ("\n +-------------------+");
System.out.println("| Key#" + ID);

if (isSet)
{
System.out.println("|Status : set");
System.out.println("Original: " + original);
System.out.println("Code: " + code);
}
else 
{
System.out.println (" no set ");
System.out.println ("\n +-------------------+");
}
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
private Key keyUsed = new Key();
private boolean encrypted;

public SecureSentence(){
sentence ="";
keyUsed = new Key();
encrypted = false;
}


public void setSentence(String s){
sentence = s;
encrypted = false;
keyUsed = new Key();
}

public void setSentence(String s , Key key){

if (key.isSet()){
sentence = s;
encrypted = true;
keyUsed = key;
}
else {
System.out.println("Cannot set sentence : Key not set yet . ");
}
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
if (!encrypted || !keyUsed.getisSet()){
System.out.println("Decryption failed : ( not encrypted or key not set ).  ");
return;
}

if (sentence.equals("")){
System.out.println("Decryption failed : sentence is missing .  ");
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
if (keyUsed.getisSet()){
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
static int systemPin = -1;

public static void setPin (Scanner read){
while (true){

System.out.println("Enter a 4-digit PIN that does not start with zero : ");
String pinstr = read.next();

if (pinstr.length() == 4 && pinstr.charAt(0) !='0'){

systemPin = Integer.parseInt(pinstr);
break;
}
else {
System.out.println("\n Invalid PIN. Try again . .\n"); }
}
}

public static boolean pinMatches(int pin){

return pin == systemPin;
}

public static int menu(Scanner read){


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
         int choice = read.nextInt();
         if (choice < 1 || choice > 9){
         System.out.println("Invalid choice,please enter a number 1-9 . "); 
         return -1 ;
         }
         return choice;
         }

      public static void main (String [] args)
      {
      Scanner read = new Scanner (System.in);
       
      Key key1 = new Key ();
      Key key2 = new Key ();
      Key key3 = new Key ();
      
      SecureSentence s1 = new SecureSentence ();
      SecureSentence s2 = new SecureSentence ();
      SecureSentence current = new SecureSentence ();
      
      setPin(read);
      
      
             
                   
         
         switch (choice)
         {
            case 1: 
               System.out.println("\n Enter PIN :  ");    // If PIN is correct, user is prompted to enter key original and key code .
                PIN_input = input.nextLine();
                input.nextLine();
               if (PIN_input.equals(PIN))               
               {
               System.out.print("\n Enter key original : ");    
               
                keyO = input.nextLine();
                   input.nextLine();   
                  int lenO = keyO.length();    
                  
                  System.out.print("\n Enter key code : "); 
                  
                  keyC = input.nextLine();       
                  input.nextLine();
                  int lenC = keyC.length();      
                  
                  if (lenO == lenC)   
                  {
                     int count = 0;  
                     for (int i = 0 ; i < lenC ; i++) {     // Checking for all characters in key original if they match characters of key code .
                        if (keyC.indexOf(keyO.charAt(i)) != -1){  
                           count++;   
                     }
                     }
                     if (count == lenC){  
                        keyset = "yes";   
                        System.out.println("\n Key saved successfully. "); 
                     }
                     else{
                        System.out.println("\n Invalid key (characters mismatch)."); 
                        }
                  } 
                  else {
                  System.out.println("\n Invalid key (length not equal)."); 
                  }
                  }
                  else {
                     System.out.println("\n Wrong PIN .");  
                     }
                  break;
                  case 2 :
               System.out.println("\n Enter PIN :  ");  // If PIN is correct and keys are set, key (original/code) are displayed .
               PIN_input = input.nextLine();
               input.nextLine();
               if (PIN_input.equals(PIN) && (keyset.equals("yes")))  // Checking if PIN is correct .
               {
               System.out.print("\n The original key is : " + keyO+"\n"+"\n The key code is : " + keyC+ "\n");
               }
               else
               {
               System.out.print("\n No key set OR wrong PIN .\n"); 
               }
               break;
               
               case 3 :
               System.out.println("\n Enter a sentence :");  // Prompting user to enter sentence, then sentence is read and saved .
               sen = input.nextLine();
               input.nextLine();  
               senset = "yes";         
               System.out.println("\n"+"Sentence saved successfully ."); 
               break;
               
               case 4 :
                
                if (senset.equals("yes")) // If a sentence was typed, sentence is displayed to the user .
                {
                System.out.print(sen);  
                }
                else 
                {
                System.out.print("\n"+"No sentence entered ."+"\n");
                }
                break;
               
                case 5 :
                if ((keyset.equals("yes")) && !senset.equals(""))  // Checking if key exsists and sentence exists .
                {
               String encr ="";  
                for (int i = 0 ; i < sen.length() ; i++)  
                {
                char c1 = sen.charAt(i);                          // c1 stores the character in sentence at position i .
                int pos =keyO.indexOf(c1);                    //pos stores position of character c1 in key original .
               
                if (pos != -1) 
                {
               encr += keyC.charAt(pos);                      // Adding the corresponding character from key code to the encrypted sentence .
              }
              else 
              {
              encr += c1; 
              }
              }
               sen = encr;  
               System.out.println("\n The encrypted sentence is : " + sen);  
               }
               else 
               {
               System.out.println ("\n Key or the sentence is missing .");  
               }
               break;
               
               case 6 :
               if (keyO.length() > 0 && keyC.length() > 0 && sen.length() > 0)  // If key original and key code and sentence were written, .
               {
               String decr = ""; 
               for (int i = 0 ; i < sen.length(); i++)    // i checks for every character in sentence .
               {
               char c2 = sen.charAt(i);                //c2 stores the character in sentence at position i .
               for (int p = 0 ; p < keyC.length(); p++)    //p checks for every character in key code .
               {
               if (c2 == keyC.charAt(p))  // If c2 at position i exsists in key code at position p, the corresponding character from key original to key code will be stored in c2  .
               {
               c2 = keyO.charAt(p);  
               break;
               }
               }
               decr += c2;  
               }
               sen = decr;  
               System.out.println ("\n The decrypted sentence is : " + sen);  
               }
               else 
               {
               System.out.println("\n Key or the sentence is missing ."); 
               }
               break;
               case 7 :
               System.out.println("\n see you soon :)");  // Goodbye message .
               break;
               default :
               System.out.println("Invalid choice,please enter a number 1-7 . ");  
               } 
               }              
         
   
   }

