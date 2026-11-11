package service;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaBancaria {
    private String numeroDaConta;
    private String titular;
    private double saldo;
    private List<String> historico;

    public ContaBancaria(String numeroDaConta, String titular) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.saldo = 0.0;
        this.historico = new ArrayList<>();
    }

    public String getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(String numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<String> getHistorico() {
        return Collections.unmodifiableList(this.historico);
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = agora.format(formatador);
            saldo += valor;
            this.historico.add("[" + dataFormatada + "] Depósito: R$ " + valor + " | Saldo Atual: R$ " + this.saldo);
            return true;
        } else {
            return false;
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            LocalDateTime agora = LocalDateTime.now();
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String dataFormatada = agora.format(formatador);
            saldo -= valor;
            this.historico.add("[" + dataFormatada + "] Saque: R$ " + valor + " | Saldo Atual: R$ " + this.saldo);
            return true;
        } else {
            return false;
        }
    }

}
