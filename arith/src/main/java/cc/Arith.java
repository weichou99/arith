package cc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 精確的數值運算。
 *
 */
public class Arith {

	// 默認除法運算精度
	private static final int DEF_DIV_SCALE = 10;

	private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;

	// 這個類不能實例化
	private Arith() {
	}

	/**
	 * num1, num2轉成BigDecimal後num1+num2。<br>
	 * num1, num2都是null的時候就回傳null。<br>
	 * num1, num2其中一個為null就當做0來運算。<br>
	 *
	 * @param num1
	 * @param num2
	 * @return
	 *
	 * @author carter
	 */
	public static BigDecimal addNumber(Number num1, Number num2) {
		if (num1 == null && num2 == null) {
			return null;
		}
		BigDecimal b1 = getBigDecimal(num1);
		BigDecimal b2 = getBigDecimal(num2);
		return b1.add(b2);
	}

	/**
	 * num1, num2轉成BigDecimal後num1-num2。<br>
	 * num1, num2都是null的時候就回傳null。<br>
	 * num1, num2其中一個為null就當做0來運算。<br>
	 *
	 * @param num1
	 * @param num2
	 * @return
	 *
	 * @author carter
	 */
	public static BigDecimal subNumber(Number num1, Number num2) {
		if (num1 == null && num2 == null) {
			return null;
		}
		BigDecimal b1 = getBigDecimal(num1);
		BigDecimal b2 = getBigDecimal(num2);
		return b1.subtract(b2);
	}

	/**
	 * num1, num2轉成BigDecimal後num1*num2。<br>
	 * num1, num2任一個是null的時候就回傳null。<br>
	 *
	 * @param num1
	 * @param num2
	 * @return
	 *
	 * @author carter
	 */
	public static BigDecimal mulNumber(Number num1, Number num2) {
		if (num1 == null || num2 == null) {
			return null;
		}
		BigDecimal b1 = getBigDecimal(num1);
		BigDecimal b2 = getBigDecimal(num2);
		return b1.multiply(b2);
	}

	/**
	 * num1, num2轉成BigDecimal後num1/num2。<br>
	 * num1或num2是null的時候就回傳null。<br>
	 * 注意 n/0 跟 0/0 的狀況。<br>
	 * DEF_DIV_SCALE = 10; DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;<br>
	 *
	 * @param num1
	 * @param num2
	 * @param scale
	 *            取到小數第幾位
	 * @return
	 *
	 * @author carter
	 */
	public static BigDecimal divNumber(Number num1, Number num2) {
		return divNumber(num1, num2, DEF_DIV_SCALE, DEFAULT_ROUNDING_MODE);
	}

	/**
	 * num1, num2轉成BigDecimal後num1/num2。<br>
	 * num1或num2是null的時候就回傳null。<br>
	 * 注意 n/0 跟 0/0 的狀況。<br>
	 * DEFAULT_ROUNDING_MODE = RoundingMode.HALF_UP;<br>
	 *
	 * @param num1
	 * @param num2
	 * @param scale
	 *            取到小數第幾位
	 * @return
	 *
	 * @author carter
	 */
	public static BigDecimal divNumber(Number num1, Number num2, int scale) {
		return divNumber(num1, num2, scale, DEFAULT_ROUNDING_MODE);
	}

	/**
	 * num1, num2轉成BigDecimal後num1/num2。<br>
	 * num1或num2是null的時候就回傳null。<br>
	 * 注意 n/0 跟 0/0 的狀況。<br>
	 *
	 * @param num1
	 * @param num2
	 * @param scale
	 *            取到小數第幾位
	 * @param roundingMode
	 *            四捨五入的方式
	 * @return
	 *
	 * @author carter
	 */
	public static BigDecimal divNumber(Number num1, Number num2, int scale, RoundingMode roundingMode) {
		if (num1 == null || num2 == null) {
			return null;
		}
		BigDecimal b1 = getBigDecimal(num1);
		BigDecimal b2 = getBigDecimal(num2);
		BigDecimal result = b1.divide(b2, scale, roundingMode);
		return result;
	}

	/**
	 * 加總nums。 當nums是空的時候，回傳null。<br>
	 *
	 * @param nums
	 * @return
	 * @author Carter
	 */
	public static BigDecimal sumNumber(Number... nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		BigDecimal total = BigDecimal.ZERO;
		for (Number value : nums) {
			if (value != null) {
				total = Arith.addNumber(total, value);
			}
		}
		return total;
	}

	/**
	 * 加總numList。 當numList是空的時候，回傳null。<br>
	 *
	 * @param numList
	 * @return
	 * @author Carter
	 */
	public static BigDecimal sumNumber(List<? extends Number> numList) {
		if (numList == null || numList.isEmpty()) {
			return null;
		}
		BigDecimal total = BigDecimal.ZERO;
		for (Number value : numList) {
			if (value != null) {
				total = Arith.addNumber(total, value);
			}
		}
		return total;
	}

	/**
	 * 對num1做round。<br>
	 * 用divide(num1, BigDecimal.ONE, scale, DEFAULT_ROUNDING_MODE)方式。<br>
	 * num1是null時，就回傳null。<br>
	 *
	 * @param num1
	 * @param scale
	 * @return
	 */
	public static BigDecimal roundNumber(Number num1, int scale) {
		return divNumber(num1, BigDecimal.ONE, scale, DEFAULT_ROUNDING_MODE);
	}

	/**
	 * 對num1做round。<br>
	 * 用divide(num1, BigDecimal.ONE, scale, roundingMode)方式。<br>
	 * num1是null時，就回傳null。<br>
	 *
	 * @param num1
	 * @param scale
	 * @param roundingMode
	 * @return
	 */
	public static BigDecimal roundNumber(Number num1, int scale, RoundingMode roundingMode) {
		if (num1 == null) {
			return null;
		}
		return divNumber(num1, BigDecimal.ONE, scale, roundingMode);
	}

	/**
	 * 把num轉成BigDecimal。<br>
	 * num是null時，就回傳BigDecimal.ZERO。<br>
	 *
	 * @param num
	 * @return
	 *
	 * @author carter
	 */
	private static BigDecimal getBigDecimal(Number num) {
		if (num == null) {
			num = BigDecimal.ZERO;
		}
		if (num instanceof BigDecimal) {
			return (BigDecimal) num;
		}
		return new BigDecimal(num.toString());
	}

}