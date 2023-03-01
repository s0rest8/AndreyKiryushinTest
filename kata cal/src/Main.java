import java.util.Scanner;
import java.io.IOException;

public class Main {
    static int sum;
    static String answer = "Пример введён некоректно";
    static int firstNumber;
    static String operator;
    static int secondNumber;

    static String firstNumberRim;

    static int ind1;

    static int ind2;
    static String secondNumberRim;



    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println(calc(answer));
        } catch (IllegalArgumentException zz) {
            System.out.println("Используются одновременно разные системы счисления");
        }
    }

    public static String calc(String input) {


        if (scanner.hasNextInt()) {
            firstNumber = scanner.nextInt();
            if (scanner.hasNext()) {
                operator = scanner.next();
                if (scanner.hasNextInt()) {
                    secondNumber = scanner.nextInt();
                    if (firstNumber >= 11 || secondNumber >= 11 || firstNumber <= 0 || secondNumber <= 0) {
                        try {
                            throw new IOException();
                        } catch (IOException e) {
                            answer = "Введите число от 1 до 10";
                        }
                    } else {
                        switch (operator) {
                            case "+":
                                sum = firstNumber + secondNumber;
                                answer = "Ваш ответ = " + sum;
                                break;
                            case "-":
                                sum = firstNumber - secondNumber;
                                answer = "Ваш ответ = " + sum;
                                break;
                            case "*":
                                sum = firstNumber * secondNumber;
                                answer = "Ваш ответ = " + sum;
                                break;
                            case "/":
                                sum = firstNumber / secondNumber;
                                answer = "Ваш ответ = " + sum;
                                break;
                        }
                    }
                }
            }
        } else if (scanner.hasNext()) {
            firstNumberRim = scanner.next();
            if (firstNumberRim.matches("[I,X,V]*")) {
                if (scanner.hasNext()) {
                    operator = scanner.next();
                }
                if (scanner.hasNext()) {
                    secondNumberRim = scanner.next();
                    if (firstNumberRim.matches("[I,X,V]*")) {
                        romanNumeral z1 = romanNumeral.valueOf(firstNumberRim);
                        romanNumeral z2 = romanNumeral.valueOf(secondNumberRim);

                        for (romanNumeral Value : romanNumeral.values()) {
                            if (z1 == Value) {
                                ind1 = Integer.parseInt(Value.getArabicNum());
                            }
                        }
                        for (romanNumeral Value : romanNumeral.values()) {
                            if (z2 == Value) {
                                ind2 = Integer.parseInt(Value.getArabicNum());
                                if (ind1 >= 11 || ind2 >= 11) {
                                    try {
                                        throw new IOException();
                                    } catch (IOException e) {
                                        answer = "Введите число от I до X";
                                    }
                                } else {
                                    switch (operator) {
                                        case "+":
                                            sum = ind1 + ind2;
                                            answer = "Ваш ответ = " + romanNumeral.values()[sum - 1];
                                            break;
                                        case "-":
                                            sum = ind1 - ind2;
                                            try {
                                                answer = "Ваш ответ = " + romanNumeral.values()[sum - 1];
                                            }
                                            catch (ArrayIndexOutOfBoundsException e) {
                                                answer = "В римской системе нет отрицательных чисел";
                                            }
                                            break;
                                        case "*":
                                            sum = ind1 * ind2;
                                            answer = "Ваш ответ = " + romanNumeral.values()[sum - 1];
                                            break;
                                        case "/":
                                            sum = ind1 / ind2;
                                            answer = "Ваш ответ = " + romanNumeral.values()[sum - 1];
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
        }

        return answer;
    }
    enum romanNumeral {
        I("1"), II("2"), III("3"), IV("4"), V("5"), VI("6"), VII("7"),
        VIII("8"), IX("9"), X("10"), XI("11"), XII("12"), XIII("13"), XIV("14"),
        XV("15"), XVI("16"), XVII("17"), XVIII("18"), XIX("19"), XX("20"),
        XXI("21"), XXII("22"), XXIII("23"), XXIV("24"), XXV("25"), XXVI("26"),
        XXVII("27"), XXVIII("28"), XXIX("29"), XXX("30"), XXXI("31"), XXXII("32"),
        XXXIII("33"), XXXIV("34"), XXXV("35"), XXXVI("36"), XXXVII("37"), XXXVIII("38"),
        XXXIX("39"), XL("40"), XLI("41"), XLII("42"), XLIII("43"), XLIV("44"),
        XLV("45"), XLVI("46"), XLVII("47"), XLVIII("48"), XLIX("49"), L("50"),
        LI("51"), LII("52"), LIII("53"), LIV("54"), LV("55"), LVI("56"), LVII("57"),
        LVIII("58"), LIX("59"), LX("60"), LXI("61"), LXII("62"), LXIII("63"),
        LXIV("64"), LXV("65"), LXVI("66"), LXVII("67"), LXVIII("68"), LXIX("69"),
        LXX("70"), LXXI("71"), LXXII("72"), LXXIII("73"), LXXIV("74"), LXXV("75"),
        LXXVI("76"), LXXVII("77"), LXXVIII("78"), LXXIX("79"), LXXX("80"), LXXXI("81"),
        LXXXII("82"), LXXXIII("83"), LXXXIV("84"), LXXXV("85"), LXXXVI("86"), LXXXVII("87"),
        LXXXVIII("88"), LXXXIX("89"), XC("90"), XCI("91"), XCII("92"), XCIII("93"),
        XCIV("94"), XCV("95"), XCVI("96"), XCVII("97"), XCVIII("98"), XCIX("99"),
        C("100");
        private String arabicNum;
        romanNumeral(String arabicNum) {
            this.arabicNum = arabicNum;
        }
        String getArabicNum() {    //Переводит римское число в арабское
            return arabicNum;
        }
    }
}