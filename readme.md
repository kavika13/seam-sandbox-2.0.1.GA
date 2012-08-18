Instructions to build:

- Connect to da Intarwebs (or have a corporate local repository for all dependencies)
- Install Maven
- Install (unzip) JBoss AS (4.2.2.GA)
- Install MySql
- Create a sandbox_db schema in MySql
- Set up the appropriate Maven repository configuration under ~/.m2/settings.xml
  - Probably:
    - http://repository.jboss.org/nexus/content/groups/public (plain)
    - http://download.java.net/maven/2 (plain)
    - http://repository.jboss.org/nexus/content/groups/public (plugins)
- Install Git
- Get this source code
- Copy <source-code-base>/src/main/filters/filter-prod.properties to filter-dev.properties in the same directory
- Edit filter-dev.properties to provide the appropriate settings, such as:
  - Where you installed JBoss AS
  - Change hibernate.hbm2ddl.auto to =create-drop
  - Change the database ds.user.name and ds.password
- Run `mvn clean install -Penv-dev` (or build.cmd)

The application will be copied to your application server, and ready for it to auto deploy.  Run JBoss AS
