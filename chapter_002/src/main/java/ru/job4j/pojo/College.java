package ru.job4j.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class College {

    public static void main(String[] args) throws ParseException {
        Student student = new Student();
        student.setName("Michael");
        student.setSurname("Dedun");
        student.setPatronymic("Alexandrovich");
        student.setGroup("iu6-65b");
        student.setReceiptDate(new SimpleDateFormat("dd.MM.yyyy").parse("01.09.2017"));
        System.out.println("Имя : " + student.getName() + "\nФамилия: " + student.getSurname() + "\nОтчество: " + student.getPatronymic() + "\nГруппа: " + student.getGroup() + "\nДата поступления: " + student.getReceiptDate());
    }

}
