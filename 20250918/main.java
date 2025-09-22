import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        
        List<Agendamento> agendamentos = new ArrayList<>();
        agendamentos.add(new Agendamento(1L, "Carlos Silva", "Dr. Roberto Alves", LocalDate.of(2025, 10, 22), LocalTime.of(14, 0), "Marcado"));
        agendamentos.add(new Agendamento(2L, "Ana Pereira", "Dra. Mariana Lima", LocalDate.of(2025, 10, 22), LocalTime.of(10, 30), "Marcado"));
        agendamentos.add(new Agendamento(3L, "Beatriz Costa", "Dr. Roberto Alves", LocalDate.of(2025, 10, 21), LocalTime.of(9, 0), "Marcado"));
        agendamentos.add(new Agendamento(4L, "Carlos Silva", "Dra. Mariana Lima", LocalDate.of(2025, 11, 5), LocalTime.of(11, 0), "Marcado"));
        agendamentos.add(new Agendamento(5L, "Ana Pereira", "Dr. Roberto Alves", LocalDate.of(2025, 10, 22), LocalTime.of(14, 30), "Marcado"));

        ArvoreBinaria<Agendamento> arvoreAgendamentos = new ArvoreBinaria<>();

        for (Agendamento agendamento : agendamentos) {
            arvoreAgendamentos.inserir(agendamento);
        }

        System.out.println("========================================================================");
        System.out.println("###         Árvore de Agendamentos (Ordenada por Data e Hora)        ###");
        System.out.println("========================================================================");

        System.out.println("\n--- Impressão Em Ordem (mostra os agendamentos cronologicamente) ---");
        arvoreAgendamentos.imprimeEmOrdem();

        System.out.println("\n\n\n--- Impressão Pré-Fixado (mostra a estrutura de inserção da árvore) ---");
        arvoreAgendamentos.imprimePreFixado();
        System.out.println("\n");
    }
}