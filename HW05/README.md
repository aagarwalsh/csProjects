# Easy Animator

Easy Animator is a Java/Swing animation project from Northeastern CS3500. It parses a simple animation text format, builds an animation model, and can render the result as text, SVG, a visual Swing animation, or an editor view.

## Features

- Model support for rectangles, ellipses, circles, squares, motions, keyframes, and canvas bounds
- Parser support for `canvas`, `shape`, `motion`, and `keyframe` input records
- Multiple views: textual, SVG, visual Swing, editor, and provider-adapted editor
- Controller actions for play, pause, restart, looping, speed changes, shape edits, and keyframe edits
- Adapter layer for integrating a provider view/model interface

## Run

From this folder, compile the application:

```sh
javac -d out $(find src -name '*.java')
```

Run a textual render using the bundled portfolio fixture folder:

```sh
java -cp out cs3500.animator.Excellence \
  -in ../animationFiles/smalldemo.txt \
  -view text
```

Export SVG:

```sh
java -cp out cs3500.animator.Excellence \
  -in ../animationFiles/smalldemo.txt \
  -view svg \
  -out smalldemo.svg \
  -speed 20
```

Launch the Swing animation:

```sh
java -cp out cs3500.animator.Excellence \
  -in ../animationFiles/smalldemo.txt \
  -view visual \
  -speed 20
```

Supported view names are `text`, `svg`, `visual`, `edit`, and `provider`.

## Project Structure

```text
src/cs3500/animator/model       Animation model, shapes, motions, and canvas
src/cs3500/animator/view        Text, SVG, visual, and editor views
src/cs3500/animator/controller  Controller logic for animation playback/editing
src/cs3500/animator/adapter     Adapters for the provider interface
src/cs3500/animator/provider    Provider-supplied interfaces and views
src/cs3500/animator/util        Animation file parser and builder interface
Test                            JUnit model tests
```

## UI/UX Improvement Ideas

- Add file-picker controls to the editor instead of requiring CLI file paths
- Replace text-field editing commands with structured forms for shapes and keyframes
- Add a timeline scrubber and current tick indicator
- Show validation messages inline for malformed keyframe or shape edits
- Add canvas zoom/pan controls for large animations
- Add export buttons for SVG and text output from the editor view
