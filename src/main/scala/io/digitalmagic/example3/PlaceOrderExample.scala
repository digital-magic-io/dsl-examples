package io.digitalmagic.example3

import OrderApi._

object PlaceOrderExample {

  def main(args:Array[String]) = {

    process (
      Order buy 100 shares_Of "Apple" at_Limit_Price 12.54 value_As Standard all_Or_None,
      Order sell 50 shares_Of "IBM" at_Limit_Price 11.45 value_As Premium
    )

  }

}
