import java.util.Scanner;

public class Bol2_Ejer11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        int acu = 0;
        do {
            n = n+1;
            acu = acu + n;
        } while (acu < 10000);
        System.out.println("la incognita n es: " + n);

    }
}
