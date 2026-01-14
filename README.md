# MockProject - Hello World (Java + JUnit)

Build and run tests:
- mvn test
- mvn package
- java -jar target/mockproject-1.0-SNAPSHOT.jar

## Where the .m2 directory exists

- Default locations
  - Linux / macOS: ~/.m2
  - Windows: C:\Users\<your-username>\.m2

- To print the local repository path Maven actually uses:
  - mvn help:evaluate -Dexpression=settings.localRepository -q -DforceStdout

- Useful commands
  - List the folder (Linux/macOS): ls -la ~/.m2
  - List the folder (Windows CMD): dir %USERPROFILE%\.m2

- settings.xml locations
  - User settings: ~/.m2/settings.xml
  - Global settings: $MAVEN_HOME/conf/settings.xml

- To change the local repository
  - Add or edit <localRepository>path</localRepository> in ~/.m2/settings.xml
  - Or set MAVEN_USER_HOME to a different folder before running Maven
