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



class SecureSentence{ // SecureSentence class 

private String sentence;     //// Attributes for SecureSentence class
private Key keyUsed;
private boolean encrypted;

public SecureSentence(){ // default constructor
sentence ="";
keyUsed = null;
encrypted = false;
}


public void setSentence(String s){  // setSentence method store the new sentence without a key 
sentence = s;
encrypted = false;
keyUsed = null;
}

public void setSentence(String s , Key key){ // setSentence method store the new sentence with a key encryption ( overload :) )

sentence = s;
encrypted = true;
keyUsed = key;
}

public void encrypt (Key key){ // encrtpy method accepts key and encrypts sentence using key

if (sentence.equals("") || !key.getisSet()){
System.out.println("Encryption failed : ( Key not set or sentence missing ).  ");
}
if (encrypted) {
System.out.println("Encryption failed : Sentence already encrypted.  ");
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

public void decrypt(){ // decrypt method decrypts an encrypted sentence and stores it in the variable result
if (!encrypted){
System.out.println("Decryption failed : ( not encrypted ).  ");
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


public void displayMe(){ // displayMe method displays (sentence, encrypted sentence, key used to encrypt)

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

public boolean isEncrypted(){  //isEncrypted method takes the value of the private variable encrypted
return encrypted;
}
} // end of SecureSentence class