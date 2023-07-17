import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        System.out.println("Введите последовательность: ");
        String line = sc.nextLine();

        String[] str = line.split("[,]");

        if(str.length <= 2){
            System.out.println("Последовательность должна состоять минимум из 3 елеменов!");
            return;
        }

        int[] arr = new int[str.length];

        for(int i = 0; i < str.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i + 1] > arr[i]){
                count++;
            }
        }


        if(count == arr.length - 1){

            String result = plus(arr);
            if(result.equals("")) {
                result = multiplication(arr);
                if(result.equals("")){
                    result = degree(arr);
                }
            }

            if(result.equals("")){
                System.out.println("Не найдено никакого алгоритма для решения данной последовательности!");
            }else{
                System.out.println(Arrays.toString(arr)+ " => " +result);
            }
        }else {
            System.out.println("Массив не является последовательностью!");
        }

    }

    static String plus(int[] arr){
        int count = 0;
        String str = "";
        int[] getArr = new int [arr.length -1];

        for(int i = 0; i < getArr.length; i++){
            getArr[i] = arr[i + 1] - arr[i];
        }
        for(int i = 0; i < getArr.length-1; i++){
            if(getArr[i + 1] == getArr[i]){
                count++;
            }
        }
        if(count == getArr.length-1){
            str = arr[arr.length -1] + getArr[0] + "";
        }
        return str;
    }
    static String multiplication(int[] arr){
        String str = "";
        boolean result = true;
        int resultNum = arr[1] / arr[0];

        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] * resultNum != arr[i+1]){
                result = false;
                break;
            }
        }

        if(result) {
            str = arr[arr.length-1] * resultNum + "";
        }

        return str;
    }

    static String degree(int [] arr){
        String str = "";
        boolean result;

        for(int i = 2; i <= 5; i++) {

            result = true;
            for (int j = 0; j < arr.length - 1; j++) {
                double intRes = Math.pow(arr[j + 1], (double) 1 / i) - Math.pow(arr[j], (double) 1 / i);
                if (!(intRes >= 0.9999 && intRes <= 1.0001)) {
                    result = false;
                    break;
                }
            }

            if (result) {
                double absNumber = Math.pow(arr[arr.length - 1], (double)1/i);
                str = (absNumber % 1 == 0) ? (int)Math.pow((int)absNumber + 1, i) + "" : (int)Math.pow((int)absNumber + 2, i) + "";
                break;
            }

        }

        return str;
    }

}