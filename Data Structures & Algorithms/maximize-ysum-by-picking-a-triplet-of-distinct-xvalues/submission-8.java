class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        List<int[]> best = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            best.add(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
        }

        for (int idx = 0; idx < x.length; idx++) {
            int xi = x[idx], yi = y[idx];
            boolean updated = false;
            for (int i = 0; i < 3; i++) {
                if (best.get(i)[0] == xi) {
                    if (yi > best.get(i)[1]) {
                        best.get(i)[1] = yi;
                        best.sort((a, b) -> Integer.compare(b[1], a[1]));
                    }
                    updated = true;
                    break;
                }
            }
            if (updated) continue;
            if (yi > best.get(0)[1]) {
                best.add(0, new int[]{xi, yi});
                best.remove(3);
            } else if (yi > best.get(1)[1]) {
                best.add(1, new int[]{xi, yi});
                best.remove(3);
            } else if (yi > best.get(2)[1]) {
                best.get(2)[1] = yi;
                best.get(2)[0] = xi;
            }
        }

        if (best.get(2)[1] == Integer.MIN_VALUE) {
            return -1;
        }

        return best.get(0)[1] + best.get(1)[1] + best.get(2)[1];
    }
}