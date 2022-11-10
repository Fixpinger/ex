//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class romanConvert2 {
    static Map<String, Integer> mapNum = new HashMap();
    static Map<Integer, String> mapArabic = new HashMap();

    static {


        mapNum.put("I", 1);
        mapNum.put("V", 5);
        mapNum.put("X", 10);
        mapNum.put("L", 50);
        mapNum.put("C", 100);
        mapNum.put("D", 500);
        mapNum.put("M", 1000);

        mapArabic.put(1, "I");
        mapArabic.put(5, "V");
        mapArabic.put(10, "X");
        mapArabic.put(50, "L");
        mapArabic.put(100, "C");
        mapArabic.put(500, "D");
        mapArabic.put(1000, "M");
    }

    public romanConvert2() {
    }

    public static int romanToArabic(String num) throws Exception {
        String[] arrNum = num.split("");
        int sum = 0;
        Integer[] array = new Integer[num.length()];

        int i;
        for(i = 0; i < num.length(); ++i) {
            array[i] = (Integer)mapNum.get(arrNum[i]);
            if (array[i] == null) {
                throw new Exception("т.к. в римской системе нет отрицательных чисел");
            }
        }

        for(i = 0; i < array.length - 1; i += 2) {
            if (array[i] >= array[i + 1]) {
                sum += array[i] + array[i + 1];
            } else {
                if (array[i] != 1 && array[i] != 10 && array[i] != 100 || array[i + 1] / array[i] >= 50) {
                    throw new ArithmeticException("Некорректное число. Вычитаться могут только цифры, обозначающие 1 или степени 10. уменьшаемым может быть только цифра, ближайшая в числовом ряду к вычитаемой.");
                }

                sum += array[i + 1] - array[i];
            }
        }

        if (array.length == 1) {
            sum = array[array.length - 1];
            return sum;
        } else if (array.length < 3) {
            return sum;
        } else {
            if (array.length % 2 != 0 && array[array.length - 1] < array[array.length - 2]) {
                sum += array[array.length - 1];
            }

            if (array.length % 2 != 0 && array[array.length - 1] == array[array.length - 2]) {
                sum += array[array.length - 1];
            }

            if (array.length % 2 != 0 && array[array.length - 1] > array[array.length - 2]) {
                sum += array[array.length - 1] - array[array.length - 2] * 2;
            }

            return sum;
        }
    }

    public static ArrayList<String> arabicToRoman(int num) {

        ArrayList<String> list = new ArrayList<String>();

        String s = String.valueOf(num);
        String[] arrs = s.split("");
        Integer[] digits = new Integer[arrs.length];
        int dig = arrs.length;

        for(int i = 0; i < arrs.length; ++i) {
            --dig;
            digits[i] = (int)Math.pow(10.0D, (double)dig);
        }

        String[] roman = new String[10];

        for(int i = 0; i < arrs.length; ++i) {

            int ind = digits[i] * Integer.parseInt(arrs[i]);
            int b;
            if (ind < digits[i] * 4) {
                roman[i] = (String)mapArabic.get(digits[i]);

                for(b = 0; b < Integer.parseInt(arrs[i]); ++b) {
                    //System.out.print(roman[i]);
                    list.add((roman[i]));
                }
            } else {
                int a;
                PrintStream var10000;
                String var10001;
                if (ind == digits[i] * 4) {
                    a = digits[i] * Integer.parseInt(arrs[i]) + digits[i];
                    var10000 = System.out;
                    var10001 = (String)mapArabic.get(digits[i]);
                    //var10000.print(var10001 + (String)mapArabic.get(a));
                    list.add((mapArabic.get(digits[i])));
                } else if (ind == digits[i] * 9) {
                    a = digits[i] * Integer.parseInt(arrs[i]) + digits[i];
                    var10000 = System.out;
                    var10001 = (String)mapArabic.get(digits[i]);
                    //var10000.print(var10001 + (String)mapArabic.get(a));
                    list.add(mapArabic.get(a));
                } else if (Integer.parseInt(arrs[i]) == 5) {
                    //System.out.print((String)mapArabic.get(digits[i] * Integer.parseInt(arrs[i])));
                    list.add(mapArabic.get(digits[i]*Integer.parseInt(arrs[i])));
                } else if (Integer.parseInt(arrs[i]) > 5 && Integer.parseInt(arrs[i]) < 9) {
                   // System.out.print((String)mapArabic.get(digits[i] * 5));
                    list.add(mapArabic.get(digits[i] * 5));
                    b = Integer.parseInt(arrs[i]) - 5 * digits[i];

                    for(int j = 0; j < Integer.parseInt(arrs[i]) - 5; ++j) {
                     //   System.out.print((String)mapArabic.get(digits[i]));
                        list.add(mapArabic.get(digits[i]));
                    }
                }
            }
        }
        return list;
    }


}
