//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Check2 {
    public static boolean Check(String a, String b) throws Exception {
        boolean check = true;
        String[] arr1 = a.split("");
        Integer[] arrInt = new Integer[arr1.length];
        String[] arr2 = b.split("");
        Integer[] arr2Int = new Integer[arr2.length];

        int i;
        for (i = 0; i < arr1.length; ++i) {
            arrInt[i] = (Integer) romanConvert2.mapNum.get(arr1[i]);
            if (arr1[i].equals("0")){
                arrInt[i] = 0;
                continue;
            }
            if (arrInt[i] == null) {
                check = false;
            }
        }

        for (i = 0; i < arr2.length; ++i) {
            if (arr2[i].equals("0")){
                arr2Int[i] = 0;
                continue;
            }
            arr2Int[i] = (Integer) romanConvert2.mapNum.get(arr2[i]);
            if (arr2Int[i] == null) {
                check = false;
            }
        }
        int count = 0;
        for (int j = 0; j < arr1.length; j++) {
            String c = arr1[j];
            count = 0;
            int k = 0;
            if (arr1[0].equals("-")){
                k = 1;
            }
            for (k = 0; k < arr1.length; k++) {
                if (c.equals(arr1[k])){
                    count++;
                    if (count > 3){
                        throw new ArithmeticException("Такого числа нет");
                    }
                }
                else {
                    count = 0;
                }
            }
        }
        for (int j = 0; j < arr2.length; j++) {
            String c = arr2[j];
            count = 0;
            for (int k = 0; k < arr2.length; k++) {
                if (c.equals(arr2[k])){
                    count++;
                    if (count > 3){
                        throw new ArithmeticException("Такого числа нет");
                    }
                }
                else {
                    count = 0;
                }
            }
        }


        if (!arr1[0].equals("-") && !arr2[0].equals("-")) {
            return check;
        } else {
            throw new Exception("т.к. в римской системе нет отрицательных чисел");
        }
    }
    public static boolean Check2(String a, String b) {
        try {
            Integer.parseInt(a);
            Integer.parseInt(b);
            return true;
        } catch (NumberFormatException var3) {
            return false;
        }
    }
}
