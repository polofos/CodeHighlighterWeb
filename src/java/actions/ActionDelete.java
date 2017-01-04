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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

/**
 *
 * @author mery
 */
public class ActionDelete extends ActionSupport implements ApplicationAware, SessionAware, ParameterAware {
    CodeId codeId;
    Language language;
    String username;
    User user;
    Set rows;
    List<String> languages;
    List<Code> listCode;
    
    public ActionDelete() {
    }
    
    @Override
    public String execute() throws Exception {
        rows = new HashSet();
        
        if(params.isEmpty()){
            codeId = (CodeId) app.get("codeId");
        } else {
            //CodeId(int idcode, String userUsername, String languageIdlanguage)
            /*
                <s:param name="idIdCode"> ${attr.listCode[i].id.idcode} </s:param>
                 <s:param name="idUserName"> ${attr.listCode[i].id.userUsername} </s:param>
                <s:param name="idLanguage"> ${attr.listCode[i].id.languageIdlanguage} </s:param>
            */            
            codeId = new CodeId(Integer.valueOf(params.get("idIdCode")[0]), params.get("idUserName")[0], params.get("idLanguage")[0]);
        }
        Session hs = NewHibernateUtil.getSessionFactory().openSession();
        hs.beginTransaction();
        Code code = (Code) hs.load(Code.class, codeId); 
        if(code != null){
            hs.delete(code);
        }else{
            System.out.println("no se instancio");
        }
        hs.getTransaction().commit();
        addActionMessage("Welcome");
        
        List<Language> list = hs.createQuery("from Language").list();
        languages = new ArrayList<>();
        list.stream().forEach((l) -> {
            languages.add(l.getIdlanguage());
        });
        
        listCode = hs.createQuery("from Code").list();
        if(!listCode.isEmpty()){
            listCode.get(0).getUser();
            listCode.get(0).getTitle();
            listCode.get(0).getLanguage();
        }
        hs.close();
        return SUCCESS;
    }

//// Getters and setters

    public CodeId getCodeId() {
        return codeId;
    }

    public void setCodeId(CodeId codeId) {
        this.codeId = codeId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set getRows() {
        return rows;
    }

    public void setRows(Set rows) {
        this.rows = rows;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<Code> getListCode() {
        return listCode;
    }

    public void setListCode(List<Code> listCode) {
        this.listCode = listCode;
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
    
    private Map<String, String[]> params;

    public Map<String, String[]> getParams() {
        return params;
    }

    public void setParams(Map<String, String[]> params) {
        this.params = params;
    }
    
    @Override
    public void setParameters(Map<String, String[]> maps) {
        this.params = maps;
    }
}
