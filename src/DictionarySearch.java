import java.util.*;

public class DictionarySearch {

    private static final DictionaryLoad dictionaryLoad = new DictionaryLoad();
    private final static TreeMap<String, TreeMap<String, List<String>>> dictionary = dictionaryLoad.getDictionary();


    public static DefinitionOutput searchGo(String token1) {

        token1 = token1.toLowerCase();

        DefinitionOutput definitionOutput = new DefinitionOutput();
        DictionaryLoad dictionaryLoad = new DictionaryLoad();
        TreeMap<String, TreeMap<String, List<String>>> dictionary = dictionaryLoad.getDictionary();

        if (CheckFirstToken(token1)) {

            definitionOutput.setKeyword(token1);

            definitionOutput.setDefinitions(dictionary.get(token1));


        }

        return definitionOutput;
    }

    public static DefinitionOutput searchGo(String token1, String token2) { // token2: reverse distinct partofSpeech notSpeech
        DefinitionOutput definitionOutput = searchGo(token1);

        token2 = token2.toLowerCase();
        switch (token2) {
            case "reverse":
                Reverse(definitionOutput);
                break;
            case "distinct":
                Distinct(definitionOutput);
                break;
            default:
                try {
                    PartOfSpeech value = PartOfSpeech.valueOf(token2);
                    TreeMap<String, List<String>> definitions = definitionOutput.getDefinitions();

                    Iterator<Map.Entry<String, List<String>>> iterator = definitions.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, List<String>> entry = iterator.next();
                        if (!entry.getKey().equals(token2)) {
                            iterator.remove(); // Remove entries that don't match the desired key
                        }
                    }

                } catch (IllegalArgumentException e) {  // token2 is not reverse, nor distinct, nor Speech
                    System.out.println("\t|\n\t <The entered 2nd parameter " + "\'" + token2 + "\'" + "is NOT a part of speech.>\n" +
                            "\t <The entered 2nd parameter 'ok' is NOT 'distinct'.>\n" +
                            "\t <The entered 2nd parameter 'ok' is NOT 'reverse'.>\n" +
                            "\t <The entered 2nd parameter 'ok' was disregarded.>\n" +
                            "\t <The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>\n\t|");
                }
        }


