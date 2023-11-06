package parking

fun main() {
//    Creating a parking lot with 20 parking spots
    val parkingLot = List(20) { "0" }.toMutableList()

    while (true) {
        val input = readln().split(" ")

//        function to park a car in the first available spot or notify user if full
        fun park() {
            val firstAvailableSpot = parkingLot.indexOf("0")
            if (firstAvailableSpot != -1) {
                parkingLot[firstAvailableSpot] = input[1] // This stores the license plate number of the car
                println("${input[2]} car parked in spot ${firstAvailableSpot + 1}.")
            } else {
                println("Sorry, the parking lot is full.")
            }
        }

//        function to remove a car or notify user if the spot is empty
        fun leave() {
            val spotToRemoveCar = input[1].toInt() - 1
            if (parkingLot[spotToRemoveCar] != "0") {
                parkingLot[spotToRemoveCar] = "0" //This clears the parking spot
                println("Spot ${input[1]} is free.")
            } else {
                println("There is no car in spot ${input[1]}.")
            }
        }

        when (input[0]) {
            "exit" -> break
            "park" -> park()
            "leave" -> leave()
        }
    }
}




