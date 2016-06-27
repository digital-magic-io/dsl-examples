package io.digitalmagic.example5

object MarketSymbols extends Enumeration {
  val IBM, APPLE = Value
}

object Operation extends Enumeration {
  val BUY, SELL = Value
}

object CurrencySymbols extends Enumeration {
  val USD, EUR = Value
}

trait Op {
  import OrderApi._
  def buy(s: Subject) = Intention(Operation.BUY, s)
  def sell(s: Subject) = Intention(Operation.SELL, s)
}

object OrderApi {

  implicit class IntEx(val x: Int) extends AnyVal {
    def shares(y: OfWord) = new ToShareWord(x)
    def EUR = CurrencyWord(x, CurrencySymbols.EUR)
    def USD = CurrencyWord(x, CurrencySymbols.USD)
  }

  implicit class FloatEx(val x: Double) extends AnyVal {
    def EUR = CurrencyWord(x, CurrencySymbols.EUR)
    def USD = CurrencyWord(x, CurrencySymbols.USD)
  }

  case class ToShareWord(amount: Int)
  implicit class ToShareWordEx(val x: ToShareWord) extends AnyVal {
    def APPLE = ShareWord(x.amount, MarketSymbols.APPLE)
    def IBM = ShareWord(x.amount, MarketSymbols.IBM)
  }

  trait Subject
  case class CurrencyWord(amount: Double, symbol: CurrencySymbols.Value) extends Subject {
    override def toString = s"$amount $symbol"
  }
  case class ShareWord(amount: Int, name: MarketSymbols.Value) extends Subject {
    override def toString = s"$amount stock shares of $name"
  }

  case class Intention(op: Operation.Value, sub: Subject) {
    override def toString = s"I want $op $sub"
  }

  implicit class IntentionEx(val i: Intention) extends AnyVal {
    def at(l: LimitWord) = PriceWord(i)
  }

  class OfWord
  val of = new OfWord

  class LimitWord
  val limit = new LimitWord

  case class PriceWord(x: Intention) {
    def price(c: CurrencyWord) = new Order(x, c)
  }

  class Order(intent: Intention, price: CurrencyWord) {
    override def toString = s"$intent for $price"
  }

  def process(order: Order*) = {
    order foreach System.out.println
  }
}