        return definitionOutput;

    }

    public static DefinitionOutput searchGo(String token1, String token2, String token3) {
        DefinitionOutput definitionOutput = searchGo(token1, token2);
        token3 = token3.toLowerCase();

        if (CheckThirdToken(token3)) {
            if (token3.equalsIgnoreCase("reverse")) {
                Reverse(definitionOutput);
            } else if (token3.equalsIgnoreCase("distinct")) {
                Distinct(definitionOutput);
            }
        }


        return definitionOutput;

    }

    public static DefinitionOutput searchGo(String token1, String token2, String token3, String token4) {

        DefinitionOutput definitionOutput = searchGo(token1, token2, token3);

        token4 = token4.toLowerCase();
        if (CheckFourthToken(token4)) {
            if (token4.equalsIgnoreCase("reverse")) {
                Reverse(definitionOutput);
            }
        }

        return definitionOutput;

    }

    public static boolean CheckFirstToken(String firstToken) {
        boolean firstTokenFlag = false;
        if (!dictionary.containsKey(firstToken.toLowerCase())) {
            System.out.println(DictionaryRun.NOT_FOUNT_INFO);
            System.out.println(DictionaryRun.HELP_INFO);
        } else {
            firstTokenFlag = true;
        }
        return firstTokenFlag;
    }


    public static boolean CheckSecondToken(String firstToken, String secondToken) {
        boolean secondTokenFlag;

        try {
            PartOfSpeech value = PartOfSpeech.valueOf(secondToken);
            DefinitionOutput definitionOutput = DictionarySearch.searchGo(firstToken);
            // is speech, but not found in the definition
            if ((!definitionOutput.getDefinitions().containsKey(secondToken))) {
                secondTokenFlag = false;
                // is speech, found in the definition
            } else {
                secondTokenFlag = true;
            }


        } catch (IllegalArgumentException e) {

            // reverse
            if (secondToken.equalsIgnoreCase("reverse")) {

                secondTokenFlag = true;

                // distinct
            } else if (secondToken.equalsIgnoreCase("distinct")) {

                secondTokenFlag = true;

                //ok
            } else {
                secondTokenFlag = true;
//                System.out.println("\t|\n\t <The entered 2nd parameter " + "\'" + secondToken + "\'" + "is NOT a part of speech.>\n" +
//                        "\t <The entered 2nd parameter 'ok' is NOT 'distinct'.>\n" +
//                        "\t <The entered 2nd parameter 'ok' is NOT 'reverse'.>\n" +
//                        "\t <The entered 2nd parameter 'ok' was disregarded.>\n" +
//                        "\t <The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>\n\t|");
            }
        }
        return secondTokenFlag;

    }

    public static boolean CheckThirdToken(String thirdToken) {
        boolean thirdTokenFlag;

        if (thirdToken.equalsIgnoreCase("reverse")) {
            thirdTokenFlag = true;
        } else if (thirdToken.equalsIgnoreCase("distinct")) {
            thirdTokenFlag = true;
        } else {
            thirdTokenFlag = false;
            System.out.println("\t|\n\t <The entered 3rd parameter " + "\'" + thirdToken + "\'" + " is NOT a part of speech.>\n" +
                    "\t <The entered 3rd parameter " + "\'" + thirdToken + "\'" + " is NOT 'reverse'.>\n" +
                    "\t <The entered 3rd parameter " + "\'" + thirdToken + "\'" + " was disregarded.>\n" +
                    "\t <The 3rd parameter should be 'distinct' or 'reverse'.>\n\t|");
        }
        return thirdTokenFlag;

    }

    public static boolean CheckFourthToken(String fourthToken) {
        boolean fourthTokenFlag;

        if (fourthToken.equalsIgnoreCase("reverse")) {
            fourthTokenFlag = true;
        } else {
            fourthTokenFlag = false;
            System.out.println("\t|\n\t <The entered 4th parameter " + "\'" + fourthToken + "\'" + " is NOT 'reverse'.>\n" +
                    "\t <The entered 4th parameter " + "\'" + fourthToken + "\'" + " was disregarded.>\n" +
                    "\t <The 4th parameter should be 'reverse'.>\n\t|");
        }
        return fourthTokenFlag;

    }


    public static void PrintDefinition(DefinitionOutput definitionOutput) {
        String keyword = definitionOutput.getKeyword();
        keyword = keyword.substring(0, 1).toUpperCase() + keyword.substring(1).toLowerCase();
        Map<String, List<String>> definitions = definitionOutput.getDefinitions();
        System.out.println("\t|");

        for (Map.Entry<String, List<String>> entry : definitions.entrySet()) {
            String speech = entry.getKey();
            List<String> definition = entry.getValue();

            for (String definitionEach : definition) {
                System.out.println("\t " + keyword + " " + "[" + speech + "]" + " : " + definitionEach);
            }

        }
        System.out.println("\t|");


    }

    public static void Reverse(DefinitionOutput definitionOutput) {

        TreeMap<String, List<String>> definitions = definitionOutput.getDefinitions();

        definitions = new TreeMap<>(definitions.descendingMap());
        definitionOutput.setDefinitions(definitions);

        for (Map.Entry<String, List<String>> entry : definitions.entrySet()) {

            List<String> definition = entry.getValue();

            Collections.reverse(definition);

        }

    }

    public static void Distinct(DefinitionOutput definitionOutput) {

        Map<String, List<String>> definitions = definitionOutput.getDefinitions();

        for (Map.Entry<String, List<String>> entry : definitions.entrySet()) {
            String speech = entry.getKey();
            List<String> definition = entry.getValue();

            Set<String> set = new TreeSet<>(definition);
            definition = new ArrayList<>(set);

            definitions.put(speech, definition);
        }

    }


}
