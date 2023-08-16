package abstract_interface;

public class Tiger extends Animal {
    private String breed;

    public Tiger(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Grrrrr!");
    }

    public String getBreed() {
        return breed;
    }
}
