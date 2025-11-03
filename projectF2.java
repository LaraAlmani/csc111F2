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

if (o.length() == c.length() && o.length() > 0){
return true;
}
else {
return false ;
}
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
System.out.println ("\n +-------------------+");
}
}
}

class SecureSentence{

private String sentence;
private Key keyUsed;
private boolean encrypted;

public SecureSentence(){
sentence ="";
keyUsed = new Key();
encrypted = false;
}


public void setSentence(String s){
sentence = s;
encrypted = false;
keyUsed.isSet = false;
}

public void setSentence(String s , Key key){

if (key.isSet){
sentence = s;
encrypted = true;
keyUsed = key;
}
else {
System.out.println("Cannot set sentence : Key not set yet . ");
}
}

public void encrypt (Key key){

if (!encrypted && key.isSet){
sentence = encryptWithKey(sentence , key);
keyUsed = key ; 
encrypted = true;
System.out.println("Sentence has encrypted successfully! ");
}
else if (encrypted) {
System.out.println("Encryption failed : Sentence already encrypted.  ");
}
else {
System.out.println("Encryption failed : Key not set.  ");
}
}

public void decrypt(){
if (encrypted){
sentence = decryptWithKey(sentence , keyUsed);
encrypted = false;
System.out.println("Sentence has decrypted successfully! ");
}
else{
System.out.println("Decryption failed : Sentence is not encrypted.  ");
}
}

public void displayMe(){

System.out.println("--------------------------");
System.out.println("Sentence : " + sentence);
System.out.println("Encrypted : " + encrypted);
if (keyUsed.isSet){
System.out.println("Using Key ID : " + keyUsed.ID);
}
else {
System.out.println("No key used. ");}
System.out.println("--------------------------");
}

public boolean isEncrypted(){
return encrypted;
}

private String encryptWithKey(String s , Key k){

String result = "";
for (int i = 0; i < s.length(); i++ ){


}}}
//csc 11



















public class projectF2
{
   static Scanner input = new Scanner (System.in);
   public static void main (String [] args)
   {
      String keyO ="" , keyC ="" , sen ="" , PIN =""; // Declare and initialize the variables .
      int choice;
     String keyset ="";      
     String PIN_input;
     String senset= "";
     String pinset =""; 
      do {
      System.out.println();
         System.out.println("Enter a 4-digit PIN that does not start with zero : ");   // Set the PIN .
         
         PIN = input.next();
         input.nextLine();
         if (PIN.length() != 4){

          System.out.println("\n Invalid PIN : you should enter 4-digit . .\n"); }
          else
          
          if(PIN.charAt(0)=='0'){
          
           System.out.println("\n Invalid PIN : you cannot start with zero . .\n");} 
           else
           {
           int i;
           for (i=0 ; i<PIN.length() ; i++)
           {
            char a = PIN.charAt(i);
            if ( a < '0' || a > '9' )
            {
            pinset = "yes";
            System.out.println("Invalid PIN : you entered a letter .");
            break; 
            }
            }
            }                 
      }
      while (!(PIN.length() == 4 && PIN.charAt(0)!='0' && !(pinset == "yes") ));  // If the condition is true , the user enters the system . 
             
           do {
         System.out.println("\n --- Main Menu ---");       // The main menu .
         System.out.println("1. Set / Change the key "); 
         System.out.println("2. Display the key ");
         System.out.println("3. Enter the sentence ");
         System.out.println("4. Display the current sentence ");
         System.out.println("5. Encrypt the sentence ");
         System.out.println("6. Decrypt the sentence ");
         System.out.println("7. Exit ");
         System.out.println("\n Enter choice : ");
         choice = input.nextInt();                              // Read the choice .
         input.nextLine();
         
         
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
          while (choice !=7); // While the user does not choose to exit system .
   
   }
}