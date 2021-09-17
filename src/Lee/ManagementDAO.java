package Lee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;



public class ManagementDAO {

private Connection conn = null;
private PreparedStatement stmt = null;
private ResultSet rs = null;

private final String LOGIN = "select * from management where id = ? and password = ?";
private final String INSERT = "insert into management(seq,id,password,name,gender,tel,email,createdate) "
        + "values((select ifnull(max(seq),0)+1 from management as a),?,?,?,?,?,?,NOW())";
private final String LIST = "select * from management";


private ManagementDAO() {}
private static ManagementDAO instance = new ManagementDAO();

public static ManagementDAO getInstance() {
    return instance;
}

public int idPassword(String id, String password) {

    conn = DataBase.getConnection();

    try {
        stmt = conn.prepareStatement(LOGIN);

        stmt.setString(1, id);
        stmt.setString(2, password);

        rs = stmt.executeQuery();

        if(rs.next()) {
            return 1;
        }
    } catch(SQLException e) {
        e.printStackTrace();
    }

    return -1;
}

public int insertMember(ManagementDTO mdto) {

    conn = DataBase.getConnection();

    try {
        stmt = conn.prepareStatement(INSERT);

        stmt.setString(1, mdto.getId());
        stmt.setString(2, mdto.getPassword());
        stmt.setString(3, mdto.getName());
        stmt.setString(4, mdto.getGender());
        stmt.setString(5, mdto.getTel());
        stmt.setString(6, mdto.getEmail());
        stmt.executeUpdate();
        return 1;

    } catch(Exception e) {
        e.printStackTrace();
    }
    return -1;
}

public List<ManagementDTO> managementList() {
        conn = DataBase.getConnection();
    List<ManagementDTO> list = new ArrayList<ManagementDTO>();

    try {
        stmt = conn.prepareStatement(LIST);
        rs = stmt.executeQuery();
        while (rs.next()) {
            ManagementDTO mdto = new ManagementDTO();
            mdto.setSeq(rs.getInt("SEQ"));
            mdto.setId(rs.getString("ID"));    
            mdto.setPassword(rs.getString("PASSWORD"));
            mdto.setName(rs.getString("NAME"));
            mdto.setGender(rs.getString("GENDER"));
            mdto.setTel(rs.getString("TEL"));
            mdto.setEmail(rs.getString("EMAIL"));
            mdto.setCreateDate(rs.getDate("CREATEDATE"));
            list.add(mdto);

        }

        return list;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
  }
}