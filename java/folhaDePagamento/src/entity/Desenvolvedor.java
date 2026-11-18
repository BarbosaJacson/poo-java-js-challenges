package entity;

public class Desenvolvedor extends Funcionario {
    private final int horasExtras;
    private final double valorHoraExtra;

    public Desenvolvedor(String nome, double salarioBase, int horasExtras, double valorHoraExtra) {
        super(nome, salarioBase);
        if (horasExtras < 0) {
            throw new IllegalArgumentException("A quantidade de horas extras não pode ser negativo.");
        }
        this.horasExtras = horasExtras;
        this.valorHoraExtra = valorHoraExtra;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public double getValorHoraExtra() {
        return valorHoraExtra;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (getHorasExtras() * getValorHoraExtra());
    }

}
