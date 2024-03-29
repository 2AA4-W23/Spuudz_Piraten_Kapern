# A1 - Piraten Karpen

  * Author: Matthew Bradbury
  * Email: bradbm1@mcmaster.ca

## Build and Execution
  * To compile the project:
    * `mvn compile`
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
  * To enable logging statements:
    * `in the file ./main/log4j2.xml, change the root level from "OFF" to "ALL"`

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  D | 01/01/23 |  01/16/23 |
| x   | F02 | Roll eight dices  |  D | 01/16/23  | 01/16/23 | 
| x   | F03 | Play 42 games each simulation  |  D  |  01/16/23 | 01/16/23 |
| x   | F04 | End the turn when the player obtains 3 skulls | D | 01/16/23 | 01/16/23 |
| x   | F05 | Player chooses which dice to keep randomly | D | 01/16/23 | 01/16/23 | 
| x   | F06 | Score points: count num of gold coins and diamonds and \*100| D | 01/16/23 | 01/16/23 |
| x   | F07 | Simulation ends when one player's score exceeds 6000 | D | 01/16/23 | 01/16/23 |
| x   | F08 | Calculate and display each player's win percentage | D | 01/16/23 | 01/16/23 |  
| x   | F09 | Score points: 'num' of a kind | D | 01/18/23 | 01/19/23 |
| x   | F10 | New player strategy: Maximize Combos | D | 01/20/23 | 01/20/23 |
| x   | F11 | Allow strategy specification from command line | D | 01/20/23 | 01/20/23 |
| x   | F12 | Implement deck of cards, 6 sea battle and 29 nop, 1 card drawn before roll | D | 01/26/23 | 01/27/23 |
| x   | F13 | Implement sea battle card effect | D | 01/26/23 | 01/27/23|
| x   | F14 | Provide new strategy revolving around sea battle card effect | D | 01/26/23 | 01/27/23 | 
| x   | F15 | Add Monkey Business Card to deck | D | 01/28/23 | 01/28/23 | 
| x   | F16 | Implement Monkey Business logic to scoring system | D | 01/28/23 | 01/28/23 | 
| x   | F17 | Update strategy for monkey business card | D | 01/28/23 | 01/29/23 |
| ... | ... | ... |

