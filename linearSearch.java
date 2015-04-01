import java.util.ArrayList;
import java.util.Random;

/**
 * Created by fattyduck on 3/30/15.
 */
public class linearSearch {
    public static int LinearSearch(ArrayList<Integer> list, int x){
        int y=0;
        for(int i =0; i<list.size(); i++){
            if(list.get(i)==x){
                y=i;
            }

        }
        if(!list.contains(x)){
            y=-1;
        }

        return y;
    }
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i= 0; i<=30; i+=2){
            list.add(i);
        }
        Random rand = new Random();
        int x = rand.nextInt(30);
        System.out.println(list);
        System.out.println("x= " + x);
        System.out.println(LinearSearch(list, x));
    }
}
