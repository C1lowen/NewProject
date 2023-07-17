import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Level2Task1 {
    public static void main(String[] args) {
        File file = new File("p.txt");
        int[][] result = loadFromFile(file);

        for(int[] rows : result){
            System.out.println(Arrays.toString(rows));
        }
    }

    public static int[][] loadFromFile(File file){
        int[][] arr = null;
        try{
            Scanner sc = new Scanner(file);
            int rows =0;
            int colm =0;

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line == "") break;
                String[] elements = line.split("[ ]");

                if(colm == 0){
                    colm = elements.length;
                }
                rows++;
            }

            arr = new int [rows][colm];
            sc = new Scanner(file);
            int row = 0;

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line == "") break;
                String[] elements = line.split("[ ]");

                for(int col = 0; col < colm; col++){
                    arr[row][col] = Integer.parseInt(elements[col]);
                }
                row++;
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return arr;
    }
}
