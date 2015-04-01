/**
 * Created by fattyduck on 4/1/15.
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class WebPageSanitizer {

    public static String webSanitize(String HTML){
        String base=HTML.toLowerCase();
        //created instance to make HTML file lowercase
        String[] array=base.split("</script>");
        //split string into array by </script> so that if certain strings will have to contain beginning of <script
        //split string into array
        ArrayList<String> sanitize= new ArrayList<String>();

        for(int i=0; i<array.length;i++){
            sanitize.add(array[i]);
        }

        //made array into arraylist because I want to use contains
        String sanitized="";

        for (int i=0;i<sanitize.size(); i++){
            if(sanitize.get(i).contains("<script")){
                sanitized+=sanitize.get(i).substring(0, sanitize.get(i).indexOf("<scr"));
            }else{
                sanitized+=sanitize.get(i);
            }
            //if string from arraylist contains <scr then create a substring instead and add to sanitized else jsut add string.
        }


        return sanitized;
    }
    public static void main(String[] args){
        //I using code that Alex provided us with to import html source as String
        Scanner scan = new Scanner(System.in);
        System.out.println("URL: ");
        String input = scan.nextLine();
        URL url= HTTP.stringToURL(input);
        String HTML= HTTP.get(url);
        //System.out.println(HTML); this print was to make sure The string HTML works and used to compare with the webSanitize
        System.out.println(webSanitize(HTML));


    }
}
