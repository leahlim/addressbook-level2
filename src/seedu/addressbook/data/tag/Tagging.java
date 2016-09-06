package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
    
    private final Person person;
    private final Tag tag;
    private String operation;
    
    public Tagging(Person person, Tag tag, String operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(operation)
               .append(" ")
               .append(person.getName())
               .append(" ")
               .append(tag);
        return builder.toString();
    }

}
