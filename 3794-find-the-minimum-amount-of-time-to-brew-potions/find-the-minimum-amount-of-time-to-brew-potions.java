class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[] endTime = new long[n];

        endTime[0] = 0 + 1L * skill[0] * mana[0];
        for (int i = 1; i < n; i++) {
            endTime[i] = endTime[i - 1] + 1L * skill[i] * mana[0];
        }

        // Process remaining potions
        for (int p = 1; p < m; p++) {
            long l = endTime[0];
            long h = endTime[n - 1];

            // Binary search to decide the start time
            while (l <= h) {
                long mid = l + (h - l) / 2;

                boolean isValid = true;
                long startTime = mid + 1L * skill[0] * mana[p];

                for (int i = 1; i < n; i++) {
                    if (startTime < endTime[i]) {
                        isValid = false;
                        break;
                    }
                    startTime += 1L * skill[i] * mana[p];
                }

                if (isValid) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            
            endTime[0] = l + 1L * skill[0] * mana[p];
            for (int i = 1; i < n; i++) {
                endTime[i] = endTime[i - 1] + 1L * skill[i] * mana[p];
            }
        }

        return endTime[n - 1];
    }

}