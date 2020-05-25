public class ArrayX {
    public static void main(String[] args) {

        String[][] arrayX = new String[7][7];

        //Заполняем иксами одну половину массива
        for (int i = 0; i < arrayX.length; i++) {
            for (int j = 0; j < arrayX[i].length; j++) {
                if (i == j) {
                    arrayX[i][j] = "x";
                } else {
                    arrayX[i][j] = " ";
                }
            }
        }

        //Заполняем иксами вторую половину массива
        for (int i = arrayX.length - 1; i >= 0; i--) {
            for (int k = 0; k < arrayX[i].length; k++) {
                if (!arrayX[i][k].equals ("x")) {
                    if (i + k == arrayX.length - 1) {
                        arrayX[i][k] = "x";
                    } else {
                        arrayX[i][k] = " ";
                    }
                }
            }
        }

        //Вывод получившегося массива в консоль
        for (String[] stringX : arrayX) {
            for (String x : stringX) {
                System.out.print (x);
            }
            System.out.println ();
        }
    }
}