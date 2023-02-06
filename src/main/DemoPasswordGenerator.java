package package1;

import java.util.Random;

public class PasswordGenerator {

	public static void main(String[] args) {


		

//		System.out.println(generatePass1());
		
//		System.out.println(generatePass2());
		
		for(int i = 0; i < 100; i++)
		{
			System.out.println(generatePass2());
		}

//		passwordGenerator_test1();
		
//		passwordGenerator_test2();

		
		
	}
	
	
	
	
	
	/*
	 * Password generate methods:
	 */
	
	
	
    /*
     * Method: generatePass1()
     * 
     * - Description: Generates random 18 character passwords. Only uses letters, numbers, and 2 (-) symbols.
     * 
     * - Notes:
     * 		- 2 dashes (-) are inserted in every password at the 1/3 and 2/3 spots.
     * 		- Only uses letters and numbers besides the 2 dashes (-).
     * 		- There are varying probabilities for whether a vowel, consonant, or number is chosen
     * 		  based on the previous character added when the password is being made.
     * 				- Higher probability a vowel is chosen, if a consonant was chosen last.
     * 				- Higher probability a consonant is chosen, if a vowel was chosen last.
     * 				- Very low probability 2 numbers are chosen in a row.
     * 		- No uppercase letters.
     * 
     * - Constraints: 
     */

	public static String generatePass1() {
		
		String password = "";
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
		char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		//char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', };
		
		
		/* Randoms */
		Random rand = new Random();
		
		
		/* Pick first character */
		
		char[] arrayChosen = pickArray(vowels,consonants,numbers,33,33,33);
		password += arrayChosen[rand.nextInt(arrayChosen.length)];
		
		/* loop for the rest, add/change probabilities (if desired) */
		
		for(int i = 1; i < 20; i++)
		{
			if(i == 6 || i == 13)
			{
				password += '-';
				continue;
			}
			
			if(arrayChosen == vowels)
			{
				arrayChosen = pickArray(vowels,consonants,numbers,25,50,25);
				password += arrayChosen[rand.nextInt(arrayChosen.length)];
				continue;
			}
			
			if(arrayChosen == consonants)
			{
				arrayChosen = pickArray(vowels,consonants,numbers,66,17,17);
				password += arrayChosen[rand.nextInt(arrayChosen.length)];
				continue;
			}
			
			if(arrayChosen == numbers)
			{
				arrayChosen = pickArray(vowels,consonants,numbers,48,48,4);
				password += arrayChosen[rand.nextInt(arrayChosen.length)];
				continue;
			}
		}

		return password;
	}
	
	
	
	
	
	
    /*
     * Method: generatePass2()
     * 
     * - Description: Generates random 18 character passwords. Only uses letters, numbers, and 2 (-) symbols.
     * 				  This method differs from the generatePass1(), in that it randomly capitalizes
     * 				  some of the letters.
     * 
     * - Notes:
     * 		- 2 dashes (-) are inserted in every password at the 1/3 and 2/3 spots.
     * 		- Only uses letters and numbers besides the 2 dashes (-).
     * 		- There are varying probabilities for whether a vowel, consonant, or number is chosen
     * 		  based on the previous character added when the password is being made.
     * 				- Higher probability a vowel is chosen, if a consonant was chosen last.
     * 				- Higher probability a consonant is chosen, if a vowel was chosen last.
     * 				- Very low probability 2 numbers are chosen in a row.
     * 		- Can have uppercase letters.
     * 				- Passwords have a high chance to have 1 uppercase letter, and lesser chances
     * 				  to have 0,2, or 3 uppcase letters.
     * 
     * - Constraints: 
     */
	
