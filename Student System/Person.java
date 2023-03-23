public class Person {
    private String name;
    private int age;
    private int id;

    //person constructor

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    //Person methods

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name){
        this.name = name;

    }

}
