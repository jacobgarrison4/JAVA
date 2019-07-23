package project6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.lang.model.element.Element;

import java.util.Iterator;

public class OccurrenceSet<T> implements Set<T>
{
	public HashMap<T, Integer> map = new HashMap<>();

	@Override
	public boolean add(T e) 
	{
		if (map.containsKey(e))
		{
			int count = map.get(e);
			map.put(e, count + 1);
			return false;
		}
		
		else
		{
			map.put(e, 1);
			return true;
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) 
	{
		HashMap<T, Integer> original = map;
		
		for (T e : c)
			if (map.containsKey(e))
			{
				int count = map.get(e);
				map.put(e, count++);
			}
			
			else
			{
				map.put(e, 1);
			}
		
		if (original == map)
		{
			return false;
		}
		
		else
		{
			return true;
		}
	}
	
	@Override
	public int size() 
	{
		System.out.println(map.size());
		return map.size();
	}
	
	@Override
	public boolean remove(Object o) 
	{
		if (map.containsKey(o))
		{
			map.remove(o);
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean removeAll(Collection<?> c) 
	{
		HashMap<T, Integer> original = map;
		
		for (Object e : c)
			if (map.containsKey(e))
			{
				map.remove(e);
			}
			
		if (original == map)
		{
			return false;
		}
		
		else
		{
			return true;
		}
	}

	@Override
	public boolean isEmpty() 
	{
		System.out.println(map.isEmpty());
		return map.isEmpty();
	}

	@Override
	public boolean contains(Object o) 
	{
		if (map.containsKey(o) == true)
		{
			System.out.println("true");
			return true;
		}
		
		else
		{
			System.out.println("false");
			return false;
		}
	}

	@Override
	public Iterator<T> iterator() 
	{
		List<T> iterator = new LinkedList<T>();
		return iterator.iterator();
	}

	@Override
	public Object[] toArray() 
	{
		Set<Map.Entry<T, Integer>> entrySet = map.entrySet();
		ArrayList<Map.Entry<T, Integer>> entryList = new ArrayList<>(entrySet);
		Collections.sort(entryList,  new Comparator<Map.Entry<T, Integer>>()
				{
			public int compare(Map.Entry<T, Integer> o1, Map.Entry<T, Integer> o2)
			{
				return o1.getValue().compareTo(o2.getValue());
			}
				});
		
		return entryList;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public <T> T[] toArray(T[] a) 
	{
		a = ((Set<T>) map).toArray(a);
		return (T[]) a;
	}

	@Override
	public boolean containsAll(Collection<?> c) 
	{
		for (Object e : c)
			if (map.containsKey(e))
			{
				continue;
			}
			
			else
			{
				System.out.println("false");
				return false;
			}
		
		System.out.println("true");
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) 
	{
		HashMap<T, Integer> original = map;
		Set<T> keys = map.keySet();
		
		for (T e : keys)
			if (!(map.containsKey(e)))
			{
				map.remove(e);
			}
		
		if (original == map)
		{
			System.out.println("false");
			return false;
		}
		
		else
		{
			System.out.println("true");
			return true;
		}
	}

	@Override
	public void clear() 
	{
		map.clear();
	}
	
	public String toString()
	{
		Set<Map.Entry<T, Integer>> entrySet = map.entrySet();
		ArrayList<Map.Entry<T, Integer>> entryList = new ArrayList<>(entrySet);
		Collections.sort(entryList,  new Comparator<Map.Entry<T, Integer>>()
				{
			public int compare(Map.Entry<T, Integer> o1, Map.Entry<T, Integer> o2)
			{
				return o1.getValue().compareTo(o2.getValue());
			}
				});
		
		return entryList.toString();
	}
}