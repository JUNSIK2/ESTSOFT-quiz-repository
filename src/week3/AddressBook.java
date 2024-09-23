package week3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("연락처가 비어있습니다.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void searchContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름을 입력해 주세요: ");
        String name = scanner.next();
        boolean s = true;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
                s = false;
            }
        }
        if (s){
            System.out.println("연락처를 찾을 수 없습니다.");
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        boolean stop = true;
        try (Scanner scanner = new Scanner(System.in)) {
            while (stop) {
                System.out.println("1. 비즈니스 연락처 추가\n2. 개인 연락처 추가\n3. 연락처 출력\n4. 연락처 검색\n5. 종료\n메뉴를 선택해주세요: ");
                switch (scanner.nextInt()) {
                    case 1 -> {
                        System.out.print("이름을 입력해 주세요: ");
                        String name = scanner.next();
                        System.out.print("전화번호를 입력하세요: ");
                        String phoneNumber = scanner.next();
                        System.out.print("회사명을 입력하세요: ");
                        String company = scanner.next();
                        addressBook.contacts.add(new BusinessContact(name, phoneNumber, company));
                        System.out.println();
                    }
                    case 2 -> {
                        System.out.print("이름을 입력해 주세요: ");
                        String name = scanner.next();
                        System.out.print("전화번호를 입력하세요: ");
                        String phoneNumber = scanner.next();
                        System.out.print("관계를 입력하세요: ");
                        String relationship = scanner.next();
                        addressBook.contacts.add(new PersonalContact(name, phoneNumber, relationship));
                        System.out.println();
                    }
                    case 3 -> addressBook.displayContacts();
                    case 4 -> addressBook.searchContact();
                    case 5 -> {
                        System.out.println("프로그램을 종료합니다.");
                        stop = false;
                    }
                    default -> System.out.println("정확한 숫자를 입력해주세요!\n");
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("숫자를 입력해 주세요!");
        }
    }
}
