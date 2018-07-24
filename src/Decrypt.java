import java.io.File;
import java.sql.Array;


public class Decrypt
{
	/**
	 * Decrpt class contains various methods in order to aquire the key of a mathcing cipher text to a plain text.
	 * getKey method uses an alphabet array to looping the length of which records where each a character is compared to the alphabet array
	 * decipher method is used to compare the 2nd cipher txt file and compares it to the alphabet once again, in the main get key is used as the key
	 * as the second parameter.
	 * 
	 * getKey and getDecip are used to return the results that are obtained.
	 */
	public Decrypt()
    {
		
	}
	
	String key = "";
	String result= "";
	char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	//compares plain text and cipher file to each other using alphabet array and result is stored in index.
	public void getkey(String p1f, String c1f)
    {
		int index = 0;
		boolean found = false;

        for( int i = 0; i < alphabet.length; i++)
        {
            for (int j = 0; j < p1f.length(); j++)
            {
                if ((p1f.charAt(j) == alphabet[i]) && !found)
                {

                    index = j;
                    found = true; // if the letter is not found it is run again until 26 are found.
                }
            }

            found = false;
            key = key + c1f.charAt(index);
            System.out.println(alphabet[i] + "-->" + c1f.charAt(index)); // displays the letters of each text with corresponding index.
            
        }
        
        System.out.println(key);
    }
		
	//compares key and file to each other using alphabet array and result is stored in result.
	public void deciper(String c2, String key){
		
		for(int i = 0; i < c2.length(); i++){
		
			for (int j = 0; j < alphabet.length; j++){
			
				if(c2.charAt(i) == key.charAt(j)){
					result = result + alphabet[j];
				}
			}
			
			
		}
		
		
	}
	
	public String getKey(){
		return key;
	}
	
	public String getDeCip(){
		return result;
	}
}
	
