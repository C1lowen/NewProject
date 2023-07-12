import java.util.Scanner;

public class LikeClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String str = sc.nextLine();
        System.out.print("Введите символ: ");
        char letter = sc.next().charAt(0);

        int count = 0;

        for(int i = 0; i < str.length(); i++){
            if(Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(letter)){
                count++;
            }
        }
        System.out.println("Количество символов '" + letter + "': " + count) ;
    }
}
