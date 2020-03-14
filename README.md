# CrimeSpotter

### Building from Source
You need Java 1.8 and a bash-like shell.


### Building

Invoke the build at the root of the project

####Invoke the build at the root of the project
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
