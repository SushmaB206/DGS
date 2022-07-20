package com.dgs.dgsQuery.datastore;

import com.dgs.dgsQuery.domain.Person;
import com.dgs.dgsQuery.domain.PersonAddress;

import java.util.ArrayList;
import java.util.List;

public class PersonStore {
    static List<Person> personList = new ArrayList<>();

    public static List<Person> getPersonList(){
        if(personList.isEmpty()){
            for(int i=0;i<5;i++){
                PersonAddress personAddress = new PersonAddress("streetName"+i, "houseNumber"+i, "city"+i, "country"+i);
                Person person= new Person(i,"personName"+i, personAddress);
                personList.add(person);
            }
        }
        return personList;
    }
}
