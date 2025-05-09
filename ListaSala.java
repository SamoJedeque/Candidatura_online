import javax.swing.*;
import java.awt.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;

public class ListaSala extends JFrame implements ActionListener, ListSelectionListener {
    

    private JLabel lbtitle = new JLabel("Lista de Salas");
    private JLabel lbnome = new JLabel("Nome Sala:");
    private JLabel lbcapacidade = new JLabel("Capacidade:");
    private JLabel lbtipo = new JLabel("Tipo Sala:");
    private JLabel lblocal  = new JLabel("Localizacao:");
    private JLabel lbstatus = new JLabel("Estado:");

    private DefaultListModel<String> dlnome = new DefaultListModel<>();
    private DefaultListModel<String> dlcapacidade = new DefaultListModel<>();
    private DefaultListModel<String> dltipo = new DefaultListModel<>();
    private DefaultListModel<String> dllocal = new DefaultListModel<>();
    private DefaultListModel<String> dlstatus = new DefaultListModel<>();

    private JList<String> lstnome = new JList<>(dlnome);
    private JList<String> lstcapacidade = new JList<>(dlcapacidade);
    private JList<String> lsttipo = new JList<>(dltipo);
    private JList<String> lstlocal = new JList<>(dllocal);
    private JList<String> lststatus = new JList<>(dlstatus);
    private JButton btnback = new JButton("Voltar");
    private JButton btnedit = new JButton("Editar");
    private JButton btneliminar = new JButton("Eliminar");

    public ListaSala(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1090, 600);
        setLocation(400,200);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#191e29")) ;
        print();
        componentes();


