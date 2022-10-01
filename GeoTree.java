package FamilyTree;

import java.util.ArrayList;
import java.util.Collection;

public interface GeoTree {
    public void append(Person p1, Person p2);

    public Collection getTree();
}