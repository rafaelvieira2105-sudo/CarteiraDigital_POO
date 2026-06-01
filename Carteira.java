
public class Carteira {
    private String dono;    //cria variável dono
    private String nome;    // cria variável nome
    private Double saldo;   //cria a variável saldo


    public Carteira(String dono, String nome, Double saldo){   //construtor da classe carteira
        this.dono = dono;
        this.nome = nome;
        this.saldo= saldo;
    }

    public String getDono(){    //getter que retorna a variável dono
        return dono;
    }

    public void setDono(String dono){   //Setter para alterar conteudo da variável dono
        this.dono = dono;
    }

    public String getNome(){        //getter que retorna a variavel nome
        return nome;
    }

    public void setNome(String nome){       //Setter para alterar conteudo da variavel dono
        this.nome = nome;
    }

    public Double getSaldo(){       //getter que retorna a variavel saldo
        return saldo;
    }

    public void setSaldo(Double saldo){     //setter para alterar conteudo da variavel saldo
        this.saldo = saldo;
    }

    public void depositar(Double valor){    //método para depositar
        this.saldo = this.saldo + valor;
    }

    public boolean levantar(Double valor){   //metodo para levantar 
        if (valor > saldo){
            return false;
        }else{
            this.saldo = this.saldo - valor;
            return true;
        }
    }
}
