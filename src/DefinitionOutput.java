import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DefinitionOutput {
    private String keyword;
    private TreeMap<String, List<String>> definitions;

    public DefinitionOutput(){
        this(" ",null);
    }
    public DefinitionOutput(String keyword, TreeMap<String, List<String>> definitions){
        this.keyword = keyword;
        this.definitions = definitions;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public TreeMap<String, List<String>> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(TreeMap<String, List<String>> definitions) {
        this.definitions = definitions;
    }
}
