public interface Arvore<T> {
    NodoArvore<T> pesquisa(T objeto);
    void inserir(T objeto);
    void remover(T objeto);
    void imprimePreFixado();
}