	public static String generatePass2() {
		
		String password = "";
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
		char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		//char[] symbols = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', };
		
		
		/* Randoms */
		Random rand = new Random();
		
		
		/* Pick first character */
		
		char[] arrayChosen = pickArray(vowels,consonants,numbers,33,33,33);
		password += arrayChosen[rand.nextInt(arrayChosen.length)];
		
		/* loop for the rest, add/change probabilities (if desired) */
		
		for(int i = 1; i < 20; i++)
		{
			if(i == 6 || i == 13)
			{
				password += '-';
				continue;
			}
			
			if(arrayChosen == vowels)
			{
				arrayChosen = pickArray(vowels,consonants,numbers,25,50,25);
				password += arrayChosen[rand.nextInt(arrayChosen.length)];
				continue;
			}
			
			if(arrayChosen == consonants)
			{
				arrayChosen = pickArray(vowels,consonants,numbers,66,17,17);
				password += arrayChosen[rand.nextInt(arrayChosen.length)];
				continue;
			}
			
			if(arrayChosen == numbers)
			{
				arrayChosen = pickArray(vowels,consonants,numbers,48,48,4);
				password += arrayChosen[rand.nextInt(arrayChosen.length)];
				continue;
			}
		}
		
		
		/* add random capitalization - (1x 30/31 chance, 2x 1/21 chance) */
		
		password = addUppercase(password,30,1);
		
		for(int i = 0; i < 2; i++)
		{
			password = addUppercase(password,1,20);
		}

		return password;
	}
	
	
	
	
	
	
	

	
	
	
	/*
	 * Helper Methods: -------------------------------------------------------
	 */
	
	
    /*
     * Method: pickArray(arr1, arr2, arr3, prob1, prob2, prob3)
     * 
     * - Description: Pass in 3 char arrays and 3 corresponding probabilities (as desired), 
     * 				  returns one of the arrays based on the probabilities given
     * 
     * - Notes:
     * 		- any valid int values can be given for the probabilities.
     * 		- each given probability value will give its corresponding array a that-many-rolls
     *        chance, out of the sum total of all 3.
     *      - Prints an error message if no array is chosen and returns null
     *        (Although it never should)
     * 
     * - Constraints:
     * 		- If the sum of all 3 probabilities goes over MAX int, it will probably cause an error. 
     */

	
	public static char[] pickArray(char[] arr1, char[] arr2, char[] arr3, int probability1, int probability2, int probability3) {
		
		Random rand = new Random();
		
		int choice = rand.nextInt(probability1 + probability2 + probability3);
		
		if(choice >= 0 && choice < probability1)
		{
			return arr1;
		}
		
		if(choice >= probability1 && choice < (probability1 + probability2))
		{
			return arr2;
		}
		
		if(choice >= (probability1 + probability2) && choice < (probability1 + probability2 + probability3))
		{
			return arr3;
		}
		
		
		System.out.println("Error: pickArray()");
		return null;
	}
	
	
	
	
	
	
	
    /*
     * Method: addUppercase(String str, int success, int fail)
     * 
     * - Description: Takes a string, a success probability, and fail probability. On success,
     * 				  a random character is capitalized in the string and the string is returned.
     * 				  The character capitalized will not be a number a symbol.
     * 
     * - Notes:
     * 		- If success AND the character chosen NOT a letter, a character will be chosen again
     * 		  randomly, until a letter is chosen.
     * 
     * - Constraints: 
     * 		- If a letter that is already upper-case, it will accept it and capitalize it again
     * 		  returning the same string.
     */
	
