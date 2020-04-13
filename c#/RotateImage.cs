using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class RotateImage
    {
        public static void Main(string[] args)
        {
            int dimension = int.Parse(Console.ReadLine());
            int[,] matrix = new int[dimension, dimension];
            for (int i = 0; i < dimension; i++)
            {
                //int[] array = Array.ConvertAll(Console.ReadLine().Split(' '), int.Parse);
                //Array.Reverse(array);
				String input = Console.ReadLine();
				String[] inputs = input.Split(' ');
                for (int j = 0; j < dimension; j++)
                {
                    //matrix[i, j] = array[j];
					matrix[i,j]=Convert.ToInt32(inputs[j]);
                }
            }
            Rotate(matrix, dimension);
            //for (int i = 0; i < dimension; i++)
            //{
            //    for (int j = 0; j < dimension; j++)
            //    {
            //        Console.Write(matrix[i, j] + " ");
            //    }
            //    Console.Write(Environment.NewLine);
            //}
            //Console.ReadLine();
        }

        public static void Rotate(int[,] matrix, int dimension)
        {
            //for (int i = 0; i < dimension; i++)
            //{
            //    for (int j = i; j < dimension; j++)
            //    {
            //        int temp = matrix[i, j];
            //        matrix[i, j] = matrix[j, i];
            //        matrix[j, i] = temp;
            //    }
            //}

            for (int i = dimension-1; i >= 0; i--)
            {
                for (int j = 0; j < dimension; j++) { Console.Write(matrix[j, i] + " "); }
                Console.WriteLine();
            }

        }
    }
}