Command line: mvn -Dbrowser=edge -Denvironment=qa clean install
By default regression.xml runs. If you want to run smoke tests, use -DsuitXml='smoke.xml' argument.
List of environments (-Denvironment):
 - qa;
 - dev.
List of browsers (-Dbrowser):
 - chrome(by default);
 - firefox;
 - edge.