public class CriptoMoeda {
    private String bit;
    private String simbolo;
    private Double preco;

    public CriptoMoeda(String cripto, String simbolo, Double preco){
        this.cripto = cripto;
        this.simbolo = simbolo;
        this.preco = preco;
    }

    public String getCripto(){
        return cripto;
    }

    public void setCripto(String cripto){
        this.cripto = cripto;
    }


    public String getSimbolo(){
        return simbolo;
    }

    public void setSimbolo(String simbolo){
        this.simbolo = simbolo;
    }

    
    public Double getPreco(){
        return preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }
    


}
