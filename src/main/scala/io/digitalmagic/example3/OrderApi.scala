package io.digitalmagic.example3
import io.digitalmagic.Order.{Action, Tradeable}
import io.digitalmagic.OrderProcessor
import io.digitalmagic.{Currency, Share}

/**
  * Created by netknight on 20/06/16.
  */
object OrderApi {

  case class Order(
    action: Action,
    quantity: Int,
    tradeable: Tradeable,
    limitPrice: Double,
    all: Boolean
  ) extends io.digitalmagic.Order {
    override def getAction: Action = action
    override def getQuantity: Integer = quantity
    override def getTradeable: Tradeable = tradeable
    override def getLimitPrice: java.lang.Double = limitPrice
    override def isAllOrNone: java.lang.Boolean = all
  }

  def I = Order

  object Order {
    private def buildOrder(quantity: Int, action: Action) = new Order(action, quantity, null, 0.0, false)
    def buy(quantity: Int): Order = buildOrder(quantity, Action.BUY)
    def sell(quantity: Int): Order = buildOrder(quantity, Action.SELL)

    implicit class OrderEnchaser(order: Order) {
      def sharesOf(share: Share): Order = order.copy(tradeable = share)
      def currency(currency: Currency): Order = order.copy(tradeable = currency)
      def atPrice(price: Double): Order = order.copy(limitPrice = price)
      def allOrNone: Order = order.copy(all = true)
    }
  }

  def process(order: Order*) = {
    order foreach OrderProcessor.process
  }

}
