package Database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServer {

    private final Connection conn;
    
    public SqlServer() throws SQLException{

        SQLServerDataSource ds = new SQLServerDataSource();
	ds.setIntegratedSecurity(false);
        ds.setPassword("A1a2$bcde");
        ds.setUser("sa");
	ds.setServerName("52.67.112.140");
	ds.setPortNumber(1433); 
	ds.setDatabaseName("JavaMVC");
	conn = ds.getConnection();
			  
        //this.conn = DriverManager.getConnection("jdbc:sqlserver://52.67.112.140:1433;DatabaseName=JavaMVC", "sa", "A1a2$bcde");
    }

    public int BuscarIdArtista(String nome) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet resultado = stmt.executeQuery("SELECT Id FROM Artista WHERE Nome LIKE '%" + nome + "%'");
            resultado.next();
            return resultado.getInt(1);
        } catch (SQLException e) {
            System.err.println(e);
            return 0;
        }
    }

    public void GravarArtista(String nome) {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO Artista(Nome) VALUES('" + nome + "')");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void GravarMusica(String nomeMusica, int artistaId) {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO Musica(NomeMusica,ArtistaId) VALUES('" + nomeMusica + "',"+ artistaId +")");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void DeletarArtista(int id) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeQuery("DELETE FROM Artista WHERE Id = " + id);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void DeletarTodosArtistas() {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM Artista");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void DeletarTodosMusicas() {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM Musica");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
