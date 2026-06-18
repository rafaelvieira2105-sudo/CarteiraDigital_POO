import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//classe que mmostra e executa todo o menu principal 
public class MenuPrincipal extends JFrame{

    //cria os componentes visuais do menu principal
    JLabel menu = new JLabel("===SQUE BANK===");
    JButton btnCriarCarteira = new JButton("Criar Carteira");
    JButton btnVerCarteiras = new JButton("Ver carteiras");
    JButton btnDepositar = new JButton("Depositar");
    JButton btnLevantar = new JButton("Levantar");
    JButton btnComprarCripto = new JButton("Comprar Cripto");
    JButton btnVerCripto = new JButton("Ver cripto");
    JButton btnVenderCripto = new JButton("Vender Cripto");
    JButton btnTransferir = new JButton("Transferir");
    JButton btnSair = new JButton("Sair");

    //chama os arrays que vão ser usados
    ArrayList<Carteira> carteiras;
    ArrayList<CriptoMoeda> criptomoedas;
    ArrayList<Utilizador> utilizadores;
    

    //construtor da classe MenuPrincipal
    public MenuPrincipal(ArrayList<Carteira> carteiras, ArrayList<CriptoMoeda> criptomoedas, ArrayList<Utilizador> utilizadores){

        this.carteiras = carteiras;
        this.criptomoedas = criptomoedas;
        this.utilizadores = utilizadores;

        setTitle("SQUE BANK");
        setSize(300,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        menu.setBounds(10,20,280,30);
        btnCriarCarteira.setBounds(50,70,200,35);
        btnVerCarteiras.setBounds(50,120,200,35);
        btnDepositar.setBounds(50,170,200,35);
        btnLevantar.setBounds(50,220,200,35);
        btnComprarCripto.setBounds(50,270,200,35);
        btnVerCripto.setBounds(50,320,200,35);
        btnVenderCripto.setBounds(50,370,200,35);
        btnTransferir.setBounds(50,420,200,35);
        btnSair.setBounds(50,470,200,35);

        menu.setFont(new Font("Arial", Font.BOLD, 24));
        menu.setHorizontalAlignment(JLabel.CENTER);


        add(menu);
        add(btnCriarCarteira);
        add(btnVerCarteiras);
        add(btnDepositar);
        add(btnLevantar);
        add(btnComprarCripto);
        add(btnVerCripto);
        add(btnVenderCripto);
        add(btnTransferir);
        add(btnSair);

        //executa o botão sair
        btnSair.addActionListener(e ->{
            App.guardar(utilizadores);
            System.exit(0);
        });

        
        //executa o botão CriarCarteira
        btnCriarCarteira.addActionListener(e-> {

            //cria uma janela paralela ao menu principal
            JDialog dialog = new JDialog(this, "Criar Carteira", true);
            dialog.setSize(300,200);
            dialog.setLayout(null);

            //cria os componentes visuais dessa janela
            JLabel lblDono = new JLabel("Nome da Pessoa : ");
            JTextField txtDono = new JTextField();
            JLabel lblNome = new JLabel("Nome da Carteira : ");
            JTextField txtNome = new JTextField();
            JButton criar = new JButton("Criar");

            lblDono.setBounds(10, 20, 120, 25);
            txtDono.setBounds(140, 20, 130, 25);
            lblNome.setBounds(10, 60, 120, 25);
            txtNome.setBounds(140, 60, 130, 25);
            criar.setBounds(90, 110, 100, 30);

            dialog.add(lblDono);
            dialog.add(txtDono);
            dialog.add(lblNome);
            dialog.add(txtNome);
            dialog.add(criar);

            //executa o botão criar - cria a conta
            criar.addActionListener(ev -> {
                String dono = txtDono.getText();
                String nome = txtNome.getText();
                carteiras.add(new Carteira(dono, nome, 0.0));
                JOptionPane.showMessageDialog(dialog, "Carteira criada com Sucesso");
                dialog.dispose();
            });

            dialog.setVisible(true);
        });



        //executa o botão VerCarteiras
        btnVerCarteiras.addActionListener(e->{

            //cria uma janela paralela ao menu principal
            JDialog dialog = new JDialog(this, "Ver Carteiras", true);
            dialog.setSize(300,300);
            dialog.setLayout(null);

            JTextArea area = new JTextArea();
            area.setEditable(false);

            //percorre as carteiras e lista-as
            for(Carteira c : carteiras){
                area.append(c.getDono()+ " - "+ c.getNome()  + " - Saldo : "+ c.getSaldo() + "€\n");
            }

            JScrollPane scroll = new JScrollPane(area);
            scroll.setBounds(10,10,260,230);    
            dialog.add(scroll);
            dialog.setVisible(true);
        });


        
        //executa o botão Depositar
        btnDepositar.addActionListener(e->{

            //cria uma janela paralela ao menu principal
            JDialog dialog = new JDialog(this, "Depositar", true);
            dialog.setSize(300,200);
            dialog.setLayout(null);

            //cria os componentes visuais da janela
            JLabel carteira = new JLabel("Carteira : ");
            JComboBox<String> comboCarteiras = new JComboBox<>();
            JLabel valor = new JLabel("Valor a depositar : ");
            JTextField val = new JTextField();
            JButton depositar = new JButton("Depositar");

            carteira.setBounds(10, 20, 120, 25);
            comboCarteiras.setBounds(140, 20, 130, 25);
            valor.setBounds(10, 60, 120, 25);
            val.setBounds(140, 60, 130, 25);
            depositar.setBounds(90, 110, 100, 30);
            
            dialog.add(carteira);
            dialog.add(comboCarteiras);
            dialog.add(valor);
            dialog.add(val);
            dialog.add(depositar);

            //corre as carteiras existentes e lista-as
            for(Carteira c : carteiras){
                comboCarteiras.addItem(c.getNome());
            }

            //executa o botão depositar da janela -> Mostra a carteira que o utilizador escolheu e efetua a transação de depósito
            depositar.addActionListener(ev->{
                int index = comboCarteiras.getSelectedIndex(); 
                Carteira escolhida = carteiras.get(index);
                Double valorDeposito = Double.parseDouble(val.getText());
                escolhida.depositar(valorDeposito);
                JOptionPane.showMessageDialog(dialog, "Transação feita com Sucesso!");
                dialog.dispose();
            });

            dialog.setVisible(true);
        });


        //executa o botão levantar 
        btnLevantar.addActionListener(e->{
            //cria uma janela paralela ao menu principal
            JDialog dialog = new JDialog(this, "Levantar", true);
            dialog.setSize(300,200);
            dialog.setLayout(null);

            //cria os componentes visuais da janela
            JLabel carteira = new JLabel("Carteira : ");
            JComboBox<String> comboCarteiras = new JComboBox<>();
            JLabel valor = new JLabel("Valor a levantar :");
            JTextField val = new JTextField();
            JButton levantar = new JButton("Levantar");

            carteira.setBounds(10, 20, 120, 25);
            comboCarteiras.setBounds(140, 20, 130, 25);
            valor.setBounds(10, 60, 120, 25);
            val.setBounds(140, 60, 130, 25);
            levantar.setBounds(90, 110, 100, 30);

            dialog.add(carteira);
            dialog.add(comboCarteiras);
            dialog.add(valor);
            dialog.add(val);
            dialog.add(levantar);

            //corre as carteiras existentes e lista-as
            for(Carteira c : carteiras){
                comboCarteiras.addItem(c.getNome());
            }

            //executa o botão levantar da janbela -> recebe, lê e guarda a carteira e o valor e aplica a função levantar para efetuar a transação
            levantar.addActionListener(ev->{
                int index = comboCarteiras.getSelectedIndex();
                Carteira escolhida = carteiras.get(index);
                Double valorLevantar = Double.parseDouble(val.getText());
                escolhida.levantar(valorLevantar);
                JOptionPane.showMessageDialog(dialog,"Transação feita com Sucesso");
                dialog.dispose(); 
            });

            dialog.setVisible(true);
        });


        //executa o botão ComprarCripto
        btnComprarCripto.addActionListener(e->{
            //cria uma janela paralela ao menu principal
            JDialog dialog = new JDialog(this, "Comprar Cripto", true);
            dialog.setSize(300,250);
            dialog.setLayout(null);
            
            //cria os componentes visuais da janela
            JLabel escolherCarteira = new JLabel("Carteira : ");
            JLabel escolherCripto = new JLabel("Cripto");
            JLabel quant = new JLabel("Quantidade : ");
            JComboBox<String> comboCarteira = new JComboBox<>();
            JComboBox<String> comboCripto = new JComboBox<>();
            JTextField quantidade = new JTextField();
            JButton comprar = new JButton("Comprar");

            escolherCarteira.setBounds(10, 20, 80, 25);
            comboCarteira.setBounds(100, 20, 170, 25);
            escolherCripto.setBounds(10, 60, 80, 25);
            comboCripto.setBounds(100, 60, 170, 25);
            quantidade.setBounds(100, 100, 170, 25);
            comprar.setBounds(90, 150, 100, 30);
            quant.setBounds(100,100,80,25);

            dialog.add(escolherCarteira);
            dialog.add(comboCarteira);
            dialog.add(escolherCripto);
            dialog.add(comboCripto);
            dialog.add(quantidade);
            dialog.add(comprar);
            dialog.add(quant);

            //corre e lista as carteiras existentes
            for(Carteira c : carteiras){
                comboCarteira.addItem(c.getNome());
            }

            //corre e lista as criptomoedas existentes
            for(CriptoMoeda cm : criptomoedas){
                comboCripto.addItem(cm.getCripto());
            }

            //executa o botão comprar da janela -> recebe, lê e guarda o valor, a carteira e a criptomoeda escolhida e executa a transação da compra
            comprar.addActionListener(ev ->{
                int indexCarteira = comboCarteira.getSelectedIndex();
                Carteira escolhida = carteiras.get(indexCarteira);
                
                int indexCripto = comboCripto.getSelectedIndex();
                CriptoMoeda moedaEscolhida = criptomoedas.get(indexCripto);

                Double qtd = Double.parseDouble(quantidade.getText());
                Double custo = moedaEscolhida.getPreco() * qtd;

                if(custo > escolhida.getSaldo()){
                    JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
                } else {
                    escolhida.levantar(custo);
                    CarteiraCripto cc = new CarteiraCripto(moedaEscolhida, qtd);
                    escolhida.comprarCripto(cc);
                    JOptionPane.showMessageDialog(null, "Compra feita com sucesso!");
                    dialog.dispose();
                }
            });

            dialog.setVisible(true);

        });


        //executa o botão VerCripto
        btnVerCripto.addActionListener(e->{
            //Cria uma janela paralela ao menu principal
            JDialog dialog = new JDialog(this, "Ver Cripto", true);
            dialog.setSize(300,300);
            dialog.setLayout(null);

            JComboBox<String> comboCarteira = new JComboBox<>();
            
            JTextArea area = new JTextArea();
            area.setEditable(false);

            JScrollPane scroll = new JScrollPane(area);

            comboCarteira.setBounds(10, 10, 260, 25);
            scroll.setBounds(10,45,260,210);

            dialog.add(comboCarteira);
            dialog.add(scroll);

            //corre e lista as carteiras existentes
            for(Carteira c : carteiras){
                comboCarteira.addItem(c.getNome());
            }

            //caso haja carteiras, lê a escolhida pelo utilizador e imprime as criptomoedas possuidas da carteira
            if(!carteiras.isEmpty()){
                Carteira primeira = carteiras.get(0);
                for(CarteiraCripto cc : primeira.getCripto()){
                    area.append(cc.getMoeda().getCripto() + " - " + cc.getMoeda().getSimbolo() + " - Quantidade: " + cc.getQuantidade() + "\n");
                }
            }

            //atualiza e mostra as criptomoedas quando o utilizador escolhe/muda de carteira
            comboCarteira.addItemListener(ev->{
                int index = comboCarteira.getSelectedIndex();
                Carteira escolhida = carteiras.get(index);
                area.setText("");
                for(CarteiraCripto cc : escolhida.getCripto()){
                    area.append(cc.getMoeda().getCripto() + " - " + cc.getMoeda().getSimbolo() + " - Quantidade : " + cc.getQuantidade() + "\n");
                }
            });

            dialog.setVisible(true);

        });


        //executa o botão VenderCripto
        btnVenderCripto.addActionListener(e->{
            //cria uma janela paralela ao menu principal
            JDialog dialog = new JDialog(this, "Comprar Cripto", true);
            dialog.setSize(300,250);
            dialog.setLayout(null);
            
            //cria os componentes visuais
            JLabel escolherCarteira = new JLabel("Carteira : ");
            JLabel escolherCripto = new JLabel("Cripto");
            JLabel quant = new JLabel("Quantidade : ");
            JComboBox<String> comboCarteira = new JComboBox<>();
            JComboBox<String> comboCripto = new JComboBox<>();
            JTextField quantidade = new JTextField();
            JButton vender = new JButton("Vender");

            escolherCarteira.setBounds(10, 20, 80, 25);
            comboCarteira.setBounds(100, 20, 170, 25);
            escolherCripto.setBounds(10, 60, 80, 25);
            comboCripto.setBounds(100, 60, 170, 25);
            quantidade.setBounds(100, 100, 170, 25);
            vender.setBounds(90, 150, 100, 30);
            quant.setBounds(10,100,80,25);


            dialog.add(escolherCarteira);
            dialog.add(comboCarteira);
            dialog.add(escolherCripto);
            dialog.add(comboCripto);
            dialog.add(quantidade);
            dialog.add(vender);
            dialog.add(quant);

            //corre e lista as carteiras existentes
            for(Carteira c : carteiras){
                comboCarteira.addItem(c.getNome());
            }

            //corre e lista as criptomoedas existentes
            for(CriptoMoeda cm : criptomoedas){
                comboCripto.addItem(cm.getCripto());
            }

            //executa o botão vender da janela -> recebe,lê e guarda a carteira e a cripto moeda escolhida e executa a transação de venda
            vender.addActionListener(ev ->{
                int indexCarteira = comboCarteira.getSelectedIndex();
                Carteira escolhida = carteiras.get(indexCarteira);
                
                int indexCripto = comboCripto.getSelectedIndex();
                CriptoMoeda moedaEscolhida = criptomoedas.get(indexCripto);

                Double qtd = Double.parseDouble(quantidade.getText());
                Double custo = moedaEscolhida.getPreco() * qtd;

                for(CarteiraCripto cc : escolhida.getCripto()){
                    if(cc.getMoeda().equals(moedaEscolhida)){
                            if(qtd > cc.getQuantidade()){
                                JOptionPane.showMessageDialog(null, "Quantidade Insuficiente");
                            } else {
                                escolhida.depositar(custo);
                                cc.setQuantidade(cc.getQuantidade() - qtd);
                                JOptionPane.showMessageDialog(null, "Venda feita com Sucesso!");
                                dialog.dispose();
                            }
                    }
                }

                
            });

            dialog.setVisible(true);
        });


        //executa o botão de Transferir
        btnTransferir.addActionListener(e -> {
            JDialog dialog = new JDialog(this, "Transferir", true);
            dialog.setSize(300, 310);
            dialog.setLayout(null);

            JLabel lblTipo = new JLabel("Tipo:");
            JComboBox<String> tipoTransferencia = new JComboBox<>();
            tipoTransferencia.addItem("Dinheiro");
            tipoTransferencia.addItem("Criptomoeda");

            JLabel lblOrigem = new JLabel("Origem:");
            JComboBox<String> comboOrigem = new JComboBox<>();
            JLabel lblDestino = new JLabel("Destino:");
            JComboBox<String> comboDestino = new JComboBox<>();
            JLabel lblCripto = new JLabel("Cripto:");
            JComboBox<String> comboCripto = new JComboBox<>();
            JLabel lblValor = new JLabel("Valor/Qtd:");
            JTextField valor = new JTextField();
            JButton transferir = new JButton("Transferir");

            lblTipo.setBounds(10, 15, 80, 25);
            tipoTransferencia.setBounds(100, 15, 170, 25);
            lblOrigem.setBounds(10, 50, 80, 25);
            comboOrigem.setBounds(100, 50, 170, 25);
            lblDestino.setBounds(10, 85, 80, 25);
            comboDestino.setBounds(100, 85, 170, 25);
            lblCripto.setBounds(10, 120, 80, 25);
            comboCripto.setBounds(100, 120, 170, 25);
            lblValor.setBounds(10, 155, 80, 25);
            valor.setBounds(100, 155, 170, 25);
            transferir.setBounds(90, 200, 110, 30);

            dialog.add(lblTipo);
            dialog.add(tipoTransferencia);
            dialog.add(lblOrigem);
            dialog.add(comboOrigem);
            dialog.add(lblDestino);
            dialog.add(comboDestino);
            dialog.add(lblCripto);
            dialog.add(comboCripto);
            dialog.add(lblValor);
            dialog.add(valor);
            dialog.add(transferir);

            for(Carteira c : carteiras){
                comboOrigem.addItem(c.getNome());
                comboDestino.addItem(c.getNome());
            }

            for(CriptoMoeda cm : criptomoedas){
                comboCripto.addItem(cm.getCripto());
            }

            transferir.addActionListener(ev -> {
                if(comboOrigem.getSelectedIndex() == comboDestino.getSelectedIndex()){
                    JOptionPane.showMessageDialog(null, "Conta Inválida!");
                    return;
                }

                Carteira cOrigem = carteiras.get(comboOrigem.getSelectedIndex());
                Carteira cDestino = carteiras.get(comboDestino.getSelectedIndex());

                if(tipoTransferencia.getSelectedIndex() == 0){
                    Double valorTransferir = Double.parseDouble(valor.getText());
                    if(cOrigem.levantar(valorTransferir)){
                        cDestino.depositar(valorTransferir);
                        JOptionPane.showMessageDialog(null, "Transferência efetuada com Sucesso!");
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
                    }
                } else {
                    CriptoMoeda moedaEscolhida = criptomoedas.get(comboCripto.getSelectedIndex());
                    Double qtd = Double.parseDouble(valor.getText());
                    for(CarteiraCripto cc : cOrigem.getCripto()){
                        if(cc.getMoeda().equals(moedaEscolhida)){
                            if(qtd > cc.getQuantidade()){
                                JOptionPane.showMessageDialog(null, "Quantidade insuficiente!");
                            } else {
                                cc.setQuantidade(cc.getQuantidade() - qtd);
                                cDestino.comprarCripto(new CarteiraCripto(moedaEscolhida, qtd));
                                JOptionPane.showMessageDialog(null, "Transferência de cripto efetuada!");
                                dialog.dispose();
                            }
                        
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Cripto não encontrada na carteira!");
                }
            });

            dialog.setVisible(true);
        });


    }
}
