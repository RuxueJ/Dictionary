import java.util.Arrays;
import java.util.List;

public enum WordEntry {
    ARROW("Arrow",
            new Definition(PartOfSpeech.noun," Here is one arrow: <IMG> -=>> </IMG>")

    ),

    BOOK("Book",
           new Definition(PartOfSpeech.noun,"A set of pages."),
           new Definition(PartOfSpeech.noun,"A written work published in printed or electronic form."),
           new Definition(PartOfSpeech.verb,"To arrange for someone to have a seat on a plane."),
           new Definition(PartOfSpeech.verb,"To arrange something on a particular date.")),
    DISTINCT("Distinct",
            new Definition(PartOfSpeech.adjective,"Familiar. Worked in Java."),
            new Definition(PartOfSpeech.adjective,"Unique. No duplicates. Clearly different or of a different kind."),
            new Definition(PartOfSpeech.adverb,"Uniquely. Written \"distinctly\"."),
            new Definition(PartOfSpeech.noun,"A keyword in this assignment."),
            new Definition(PartOfSpeech.noun,"A keyword in this assignment."),
            new Definition(PartOfSpeech.noun,"A keyword in this assignment."),
            new Definition(PartOfSpeech.noun,"An advanced search option."),
            new Definition(PartOfSpeech.noun,"Distinct is a parameter in this assignment.")),
    PLACEHOLDER("Placeholder",
            new Definition(PartOfSpeech.adjective,"To be updated..."),
            new Definition(PartOfSpeech.adjective,"To be updated..."),
            new Definition(PartOfSpeech.noun,"To be updated..."),
            new Definition(PartOfSpeech.adverb,"To be updated..."),
            new Definition(PartOfSpeech.conjunction,"To be updated..."),
            new Definition(PartOfSpeech.interjection,"To be updated..."),
            new Definition(PartOfSpeech.noun,"To be updated..."),
            new Definition(PartOfSpeech.noun,"To be updated..."),
            new Definition(PartOfSpeech.preposition,"To be updated..."),
            new Definition(PartOfSpeech.pronoun,"To be updated..."),
            new Definition(PartOfSpeech.verb,"To be updated...")),

    REVERSE("Reverse",
            new Definition(PartOfSpeech.adjective,"On back side"),
            new Definition(PartOfSpeech.adjective,"Opposite to usual or previous arrangement."),
            new Definition(PartOfSpeech.noun,"A dictionary program's parameter."),
            new Definition(PartOfSpeech.noun,"Change to opposite direction."),
            new Definition(PartOfSpeech.noun,"The opposite."),
            new Definition(PartOfSpeech.noun,"To be updated..."),
            new Definition(PartOfSpeech.noun,"To be updated..."),
            new Definition(PartOfSpeech.noun,"To be updated..."),
            new Definition(PartOfSpeech.noun,"To be updated..."),
            new Definition(PartOfSpeech.verb,"Change something to opposite."),
            new Definition(PartOfSpeech.verb,"Go back"),
            new Definition(PartOfSpeech.verb,"Revoke ruling."),
            new Definition(PartOfSpeech.verb,"To be updated..."),
            new Definition(PartOfSpeech.verb,"To be updated..."),
            new Definition(PartOfSpeech.verb,"Turn something inside out.")
            )


    ;
    private final String keyword;

    private final Definition[] definitions;

    WordEntry(String keyword, Definition... definitions){
        this.keyword = keyword;

        this.definitions = definitions;
    }

    public String getKeyword(){
        return keyword;
    }

    public Definition[] getDefinitions(){
        return definitions;
    }





}
