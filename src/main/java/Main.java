import br.prover.service.FraseService;

public class Main {
    public static void main(String[] args) {

        FraseService fraseService = new FraseService();

        System.out.print(fraseService.analisarFrase("Ta estressado cara ta"));
    }
}
