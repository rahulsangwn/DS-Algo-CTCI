using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp2
{
    class StringSort
    {
        public static void Main(string[] str)
        {
            //Console.WriteLine(String.Compare("bp", "bpp"));
            int numberOfTestCases = int.Parse(Console.ReadLine());

            List<string> list = new List<string>();
            for (int i = 0; i < numberOfTestCases; i++)
            {
                list.Add(Console.ReadLine());
            }
            list = SortList(list);

            foreach (string item in list) { Console.WriteLine(item); }

            Console.ReadLine();
        }
        
        public static List<string> SortList(List<string> list)
        {
            list.Sort(MyComparer);
            return list;
        }

        public static int MyComparer(string str1, string str2)
        {
            int compareValue = String.Compare(str1, str2);
            if (compareValue == 0) { return 0; }
            else if (compareValue == -1)
            {
                if (str1.Length > str2.Length)
                {
                    if (String.Equals(str2, str1.Substring(0, str2.Length))) { return 1; }
                    else { return -1; }
                } else
                {
                    if (String.Equals(str1, str2.Substring(0, str1.Length))) { return 1; }
                    else { return -1; }
                }
                
            }
            else
            {
                if (str1.Length > str2.Length)
                {
                    if (String.Equals(str2, str1.Substring(0, str2.Length))) { return -1; }
                    else { return 1; }
                }
                else
                {
                    if (String.Equals(str1, str2.Substring(0, str1.Length))) { return -1; }
                    else { return 1; }
                }
            }
        }
    }
}