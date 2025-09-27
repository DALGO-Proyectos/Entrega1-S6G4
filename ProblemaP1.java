import java.util.*;

public class ProblemaP1 {

    static int creatividadDeNumero(int numero, int[] P) {
        int total = 0;
        int pos = 0;
        for (; numero > 0; numero /= 10, pos++) {
            int d = numero % 10;
            if (d == 3) {
                total += P[pos];
            } else if (d == 6) {
                total += 2 * P[pos];
            } else if (d == 9) {
                total += 3 * P[pos];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalCasos = in.nextInt();

        for (int caso = 0; caso < totalCasos; caso++) {
            int k = in.nextInt();   
            int n = in.nextInt();   

            int[] P = new int[5];
            for (int i = 0; i < 5; i++) {
                P[i] = in.nextInt();
            }

            int[] creatividad = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                creatividad[i] = creatividadDeNumero(i, P);
            }

            int[] anterior = new int[n + 1];
            int[] actual = new int[n + 1];
            Arrays.fill(anterior, Integer.MIN_VALUE);
            anterior[0] = 0; 

            for (int i = 1; i <= k; i++) {
                Arrays.fill(actual, Integer.MIN_VALUE);
                for (int suma = 0; suma <= n; suma++) {
                    if (anterior[suma] == Integer.MIN_VALUE) {
                        continue;
                    }
                    for (int energia = 0; energia + suma <= n; energia++) {
                        actual[suma + energia] = Math.max(actual[suma + energia], anterior[suma] + creatividad[energia]);
                    }
                }
                
                int[] temp = anterior;
                anterior = actual;
                actual = temp;
            }

            System.out.println(anterior[n]);
        }

        in.close();
    }
}
