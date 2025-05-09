
public class Session {

    private static int id;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Session.id = id;
    }
    
    public static void creatSession(int id, String username) {
        
        try{

            Connetor con = new Connetor();
            con.ps = con.con.prepareStatement("INSERT INTO session (user_id, username) VALUES (?, ?)");
            con.ps.setInt(1, id);
            con.ps.setString(2, username);
            con.ps.executeUpdate();
            setId(id);
            if (id == 0) {
                System.out.println("Sessao nao criada!");
                return;
                
            }else if (id > 0) {
                System.out.println("Sessao criada com sucesso!");
            }
        }catch(Exception e){
            System.out.println("Erro ao criar sessao: " + e.getMessage());
        }
    }

    public static int getSession(int id) { 
        try{
            Connetor con = new Connetor();
            con.ps = con.con.prepareStatement("SELECT * FROM session WHERE user_id = ?");
            con.ps.setInt(1, id);
            con.rs = con.ps.executeQuery();
            if (con.rs.next()) {
                return con.rs.getInt("user_id");
            } else {
                System.out.println("Sessao nao encontrada!");
            }
        }catch(Exception e){
            System.out.println("Erro ao buscar sessao: " + e.getMessage());
        }

        return -1;
    }

    public static void clearSession(int id) {
        try{
            Connetor con = new Connetor();
            con.ps = con.con.prepareStatement("DELETE FROM session WHERE user_id = ?");
            con.ps.setInt(1, id);

            if (id == 0) {
                System.out.println("Sessao nao encontrada!");
                return;
                
            }else if (id > 0) {
                con.ps.executeUpdate();
                System.out.println("Sessao encerrada com sucesso!");
            }
        }catch(Exception e){
            System.out.println("Erro ao encerrar sessao: " + e.getMessage());
        }
    }
}