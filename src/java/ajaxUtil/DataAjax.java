/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajaxUtil;

import com.mysql.jdbc.Connection;
import entity.Code;
import entity.CodeId;
import entity.Language;
import entity.Row;
import entity.RowId;
import entity.User;
import java.util.Set;


/**
 *
 * @author Pol
 */
public class DataAjax {
    private MysqlConnection con;
    
    public void InsertRow() throws ClassNotFoundException{
        con = MysqlConnection.getInstance();
        
        Row row = new Row();
        
        
    }
    
    
}
