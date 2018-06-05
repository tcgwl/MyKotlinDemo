package net.println.kotlin.network.gson

data class Singer(val id:Int, val name:String, val songs:List<Song>) {
    data class Song(val id:Int, val name:String)
}