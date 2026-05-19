package cs3500.animator.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A tiny executable smoke test for the animation parser utilities.
 */
public final class AnimationReaderSmokeTest {
  /**
   * Reads an animation file and prints a compact parse summary.
   *
   * @param args optional path to an animation text file
   * @throws IOException if the file cannot be read
   */
  public static void main(String[] args) throws IOException {
    Path input = args.length == 0 ? Paths.get("smalldemo.txt") : Paths.get(args[0]);
    Summary summary = AnimationReader.parseFile(
            Files.newBufferedReader(input), new SummaryBuilder());
    System.out.println(summary);
  }

  private static final class Summary {
    private int canvasX;
    private int canvasY;
    private int canvasWidth;
    private int canvasHeight;
    private int motionCount;
    private int keyframeCount;
    private final Map<String, String> shapes = new LinkedHashMap<>();

    @Override
    public String toString() {
      return String.format(
              "Parsed %d shape(s), %d motion(s), %d keyframe(s), canvas=(%d,%d %dx%d)",
              shapes.size(), motionCount, keyframeCount,
              canvasX, canvasY, canvasWidth, canvasHeight);
    }
  }

  private static final class SummaryBuilder implements AnimationBuilder<Summary> {
    private final Summary summary = new Summary();

    @Override
    public Summary build() {
      return summary;
    }

    @Override
    public AnimationBuilder<Summary> setBounds(int x, int y, int width, int height) {
      summary.canvasX = x;
      summary.canvasY = y;
      summary.canvasWidth = width;
      summary.canvasHeight = height;
      return this;
    }

    @Override
    public AnimationBuilder<Summary> declareShape(String name, String type) {
      summary.shapes.put(name, type);
      return this;
    }

    @Override
    public AnimationBuilder<Summary> addMotion(String name,
                                               int t1, int x1, int y1,
                                               int w1, int h1, int r1, int g1, int b1,
                                               int t2, int x2, int y2,
                                               int w2, int h2, int r2, int g2, int b2) {
      summary.motionCount += 1;
      return this;
    }

    @Override
    public AnimationBuilder<Summary> addKeyframe(String name,
                                                 int t, int x, int y,
                                                 int w, int h, int r, int g, int b) {
      summary.keyframeCount += 1;
      return this;
    }
  }
}
