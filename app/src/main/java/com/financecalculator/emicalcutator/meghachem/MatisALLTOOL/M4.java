package com.financecalculator.emicalcutator.meghachem.MatisALLTOOL;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class M4 {
    public static double e(double d10, int i10) {
        if (i10 >= 0) {
            return new BigDecimal(d10).setScale(i10, RoundingMode.HALF_UP).doubleValue();
        }
        throw new IllegalArgumentException();
    }

    public Double a(String str, String str2) {
        return Double.valueOf((Double.parseDouble(str) / 100.0d) * Double.parseDouble(str2));
    }

    public Double b(String str, String str2) {
        return Double.valueOf((Double.parseDouble(str) * 100.0d) / (Double.parseDouble(str2) + 100.0d));
    }

    public Double c(String str, String str2) {
        return Double.valueOf(Double.parseDouble(str) + a(str, str2).doubleValue());
    }

    public Double d(String str, String str2) {
        return Double.valueOf(Double.parseDouble(str) - b(str, str2).doubleValue());
    }
}
