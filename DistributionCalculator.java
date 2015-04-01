import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fattyduck on 3/31/15.
 */
class DistributionCalculator {

    public static int countChar(char c, String str) {
        //made a counter method to count number of ints

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==(c)) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Double> calculate(String textfile) {
        ArrayList<Double> calculate= new ArrayList<Double>();
        ArrayList<Character> c= new ArrayList<Character>();
        ArrayList<Integer> count = new ArrayList<Integer>();
        try{

            String file1 = new Scanner(new File(textfile)).useDelimiter("\\Z").next();
            String file= file1.toLowerCase();
            //convert file into lowercase string
            for (char i='a'; i<'z'+1;i++){
                //create an arraylist for characters
                c.add(i);
            }

           for (char i='a'; i<'z'+1;i++){
               count.add(countChar(i, file));
               //count every character
            }
            int total=0;
            for(int i=0;i<26; i++){
                total+=count.get(i);
                //get total of characters in string
            }
            Double dTotal=(double)total;
            for(int i=0; i<26; i++){
                calculate.add((count.get(i)/dTotal)*100);
                //part divided by total then times 100 to get percentage
            }

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return calculate;
    }
    public static void main(String[] args){
        char c='A';
        for(int i=0;i<26;i++){
            System.out.print(c+": ");
            System.out.printf("%.2f", calculate("/home/fattyduck/IdeaProjects/HW20150320/src/StellarTrans").get(i));
            //limit decimals to to 2 units (0.00)
            System.out.println("%");
            c++;
        }
    }
}
