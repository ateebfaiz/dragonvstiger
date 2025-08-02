package xb;

class c extends b {
    public static int a(double d10) {
        if (Double.isNaN(d10)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d10 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        } else {
            if (d10 < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d10);
        }
    }
}
