import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class EditarSala extends JFrame implements ActionListener{

    private JLabel lbtitle = new JLabel("Editar Salas");
    private JLabel lbnome = new JLabel("Nome Sala:");
    private JLabel lbcapacidade = new JLabel("Capacidade:");
    private JLabel lbtipo = new JLabel("Tipo Sala:");
    private JLabel lblocal  = new JLabel("Localizacao:");

    private JTextField txtnome = new JTextField();
    private JTextField txtcapaci = new JTextField();
    private JTextField txttipo = new JTextField();
    private JTextField txtlocal = new JTextField();
    private JButton btneditar = new JButton("Editar Sala");
    private JButton btnback = new JButton("Voltar");

    public EditarSala(String nome, int capacidade, String tipo, String local){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500,500);
        setLocation(800,200);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        componentes();
        txtnome.setText(nome);
        txtcapaci.setText(String.valueOf(capacidade));
        txttipo.setText(tipo);
        txtlocal.setText(local);
        txtnome.setEditable(false);

        setVisible(true);
    }
    
    public void componentes(){


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


        
         lblocal.setBounds(30,250, 140, 50);
        lblocal.setForeground(Color.decode("#01c380"));
        lblocal.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lblocal);

        
        txtlocal.setBounds(190, 250, 200, 50);
        txtlocal.setBackground(Color.decode("#132d46"));
        txtlocal.setForeground(Color.decode("#01c380"));
        txtlocal.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtlocal.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txtlocal);


        btneditar.setBounds(30, 320, 200, 50);
        btneditar.setForeground(Color.decode("#132d46"));
        btneditar.setFont(new Font("Dialog", Font.BOLD, 18));
        btneditar.setBackground(Color.decode("#01c380"));
        btneditar.setBorder(BorderFactory.createLineBorder(Color.decode("#132d46"), 1, true));
        btneditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btneditar.addActionListener(this);
        this.add(btneditar);


        btnback.setBounds(230, 320, 200, 50);
        btnback.setForeground(Color.decode("#132d46"));
        btnback.setFont(new Font("Dialog", Font.BOLD, 18));
        btnback.setBackground(Color.decode("#01c380"));
        btnback.setBorder(BorderFactory.createLineBorder(Color.decode("#132d46"), 1, true));
        btnback.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnback.addActionListener(this);
        this.add(btnback);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btneditar) {
            // Implementar a lógica para editar a sala
            String nome = txtnome.getText();
            String capacidade = txtcapaci.getText();
            String tipo = txttipo.getText();
            String local = txtlocal.getText();
            
            Connetor con = new Connetor();

            try {
               con.ps = con.con.prepareStatement("UPDATE sala SET nome = ?, capacidade = ?, tipo = ?, localizacao = ? WHERE nome = ?");
                con.ps.setString(1, nome);
                con.ps.setString(2, capacidade);
                con.ps.setString(3, tipo);
                con.ps.setString(4, local);
                con.ps.setString(5, nome); // Aqui você deve passar o ID ou nome da sala que deseja editar
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
                // Aqui você pode adicionar a lógica para atualizar os dados da sala no sistema
                
                JOptionPane.showMessageDialog(this, "Sala editada com sucesso!");
        } else if (e.getSource() == btnback) {
            this.dispose();
            new CriarSalas(); // Volta para a tela de criação de salas
        }
    }
}
