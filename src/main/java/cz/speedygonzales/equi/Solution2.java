package cz.speedygonzales.equi;

/**
 * @author vondracek
 * @since 15.4.15 16:32
 */
public class Solution2 {

    public int solution(int[] A) {

        int delkaPole = A.length;
        int[] novePole = new int[delkaPole + 1];
        novePole[0] = -1;
        for (int i = 0; i < delkaPole; i++) {
            novePole[i + 1] = A[i];
        }
        int pocet = 0;
        int pozice = (delkaPole + 1) / 2;
        int kandidat = novePole[pozice];
        for (int i = 1; i <= delkaPole; i++) {
            if (novePole[i] == kandidat) {
                pocet++;
            }
        }
        if (pocet > pozice) {
            return kandidat;
        }

        return (-1);
    }
}
