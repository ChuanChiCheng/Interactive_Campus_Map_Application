runTests: FrontendDeveloperTests.class
	java -jar junit5.jar -cp . --select-class=FrontendDeveloperTests

FrontendDeveloperTests.class: FrontendDeveloperTests.java CampusMapFrontend.class
	javac -cp .:junit5.jar FrontendDeveloperTests.java

CampusMapFrontend.class: CampusMapFrontend.java
	javac Building.java
	javac BuildingInterface.java
	javac GraphReaderFD.java
	javac GraphReaderInterface.java
	javac CampusMapAE.java
	javac CampusMapAEInterface.java
	javac CampusMapBD.java
	javac CampusMapBDInterface.java
	javac TextUITester.java
	javac -cp .:junit5.jar CampusMapFrontend.java

clean:
	rm *.class
