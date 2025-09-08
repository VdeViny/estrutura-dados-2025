import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe principal que executa o teste com a Árvore Binária de Agendamentos.
 * Esta classe contém todas as definições necessárias para rodar o exemplo.
 */
public class Main {

    public static void main(String[] args) {
        // 1. Criar a árvore binária para armazenar agendamentos
        ArvoreBinaria<AgendamentoEntity> arvoreAgendamentos = new ArvoreBinaria<>();

        // 2. Criar 10 objetos AgendamentoEntity em ordem não cronológica
        AgendamentoEntity[] agendamentos = new AgendamentoEntity[10];

        agendamentos[0] = criarAgendamento("2025-09-15", "10:00:00");
        agendamentos[1] = criarAgendamento("2025-09-12", "14:00:00");
        agendamentos[2] = criarAgendamento("2025-09-20", "09:30:00");
        agendamentos[3] = criarAgendamento("2025-09-10", "11:00:00"); // Primeiro a ser inserido, se torna a raiz
        agendamentos[4] = criarAgendamento("2025-09-18", "16:00:00");
        agendamentos[5] = criarAgendamento("2025-09-22", "08:00:00");
        agendamentos[6] = criarAgendamento("2025-09-15", "11:30:00");
        agendamentos[7] = criarAgendamento("2025-09-14", "09:00:00");
        agendamentos[8] = criarAgendamento("2025-10-01", "10:00:00");
        agendamentos[9] = criarAgendamento("2025-09-15", "09:00:00");

        // 3. Inserir os agendamentos na árvore
        System.out.println("Inserindo agendamentos na árvore na seguinte ordem:");
        for (AgendamentoEntity agendamento : agendamentos) {
            System.out.println("- " + agendamento);
            arvoreAgendamentos.inserir(agendamento);
        }

        // 4. Imprimir os resultados usando os métodos de caminhamento
        System.out.println("\n=== IMPRESSÃO PRÉ-FIXADA (Raiz -> Esquerda -> Direita) ===");
        System.out.println("Esta ordem depende da sequência de inserção e mostra a estrutura da árvore.");
        arvoreAgendamentos.imprimePreFixado();

        System.out.println("\n=== IMPRESSÃO EM ORDEM (Esquerda -> Raiz -> Direita) ===");
        System.out.println("Esta ordem SEMPRE mostrará os elementos de forma ordenada (cronologicamente).");
        arvoreAgendamentos.imprimeEmOrdem();
    }

    /**
     * Método auxiliar para criar um objeto AgendamentoEntity de forma simplificada.
     */
    private static AgendamentoEntity criarAgendamento(String data, String hora) {
        AgendamentoEntity agendamento = new AgendamentoEntity();
        agendamento.setDataAgendamento(LocalDate.parse(data));
        agendamento.setHoraAgendamento(LocalTime.parse(hora));
        return agendamento;
    }
}