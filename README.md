Mars Rover Kava - Java
======================

A Java implementation of the Mars Rover Kata.
(Inspired by http://www.techinterviewpuzzles.com/2010/09/mars-rovers-thoughtworks-puzzles.html)

Context
-------

You joined a team that planned to land a rover squad on planet Mars.
The distance is so huge, the rover can not be remotely driven from Earth.
The answer is to send the command to a rover's control center that will drive each rover and wait after its report.

You're part of team responsible for the software development of the rover's and rover's control center firmwares.

Constraint
----------

### Expected input

```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

 1. The first line indicates the size of the map
 2. The second line indicates where the first rover lies in the map, and in which direction it's heading
 3. The third line it the command to send to the rover
 4. then a new sequence of 2 line for the second rover

### Expected output

```
1 3 N
5 1 E
==========
```
 1. One line per rover indicating its new coordinate and the new heading situation
 2. One terminal line `==========` to mark the end of transmission
