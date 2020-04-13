using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class RainWaterTapping
    {
        public static void Main(string[] vs)
        {
            int numberOfTestCases = int.Parse(Console.ReadLine());
            int[] results = new int[numberOfTestCases];
            for (int i = 0; i < numberOfTestCases; i++)
            {
                int numberOfElements = int.Parse(Console.ReadLine());
                
                
                int[] array = new int[numberOfElements];
                string[] str = Console.ReadLine().Split(' ');

                //List<int> str = strr.Split(' ').Select(int.Parse).ToList();

                for (int j = 0; j < numberOfElements; j++)
                {
                    //array[j] = int.Parse(str[j]);
                    try
                    {
                        //numVal = Convert.ToInt32(input);
                        array[j] = int.Parse(str[j]);
                    }
                    catch (FormatException e)
                    {
                        Console.WriteLine("Format Exception:" + e.Source);
                    }
                    catch (IndexOutOfRangeException e)
                    {
                        Console.WriteLine("Out of range:" + e.Source);
                    }
                }

                //foreach (var item in str) { Console.WriteLine(item); }
                results[i] = CountTrapping(array, numberOfElements);
            }
            
            for (int i = 0; i < numberOfTestCases; i++)
            {
                Console.WriteLine(results[i]);
            }
            Console.ReadLine();
        }

        public static int CountTrapping(int[] array, int numberOfElements)
        {
            numberOfElements = array.Length;
            int[] leftMaximum = new int[numberOfElements];
            int[] rightMaximum = new int[numberOfElements];
            int count = 0;

            int max = array[0];
            for (int i = 0; i < numberOfElements; i++)
            {
                if (array[i] > max)
                {
                    max = array[i];
                }
                leftMaximum[i] = max;
            }

            max = array[numberOfElements-1];
            for (int i = numberOfElements-1; i >= 0; i--)
            {
                if (array[i] > max)
                {
                    max = array[i];
                }
                rightMaximum[i] = max;
            }

            for (int i = 0; i < numberOfElements; i++)
            {
                int ground = Math.Min(leftMaximum[i], rightMaximum[i]);
                count += ground - array[i];
            }

            return count;
        }
    }
}