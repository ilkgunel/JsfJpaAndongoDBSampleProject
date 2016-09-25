package com.ilkaygunel.jpaandmongodb.bean;

import com.ilkaygunel.jpaandmongodb.entity.Address;
import com.ilkaygunel.jpaandmongodb.entity.Person;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
@SessionScoped
public class ManagedBeanClass {

    private Person person;
    private Address address;

    private String operationMessage = "";

    public ManagedBeanClass() {
        person = new Person();
        address = new Address();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getOperationMessage() {
        return operationMessage;
    }

    public void setOperationMessage(String operationMessage) {
        this.operationMessage = operationMessage;
    }

    public void saveDataToDatabase() throws ParseException {
        person.setAddress(address);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mongodbPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            operationMessage = "Kayıt Başarı İle Eklendi!";
            GetRecordsBean getRecordsBean = new GetRecordsBean();
            getRecordsBean.refreshPersonList();
        } catch (Exception e) {
            operationMessage = "Kayıt eklenirken bir hata meydana geldi! Hata:"+e;
        }
    }
}
