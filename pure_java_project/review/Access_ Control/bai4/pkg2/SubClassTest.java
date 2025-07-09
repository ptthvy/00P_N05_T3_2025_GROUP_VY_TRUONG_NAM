package pkg2;

import pkg1.Base;

public class SubClassTest extends Base {
    public static void main(String[] args) {
        SubClassTest obj = new SubClassTest();
        obj.show();  // được vì đang gọi từ subclass
    }
}
