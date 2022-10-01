package FamilyTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
abstract class Research {
    ArrayList<Node> tree;
    public Research(GeoTree myGeoTree) {
        tree = (ArrayList<Node>) myGeoTree.getTree();
    }
    abstract Collection<Person> findRels(Person p, Relationship re);

}
//выборка по детям/родителям
class Research1 extends Research {

    public Research1(GeoTree myGeoTree) {
        super(myGeoTree);
    }

    public ArrayList<Person> findRels(Person p, Relationship re) {
        ArrayList<Person> result = new ArrayList<>();
        for (Node t : tree) {
            if (t.getP1().getFullName() == p.getFullName() && t.getRe() == re) {
                result.add(t.getP2());
            }
        }
        return result;
    }
//    public Set<Person> byCond(Person temp, boolean cut){
//        Set<Person> result = new HashSet<>();
//        for (Node t : tree){
//            temp = t.getP1();
//            if (cut){result.add(temp);}
//        }
//        return result;
//    }
}
//выборка по возрасту
class Research2 extends Research1 {
    public Research2(GeoTree myGeoTree) {
        super(myGeoTree);
    }

    public Set<Person> byAge(int age, char sign) {
        Set<Person> result = new HashSet<>();
        for (Node t : tree) {
            switch (sign) {
                case '>': {
                    if (t.getP1().getAge() > age) {
                        result.add(t.getP1());
                    }
                    break;
                }
                case '=': {
                    if (t.getP1().getAge() == age) {
                        result.add(t.getP1());
                    }
                    break;
                }
                case '<': {
                    if (t.getP1().getAge() < age) {
                        result.add(t.getP1());
                    }
                    break;
                }
            }
        }
        return result;
    }
}
//выборка детям/родителям и по их возрасту
class Research3 extends Research2{
    public Research3(GeoTree myGeoTree) {
        super(myGeoTree);
    }
    public Set <Person> reAndAge (Person p, Relationship re, int age, char sign){
        ArrayList <Person> res1 = findRels(p, re);
        Set<Person> res2 = byAge(age, sign);
        res2.retainAll(res1);
        return res2;
    }
}
//поиск внуков и дедушек
class FindGrands extends Research1 {
    public FindGrands(GeoTree myGeoTree){
        super (myGeoTree);
    }

    public ArrayList <Person>findGrands (Person p, Relationship re){
        ArrayList <Person> result = new ArrayList<>();
        ArrayList <Person> temp;
        Relationship r;
        if (re == Relationship.GRANDPARENT) {r = Relationship.PARENT;}
        else if (re == Relationship.GRANDCHILD){r = Relationship.CHILD;}
        else return null;
        temp = findRels(p,r);
        for (Person p1 : temp){result.addAll(findRels(p1,r)); }
        return result;
    }
}

