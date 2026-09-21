package au.edu.sydney.soft3202.project.model.pojo;

import java.util.List;

public class Classification {

    private List<String> iconClassIdentifier;

    public List<String> getIconClassIdentifier() {
        return iconClassIdentifier;
    }

    public void setIconClassIdentifier(List<String> iconClassIdentifier) {
        this.iconClassIdentifier = iconClassIdentifier;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "iconClassIdentifier=" + iconClassIdentifier +
                '}';
    }
}
