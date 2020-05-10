package me.deepak.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * https://leetcode.com/problems/reorder-data-in-log-files/
*/
public class ReorderDataInLogFiles {
	
	public String[] reorderLogFiles(String[] logs) {
		if (logs == null || logs.length == 0) {
			return new String[0];
		}

		List<String> wordLogs = new ArrayList<>();
		List<String> numberLogs = new ArrayList<>();
		for (String log : logs) {
			char c = log.charAt(log.length() - 1);
			if ('0' <= c && c <= '9') {
				numberLogs.add(log);
			} else {
				wordLogs.add(log);
			}
		}
		wordLogs.sort(new Comparator<String>() {
			public int compare(String s1, String s2) {
				String[] splittedS1 = s1.split(" ", 2);
				String[] splittedS2 = s2.split(" ", 2);
				String id1 = splittedS1[0];
				String log1 = splittedS1[1];
				String id2 = splittedS2[0];
				String log2 = splittedS2[1];
				int result = log1.compareToIgnoreCase(log2);
				if (result == 0) {
					return id1.compareTo(id2);
				}
				return result;
			}
		});
		wordLogs.addAll(numberLogs);
		return wordLogs.toArray(new String[0]);
	}
}
