package edu.ucne.login.data.remote

import edu.ucne.login.data.remote.api.UsuarioApi
import edu.ucne.login.data.remote.dto.UsuarioDto
import javax.inject.Inject

class UsuarioRemoteDataSource @Inject constructor(
    private val api: UsuarioApi
) {
    suspend fun fetchUsuarios(): List<UsuarioDto> = api.getUsuarios()
    suspend fun createUsuario(usuario: UsuarioDto): UsuarioDto = api.createUsuario(usuario)
}