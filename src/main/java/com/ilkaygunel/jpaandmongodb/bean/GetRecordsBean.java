package com.ilkaygunel.jpaandmongodb.bean;

import com.ilkaygunel.jpaandmongodb.entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

@ManagedBean
@SessionScoped
public class GetRecordsBean {

    List<Person> personList = new ArrayList<Person>();

    @PostConstruct
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mongodbPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        personList = query.getResultList();
    }

    public List<Person> getPersonList() {
        for (Person person : personList) {
            System.out.println(person.getName());
            System.out.println(person.getSurname());
        }
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void refreshPersonList() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mongodbPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
        personList = query.getResultList();
    }
}
