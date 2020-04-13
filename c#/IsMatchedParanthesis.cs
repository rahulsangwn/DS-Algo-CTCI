using System;
using System.Collections.Generic;
class Test
{
	public static void Main(string[] args)
        {
            char[] array = Console.ReadLine().ToCharArray();

            Console.WriteLine(IsMatchedParanthesis(array));

            Console.ReadLine();
        }

        
        public static string IsMatchedParanthesis(char[] array)
        {
            Stack<char> stack = new Stack<char>();
            for (int i = 0; i < array.Length; i++)
            {
                if (array[i] == '(') { stack.Push('('); }
                else if (array[i] == ')' && stack.Count != 0) { stack.Pop(); }
                else { return "No"; }
            }

            if(stack.Count == 0) { return "Yes"; }
            else { return "No"; }
        }
}