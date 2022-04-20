package com.rest.app;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresidentController {

	private List<President> presidents = new ArrayList<>();
	
	public PresidentController() {
		this.presidents = new ArrayList<>();
		setPresidents();
	}
	
	
	@GetMapping
	public String getEmpty() {
		return "works ...";
	}
	
	@GetMapping("/president/{number}")
	public President getByNumber(@PathVariable("number") String nthPresident) {
		
		int index = Integer.valueOf(nthPresident);
		
		System.out.println("presidents.size() " + presidents.size());
		
		
		if(index > 0 && index <= presidents.size()) {
			return presidents.get(index - 1);
		}
		
		return null;
	}
	
	/**
	 * Returns the list of presidents
	 * @return
	 */
	@GetMapping("/presidents")
	public List<President> getAll() {
		return this.presidents;
	}
	
	/**
	 * Returns the list of presidents who were president after the mentioned year
	 * @param after
	 * @return
	 */
	@GetMapping("/presidents/after/{year}")
	public List<President> getbefore(@PathVariable("year") String after) {
		int afterYear = Integer.valueOf(after);
		List<President> afterList = new ArrayList<>();
		
		presidents.stream()
			.forEach(p -> {
				if(p.getEndYear() >= afterYear) {
					afterList.add(p);
				}
			});
		return afterList;
	}
	
	/**
	 * Returns the list of presidents who were president before the mentioned year
	 * @param before
	 * @return
	 */
	@GetMapping("/presidents/before/{year}")
	public List<President> getAfter(@PathVariable("year") String before) {
		
		int beforeYear = Integer.valueOf(before);
		
		List<President> beforeList = new ArrayList<>();
		
		presidents.stream()
			.forEach(p -> {
				if(p.getStartYear() <= beforeYear) {
					beforeList.add(p);
				}
			});
		return beforeList;
	}
	
	/**
	 * Returns the list of presidents who were president in the mentioned year
	 * @param strYear
	 * @return
	 */
	@GetMapping("/presidents/onyear/{year}")
	public List<President> inYear(@PathVariable("year") String strYear) {
		
		int inYear = Integer.valueOf(strYear);

		
		List<President> inTheYearList = new ArrayList<>();
		
		presidents.stream()
			.forEach(p -> {
				if(inYear >= p.getStartYear() && inYear <= p.getEndYear()) {
						inTheYearList.add(p);
				}
			});
		return inTheYearList;
	}
	
	/**
	 * Returns the list of presidents who was president in the range 
	 * @param strStartYear
	 * @param strEndYear
	 * @return
	 */
	@GetMapping("/presidents/between/{start}/{end}")
	public List<President> getbetween(@PathVariable("start") String strStartYear, @PathVariable("end") String strEndYear) {
		
		int startYear = Integer.valueOf(strStartYear);
		int endYear = Integer.valueOf(strEndYear);
		
		List<President> beetween = new ArrayList<>();
		
		presidents.stream()
			.forEach(p -> {
				if(p.getEndYear() >= startYear && p.getStartYear() <= endYear) {
					beetween.add(p);
				}
			});
		return beetween;
	}
	
	public void setPresidents() {
		presidents.add(new President("George", "Washington", 1789, 1797));
		presidents.add(new President("John", "Adams", 1797, 1801));
		presidents.add(new President("Thomas", "Jefferson", 1801, 1809));
		presidents.add(new President("James", "Madison", 1809, 1817));
		presidents.add(new President("James", "Monroe", 1817, 1825));
		presidents.add(new President("John", "Quincy Adams", 1825, 1829));
		presidents.add(new President("Andrew", "Jackson", 1829, 1837));
		presidents.add(new President("Martin", "Van Buren", 1837, 1841));
		presidents.add(new President("William Henry", "Harrison", 1841, 1841));
		presidents.add(new President("John", "Tyler", 1841, 1845));
		presidents.add(new President("James", "K. Polk", 1845, 1849));
		presidents.add(new President("Zachary", "Taylor", 1849, 1850));
		presidents.add(new President("Millard", "Fillmore", 1850, 1853));
		presidents.add(new President("Franklin", "Pierce", 1853, 1857));
		presidents.add(new President("Buchanan", "Buchanan", 1957, 1961));
		presidents.add(new President("Abraham", "Lincoln", 1861, 1865));	
		presidents.add(new President("Andrew", "Johnson", 1865, 1869));
		presidents.add(new President("Ulysses", "S. Grant", 1869, 1877));
		presidents.add(new President("Rutherford", "B. Hayes", 1877, 1881));
		presidents.add(new President("James", "A. Garfield", 1881, 1881));
		presidents.add(new President("Chester", "A. Arthur", 1881, 1885));
		presidents.add(new President("Grover", "Cleveland", 1885, 1889));
		presidents.add(new President("Benjamin", "Harrison", 1889, 1893));
		presidents.add(new President("Grover", "Cleveland", 1893, 1897));
		presidents.add(new President("William", "McKinley", 1897, 1901));
		presidents.add(new President("Theodore", "Roosevelt", 1901, 1909));
		presidents.add(new President("William", "Howard Taft", 1909, 1913));
		presidents.add(new President("Woodrow", "Wilson", 1913, 1921));
		presidents.add(new President("Warren", "G. Harding", 1921, 1923));
		presidents.add(new President("Calvin", "Coolidge", 1923, 1929));
		presidents.add(new President("Herbert", "Hoover", 1929, 1933));
		presidents.add(new President("Franklin", "D. Roosevelt", 1933, 1845));
		presidents.add(new President("Harry", "S. Truman", 1945, 1953));
		presidents.add(new President("Dwight", "Eisenhower", 1953, 1961));
		presidents.add(new President("John", "F. Kennedy", 1961, 1963));
		presidents.add(new President("Lyndon", "B. Johnson", 1963, 1969));
		presidents.add(new President("Richard", "Nixon", 1969, 1974));
		presidents.add(new President("Gerald", "Ford", 1974, 1977));
		presidents.add(new President("Jimmy", "Carter", 1977, 1981));
		presidents.add(new President("Ronald", "Reagan", 1981, 1989));
		presidents.add(new President("George", "H. W. Bush", 1989, 1993));		
		presidents.add(new President("Bill", "Clinton", 1993, 2001));
		presidents.add(new President("George", "W. Bush", 2001, 2009));
		presidents.add(new President("Barack", "Obama", 2009, 2017));
		presidents.add(new President("Donald", "Trump", 2017, 2021));
		presidents.add(new President("Joe", "Biden", 2021, 2022));
	}
}
