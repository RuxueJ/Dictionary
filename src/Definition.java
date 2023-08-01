public class Definition {
    private final PartOfSpeech partOfSpeech;
    private final String definitionText;

    public Definition(PartOfSpeech partOfSpeech, String definitionText){
        this.partOfSpeech = partOfSpeech;
        this.definitionText = definitionText;
    }

    public PartOfSpeech getPartOfSpeech() {
        return partOfSpeech;
    }

    public String getDefinitionText() {
        return definitionText;
    }
    public String toString(){
        return "[" + partOfSpeech.name() + "]" + " : " + definitionText;
    }

}
