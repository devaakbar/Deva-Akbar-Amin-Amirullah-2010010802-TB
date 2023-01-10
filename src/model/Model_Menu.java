package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.lang.Object.*;

public class Model_Menu {
    String icon;
    String name;
    MenuType type;
    
    // CONSTRUCTOR
    public Model_Menu(){
        
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }
    
    // GETTER dan SETTER
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
    
    
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/icon/" + icon + ".png"));
    }
    
    public static enum MenuType{
        TITLE, MENU, EMPTY
    }
}
