package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses has to be in this format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "(.+),(.+),(.+),(.+)";
    public static final int ADDRESS_SIZE = 4;

    //public final String value;
    private boolean isPrivate;
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    
    class Block {
        private String block;
        
        public Block(String block) {
            this.block = block;
        }
        
        public String getBlock() {
            return block;
        }
    }
    
    class Street {
        private String street;
        
        public Street(String street) {
            this.street = street;
        }
        
        public String getStreet() {
            return street;
        }
    }
    
    class Unit {
        private String unit;
        
        public Unit(String unit) {
            this.unit = unit;
        }
        
        public String getUnit() {
            return unit;
        }
    }
    
    class PostalCode {
        private String postalCode;
        
        public PostalCode(String postalCode) {
            this.postalCode = postalCode;
        }
        
        public String getPostalCode() {
            return postalCode;
        }
    }

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String[] addressParts = splitAddress(address);
        if (!isValidAddress(address) || addressParts.length != ADDRESS_SIZE) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        //this.value = address;
        block = new Block(addressParts[0]);
        street = new Street(addressParts[1]);
        unit = new Unit(addressParts[2]);
        postalCode = new PostalCode(addressParts[3]);
    }
    
    public String[] splitAddress(String address) {
        return address.split(", ");
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}