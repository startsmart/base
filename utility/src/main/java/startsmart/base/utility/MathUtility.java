package startsmart.base.utility;

import java.util.List;
import java.util.Objects;

/**
 * Utility that serves basic mathematical functions
 */
public class MathUtility 
{
	/**
	 * Calculates mean of the given two numbers and return the {@link Math#ceil(double)} value of the mean
	 * @param number1 - a non null number value | if null {@link NullPointerException} will be thrown
	 * @param number2 - a non null number value | if null {@link NullPointerException} will be thrown
	 * @return ceil value of the mean of the given two numbers
	 */
	public static int meanHigh(final Number number1, final Number number2)
	{
		Number start = Objects.requireNonNull(number1);
		Number end = Objects.requireNonNull(number2);
		return  (int) Math.ceil((start.doubleValue() + end.doubleValue())/2.0d);
	}

	/**
	 * Calculates mean of the given two numbers and return the {@link Math#round(double)} value of the mean
	 * @param number1 - a non null number value | if null {@link NullPointerException} will be thrown
	 * @param number2 - a non null number value | if null {@link NullPointerException} will be thrown
	 * @return round value of the mean of the given two numbers
	 */
	public static int meanRound(final Number number1, final Number number2)
	{
		Number startT = Objects.requireNonNull(number1);
		Number endT = Objects.requireNonNull(number2);
		return  (int) Math.round((startT.doubleValue() + endT.doubleValue())/2.0d);
	}

	/**
	 * Calculates mean of the given two numbers and return the {@link Math#floor(double)} value of the mean
	 * @param number1 - a non null number value | if null {@link NullPointerException} will be thrown
	 * @param number2 - a non null number value | if null {@link NullPointerException} will be thrown
	 * @return floor value of the mean of the given two numbers
	 */
	public static int meanLow(final Number number1, final Number number2)
	{
		Number startT = Objects.requireNonNull(number1);
		Number endT = Objects.requireNonNull(number2);
		return  (int) Math.floor((startT.doubleValue() + endT.doubleValue())/2.0d);
	}

	/**
	 * Calculates the mean value of the given numbers
	 * @param numbers - numbers for which mean has to be calculated
	 * @return mean of the given numbers | 0.0D if the numbers is empty
	 */
	public static double mean(double... numbers)
	{
		if(numbers == null || numbers.length < 1)
		{
			return 0.0D;
		}
		return sum(numbers) / numbers.length;
	}

	/**
	 * Calculates the mean value of the given list of numbers. Ignore <code>null</code> values in the list
	 * @param numbers - numbers for which mean has to be calculated
	 * @return mean of the given numbers | <code>null</code> if the list is <code>null</code>
	 * or empty or all values in list is <code>null</code>
	 */
	public static Double mean(List<Double> numbers)
	{
		return mean(numbers, true);
	}

	/**
	 * Calculates the mean value of the given list of numbers. Ignore <code>null</code> values in the list
	 * if ignoreNull is set to true other wise <code>null</code> will be returned
	 * @param numbers - numbers for which mean has to be calculated
	 * @param ignoreNull - if true any <code>null</code> value in the list is ignored | false will return
	 *                     <code>null</code> if any value in the list is <code>null</code>
	 * @return mean of the given numbers | <code>null</code> if the list is <code>null</code>
	 * or empty or all values in list is <code>null</code>
	 */
	public static Double mean(List<Double> numbers, boolean ignoreNull)
	{
		if(numbers == null || numbers.size() < 1)
		{
			return null;
		}
		Double sum = sum(numbers, ignoreNull);
		return sum == null ? null : sum / numbers.size();
	}

	/**
	 * Calculates the sum value of the given list of numbers. Ignore <code>null</code> values in the list
	 * @param numbers - numbers for which sum has to be calculated
	 * @return sum of the given numbers | <code>null</code> if the list is <code>null</code>
	 * or empty or all values in list is <code>null</code>
	 */
	public static Double sum(List<Double> numbers)
	{
		return sum(numbers, true);
	}

	/**
	 * Calculates the sum value of the given list of numbers. Ignore <code>null</code> values in the list
	 * if ignoreNull is set to true other wise <code>null</code> will be returned
	 * @param numbers - numbers for which sum has to be calculated
	 * @param ignoreNull - if true any <code>null</code> value in the list is ignored | false will return
	 *                     <code>null</code> if any value in the list is <code>null</code>
	 * @return sum of the given numbers | <code>null</code> if the list is <code>null</code>
	 * or empty or all values in list is <code>null</code>
	 */
	public static Double sum(List<Double> numbers, boolean ignoreNull)
	{
		if(numbers == null || numbers.size() < 1)
		{
			return null;
		}
		Double sum = null;
		for(Double number : numbers)
		{
			if(number == null)
			{
				if(ignoreNull)
				{
					continue;
				}
				else
				{
					return null;
				}
			}
			sum = (sum == null ? 0.0D : sum) + number;
		}
		return sum;
	}

	/**
	 * Calculates the sum value of the given numbers
	 * @param numbers - numbers for which mean has to be calculated
	 * @return mean of the given numbers | 0.0D if the numbers is empty
	 */
	public static double sum(double... numbers)
	{
		if(numbers == null || numbers.length < 1)
		{
			return 0.0D;
		}
		double sum = 0.0D;
		for(double number : numbers)
		{
			sum = sum + number;
		}
		return sum;
	}
}
