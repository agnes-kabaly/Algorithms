package test;

import org.junit.Test;
import solutions.MySolution;
import solutions.Solution;

import java.io.File;

import static org.junit.Assert.*;

    public class SolutionTest {

        private Solution solution = new MySolution();

        @Test
        public void testTitleCase() throws Exception {
            assertEquals("I'm A Little Tea Pot",solution.titleCase("I'm a little tea pot"));
            assertEquals("Short And Stout",solution.titleCase("sHoRt AnD sToUt"));
            assertEquals("Here Is My Handle Here Is My Spout",solution.titleCase("HERE IS MY HANDLE HERE IS MY SPOUT"));
        }

        @Test
        public void testFindLongestWord() throws Exception {
            assertEquals(6,solution.findLongestWord("The quick brown fox jumped over the lazy dog"));
            assertEquals(5,solution.findLongestWord("May the force be with you"));
            assertEquals(6,solution.findLongestWord("Google do a barrel roll"));
            assertEquals(8,solution.findLongestWord("What is the average airspeed velocity of an unladen swallow"));
            assertEquals(19,solution.findLongestWord("What if we try a super-long word such as otorhinolaryngology"));
        }

        @Test
        public void testPalindrome() throws Exception {
            assertTrue(solution.palindrome("eye"));
            assertTrue(solution.palindrome("_eye"));
            assertTrue(solution.palindrome("race car"));
            assertFalse(solution.palindrome("not a palindrome"));
            assertTrue(solution.palindrome("A man, a plan, a canal. Panama"));
            assertTrue(solution.palindrome("never odd or even"));
            assertFalse(solution.palindrome("nope"));
            assertFalse(solution.palindrome("almostomla"));
            assertTrue(solution.palindrome("My age is 0, 0 si ega ym."));
            assertFalse(solution.palindrome("1 eye for of 1 eye."));
            assertTrue(solution.palindrome("0_0 (: /-\\ :) 0-0"));
            assertFalse(solution.palindrome("five|\\_/|four"));
        }

        @Test
        public void testFactorialize() throws Exception {
            assertEquals(120,solution.factorialize(5));
            assertEquals(3628800,solution.factorialize(10));
            assertEquals("2432902008176640000",String.valueOf(solution.factorialize(20)));
            assertEquals(1,solution.factorialize(0));
        }

        @Test
        public void testReverseString(){
            assertEquals("olleh", solution.reverseString("hello"));
            assertEquals("ydwoH", solution.reverseString("Howdy"));
            assertEquals("htraE morf sgniteerG", solution.reverseString("Greetings from Earth"));
        }

        @Test
        public void testlargestOfFour()throws Exception{
            assertArrayEquals(new int []{27,5,39,1001},solution.largestOfFour(new int[][]{
                    {13,27,18,26},
                    {4,5,1,3},
                    {32,35,37,39},
                    {1000,1001,857,1}
            }));
            assertArrayEquals(new int []{9,35,97,1000000},solution.largestOfFour(new int[][]{
                    {4,9,1,3},
                    {13,35,18,26},
                    {32,35,97,39},
                    {1000000,1001,857,1}
            }));
        }

        @Test
        public void confirmEnding() throws Exception {
            assertEquals(true,solution.confirmEnding("Bastian","n"));
            assertEquals(true,solution.confirmEnding("Open sesame","same"));
            assertEquals(true,solution.confirmEnding("He has to give me a new name", "name"));
            assertEquals(false,solution.confirmEnding("Connor","n"));
            assertEquals(false,solution.confirmEnding("If you want to save our world, you must hurry. We dont know how much longer we can withstand the nothing", "mountain"));
            assertEquals(false,solution.confirmEnding("Open sesame","pen"));
            assertEquals(false,solution.confirmEnding("Walking on water and developing software from a specification are easy if both are frozen","specification"));
        }

        @Test
        public void repeatStringNumTimes() throws Exception {
            assertEquals("***",solution.repeatStringNumTimes("*",3));
            assertEquals("********",solution.repeatStringNumTimes("*",8));
            assertEquals("abcabcabc",solution.repeatStringNumTimes("abc",3));
            assertEquals("abcabcabcabc",solution.repeatStringNumTimes("abc",4));
            assertEquals("abc",solution.repeatStringNumTimes("abc",1));
            assertEquals("",solution.repeatStringNumTimes("abc",-2));
        }

        @Test
        public void truncateString() throws Exception {
            assertEquals("A-tisket...",solution.truncateString("A-tisket a-tasket A green and yellow basket", 11));
            assertEquals("Peter Piper...",solution.truncateString("Peter Piper picked a peck of pickled peppers", 14));
            assertEquals("A-tisket a-tasket A green and yellow basket",solution.truncateString("A-tisket a-tasket A green and yellow basket", "A-tisketa a-tasket A green and yellow basket".length()));
            assertEquals("A-tisket a-tasket A green and yellow basket",solution.truncateString("A-tisket a-tasket A green and yellow basket", "A-tisketa a-tasket A green and yellow basket".length()+2));
            assertEquals("A...",solution.truncateString("A-",1));
            assertEquals("Ab...",solution.truncateString("Absolutely Longer",2));
        }

        @org.junit.Test
        public void chunkArrayInGroups() throws Exception {
            assertArrayEquals(new int[][]{
                    {0,1,2},
                    {3,4,5},
            },solution.chunkArrayInGroups(new Object[]{0,1,2,3,4,5},3));
            assertArrayEquals(new int[][]{
                    {0,1},
                    {2,3},
                    {4,5},
            },solution.chunkArrayInGroups(new Object[]{0,1,2,3,4,5},2));
            assertArrayEquals(new int[][]{
                    {0,1,2,3},
                    {4,5},
            },solution.chunkArrayInGroups(new Object[]{0,1,2,3,4,5},4));

            assertArrayEquals(new int[][]{
                    {0,1,2},
                    {3,4,5},
                    {6}
            },solution.chunkArrayInGroups(new Object[]{0,1,2,3,4,5,6},3));

            assertArrayEquals(new int[][]{
                    {0,1,2,3},
                    {4,5,6,7},
                    {8}
            },solution.chunkArrayInGroups(new Object[]{0,1,2,3,4,5,6,7,8},4));
            assertArrayEquals(new int[][]{
                    {0,1},
                    {2,3},
                    {4,5},
                    {6,7},
                    {8}
            },solution.chunkArrayInGroups(new Object[]{0,1,2,3,4,5,6,7,8},2));
        }

        @Test
        public void slasher() throws Exception {
            assertArrayEquals(new Object[]{3},solution.slasher(new Object[]{1,2,3},2));
            assertArrayEquals(new Object[]{1,2,3},solution.slasher(new Object[]{1,2,3},0));
            assertArrayEquals(new Object[]{},solution.slasher(new Object[]{1,2,3},9));
            assertArrayEquals(new Object[]{},solution.slasher(new Object[]{1,2,3},4));
            assertArrayEquals(new Object[]{"fries", "shake"},solution.slasher(new Object[]{"burgers", "fries", "shake"},1));
            assertArrayEquals(new Object[]{"cheese", 4},solution.slasher(new Object[]{1, 2, "chicken", 3, "potatoes", "cheese", 4},5));
        }

        @Test
        public void bouncer() throws Exception {
            assertArrayEquals(new Object[]{7, "ate", 9}, solution.bouncer(new Object[]{7, "ate", "", false, 9}));
            assertArrayEquals(new Object[]{"a", "b", "c"}, solution.bouncer(new Object[]{"a", "b", "c"}));
            assertArrayEquals(new Object[]{}, solution.bouncer(new Object[]{false, null, 0, ""}));
            assertArrayEquals(new Object[]{1, 2}, solution.bouncer(new Object[]{1, null, false, 2, null}));
        }

        @Test
        public void destroyer() throws Exception {
            assertArrayEquals(new Object[]{1,1},solution.destroyer(new Object[]{1,2,3,1,2,3},new Object[]{2,3}));
            assertArrayEquals(new Object[]{1,5,1},solution.destroyer(new Object[]{1,2,3,5,1,2,3},new Object[]{2,3}));
            assertArrayEquals(new Object[]{1},solution.destroyer(new Object[]{3,5,1,2,2},new Object[]{2,3,5}));
            assertArrayEquals(new Object[]{},solution.destroyer(new Object[]{2,3,2,3},new Object[]{2,3,}));
            assertArrayEquals(new Object[]{"hamburger"},solution.destroyer(new Object[]{"tree", "hamburger", 53},new Object[]{"tree", 53}));
        }

        @Test
        public void getIndexToIns() throws Exception {
            assertEquals(3,solution.getIndexToIns(new Object[]{10,20,30,40,50},35));
            assertEquals(2,solution.getIndexToIns(new Object[]{10,20,30,40,50},30));
            assertEquals(1,solution.getIndexToIns(new Object[]{40,60},50));
            assertEquals(0,solution.getIndexToIns(new Object[]{3,10,5},3));
            assertEquals(2,solution.getIndexToIns(new Object[]{5,3,20,3},5));
            assertEquals(2,solution.getIndexToIns(new Object[]{2,20,10},19));
            assertEquals(3,solution.getIndexToIns(new Object[]{2,5,10},15));
        }

        @Test
        public void rot13() throws Exception {
            assertEquals("FREE CODE CAMP",solution.rot13("SERR PBQR PNZC"));
            assertEquals("FREE PIZZA!",solution.rot13("SERR CVMMN!"));
            assertEquals("FREE LOVE?",solution.rot13("SERR YBIR?"));
            assertEquals("THE QUICK BROWN DOG JUMPED OVER THE LAZY FOX.",solution.rot13("GUR DHVPX OEBJA QBT WHZCRQ BIRE GUR YNML SBK."));
        }

        @Test
        public void endsWith() {
            assertTrue(solution.endsWith("abc", "bc"));
            assertFalse(solution.endsWith("abc", "d"));
        }

        @Test
        public void canPack() {
            assertFalse(solution.canPack(1, 0, 4));
            assertTrue(solution.canPack(1, 0, 5));
            assertTrue(solution.canPack(0, 5, 4));
            assertTrue(solution.canPack(2, 2, 12));
            assertFalse(solution.canPack(-3, 2, 12));
            assertTrue(solution.canPack(2, 1, 5));
            assertTrue(solution.canPack(4, 18, 19));
        }

        @Test
        public void printSquareStar() {
            assertEquals("" +
                    "*****\n" +
                    "** **\n" +
                    "* * *\n" +
                    "** **\n" +
                    "*****", solution.printSquareStar(5));
            assertEquals("" +
                    "********\n" +
                    "**    **\n" +
                    "* *  * *\n" +
                    "*  **  *\n" +
                    "*  **  *\n" +
                    "* *  * *\n" +
                    "**    **\n" +
                    "********", solution.printSquareStar(8));
        }

        @Test
        public void sort() {
            assertArrayEquals(new int[]{1, 1, 2, 21, 23, 34, 34, 678, 865, 1245}, solution.sort(new int[]{1, 23, 678, 34, 1245, 2, 1, 34, 21, 865}));
            assertArrayEquals(new int[]{-12, -6, 0, 1, 1, 21, 34, 34, 865, 1245}, solution.sort(new int[]{1, -6, 34, 1245, -12, 1, 34, 21, 0, 865}));
        }

        @Test
        public void displayTraversal() {
            //assertEquals("/home/kabaly/0VALAMI/01.xt, /home/kabaly/0VALAMI/02.txt, /home/kabaly/0VALAMI/03.txt",
            solution.displayTraversal(new File("/home/kabaly/0VALAMI"));
        }

        @Test
        public void getFibonacciByIndex() {
            assertEquals(2, solution.getFibonacciByIndex(3));
            assertEquals(5, solution.getFibonacciByIndex(5));
            assertEquals(55, solution.getFibonacciByIndex(10));
            assertEquals(1597, solution.getFibonacciByIndex(17));
        }

    }