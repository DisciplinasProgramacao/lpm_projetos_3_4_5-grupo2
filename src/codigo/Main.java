
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Carregar dados");
                LeituraDados l = new LeituraDados();

                l.carregarEspectador("espectadores.csv");
                l.carregarSeries("series.csv");
        }



    }
}
