
public class Carteira {
    private String dono;
    private String nome;
    private Double saldo;


    public Carteira(String dono, String nome, Double saldo){
        this.dono = dono;
        this.nome = nome;
        this.saldo= saldo;
    }

    public String getDono(){
        return dono;
    }

    public void setDono(String dono){
        this.dono = dono;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Double getSaldo(){
        return saldo;
    }

    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }

    public void depositar(Double valor){
        this.saldo = this.saldo + valor;
    }

    public boolean levantar(Double valor){
        if (valor > saldo){
            return false;
        }else{
            this.saldo = this.saldo - valor;
            return true;
        }
    }
}
