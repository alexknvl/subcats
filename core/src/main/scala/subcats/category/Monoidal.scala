package subcats.category

trait Monoidal[C[_, _], F[_, _]] extends Associative[C, F] {
  type Id

  def idl[A, B]: F[Id, A] C1 A
  def idr[A, B]: F[A, Id] C1 A
  def coidl[A, B]: A C1 F[A, Id]
  def coidr[A, B]: A C1 F[Id, A]
}
object Monoidal {
  trait Aux[F[_, _], C1[_, _], C0[_], I] extends Monoidal[C1, F] with Associative.Aux[C1, C0, F] {
    type Id = I
  }
}
