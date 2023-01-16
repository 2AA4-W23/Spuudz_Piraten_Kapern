# A1 - Piraten Karpen

  * Author: Matthew Bradbury
  * Email: bradbm1@mcmaster.ca

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * A feature is done when it is fully functional and interacts with the rest of the project without error.

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/01/23 |  01/16/23 |
| x   | F02 | Roll eight dices  |  D | 01/16/23  | 01/16/23 | 
| x   | F03 | Play 42 games each simulation  |  P  |   |
| x   | F04 | End the turn when the player obtains 3 skulls | D | 01/16/23 | 01/16/23 |
| x   | F05 | Player chooses which dice to keep randomly | D | 01/16/23 | 01/16/23 | 
| x   | F06 | Score points: count num of gold coins and diamonds and \*100| D | 01/16/23 | 01/16/23 |
| x   | F07 | Simulation ends when one player's score exceeds 6000 | D | 01/16/23 | 01/16/23 |
| x   | F08 | Calculate and display each player's win percentage | P | | 
| ... | ... | ... |

