package startsmart.base.utility;

import startsmart.base.model.datastructure.ReverseSortedLinkedList;
import startsmart.base.model.datastructure.ReverseSortedLinkedSet;
import startsmart.base.model.datastructure.SortedLinkedData;
import startsmart.base.model.datastructure.SortedLinkedList;
import startsmart.base.model.datastructure.SortedLinkedSet;

import java.util.ArrayList;
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
	public static long meanHigh(final Number number1, final Number number2)
	{
		Number start = Objects.requireNonNull(number1);
		Number end = Objects.requireNonNull(number2);
		return  (long) Math.ceil((start.doubleValue() + end.doubleValue())/2.0d);
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

	/**
	 * Returns the greatest common divisor for the given list of numbers.
	 * @param a input list of numbers
	 * @return GCD of the given numbers | null if the given number list is null or empty
	 */
	public static Long gcd(long... a)
	{
		if(a == null || a.length == 0)
			return null;
		Long gcd = a[0]; //GCD[k] = k; GCD of single numbered list say k is k
		for(int i=1; i < a.length; i++)
		{
			if(a[i] == 1 || gcd == 1)
				return 1L; //GCD[x,y,z,1,....n] = 1; GCD of any number list containing 1 is 1 or containing a sublist whose GCD is 1 is also 1
			gcd = gcd(gcd, a[i]);
		}
		return gcd;
	}

	private static Long gcd(long a, long b)
	{
		return b == 0 ? a : gcd(b, a%b);
	}

	public static List<List<Boolean>> generateBooleanTable(int operandCount)
	{
		List<List<Boolean>> result = new ArrayList<List<Boolean>>();
		if(operandCount == 0)
		{
			return null;
		}
		if(operandCount == 1)
		{
			List<Boolean> tresult = new ArrayList<>();
			tresult.add(true);
			tresult.add(false);
			result.add(tresult);
		}
		else
		{
			for(int i = 1; i <= Math.pow(2, operandCount); i++)
			{
				List<Boolean> tresult = generateBooleanTableRow(i, operandCount);
				result.add(tresult);
			}
		}
		return result;
	}


	private static List<Boolean> generateBooleanTableRow(int row, int operandCount)
	{
		List<Boolean> tresult = new ArrayList<>();
		for(int i = 1; i <= operandCount; i++)
		{
			tresult.add(getBooleanTableColumnValue(i, row, operandCount));
		}
		return tresult;
	}

	private static boolean getBooleanTableColumnValue(int col, int row, int operandCount)
	{
		int a = (int) (Math.pow(2, operandCount) / Math.pow(2, col));
		int b = Math.floorDiv(row, a) % 2;
		return b != 0;
	}


	public static long lengthOfProduct(long... numbers){
		double logSum = 0;
		for(Long number : numbers){
			logSum = logSum + Math.log10(number);
		}
		return (long) Math.floor(logSum) + 1L;
	}

	public static long max(long... numbers) {
		Long max = Long.MIN_VALUE;
		for(long number : numbers){
			if(number > max){
				max = number;
			}
		}
		return max;
	}

	public static long min(long... numbers) {
		Long min = Long.MAX_VALUE;
		for(long number : numbers){
			if(number < min){
				min = number;
			}
		}
		return min;
	}


	public static long nthSmallestNumber(int n, Number... numbers){
		boolean sortStraight = (n <= numbers.length/2);
		SortedLinkedData<Long> set = sortStraight ? new SortedLinkedSet<>(n): new ReverseSortedLinkedSet<>((numbers.length - n) + 1);
		return nthSmallestNumber(n, set, numbers);
	}

	public static long nthSmallestNumberWithDuplicate(int n, Number... numbers){
		boolean sortStraight = (n <= numbers.length/2);
		SortedLinkedData<Long> set = sortStraight ? new SortedLinkedList<>(n): new ReverseSortedLinkedList<>((numbers.length - n) + 1);
		return nthSmallestNumber(n, set, numbers);
	}

	private static long nthSmallestNumber(int n, SortedLinkedData<Long> set, Number... numbers){
		if(numbers == null)
			throw new ArithmeticException("Number list cant be null");
		if(n < 1)
			throw new ArithmeticException("n value should be positive");
		if(n > numbers.length)
			throw new ArithmeticException("n value is greater than total numbers");
		for(Number number : numbers){
			set.insert(number.longValue());
		}
		return set.getTailValue();
	}
}
