package entity;

import java.time.Duration;
import java.time.LocalDateTime;

public class RegistroEstacionamento {
    private final Veiculo veiculo;
    private final LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valorPago;

    public RegistroEstacionamento(Veiculo veiculo) {
        if(veiculo==null){
            throw new IllegalArgumentException("Dados do veículo inválidos!!");
        }
        this.veiculo = veiculo;
        this.horaEntrada = LocalDateTime.now();
        this.horaSaida = null;
        this.valorPago = 0.0;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void registrarSaida(LocalDateTime horaSaida, double taxaPorHora){
        if((this.horaSaida!= null) || (horaSaida.isBefore(getHoraEntrada()))){
            throw  new IllegalArgumentException("Hora de Entrada ou hora de saída inválidas!!");
        }
        Duration duracao = Duration.between(getHoraEntrada(), horaSaida);
        long minutos = duracao.toMinutes();
        double horasCobradas = Math.max(1.0, Math.ceil(minutos/60.0));
        this.horaSaida = horaSaida;
        this.valorPago = horasCobradas * taxaPorHora;

    }
}
