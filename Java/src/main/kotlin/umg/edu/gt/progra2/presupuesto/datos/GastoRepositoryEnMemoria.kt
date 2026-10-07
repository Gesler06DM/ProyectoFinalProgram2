package umg.edu.gt.progra2.presupuesto.datos

import umg.edu.gt.progra2.presupuesto.modelo.Movimiento

class GastoRepositoryEnMemoria : GastoRepository {

    private val movimientos = mutableListOf<Movimiento>()

    override fun guardar(movimiento: Movimiento) {
        movimientos.add(movimiento)
    }

    override fun listar(): List<Movimiento> {
        return movimientos.toList()
    }
}