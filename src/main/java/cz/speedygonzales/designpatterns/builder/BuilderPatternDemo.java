package cz.speedygonzales.designpatterns.builder;

public class BuilderPatternDemo {

    public static void main(String[] args) {

        Author author = new Author.Builder("some name").age(50).build();
        System.out.println(author.toString());
    }
}

class Author {

    private final String name;
    private final int age;

    private Author(Author.Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder {

        private String name = "default author name";

        private int age;

        public Builder(String name) {
            this.name = name;
        }

        public Author.Builder age(int age) {
            this.age = age;
            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}