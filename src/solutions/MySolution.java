package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySolution implements Solution {
    @Override
    public String reverseString(String word) {
        char[] charArray = word.toCharArray();
        char temp = 0;
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
        for (int i = 0; i < charList.size(); i++) {
            int begin = 0;
            int end = charList.size()-1;
            while (end > begin) {
                if (charList.get(begin) != charList.get(end)) {
                    return false;
                }
                begin++;
                end--;
            }
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
        int addedItems = 0;
        int addedArrays = 0;
        while (addedItems < numberOfArrays) {
            for (int i = 0; i < numbers.length; i++) {
                if (eachArr.size() == counter) {
                    result[addedArrays] = eachArr.toArray();
                    eachArr = new ArrayList<>();
                    addedArrays++;
                }
                eachArr.add(numbers[i]);
                addedItems++;
            }
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
        return new Object[0];
    }

    @Override
    public Object[] destroyer(Object[] numbers, Object... remove) {
        List<Object> resultList = new ArrayList<>();
        List<Object> removeList = Arrays.asList(remove);
        for (int i = 0; i < numbers.length; i++) {
            if (removeList.contains(numbers[i])){
            } else {
                resultList.add(numbers[i]);
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
}