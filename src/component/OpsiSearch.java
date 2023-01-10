package component;


import javax.swing.Icon;

public class OpsiSearch {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public OpsiSearch(String name, Icon icon) {
        this.name = name;
        this.icon = icon;
    }

    public OpsiSearch() {
    }

    private String name;
    private Icon icon;
}

