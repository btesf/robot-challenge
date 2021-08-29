### Robot Challenge

This is a Spring Boot application that runs at a port number specified at the `server.port` property in `application.properties` file.

It exposes an endpoint at `/move` that accepts a `POST` request which takes a JSON payload such as the following: 
```
{
    "grid" : {
        "cols" : 3,
        "rows" : 2
    },
    "initial_location": {
        "coordinate" : {
            "x" : 2,
            "y" : 3
        },
        "direction" : "NORTH"
    },
    "commands" : "commands"
}
```
`grid` : Size of the "grid"/"board"

`initial_location` : Starting position of the robot.

`commands` : List of commands separated by new lines. (See the list of commands below).

#### Commands
`POSITION <x> <y> <EAST|WEST|NORTH|SOUTH>`

`FORWARD <steps>`

`WAIT`
 
`TURNAROUND`
 
`NORTH`

`EAST`

`SOUTH`

`WEST`

#### Testing the application
In the application landing page, put the commands separated by new lines and click the "submit' button. Then the robot should be placed at a final position specified by the commands.

e.g. Submitting the next set of commands should move the robot at `(x, y)` => `(1, 3)` facing `WEST` direction.

```
POSITION 1 3 EAST 
FORWARD 3
WAIT 
TURNAROUND 
FORWARD 1 
FORWARD 2 
```