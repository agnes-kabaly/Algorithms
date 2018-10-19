package solutions;

import java.io.File;

public interface Solution {
    String reverseString(String word);
    long factorialize(int number);
    boolean palindrome(String word);
    int findLongestWord(String word);
    String titleCase(String word);
    int[] largestOfFour(int[][] numbers);
    boolean confirmEnding(String word,String end);
    String repeatStringNumTimes(String word,int counter);
    String truncateString(String word,int counter);
    Object[][] chunkArrayInGroups(Object[] numbers,int counter);
    Object[] slasher(Object[] numbers,int counter);
    Object[] bouncer(Object[] objects);
    Object[] destroyer(Object[] objects,Object... remove);
    int getIndexToIns(Object[] numbers,float number);
    String rot13(String word);
    boolean endsWith(String str, String ending);
    boolean canPack(int bigCount, int smallCount, int goal);
    String printSquareStar(int number);
    int[] sort(int[] toSort);
    void displayTraversal(File toTraversal);
    int getFibonacciByIndex(int n);
}