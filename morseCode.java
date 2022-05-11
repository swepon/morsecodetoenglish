import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class morseCode 
{
    private HashMap<String, String> dictionary = new HashMap<String, String>();

    public static void main(String args[])
    {
        morseCode x = new morseCode();
        x.addToHashMap(); 
        //System.out.println(x.englishToMorse());
        System.out.println(x.morseToEnglish());
    }

    public void addToHashMap()
    {
            dictionary.put("a", ".-");
            dictionary.put("b", "-...");
            dictionary.put("c", "-.-.");
            dictionary.put("d", "-..");
            dictionary.put("e", ".");
            dictionary.put("f", "..-.");
            dictionary.put("g", "--.");
            dictionary.put("h", "....");
            dictionary.put("i", "..");
            dictionary.put("j", ".---");
            dictionary.put("k", "-.-");
            dictionary.put("l", ".-..");
            dictionary.put("m", "--");
            dictionary.put("n", "-.");
            dictionary.put("o", "---");
            dictionary.put("p", ".--.");
            dictionary.put("q", "--.-");
            dictionary.put("r", ".-.");
            dictionary.put("s", "...");
            dictionary.put("t", "-");
            dictionary.put("u", "..-");
            dictionary.put("v", "...-");
            dictionary.put("w", ".--");
            dictionary.put("x", "-..-");
            dictionary.put("y", "-.--");
            dictionary.put("z", "--..");
            dictionary.put("1", ".----");
            dictionary.put("2", "..---");
            dictionary.put("3", "...--");
            dictionary.put("4", "....-");
            dictionary.put("5", ".....");
            dictionary.put("6", "-....");
            dictionary.put("7", "--...");
            dictionary.put("8", "---..");
            dictionary.put("9", "----.");
            dictionary.put("0", "-----");
            dictionary.put(" ", "");
    }  

    //converting from english to morse
    public String englishToMorse()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phrase: ");
        String phrase = scanner.nextLine();
        scanner.close();
        phrase.toLowerCase();
        String morse = "";
    
        for (int i = 0; i < phrase.length(); i ++)
        {
            char letter = phrase.charAt(i); 
            String letterStr = letter + "";
            //if letter is in the dictionary as a key 
            if (dictionary.containsKey(letterStr))
            {
                String morseForLetter = dictionary.get(letterStr) + " ";
                morse += morseForLetter;
            }
            //if letter is not in the dictionary as a key
            else
            {
                String morseForLetter = letterStr;
                morse += morseForLetter;
            } 
        }
        return morse;
    } 

    //converting morse code to english
    public String morseToEnglish()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter morse code using only - and . and using a space between each letter");
 
        String phrase = scanner.nextLine();
        scanner.close();
        phrase = phrase + " ";
        String englishPhrase = "";
        int indexOfSpace = 0;

        for (int i = 0; i < phrase.length(); i ++)
        {
            char letter = phrase.charAt(i);
            if (letter == ' ')
            {
                String morseLetter = phrase.substring(indexOfSpace, i);
                morseLetter = morseLetter.replaceAll("\\s", "");
                //checks if dictionary contains the morse code letter
                if (dictionary.containsValue(morseLetter))
                {
                    for (Map.Entry<String, String> entry: dictionary.entrySet())
                    {
                        if (entry.getValue().equals(morseLetter))
                        {
                            String englishChar = entry.getKey();
                            englishPhrase += englishChar;
                            break;
                        }  
                    }
                }
                else
                {
                    englishPhrase += morseLetter;
                }
                indexOfSpace = i;
            }
        }
        return englishPhrase;
    }

   


}
