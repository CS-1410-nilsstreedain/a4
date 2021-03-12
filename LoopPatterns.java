package a4;

import java.awt.Color;
import java.util.Arrays;

/**
 * 
 * This java class has multiple methods that deal with optimized loops and
 * images. Javadocs for each method explain what it does, the main method tests
 * each one of the methods by taking multiple inputs and showing what the given
 * outputs for each input would be.
 * 
 * @author Nils Streedain
 */

public class LoopPatterns {
	public static void main(String[] args) {
		String[] stringArray = { "cat", "dog", "apple", "fish" };
		int[] intArray1 = { 1, 2, 3, 4 };
		int[] intArray2 = { 0, 1, 2, 3 };
		int[] intArray3 = { 1, 2, 3, 1000 };
		double[] doubleArray1 = { 0.0, 1.0, 2.0, 3.0 };
		double[] doubleArray2 = { 0.0, 2.0, 1.0, 3.0 };
		Picture picture = new Picture("arches.jpg");
		picture.show();

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for lowestAlphabetically()\n");
		System.out.println("lowestAlphabetically(['cat', 'dog', 'apple', 'fish']) results in: "
				+ lowestAlphabetically(stringArray));

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for findSmallestNumberInTwoArrays()\n");
		System.out.println("findSmallestNumberInTwoArrays([1, 2, 3, 4], [0, 1, 2, 3]) results in: "
				+ findSmallestNumberInTwoArrays(intArray1, intArray2));

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for curveScores()\n");
		System.out.println("curveScores([1, 2, 3, 4]) results in: " + Arrays.toString(curveScores(intArray1)));
		System.out.println("curveScores([1, 2, 3, 100]) results in: " + Arrays.toString(curveScores(intArray3)));

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for findSmallestPositiveNumber()\n");
		System.out.println("findSmallestPositiveNumber([0.0, 1.0, 2.0, 3.0]) results in: "
				+ findSmallestPositiveNumber(doubleArray1));
		System.out.println("findSmallestPositiveNumber([0.0, 2.0, 1.0, 3.0]) results in: "
				+ findSmallestPositiveNumber(doubleArray2));

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for containsThisColor()\n");

		Color color = new Color(76, 151, 232);
		System.out.println(
				"containsThisColor('arches.jpg', (76, 151, 232)) results in: " + containsThisColor(picture, color));

		color = new Color(100, 100, 100);
		System.out.println(
				"containsThisColor('arches.jpg', (100, 100, 100)) results in: " + containsThisColor(picture, color));

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for makeGrey()\n");
		System.out.println("makeGrey('arches.jpg') results in: (check newly opened windows)");
		System.out.println("Pixel before: " + picture.get(10, 10) + " Pixel after: " + makeGrey(picture).get(10, 10));
		makeGrey(picture).show();

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for makeNegative()\n");
		System.out.println("makeNegative('arches.jpg') results in: (check newly opened windows for image)");
		System.out
				.println("Pixel before: " + picture.get(10, 10) + " Pixel after: " + makeNegative(picture).get(10, 10));
		makeNegative(picture).show();

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for safeColor()\n");
		System.out.println("safeColor(-1000) results in: " + safeColor(-1000));
		System.out.println("safeColor(0) results in: " + safeColor(0));
		System.out.println("safeColor(100) results in: " + safeColor(100));
		System.out.println("safeColor(1000) results in: " + safeColor(1000));

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");

		System.out.println("Test for makeBrighter()\n");
		System.out.println("makeBrighter('arches.jpg') results in: (check newly opened windows for image)");
		System.out
				.println("Pixel before: " + picture.get(10, 10) + " Pixel after: " + makeBrighter(picture).get(10, 10));
		makeBrighter(picture).show();

		System.out.println(
				"\n----------------------------------------------------------------------------------------------------\n");
	}

	/**
	 * Takes each string of the input array and finds the lowest alphabetically
	 * using compareTo().
	 * 
	 * EX: lowestAlphabetically(["cat", "dog", "apple", "fish"]) would output the
	 * string: "apple"
	 * 
	 * 
	 * @param array The array to have all strings compared for the lowest.
	 * 
	 * @return currentLowest A string containing the lowest alphabetical string.
	 */
	public static String lowestAlphabetically(String[] array) {
		String currentLowest = array[0];
		for (String element : array) {
			if (element.compareTo(currentLowest) < 0) {
				currentLowest = element;
			}
		}
		return currentLowest;
	}

	/**
	 * Takes two arrays and finds the smallest integer between the two and returns
	 * it.
	 * 
	 * EX: findSmallestNumberInTwoArrays([1, 2, 3, 4], [0, 1, 2, 3]) would output
	 * the integer: 0
	 * 
	 * 
	 * @param array1 The first array to have all integers compared for the smallest.
	 * @param array2 The second array to have all integers compared for the
	 *               smallest.
	 * 
	 * @return smallest An integer containing the lowest integer from the two
	 *         arrays.
	 */
	public static int findSmallestNumberInTwoArrays(int[] array1, int[] array2) {
		int smallest = array1[0];
		for (int i : array1) {
			if (smallest > i) {
				smallest = i;
			}
		}
		for (int i : array2) {
			if (smallest > i) {
				smallest = i;
			}
		}
		return smallest;
	}

