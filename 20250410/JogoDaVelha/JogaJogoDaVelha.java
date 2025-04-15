import java.util.Random;

public class JogaJogoDaVelha {
    public void jogar(){
        System.out.println("Jogando para ganhar");
        int coluna = 6;
        int linha = 6;
        // Instanciando o jogo da velha
        JogoDaVelha jogo = new JogoDaVelha(coluna, linha);
        String tabuleiroInicial = jogo.toString();
        System.out.println(tabuleiroInicial);
        System.out.println("\n-------------------\n");
        Random random = new Random();

        while (jogo.haveEmptySpace() && jogo.vencedor()!=1){
            geraNumerosEJogaAteDarCerto(random, coluna, jogo);
        }
        String primeiroJogo = jogo.toString();
        System.out.println(primeiroJogo);
        System.out.println();
        jogo.vencedor();
    }

    private static void geraNumerosEJogaAteDarCerto(Random random, int coluna, JogoDaVelha jogo){
        int randomNumber = random.nextInt(0,coluna);
        int randomNumber2 = random.nextInt(0,coluna);
        if(!jogo.isPosicaoOcupada(randomNumber,randomNumber2))
            jogo.poePeca(randomNumber,randomNumber2);

    }
}
