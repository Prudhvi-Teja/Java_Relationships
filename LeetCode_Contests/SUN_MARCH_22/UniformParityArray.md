class Solution {
    /*
     * PROBLEM SUMMARY:
     * ----------------
     * Given nums1[], construct nums2[] where ALL elements are odd OR all even.
     * For each index i, either:
     *   - nums2[i] = nums1[i]             (keep as-is)
     *   - nums2[i] = nums1[i] - nums1[j]  (subtract, and result must be >= 1)
     *
     * PARITY RULES TO REMEMBER:
     * --------------------------
     *   odd  - odd  = even
     *   even - even = even
     *   even - odd  = odd   ← key for all-odd strategy
     *   odd  - even = odd
     *
     * CORE INSIGHT:
     * -------------
     * All-Even  → only possible if NO odd numbers exist (oddCount == 0)
     *             because the smallest odd has no smaller odd to subtract from
     *
     * All-Odd   → possible if:
     *             1. All are already odd (oddCount == n), OR
     *             2. Every EVEN number > minOdd
     *                (so each even can subtract minOdd → even - odd = odd, and >= 1)
     */

    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        // -------------------------------------------------------
        // STEP 1: Count odds and find the minimum odd number
        // -------------------------------------------------------
        // Why minOdd?
        // For all-odd strategy, each even number needs to subtract
        // an odd number smaller than itself (to keep result >= 1).
        // The best candidate is always the SMALLEST odd available.
        // -------------------------------------------------------
        int oddCount = 0;
        int minOdd = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 != 0) {       // num is odd
                oddCount++;
                minOdd = Math.min(minOdd, num);  // track smallest odd
            }
        }

        // -------------------------------------------------------
        // STEP 2: Trivial cases — already uniform, no work needed
        // -------------------------------------------------------
        // oddCount == 0 → all elements even  → nums2 = nums1 → all-even ✅
        // oddCount == n → all elements odd   → nums2 = nums1 → all-odd  ✅
        // -------------------------------------------------------
        if (oddCount == 0 || oddCount == n)
            return true;

        // -------------------------------------------------------
        // STEP 3: Mixed array — try All-Odd strategy
        // -------------------------------------------------------
        // We already know all-even is IMPOSSIBLE here because:
        //   - There's at least 1 odd number
        //   - The smallest odd has no smaller odd to subtract
        //   - So it can never become even via subtraction
        //
        // All-Odd is possible ONLY IF:
        //   every even number > minOdd
        //   → even - minOdd >= 1  ✅  (result is positive)
        //   → even - odd = odd    ✅  (parity becomes odd)
        //
        // If ANY even <= minOdd, it cannot subtract any odd
        // to get a result >= 1, so all-odd fails too → return false
        // -------------------------------------------------------
        if (oddCount >= 1) {
            for (int num : nums1) {
                if (num % 2 == 0 && num <= minOdd) {
                    // This even number cannot subtract any odd (would give <= 0)
                    // All-Odd strategy FAILS
                    return false;
                }
            }
        }

        // -------------------------------------------------------
        // STEP 4: All evens are > minOdd → All-Odd strategy works
        // -------------------------------------------------------
        // Every even can do: even - minOdd = odd (>= 1) ✅
        // Every odd can stay as-is                       ✅
        // -------------------------------------------------------
        return true;
    }
}
```

---

### Dry Run on Key Examples
```
nums1 = [1, 2, 4]
─────────────────────────────
STEP 1: oddCount=1, minOdd=1
STEP 2: 1 != 0, 1 != 3 → skip
STEP 3: check evens:
        num=2 → even, 2 > 1 ✅
        num=4 → even, 4 > 1 ✅
STEP 4: return true ✅

nums2 = [1, 2-1=1, 4-1=3] = [1, 1, 3] → all odd ✅

────────────────────────────────────────
nums1 = [3, 2, 4]
─────────────────────────────
STEP 1: oddCount=1, minOdd=3
STEP 2: 1 != 0, 1 != 3 → skip
STEP 3: check evens:
        num=2 → even, 2 <= 3 ❌ → return false

No way to make 2 odd with subtraction (2-3 = -1, violates >= 1) ✅

────────────────────────────────────────
nums1 = [2, 4, 6]
─────────────────────────────
STEP 1: oddCount=0, minOdd=MAX
STEP 2: oddCount==0 → return true ✅

nums2 = [2, 4, 6] → all even already ✅
```

---

### Complexity
```
Time  → O(n)  — two linear passes at most
Space → O(1)  — only oddCount and minOdd variables
```

---

### Cheat Sheet (Pin this in GitHub README)
```
PARITY CHEATSHEET
──────────────────────────────────────────
same parity subtraction  → even result
diff parity subtraction  → odd result
result must be >= 1      → num1[i] > num1[j]

ALL-EVEN → only if oddCount == 0
ALL-ODD  → oddCount == n
        OR every even > minOdd
──────────────────────────────────────────