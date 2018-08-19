set workspace = C:\Users\anests1a\eclipse-workspace\Forja
cd %workspace%
echo ==== mvn clean org.jacoco:jacoco maven plugin: prepare agent verify settings settings.xml ... ====
call mvn clean org.jacoco:jacoco maven plugin:prepare agent verify settings settings.xml

call mvn sonar:sonar 
  -Dsonar.organization=agent647-github
  -Dsonar.host.url=https://sonarcloud.io 
  -Dsonar.login=f44ec508ee574a7c68440cdf534d48eb79dd27a5
  
pause  