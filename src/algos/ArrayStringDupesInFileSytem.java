package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArrayStringDupesInFileSytem {

	/*
	 * Input: ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)",
	 * "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"] Output:
	 * [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt",
	 * "root/c/3.txt"]]
	 */

	// https://leetcode.com/problems/find-duplicate-file-in-system/description/

	public static void main(String[] args) {
		String[] paths = new String[] { 
			"root/a 1.txt(abcd) 2.txt(efgh)", 
			"root/c 3.txt(abcd)", 
			"root/c/d 4.txt(efgh)",
			"root 4.txt(efgh)" 
		};
		System.out.println(new ArrayStringDupesInFileSytem().findDuplicate(paths));
	}

	public List<List<String>> findDuplicate(String[] paths) {
		Map<String, List<String>> fd = new HashMap<String, List<String>>();
		List<List<String>> sol = new ArrayList<>();
		for (String string : paths) {
			String[] raf = string.split(" ");
			for (int i = 1; i < raf.length; i++) {
				int cs = raf[i].indexOf('(');
				int ce = raf[i].lastIndexOf(')');
				String c = raf[i].substring(cs + 1, ce);
				List<String> ps = fd.getOrDefault(c, new ArrayList<String>());
				ps.add(raf[0] + "/" + raf[i].substring(0, cs));
				fd.put(c, ps);
			}
		}
		for (String c : fd.keySet()) {
			if(fd.get(c).size() > 1) {
				sol.add(fd.get(c));
			}
		}
		return sol;
	}
}