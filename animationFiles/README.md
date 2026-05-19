# Animation Files

This folder contains CS3500 animation fixtures and parser utilities for the Easy Animator file format. The text files describe animated shapes, motions, and canvas bounds; the SVG files are sample rendered outputs.

## Contents

- `cs3500/animator/util/AnimationReader.java`: whitespace/comment-tolerant parser for animation text files
- `cs3500/animator/util/AnimationBuilder.java`: builder interface used by animation models or exporters
- `smalldemo.txt`, `buildings.txt`, `hanoi.txt`, `toh-*.txt`, `big-bang-big-crunch.txt`: sample animation inputs at different sizes
- `simple-example.svg`, `simple-example-with-loopback.svg`: example SVG output
- `test/cs3500/animator/util/AnimationReaderSmokeTest.java`: no-framework smoke test for parser verification

## Format

Animation input files use a compact text format:

```text
canvas <left> <top> <width> <height>
shape <name> <type>
motion <name> <t1> <x1> <y1> <w1> <h1> <r1> <g1> <b1> <t2> <x2> <y2> <w2> <h2> <r2> <g2> <b2>
keyframe <name> <t> <x> <y> <w> <h> <r> <g> <b>
```

Lines may include comments beginning with `#`.

## Verify

Compile the utilities and smoke test:

```sh
javac -d out $(find cs3500 test -name '*.java')
```

Run the parser against the small demo:

```sh
java -cp out cs3500.animator.util.AnimationReaderSmokeTest smalldemo.txt
```

Expected output:

```text
Parsed 2 shape(s), 10 motion(s), 0 keyframe(s), canvas=(200,70 360x360)
```
