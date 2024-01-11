import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App_SortedMultiMap {
    public static void main(String[] args) throws FileNotFoundException {
        SortedMultiMap<String, Thesaurus> thesaurusMultiMap = new SortedMultiMap();
        final String fname = "thesaurus_dict.txt";
        Scanner fin = new Scanner(new File(fname));
        if (!fin.hasNext()) {
            System.out.printf("Error in reading from fin (%s) ...\n", fname);
            return; }
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
            thesaurusMultiMap.put(keyword, thesaurus);
        }
        fin.close();
        Set<String> keys = thesaurusMultiMap.keySet();
        System.out.printf("keys = %s\n", keys);
        Iterator<String> it = keys.iterator();
        Collection<Thesaurus> arrayList_thesaurus;
        while (it.hasNext()) {
            String keyWord = it.next();
            arrayList_thesaurus = thesaurusMultiMap.get(keyWord);
            System.out.printf("key (%s) :\n", keyWord);
            for (Thesaurus ths : arrayList_thesaurus)
                System.out.printf(" %s\n", ths);
        }
    }
}
