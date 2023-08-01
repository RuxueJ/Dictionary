import java.util.*;

public class DictionaryLoad {
    private final TreeMap<String, TreeMap<String, List<String>>> dictionary ;
    private int keyNumber = 0;
    private int definitionNumber = 0;


    public DictionaryLoad() {
        this.keyNumber = WordEntry.values().length;

        dictionary = new TreeMap<>();
        for (WordEntry word : WordEntry.values()) {
            String keyword = word.getKeyword();
            Definition[] definitions = word.getDefinitions();
            definitionNumber += definitions.length;

            TreeMap<String, List<String>> innerDictionary = new TreeMap<>();

            for (Definition def : definitions) {

                String speech = def.getPartOfSpeech().name();
                if (innerDictionary.containsKey(speech)) {
                    innerDictionary.get(speech).add(def.getDefinitionText());
                } else {
                    List<String> definitionText = new ArrayList<>();
                    definitionText.add(def.getDefinitionText());
                    innerDictionary.put(speech, definitionText);
                }
            }
            for (Map.Entry<String, List<String>> entry : innerDictionary.entrySet()) {
                Collections.sort(entry.getValue());
            }
            dictionary.put(keyword.toLowerCase(), innerDictionary);
        }




    }

    public  TreeMap<String, TreeMap<String, List<String>>> getDictionary() {
        return dictionary;
    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public int getDefinitionNumber() {
        return definitionNumber;
    }
}










