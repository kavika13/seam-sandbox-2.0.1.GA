Instructions to build:

- Connect to da Intarwebs (or have a corporate local repository for all dependencies)
- Install Maven (Probably older version - [2.2.1](http://www.apache.org/dyn/closer.cgi?path=/maven/binaries/apache-maven-2.2.1-bin.zip))
- Install (unzip) JBoss AS ([4.2.2.GA](http://sourceforge.net/projects/jboss/files/JBoss/JBoss-4.2.2.GA/))
- Install [MySql](http://dev.mysql.com/downloads/)
- Install [MySql Workbench](http://dev.mysql.com/downloads/workbench/5.2.html)
- Install [MySql connector](http://dev.mysql.com/downloads/connector/j/) to `<jboss-root>/server/default/lib`
- Create a `sandbox_db` schema in MySql
- If necessary, set up the appropriate Maven repository configuration under `<user-profile>/.m2/settings.xml`
  - Default repositories are configured in the root `pom.xml` file, but you can create mirrors to override them via mirrors in `settings.xml`
- Install [GitHub for Windows](http://windows.github.com/) or [Git Extensions](http://code.google.com/p/gitextensions/)
- Get [this source code](https://github.com/kavika13/seam-sandbox-2.0.1.GA)
- Copy `<source-code-base>/src/main/filters/filter-prod.properties` to `filter-dev.properties` in the same directory
- Edit `filter-dev.properties` to provide the appropriate settings, such as:
  - Where you installed JBoss AS
  - Change `hibernate.hbm2ddl.auto` to `=create-drop`
  - Change the database `ds.user.name` and `ds.password`
- Run `mvn clean install -Penv-dev` (or `build.cmd`)

The application will be copied to your application server, and ready for it to auto deploy.  Run JBoss AS
