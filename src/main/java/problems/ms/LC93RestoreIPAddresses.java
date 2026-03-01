package problems.ms;

import java.util.ArrayList;
import java.util.List;

public class LC93RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            return res;
        }
        findIpAddresses(0, 0, s, "", res);
        return res;
    }

    private void findIpAddresses(int index, int parts, String s, String sb, List<String> res) {
        if (index == s.length() && parts == 4) {
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
        if (index == s.length() || parts >= 4) {
            return;
        }
        if (index + 1 <= s.length()) {
            findIpAddresses(index + 1, parts + 1, s, sb + (s.substring(index, index + 1)) + ("."), res);
        }

        if (index + 2 <= s.length() && isValid(s.substring(index, index + 2))) {
            findIpAddresses(index + 2, parts + 1, s, sb + (s.substring(index, index + 2)) + ("."), res);
        }

        if (index + 3 <= s.length() && isValid(s.substring(index, index + 3))) {
            findIpAddresses(index + 3, parts + 1, s, sb + (s.substring(index, index + 3)) + ("."), res);
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num > 255) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC93RestoreIPAddresses obj = new LC93RestoreIPAddresses();
        List<String> strs = obj.restoreIpAddresses("25525511135");
        for (String str : strs) {
            System.out.println(str);
        }
        System.out.println(strs.size());
    }
}
