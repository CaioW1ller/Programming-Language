public class Main {

    /**
     * Calcula o logaritmo natural (ln) usando série de Taylor
     * ln(x) = (x-1) - (x-1)²/2 + (x-1)³/3 - (x-1)⁴/4 + ...
     */
    public static double logNatural(double x, int n) {
        if (x <= 0) {
            throw new IllegalArgumentException("x deve ser maior que 0");
        }

        return logNaturalRecursivo(x, n, 1, 1);
    }

    private static double logNaturalRecursivo(
            double x, int n, int i, int sinal) {

        // Caso base
        if (i > n) {
            return 0;
        }

        // Termo atual
        double termo = sinal * Math.pow(x - 1, i) / i;

        // Próximo termo, invertendo o sinal
        return termo
                + logNaturalRecursivo(x, n, i + 1, -sinal);
    }

    // Valor padrão: 100 termos
    public static double logNatural(double x) {
        return logNatural(x, 100);
    }

    public static void main(String[] args) {

        double x = 2.0;

        System.out.printf(
            "ln(%.2f) = %.10f%n",
            x, logNatural(x)
        );

        System.out.printf(
            "ln(%.2f) (Math.log) = %.10f%n",
            x, Math.log(x)
        );

        x = 10.0;

        System.out.printf(
            "ln(%.2f) = %.10f%n",
            x, logNatural(x)
        );

        System.out.printf(
            "ln(%.2f) (Math.log) = %.10f%n",
            x, Math.log(x)
        );

        x = 0.5;

        System.out.printf(
            "ln(%.2f) = %.10f%n",
            x, logNatural(x)
        );

        System.out.printf(
            "ln(%.2f) (Math.log) = %.10f%n",
            x, Math.log(x)
        );
    }
}