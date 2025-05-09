import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PerfilCandidato extends JFrame implements ActionListener{

    private JLabel lbtitle = new JLabel("Perfil Candidato");
    private int user_id;

    private JTextField txtnome = new JTextField();
    private JTextField txtapelido = new JTextField();
    private JTextField txtcidade = new JTextField();
    private JTextField txtgen = new JTextField();
    private JTextField txtid = new JTextField();
    
    
    private JLabel lbnome = new JLabel("Nome:");
    private JLabel lbapelido = new JLabel("Apelido:");
    private JLabel lbcidade = new JLabel("Cidade:");
    private JLabel lbgen = new JLabel("Genero:");
    private JLabel lbid = new JLabel("ID");
    private JLabel lbcurso = new JLabel("Curso:");
    private JButton jbstatus = new JButton("Status");

    private JButton btnback = new JButton("Voltar");
    private JButton btnedit = new JButton("Editar");
    private JButton btneliminar = new JButton("Eliminar");

    private int id;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public int getIdCandidato(){
       
        try {
            Connetor con = new Connetor();
            con.ps = con.con.prepareStatement("SELECT * FROM inscricao WHERE cand_id = ?");
            con.ps.setInt(1, Session.getId());
            con.rs = con.ps.executeQuery();
            if (con.rs.next()) {
                return con.rs.getInt("inscricao_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }

    public PerfilCandidato(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500,700);
        setLocation(800,200);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        componentes();

        setVisible(true);
    }
    private void componentes(){

        Connetor con = new Connetor();

        try {
            int id = Session.getId();

            con.ps = con.con.prepareStatement("SELECT * FROM candidato WHERE user_id = ?");
            con.ps.setInt(1, id);
            con.rs = con.ps.executeQuery();
            if (con.rs.next()) {
                txtnome.setText(con.rs.getString("nome"));
                txtapelido.setText(con.rs.getString("sobrenome"));
                txtcidade.setText(con.rs.getString("cidade"));
                txtgen.setText(con.rs.getString("genero"));
                txtid.setText(con.rs.getString("nuit"));
                txtid.setEditable(false);
                
                
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            user_id = Session.getId();
            con.ps = con.con.prepareStatement("SELECT * FROM inscricao WHERE cand_id = ?");
            con.ps.setInt(1, user_id);
            con.rs = con.ps.executeQuery();
            if (con.rs.next()) {
                lbcurso.setText(con.rs.getString("curso"));
                jbstatus.setText(con.rs.getString("status"));
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        lbtitle.setBounds(0, 10, 400, 50);
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

        
        lbapelido.setBounds(30, 130, 140, 50);
        lbapelido.setForeground(Color.decode("#01c380"));
        lbapelido.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbapelido);

        txtapelido.setBounds(190, 130, 200, 50);
        txtapelido.setBackground(Color.decode("#132d46"));
        txtapelido.setForeground(Color.decode("#01c380"));
        txtapelido.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtapelido.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txtapelido);

        lbcidade.setBounds(30, 190, 140, 50);
        lbcidade.setForeground(Color.decode("#01c380"));
        lbcidade.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbcidade);

        txtcidade.setBounds(190, 190, 200, 50);
        txtcidade.setBackground(Color.decode("#132d46"));
        txtcidade.setForeground(Color.decode("#01c380"));
        txtcidade.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtcidade.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txtcidade);

        lbgen.setBounds(30, 250, 140, 50);
        lbgen.setForeground(Color.decode("#01c380"));
        lbgen.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbgen);

        txtgen.setBounds(190, 250, 200, 50);
        txtgen.setBackground(Color.decode("#132d46"));
        txtgen.setForeground(Color.decode("#01c380"));
        txtgen.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtgen.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txtgen);

        lbid.setBounds(30, 310, 140, 50);
        lbid.setForeground(Color.decode("#01c380"));
        lbid.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbid);

        txtid.setBounds(190, 310, 200, 50);
        txtid.setBackground(Color.decode("#132d46"));
        txtid.setForeground(Color.decode("#01c380"));
        txtid.setFont(new Font("Dialog", Font.PLAIN, 28));
        txtid.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(txtid);

        lbcurso.setBounds(30, 370, 140, 50);
        lbcurso.setForeground(Color.decode("#01c380"));
        lbcurso.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbcurso);

        jbstatus.setBounds(190, 370, 200, 50);
        jbstatus.setBackground(Color.decode("#132d46"));
        jbstatus.setForeground(Color.decode("#01c380"));
        jbstatus.setFont(new Font("Dialog", Font.PLAIN, 28));
        jbstatus.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        jbstatus.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbstatus.addActionListener(this);
        this.add(jbstatus);

        btnedit.setBounds(30, 450, 140, 50);
        btnedit.setBackground(Color.decode("#132d46"));
        btnedit.setForeground(Color.decode("#01c380"));
        btnedit.setFont(new Font("Dialog", Font.BOLD, 18));
        btnedit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnedit.addActionListener(this);
        this.add(btnedit);

        btneliminar.setBounds(190, 450, 140, 50);
        btneliminar.setBackground(Color.decode("#132d46"));
        btneliminar.setForeground(Color.decode("#01c380"));
        btneliminar.setFont(new Font("Dialog", Font.BOLD, 18));
        btneliminar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btneliminar.addActionListener(this);
        this.add(btneliminar);

        btnback.setBounds(30, 520, 360, 50);
        btnback.setBackground(Color.decode("#132d46"));
        btnback.setForeground(Color.decode("#01c380"));
        btnback.setFont(new Font("Dialog", Font.BOLD, 18));
        btnback.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnback.addActionListener(this);
        this.add(btnback);

    }


    @Override

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnback) {
            dispose();
            new Principal();
        }else if (e.getSource() == btnedit) {
            int yes = JOptionPane.showConfirmDialog(this, "Deseja realmente editar os dados?", "Editar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (yes == JOptionPane.YES_OPTION) {
                Connetor con = new Connetor();
                try {
                    con.ps = con.con.prepareStatement("UPDATE candidato SET nome = ?, sobrenome = ?, cidade = ?, genero = ? WHERE user_id = ?");
                    con.ps.setString(1, txtnome.getText());
                    con.ps.setString(2, txtapelido.getText());
                    con.ps.setString(3, txtcidade.getText());
                    con.ps.setString(4, txtgen.getText());
                    con.ps.setInt(5, Session.getId());
                    con.ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                
            }
        }else if (e.getSource() == btneliminar) {
            
            Connetor con = new Connetor();
            con.delete(Session.getId());
        }else if (e.getSource() == jbstatus) {
            int valor = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o valor a pagar: ", "Status", JOptionPane.INFORMATION_MESSAGE));

            if (valor < 1000) {
                JOptionPane.showConfirmDialog(this, "Valor invalido");
            }else{

                Connetor con = new Connetor();
                boolean pago = false;
                try{
                    con.ps = con.con.prepareStatement("INSERT INTO pagamento ( candidatura_id, valor) VALUES (?, ?)");
                    con.ps.setInt(2, valor);
                    con.ps.setInt(1, getIdCandidato());
                    con.ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    pago = true;
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                if (pago) {
                    try {
                        con.ps = con.con.prepareStatement("UPDATE inscricao SET status = ? WHERE cand_id = ?");
                        con.ps.setString(1, "PAGO");
                        con.ps.setInt(2, user_id);
                        con.ps.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Status atualizado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    } 

                    jbstatus.setText("PAGO");
                    jbstatus.setEnabled(false);
                }
                

                
            }
        }
        
    }
    

}
