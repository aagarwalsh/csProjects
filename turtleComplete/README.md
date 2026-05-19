# TurtleComplete

TurtleComplete is a small Java MVC drawing app that interprets turtle-graphics commands and renders the traced path in a Swing canvas. It supports simple movement commands, state save/restore, reusable shape commands, and a Koch snowflake demo.

## Features

- Interactive Swing UI with command entry and status feedback
- Turtle commands for `move`, `trace`, `turn`, `square`, `koch`, `save`, and `retrieve`
- Auto-centered drawing canvas that scales artwork to fit the window
- Separate model, command-controller, and view packages
- JUnit coverage for turtle movement, tracing, and state restoration behavior

## Run

Compile and launch the Swing app:

```sh
javac -d out/production/turtleComplete $(find src -name '*.java')
java -cp out/production/turtleComplete cs3500.turtle.TurtleRunner
```

Example commands to try in the app:

```text
square 120
koch 180 3
save turn 45 trace 100 retrieve turn -45 trace 100
```

## Project Structure

```text
src/cs3500/turtle/model         Core turtle position and heading model
src/cs3500/turtle/tracingmodel  Line-tracing model extensions
src/cs3500/turtle/control       Command parsing and MVC control flow
src/cs3500/turtle/view          Swing rendering and input UI
test/cs3500/turtle              Unit tests
```

## Notes

This project intentionally keeps the architecture lightweight and educational: commands are small classes, the model owns turtle state, and the Swing view only displays state supplied by the controller.
