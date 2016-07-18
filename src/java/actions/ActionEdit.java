/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import entity.Code;
import entity.CodeId;
import entity.Row;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Pol
 */
public class ActionEdit extends ActionSupport implements ApplicationAware, ParameterAware {
    
    private List<String> rowList;
    private String input;
    private String output;
    private String title;
    private CodeId codeId;
    

    public List<String> getRowList() {
        return rowList;
    }

    public void setRowList(List<String> rowList) {
        this.rowList = rowList;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
       
    
    public ActionEdit() {
    }
    
    @Override
    public String execute() throws Exception {
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
        
        rowList = new ArrayList<>();
        Session hs = NewHibernateUtil.getSessionFactory().openSession();
        String hql = "from Code C where C.id = :codeid";
        Query q = hs.createQuery(hql);
        q.setParameter("codeid", codeId);
        Code code = (Code) q.uniqueResult();
        //System.out.println(code.toString());
        List <Row> listaRenglon = OrdenarRenglones(new ArrayList <>(code.getRows()));
        listaRenglon.stream().forEach((renglon) -> {
            rowList.add(renglon.getContent());
            System.out.println(renglon.getContent());
        });
        app.put("title", code.getTitle());
        app.put("language", code.getLanguage().getIdlanguage());
        app.put("input", code.getInput());
        app.put("output", code.getOutput());
        title = code.getTitle();
        input = code.getInput();
        output = code.getOutput();
        return SUCCESS;
    }

    public List<Row> OrdenarRenglones(List <Row> l){
        Row[] ordenados = new Row[l.size()];
        ordenados = l.toArray(ordenados);
        Row rt = new Row();
        int i=0;
        while(i<l.size()-1){
            if(ordenados[i].getId().getIdrow() > ordenados[i+1].getId().getIdrow()){
                rt=ordenados[i+1];
                ordenados[i+1]=ordenados[i];
                ordenados[i]=rt;
                i=0;
            } else{
                i++;
            }
            
        }
        List<Row> l1 = new ArrayList<Row>();
        l1 = Arrays.asList(ordenados);
        return l1;
    }
    
    
    private Map<String, Object> app;
    
    public Map<String, Object> getApp() {
        return app;
    }

    public void setApp(Map<String, Object> app) {
        this.app = app;
    }
    
    @Override
    public void setApplication(Map<String, Object> map) {
        this.app = map;
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
