package entity;

public abstract class Funcionario {
    private final String nome;
    private double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        if (nome == null || nome.isBlank() || salarioBase <= 0) {
            throw new IllegalArgumentException("Nome inválido ou salário base menor ou igual a zero.");
        }
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
    public abstract double calcularSalario();
}