	/**
	 * Takes an array and changes the last number to 100, then adds or subtracts the
	 * amount that was added to, or subtracted from, the last number, to the rest of
	 * the numbers in the array.
	 * 
	 * EX: curveScores([1, 2, 3, 4]) would output the array: (97, 98, 99, 100)
	 * 
	 * 
	 * @param array The array to be modified and have its integers scaled to 100.
	 * 
	 * @return returnArray The modified array with integers scaled to 100.
	 */
	public static int[] curveScores(int[] array) {
		int[] returnArray = new int[array.length];
		int differenceHundred = 100 - array[array.length - 1];

		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = array[i] + differenceHundred;
		}
		return returnArray;
	}

	/**
	 * Takes an array and returns the smallest positive double in the array.
	 * 
	 * EX: findSmallestPositiveNumber([0.0, 1.0, 2.0, 3.0]) would output the double:
	 * 1.0
	 * 
	 * 
	 * @param array The array to be evaluated for the the smallest positive double.
	 * 
	 * @return lowestPositive A double with the smallest double from the array.
	 */
	public static double findSmallestPositiveNumber(double[] array) {
		double lowestPositive = 0;
		for (double d : array) {
			if (d > 0) {
				lowestPositive = d;
				break;
			}
		}
		for (double d : array) {
			if (d > 0 && d < lowestPositive) {
				lowestPositive = d;
			}
		}
		return lowestPositive;
	}

	/**
	 * Takes an image and color and returns a boolean determining if the picture
	 * contains a pixel with the color.
	 * 
	 * EX: containsThisColor('arches.jpg', (100, 100, 100)) would output the
	 * boolean: false
	 * 
	 * 
	 * @param picture The input picture to be evaluated.
	 * @param color   The input color to evaluate the picture.
	 * 
	 * @return A boolean stating weather the picture contains a picture with the
	 *         color.
	 */
	public static boolean containsThisColor(Picture picture, Color color) {
		for (int y = 0; y < picture.height(); y++) {
			for (int x = 0; x < picture.width(); x++) {
				if (picture.get(x, y).equals(color)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Takes an image and makes it grey scale by averaging the red, green, and blue
	 * together.
	 * 
	 * EX: makeGrey('arches.jpg') results in a grey scale image of the input image
	 * 
	 * 
	 * @param picture The input picture to be grey scaled.
	 * 
	 * @return newPicture A new image that has been grey scaled.
	 */
	public static Picture makeGrey(Picture picture) {
		Picture newPicture = new Picture(picture);
		for (int y = 0; y < picture.height(); y++) {
			for (int x = 0; x < picture.width(); x++) {
				Color color = picture.get(x, y);
				int greyValue = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
				Color greyPixel = new Color(greyValue, greyValue, greyValue);
				newPicture.set(x, y, greyPixel);
			}
		}
		return newPicture;
	}

	/**
	 * Takes an image and makes it negative scale by subtracting the red, green, and
	 * blue values from 255.
	 * 
	 * EX: makeNegative('arches.jpg') results in a negative scale image of the input
	 * image
	 * 
	 * 
	 * @param picture The input picture to be negative scaled.
	 * 
	 * @return newPicture A new image that has been negative scaled.
	 */
	public static Picture makeNegative(Picture picture) {
		Picture newPicture = new Picture(picture);
		for (int y = 0; y < picture.height(); y++) {
			for (int x = 0; x < picture.width(); x++) {
				Color color = picture.get(x, y);
				int newRedValue = 255 - color.getRed();
				int newGreenValue = 255 - color.getGreen();
				int newBlueValue = 255 - color.getBlue();
				Color greyPixel = new Color(newRedValue, newGreenValue, newBlueValue);
				newPicture.set(x, y, greyPixel);
			}
		}
		return newPicture;
	}

	/**
	 * Takes an input value and makes sure it's between 0 and 255
	 * 
	 * EX: safeColor(100) results in: 100
	 * 
	 * 
	 * @param value The value to be determined if between 0 and 255
	 * 
	 * @return value The value between 0 and 255.
	 */
	public static int safeColor(int value) {
		if (value < 0) {
			value = 0;
		} else if (value > 255) {
			value = 255;
		}
		return value;
	}

	/**
	 * Takes an image and makes it twice as contrasted by doubling the RGB values
	 * 
	 * EX: makeBrighter('arches.jpg') results in an image with double the contrast
	 * of the input image
	 * 
	 * 
	 * @param picture The input picture to have contrast doubled.
	 * 
	 * @return newPicture A new image that has had contrast doubled.
	 */
	public static Picture makeBrighter(Picture picture) {
		Picture newPicture = new Picture(picture);
		for (int y = 0; y < picture.height(); y++) {
			for (int x = 0; x < picture.width(); x++) {
				Color color = picture.get(x, y);
				int newRedValue = safeColor(color.getRed() * 2);
				int newGreenValue = safeColor(color.getGreen() * 2);
				int newBlueValue = safeColor(color.getBlue() * 2);
				Color greyPixel = new Color(newRedValue, newGreenValue, newBlueValue);
				newPicture.set(x, y, greyPixel);
			}
		}
		return newPicture;
	}
}
