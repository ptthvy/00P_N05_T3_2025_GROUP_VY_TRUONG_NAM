package pkg2;

import pkg1.Base;

public class OtherPackageTest {
    public static void main(String[] args) {
        Base base = new Base();
        //  bị lỗi:không được phép gọi vì khác package và không kế thừa//
    }
}
