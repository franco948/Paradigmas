package ejercicio5;

import java.lang.Math;

public class MultiploMasGrande {

    public int encontrarMultiploMasGrande(int x, int y) {
        if (x == 0 || y == 0) return -1;

        x = Math.abs(x);
        y = Math.abs(y);

        if (x > 1000 || y > 1000) return -1;

        int masGrande = x > y ? x : y;
        int multiploMasGrande = -1;

        for(int i = masGrande; i <= 1000; i++) {

            if(i % x == 0 && i % y == 0) {
                if (i > multiploMasGrande) {
                    multiploMasGrande = i;
                }
            }
        }

        return multiploMasGrande;
    }
}
