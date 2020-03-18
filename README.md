# CrimeSpotter
## Installing MySQL
First use homebrew to install:
#### Brew installation
----
    $ brew install mysql
----
#### Run secure installation
----
    $ mysql_secure_installation
----
1. Would you like to setup VALIDATE PASSWORD component? No
2. Set new password
3. Disallow root login remotely? Yes
4. Remove test database and access to it? Yes
5. Reload privilege tables now? Yes

Running into trouble?
https://stackoverflow.com/questions/4359131/brew-install-mysql-on-macos/33924648#33924648
- Follow this guide and remove all your mysql instances, re-install mysql and run the above configuration again.

#### Installing the Database Management Application
Personally I use Sequel Pro, you can install any other tool you like.
- Here is SQL Pro: https://www.sequelpro.com/
#### Connect to your database with:
    Host: 127.0.0.1
    Username: root
    Password: "your_password"

#### Creating a a new Database
On the top left drop down in sequel pro, click "Add a new database"
- Create a new database with the name "CrimeSpotter" and set all the default options.


## Installing Spring Framework and Maven
You need Java 11 and a bash-like shell.


#### Building

Invoke the build at the root of the project

#### Invoke the build at the root of the project
----
    $ ./mvnw clean install
----

The project also includes a number of longer-running verification tests. They
can be built and run using the `verification` profile:

----
    $ ./mvnw -Pverification clean install
----

The project's other tests are not included in the `verification` profile. All of
the project's tests can be run using the `full` profile:

----
    $ ./mvnw -Pfull clean install
----

If building `start-client` fails, you may have an outdated cache that can be deleted as
follows:

----
    $ cd start-client
    $ rm -rf .cache node_modules
----


### Running the app locally
As long as you've built the project beforehand (in particular `start-client`), you can
easily start the app as any other Spring Boot app:

----
    $ cd start-site
    $ ../mvnw spring-boot:run
----

### Running the app in an IDE
You should be able to import the project into your IDE with no problems. Once there you
can run the `StartApplication` from its main method and debug it. If you also need to
work on the library, adding the `initializr` project in your workspace would make sure
to reload the app whenever you make any change.

This is the recommended way to operate while you are developing the application,
especially the UI.


## Troubleshooting
### Timezone issue

"java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc timezone value if you want to utilize timezone support."

#### Run this in MySQL:

----
    SET GLOBAL time_zone = '+3:00';
----
