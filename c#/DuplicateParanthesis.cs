using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class DuplicateParanthesis
    {
        public static void Main(string[] vs)
        {
            Console.WriteLine(IsDuplicateParanthesis(Console.ReadLine()));

            Console.ReadLine();
        }

        public static string IsDuplicateParanthesis(string exp)
        {
            Stack<char> stack = new Stack<char>();
            bool flag = false;
            for (int i = 0; i < exp.Length; i++)
            {
                if (exp[i] != ')')
                {
                    stack.Push(exp[i]);
                    //if (exp[i] == '(') { fla}
                    flag = false;
                }
                else
                {
                    if (flag == true) { return "true"; }
                    while (stack.Peek() != '(')
                    {
                        stack.Pop();
                    }
                    stack.Pop();
                    flag = true;
                }
            }
            return "false";
        }
    }
}