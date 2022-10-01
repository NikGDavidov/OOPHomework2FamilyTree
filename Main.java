package FamilyTree;


public class Main {
    //Используйте предыдущие задачи из прошлого домашнего задания. Необходимо гарантированно продумать иерархию компонент и взаимодействия их между собой.
//Обеспечить переход от использования явных классов в сторону использования абстрактных типов.
// Т е работаем не с:
//конкретным экземпляром генеалогического древа, а с интерфейсом “ генеалогическое древо”
//
//Под исследованием передачу конкретного экземпляра класса узла и отношения
//Передать узел (сына) и найти его отца
//Передать узел (дедушка) и найти его внуков
//
//Необязательно: Продумать возможность ухода он конкретных "котиков", к интерфейсу “котик”, лучше уйти от взаимодействия с конкретными питомцами и повысить уровень абстракции до взаимодействия с котиком, собачкой или хомяком т е с интерфейсом “животное”
    public static void main(String[] args) {
        Person irina = new Person(1, "Irina", Sex.FEMALE, 56);
        Person vasya = new Person(2, "Vasiliy", Sex.MALE, 25);
        Person masha = new Person(3, "Maria", Sex.FEMALE, 27);
        Person jane = new Person(4, "Jana", Sex.FEMALE, 3);
        Person ivan = new Person(5, "Ivan", Sex.MALE, 5);

        GeoTree gt = new MyGeoTree();
        gt.append(irina, vasya);
        gt.append(irina, masha);
        gt.append(vasya, jane);
        gt.append(vasya, ivan);

        System.out.println(new Research1(gt).findRels(irina, Relationship.PARENT));//выборка детей
        System.out.println(new Research1(gt).findRels(ivan, Relationship.CHILD));//выборка родителей
        System.out.println(new FindGrands(gt).findGrands(irina, Relationship.GRANDPARENT));//выборка внуков
        System.out.println(new FindGrands(gt).findGrands(jane, Relationship.GRANDCHILD));//выборка дедушек и бабушек

        System.out.println(new Research2(gt).byAge(30, '<'));//выборка по возрасту
        System.out.println(new Research3(gt).reAndAge(irina, Relationship.PARENT, 27, '<'));//выборка по детям и их возрасту
        FileOutput.fileWrite(new Research2(gt).byAge(40, '<'));// запись выбоорки в файл

    }
}
