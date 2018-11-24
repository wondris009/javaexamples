package cz.speedygonzales.json;

import java.util.List;

/**
 * @author vondracek
 * @since 25.10.2015 14:51
 */
public class User {

    private String name;
    private int age = 0;
    private List<String> messages;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    public List<String> getMessages() {

        return messages;
    }

    public void setMessages(List<String> messages) {

        this.messages = messages;
    }

    @Override
    public String toString() {

        return "User{" + "name='" + name + '\'' + ", age=" + age + ", messages=" + messages + '}';
    }
}
