import java.util.concurrent.TimeUnit
import java.util.Queue
import java.util.LinkedList



open class Board (var board_num : Int,
                  var length : Int,
                  var width : Int,
                  var height : Int,
                  var color : String?)
{
    fun customizeDimensions(args: Array<Int?>){
        print("Enter Length: ")
        length = Integer.valueOf(readLine())
        print("Enter width: ")
        width = Integer.valueOf(readLine())
        print("Enter heigth: ")
        height = Integer.valueOf(readLine())
    }
    fun customizeColor(args: String){
        print("Enter Color: ")
        color = readLine()
    }

    override fun toString(): String {
        return "\nBoard_num = $board_num, Length = $length, Width = $width, Height = $height, Color = $color"
    }


}
open class Order(val order_id : Int,
                 var buyer_name : String?,
                 var quantity : Int,
                 var color : String?,
                 val amount : Int,
                 var produced : Boolean=false,
                 var fulfilled : Boolean=false,
                 var dealer_received : Boolean=false,
                 var dealer_assembled : Boolean=false,
                 var checklist : MutableList<Board>) {

    override fun toString(): String {
        return "\n_______Order_Info_______\n" +
                "Order_ID = $order_id \n" +
                "Buyer_Name = $buyer_name\n" +
                "Quantity = $quantity\n" +
                "Color = $color\n" +
                "Total_Amount = $$amount\n" +
                "Produced = $produced\n" +
                "Fulfilled = $fulfilled \n" +
                "Dealer_Received = $dealer_received \n"+
                "Dealer_Assembled = $dealer_assembled" +
                "\n______________________Checklist______________________\n" +
                "$checklist"
    }
}


open class Factory(val factory_id : Int = (100000..999999).random())
{

    fun production() : Order {
        val p_list = mutableListOf<Board>()
        print("Enter your name: ")
        val buyer_name = readLine()
        print("How many sheets? : ")
        val quantity = Integer.valueOf(readLine())
        print("Enter color: ")
        val color = readLine()
        val rand_id = (1000000..9999999).random()
        val amount = quantity * 13
        val order = Order(rand_id, buyer_name, quantity, color, amount,
            produced = false, fulfilled = false,
            dealer_received = false, dealer_assembled = false,
            p_list)

        println("")
        println("Order is being created and produced...")

        val p_loading = listOf<String>(".", ".", ".")
        for (i in 0..p_loading.lastIndex){
            try {
                TimeUnit.SECONDS.sleep(1)
            }
            catch (e: InterruptedException){
                e.printStackTrace()
            }
            println(p_loading[i])
        }

        for (i in 1..order.quantity){
            val board = Board(i,8, 4, 1, order.color)
            p_list.add(board)
            println("Board_ID: " + p_list[i-1].board_num + " - created")
            TimeUnit.MILLISECONDS.sleep(500)
        }
        order.produced=true
        println(order)

        println("")
        println("Order is now being fulfilled...")
        val f_loading = listOf<String>(".", ".", ".")
        for (i in 0..f_loading.lastIndex){
            try {
                TimeUnit.SECONDS.sleep(1)
            }
            catch (e: InterruptedException){
                e.printStackTrace()
            }
            println(f_loading[i])
        }

        val f_list = mutableListOf<Board>()
        for (i in 0..order.checklist.lastIndex){
            f_list.add(order.checklist[i])
            println("Board_ID: " + f_list[i].board_num + " - fulfilled")
            TimeUnit.MILLISECONDS.sleep(200)
        }
        order.checklist = f_list
        order.fulfilled=true
        println(order)
        println("____________________________Factory_Summary______________________________")
        println("Factory_ID: $factory_id has produced ${f_list.count()} boards and fulfilled Order_ID: ${order.order_id}")
        return order
    }


}
open class Dealer(val dealer_id : Int, val f_list: MutableList<Board>){
    fun receiver(f_list : MutableList<Board>){
        var i = 0
        do{
            f_list.remove(f_list[i])
            i++
        }
        while (f_list.count()>1)

        println("Dealer_ID: $dealer_id - has received and sold $i boards from the order.")

    }

}

fun main(){
//    val board = Board(1, 12, 12, 1, "black")
//    println(board)
//    val order = Order(1, "Sully", 50, "black", 250, true, true)
//    println(order)
    val factory = Factory()
    factory.production()

}