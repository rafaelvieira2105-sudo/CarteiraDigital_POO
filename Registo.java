import javax.swing.*;
import java.util.ArrayList;

//classe da janela de registo
public class Registo extends JFrame{

    ArrayList<Utilizador> utilizadores;
    ArrayList<Carteira> carteiras;
    ArrayList<CriptoMoeda> criptomoedas;

    //cria os componentes visuais
    JLabel mail = new JLabel("Email : ");
    JTextField email = new JTextField();
    JLabel util = new JLabel("Utilizador : ");
    JTextField utilizador = new JTextField();
    JLabel pass = new JLabel("Password : ");
    JTextField password = new JTextField();
    JLabel rep = new JLabel("Repetir Password : ");
    JTextField repetir = new JTextField();
    JButton registar = new JButton("Registar");
    JButton voltar = new JButton("Voltar");


    //construtor da classe Registo
    public Registo(ArrayList<Utilizador> utilizadores, ArrayList<Carteira> carteiras, ArrayList<CriptoMoeda> criptomoedas){
        
        this.utilizadores = utilizadores;
        this.carteiras = carteiras;
        this.criptomoedas = criptomoedas;

        setTitle("SQUE BANK");
        setSize(300,350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mail.setBounds(10, 50, 100, 25);
        email.setBounds(120, 50, 150, 25);
        util.setBounds(10, 90, 150, 25);
        utilizador.setBounds(120, 90, 150, 25);
        pass.setBounds(10, 130, 100, 25);
        password.setBounds(120, 130, 150, 25);
        rep.setBounds(10, 170, 150, 25);
        repetir.setBounds(120, 170, 150, 25);
        registar.setBounds(50, 220, 100, 30);
        voltar.setBounds(160, 220, 80, 30);

        add(mail);
        add(email);
        add(util);
        add(utilizador);
        add(pass);
        add(password);
        add(rep);
        add(repetir);
        add(registar);
        add(voltar);

        //executa o b0otão voltar -> volta para o menu inicial
        voltar.addActionListener( e -> {
            MiniMenu mm = new MiniMenu(utilizadores, carteiras, criptomoedas);
            mm.setVisible(true);
            this.dispose();
        });


        //executa o botão registar -> lê e guarda valores e conteúdo do registo do utilizador
        registar.addActionListener( e -> {
            
            String emailTxt = email.getText();
            String utilizadorTxt = utilizador.getText();
            String passwordTxt = password.getText();
            String repetirTxt = repetir.getText();

            if(!emailTxt.contains("@")){
                JOptionPane.showMessageDialog(this,"Email inválido");
                return;
            }

            if ( passwordTxt.equals(repetirTxt)){
                Utilizador u = new Utilizador(emailTxt, utilizadorTxt, passwordTxt);
                utilizadores.add(u);
                MenuPrincipal menu = new MenuPrincipal(u.getCarteiras(), criptomoedas, utilizadores);
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "As passwords não coincidem");
            }
        });
    }
}
