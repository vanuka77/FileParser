package Util;

public class OutPut {

    public void printQuastion() {
        System.out.println("Выбирите , что сделать.\n" + "1 - посчитать количество вхождений строки\n" +
                "2 - найти строку и заменить на другую строку");
    }

    public void printInstruction() {
        System.out.println("Если вы выбрали 1:\n" +
                "Введите путь к файлу\n" + "Введите строку количество входов которой нужно узнать");
        System.out.println("Если вы выбрали 2:\n"+
                "Введите путь к файлу\n" + "Введите строку которую нужно найти\n" +
                "Введите строку на которую нужно заменить\n" + "После каждого ввода нажимайте enter");
    }

    public void printError() {
        System.err.println("Нарушены инструкции программы!");
    }


    public void printFileError() {
        System.err.println("Проблема с файловой роботой");
    }

    public void printSuccessChange() {
        System.out.println("Успешно заменено");
    }

    public void printFound(int count) {
        System.out.println("Количество входов строки в файле - " + count + " .");
    }

    public void printContinueInstruction() {
        System.out.println("Если хотите продолжить нажмите y/yes?");
    }
}

