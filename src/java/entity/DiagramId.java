package entity;
// Generated 30/06/2016 02:12:41 AM by Hibernate Tools 4.3.1



/**
 * DiagramId generated by hbm2java
 */
public class DiagramId  implements java.io.Serializable {


     private int iddiagrama;
     private int codeIdcode;
     private String codeUserUsername;
     private String codeLanguageIdlanguage;

    public DiagramId() {
    }

    public DiagramId(int iddiagrama, int codeIdcode, String codeUserUsername, String codeLanguageIdlanguage) {
       this.iddiagrama = iddiagrama;
       this.codeIdcode = codeIdcode;
       this.codeUserUsername = codeUserUsername;
       this.codeLanguageIdlanguage = codeLanguageIdlanguage;
    }
   
    public int getIddiagrama() {
        return this.iddiagrama;
    }
    
    public void setIddiagrama(int iddiagrama) {
        this.iddiagrama = iddiagrama;
    }
    public int getCodeIdcode() {
        return this.codeIdcode;
    }
    
    public void setCodeIdcode(int codeIdcode) {
        this.codeIdcode = codeIdcode;
    }
    public String getCodeUserUsername() {
        return this.codeUserUsername;
    }
    
    public void setCodeUserUsername(String codeUserUsername) {
        this.codeUserUsername = codeUserUsername;
    }
    public String getCodeLanguageIdlanguage() {
        return this.codeLanguageIdlanguage;
    }
    
    public void setCodeLanguageIdlanguage(String codeLanguageIdlanguage) {
        this.codeLanguageIdlanguage = codeLanguageIdlanguage;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DiagramId) ) return false;
		 DiagramId castOther = ( DiagramId ) other; 
         
		 return (this.getIddiagrama()==castOther.getIddiagrama())
 && (this.getCodeIdcode()==castOther.getCodeIdcode())
 && ( (this.getCodeUserUsername()==castOther.getCodeUserUsername()) || ( this.getCodeUserUsername()!=null && castOther.getCodeUserUsername()!=null && this.getCodeUserUsername().equals(castOther.getCodeUserUsername()) ) )
 && ( (this.getCodeLanguageIdlanguage()==castOther.getCodeLanguageIdlanguage()) || ( this.getCodeLanguageIdlanguage()!=null && castOther.getCodeLanguageIdlanguage()!=null && this.getCodeLanguageIdlanguage().equals(castOther.getCodeLanguageIdlanguage()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIddiagrama();
         result = 37 * result + this.getCodeIdcode();
         result = 37 * result + ( getCodeUserUsername() == null ? 0 : this.getCodeUserUsername().hashCode() );
         result = 37 * result + ( getCodeLanguageIdlanguage() == null ? 0 : this.getCodeLanguageIdlanguage().hashCode() );
         return result;
   }   


}

