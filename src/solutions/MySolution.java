package solutions;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution implements Solution {

    @Override
    public String reverseString(String word) {
        char[] charArray = word.toCharArray();
        char temp;
        int begin = 0;
        int end = charArray.length-1;
        String result;
        while (end > begin) {
            temp = charArray[begin];
            charArray[begin] = charArray[end];
            charArray[end] = temp;
            begin++;
            end--;
        }
        result = new String(charArray);
        return result;
    }

    @Override
    public long factorialize(int number) {
        long result = 1;
        for (int i = 1; i < number; i++) {
            result += result * i;
        }
        return result;
    }

    @Override
    public boolean palindrome(String word) {
        char[] wordArray = word.toCharArray();
        List<Character> charList = new ArrayList<>();
        for (int i = 0; i < wordArray.length; i++) {
            if (Character.isLetter(wordArray[i]) || Character.isDigit(wordArray[i])) {
                charList.add(Character.toLowerCase(wordArray[i]));
            }
        }
        int begin = 0;
        int end = charList.size()-1;
        while (end > begin) {
            if (charList.get(begin) != charList.get(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    @Override
    public int findLongestWord(String word) {
        String[] str = word.split(" ");
        int longest = str[0].length();
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > longest) {
                longest = str[i].length();
            }
        }
        return longest;
    }

    @Override
    public String titleCase(String word) {
        char[] charArray = word.toCharArray();
        char[] resArray = new char[charArray.length];
        resArray[0] = Character.toUpperCase(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i-1] == ' ') {
                resArray[i] = Character.toUpperCase(charArray[i]);
            } else {
                resArray[i] = Character.toLowerCase(charArray[i]);
            }
        }
        return new String(resArray);
    }

    @Override
    public int[] largestOfFour(int[][] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = findMaxIndexValue(numbers[i]);
        }
        return result;
    }
    public int findMaxIndexValue(int[] eachArray) {
        int maxI = 0;
        for (int i = 0; i < eachArray.length; i++) {
            if (eachArray[i] > eachArray[maxI]) {
                maxI = i;
            }
        }
        return eachArray[maxI];
    }

    @Override
    public boolean confirmEnding(String word, String end) {
        if (word.length() > end.length()) {
            if (word.substring(word.length()-end.length()).equals(end)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String repeatStringNumTimes(String word, int counter) {
        String result = "";
        int count = 0;
        if (counter >= 0) {
            while (counter > count) {
                result += word;
                count++;
            }
        }
        return result;
    }

    @Override
    public String truncateString(String word, int counter) {
        if (word.length() <= 3 || counter <= 3) {
            return word.substring(0, counter) + "...";
        } else if (word.length() > counter){
            return word.substring(0, counter-3) + "...";
        }
        return word;
    }

    @Override
    public Object[][] chunkArrayInGroups(Object[] numbers, int counter) {
        int numberOfArrays = (int) Math.ceil((double) numbers.length / counter);
        Object[][] result = new Object[numberOfArrays][];
        List<Object> eachArr = new ArrayList();
        int addedArrays = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (eachArr.size() == counter) {
                result[addedArrays] = eachArr.toArray();
                eachArr = new ArrayList<>();
                addedArrays++;
            }
            eachArr.add(numbers[i]);
        }
        result[addedArrays] = eachArr.toArray();
        return result;
    }

    @Override
    public Object[] slasher(Object[] numbers, int counter) {
        List<Object> resultList = new ArrayList<Object>();
        if (numbers.length < counter) {
            return new Object[0];
        }
        for (int i = counter; i < numbers.length; i++) {
            resultList.add(numbers[i]);
        }
        return resultList.toArray();
    }

    @Override
    public Object[] bouncer(Object[] objects) {
        List<Object> result = new ArrayList<>();
        Object[] falsy = {false, 0, null, ""};
        for (int i = 0; i < objects.length; i++) {
            if (!Arrays.asList(falsy).contains(objects[i])) {
                result.add(objects[i]);
            }
        }
        return result.toArray();
    }

    @Override
    public Object[] destroyer(Object[] objects, Object... remove) {
        List<Object> resultList = new ArrayList<>();
        for (int i = 0; i < objects.length; i++) {
            if (!Arrays.asList(remove).contains(objects[i])) {
                resultList.add(objects[i]);
            }
        }
        return resultList.toArray();
    }

    @Override
    public int getIndexToIns(Object[] numbers, float number) {
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            int eachObj = ((Integer) numbers[i]).intValue();
            if (number > eachObj) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String rot13(String word) {
        String result = "";
        char[] charArr = word.toLowerCase().toCharArray();
        List<Character> alphabet = new ArrayList<>();
        for (char character = 'a'; character <= 'z'; character++) {
            alphabet.add(character);
        }
        for (int i = 0; i <charArr.length; i++) {
            if (Character.isLetter(charArr[i])) {
                int ceasarsI = alphabet.indexOf(charArr[i]) + 13;
                if (ceasarsI >= alphabet.size()) {
                    result += alphabet.get(ceasarsI - alphabet.size());
                } else {
                    result += alphabet.get(ceasarsI);
                }
            } else {
                result += charArr[i];
            }
        }
        return result.toUpperCase();
    }

    @Override
    public boolean endsWith(String str, String ending) {
        if (str.length() == 0 || ending.length() == 0 || str.length() == 0) return false;
        if (str.substring(str.length() - ending.length()).equals(ending)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0 || 5 * bigCount + smallCount < goal) return false;
        return goal % 5 <= smallCount ? true : false;
    }

    @Override
    public String printSquareStar(int number) {
        String result = "";
        if (number > 10) {
            result += "Invalid Value";
        } else {
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (i == 0 || j == 0 || i == number-1 || j == number-1 || i == j || i + j == number - 1) {
                        result += "*";
                    } else {
                        result += " ";
                    }
                }
                result += "\n";
            }
        }
        return result.trim();
    }

    @Override
    public int[] sort(int[] numArray) {
        int temp;
        for (int i = 0; i < numArray.length - 1; i++) {
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[i] > numArray[j]) {
                    temp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }
        for (int i = 0; i < numArray.length; i++) {
            System.out.println(numArray[i]);
        }
        return numArray;
    }

    @Override
    public void displayTraversal(File toTraversal) {
        for (File file : toTraversal.listFiles()) {
            if (file.getName().endsWith(".txt")) {
                System.out.println(file.getAbsolutePath());
            }
            if (file.isDirectory()) {
                displayTraversal(file);
            }
        }
    }

}