import java.io.File;
import java.io.IOException;
import java.util.*;

public class App_HashMap_ThesaurusDict {
    public static void main(String[] args) throws IOException {
        HashMap<Word_Type, Thesaurus> thesaurusDict = new HashMap<Word_Type, Thesaurus>();
        final String fname = "sample_thesaurus_dict.txt";
        Scanner fin = new Scanner(new File(fname));
        String keyword, word, type;
        while(fin.hasNext()) {
            String str_line = fin.nextLine();
            System.out.printf("ThesaurusDict:: processing %s\n", str_line);
            StringTokenizer strTokenizer = new StringTokenizer(str_line," ");
            Thesaurus thesaurus = new Thesaurus();
            keyword = strTokenizer.nextToken();
            thesaurus.setKeyWord(keyword);
            type = strTokenizer.nextToken();
            thesaurus.setType(type);
            while(strTokenizer.hasMoreTokens()) {
                word = strTokenizer.nextToken();
                thesaurus.addThesaurus(word);
            }
            thesaurusDict.put(new Word_Type(keyword, type), thesaurus);
        }
        fin.close();
        Set<Word_Type> keys = thesaurusDict.keySet();
        System.out.printf("keys = %s\n", keys);
        Iterator<Word_Type> it = keys.iterator();
        while (it.hasNext()) {
            Word_Type keyWordType = it.next();
            Thesaurus value = thesaurusDict.get(keyWordType);
            System.out.println("key (" + keyWordType + ") : " + value + ")");
        }
    }

}
