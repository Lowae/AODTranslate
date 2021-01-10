import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

fun main(){
    println("“Are you certain? I know nothing about it.”".replace("“", "").replace("”", ""))
}
private fun parse(){
    //1.创建一个DocumentBuilderFactory对象
    val builderFactory = DocumentBuilderFactory.newInstance()
    //2.创建一个DocumentBuilder
    val documentBuilder = builderFactory.newDocumentBuilder()
    val files = File("english")
    println(files.list()?.size)
    files.listFiles()?.forEach {
        println(it.path)
        //通过DocumentBuilder对象的parse方法加载books.xml到当前项目下
        val parse = documentBuilder.parse(it.path)
        //获取节点(book)的集合
        val npcTexts = parse.getElementsByTagName("npc_text")
        val texts = parse.getElementsByTagName("text")
        println(npcTexts.length)
        for ( i in 0 until npcTexts.length){
            println(npcTexts.item(i).textContent.replace("\n", "").replace("”", ""))
        }

        for ( i in 0 until texts.length){
            println(texts.item(i).textContent.replace("\n", "").replace("”", ""))
        }
    }
}