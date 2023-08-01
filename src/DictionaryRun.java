import java.util.*;

public class DictionaryRun {
    public static final String HELP_INFO = "\t|\n " +
            "\t PARAMETER HOW-TO, please enter:\n" +
            "\t 1. A search key -then 2. An optional part of speech -then\n" +
            "\t 3. An optional 'distinct' -then 4. An optional 'reverse'\n\t|";

    public static final String NOT_FOUNT_INFO = "\t|\n \t<NOT FOUND> To be considered for the next release. Thank you.\n\t|";

    public static void menu() {
        System.out.println("! Loading data...");
        DictionaryLoad dictionaryLoad = new DictionaryLoad();

        System.out.println("! Loading completed..." + "\n");


        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords:" + dictionaryLoad.getKeyNumber());
        System.out.println("----- Definitions:" + dictionaryLoad.getDefinitionNumber() + "\n");
    }

//    public static void run(){
//        int count = 1;
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.print("Search [" + count + "]:");
//
//            String userInput = scanner.nextLine();
//            userInput = userInput.trim().toLowerCase();
//            String[] tokens = userInput.split("\\s+");
//
//            if (userInput.isEmpty()) {
//                System.out.println(HELP_INFO);
//                count++;
//            } else {
//                String firstToken = tokens[0];
//
//                if (firstToken.equalsIgnoreCase("!help")) {
//                    System.out.println(HELP_INFO);
//                    count++;
//
//                } else if (firstToken.equalsIgnoreCase("!q")) {
//
//                    System.out.println("-----THANK YOU-----");
//                    break;
//
//                    // the first token keyword is already in the dictionary
//                } else if(DictionarySearch.CheckFirstToken(tokens[0])){
//                    DefinitionOutput definitionOutput;
//
//                    if (tokens.length == 1) {
//                        definitionOutput = DictionarySearch.searchGo(tokens[0]);
//                    } else if (tokens.length == 2 ) {
//
//                        // if is speech, but not found in the definition
//                        if( !DictionarySearch.CheckSecondToken(tokens[0],tokens[1])){
//                            System.out.println(NOT_FOUNT_INFO);
//                            System.out.println(HELP_INFO);
//                            count++;
//                            continue;
//                        }
//                        // token[1] can be reverse, distinct, not speech, partOfSpeech
//                        definitionOutput = DictionarySearch.searchGo(tokens[0], tokens[1]);
//                    } else if (tokens.length == 3) {
//                        definitionOutput = DictionarySearch.searchGo(tokens[0], tokens[1], tokens[2]);
//                    } else if(tokens.length == 4){
//                        definitionOutput = DictionarySearch.searchGo(tokens[0], tokens[1], tokens[2], tokens[3]);
//                    }else {
//                        System.out.println(DictionaryRun.HELP_INFO);
//                        count++;
//                        continue;
//                    }
//
//                    DictionarySearch.PrintDefinition(definitionOutput);
//
//                    count++;
//                }
//
//            }
//
//
//        }
//    }

    public static void run() {
        int count = 1;

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        DefinitionOutput definitionOutput;
        while (flag) {
            System.out.print("Search [" + count + "]:");

            String userInput = scanner.nextLine();
            if (userInput.isEmpty()) {
                System.out.println(DictionaryRun.HELP_INFO);

            } else {
                userInput = userInput.trim().toLowerCase();
                String[] tokens = userInput.split("\\s+");

                int length = tokens.length;
                switch (length) {
                    case 1 -> {
                        String firstToken = tokens[0].toLowerCase();
                        switch (firstToken) {
                            case "!help":
                                System.out.println(DictionaryRun.HELP_INFO);
                                break;
                            case "!q":
                                flag = false;
                                System.out.println("-----THANK YOU-----");
                                break;
                            default:
                                if (DictionarySearch.CheckFirstToken(tokens[0])) {
                                    definitionOutput = DictionarySearch.searchGo(tokens[0]);
                                    DictionarySearch.PrintDefinition(definitionOutput);
                                }

                        }
                    }
                    case 2 -> {
                        if (!DictionarySearch.CheckSecondToken(tokens[0], tokens[1])) {
                            System.out.println(NOT_FOUNT_INFO);
                            System.out.println(HELP_INFO);
                            count++;
                            break;
                        }
                        String firstToken = tokens[0].toLowerCase();
                        String secondToken = tokens[1].toLowerCase();
                        definitionOutput = DictionarySearch.searchGo(firstToken, secondToken);
                        DictionarySearch.PrintDefinition(definitionOutput);
                    }
                    case 3 -> {
                        definitionOutput = DictionarySearch.searchGo(tokens[0], tokens[1], tokens[2]);
                        DictionarySearch.PrintDefinition(definitionOutput);
                    }
                    case 4 -> {
                        definitionOutput = DictionarySearch.searchGo(tokens[0], tokens[1], tokens[2], tokens[3]);
                        DictionarySearch.PrintDefinition(definitionOutput);
                    }
                    default -> System.out.println(DictionaryRun.HELP_INFO);
                }


            }
            count++;


        }

    }

    public static void main(String[] args) {
        menu();
        run();
    }
}
