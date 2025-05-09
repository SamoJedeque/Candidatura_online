import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener{

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1 = new JMenu("Minha Conta");
    private JMenu menu2 = new JMenu("Arquivos");
    private JMenu menu3 = new JMenu("Jogos");

    private JMenuItem item1 = new JMenuItem("Nova Inscricao");
    private JMenuItem item3 = new JMenuItem("Sair");
    private JMenuItem item4 = new JMenuItem("Perfil");
    
    public Principal(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400,300);
        setLocation(800,200);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        componentes();


        setVisible(true);
    }

    private void componentes(){
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.decode("#191e29"));
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        
        menu1.setForeground(Color.decode("#01c380"));
        menu2.setForeground(Color.decode("#01c380"));
        menu3.setForeground(Color.decode("#01c380"));
       
        item1.setForeground(Color.decode("#01c380"));
        item3.setForeground(Color.decode("#01c380"));
        item4.setForeground(Color.decode("#01c380"));
        menu1.setBackground(Color.decode("#191e29"));   
        menu2.setBackground(Color.decode("#191e29"));
        menu3.setBackground(Color.decode("#191e29"));
       
        item1.setBackground(Color.decode("#191e29"));
        item3.setBackground(Color.decode("#191e29"));
        item4.setBackground(Color.decode("#191e29"));
        menu1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        menu2.setFont(new Font("Arial", Font.PLAIN, 20));
        menu3.setFont(new Font("Arial", Font.PLAIN, 20));
        
        item1.setFont(new Font("Arial", Font.PLAIN, 20));
        item3.setFont(new Font("Arial", Font.PLAIN, 20));
        item4.setFont(new Font("Arial", Font.PLAIN, 20));
        menu1.add(item1);
        menu1.add(item3);
        menu2.add(item4);

        item1.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == item1) {
            dispose();
            new Incricao();
        }else if (ae.getSource() == item3) {
            Session.clearSession(Session.getSession(Session.getId()));
            dispose();
            JOptionPane.showMessageDialog(null, "Sessao encerrada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            new Loginform();
        }else if(ae.getSource() == item4){
            dispose();
            new PerfilCandidato();

        }
    }
    
}
