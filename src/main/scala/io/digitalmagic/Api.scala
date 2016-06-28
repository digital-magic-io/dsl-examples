package io.digitalmagic

import io.digitalmagic.Order.{Action, Tradeable}

object Api {

  sealed trait Share extends Tradeable
  case object Apple extends Share
  case object IBM extends Share

  sealed trait Currency extends Tradeable {
    def toJava: io.digitalmagic.Order.Currency
  }
  case object USD extends Currency {
    def toJava = io.digitalmagic.Order.Currency.USD
  }
  case object EUR extends Currency {
    def toJava = io.digitalmagic.Order.Currency.EUR
  }

  case class TradeOffer(quantity: Int, tradeable: Tradeable)
  case class PriceLimit(quantity: Double, currency: Currency)

  case class Order(
    action: Action,
    quantity: Int,
    tradeable: Tradeable,
    limitPrice: Double,
    currency: Currency,
    all: Boolean
  ) extends io.digitalmagic.Order {
    override def getAction: Action = action
    override def getQuantity: Integer = quantity
    override def getTradeable: Tradeable = tradeable
    override def getLimitPrice: java.lang.Double = limitPrice
    override def getPriceCurrency: io.digitalmagic.Order.Currency = currency.toJava
  }

  def process(order: Order*) = {
    order foreach OrderProcessor.process
  }
}
