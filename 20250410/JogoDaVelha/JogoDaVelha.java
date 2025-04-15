public class JogoDaVelha {
    protected static final int X = 1, O = -1;
    protected static final int VAZIO = 0;
    protected int coluna;
    protected  int linha;
    protected int tabuleiro[][];
    protected int jogador;

    public JogoDaVelha(int colunas, int linhas) {
        tabuleiro = new int[colunas][linhas];
        coluna = colunas;
        linha = linhas;
        limpaTabuleiro();
    }

    public JogoDaVelha() {
        tabuleiro = new int[3][3];
        coluna = 3;
        linha = 3;
        limpaTabuleiro();
    }


    public void limpaTabuleiro() {
        for(int i = 0; i< coluna; i++) {
            for (int j = 0; j< linha; j++) {
                tabuleiro[i][j]=VAZIO;
            }
        }
        jogador = X;
    }

    public void poePeca(int i, int j) {
        if (i < 0 || i > linha || j < 0 || j > linha  ){
            throw new IllegalArgumentException("Posição Inválida");
        }
        if (tabuleiro[i][j]!=VAZIO) throw new IllegalArgumentException("Posição Ocupada");
        tabuleiro[i][j] = jogador;
        jogador = -jogador;
    }

    public Boolean isPosicaoOcupada(int i, int j){
        if (tabuleiro[i][j]!=VAZIO) return true;
        return false;
    }
    public Boolean haveEmptySpace(){
         Boolean espacoVazio=false;
        for(int i=0; i<coluna;i++){
             for(int j=0;j<linha;j++){
                espacoVazio= tabuleiro[i][j]==0;
                if(espacoVazio)
                    break;
             }
             if (espacoVazio)
                 break;
        }
        return espacoVazio;
    }


    public int vencedor() {
        int colunas = tabuleiro.length;
        int linhas = tabuleiro[0].length;
        Boolean xVenceu=false;
        Boolean oVenceu=false;

        // Verifica vitória nas linhas
        for (int i = 0; i < colunas; i++) {
            int soma = 0;
            for (int j = 0; j < linhas; j++) {
                soma += tabuleiro[i][j];
            }
            if (soma == 1 * linhas) {
                xVenceu=true;
            }
            if (soma == -1 * linhas) {
                oVenceu=true;
            }
        }

        // Verifica vitória nas colunas
        for (int j = 0; j < linhas; j++) {
            int soma = 0;
            for (int i = 0; i < colunas; i++) {
                soma += tabuleiro[i][j];
            }
            if (soma == 1 * colunas) {
                xVenceu=true;
            }
            if (soma == -1 * colunas) {
                oVenceu=true;
            }
        }

        // Verifica vitória na diagonal principal
        int somaDiagonalPrincipal = 0;
        for (int i = 0; i < Math.min(colunas, linhas); i++) {
            somaDiagonalPrincipal += tabuleiro[i][i];
        }
        if (somaDiagonalPrincipal == 1 * Math.min(colunas, linhas)) {
            xVenceu=true;
        }
        if (somaDiagonalPrincipal == -1 * Math.min(colunas, linhas)) {
            oVenceu=true;
        }

        // Verifica vitória na diagonal secundária
        int somaDiagonalSecundaria = 0;
        for (int i = 0; i < Math.min(colunas, linhas); i++) {
            somaDiagonalSecundaria += tabuleiro[i][linhas - 1 - i];
        }
        if (somaDiagonalSecundaria == 1 * Math.min(colunas, linhas)) {
            xVenceu=true;
        }
        if (somaDiagonalSecundaria == -1 * Math.min(colunas, linhas)) {
            oVenceu=true;
        }


        if(xVenceu){
            System.out.println("X Venceu");
            return 1;
        }
        if(oVenceu){
            System.out.println("O Venceu");
            return 1;
        }

        if (!haveEmptySpace()) {
            System.out.println("Empate!");
            return 1;
        }
        return 0;
    }

    
    public String toString() {
        /** Implementar o método to String que deve retornar
         * uma string com o tabuleiro do jogo da velha com as peças
         * nas posições corretas.
         */
        String retorno = "";
        for (int i = 0; i< linha; i++){
            for (int j = 0; j< coluna; j++){
                if(tabuleiro[i][j]==X) {
                    retorno += (" |X| ");
                } else if (tabuleiro[i][j]==O) {
                    retorno += (" |O| ");
                } else {
                    retorno += (" | | ");
                }
                if (j< linha){
                    retorno += (" ");
                }
            }
            //System.out.println();
            if (i< linha -1){
                retorno += ("\n-------------------\n");
            }

        }   
        return retorno;
    }
}