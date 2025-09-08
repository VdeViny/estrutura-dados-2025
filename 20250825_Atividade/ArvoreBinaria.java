public class ArvoreBinaria<T extends Comparable<T>> implements Arvore<T> {
    NodoArvore<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    @Override
    public void inserir(T objeto) {
        this.raiz = inserirRecursivo(this.raiz, objeto);
    }

    private NodoArvore<T> inserirRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null) {
            return new NodoArvore<>(objeto);
        }

        int comparacao = objeto.compareTo(noAtual.objeto);

        if (comparacao < 0) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, objeto);
        } else if (comparacao > 0) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, objeto);
        }

        return noAtual;
    }

    @Override
    public NodoArvore<T> pesquisa(T objeto) {
        return pesquisaRecursivo(this.raiz, objeto);
    }

    private NodoArvore<T> pesquisaRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null) {
            return null;
        }

        int comparacao = objeto.compareTo(noAtual.objeto);

        if (comparacao == 0) {
            return noAtual;
        } else if (comparacao < 0) {
            return pesquisaRecursivo(noAtual.filhoEsquerda, objeto);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireita, objeto);
        }
    }

    @Override
    public void remover(T objeto) {
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public void imprimePreFixado() {
        imprimePreFixadoRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimePreFixadoRecursivo(NodoArvore<T> no) {
        if (no != null) {
            System.out.print(no.objeto + " ");
            imprimePreFixadoRecursivo(no.filhoEsquerda);
            imprimePreFixadoRecursivo(no.filhoDireita);
        }
    }

    public void imprimeEmOrdem() {
        imprimeEmOrdemRecursivo(this.raiz);
        System.out.println();
    }

    private void imprimeEmOrdemRecursivo(NodoArvore<T> no) {
        if (no != null) {
            imprimeEmOrdemRecursivo(no.filhoEsquerda);
            System.out.print(no.objeto + " ");
            imprimeEmOrdemRecursivo(no.filhoDireita);
        }
    }
}