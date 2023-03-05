import java.sql.PreparedStatement;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println(pigIt("Pig latin is cool"));
    }

    public static int[] twoSum(int[] numbers, int target)
    {


        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                if (numbers[i] + numbers[j] == target)
                {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //Get count of all the vowels in a string
    public static int getCount(String str)
    {
        String vowels = "aeiou";
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (vowels.contains(String.valueOf(str.charAt(i))))
            {
                count++;
            }
        }
        return count;
    }

    public static int countSmileys(List<String> arr)
    {
        // Just Smile :)
        int count = 0;
        for (String s : arr)
        {
            if (s.matches("[:;][-~]?[)D]"))
            {
                count++;
            }
        }
        return count;
    }

    public static int countBits(int n)
    {
        // Show me the code!
        String binary = Integer.toBinaryString(n);
        //count the number of 1's in the binary string
        int count = 0;
        for (int i = 0; i < binary.length(); i++)
        {
            if (binary.charAt(i) == '1')
            {
                count++;
            }
        }
        return count;
    }

    public String cleanString(String s)
    {
        // your code here
        String result = "";
        //abc##d
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) != '#')
            {
                result += s.charAt(i);
            } else
            {
                if (result.length() > 0)
                {
                    result = result.substring(0, result.length() - 1);
                }
            }
        }
        return result;
    }

    public static String order(String words)
    {
        if(words.isEmpty())
        {
            return "";
        }
        //split the string into an array of words
        String[] wordsArray = words.split(" ");
        //create a new array of the same size as the wordsArray
        String[] result = new String[wordsArray.length];
        //loop through the wordsArray
        for (int i = 0; i < wordsArray.length; i++)
        {
            //loop through each word in the wordsArray
            for (int j = 0; j < wordsArray[i].length(); j++)
            {
                //check if the character at index j is a number
                if (Character.isDigit(wordsArray[i].charAt(j)))
                {
                    //if it is a number, add the word to the result array at the index of the number
                    result[Character.getNumericValue(wordsArray[i].charAt(j)) - 1] = wordsArray[i];
                }
            }
        }
           //join the result array into a string
        return String.join(" ", result);
    }
    public static String camelCase(String str) {
        // your code here
        String result = "";
       //split the string into an array of words
        String[] wordsArray = str.split(" ");
        //loop through the wordsArray
        for (int i = 0; i < wordsArray.length; i++)
        {
            //if the word is not empty
            if(!wordsArray[i].isEmpty())
            {
                //capitalize the first letter of the word
                wordsArray[i] = wordsArray[i].substring(0, 1).toUpperCase() + wordsArray[i].substring(1);
            }
        }
        //join the wordsArray into a string
        return String.join("", wordsArray);
    }

    public static int persistence(long n) {
        // your code
        int count = 0;
        while(n > 9)  //39->3*9=27->2*7=14->1*4=4
        {
            long product = 1;
            while(n > 0)
            {
                product *= n % 10;
                n /= 10;

            }
            n = product;
            count++;
        }
        return count;
    }
    public static boolean alphanumeric(String s){

        return s.matches("[a-zA-Z0-9]+");
    }

    public static String pigIt(String str)
    {

        String[] words = str.split(" ");

        // move the first letter of each word to the end of it, then add "ay" to the end of the word.


        String result = "";

        for (int i = 0; i < words.length; i++)
        {
            if(words[i].matches("[^a-zA-Z]+"))
            {
                result += words[i] + " ";
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[i].substring(1));
            sb.append(words[i].charAt(0));
            sb.append("ay");
            result += sb.toString() + " ";
            System.out.println(sb);

        }
        return result.substring(0, result.length() - 1);
    }

}
