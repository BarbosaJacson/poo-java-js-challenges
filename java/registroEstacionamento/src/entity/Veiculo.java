package entity;

public class Veiculo {
    private final String placa;
    private final String modelo;
    private final String cor;

    public Veiculo(String placa, String modelo, String cor) {
        if((placa == null || modelo == null || cor==null) || (placa.isBlank() || modelo.isBlank() || cor.isBlank())){
            throw new IllegalArgumentException("Parâmetros de registro do veículo inválidos!! (placa, modelo cor)");
        }
        this.placa = placa.trim().toUpperCase();
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }
}
