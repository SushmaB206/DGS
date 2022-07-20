package com.dgs.dgsQuery.datafetchers;

import com.dgs.dgsQuery.datastore.PersonStore;
import com.dgs.dgsQuery.domain.Person;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class PersonDataFetcher {

    @DgsQuery
    public List<Person> allPersons(){
        return PersonStore.getPersonList();
    }

    @DgsQuery
    public Person searchPerson(@InputArgument Integer searchPersonId){
        return PersonStore.getPersonList().stream().filter(record -> record.getPersonId().equals(searchPersonId)).findFirst().get();
    }
}
