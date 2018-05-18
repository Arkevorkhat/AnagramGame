package GameLogicAna;

import java.io.Serializable;

public class UserAna {
    String username;
    String password;
    boolean parent;
    String parentName;
    
    public UserAna(String username, String password, boolean parent, String parentName) {
    	this.username = username;
    	this.password= password;
    	 this.parent= parent;
    	 this.parentName= parentName;
    			
    			
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   public boolean isParent() {
	   return parent;
   }
   
   public String getParentName() {
	   return parentName;
   }
   
}

