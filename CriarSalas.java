
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CriarSalas extends JFrame implements ActionListener{


    private JLabel lbtitle = new JLabel("Criar Salas");
    private JLabel lbnome = new JLabel("Nome Sala:");
    private JLabel lbcapacidade = new JLabel("Capacidade:");
    private JLabel lbtipo = new JLabel("Tipo Sala:");
    private JLabel lblocal  = new JLabel("Localizacao:");

    private JTextField txtnome = new JTextField();
    private JTextField txtcapaci = new JTextField();
    private JTextField txttipo = new JTextField();
    private JTextField txtlocal = new JTextField();
    private JButton btncriar = new JButton("Criar Sala");
    private JButton btnback = new JButton("Voltar");

    public CriarSalas(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500,500);
        setLocation(800,200);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        componentes();

        setVisible(true);
    }

    private void componentes(){

        lbtitle.setBounds(0, 10, 500, 50);
        lbtitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbtitle.setForeground(Color.decode("#01c380"));
        lbtitle.setFont(new Font("Dialog", Font.BOLD, 40));
        this.add(lbtitle);

        lbnome.setBounds(30, 70, 140, 50);
        lbnome.setForeground(Color.decode("#01c380"));
        lbnome.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbnome);

        txtnome.setBounds(190, 70, 200, 50);
        txtnome.setBackground(Color.decode("#132d46"));
        txtnome.setForeground(Color.decode("#01c380"));
        txtnome.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtnome.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txtnome);

        lbcapacidade.setBounds(30, 130, 140, 50);
        lbcapacidade.setForeground(Color.decode("#01c380"));
        lbcapacidade.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbcapacidade);

        txtcapaci.setBounds(190, 130, 200, 50);
        txtcapaci.setBackground(Color.decode("#132d46"));
        txtcapaci.setForeground(Color.decode("#01c380"));
        txtcapaci.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtcapaci.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txtcapaci);

        
        lbtipo.setBounds(30, 190, 140, 50);
        lbtipo.setForeground(Color.decode("#01c380"));
        lbtipo.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbtipo);

        txttipo.setBounds(190, 190, 200, 50);
        txttipo.setBackground(Color.decode("#132d46"));
        txttipo.setForeground(Color.decode("#01c380"));
        txttipo.setFont(new Font("Dialog", Font.PLAIN, 28));
        txttipo.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txttipo);

        lblocal.setBounds(30, 250, 140, 50);
        lblocal.setForeground(Color.decode("#01c380"));
        lblocal.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lblocal);

        txtlocal.setBounds(190, 250, 200, 50);
        txtlocal.setBackground(Color.decode("#132d46"));
        txtlocal.setForeground(Color.decode("#01c380"));
        txtlocal.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtlocal.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txtlocal);

        btncriar.setBounds(getBounds().width/2 - 100, 350, 200, 50);
        btncriar.setBackground(Color.decode("#1C5C27"));
        btncriar.setForeground(Color.decode("#01c380"));
        btncriar.setFont(new Font("Dialog", Font.BOLD, 20));
        btncriar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btncriar.addActionListener(this);
        this.add(btncriar);

        btnback.setBounds(30, 350, 100, 50);
        btnback.setBackground(Color.decode("#1C5C27"));
        btnback.setForeground(Color.decode("#01c380"));
        btnback.setFont(new Font("Dialog", Font.BOLD, 20));
        btnback.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnback.addActionListener(this);
        this.add(btnback);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btncriar){

            if(txtnome.getText().isEmpty() || txtcapaci.getText().isEmpty() || txttipo.getText().isEmpty() || txtlocal.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
                
            }else{
                String nome = txtnome.getText();
                int capacidade = Integer.parseInt(txtcapaci.getText());

                if(capacidade <= 0){       
                    JOptionPane.showMessageDialog(this, "Capacidade deve ser maior que 0", "Erro", JOptionPane.ERROR_MESSAGE);
                    
                }else{
                    
                    String tipo = txttipo.getText();
                    String local = txtlocal.getText();
                    Connetor con = new Connetor();
                    System.out.println("Nome: " + nome + " Capacidade: " + capacidade + " Tipo: " + tipo + " Local: " + local);
                    con.insertSala(nome, capacidade, tipo, local);
                    JOptionPane.showMessageDialog(this, "Sala criada com sucesso!");
                    txtnome.setText("");
                    txtcapaci.setText("");
                    txttipo.setText("");
                    txtlocal.setText("");
                     
                }

                
            }

        }else if(e.getSource() == btnback){
            new Menu();
            dispose();
        }
    }

    public static void main(String[] args) {
        new CriarSalas();
    }
    
}