	public static String addUppercase(String str, int success, int fail) {
		
		int probability = success + fail;
		Random rand = new Random();
		
		int num = rand.nextInt(probability);
		
		if(num >= 0 && num < success)
		{
			//capitalize
			
			int index = rand.nextInt(str.length());
			char c = str.charAt(index);
			
			while(c == '-' || c == '0' || c == '1' || c == '2' || c == '3' || c == '4' 
					|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
			{
				index = rand.nextInt(str.length());
				c = str.charAt(index);
			}
			
			str = str.substring(0,index)
					+ str.substring(index, index+1).toUpperCase()
					+ str.substring(index+1);
		}
		
		if(num >= success && num < fail)
		{
			//don't capitalize
		}
		
		return str;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Testing Methods:
	 */
	
	
	
	
	
    /*
     * Method: passwordGenerator_test1()
     * 
     * - Description: Driver test to test PasswordGenerator.java.
     * 
     * - Notes:
     * 		- Uses generatePass2() and comparePass(String pass1, String pass2) methods.
     * 		- Creates array of 1000 passwords, and compares all passwords to each other,
     * 		  returning the number of matches each comparison has.
     * 
     * - Constraints: 
     */

	public static void passwordGenerator_test1() {
		
		String[] arr = new String[1000];
		PasswordGenerator p = new PasswordGenerator();
		
		for(int i = 0; i < 1000; i++)
		{
			arr[i] = p.generatePass2();
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				if(i == j)
				{
					continue;
				}
				
				System.out.print(comparePass(arr[i], arr[j])+" ");
				if(j % 30 == 0)
				{
					System.out.println();
				}
			}
		}
		
	}
	
	
	
    /*
     * Method: passwordGenerator_test2()
     * 
     * - Description: Driver test to test PasswordGenerator.java.
     * 
     * - Notes:
     * 		- Uses generatePass2() and comparePass(String pass1, String pass2) methods.
     * 		- Creates array of 1000 passwords, and compares all passwords to each other,
     * 		  returning the number of matches each comparison has.
     * 		- Same as passwordGenerator_test1(), except: it counts the results and displays the counts.
     * 
     * - Constraints: 
     */
	
	public static void passwordGenerator_test2() {
		
		String[] arr = new String[1000];
		PasswordGenerator p = new PasswordGenerator();
		
		int zero=0, one=0, two=0, three=0, four=0, five=0, six=0, seven=0, eight=0, nine=0, ten=0,
				eleven=0, twelve=0, thirteen=0, fourteen=0, fifteen=0, sixteen=0, seventeen=0, eighteen=0;
		int result;
		
		for(int i = 0; i < 1000; i++)
		{
			arr[i] = p.generatePass2();
		}
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				if(i == j)
				{
					continue;
				}
				
				result = comparePass(arr[i], arr[j]);
				
				if(result == 0) zero++;
				if(result == 1) one++;
				if(result == 2) two++;
				if(result == 3) three++;
				if(result == 4) four++;
				if(result == 5) five++;
				if(result == 6) six++;
				if(result == 7) seven++;
				if(result == 8) eight++;
				if(result == 9) nine++;
				if(result == 10) ten++;
				if(result == 11) eleven++;
				if(result == 12) twelve++;
				if(result == 13) thirteen++;
				if(result == 14) fourteen++;
				if(result == 15) fifteen++;
				if(result == 16) sixteen++;
				if(result == 17) seventeen++;
				if(result == 18) eighteen++;
				
				
			}
		}
		
		System.out.println("0: "+zero);
		System.out.println("1: "+one);
		System.out.println("2: "+two);
		System.out.println("3: "+three);
		System.out.println("4: "+four);
		System.out.println("5: "+five);
		System.out.println("6: "+six);
		System.out.println("7: "+seven);
		System.out.println("8: "+eight);
		System.out.println("9: "+nine);
		System.out.println("10: "+ten);
		System.out.println("11: "+eleven);
		System.out.println("12: "+twelve);
		System.out.println("13: "+thirteen);
		System.out.println("14: "+fourteen);
		System.out.println("15: "+fifteen);
		System.out.println("16: "+sixteen);
		System.out.println("17: "+seventeen);
		System.out.println("18: "+eighteen);
		
	}
	
	
	
	
	
	
    /*
     * Method: comparePass(String pass1, String pass2)
     * 
     * - Description: Returns the number of matches 2 generated-passwords contained. To be considered
     * 				  a match, there has to be the same character at the same index of the String.
     * 
     * - Notes:
     * 
     * - Constraints: 
     */
	public static int comparePass(String pass1, String pass2) {
		
		int matches = 0;
		
		/* Error check */
		if(pass1.length() != pass2.length())
		{
			System.out.println("Error: comparePass() - lengths different");
			return -1;
		}
		
		/* Method test */
		for(int i = 0; i < pass1.length(); i++)
		{
			if(i == 6 || i == 13)
			{
				continue;	//don't count the dashes (-) as matches
			}
			
			if(pass1.charAt(i) == pass2.charAt(i))
			{
				matches++;
			}
		}

		return matches;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	//End Class
