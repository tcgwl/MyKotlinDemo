package net.println.kotlin.chapter04;

public class PersonJava {
    public void work() {

    }

    public static class MaNongJava extends PersonJava {
        //Override 在Java中可有可无，在kotlin中不可删除
        @Override
        public void work() {
            super.work();
        }
    }
}
