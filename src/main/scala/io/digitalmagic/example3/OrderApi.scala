package io.digitalmagic.example3
import io.digitalmagic.Order.Action
import io.digitalmagic.{OrderProcessor, PremiumOrderValuer, StandardOrderValuer}

/**
  * Created by netknight on 20/06/16.
  */
object OrderApi {

  case class Order(
    security: String,
    value: Double,
    allOrNone: Boolean,
    quantity: Int,
    action: Action,
    limitPrice: Double
  ) extends io.digitalmagic.Order {
    override def getSecurity: String = security
    override def getValue: Double = value
    override def isAllOrNone: Boolean = allOrNone
    override def getQuantity: Int = quantity
    override def getAction: Action = action
    override def getLimitPrice: Double = limitPrice
  }

  object Order {
    private def buildOrder(quantity: Int, action: Action) = new Order("", 0, false, quantity, action, 0)
    def buy(quantity: Int): Order = buildOrder(quantity, Action.BUY)
    def sell(quantity: Int): Order = buildOrder(quantity, Action.SELL)

    implicit class OrderEnchaser(order: Order) {
      def shares_Of(name: String): Order = order.copy(security = name)
      def at_Limit_Price(limitPrice: Double): Order = order.copy(limitPrice = limitPrice)
      def all_Or_None: Order = order.copy(allOrNone = true)
      def value_As(valuer: OrderValuer): Order = order.copy(value = valuer.valueAs(order.quantity, order.limitPrice))
    }
  }

  trait OrderValuer extends io.digitalmagic.OrderValuer
  object Standard extends StandardOrderValuer with OrderValuer
  object Premium extends PremiumOrderValuer with OrderValuer

  def process(order: Order*) = {
    order foreach OrderProcessor.process
  }

}
