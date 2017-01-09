package subcats.category

import cats.Trivial
import simulacrum.typeclass

@typeclass trait Groupoid[->[_, _]] extends Category[->] {
  def flip[A, B](f: A -> B): B -> A
}
object Groupoid {
  trait Aux[C1[_, _], C0[_]] extends Groupoid[C1] with Category.Aux[C1, C0]
  trait AuxT[C1[_, _]] extends Aux[C1, Trivial.P1]
}