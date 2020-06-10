package Validator;

public class Validator {
    public static boolean areArguments(String[] args) {
        return args.length >= 2;
    }

    public static boolean areThreeArguments(String[] args) {
        return args.length >= 3;
    }


}
