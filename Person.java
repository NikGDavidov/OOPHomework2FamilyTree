package FamilyTree;

class Person {
    private String fullName;
    private int age;
    Sex sex;
    private int id;

    public String getFullName() {
        return fullName;
    }
    public int getAge(){
        return age;
    }
    public Person(){};

    public Person(int id,String fullName, Sex sex, int age) {
        this.id = id;
        this.fullName = fullName;
        this.sex = sex;
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("%d %s %s %d", this.id,this.fullName,this.sex, this.age);
    }
}
