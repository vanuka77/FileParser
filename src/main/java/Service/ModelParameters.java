package Service;

import Model.Model;
import Util.Input;
import Validator.Validator;

import java.util.InputMismatchException;

public class ModelParameters {

    public boolean setWithNoParametrs(Model model, String choice) {

        model.setFileName(Input.inputString());
        if (choice.equals("1")) {
            model.setCountString(Input.inputString());
            return true;
        }
        if (choice.equals("2")) {
            model.setFindString(Input.inputString());
            model.setReplaceString(Input.inputString());
            return true;
        }
        return false;
    }

    public boolean setWithParametrs(Model model, String[] args) throws NumberFormatException {//установить значения полей треугольника когда передаються аргументы в программу
        model.setFileName(args[0]);
        if (Validator.areThreeArguments(args)) {
            model.setFindString(args[1]);
            model.setReplaceString(args[2]);
        } else {
            model.setCountString(args[1]);
        }
        return true;
    }
}
