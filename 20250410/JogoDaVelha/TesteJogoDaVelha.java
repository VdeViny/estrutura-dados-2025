import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class TesteJogoDaVelha {
    public static void main(String[] args) {

        Boolean sair=true;
        while (sair) {
            System.out.println("Deseja jogar o jogo da velha??");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            Scanner scanner = new Scanner(System.in);
            String resposta = scanner.nextLine();
            JogaJogoDaVelha jogo = new JogaJogoDaVelha();

            if ("1".equals(resposta)) {
                System.out.println("Você escolheu jogar!");
                jogo.jogar();
            } else if ("2".equals(resposta)) {
                System.out.println("Você escolheu não jogar. Até mais!");
                sair=false;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

   }

}