blog
====

Testing DAOs with Arquillian


The profile in pom.xml has to be added as a active maven profile in eclipse in order to run the tests:

<profiles>
    <profile>
      <id>JBOSS_AS_REMOTE_7.X</id>
      <dependencies>
        <dependency>
          <groupId>org.jboss.as</groupId>
          <artifactId>jboss-as-arquillian-container-remote</artifactId>
          <version>7.1.1.Final</version>
        </dependency>
      </dependencies>
    </profile>
  </profiles>
