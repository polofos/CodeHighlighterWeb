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
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

/**
 *
 * @author Pol
 */
public class ActionLogin extends ActionSupport implements SessionAware{
    
    private String userName, password;
    private List<String> languages; 
    private Session hibernateSession;
    private User user;
    private List<Code> listCode;

    public List<Code> getListCode() {
        return listCode;
    }

    public void setListCode(List<Code> listCode) {
        this.listCode = listCode;
    }
    
    // Mapa de sesión
    private Map<String, Object> sesion;

    public Map<String, Object> getSesion() {
        return sesion;
    }

    public void setSesion(Map<String, Object> sesion) {
        this.sesion = sesion;
    }
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
    
    
    
    public ActionLogin() {
    }
    
    @Override
    public String execute() throws Exception {
        hibernateSession = NewHibernateUtil.getSessionFactory().openSession();
        hibernateSession.beginTransaction();
        if(userName!=null && password!=null && (!userName.equals("") && !password.equals("")) ){
            sesion.put("userName", userName);
            user = (User) hibernateSession.createQuery("from User where username = '"+userName+"' AND password = '"+password+"'").uniqueResult();
        } else {
            addActionError("User name & password are required");
            return INPUT;
        }
        
        if(user == null){
            addActionError("User name doesn't exist or wrong password");
            return INPUT;
        }
        
        addActionMessage("Welcome");
        
        List<Language> list = hibernateSession.createQuery("from Language").list();
        languages = new ArrayList<String>();
        list.stream().forEach((l) -> {
            languages.add(l.getIdlanguage());
        });
        
        listCode = hibernateSession.createQuery("from Code").list();
        if(!listCode.isEmpty()){
            listCode.get(0).getUser();
            listCode.get(0).getTitle();
            listCode.get(0).getLanguage();
        }
        return SUCCESS;
    }

    // Método de Sesión
    @Override
    public void setSession(Map<String, Object> map) {
        this.sesion = map;
    }
    
    
    
}
