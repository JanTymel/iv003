package com.example.sada01;

public class Priklad3 {

    private static final int n = 6;

    // n+1 kvuli tomu, ze java indexuje od nuly
    // prvky A[0], R[0] a L[0] se tedy efektivne ignoruji
    private static final int[] A = new int[n + 1];
    private static final int[] R = new int[n + 1];
    private static final int[] L = new int[n + 1];

    public static void main(String[] args) {
        setup(4);
        setup(5);
        setup(3);
    }

    private static void setup(int i) {
        if (A[i] == 0) {
            if (i == n || A[i + 1] == 0) {
                A[i] = i;
                R[i] = i;
                L[i] = i;
            }

            if (i < n && A[i + 1] != 0) {
                A[i] = A[i + 1];
                R[A[i]] = i;
                L[A[i]] = L[A[i]] + 1;
            }

            if (i > 1 && A[i - 1] != 0) {
                if (L[A[i - 1]] >= L[A[i]]) {
                    L[A[i - 1]] = L[A[i - 1]] + L[A[i]];
                    int tmp = i + L[A[i]] - 1;
                    for (int k = i; k <= tmp; k++) {
                        A[k] = A[i - 1];

                    }
                } else {
                    L[A[i]] = L[A[i - 1]] + L[A[i]];
                    R[A[i]] = R[A[i - 1]];
                    for (int k = R[A[i]]; k >= i - 1; k--) {
                        A[k] = A[i];
                    }
                }
            }

        }
        printArrays();
    }

    private static boolean test(int i) {
        return A[i] != 0;
    }

    private static int max(int i) {
        return A[i] == 0 ? i : R[A[i]] - 1;
    }

    private static void printArrays() {
        System.out.print("A: ");
        printParticularArray(A);

        System.out.print("R: ");
        printParticularArray(R);

        System.out.print("L: ");
        printParticularArray(L);
    }

    private static void printParticularArray(int[] array) {
        for (int i = 1; i <= n; i++) {
            System.out.print(array[i] + " ");

        }

        System.out.println("");
    }

}
