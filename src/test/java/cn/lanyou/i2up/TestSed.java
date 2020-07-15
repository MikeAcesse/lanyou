package cn.lanyou.i2up;

public class TestSed {
    public static void main(String[] args) {
       // String sedString = "cd " + dir + ";sed -e '" + rowNum + optional + "+"\\"+'  " + filename;
        String srcHost="192.20";
        String srcDir="/root/work/test/monitor";
        modifyFileBySed(srcDir, 1, "i", "insert this text in front of the file", "aa_0.txt", srcHost);
        modifyFileBySed(srcDir, 2, "d", "", "aa_0.txt", srcHost);

    }
    public static void modifyFileBySed(String dir, int rowNum, String optional, String content, String filename, String host) {
        String sedString = "cd " + dir + ";sed -e '" + rowNum + optional + "\\"+content+"'  " + filename +"| tee "+filename;
        String sedString2 = "cd " + dir + ";sed -e '" + rowNum + optional + "'  "+ filename + "| tee "+filename;
        System.out.println(sedString);
        System.out.println(sedString2);

    }
}


