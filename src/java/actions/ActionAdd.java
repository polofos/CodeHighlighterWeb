/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import entity.Code;
import entity.CodeId;
import entity.Language;
import entity.Row;
import entity.RowId;
import entity.User;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Pol
 */
public class ActionAdd extends ActionSupport implements ApplicationAware, SessionAware {
    
    private Session hibernateSession;
    private String language;
    private String username;
    private Set rows;
    private List<String> rowList;
    private String title;
    private List<String> markList;
    private String input;
    private String output;
    private String inputInclude;
    private String outputOptional;

    public List<String> getMarkList() {
        return markList;
    }

    public void setMarkList(List<String> markList) {
        this.markList = markList;
    }
    
        public List<String> getRowList() {
        return rowList;
    }

    public void setRowList(List<String> rowList) {
        this.rowList = rowList;
    }

       
    public Set getRows() {
        return rows;
    }

    public void setRows(Set rows) {
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getInputInclude() {
        return inputInclude;
    }

    public void setInputInclude(String inputInclude) {
        this.inputInclude = inputInclude;
    }

    public String getOutputOptional() {
        return outputOptional;
    }

    public void setOutputOptional(String outputOptional) {
        this.outputOptional = outputOptional;
    }
    
    
    public ActionAdd() {
        
    }
    
    @Override
    public String execute() throws Exception {
        language = (String) app.get("language");
        username =(String) sesion.get("userName");
        rows = new HashSet();
        System.out.println(markList.get(0));
        System.out.println(inputInclude);
        System.out.println(outputOptional);
        
        
        hibernateSession = NewHibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        if(title != null && !title.equals("")){
            if(rowList != null && rowList.size()>0){
                CodeId cid = (CodeId) hibernateSession.createQuery("Select c.id from Code c where c.id.idcode = (Select max(cc.id.idcode) from Code cc)").uniqueResult();
                Integer intCid;
                if(cid==null){
                    intCid = 1;
                } else {
                    intCid = cid.getIdcode()+1;
                    app.put("codeId",cid);
                }
                Language lan = new Language(language);
                User user = new User();
                user.setUsername(username);
                CodeId codid = new CodeId(intCid,username,language);
                // Code(CodeId id, Language language, User user)
                // Code(CodeId id, Language language, User user, String input, String output, String title, Set rows, Set diagrams)
                Code cod = new Code(codid, lan, user);
                if(inputInclude.equals("true")){
                    cod.setInput(input);                    
                }
                if(outputOptional.equals("true")){
                    cod.setOutput(output);
                }
                cod.setTitle(title);
                for(int i=0; i<rowList.size();i++ ){
                    // RowId(int idrow, int codeIdcode, String codeUserUsername, String codeLanguageIdlanguage)               
                    RowId rowid = new RowId(i+1,intCid,username,language);
                    // Row(RowId id, Code code, Boolean mark, String content)
                    Boolean mark = Boolean.valueOf( markList.get(i));
                    System.out.println(rowid.getIdrow());
                    String content = rowList.get(i);
                    Row row = new Row(rowid,cod, mark, content);
                    rows.add(row);
                    //hibernateSession.save(row);
                }
                cod.setRows(rows);
                hibernateSession.save(cod);
                
                hibernateSession.getTransaction().commit();
                hibernateSession.close();
                
            }
            return SUCCESS;
        }
        else{
                addActionError("Must give a Title");   
                return INPUT;
        }
        
    }

    //// Scopes 
    
    private Map<String, Object> app;
    
    public Map<String, Object> getApp() {
        return app;
    }

    public void setApp(Map<String, Object> app) {
        this.app = app;
    }
    
        // Mapa de sesión
    private Map<String, Object> sesion;

    public Map<String, Object> getSesion() {
        return sesion;
    }

    public void setSesion(Map<String, Object> sesion) {
        this.sesion = sesion;
    }
    
    @Override
    public void setApplication(Map<String, Object> map) {
        this.app = map;
    }
    
     // Método de Sesión
    @Override
    public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }
    
}
