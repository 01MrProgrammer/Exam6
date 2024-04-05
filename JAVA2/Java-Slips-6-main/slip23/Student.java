import java.util.*;

public class Student
{
    public static void main(String[] args)
    {
        List<String> L1 = new ArrayList<>();

        for(String arg: args)
        {
            L1.add(arg);
        }

        //Display Student Names
        System.out.println("Student Names in List are: ");
        Iterator<String> iterator = L1.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        //Display Students in Reverse Order
        System.out.println("Student Names in Reverse Order: ");
        ListIterator<String> listIterator= L1.listIterator(L1.size());
        while(listIterator.hasPrevious())
        {
            System.out.println(listIterator.previous());
        }
    }
}