        setVisible(true);

    }

    private void componentes(){
        lbtitle.setBounds(0, 10, 1090, 50);
        lbtitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbtitle.setForeground(Color.decode("#01c380"));
        lbtitle.setFont(new Font("Dialog", Font.BOLD, 40));
        this.add(lbtitle);

        lbnome.setBounds(25, 120, 200, 50);
        lbnome.setForeground(Color.decode("#01c380"));
        lbnome.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbnome);

        lstnome.setBounds(25, 170, 200, 300);
        lstnome.setBackground(Color.decode("#132d46"));
        lstnome.setForeground(Color.decode("#01c380"));
        lstnome.setFont(new Font("Dialog", Font.PLAIN, 18));
        lstnome.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(lstnome);

        lbcapacidade.setBounds(235, 120, 200, 50);
        lbcapacidade.setForeground(Color.decode("#01c380"));
        lbcapacidade.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbcapacidade);

        lstcapacidade.setBounds(235, 170, 200, 300);
        lstcapacidade.setBackground(Color.decode("#132d46"));
        lstcapacidade.setForeground(Color.decode("#01c380"));
        lstcapacidade.setFont(new Font("Dialog", Font.PLAIN, 18));
        lstcapacidade.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(lstcapacidade);

        
        lbtipo.setBounds(445, 120, 100, 50);
        lbtipo.setForeground(Color.decode("#01c380"));
        lbtipo.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbtipo);

        
        lsttipo.setBounds(445, 170, 200, 300);
        lsttipo.setBackground(Color.decode("#132d46"));
        lsttipo.setForeground(Color.decode("#01c380"));
        lsttipo.setFont(new Font("Dialog", Font.PLAIN, 18));
        lsttipo.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(lsttipo);
        
        lblocal.setBounds(655,120, 200, 50);
        lblocal.setForeground(Color.decode("#01c380"));
        lblocal.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lblocal);

        lstlocal.setBounds(655, 170, 200, 300);
        lstlocal.setBackground(Color.decode("#132d46"));
        lstlocal.setForeground(Color.decode("#01c380"));
        lstlocal.setFont(new Font("Dialog", Font.PLAIN, 18));
        lstlocal.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(lstlocal);

        lbstatus.setBounds(865, 120, 200, 50);
        lbstatus.setForeground(Color.decode("#01c380"));
        lbstatus.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(lbstatus);

        lststatus.setBounds(865, 170, 200, 300);
        lststatus.setBackground(Color.decode("#132d46"));
        lststatus.setForeground(Color.decode("#01c380"));
        lststatus.setFont(new Font("Dialog", Font.PLAIN, 18));
        lststatus.setBorder(BorderFactory.createLineBorder(Color.decode("#01c380"), 1, true));
        this.add(lststatus);

        btnback.setBounds(865, 490, 100, 50);
        btnback.addActionListener(this);
        btnback.setBackground(Color.decode("#1C5C27"));
        btnback.setForeground(Color.white);
        btnback.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(btnback);

        btnedit.setBounds(445, 490, 150, 50);
        btnedit.addActionListener(this);
        btnedit.setBackground(Color.decode("#1C5C27"));
        btnedit.setForeground(Color.white);
        btnedit.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(btnedit);

        btneliminar.setBounds(655, 490, 150, 50);
        btneliminar.addActionListener(this);
        btneliminar.setBackground(Color.decode("#1C5C27"));
        btneliminar.setForeground(Color.white);
        btneliminar.setFont(new Font("Dialog", Font.BOLD, 18));
        this.add(btneliminar);

        lstnome.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstcapacidade.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsttipo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstlocal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lststatus.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstnome.setSelectedIndex(0);
        lstcapacidade.setSelectedIndex(0);
        lsttipo.setSelectedIndex(0);
        lstlocal.setSelectedIndex(0);
        lststatus.setSelectedIndex(0);
        lstnome.setVisibleRowCount(10);
        lstcapacidade.setVisibleRowCount(10);
        lsttipo.setVisibleRowCount(10);
        lstlocal.setVisibleRowCount(10);
        lststatus.setVisibleRowCount(10);

        lstnome.setFixedCellHeight(30);
        lstcapacidade.setFixedCellHeight(30);

        
        lstnome.addListSelectionListener(this);
        lstcapacidade.addListSelectionListener(this);
        lsttipo.addListSelectionListener(this);
        lstlocal.addListSelectionListener(this);
        lststatus.addListSelectionListener(this);
        lstnome.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lstcapacidade.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lsttipo.setCursor(new Cursor(Cursor.HAND_CURSOR));

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == lstnome) {
            lstcapacidade.setSelectedIndex(lstnome.getSelectedIndex());
            lsttipo.setSelectedIndex(lstnome.getSelectedIndex());
            lstlocal.setSelectedIndex(lstnome.getSelectedIndex());
            lststatus.setSelectedIndex(lstnome.getSelectedIndex());
        } else if (e.getSource() == lstcapacidade) {
            lstnome.setSelectedIndex(lstcapacidade.getSelectedIndex());
            lsttipo.setSelectedIndex(lstcapacidade.getSelectedIndex());
            lstlocal.setSelectedIndex(lstcapacidade.getSelectedIndex());
            lststatus.setSelectedIndex(lstcapacidade.getSelectedIndex());
        } else if (e.getSource() == lsttipo) {
            lstnome.setSelectedIndex(lsttipo.getSelectedIndex());
            lstcapacidade.setSelectedIndex(lsttipo.getSelectedIndex());
            lstlocal.setSelectedIndex(lsttipo.getSelectedIndex());
            lststatus.setSelectedIndex(lsttipo.getSelectedIndex());
        } else if (e.getSource() == lstlocal) {
            lstnome.setSelectedIndex(lstlocal.getSelectedIndex());
            lstcapacidade.setSelectedIndex(lstlocal.getSelectedIndex());
            lsttipo.setSelectedIndex(lstlocal.getSelectedIndex());
            lststatus.setSelectedIndex(lstlocal.getSelectedIndex());
        } else if (e.getSource() == lststatus) {
            lstnome.setSelectedIndex(lststatus.getSelectedIndex());
            lstcapacidade.setSelectedIndex(lststatus.getSelectedIndex());
            lsttipo.setSelectedIndex(lststatus.getSelectedIndex());
            lstlocal.setSelectedIndex(lststatus.getSelectedIndex());

        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (rootPaneCheckingEnabled) {
            if (e.getSource() == btnback) {
                this.dispose();
                new Menu();
            } else if (e.getSource() == btnedit) {
                this.dispose();
                int capacidade = Integer.parseInt(lstcapacidade.getSelectedValue());
                new EditarSala(lstnome.getSelectedValue(), capacidade , lsttipo.getSelectedValue(), lstlocal.getSelectedValue());
                lstnome.clearSelection();
                lstcapacidade.clearSelection();
                lsttipo.clearSelection();
                lstlocal.clearSelection();
                lststatus.clearSelection();
            } else if (e.getSource() == btneliminar) {
                try {
                    Connetor con = new Connetor();
                    con.ps = con.con.prepareStatement("DELETE FROM salas WHERE nome = ?");
                    con.ps.setString(1, lstnome.getSelectedValue());
                    con.ps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Sala eliminada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new ListaSala();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao eliminar sala "+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
    }

    public void print(){

        try{
            Connetor con = new Connetor();
            con.ps = con.con.prepareStatement("SELECT * FROM salas");
            con.rs = con.ps.executeQuery();
            while (con.rs.next()) {
                dlnome.addElement(con.rs.getString("nome"));
                dlcapacidade.addElement(String.valueOf(con.rs.getInt("capacidade")));
                dltipo.addElement(con.rs.getString("tipo"));
                dllocal.addElement(con.rs.getString("localizacao"));
                dlstatus.addElement(con.rs.getString("disponivel"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Erro ao imprimir lista de salas "+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    public static void main(String[] args) {
        new ListaSala();
    }
}
