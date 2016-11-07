package Database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlServer {

    private final Connection conn;

    public SqlServer() throws SQLException {

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
            return resultado.getInt("Id");
        } catch (SQLException e) {
            System.err.println(e);
            return 0;
        }
    }

    public ArrayList<Artista> BuscarArtistas() {
        try (Statement stmt = conn.createStatement()) {
            ResultSet resultado = stmt.executeQuery("SELECT * FROM Artista");
            ArrayList<Artista> artistas = new ArrayList<>();
            while (resultado.next()) {
                Artista a1 = new Artista();
                a1.Id = resultado.getInt("Id");
                a1.Nome = resultado.getString("Nome");
                artistas.add(a1);
            }

            return artistas;
        } catch (SQLException e) {
            return null;
        }
    }

    public ArrayList<MusicaInfo> BuscarMusicas(int artistaId) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet resultado = stmt.executeQuery("SELECT Musica.Id IdMusica, Musica.NomeMusica, Artista.Nome NomeArtista FROM Musica JOIN Artista ON Artista.Id = Musica.ArtistaId WHERE Musica.ArtistaId = " + artistaId);
            ArrayList<MusicaInfo> musicas = new ArrayList<>();
            while (resultado.next()) {
                MusicaInfo mf = new MusicaInfo();
                mf.NomeMusica = resultado.getString("NomeMusica");
                mf.NomeArtista = resultado.getString("NomeArtista");
                mf.IdMusica = resultado.getInt("IdMusica");
                musicas.add(mf);
            }

            return musicas;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public MusicaInfo MusicaInfo(int musicaId) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet resultado = stmt.executeQuery("SELECT Musica.NomeMusica, Artista.Nome NomeArtista FROM Musica JOIN Artista ON Artista.Id = Musica.ArtistaId WHERE Musica.Id = " + musicaId);
            resultado.next();
            MusicaInfo mf = new MusicaInfo();
            mf.NomeMusica = resultado.getString("NomeMusica");
            mf.NomeArtista = resultado.getString("NomeArtista");
            return mf;
        } catch (SQLException e) {
            return null;
        }
    }

    public void GravarArtista(String nome) {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO Artista(Nome) VALUES('" + nome + "')");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void GravarArtista(ArrayList<String> nome) {
        try (Statement stmt = conn.createStatement()) {
            if (nome.isEmpty()) {
                return;
            }
            String query = "INSERT INTO Artista(Nome) VALUES";
            for (int i = 0; i < nome.size(); i++) {
                query += "('" + nome.get(i) + "')";
                if (i < nome.size() - 1) {
                    query += ",";
                }
            }
            stmt.execute(query);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void GravarMusica(String nomeMusica, int artistaId) {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("INSERT INTO Musica(NomeMusica,ArtistaId) VALUES('" + nomeMusica + "'," + artistaId + ")");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void GravarMusica(ArrayList<String> nomeMusica, int artistaId) {
        try (Statement stmt = conn.createStatement()) {
            if (nomeMusica.isEmpty()) {
                return;
            }
            String query = "INSERT INTO Musica(NomeMusica,ArtistaId) VALUES ";
            for (int i = 0; i < nomeMusica.size(); i++) {
                query += "('" + nomeMusica.get(i).replace('\'', '"') + "'," + artistaId + ")";
                if (i < nomeMusica.size() - 1) {
                    query += ",";
                }
            }
            stmt.execute(query);
        } catch (Exception e) {
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
