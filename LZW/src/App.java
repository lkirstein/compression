import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {


        String input = "";
        String output = "";

        String lastWord = "";
        String currentWord = "";

        String dictKey = ""; 
        int currentValue = 0;

        HashMap<String, Integer> dictionary = new HashMap<>();


        System.out.println();
        System.out.print("Enter String: ");

        Scanner readLine = new Scanner(System.in);
        input = readLine.nextLine();

        System.out.println();


        int[] outputCode = new int[input.length()];
        int outputCodeCounter = 0;
        
        // Dictionary
        for (int i = 0; i < input.length(); i++) {

            if (dictionary.containsKey(String.valueOf(input.charAt(i)))) {
                System.out.println(String.valueOf(input.charAt(i)) + " already exists.");
            }
            else {
                dictionary.put(String.valueOf(input.charAt(i)), currentValue);
                System.out.println("Added " + String.valueOf(input.charAt(i)) + " as " + currentValue);
                currentValue++;
            }
        }

        System.out.println();
        System.out.println(dictionary);
        System.out.println();

        for (int i = 0; i <= input.length(); i++) {
                        
            if (i < input.length()) {
                currentWord = String.valueOf(input.charAt(i));
            }
            else {
                currentWord = "";
            }

            dictKey = lastWord + currentWord;

            System.out.print(lastWord + "\t | " + currentWord + "\t | ");

            if (i == input.length()) {
                
                if (dictionary.containsKey(dictKey)) {
                    outputCode[outputCodeCounter] = dictionary.get(lastWord);

                    System.out.print("\t\t | " + outputCode[outputCodeCounter]);

                    outputCodeCounter++;
                }
                else {
                    dictionary.put(dictKey, currentValue);
                    currentValue++;

                    outputCode[outputCodeCounter] = dictionary.get(lastWord);

                    System.out.print(dictKey + ": " + dictionary.get(dictKey) + "\t | " + outputCode[outputCodeCounter]);

                    outputCodeCounter++;
                }

            }
            else {
                if (dictionary.containsKey(dictKey)) {

                    lastWord = dictKey;

                }
                else {
                    dictionary.put(dictKey, currentValue);
                    currentValue++;

                    outputCode[outputCodeCounter] = dictionary.get(lastWord);

                    System.out.print(dictKey + ": " + dictionary.get(dictKey) + "\t | " + outputCode[outputCodeCounter]);

                    outputCodeCounter++;

                    lastWord = currentWord;
                }
            }

            System.out.println();

        }

        System.out.println("Value of next dictionary entry : \t" + currentValue);
        System.out.println("Total length of output : \t" + outputCodeCounter);

        for (int i = 0; i < outputCodeCounter; i++) {
            System.out.print(outputCode[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < outputCodeCounter; i++) {
            output += outputCode[i];
        }
        System.out.println(output);

        System.out.println(dictionary);

        //Testwert: ababcabac



        System.out.println();
        System.out.println();
        System.out.println("Decompressing:");

        for (int i = 0; i < outputCodeCounter; i++) {
        
            for (HashMap.Entry<String, Integer> entry : dictionary.entrySet()) {
                if (entry.getValue().equals(outputCode[i])) {
                    System.out.print(entry.getKey());
                }
            }

        }

        System.out.println();
        System.out.println();
        System.out.println();

    }
}
