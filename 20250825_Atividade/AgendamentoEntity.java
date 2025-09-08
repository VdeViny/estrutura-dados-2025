import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class AgendamentoEntity implements Comparable<AgendamentoEntity> {

    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;

    // Getters e Setters
    public LocalDate getDataAgendamento() { return dataAgendamento; }
    public void setDataAgendamento(LocalDate dataAgendamento) { this.dataAgendamento = dataAgendamento; }
    public LocalTime getHoraAgendamento() { return horaAgendamento; }
    public void setHoraAgendamento(LocalTime horaAgendamento) { this.horaAgendamento = horaAgendamento; }

    /**
     * Implementação do método de comparação, modelado a partir da lógica
     * necessária para a Árvore Binária de Busca.
     */
    @Override
    public int compareTo(AgendamentoEntity outroAgendamento) {
        Objects.requireNonNull(outroAgendamento, "O agendamento para comparação não pode ser nulo.");

        int comparacaoData = this.dataAgendamento.compareTo(outroAgendamento.getDataAgendamento());

        if (comparacaoData != 0) {
            return comparacaoData;
        }

        return this.horaAgendamento.compareTo(outroAgendamento.getHoraAgendamento());
    }

    @Override
    public String toString() {
        return "Agendamento[" + dataAgendamento + " " + horaAgendamento + "]";
    }
}