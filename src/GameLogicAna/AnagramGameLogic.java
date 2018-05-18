package GameLogicAna;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Natalia
 */
public class AnagramGameLogic {

    //Write a program to check if two words are anagrams
    public static void main(String[] args) {
        AnagramGameLogic an=new AnagramGameLogic();
        ArrayList<String> l=new ArrayList<String>();
       
           
            for(int i=0;i<Integer.parseUnsignedInt("2");i++)
            {
//this here needs to be made into a console input dialog via Scanner, then rewired into GUI input
                String word=JOptionPane.showInputDialog("Enter word #"+i);
                l.add(word);   
            }
            System.out.println(an.isanagrams(l));
        }
        

    

    private static String sortString( String w )
    {
        char[] ch = w.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public boolean isanagrams(ArrayList<String> l)
    {
        boolean isanagrams=true; 
        ArrayList<String> anagrams = null;
        HashMap<String, ArrayList<String>> map =  new HashMap<String, ArrayList<String>>();
        for(int i=0;i<l.size();i++)
            {
        String word = l.get(i);
        String sortedWord = sortString(word);
            anagrams = map.get( sortedWord );
        if( anagrams == null ) anagrams = new ArrayList<String>();
        anagrams.add(word);
        map.put(sortedWord, anagrams);
            }

            for(int h=0;h<l.size();h++)
            {
                if(!anagrams.contains(l.get(h)))
                {
                    isanagrams=false;
                    break;
                }
            }

            return isanagrams;
        //}
        }

}