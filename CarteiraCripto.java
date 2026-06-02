public class CarteiraCripto {
    private CriptoMoeda moeda;
    private Double quantidade;

    public CarteiraCripto(CriptoMoeda moeda, Double quantidade){
        this.moeda = moeda;
        this.quantidade = quantidade;
    }


    public CriptoMoeda getMoeda(){
        return moeda;
    }

    public void setMoeda(CriptoMoeda moeda){
        this.moeda = moeda;
    }

    
    public Double getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(Double quantidade){
        this.quantidade = quantidade;
    }
}
