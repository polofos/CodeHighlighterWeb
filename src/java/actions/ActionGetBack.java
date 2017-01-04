/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import entity.Code;
import entity.User;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;

/**
 *
 * @author mery
 */
public class ActionGetBack extends ActionSupport implements SessionAware {
    
    private String username, password;
    private List<String> languages; 
        private Session hibernateSession;
    private User user;
    private List<Code> listCode;
    public ActionGetBack() {
    }
    
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    private Map<String, Object> sesion;

    public Map<String, Object> getSesion() {
        return sesion;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        
    }
    
}
