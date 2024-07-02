package utils;

public class UnitUtils {

    public static float calculateDamageAfterArmor(float damage, int armor) {
        if (armor == 0) {
            return damage;
        }

        // Each armor point reduces physical damage by 10%
        float reductionFactor = 1 - (armor * 0.1f);

        // Ensure reduction factor doesn't go below 0
        if (reductionFactor < 0) {
            reductionFactor = 0;
        }

        return damage * reductionFactor;
    }
}
