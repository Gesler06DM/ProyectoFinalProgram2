package umg.edu.gt.progra2.presupuesto.datos

import umg.edu.gt.progra2.presupuesto.modelo.Movimiento

interface GastoRepository {
    fun guardar(movimiento: Movimiento)
    fun listar(): List<Movimiento>
}