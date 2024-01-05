package com.tryingOutNeo4j.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Node
public class User
{


        @Id
        @GeneratedValue
        private Long id;

        private String firstName;
        private String lastName;


        @Relationship(type = "INCLUDES",direction = INCOMING)
        @JsonIgnoreProperties("userAccount")
        private List<Account> userAccounts = new ArrayList<Account>();

        public User(){

        }



        public User(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }


        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public List<Account> getUserAccounts() {
                return userAccounts;
        }

        public void setUserAccounts(List<Account> userAccounts) {
                this.userAccounts = userAccounts;
        }
}
