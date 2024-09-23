package week3;

public class BusinessContact extends Contact{
    private String company;

    public BusinessContact(String name, String phoneNumber, String company) {
        super(name, phoneNumber);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "이름: " + super.getName() + ", 전화번호: " + super.getPhoneNumber() + ", 회사명: " + company;
    }
}
