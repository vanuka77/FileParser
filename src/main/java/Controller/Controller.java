package Controller;

import Model.Model;
import Service.*;
import Util.Input;
import Util.OutPut;
import Validator.Validator;

import java.io.File;
import java.io.IOException;

public class Controller {

    boolean isWorkedWithArguments = false;
    boolean areSetModelParameters = false;
    boolean fileIsOk = false;

    Model model = new Model();
    OutPut outPut = new OutPut();
    ModelParameters modelParameters = new ModelParameters();
    File file;
    FileRead fileRead = new FileRead();
    FileWrite fileWrite = new FileWrite();
    WorkWithFile workWithFile = new WorkWithFile();
    Storage storage = new Storage();

    public void run(String[] args) {
        String choice = "";
        String isContinued = "y";
        while (isContinued.equals("y") || isContinued == "yes") {
            if (Validator.areArguments(args) == false || isWorkedWithArguments == true) {
                while (!choice.equals("1") && !choice.equals("2")) {
                    outPut.printQuastion();
                    choice = Input.inputString();
                    if (!choice.equals("1") && !choice.equals("2")) {
                        outPut.printError();
                    }
                }
                outPut.printInstruction();
                areSetModelParameters = modelParameters.setWithNoParametrs(model, choice);
                try {
                    file = new File(model.getFileName());
                    fileRead.readFromFile(storage, file);
                    fileIsOk = true;
                } catch (IOException e) {
                    outPut.printFileError();
                    fileIsOk = false;
                }
                if (areSetModelParameters) {
                    if (fileIsOk == true) {
                        if (choice.equals("1")) {
                            outPut.printFound(workWithFile.countAmountOfStrings(storage, model));
                        } else if (choice.equals("2")) {
                            workWithFile.replaceString(storage, model);
                            try {
                                fileWrite.writeToFile(storage, file);
                                outPut.printSuccessChange();
                            } catch (IOException e) {
                                outPut.printFileError();
                            }
                        } else {
                            outPut.printError();
                        }

                    }
                }
            } else {
                try {
                    areSetModelParameters = modelParameters.setWithParametrs(model, args);
                } catch (NumberFormatException e) {
                    areSetModelParameters = false;
                    outPut.printError();
                }
                if (areSetModelParameters) {
                    try {
                        file = new File(model.getFileName());
                        fileRead.readFromFile(storage, file);
                        fileIsOk = true;
                    } catch (IOException e) {
                        fileIsOk = false;
//                        outPut.printFileError();
                    }
                    if (fileIsOk == true) {
                        if (Validator.areThreeArguments(args)) {
                            workWithFile.replaceString(storage, model);
                            try {
                                fileWrite.writeToFile(storage, file);
                                outPut.printSuccessChange();
                            } catch (IOException e) {
                                outPut.printFileError();
                            }
                        } else {
                            outPut.printFound(workWithFile.countAmountOfStrings(storage, model));
                        }
                    }
                }
            }
            isWorkedWithArguments = true;
            storage.getLines().clear();
            outPut.printContinueInstruction();
            isContinued = Input.inputString().toLowerCase();
            choice = "";
        }
    }
}

