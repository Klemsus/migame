package org.mie.game.generators;

/**
 *
 * @author Cerber
 */
public class PerlinNoise {
  
  private static float noise(int x) {
    x = (x << 13) ^ x;
    return (1.0f - ((x * (x * x * 15731 + 789221) + 1376312589) & 0x7fffffff) / 1073741824.0f);
  }

  private static double smoothedNoise(int x) {
    return noise(x) / 2 + noise(x - 1) / 4 + noise(x + 1) / 4;
  }

  private static double cosineInterpolate(double a, double b, double x) {
    double ft = x * 3.1415927;
    double f = (1 - Math.cos(ft)) * .5;
    return a * (1 - f) + b * f;
  }

  private static double interpolatedNoise(double x) {
    int intX = (int) x;
    double fractionalX = x - intX;
    double v1 = smoothedNoise(intX);
    double v2 = smoothedNoise(intX + 1);
    return cosineInterpolate(v1, v2, fractionalX);
  }

  public static double of(double x) {
    double total = 0;
    double p = 0.25;
    int n = 3 - 1;

    for (int i = 0; i < n; i++) {
      double frequency = Math.pow(2, i);
      double amplitude = Math.pow(p, i);

      total = total + interpolatedNoise(x * frequency) * amplitude;
    }
    return total;
  }
}
