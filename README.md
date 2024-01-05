<h1>Neo4J and Spring Demo</h1>

<body>

<div>
  <h2>Intro:</h2>
  <p>
    This project has 5 features. Create Users, Create Accounts, view Users, view Accounts, and link Users to Accounts. The Users and Accounts are two types of Node Entities within a Neo4j graph database. You can access these features on localhost:8080/ within your web browser. It is a Java SpringBoot application that uses Neo4jRepository and Thymeleaf. 
  </p>
</div>
<div>
  <h2>
    Controllers
  </h2>
  <ul>
    <li>
      <h3>AccountController.java</h3>
      <p>
        Handles POST and GET requests for localhost:8080/accounts/. Features include displaying all Accounts from the Neo4j database. Creating Accounts and saving them to the database. Searching for Accounts using /{name}. As well as linking Users to Accounts in database.
      </p>
    </li>
    <li>
      <h3>UserController.java</h3>
      <p>
         Handles POST and GET requests for localhost:8080/users/. Features include displaying all Users from the Neo4j database. Creating Users and saving them to the database. As well as searching for Users using /{lastName} in database.
      </p>
    </li>
    <li>
      <h3>HomeController.java</h3>
      <p>
        Handles GET requests for the index.html whick contains links to other endpoints so you dont have to type them into url.
      </p>
    </li>
  </ul>
</div>

<div>
  <h2>
    HTML Pages
  </h2>
  <ul>
    <li>
      <h3>accountsList.html</h3>
      <p>
        Displays Accounts fetched from database using Thymeleaf.
      </p>
    </li>
    <li>
      <h3>createAccount.html</h3>
      <p>
        Page where a user can create an Account that is saved to database.
      </p>
    </li>
    <li>
      <h3>createUser.html</h3>
    <p>
      Page where a user can create a User that is saved to database.
    </p>
    </li>
    <li>
      <h3>index.html</h3>
      <p>
        Simple home page with some links to make navigating to different pages easier.
      </p>
    </li>
    <li>
      <h3>linkUserToAccount.html</h3>
      <p>
        A user can input the id of an Account and a User and it creates an INCLUDES relationship from Account to User in database.
      </p>
    </li>
    <li>
      <h3>userList.html</h3>
      <p>
        DIsplays Users fetched from database using Thymeleaf.
      </p>
    </li>
  </ul>
</div>

<div>
  <h2>
    How To Download
  </h2>
  <p>
    Clone the repository onto your machine.
  </p>
  <p>
    Start a docker container with a Neo4j db.
</p>
    <p>
    Within demo/src/main/resources/application.properties configure your bolt uri, username, password, and database.
</p>
    <p>
    Run demo/src/main/java/com/tryingOutNeo4j/demo/LearningNeo4jApplication.java .
</p>
    <p>
    Open web browser to localhost:8080/home/
</p>
    <p>
    Enjoy!
    </p>
  </p>
</div>
  
</body>
