import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Automovel> automoveis = new ArrayList<>();
        automoveis.add(new Automovel("Fiat", "Mobi", "Hatch", "CHASSI1", "2023", "2024", "Branco", "ABC1234"));
        automoveis.add(new Automovel("VW", "Nivus", "SUV", "CHASSI2", "2023", "2023", "Cinza", "XYZ0123"));
        automoveis.add(new Automovel("Chevrolet", "Onix", "Hatch", "CHASSI3", "2022", "2023", "Preto", "GHI7890"));
        automoveis.add(new Automovel("Hyundai", "Creta", "SUV", "CHASSI4", "2024", "2024", "Prata", "DEF4567"));
        automoveis.add(new Automovel("Toyota", "Corolla", "Sedan", "CHASSI5", "2023", "2024", "Branco", "JKL1122"));

        ArvoreBinaria<Automovel> arvorePrincipal = new ArvoreBinaria<>();

        for (Automovel auto : automoveis) {
            arvorePrincipal.inserir(auto);
        }

        System.out.println("========================================================================");
        System.out.println("### Árvore Principal (Ordenada por Marca-Modelo-Ano-Chassi) ###");
        System.out.println("========================================================================");

        System.out.println("\n--- Impressão Em Ordem (mostra os elementos ordenados) ---");
        arvorePrincipal.imprimeEmOrdem();

        System.out.println("\n\n--- Impressão Pré-Fixado (mostra a estrutura da árvore) ---");
        arvorePrincipal.imprimePreFixado();
        System.out.println("\n");
    }
}