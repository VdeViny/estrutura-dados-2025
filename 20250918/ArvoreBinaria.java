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
            return new NodoArvore<T>(objeto);
        }

        if (objeto.compareTo(noAtual.objeto) < 0) {
            noAtual.filhoEsquerda = inserirRecursivo(noAtual.filhoEsquerda, objeto);
        } else if (objeto.compareTo(noAtual.objeto) > 0) {
            noAtual.filhoDireita = inserirRecursivo(noAtual.filhoDireita, objeto);
        }

        return noAtual;
    }

    @Override
    public NodoArvore<T> pesquisa(T objeto) {
        return pesquisaRecursivo(this.raiz, objeto);
    }

    private NodoArvore<T> pesquisaRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null || noAtual.objeto.compareTo(objeto) == 0) {
            return noAtual;
        }

        if (objeto.compareTo(noAtual.objeto) < 0) {
            return pesquisaRecursivo(noAtual.filhoEsquerda, objeto);
        } else {
            return pesquisaRecursivo(noAtual.filhoDireita, objeto);
        }
    }

    @Override
    public void remover(T objeto) {
        this.raiz = removerRecursivo(this.raiz, objeto);
    }

    private NodoArvore<T> removerRecursivo(NodoArvore<T> noAtual, T objeto) {
        if (noAtual == null) {
            return null;
        }

        int comparacao = objeto.compareTo(noAtual.objeto);

        if (comparacao < 0) {
            noAtual.filhoEsquerda = removerRecursivo(noAtual.filhoEsquerda, objeto);
            return noAtual;
        } else if (comparacao > 0) {
            noAtual.filhoDireita = removerRecursivo(noAtual.filhoDireita, objeto);
            return noAtual;
        } else {
            if (noAtual.filhoEsquerda == null) {
                return noAtual.filhoDireita;
            } else if (noAtual.filhoDireita == null) {
                return noAtual.filhoEsquerda;
            }

            T menorValor = encontrarMenorValor(noAtual.filhoDireita);
            noAtual.objeto = menorValor;
            noAtual.filhoDireita = removerRecursivo(noAtual.filhoDireita, menorValor);
            return noAtual;
        }
    }

    private T encontrarMenorValor(NodoArvore<T> no) {
        if (no.filhoEsquerda == null) {
            return no.objeto;
        } else {
            return encontrarMenorValor(no.filhoEsquerda);
        }
    }

    @Override
    public void imprimePreFixado() {
        imprimePreFixadoRecursivo(this.raiz);
    }

    private void imprimePreFixadoRecursivo(NodoArvore<T> no) {
        if (no != null) {
            System.out.print(no.objeto + " ");
            imprimePreFixadoRecursivo(no.filhoEsquerda);
            imprimePreFixadoRecursivo(no.filhoDireita);
        }
    }

    public void imprimePosFixado() {
        imprimePosFixadoRecursivo(this.raiz);
    }

    private void imprimePosFixadoRecursivo(NodoArvore<T> no) {
        if (no != null) {
            imprimePosFixadoRecursivo(no.filhoEsquerda);
            imprimePosFixadoRecursivo(no.filhoDireita);
            System.out.print(no.objeto + " ");
        }
    }

    public void imprimeEmOrdem() {
        imprimeEmOrdemRecursivo(this.raiz);
    }

    private void imprimeEmOrdemRecursivo(NodoArvore<T> no) {
        if (no != null) {
            imprimeEmOrdemRecursivo(no.filhoEsquerda);
            System.out.print(no.objeto + " ");
            imprimeEmOrdemRecursivo(no.filhoDireita);
        }
    }
}