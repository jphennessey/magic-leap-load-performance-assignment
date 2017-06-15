# Magic Leap Quality Engineer Assignment (Test 3)
### Demonstrate the ability to write a test program.

jphennessey,  14 June 2017

### Test 3:
- [x] wrote a program to test page load performance
   - tested 100 gets of the Magic Leap homepage
- [x] output basic report(s)
   - included the min, max, and average page load times
### Considerations:
- ensuring that the page load was complete 
  - used compound explicit waits to ensure that JavaScript and jQuery actions were complete
- ensuring that each load was performed in a clean browser environment
  - used incognito mode 
  - used Chromedriver capability setting for "ensuring clean session"
- providing reports with performance data points
  - 2 reports are generated:
    - a line graph showing the millesecond load time for each of the 100 loads
    - a simple bar graph with the requested min, max, and average statistics

### Running the Tests (based on Mac OS):
##### Prerequisites
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)
- [maven](http://maven.apache.org/)
   - available via "brew install maven"
- [git](https://git-scm.com/downloads)
   - available via "brew install git"
- [chromedriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
   - NOTE: use "brew install chromedriver" or ensure it is accessible on $PATH 
##### Steps 
- git clone https://github.com/jphennessey/magic-leap-load-performance-assignment.git
- mvn clean compile
- mvn test 
- open output/LoadTimePlot.jpeg
- open output/LoadTimeStats.jpeg

### Sample reports:
- Load Time Line Graph
![Load Time Line Graph report missing](../master/output/LoadTimePlot.jpeg)
- Load Time Statistics
![Load Time Statistics report missing](../master/output/LoadTimeStats.jpeg)
