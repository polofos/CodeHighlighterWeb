/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;

/**
 *
 * @author Pol
 */
public class ActionNewCode extends ActionSupport implements ApplicationAware {
 
    private String language;
    private Map<String, Object> app;
    
    public Map<String, Object> getApp() {
        return app;
    }

    public void setApp(Map<String, Object> app) {
        this.app = app;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
      
    
    
    
    public ActionNewCode() {
        
    }
    
    public String execute() throws Exception {
        if(language != null){
            app.put("language", language);
            return SUCCESS;
        } else{
            addActionError("Must choose language");
            return INPUT;
        }
        
    }

    @Override
    public void setApplication(Map<String, Object> map) {
        this.app = map;
    }
    
    
    
    
            

  
}
