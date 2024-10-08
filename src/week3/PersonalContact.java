package week3;

public class PersonalContact extends Contact{
    private String relationship;

    public PersonalContact(String name, String phoneNumber, String relationship) {
        super(name, phoneNumber);
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public String toString() {
        return "이름: " + super.getName() + ", 전화번호: " + super.getPhoneNumber() + ", 관계: " + relationship;
    }
}
