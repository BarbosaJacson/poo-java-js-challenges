package entity;

public class Gerente extends Funcionario {
    private final double bonus;

    public Gerente(String nome, double salarioBase, double bonus) {
        super(nome, salarioBase);
        if (bonus < 0) {
            throw new IllegalArgumentException("O bônus não pode ser negativo.");
        }
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }
    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonus;
    }
}
