//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calc2 {
    public Calc2() {
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] expr = str.split(" ");
        if (expr.length == 0) {
            expr = str.split("");
        }

        if (expr.length <= 3 && expr.length >= 2) {
            String a = expr[0];
            String b = expr[2];
            int a1 = 0;
            int b1 = 0;
            int arifExpr = 0;
            boolean roman = Check2.Check(a, b);
            boolean integer = Check2.Check2(a, b);
            if (!roman && !integer) {
                throw new Exception("т.к. используются одновременно разные системы счисления");
            } else {
                if (roman) {
                    a1 = romanConvert2.romanToArabic(a);
                    b1 = romanConvert2.romanToArabic(b);
                    if (a1 > 11 || b1 > 11 || a1 < 1 || b1 < 1){
                        throw new ArithmeticException("Числа только от 1 до 10");
                    }
                }

                if (integer) {
                    a1 = Integer.parseInt(a);
                    b1 = Integer.parseInt(b);
                    if (a1 > 11 || b1 > 11 || a1 < 1 || b1 < 1){
                        throw new ArithmeticException("Числа только от 1 до 10");
                    }
                }

                String var11 = expr[1];


                switch(var11) {
                    case "+":
                        arifExpr = a1 + b1;
                        break;
                    case "-":
                        if (roman && a1 - b1 < 0) {
                            throw new Exception("т.к. в римской системе нет отрицательных чисел");
                        }

                        arifExpr = a1 - b1;
                        break;
                    case "/":
                        arifExpr = a1 / b1;
                        break;
                    case "*":
                        arifExpr = a1 * b1;

                    default: throw new ArithmeticException("Только сложение, выяитание, умножение и деление");

                }

                if (roman) {
                    romanConvert2.arabicToRoman(arifExpr);
                } else {
                    System.out.println(arifExpr);
                }

            }
        } else {
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
}
