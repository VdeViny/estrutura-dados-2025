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
    
    public void imprimeEmOrdem() {
        imprimeEmOrdemRecursivo(this.raiz);
    }

    private void imprimeEmOrdemRecursivo(NodoArvore<T> no) {
        if (no != null) {
            imprimeEmOrdemRecursivo(no.filhoEsquerda);
            System.out.print(no.objeto);
            imprimeEmOrdemRecursivo(no.filhoDireita);
        }
    }
    
    @Override
    public void imprimePreFixado() {
        imprimePreFixadoRecursivo(this.raiz);
    }

    private void imprimePreFixadoRecursivo(NodoArvore<T> no) {
        if (no != null) {
            System.out.print(no.objeto);
            imprimePreFixadoRecursivo(no.filhoEsquerda);
            imprimePreFixadoRecursivo(no.filhoDireita);
        }
    }

    // Demais métodos (não utilizados na demonstração)
    @Override
    public NodoArvore<T> pesquisa(T objeto) { return null; /* Implementação omitida */ }
    @Override
    public void remover(T objeto) { /* Implementação omitida */ }
}