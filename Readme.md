Overview
==========
This application allows user to select a city from the drop-down for which current weather information is made available in a table.
The application uses internet based service called open weather map to fetch the weather data

How to deploy
==========
Run the following statement on a shell and it should start tomcat server on port 8080.
```
mvn clean spring-boot:run
```
Once tomcat is running you can use following APIs/pages to see the result

APIs
==========
```
/weather/{city}
```
Return a json object containing weather information such as weather condition, temperature and wind speed of the city passed as parameter.

```
/allcities
```
Returns a json object containing a collection of possible cities which for which weather information can be requested.

Pages
==========
```
/index.html
```
Open this page to view a tabular representation of few weather attributes.
This page contains a drop down selection box to allow user select one of the available cities.
You can add more cities to the list by adding them in cities.txt file in resources folder.

Tools/Languages Used
==========

The microservices are written in <strong>java using spring-boot framework</strong> and the front end is written using <strong>AngularJS</strong>.
