Demo project for the algorand-spring-boot-starter project. The project is not audited and should not be used in a production environment


* Main project is algorandStarterdemo
* Create account at https://developer.purestake.io/ that will give you API key.
* Change API key in AlgorandController.java file at

```
 String[] values = {"Your API Key that you will get after creating account on https://developer.purestake.io/"};
```

* Get the depedency locally

1. Clone repo https://github.com/babcoccl/algorand-spring-boot-starter.git
2. Run mvn clean package
3. mvn install:install-file -Dfile=<PATH TO YOUR TARGET/JAR>\algorand-spring-boot-starter-1.0-SNAPSHOT.jar -DgroupId=org.algorand -DartifactId=algorand-spring-boot-starter -Dversion=1.0-SNAPSHOT  -Dpackaging=jar -DgeneratePom=true
