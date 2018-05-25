package net.println.kotlin.chapter04.objects;
//用kotlin的object修饰的MusicPlayer对应的java类
public class MusicPlayerJava {
    public static MusicPlayerJava INSTANCE = new MusicPlayerJava();

    private MusicPlayerJava() {}
}
