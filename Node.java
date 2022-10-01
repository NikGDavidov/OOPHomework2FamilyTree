package FamilyTree;

class Node {
    public Node(Person p1, Relationship re, Person p2) {
        this.p1 = p1;
        this.re = re;
        this.p2 = p2;
    }

    private Person p1;
    private Relationship re;
    private Person p2;

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }

    public Person getP1() {
        return p1;
    }

    public Relationship getRe() {
        return re;
    }

    public Person getP2() {
        return p2;
    }
}