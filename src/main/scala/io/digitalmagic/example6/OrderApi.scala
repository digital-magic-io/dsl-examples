package io.digitalmagic.example6

import io.digitalmagic.example5.{CurrencySymbols, MarketSymbols, Operation}

object OrderApi {

  class ToWord {
    def buy(amount: Int): ActionWord = ActionWord(Operation.BUY, amount)
    def sell(amount: Int): ActionWord = ActionWord(Operation.SELL, amount)
  }
  val to = new ToWord

  case class ActionWord(op: Operation.Value, amount: Int) {
    def EUR(a: AtWord) = PriceWord(op, Currency(amount, CurrencySymbols.EUR))
    def USD(a: AtWord) = PriceWord(op, Currency(amount, CurrencySymbols.USD))
    def shares(of: OfWord) = ShareWord(this)
  }

  class OfWord
  val of = new OfWord

  class AtWord
  val at = new AtWord

  case class ShareWord(action: ActionWord) {
    def APPLE(a: AtWord) = PriceWord(action.op, Shares(action.amount, MarketSymbols.APPLE))
    def IBM(a: AtWord) = PriceWord(action.op, Shares(action.amount, MarketSymbols.IBM))
  }

  case class PriceWord(op: Operation.Value, securities: Securities) {
    def price(amount: Int) = LastWord(op, securities, amount)
  }

  case class LastWord(op: Operation.Value, securities: Securities, amount: Int) {
    def USD : Order = Order(op, securities, Currency(amount, CurrencySymbols.USD))
    def EUR : Order = Order(op, securities, Currency(amount, CurrencySymbols.EUR))
  }

  trait Securities
  case class Currency(amount: Int, symbol: CurrencySymbols.Value) extends Securities
  case class Shares(amount: Int, symbol: MarketSymbols.Value) extends Securities

  case class Order(op: Operation.Value, subject: Securities, price: Currency)

  def process(order: Order*) = {
    order foreach System.out.println
  }
}
