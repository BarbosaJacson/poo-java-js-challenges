package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Estacionamento {
    private final int capacidadeMax;
    private double taxaPorHora;
    private List<RegistroEstacionamento> ativo;
    private List<RegistroEstacionamento> historico;

    public Estacionamento(int capacidadeMax, double taxaPorHora) {
        if (capacidadeMax <= 0 || taxaPorHora <= 0) {
            throw new IllegalArgumentException("Parâmetros inválidos para capacidadeMax ou taxaPorHora");
        }
        this.capacidadeMax = capacidadeMax;
        this.taxaPorHora = taxaPorHora;
        this.ativo = new ArrayList<>();
        this.historico = new ArrayList<>();
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public List<RegistroEstacionamento> getAtivo() {
        return ativo;
    }

    public double getTaxaPorHora() {
        return taxaPorHora;
    }

    public List<RegistroEstacionamento> getHistorico() {
        return historico;
    }

    public void registrarEntrada(Veiculo veiculo) {
        if (veiculo == null){
            throw new IllegalArgumentException("Parâmetros do veículo incorretos!!!");
        }
        if(ativo.size() >= capacidadeMax){
            throw new IllegalArgumentException("Estacionamento Lotado!!");
        }
            for (RegistroEstacionamento reg : ativo) {
            if (reg.getVeiculo().getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
                throw new IllegalArgumentException("Veículo já está no estacionamento!!");
            }
        }
        RegistroEstacionamento novoRegistro = new RegistroEstacionamento(veiculo);
        ativo.add(novoRegistro);
    }

    public RegistroEstacionamento registrarSaida(String placa) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("Placa não encontrada!!");
        }
        String placaBusca = placa.trim().toUpperCase();
        Iterator<RegistroEstacionamento> it = ativo.iterator();
        while (it.hasNext()) {
            RegistroEstacionamento reg = it.next();
            if (reg.getVeiculo().getPlaca().equalsIgnoreCase(placaBusca)) {
                reg.registrarSaida(LocalDateTime.now(), this.taxaPorHora);
                it.remove();
                historico.add(reg);
                return reg;
            }
        }
        throw new NoSuchElementException("Veículo com placa " + placaBusca + " não encontrado no pátio.");
    }

}
