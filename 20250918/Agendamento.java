import java.time.LocalDate;
import java.time.LocalTime;

// A anotação @Entity e outras foram removidas, pois esta é agora uma classe Java simples.
public class Agendamento implements Comparable<Agendamento> {

    private Long codigo;
    private String nomePaciente;
    private String nomeMedico;
    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;
    private String status;
    
    // Construtor atualizado para usar Strings para paciente e médico
    public Agendamento(Long codigo, String nomePaciente, String nomeMedico, LocalDate dataAgendamento, LocalTime horaAgendamento, String status) {
        this.codigo = codigo;
        this.nomePaciente = nomePaciente;
        this.nomeMedico = nomeMedico;
        this.dataAgendamento = dataAgendamento;
        this.horaAgendamento = horaAgendamento;
        this.status = status;
    }

    // O método de comparação continua o mesmo (por data e hora)
    @Override
    public int compareTo(Agendamento outro) {
        int comparacaoData = this.dataAgendamento.compareTo(outro.dataAgendamento);
        if (comparacaoData != 0) {
            return comparacaoData;
        }
        return this.horaAgendamento.compareTo(outro.horaAgendamento);
    }

    // O método toString foi atualizado para os novos campos
    @Override
    public String toString() {
        return String.format("\nAgendamento [Data: %s, Hora: %s, Paciente: %s, Médico: %s]",
            dataAgendamento, horaAgendamento, nomePaciente, nomeMedico);
    }
    
    // Getters e Setters
    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }
    public String getNomePaciente() { return nomePaciente; }
    public void setNomePaciente(String nomePaciente) { this.nomePaciente = nomePaciente; }
    public String getNomeMedico() { return nomeMedico; }
    public void setNomeMedico(String nomeMedico) { this.nomeMedico = nomeMedico; }
    public LocalDate getDataAgendamento() { return dataAgendamento; }
    public void setDataAgendamento(LocalDate dataAgendamento) { this.dataAgendamento = dataAgendamento; }
    public LocalTime getHoraAgendamento() { return horaAgendamento; }
    public void setHoraAgendamento(LocalTime horaAgendamento) { this.horaAgendamento = horaAgendamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}