package businesslogic;

import java.util.Iterator;

public interface ExtendedIterator<T> extends Iterator<T> {
	//return	the	actual	element	and	go	to	the	previous
	public T	previous();
	//true	if ther	is	a	previous	element
	public boolean hasPrevious();
	//It	is	placed	in	the	first	element
	public void goFirst();
	// It	is	placed	in	the	last	element
	public void goLast();


	public static void main(String[] args) {
        
        // Cambia esta variable a true o false para probar ambos casos
        boolean isLocal = true;

        BLFacade businessLogic = BLFacadeFactory.createBusinessLogicFactory(isLocal);
        
        ExtendedIterator<String>	i =	businessLogic.getDepartCitiesIterator();
        String c;
        System.out.println("_____________________");
        System.out.println("FROM	LAST	TO	FIRST");
        i.goLast();	//	Go	to	last	element
        while (i.hasPrevious())	{
        c =	i.previous();
        System.out.println(c);
        }
        System.out.println();
        System.out.println("_____________________");
        System.out.println("FROM	FIRST	TO	LAST");
        i.goFirst();	//	Go	to	first	element
        while (i.hasNext())	{
        c =	i.next();
        System.out.println(c);
        }
    }
}



